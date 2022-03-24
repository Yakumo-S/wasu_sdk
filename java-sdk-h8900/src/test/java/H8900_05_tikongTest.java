import com.dahuatech.h8900.oauth.http.DefaultClient;
import com.dahuatech.h8900.oauth.http.IClient;
import com.dahuatech.h8900.oauth.model.v202010.GeneralRequest;
import com.dahuatech.h8900.oauth.model.v202010.GeneralResponse;
import com.dahuatech.hutool.http.Method;
import com.dahuatech.hutool.json.JSONUtil;
import com.dahuatech.icc.exception.ClientException;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 主要针对DSS-H8900-SDK-20200111版本(v3.1.4)\02-接口文档\05-梯控子系统接口文档
 * <p>
 * 仅展示部分接口的调用，其他雷同
 * <p>
 * url参数也可以传全路径
 * <p>
 * SDK已经封装token的保活和获取
 *
 * @since 2021-05-19
 */
public class H8900_05_tikongTest {

    private static String host = "10.35.80.140";
    private static String username = "system";
    private static String password = "dahua2020";

    /**
     * 1.2.4 查询梯控列表
     *
     * @throws ClientException
     */
    @Test public void h8900_05_124_ecs_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);

        GeneralRequest request = new GeneralRequest("/CardSolution/card/ecs/elevator", Method.GET);
        String response = client.doAction(request);
        System.out.println(response);
    }

    /**
     * 1.3.1 查询开门计划
     *
     * @throws ClientException
     */
    @Test public void h8900_05_131_timeQuantum_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);

        GeneralRequest request = new GeneralRequest("/CardSolution/card/accessControl/timeQuantum/1/list", Method.POST);
        String response = client.doAction(request);
        System.out.println(response);
    }

    /**
     * 1.3.2 查询梯控列表
     *
     * @throws ClientException
     */
    @Test public void h8900_05_132_elevatorDataList_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);

        GeneralRequest request = new GeneralRequest("/CardSolution/configGuide/elevatorDataList", Method.POST);
        GeneralResponse response = client.doAction(request, request.getResponseClass());
        Assert.assertTrue(response.isSuccess());
    }

    /**
     * 1.4.1 分页查询按人授权列表
     *
     * @throws ClientException
     */
    @Test public void h8900_05_141_doorAuthority_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);
        GeneralRequest request =
            new GeneralRequest("/CardSolution/card/accessControl/doorAuthority/bycondition/combined", Method.POST);
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", 1);
        map.put("pageSize", 10);
        map.put("deptIds", new String[] {"1"});
        request.body(JSONUtil.toJsonStr(map));
        GeneralResponse response = client.doAction(request, request.getResponseClass());
        Assert.assertTrue(response.isSuccess());
    }

    /**
     * 1.7.1 分页查询梯控授权任务
     *
     * @throws ClientException
     */
    @Test public void h8900_05_171_doorAuthority_getAcsCardSyncList() throws ClientException {
        IClient client = new DefaultClient(host, username, password);

        GeneralRequest request =
            new GeneralRequest("/CardSolution/card/accessControl/doorAuthority/getAcsCardSyncList", Method.POST);
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", 1);
        map.put("pageSize", 10);
        request.body(JSONUtil.toJsonStr(map));
        GeneralResponse response = client.doAction(request, request.getResponseClass());
        Assert.assertTrue(response.isSuccess());
    }

    /**
     * 1.8.1 分页查询梯控人脸授权任务
     *
     * @throws ClientException
     */
    @Test public void h8900_05_181_doorAuthority_getAcsFaceSyncList() throws ClientException {
        IClient client = new DefaultClient(host, username, password);

        GeneralRequest request =
            new GeneralRequest("/CardSolution/card/accessControl/doorAuthority/getAcsFaceSyncList", Method.POST);
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", 1);
        map.put("pageSize", 10);
        request.body(JSONUtil.toJsonStr(map));
        GeneralResponse response = client.doAction(request, request.getResponseClass());
        Assert.assertTrue(response.isSuccess());
    }

}
