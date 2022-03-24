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
 * 主要针对DSS-H8900-SDK-20200111版本(v3.1.4)\02-接口文档\06-消费子系统接口文档
 * <p>
 * 仅展示部分接口的调用，其他雷同
 * <p>
 * url参数也可以传全路径
 * <p>
 * SDK已经封装token的保活和获取
 *
 * @since 2021-05-19
 */
public class H8900_06_merchant_Test {

    private static String host = "10.35.80.140";
    private static String username = "system";
    private static String password = "dahua2020";

    /**
     * 1.2.4 营业单位查询
     *
     * @throws ClientException
     */
    @Test public void h8900_06_124_merchant_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);
        GeneralRequest request = new GeneralRequest("/CardSolution/card/merchant/merchantTerminalTree", Method.POST);
        GeneralResponse response = client.doAction(request, request.getResponseClass());
        Assert.assertTrue(response.isSuccess());
    }

    /**
     * 1.3.11 消费设备查询
     *
     * @throws ClientException
     */
    @Test public void h8900_06_1311_merchant_device_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);
        GeneralRequest request =
            new GeneralRequest("/CardSolution/card/consumption/terminal/bycondition/combined", Method.POST);
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", 1);
        map.put("pageSize", 10);
        request.body(JSONUtil.toJsonStr(map));
        GeneralResponse response = client.doAction(request, request.getResponseClass());
        Assert.assertTrue(response.isSuccess());
    }

    /**
     * 1.4.4 规则查询
     *
     * @throws ClientException
     */
    @Test public void h8900_06_144_merchant_device_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);
        GeneralRequest request = new GeneralRequest("/CardSolution/card/consumption/business_time", Method.GET);
        GeneralResponse response = client.doAction(request, request.getResponseClass());
        Assert.assertTrue(response.isSuccess());
    }

    /**
     * 1.5.4查询人员卡号消费列表
     *
     * @throws ClientException
     */
    @Test public void h8900_06_154_person_card_costo_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);
        GeneralRequest request =
            new GeneralRequest("/CardSolution/card/consumption/terminal/card/authorizable", Method.POST);
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", 1);
        map.put("pageSize", 10);
        request.body(JSONUtil.toJsonStr(map));
        GeneralResponse response = client.doAction(request, request.getResponseClass());
        Assert.assertTrue(response.isSuccess());
    }

}
