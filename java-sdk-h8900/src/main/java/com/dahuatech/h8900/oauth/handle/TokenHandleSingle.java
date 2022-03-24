package com.dahuatech.h8900.oauth.handle;

import com.dahuatech.h8900.oauth.constant.H8900OauthConstant;
import com.dahuatech.h8900.oauth.http.H8900Token;
import com.dahuatech.h8900.oauth.http.H8900HttpRequest;
import com.dahuatech.h8900.oauth.profile.GrantType;
import com.dahuatech.h8900.oauth.profile.H8900Profile;
import com.dahuatech.hutool.core.thread.NamedThreadFactory;
import com.dahuatech.hutool.core.util.StrUtil;
import com.dahuatech.hutool.http.HttpRequest;
import com.dahuatech.hutool.http.HttpResponse;
import com.dahuatech.hutool.http.HttpStatus;
import com.dahuatech.hutool.http.Method;
import com.dahuatech.hutool.json.JSONObject;
import com.dahuatech.hutool.json.JSONUtil;
import com.dahuatech.hutool.log.Log;
import com.dahuatech.hutool.log.LogFactory;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.exception.ServerException;
import com.dahuatech.icc.util.BeanUtil;
import com.dahuatech.icc.util.SignUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;

/**
 * 单例，获取access_token,刷新access_token，登录状态保活
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class TokenHandleSingle {
    private static final Log logger = LogFactory.get();

    /**
     * access_token 首次获取状态
     */
    private static final AtomicBoolean TOKEN_INITED = new AtomicBoolean(Boolean.FALSE);
    /**
     * token刷新间隔 30s
     */
    private static final long FRESH_TOKEN_INTERVAL = 30 * 1000;
    /**
     * 线程刷新token和保活
     */
    private final ScheduledExecutorService REFRESH_TOKEN_SCHEDULED =
        newSingleThreadScheduledExecutor(new NamedThreadFactory("Icc-Refresh-Token", true));
    /**
     * 密码和客户端认证存储Map
     */
    private final Map<String, H8900Token> tokenMap = new ConcurrentHashMap<>();

    private final Boolean ipmsInstall = Boolean.FALSE;

    public Map<String, H8900Token> getTokenMap() {
        return tokenMap;
    }

    /**
     * 定时任务刷新token
     */
    private TokenHandleSingle() {
        REFRESH_TOKEN_SCHEDULED.scheduleWithFixedDelay(new Runnable() {
            @Override public void run() {
                try {
                    refreshTokenAndKeepAlive();
                } catch (Throwable t) { // Defensive fault tolerance
                    logger.error("Unexpected error occur at token refresh, cause: " + t.getMessage(), t);
                }
            }
        }, FRESH_TOKEN_INTERVAL, FRESH_TOKEN_INTERVAL, TimeUnit.MILLISECONDS);
    }

    public static synchronized TokenHandleSingle getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public synchronized H8900Token refreshToken(GrantType grantType) {

        H8900Token token = null;
        try {
            switch (grantType) {
                case password:
                    token = password();
                    break;
                default:
            }
        } catch (ClientException e) {
            logger.error("get token failure");
        }
        /** 设置已首次加载，线程可以开始刷新或保活token */
        if (!TOKEN_INITED.get() && token != null) {
            TOKEN_INITED.set(Boolean.TRUE);
        }
        return token;
    }

    /**
     * 密码认证获取token
     *
     * @return IccTokenResponse.IccToken
     * @throws ClientException 客户端异常
     * @throws ServerException 服务端异常
     */
    private H8900Token password() throws ClientException, ServerException {
        H8900HttpRequest pubRequest = new H8900HttpRequest(
            H8900Profile.HTTP_PROTOCOL + H8900Profile.host + H8900OauthConstant.OAUTH_URL_PUBLIC_KEY_POST, Method.POST);
        Map<String, Object> map = new HashMap<>();
        map.put("loginName", H8900Profile.username);
        pubRequest.body(JSONUtil.toJsonStr(map));
        String pubBody = pubRequest.execute();
        JSONObject pubKey = JSONUtil.parseObj(pubBody);
        if (pubKey == null || (pubKey != null && !pubKey.containsKey("publicKey"))) {
            logger.error("get public key faiure [{}]", H8900OauthConstant.OAUTH_URL_PUBLIC_KEY_POST);
            throw new ServerException("get public key faiure");
        }

        Map<String, Object> pass = new HashMap<>();
        pass.put("loginName", H8900Profile.username);
        pass.put("loginPass", SignUtil.encryptRSA(H8900Profile.password, pubKey.getStr("publicKey")));
        H8900HttpRequest pr = new H8900HttpRequest(
            H8900Profile.HTTP_PROTOCOL + H8900Profile.host + H8900OauthConstant.OAUTH_URL_PWD_AUTH_POST, Method.POST,
            JSONUtil.toJsonStr(pass));
        String prBody = pr.execute();
        H8900Token token = BeanUtil.toBean(prBody, H8900Token.class);
        if (token == null || !"true".equals(token.getSuccess())) {
            logger.error(" h8900 auth failure [{}] reason [{}]", H8900OauthConstant.OAUTH_URL_PWD_AUTH_POST,
                token == null ? "" : token.getErrMsg());
            throw new ClientException(
                "h8900 [password] username=[" + H8900Profile.username + "],password=[" + H8900Profile.password
                    + "] get token failure");
        }
        /** 设置存活时间ttl,其中 expires_in 单位是秒 */
        token.setTtl(System.currentTimeMillis() + (30 * 1000));
        tokenMap.put(H8900Profile.host, token);
        refreshIpmsAccessToken();
        return token;
    }

    private void refreshIpmsAccessToken() {
        HttpRequest ipmsRequest =
            HttpRequest.get(H8900Profile.HTTPS_PROTOCOL + H8900Profile.host + H8900OauthConstant.IPMS_TOKEN_GET);
        try {
            HttpResponse result = ipmsRequest.execute();
            if (result.getStatus() == HttpStatus.HTTP_OK) {
                JSONObject rs = JSONUtil.parseObj(result.body());
                if ("true".equals(rs.getStr("success"))) {
                    String accessToken = rs.getJSONObject("data").getStr("accessToken");
                    H8900Token token = tokenMap.get(H8900Profile.host);
                    token.setIpmsAccessToken(accessToken);
                    tokenMap.put(H8900Profile.host, token);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 从缓存获取token
     *
     * @return H8900Token
     */
    public H8900Token getTokenCache() {
        return tokenMap.get(H8900Profile.host);
    }

    /**
     * 刷新token
     */
    public H8900Token refreshToken() {
        try {
            return password();
        } catch (Exception e) {
            logger.error("fresh token error {}", e);
        }
        return null;
    }

    private void refreshTokenAndKeepAlive() {
        if (TOKEN_INITED.get() && tokenMap.size() > 0) {
            for (Map.Entry<String, H8900Token> entry : tokenMap.entrySet()) {
                H8900Token token = entry.getValue();
                Long currentTime = System.currentTimeMillis();
                refreshIpmsAccessToken();
                /** 如果时间还剩120s，则刷新token */
                if (token.getTtl() - currentTime <= 120 * 1000) {
                    token = refreshToken();
                    if (token != null) {
                        tokenMap.put(entry.getKey(), token);
                        logger.debug("refresh token success, [{}],token=[{}]", entry.getKey(), token);
                    }
                }
            }
        }
    }

    private String enGrantKeyName(String grantType) {
        return grantType + StrUtil.COLON + H8900Profile.host;
    }

    private GrantType deGrantType(String grantKeyName) {
        return GrantType.valueOf(grantKeyName.substring(0, grantKeyName.indexOf(StrUtil.COLON)));
    }

    private static class SingletonHolder {
        private static final TokenHandleSingle INSTANCE = new TokenHandleSingle();
    }
}
