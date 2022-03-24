import com.dahuatech.h8900.oauth.http.DefaultClient;
import com.dahuatech.h8900.oauth.http.IClient;
import com.dahuatech.h8900.oauth.model.v202010.GeneralRequest;
import com.dahuatech.hutool.http.Method;
import com.dahuatech.hutool.json.JSONUtil;
import com.dahuatech.icc.exception.ClientException;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 主要针对DSS-H8900-SDK-20200111版本(v3.1.4)\02-接口文档\03-考勤系统接口文档
 * <p>
 * 仅展示部分接口的调用，其他雷同
 * <p>
 * url参数也可以传全路径
 * <p>
 * SDK已经封装token的保活和获取
 *
 * @since 2021-05-19
 */
public class H8900_03_attendance_Test {

    private static String host = "10.35.80.140";
    private static String username = "system";
    private static String password = "dahua2020";

    /**
     * 1.9.1 考勤结果记录查询
     *
     * @throws ClientException
     */
    @Test public void h8900_01_191_attendance_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);

        GeneralRequest request = new GeneralRequest("/CardSolution/attendance/result/page", Method.POST);
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", 1);
        map.put("pageSize", 10);
        map.put("searchType", 1);
        request.body(JSONUtil.toJsonStr(map));
        String response = client.doAction(request);
        System.out.println(response);
    }
    /**
     * 1.9.1 考勤结果记录查询
     *
     * @throws ClientException
     */
    @Test public void h8900_01_1101_attendance_result_list() throws ClientException {
        IClient client = new DefaultClient(host, username, password);

        GeneralRequest request = new GeneralRequest("/CardSolution/attendance/result/stat/page", Method.POST);
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", 1);
        map.put("pageSize", 10);
        map.put("searchType", 1);
        request.body(JSONUtil.toJsonStr(map));
        String response = client.doAction(request);
        System.out.println(response);
    }
}
