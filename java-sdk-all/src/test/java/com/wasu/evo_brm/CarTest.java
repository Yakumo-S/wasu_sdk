package com.wasu.evo_brm;


import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.ExtentUtils;
import com.wasu.model.v202010.car.BrmCarAddRequest;
import com.wasu.model.v202010.car.BrmCarAddResponse;
import com.wasu.model.v202010.car.BrmCarBatchAddRequest;
import com.wasu.model.v202010.car.BrmCarBatchAddResponse;
import com.wasu.model.v202010.car.BrmCarDelRequest;
import com.wasu.model.v202010.car.BrmCarDelResponse;
import com.wasu.model.v202010.car.BrmCarPageRequest;
import com.wasu.model.v202010.car.BrmCarPageResponse;
import com.wasu.model.v202010.car.BrmCarQueryRequest;
import com.wasu.model.v202010.car.BrmCarQueryResponse;
import com.wasu.model.v202010.car.BrmCarSyncRequest;
import com.wasu.model.v202010.car.BrmCarSyncResponse;
import com.wasu.model.v202010.car.BrmCarUpdateRequest;
import com.wasu.model.v202010.car.BrmCarUpdateResponse;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础资源-车辆管理
 *
 * @author 237417
 * @since 2021/02/24
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarTest extends ExtentUtils {
    private static String carNum = "浙A888888";
    private static Long deptId = 1L;

    @BeforeAll
    public static void beforeClass() throws ClientException {}

    @BeforeEach
    public void before() throws ClientException {
        setup();
    }

    @AfterEach
    public void after() throws ClientException {
        setup();
    }

    private void setup() throws ClientException {
        IClient iClient = new DefaultClient();
        // 执行分页 查询
        BrmCarPageRequest pageRequest = new BrmCarPageRequest();
        pageRequest.setPageSize(20);
        BrmCarPageResponse response = iClient.doAction(pageRequest, pageRequest.getResponseClass());
        printLog(pageRequest, response);
        if (response.isSuccess()
                && response.getData() != null
                && response.getData().getPageData() != null) {
            List<BrmCarPageResponse.CarPageData> pages = response.getData().getPageData();
            if (pages != null && pages.size() > 0) {
                List<String> carCords = new ArrayList<>();
                for (BrmCarPageResponse.CarPageData cp : pages) {
                    carCords.add(cp.getCarCode());
                }
                if (carCords.size() > 0) {
                    // 开始删除
                    BrmCarDelRequest delRequest = BrmCarDelRequest.builder().carCodeList(carCords).build();
                    BrmCarDelResponse delResponse =
                            iClient.doAction(delRequest, delRequest.getResponseClass());
                    printLog(delRequest, delResponse);
                }
            }
        }
    }

    /**
     * 基础资源->车辆管理-新增
     *
     * <p>接口编号 evo_brm_066
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/%{version}/car/add
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("车辆管理-新增")
    @Tag("基础资源")
    public void evo_brm_066_car_add() throws ClientException {

        logger.info("----开始执行----{}------", "车辆管理-新增");
        IClient iClient = new DefaultClient();
        BrmCarAddRequest request =
                BrmCarAddRequest.builder().departmentId(deptId).carNum(carNum).build();
        BrmCarAddResponse response = iClient.doAction(request, request.getResponseClass());
        Assertions.assertTrue(response.isSuccess());
        printLog(request, response);
        Assertions.assertTrue(response.isSuccess());
        logger.info("----结束执行----{}------", "车辆管理-新增");
    }


    /**
     * 基础资源->车辆管理-更新
     *
     * <p>接口编号 evo_brm_067
     *
     * <p>方法类型 put
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/car/update
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("车辆管理-更新")
    @Tag("基础资源")
    public void evo_brm_067_car_update() throws ClientException {
        logger.info("----开始执行----{}------", "车辆管理-更新");
        IClient iClient = new DefaultClient();
        // 产生车辆
        BrmCarAddRequest request =
                BrmCarAddRequest.builder().departmentId(deptId).carNum(carNum).build();
        BrmCarAddResponse response = iClient.doAction(request, request.getResponseClass());
        Assertions.assertTrue(response.isSuccess());
        printLog(request, response);
        // 更新
        BrmCarPageRequest pageRequest = new BrmCarPageRequest();
        BrmCarPageResponse pageResponse = iClient.doAction(pageRequest, pageRequest.getResponseClass());
        Assertions.assertTrue(pageResponse.isSuccess());
        printLog(pageRequest, pageResponse);
        List<BrmCarPageResponse.CarPageData> carPageData = pageResponse.getData().getPageData();
        if (carPageData != null && carPageData.size() > 0) {
            BrmCarPageResponse.CarPageData data = carPageData.get(0);
            BrmCarUpdateRequest updateRequest =
                    BrmCarUpdateRequest.builder()
                            .carCode(data.getCarCode())
                            .departmentId(data.getDepartmentId())
                            .carNum(data.getCarNum())
                            .build();
            updateRequest.setCarBrand("12");
            BrmCarUpdateResponse updateResponse =
                    iClient.doAction(updateRequest, updateRequest.getResponseClass());
            printLog(updateRequest, updateResponse);
            Assertions.assertTrue(updateResponse.isSuccess());
            logger.info("----结束执行----{}------", "车辆管理-更新");
        }
    }

    /**
     * 基础资源->车辆管理-删除
     *
     * <p>接口编号 evo_brm_068
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/car/delete
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("车辆管理-删除")
    @Tag("基础资源")
    public void evo_brm_068_car_delete() throws ClientException {
        logger.info("----开始执行----{}------", "车辆管理-删除");
        // 新增
        IClient iClient = new DefaultClient();
        BrmCarAddRequest request =
                BrmCarAddRequest.builder().departmentId(deptId).carNum(carNum).build();
        BrmCarAddResponse response = iClient.doAction(request, request.getResponseClass());
        printLog(request, response);
        Assertions.assertTrue(response.isSuccess());
        List<String> carNums = new ArrayList<>();
        carNums.add(carNum);
        // 删除信息
        BrmCarDelRequest delRequest =
                BrmCarDelRequest.builder().carNumList(carNums).build();
        BrmCarDelResponse delResponse =
                iClient.doAction(delRequest, delRequest.getResponseClass());
        printLog(delRequest, delResponse);
        Assertions.assertTrue(delResponse.isSuccess());
        logger.info("----结束执行----{}------", "车辆管理-删除");
    }

    /**
     * 基础资源->车辆管理-详情
     *
     * <p>接口编号 evo_brm_069
     *
     * <p>方法类型 get
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/car/{carCode}
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("车辆管理-详情")
    @Tag("基础资源")
    public void evo_brm_069_car_detail() throws ClientException {
        logger.info("----开始执行----{}------", "车辆管理-详情");
        // 产生数据
        IClient iClient = new DefaultClient();
        BrmCarAddRequest request =
                BrmCarAddRequest.builder().departmentId(deptId).carNum(carNum).build();
        BrmCarAddResponse response = iClient.doAction(request, request.getResponseClass());
        printLog(request, response);
        Assertions.assertTrue(response.isSuccess());
        // 更新
        BrmCarPageRequest pageRequest = new BrmCarPageRequest();
        BrmCarPageResponse pageResponse =
                iClient.doAction(pageRequest, pageRequest.getResponseClass());
        printLog(pageRequest, pageResponse);
        Assertions.assertTrue(pageResponse.isSuccess());
        List<BrmCarPageResponse.CarPageData> carPageData = pageResponse.getData().getPageData();
        if (carPageData != null && carPageData.size() > 0) {
            // 开始查询
            BrmCarPageResponse.CarPageData data = carPageData.get(0);
            BrmCarQueryRequest delRequest = new BrmCarQueryRequest(data.getCarCode());
            BrmCarQueryResponse delResponse =
                    iClient.doAction(delRequest, delRequest.getResponseClass());
            printLog(delRequest, delResponse);
            Assertions.assertTrue(delResponse.isSuccess());
        }
        logger.info("----结束执行----{}------", "车辆管理-详情");
    }

    /**
     * 基础资源->用户管理-批量新增
     *
     * <p>接口编号 evo_brm_070
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/car/add-batch
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("用户管理-批量新增")
    @Tag("基础资源")
    public void evo_brm_070_car_batch_add() throws ClientException {
        logger.info("----开始执行----{}------", "用户管理-批量新增");
        // 产生数据
        IClient iClient = new DefaultClient();
        BrmCarBatchAddRequest.CarBatchAddData data = new BrmCarBatchAddRequest.CarBatchAddData();
        data.setCarNum(carNum);
        data.setDepartmentId(deptId);
        List<BrmCarBatchAddRequest.CarBatchAddData> carList = new ArrayList<>();
        carList.add(data);
        BrmCarBatchAddRequest batchAddRequest =
                BrmCarBatchAddRequest.builder().carList(carList).build();
        BrmCarBatchAddResponse batchAddResponse =
                iClient.doAction(batchAddRequest, batchAddRequest.getResponseClass());
        printLog(batchAddRequest, batchAddResponse);
        Assertions.assertTrue(batchAddResponse.isSuccess());;
        logger.info("----结束执行----{}------", "用户管理-批量新增");
    }

    /**
     * 基础资源->车辆管理-分页查询
     *
     * <p>接口编号 evo_brm_071
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/car/subsystem/page
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("车辆管理-分页查询")
    @Tag("基础资源")
    public void evo_brm_071_car_page() throws ClientException {
        logger.info("----开始执行----{}------", "车辆管理-分页查询");
        // 产生数据
        IClient iClient = new DefaultClient();
        BrmCarAddRequest request =
                BrmCarAddRequest.builder().departmentId(deptId).carNum(carNum).build();
        BrmCarAddResponse response = iClient.doAction(request, request.getResponseClass());
        printLog(request, response);
        Assertions.assertTrue(response.isSuccess());
        // 开始查询
        BrmCarPageRequest pageRequest = new BrmCarPageRequest();
        BrmCarPageResponse pageResponse =
                iClient.doAction(pageRequest, pageRequest.getResponseClass());
        printLog(pageRequest, pageResponse);
        Assertions.assertTrue(pageResponse.isSuccess());
        logger.info("----结束执行----{}------", "车辆管理-分页查询");
    }

    /**
     * 基础资源->车辆管理-全量同步
     *
     * <p>接口编号 evo_brm_072
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/car/page
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("车辆管理-全量同步")
    @Tag("基础资源")
    public void evo_brm_072_car_sync() throws ClientException {
        logger.info("----开始执行----{}------", "车辆管理-全量同步");
        IClient iClient = new DefaultClient();
        // 产生数据
        BrmCarAddRequest request =
                BrmCarAddRequest.builder().departmentId(deptId).carNum(carNum).build();
        BrmCarAddResponse response = iClient.doAction(request, request.getResponseClass());
        printLog(request, response);
        Assertions.assertTrue(response.isSuccess());
        // 执行分页 查询
        BrmCarSyncRequest syncRequest =
                new BrmCarSyncRequest();
        BrmCarSyncResponse syncResponse =
                iClient.doAction(syncRequest, syncRequest.getResponseClass());
        printLog(syncRequest, syncResponse);
        Assertions.assertTrue(syncResponse.isSuccess());
        logger.info("----结束执行----{}------", "车辆管理-全量同步");
    }
}
