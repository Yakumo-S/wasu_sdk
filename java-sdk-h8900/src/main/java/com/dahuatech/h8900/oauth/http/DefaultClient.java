package com.dahuatech.h8900.oauth.http;

import com.dahuatech.h8900.oauth.handle.TokenHandleSingle;
import com.dahuatech.h8900.oauth.profile.H8900Profile;
import com.dahuatech.h8900.oauth.unmarshaller.JsonUnmashaller;
import com.dahuatech.h8900.oauth.unmarshaller.Unmarshaller;
import com.dahuatech.hutool.core.util.CharsetUtil;
import com.dahuatech.hutool.core.util.StrUtil;
import com.dahuatech.hutool.http.HttpResponse;
import com.dahuatech.hutool.http.HttpUtil;
import com.dahuatech.hutool.json.JSONUtil;
import com.dahuatech.hutool.log.Log;
import com.dahuatech.hutool.log.LogFactory;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.exception.ServerException;

/**
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class DefaultClient extends AbstractIClient {
    private static final Log logger = LogFactory.get();

    private TokenHandleSingle tokenHandleSingle;
    private Unmarshaller unmarshaller;

    public DefaultClient() throws ClientException {
        H8900Profile.getInstance().init();
        tokenHandleSingle = TokenHandleSingle.getInstance();
        unmarshaller = new JsonUnmashaller();
    }

    /**
     * 客户端认证
     *
     * @param host     服务地址
     * @param username 客户端ID
     * @param password 客户端秘钥
     * @throws ClientException 客户端异常
     */
    public DefaultClient(String host, String username, String password) throws ClientException {
        init(host, username, password);
    }

    private void init(String host, String username, String password) {
        // 当前已初始化，且host有变更
        if (H8900Profile.inited && !H8900Profile.host.equals(host)) {
            // 清空刷新tokenMap
            TokenHandleSingle.getInstance().getTokenMap().clear();
        }
        H8900Profile.host = host;
        H8900Profile.password = password;
        H8900Profile.username = username;
        H8900Profile.inited = Boolean.FALSE;
        H8900Profile.getInstance().init();
        tokenHandleSingle = TokenHandleSingle.getInstance();
        unmarshaller = new JsonUnmashaller();
    }

    @Override public String doAction(H8900HttpRequest request) throws ClientException, ServerException {
        H8900HttpRequest iccHttpRequest = signRequest(request);
        HttpResponse httpResponse = iccHttpRequest.executeResponse();
        String httpResult = httpResponse.body();
        if (logger.isDebugEnabled()) {
            logger.debug("requestUrl=[{}],method=[{}],params=[{}],result=[{}]", request.getUrl(), request.getMethod(),
                StrUtil.isBlank(request.getBody()) ? request.getForm() : request.getBody(), httpResult);
        }
        return httpResult;
    }

    @Override public <T extends H8900Response> T doAction(H8900HttpRequest request, Class<T> tClass)
        throws ClientException, ServerException {
        H8900HttpRequest iccHttpRequest = signRequest(request);
        HttpResponse httpResult = iccHttpRequest.executeResponse();
        String result = httpResult.body();
        if (logger.isDebugEnabled()) {
            logger.debug("requestUrl=[{}],method=[{}],params=[{}],result=[{}]", request.getUrl(), request.getMethod(),
                StrUtil.isBlank(request.getBody()) ? request.getForm() : request.getBody(), result);
        }
        T t = unmarshal(tClass, result);
        /** 返回原字符串,回填result字段 */
        t.setResult(result);
        return t;
    }

    @Override public synchronized H8900Token getAccessToken() {
        /** false 不续缓存的生存时间 */
        H8900Token token = tokenHandleSingle.getTokenCache();
        if (token != null) {
            return token;
        }
        token = tokenHandleSingle.refreshToken();

        return token;
    }

    @Override H8900HttpRequest signRequest(H8900HttpRequest request) {

        if (request.isNeedAuth()) {
            H8900Token token = getAccessToken();
            request.setUrl(HttpUtil.urlWithForm(request.getUrl(), token.getParam(), CharsetUtil.CHARSET_UTF_8, false));
            request.header("token", token.getToken());
            request.header("accessToken", token.getIpmsAccessToken());
            //            request.form("userId",token.getId());
            //            request.form("userName",token.getLoginName());
            //            request.form("token",token.getToken());
        }

        /**
         * bodyParameters优先级大于body
         *
         * <p>1、从request.body(""),json字符串
         *
         * <p>2、request.bodyParameters，map类型
         */
        if (request.getBodyParameters().size() > 0 && StrUtil.isBlank(request.getBody())) {
            request.body(JSONUtil.toJsonStr(request.getBodyParameters()));
        }

        return request;
    }

    @Override public <T extends H8900Response> T unmarshal(Class<T> clasz, String content) throws ClientException {
        return unmarshaller.unmarshal(clasz, content);
    }
}
