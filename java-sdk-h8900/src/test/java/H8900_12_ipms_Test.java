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
 * 主要针对DSS-H8900-SDK-20200111版本(v3.1.4)\02-接口文档\12-停车子系统接口文档
 * <p>
 * 仅展示部分接口的调用，其他雷同
 * <p>
 * url参数也可以传全路径
 * <p>
 * SDK已经封装token的保活和获取
 *
 * @since 2021-05-19
 */
public class H8900_12_ipms_Test {

    private static String host = "10.35.80.140";
    private static String username = "system";
    private static String password = "dahua2020";

    /**
     * 2.1.1 停车场车位统计
     *
     * @throws ClientException
     */
    @Test public void h8900_12_211_parkinglot_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);
        GeneralRequest request = new GeneralRequest("/ipms/parkinglot/stat", Method.GET);
        //        Map<String, Object> map = new HashMap<>();
        //        map.put("pageNum", 1);
        //        map.put("pageSize", 10);
        //        map.put("searchKey", 1);
        //        request.body(JSONUtil.toJsonStr(map));
        GeneralResponse response = client.doAction(request, request.getResponseClass());
        Assert.assertTrue(response.isSuccess());
    }

    /**
     * 2.2.1 车辆进出数据
     *
     * @throws ClientException
     */
    @Test public void h8900_12_211_caraccess_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);
        GeneralRequest request = new GeneralRequest("/ipms/caraccess/find/his", Method.GET);
        request.form("pageNum", 1);
        request.form("pageSize", 10);
        GeneralResponse response = client.doAction(request, request.getResponseClass());
        Assert.assertTrue(response.isSuccess());
    }
    /**
     * 2.2.2 过车记录
     *
     * @throws ClientException
     */
    @Test public void h8900_12_222_carcapture_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);
        GeneralRequest request = new GeneralRequest("/ipms/carcapture/find/conditions", Method.GET);
        request.form("pageNum", 1);
        request.form("pageSize", 10);
        GeneralResponse response = client.doAction(request, request.getResponseClass());
        Assert.assertTrue(response.isSuccess());
    }


    /**
     * 1.3.1在场人员查询
     *
     * @throws ClientException
     */
    @Test public void h8900_09_131_statistics_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);
        GeneralRequest request = new GeneralRequest("/CardSolution/statistics/presencePerson/page", Method.POST);
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", 1);
        map.put("pageSize", 10);
        map.put("enterEndTime", "2021-06-12 00:00:00");
        map.put("enterStartTime", "2019-06-12 00:00:00");
        request.body(JSONUtil.toJsonStr(map));
        GeneralResponse response = client.doAction(request, request.getResponseClass());
        Assert.assertTrue(response.isSuccess());
    }
}
