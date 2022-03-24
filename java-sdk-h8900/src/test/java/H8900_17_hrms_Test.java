import com.dahuatech.h8900.oauth.http.DefaultClient;
import com.dahuatech.h8900.oauth.http.IClient;
import com.dahuatech.h8900.oauth.model.v202010.GeneralRequest;
import com.dahuatech.h8900.oauth.model.v202010.GeneralResponse;
import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import org.junit.Assert;
import org.junit.Test;

/**
 * 主要针对DSS-H8900-SDK-20200111版本(v3.1.4)\02-接口文档\17-小区子系统接口文档
 * <p>
 * 仅展示部分接口的调用，其他雷同
 * <p>
 * url参数也可以传全路径
 * <p>
 * SDK已经封装token的保活和获取
 *
 * @since 2021-05-19
 */
public class H8900_17_hrms_Test {

    private static String host = "10.31.21.211";
    private static String username = "system";
    private static String password = "dahua2006";

    /**
     * 1.2.1.6 小区分页查询
     *
     * @throws ClientException
     */
    @Test public void h8900_17_1214_hrms_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);
        GeneralRequest request = new GeneralRequest("/hrms/block/page", Method.GET);
        request.form("pageSize", 10);
        request.form("pageNum", 1);
        request.form("searchType", 2);
        GeneralResponse response = client.doAction(request, request.getResponseClass());
        Assert.assertTrue(response.isSuccess());
    }

    /**
     * 1.2.4.1人脸检测记录
     *
     * @throws ClientException
     */
    @Test public void h8900_15_1321_pmms_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);
        GeneralRequest request = new GeneralRequest("/face/faceQuery/page", Method.GET);
        request.form("pageSize", 10);
        request.form("pageNum", 1);
        request.form("searchType", 2);
        GeneralResponse response = client.doAction(request, request.getResponseClass());
        Assert.assertTrue(response.isSuccess());
    }

}
