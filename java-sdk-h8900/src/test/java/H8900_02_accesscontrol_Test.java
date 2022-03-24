import com.dahuatech.h8900.oauth.http.DefaultClient;
import com.dahuatech.h8900.oauth.http.IClient;
import com.dahuatech.h8900.oauth.model.v202010.GeneralRequest;
import com.dahuatech.hutool.core.io.FileUtil;
import com.dahuatech.hutool.http.HttpUtil;
import com.dahuatech.hutool.http.Method;
import com.dahuatech.hutool.json.JSONUtil;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.util.Base64Util;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 主要针对DSS-H8900-SDK-20200111版本(v3.1.4)\02-接口文档\02-门禁子系统接口文档
 * <p>
 * 仅展示部分接口的调用，其他雷同
 * <p>
 * url参数也可以传全路径
 * <p>
 * SDK已经封装token的保活和获取
 *
 * @since 2021-05-19
 */
public class H8900_02_accesscontrol_Test {

    private static String host = "10.35.120.76";
    private static String username = "system";
    private static String password = "dahua2006";

    /**
     * 02_门禁子系统资源_1.3.1.1查询分组
     *
     * @throws ClientException
     */
    @Test public void h8900_01_1311_vims_card_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);

        GeneralRequest request = new GeneralRequest("/vims/cardGroup/list", Method.GET);
        String response = client.doAction(request);
        System.out.println(response);
    }

    /**
     * 02_门禁子系统资源_1.3.1.1查询分组
     * <p>
     * 全路径
     *
     * @throws ClientException
     */
    @Test public void h8900_01_1311_vims_card_list_other() throws ClientException {
        IClient client = new DefaultClient(host, username, password);

        GeneralRequest request = new GeneralRequest("http://" + host + "/vims/cardGroup/list", Method.GET);
        String response = client.doAction(request);
        System.out.println(response);
    }

    /**
     * 02_门禁子系统资源_1.3.5.1可视对讲设备报警记录
     *
     * @throws ClientException
     */
    @Test public void h8900_01_1351_vims_alarm_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);

        GeneralRequest request = new GeneralRequest("/vims/log/alarm/list", Method.GET);
        String response = client.doAction(request);
        System.out.println(response);
    }

}
