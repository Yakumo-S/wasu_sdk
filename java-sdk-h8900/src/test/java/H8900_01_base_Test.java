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
 * 主要针对DSS-H8900-SDK-20200111版本(v3.1.4)\02-接口文档\01-基础数据接口文档
 * <p>
 * 仅展示部分接口的调用，其他雷同
 * <p>
 * url参数也可以传全路径
 * <p>
 * SDK已经封装token的保活和获取
 *
 * @since 2021-05-19
 */
public class H8900_01_base_Test {
    /**
     * 01_基础资源_1.2.1.1查询组织
     *
     * @throws ClientException
     */
    @Test public void h8900_01_1211_org() throws ClientException {
        IClient client = new DefaultClient("10.35.120.76", "system", "dahua2006");

        GeneralRequest request = new GeneralRequest("/admin/rest/api", Method.POST);
        request.body("{\n" + "\t\"interfaceId\": \"admin_002_001\",\n"
            + "\t\"jsonParam\": \"{\\\"param\\\":{},\\\"pagination\\\": {\\\"currentPage\\\": 1,\\\"pageSize\\\": 10}}\"\n"
            + "}\n");
        String response = client.doAction(request);
        System.out.println(response);
    }

    /**
     * 01_基础资源_1.2.3.4 查询门禁设备信息
     *
     * @throws ClientException
     */
    @Test public void h8900_01_1221_orgTree() throws ClientException {
        IClient client = new DefaultClient("10.35.120.76", "system", "dahua2006");

        GeneralRequest request = new GeneralRequest("/vims/tree", Method.GET);
        request.form("type","01;00");
        String response = client.doAction(request);
        System.out.println(response);
    }

    /**
     * 01_基础资源_1.2.3.4 查询门禁设备信息
     *
     * @throws ClientException
     */
    @Test public void h8900_01_1234_accessControl_device_combined() throws ClientException {
        IClient client = new DefaultClient("10.35.80.140", "system", "dahua2020");

        GeneralRequest request = new GeneralRequest("/CardSolution/card/accessControl/device/bycondition/combined", Method.POST);
        request.body("{\"pageNum\":1,\"pageSize\":20}");
        String response = client.doAction(request);
        System.out.println(response);
    }
    /**
     * 01_基础资源_1.2.3.5.2查询可视对讲设备列表
     *
     * @throws ClientException
     */
    @Test public void h8900_01_1235_vims_device_combined() throws ClientException {
        IClient client = new DefaultClient("10.35.80.140", "system", "dahua2020");

        GeneralRequest request = new GeneralRequest("/vims/device/list/condition", Method.GET);
        String response = client.doAction(request);
        System.out.println(response);
    }
    /**
     * 01_基础资源_1.2.5.1查询身份列表
     *
     * @throws ClientException
     */
    @Test public void h8900_01_1251_card_person() throws ClientException {
        IClient client = new DefaultClient("10.35.80.140", "system", "dahua2020");

        GeneralRequest request = new GeneralRequest("/CardSolution/card/person/personidentity", Method.GET);
        String response = client.doAction(request);
        System.out.println(response);
    }
    /**
     * 01_基础资源_1.2.6.4-查询人员列表信息
     *
     * @throws ClientException
     */
    @Test public void h8900_01_12564_person_list() throws ClientException {
        IClient client = new DefaultClient("10.35.120.76", "system", "dahua2006");

        GeneralRequest request = new GeneralRequest("/CardSolution/card/person/bycondition/combined", Method.POST);
        request.body("{\n" + "\t\"pageNum\": 1,\n" + "\t\"pageSize\": 10,\n" + "\t\"deptIdsString\": \"1\"\n" + "}\n");
        String response = client.doAction(request);
        System.out.println(response);
    }
    /**
     * 01_基础资源_1.2.6.5人员图片上传
     *
     * @throws ClientException
     */
    @Test public void h8900_01_12564_images_upload() throws ClientException {
        IClient client = new DefaultClient("10.35.80.140", "system", "dahua2020");

        GeneralRequest request = new GeneralRequest("/CardSolution/common/saveMobileBase64ImageToByte", Method.POST);
        Map<String,Object> map=new HashMap<>();
        map.put("personCode","22222");
        HttpUtil.downloadFile("https://s.secrss.com/anquanneican/4493735b5b45283528dc2aad3806f8ea.jpg","c://temp.jpg");
        String base64=Base64Util.encode(FileUtil.readBytes("c:/temp.jpg"));
        System.out.println(base64);
        map.put("base64file",base64);
        request.body(JSONUtil.toJsonStr(map));
        String response = client.doAction(request);
        System.out.println(response);
    }
    /**
     * 01_基础资源_1.2.7.9 卡片查询
     *
     * @throws ClientException
     */
    @Test public void h8900_01_1279_card_query() throws ClientException {
        IClient client = new DefaultClient("10.35.80.140", "system", "dahua2020");

        GeneralRequest request = new GeneralRequest("/CardSolution/card/card/bycondition/combined", Method.POST);
        request.body("{\"cardStatus\":\"ACTIVE\",\"pageSize\":20,\"pageNum\":1}");
        String response = client.doAction(request);
        System.out.println(response);
    }



    
    /**
     * 1.2.4.1人脸检测记录
     *
     * @throws ClientException
     */
    @Test public void faceQuery() throws ClientException {
        IClient client = new DefaultClient("10.35.120.76", "system", "dahua2006");

        GeneralRequest request = new GeneralRequest("/face/faceQuery/page", Method.GET);
        request.form("pageNum", 1);
        request.form("pageSize", 10);
        request.form("searchType", 1);
        String response = client.doAction(request);
        System.out.println(response);
    }

    /**
     * 1.2.4.1人脸检测记录
     *
     * @throws ClientException
     */
    @Test public void ownerList() throws ClientException {
        IClient client = new DefaultClient("10.35.120.76", "system", "dahua2006");

        GeneralRequest request = new GeneralRequest("/ipms/owner/list", Method.GET);
        request.form("pageNum", 1);
        request.form("pageSize", 10);
        request.form("searchType", 1);
        String response = client.doAction(request);
        System.out.println(response);
    }



}
