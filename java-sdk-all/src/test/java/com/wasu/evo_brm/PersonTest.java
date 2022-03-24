package com.wasu.evo_brm;


import cn.binarywang.tools.generator.ChineseIDCardNumberGenerator;
import com.wasu.hutool.core.date.DateUtil;
import com.wasu.hutool.core.util.RandomUtil;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.ExtentUtils;
import com.wasu.model.v202010.person.BrmPersonAddRequest;
import com.wasu.model.v202010.person.BrmPersonAddResponse;
import com.wasu.model.v202010.person.BrmPersonBatchAddRequest;
import com.wasu.model.v202010.person.BrmPersonBatchAddResponse;
import com.wasu.model.v202010.person.BrmPersonBatchGenIdRequest;
import com.wasu.model.v202010.person.BrmPersonBatchGenIdResponse;
import com.wasu.model.v202010.person.BrmPersonBatchUpdateImgRequest;
import com.wasu.model.v202010.person.BrmPersonBatchUpdateImgResponse;
import com.wasu.model.v202010.person.BrmPersonCar;
import com.wasu.model.v202010.person.BrmPersonCard;
import com.wasu.model.v202010.person.BrmPersonDelRequest;
import com.wasu.model.v202010.person.BrmPersonDelResponse;
import com.wasu.model.v202010.person.BrmPersonGenIdRequest;
import com.wasu.model.v202010.person.BrmPersonGenIdResponse;
import com.wasu.model.v202010.person.BrmPersonPageRequest;
import com.wasu.model.v202010.person.BrmPersonPageResponse;
import com.wasu.model.v202010.person.BrmPersonQueryByIdCardRequest;
import com.wasu.model.v202010.person.BrmPersonQueryByIdCardResponse;
import com.wasu.model.v202010.person.BrmPersonQueryRequest;
import com.wasu.model.v202010.person.BrmPersonQueryResponse;
import com.wasu.model.v202010.person.BrmPersonSaveAllRequest;
import com.wasu.model.v202010.person.BrmPersonSaveAllResponse;
import com.wasu.model.v202010.person.BrmPersonSyncRequest;
import com.wasu.model.v202010.person.BrmPersonSyncResponse;
import com.wasu.model.v202010.person.BrmPersonUpdateRequest;
import com.wasu.model.v202010.person.BrmPersonUpdateResponse;
import com.wasu.model.v202010.person.BrmPersonUploadImgRequest;
import com.wasu.model.v202010.person.BrmPersonUploadImgResponse;
import com.wasu.model.v202010.person.PersonBioSignatures;
import com.wasu.model.v202010.person.PersonData;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 基础资源-人员管理
 *
 * @author 237417
 * @since 2021/02/24
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonTest extends ExtentUtils {
    private static Integer paperType = 111;
    private static Long departmentId = 1L;
    private static String car_prefix = "浙";

    private static String carNum = "浙A888888";
    private static Long deptId = 1L;

    private static String cardType = "0";
    private static String cardGory = "0";
    private static String name = "测试员";

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
        List<Integer> status = new ArrayList<>();
        BrmPersonPageRequest pageRequest = BrmPersonPageRequest.builder().statusList(status).build();
        pageRequest.setSearchKey(name);
//        pageRequest.setPageSize(20);
        BrmPersonPageResponse response = iClient.doAction(pageRequest, pageRequest.getResponseClass());
        printLog(pageRequest, response);
        if (response.isSuccess()
                && response.getData() != null
                && response.getData().getPageData() != null) {
            List<PersonData> pages = response.getData().getPageData();
            if (pages != null && pages.size() > 0) {
                List<Long> ids = new ArrayList<>();
                for (PersonData pd : pages) {
                    ids.add(pd.getId());
                }
                if (ids.size() > 0) {
                    BrmPersonDelRequest delRequest = BrmPersonDelRequest.builder().ids(ids).build();
                    BrmPersonDelResponse delResponse =
                            iClient.doAction(delRequest, delRequest.getResponseClass());
                    printLog(delRequest, delResponse);
                }
            }
        }
    }

    /**
     * 基础资源->人员管理-新增
     *
     * <p>接口编号 evo_brm_038
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/%{version}/person/subsystem/add
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("人员管理-新增")
    @Tag("基础资源")
    public void evo_brm_038_person_add() throws ClientException {

        logger.info("----开始执行----{}------", "人员管理-新增");
        // 新增
        IClient iClient = new DefaultClient();
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        String code = RandomUtil.randomString(6);
//        String name = ChineseNameGenerator.getInstance().generate();

        // 产生ID
        BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
        BrmPersonGenIdResponse genIdResponse =
                iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
        printLog(genIdRequest, genIdResponse);
        Assertions.assertTrue(genIdResponse.isSuccess());
        // 新增人员
        BrmPersonAddRequest request =
                BrmPersonAddRequest.builder()
                        .code(code)
                        .id(genIdResponse.getData().getId())
                        .departmentId(departmentId)
                        .name(name)
                        .paperType(paperType)
                        .build();
        request.setPaperNumber(idCard);
        BrmPersonAddResponse response = iClient.doAction(request, request.getResponseClass());
        printLog(request, response);
        Assertions.assertTrue(response.isSuccess());
        logger.info("----结束执行----{}------", "人员管理-新增");
    }

    /**
     * 基础资源->人员管理-批量新增
     *
     * <p>接口编号 evo_brm_039
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/person/subsystem/batch-add
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("人员管理-批量新增")
    @Tag("基础资源")
    public void evo_brm_039_user_batch_add() throws ClientException {
        logger.info("----开始执行----{}------", "人员管理-批量新增");
        // 新增
        IClient iClient = new DefaultClient();
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        String code = RandomUtil.randomString(6);
//        String name = ChineseNameGenerator.getInstance().generate();
        // 产生ID
        BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
        BrmPersonGenIdResponse genIdResponse =
                iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
        printLog(genIdRequest, genIdResponse);
        Assertions.assertTrue(genIdResponse.isSuccess());

        // 开始新增
        List<BrmPersonBatchAddRequest.PersonBatchData> personBatchDataList = new ArrayList<>();
        BrmPersonBatchAddRequest.PersonBatchData data = new BrmPersonBatchAddRequest.PersonBatchData();
        data.setCode(code);
        data.setId(genIdResponse.getData().getId());
        data.setDepartmentId(departmentId);
        data.setName(name);
        data.setPaperType(paperType);
        data.setPaperNumber(idCard);
        personBatchDataList.add(data);
        BrmPersonBatchAddRequest batchAddRequest =
                BrmPersonBatchAddRequest.builder().personList(personBatchDataList).build();
        BrmPersonBatchAddResponse batchAddResponse =
                iClient.doAction(batchAddRequest, batchAddRequest.getResponseClass());
        printLog(batchAddRequest, batchAddResponse);
        Assertions.assertTrue(batchAddResponse.isSuccess());
        logger.info("----结束执行----{}------", "用户管理-批量新增");
    }


    /**
     * 基础资源->人员管理-更新
     *
     * <p>接口编号 evo_brm_040
     *
     * <p>方法类型 put
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/person/subsystem/update
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("人员管理-更新")
    @Tag("基础资源")
    public void evo_brm_040_person_update() throws ClientException {
        logger.info("----开始执行----{}------", "人员管理-更新");
        IClient iClient = new DefaultClient();
        // 新增
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        String code = RandomUtil.randomString(6);
//        String name = ChineseNameGenerator.getInstance().generate();
        // 产生ID
        BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
        BrmPersonGenIdResponse genIdResponse =
                iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
        printLog(genIdRequest, genIdResponse);
        Assertions.assertTrue(genIdResponse.isSuccess());
        // 新增人员
        BrmPersonAddRequest request =
                BrmPersonAddRequest.builder()
                        .code(code)
                        .id(genIdResponse.getData().getId())
                        .departmentId(departmentId)
                        .name(name)
                        .paperType(paperType)
                        .build();
        request.setPaperNumber(idCard);
        BrmPersonAddResponse response = iClient.doAction(request, request.getResponseClass());
        printLog(request, response);
        Assertions.assertTrue(response.isSuccess());
        // 更新人员
        BrmPersonUpdateRequest updateRequest =
                BrmPersonUpdateRequest.builder()
                        .departmentId(departmentId)
                        .paperType(paperType)
                        .paperNumber(idCard)
                        .code(code)
                        .name(name)
                        .id(response.getData().getId())
                        .paperAddress("北京")
                        .paperTypeName("身份证")
                        .build();
//        updateRequest.setPhone("13282821333");
        BrmPersonUpdateResponse updateResponse =
                iClient.doAction(updateRequest, updateRequest.getResponseClass());
        printLog(updateRequest, updateResponse);
        Assertions.assertTrue(updateResponse.isSuccess());
        logger.info("----结束执行----{}------", "人员管理-更新");
    }


    /**
     * 基础资源->人员管理-详情
     *
     * <p>接口编号 evo_brm_041
     *
     * <p>方法类型 get
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/person/subsystem/{id}
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("人员管理-详情")
    @Tag("基础资源")
    public void evo_brm_041_person_detail() throws ClientException {
        logger.info("----开始执行----{}------", "人员管理-详情");
        IClient iClient = new DefaultClient();
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        String code = RandomUtil.randomString(6);
//        String name = ChineseNameGenerator.getInstance().generate();
        // 产生ID
        BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
        BrmPersonGenIdResponse genIdResponse =
                iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
        printLog(genIdRequest, genIdResponse);
        Assertions.assertTrue(genIdResponse.isSuccess());
        // 新增人员
        BrmPersonAddRequest addRequest =
                BrmPersonAddRequest.builder()
                        .code(code)
                        .id(genIdResponse.getData().getId())
                        .departmentId(departmentId)
                        .name(name)
                        .paperType(paperType)
                        .build();
        addRequest.setPaperNumber(ChineseIDCardNumberGenerator.getInstance().generate());
        BrmPersonAddResponse addResponse = iClient.doAction(addRequest, addRequest.getResponseClass());
        printLog(addRequest, addResponse);
        Assertions.assertTrue(addResponse.isSuccess());
        // 查询
        BrmPersonQueryRequest queryRequest = new BrmPersonQueryRequest(addResponse.getData().getId());
        BrmPersonQueryResponse queryResponse =
                iClient.doAction(queryRequest, queryRequest.getResponseClass());
        printLog(queryRequest, queryResponse);
        Assertions.assertTrue(queryResponse.isSuccess());
        logger.info("----结束执行----{}------", "人员管理-详情");
    }

    /**
     * 基础资源->人员管理-删除
     *
     * <p>接口编号 evo_brm_042
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/person/delete
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("人员管理-删除")
    @Tag("基础资源")
    public void evo_brm_042_person_delete() throws ClientException {
        logger.info("----开始执行----{}------", "人员管理-删除");
        IClient iClient = new DefaultClient();
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        String code = RandomUtil.randomString(6);
//        String name = ChineseNameGenerator.getInstance().generate();
        // 产生ID
        BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
        BrmPersonGenIdResponse genIdResponse =
                iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
        printLog(genIdRequest, genIdResponse);
        Assertions.assertTrue(genIdResponse.isSuccess());
        // 新增人员
        BrmPersonAddRequest addRequest =
                BrmPersonAddRequest.builder()
                        .code(code)
                        .id(genIdResponse.getData().getId())
                        .departmentId(departmentId)
                        .name(name)
                        .paperType(paperType)
                        .build();
        addRequest.setPaperNumber(ChineseIDCardNumberGenerator.getInstance().generate());
        BrmPersonAddResponse addResponse = iClient.doAction(addRequest, addRequest.getResponseClass());
        printLog(addRequest, addResponse);
        Assertions.assertTrue(addResponse.isSuccess());
        // 删除人员
        List<Long> ids = new ArrayList<>();
        ids.add(addResponse.getData().getId());
        BrmPersonDelRequest delRequest = BrmPersonDelRequest.builder().ids(ids).build();
        BrmPersonDelResponse delResponse = iClient.doAction(delRequest, delRequest.getResponseClass());
        printLog(delRequest, delResponse);
        Assertions.assertTrue(delResponse.isSuccess());
        logger.info("----结束执行----{}------", "人员管理-删除");
    }

    /**
     * 基础资源->人员管理-全局ID生成
     *
     * <p>接口编号 evo_brm_043
     *
     * <p>方法类型 get
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/person/generate-id
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("人员管理-全局ID生成")
    @Tag("基础资源")
    public void evo_brm_043_person_generate_id() throws ClientException {
        logger.info("----开始执行----{}------", "人员管理-全局ID生成");
        IClient iClient = new DefaultClient();
        BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
        BrmPersonGenIdResponse genIdResponse =
                iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
        printLog(genIdRequest, genIdResponse);
        Assertions.assertTrue(genIdResponse.isSuccess());
        logger.info("----结束执行----{}------", "人员管理-全局ID生成");
    }

    /**
     * 基础资源->人员管理-头像批量更新
     *
     * <p>接口编号 evo_brm_044
     *
     * <p>方法类型 put
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/person/subsystem/update-biosignature-face
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("人员管理-头像批量更新")
    @Tag("基础资源")
    public void evo_brm_044_person_update_biosignature_face() throws ClientException {
        logger.info("----开始执行----{}------", "人员管理-头像批量更新");
        IClient iClient = new DefaultClient();
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        String code = RandomUtil.randomString(6);
//        String name = ChineseNameGenerator.getInstance().generate();
        // 产生ID
        BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
        BrmPersonGenIdResponse genIdResponse =
                iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
        printLog(genIdRequest, genIdResponse);
        Assertions.assertTrue(genIdResponse.isSuccess());
        // 新增人员
        BrmPersonAddRequest addRequest =
                BrmPersonAddRequest.builder()
                        .code(code)
                        .id(genIdResponse.getData().getId())
                        .departmentId(departmentId)
                        .name(name)
                        .paperType(paperType)
                        .build();
        addRequest.setPaperNumber(ChineseIDCardNumberGenerator.getInstance().generate());
        BrmPersonAddResponse addResponse = iClient.doAction(addRequest, addRequest.getResponseClass());
        printLog(addRequest, addResponse);
        Assertions.assertTrue(addResponse.isSuccess());

        // 头像批量更新
        List<PersonBioSignatures> personBiosignatures = new ArrayList<>();
        PersonBioSignatures signatures = new PersonBioSignatures();
        signatures.setPath(
                "71f193ee-b2cb-11ea-a94e-000af7e4d68a/20201109/1/f5259745-227d-11eb-9cff-000af7e4d68a.jpg");
        signatures.setType(3);
        signatures.setIndex(1);
        signatures.setPersonId(addResponse.getData().getId());
        personBiosignatures.add(signatures);
        BrmPersonBatchUpdateImgRequest batchUpdateImgRequest =
                BrmPersonBatchUpdateImgRequest.builder().personBiosignatures(personBiosignatures).build();

        BrmPersonBatchUpdateImgResponse batchUpdateImgResponse =
                iClient.doAction(batchUpdateImgRequest, batchUpdateImgRequest.getResponseClass());
        printLog(batchUpdateImgRequest, batchUpdateImgResponse);
        Assertions.assertTrue(batchUpdateImgResponse.isSuccess());
        logger.info("----结束执行----{}------", "人员管理-头像批量更新");
    }

    /**
     * 基础资源->人员管理-新增（包含车辆、卡片信息）
     *
     * <p>接口编号 evo_brm_045
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/person/subsystem/save-person-all
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("人员管理-新增（包含车辆、卡片信息）")
    @Tag("基础资源")
    public void evo_brm_045_person_save_person_all() throws ClientException {
        logger.info("----开始执行----{}------", "人员管理-新增（包含车辆、卡片信息）");
        // 新增
        IClient iClient = new DefaultClient();
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        String code = RandomUtil.randomString(6);
//        String name = ChineseNameGenerator.getInstance().generate();

        // 产生ID
        BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
        BrmPersonGenIdResponse genIdResponse =
                iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
        printLog(genIdRequest, genIdResponse);
        Assertions.assertTrue(genIdResponse.isSuccess());
        // 产生车辆
        BrmPersonCar brmPersonCar = BrmPersonCar.builder().carNum(carNum).build();
        List<BrmPersonCar> cars = new ArrayList<>();
        cars.add(brmPersonCar);

        // 新增卡片
        BrmPersonCard brmPersonCard =
                BrmPersonCard.builder()
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .departmentId(departmentId)
                        .build();
        List<BrmPersonCard> cards = new ArrayList<>();
        cards.add(brmPersonCard);
        // 新增全量人员
        BrmPersonSaveAllRequest request =
                BrmPersonSaveAllRequest.builder()
                        .code(code)
                        .id(genIdResponse.getData().getId())
                        .departmentId(departmentId)
                        .name(name)
                        .paperType(paperType)
                        .cards(cards)
                        .cars(cars)
                        .build();
        request.setPaperNumber(idCard);
//        request.setCars(cars);
//        request.setCards(cards);
        BrmPersonSaveAllResponse response = iClient.doAction(request, request.getResponseClass());
        printLog(request, response);
        Assertions.assertTrue(response.isSuccess());
        logger.info("----结束执行----{}------", "人员管理-新增（包含车辆、卡片信息）");
    }

    /**
     * 基础资源->人员管理-详情信息获取(根据人员证件号获取)
     *
     * <p>接口编号 evo_brm_046
     *
     * <p>方法类型 get
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/person/list-page
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("人员管理-详情信息获取(根据人员证件号获取)")
    @Tag("基础资源")
    public void evo_brm_046_person_get_by_paper_number() throws ClientException {
        logger.info("----开始执行----{}------", "人员管理-详情信息获取(根据人员证件号获取)");
        IClient iClient = new DefaultClient();
        // 产生ID
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        String code = RandomUtil.randomString(6);
//        String name = ChineseNameGenerator.getInstance().generate();

        BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
        BrmPersonGenIdResponse genIdResponse =
                iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
        // 新增人员
        BrmPersonAddRequest addRequest =
                BrmPersonAddRequest.builder()
                        .code(code)
                        .id(genIdResponse.getData().getId())
                        .departmentId(departmentId)
                        .name(name)
                        .paperType(paperType)
                        .build();
        addRequest.setPaperNumber(idCard);
        BrmPersonAddResponse addResponse = iClient.doAction(addRequest, addRequest.getResponseClass());
        printLog(addRequest, addResponse);
        Assertions.assertTrue(addResponse.isSuccess());
        // 查询
        BrmPersonQueryByIdCardRequest idCardRequest = new BrmPersonQueryByIdCardRequest(idCard);
        BrmPersonQueryByIdCardResponse idCardResponse =
                iClient.doAction(idCardRequest, idCardRequest.getResponseClass());
        printLog(idCardRequest, idCardResponse);
        Assertions.assertTrue(idCardResponse.isSuccess());
        logger.info("----结束执行----{}------", "人员管理-详情信息获取(根据人员证件号获取)");
    }

    /**
     * 基础资源->人员管理-分页查询
     *
     * <p>接口编号 evo_brm_047
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/person/subsystem/page
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("人员管理-分页查询")
    @Tag("基础资源")
    public void evo_brm_047_person_page() throws ClientException {
        logger.info("----开始执行----{}------", "人员管理-分页查询");
        IClient iClient = new DefaultClient();
        List<Integer> status = new ArrayList<>();
        status.add(0);
        BrmPersonPageRequest pageRequest = BrmPersonPageRequest.builder().statusList(status).build();
        BrmPersonPageResponse pageResponse =
                iClient.doAction(pageRequest, pageRequest.getResponseClass());
        printLog(pageRequest, pageResponse);
        Assertions.assertTrue(pageResponse.isSuccess());
        logger.info("----结束执行----{}------", "人员管理-分页查询");
    }

    /**
     * 基础资源->人员管理-批量生成人员全局唯一ID
     *
     * <p>接口编号 evo_brm_048
     *
     * <p>方法类型 get
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/person/subsystem/batch-generate-id
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("人员管理-批量生成人员全局唯一ID")
    @Tag("基础资源")
    public void evo_brm_048_person_batch_generate_id() throws ClientException {
        logger.info("----开始执行----{}------", "人员管理-批量生成人员全局唯一ID");
        IClient iClient = new DefaultClient();
        BrmPersonBatchGenIdRequest request = new BrmPersonBatchGenIdRequest(1);
        BrmPersonBatchGenIdResponse response =
                iClient.doAction(request, request.getResponseClass());
        printLog(request, response);
        Assertions.assertTrue(response.isSuccess());
        logger.info("----结束执行----{}------", "人员管理-批量生成人员全局唯一ID");
    }

    /**
     * 基础资源->人员管理-全量同步
     *
     * <p>接口编号 evo_brm_049
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/person/subsystem/list-page
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("人员管理-全量同步")
    @Tag("基础资源")
    public void evo_brm_049_person_sync() throws ClientException {
        logger.info("----开始执行----{}------", "人员管理-全量同步");
        IClient iClient = new DefaultClient();
        // 产生ID
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        String code = RandomUtil.randomString(6);
//        String name = ChineseNameGenerator.getInstance().generate();

        BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
        BrmPersonGenIdResponse genIdResponse =
                iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
        // 新增人员
        BrmPersonAddRequest addRequest =
                BrmPersonAddRequest.builder()
                        .code(code)
                        .id(genIdResponse.getData().getId())
                        .departmentId(departmentId)
                        .name(name)
                        .paperType(paperType)
                        .build();
        addRequest.setPaperNumber(idCard);
        BrmPersonAddResponse addResponse = iClient.doAction(addRequest, addRequest.getResponseClass());
        printLog(addRequest, addResponse);
        Assertions.assertTrue(addResponse.isSuccess());
        // 执行分页 查询
        BrmPersonSyncRequest syncRequest = new BrmPersonSyncRequest();
        BrmPersonSyncResponse syncResponse =
                iClient.doAction(syncRequest, syncRequest.getResponseClass());
        printLog(syncRequest, syncResponse);
        Assertions.assertTrue(syncResponse.isSuccess());
        logger.info("----结束执行----{}------", "人员管理-全量同步");
    }

    /**
     * 基础资源->人员管理-人员图片上传
     *
     * <p>接口编号 evo_brm_050
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/person/upload/img
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("人员管理-人员图片上传")
    @Tag("基础资源")
    public void evo_brm_050_person_img() throws ClientException {
        logger.info("----开始执行----{}------", "人员管理-人员图片上传");
        // 新增
        IClient iClient = new DefaultClient();
        File file = new File(this.getClass().getResource("/2.jpg").getPath());
        BrmPersonUploadImgRequest uploadImgRequest = new BrmPersonUploadImgRequest(file);
        BrmPersonUploadImgResponse uploadImgResponse =
                iClient.doAction(uploadImgRequest, uploadImgRequest.getResponseClass());
        printLog(uploadImgRequest, uploadImgResponse);
        Assertions.assertTrue(uploadImgResponse.isSuccess());
        logger.info("----结束执行----{}------", "人员管理-人员图片上传");
    }
}
