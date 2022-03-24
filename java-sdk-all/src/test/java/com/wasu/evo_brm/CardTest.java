package com.wasu.evo_brm;


import cn.binarywang.tools.generator.ChineseIDCardNumberGenerator;
import cn.binarywang.tools.generator.ChineseNameGenerator;
import com.wasu.hutool.core.date.DateUtil;
import com.wasu.hutool.core.util.RandomUtil;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.ExtentUtils;
import com.wasu.model.v202010.card.BrmCard;
import com.wasu.model.v202010.card.BrmCardActiveRequest;
import com.wasu.model.v202010.card.BrmCardActiveResponse;
import com.wasu.model.v202010.card.BrmCardAddRequest;
import com.wasu.model.v202010.card.BrmCardAddResponse;
import com.wasu.model.v202010.card.BrmCardBatchAddRequest;
import com.wasu.model.v202010.card.BrmCardBatchAddResponse;
import com.wasu.model.v202010.card.BrmCardBatchGenIdRequest;
import com.wasu.model.v202010.card.BrmCardBatchGenIdResponse;
import com.wasu.model.v202010.card.BrmCardDelRequest;
import com.wasu.model.v202010.card.BrmCardDelResponse;
import com.wasu.model.v202010.card.BrmCardLoseRequest;
import com.wasu.model.v202010.card.BrmCardLoseResponse;
import com.wasu.model.v202010.card.BrmCardPageRequest;
import com.wasu.model.v202010.card.BrmCardPageResponse;
import com.wasu.model.v202010.card.BrmCardQueryRequest;
import com.wasu.model.v202010.card.BrmCardQueryResponse;
import com.wasu.model.v202010.card.BrmCardRecycleRequest;
import com.wasu.model.v202010.card.BrmCardRecycleResponse;
import com.wasu.model.v202010.card.BrmCardRelieveRequest;
import com.wasu.model.v202010.card.BrmCardRelieveResponse;
import com.wasu.model.v202010.card.BrmCardReplaceRequest;
import com.wasu.model.v202010.card.BrmCardReplaceResponse;
import com.wasu.model.v202010.card.BrmCardReturnRequest;
import com.wasu.model.v202010.card.BrmCardReturnResponse;
import com.wasu.model.v202010.card.BrmCardSyncRequest;
import com.wasu.model.v202010.card.BrmCardSyncResponse;
import com.wasu.model.v202010.card.BrmCardUpdateRequest;
import com.wasu.model.v202010.card.BrmCardUpdateResponse;
import com.wasu.model.v202010.person.BrmPersonAddRequest;
import com.wasu.model.v202010.person.BrmPersonAddResponse;
import com.wasu.model.v202010.person.BrmPersonDelRequest;
import com.wasu.model.v202010.person.BrmPersonDelResponse;
import com.wasu.model.v202010.person.BrmPersonGenIdRequest;
import com.wasu.model.v202010.person.BrmPersonGenIdResponse;
import com.wasu.model.v202010.person.BrmPersonSyncRequest;
import com.wasu.model.v202010.person.BrmPersonSyncResponse;
import com.wasu.model.v202010.person.PersonData;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 基础资源-卡片管理
 *
 * @author 237417
 * @since 2021/02/24
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CardTest extends ExtentUtils {

    private static Integer paperType = 111;
    private static Long departmentId = 1L;
    private static String car_prefix = "浙";
    private static String cardType = "0";
    private static String cardGory = "0";
//    private static String code = "88888888";


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
        // 执行人员分页 查询
        BrmPersonSyncRequest syncRequest = new BrmPersonSyncRequest();
        BrmPersonSyncResponse syncResponse =
                iClient.doAction(syncRequest, syncRequest.getResponseClass());
        printLog(syncRequest, syncResponse);
        List<PersonData> datas = syncResponse.getData().getPageData();
        if (datas != null && datas.size() > 0) {
            List<Long> ids = new ArrayList<>();
            for (PersonData pd : datas) {
                ids.add(pd.getId());
            }
            if (ids.size() > 0) {
                BrmPersonDelRequest delRequest = BrmPersonDelRequest.builder().ids(ids).build();
                BrmPersonDelResponse delResponse =
                        iClient.doAction(delRequest, delRequest.getResponseClass());
                printLog(delRequest, delResponse);
            }
        }
        // 执行分页 查询
//        BrmCardPageRequest pageRequest = new BrmCardPageRequest();
//        pageRequest.setPageSize(20);
//        BrmCardPageResponse response = iClient.doAction(pageRequest, pageRequest.getResponseClass());
//        printLog(pageRequest, response);
//        if (response.isSuccess()
//                && response.getData() != null
//                && response.getData().getPageData() != null) {
//            BrmCardPageResponse.CardPageData data = response.getData();
//            List<BrmCardPageDetail> pages = data.getPageData();
//            if (pages != null && pages.size() > 0) {
//                for (BrmCardPageDetail pg : pages) {
//                    if (pg.getCardNumber().equals(code)) {
//                        BrmCardDelRequest deleteRequest = new BrmCardDelRequest();
//                        deleteRequest.setCardIds(Stream.of(pg.getId()).collect(Collectors.toList()));
//                        BrmCardDelResponse deleteResponse =
//                                iClient.doAction(deleteRequest, deleteRequest.getResponseClass());
//                        printLog(deleteRequest, deleteResponse);
//                    }
//                }
//            }
//        }
    }

    /**
     * 基础资源->卡片管理-批量开卡
     *
     * <p>接口编号 evo_brm_051
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/%{version}/card/batch-add
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("卡片管理-批量开卡")
    @Tag("基础资源")
    public void evo_brm_051_card_batch_add() throws ClientException {

        logger.info("----开始执行----{}------", "卡片管理-批量开卡");
        // 新增
        IClient iClient = new DefaultClient();
        String code = RandomUtil.randomNumbers(8);
        List<BrmCard> cardList = new ArrayList<>();
        BrmCard card =
                BrmCard.builder()
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        cardList.add(card);
        // 批量新增
        BrmCardBatchAddRequest batchAddRequest =
                BrmCardBatchAddRequest.builder().cardList(cardList).build();
        BrmCardBatchAddResponse batchAddResponse =
                iClient.doAction(batchAddRequest, batchAddRequest.getResponseClass());
        printLog(batchAddRequest, batchAddResponse);
        Assertions.assertTrue(batchAddResponse.isSuccess());
        logger.info("----结束执行----{}------", "卡片管理-批量开卡");
    }

    /**
     * 基础资源->卡片管理-新增
     *
     * <p>接口编号 evo_brm_052
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/%{version}/card/add
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("卡片管理-新增")
    @Tag("基础资源")
    public void evo_brm_052_card_add() throws ClientException {

        logger.info("----开始执行----{}------", "卡片管理-新增");
        // 新增
        IClient iClient = new DefaultClient();
        String code = RandomUtil.randomNumbers(8);
        // 新增卡片
        BrmCardAddRequest request =
                BrmCardAddRequest.builder()
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardAddResponse response =
                iClient.doAction(request, request.getResponseClass());
        printLog(request, response);
        Assertions.assertTrue(response.isSuccess());
        logger.info("----结束执行----{}------", "卡片管理-新增");
    }


    /**
     * 基础资源->卡片管理-更新
     *
     * <p>接口编号 evo_brm_053
     *
     * <p>方法类型 put
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/card/update
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("卡片管理-更新")
    @Tag("基础资源")
    public void evo_brm_053_card_update() throws ClientException {
        logger.info("----开始执行----{}------", "卡片管理-更新");
        // 新增
        IClient iClient = new DefaultClient();
        String code = RandomUtil.randomNumbers(8);
        // 新增卡片
        BrmCardAddRequest cardAddRequest =
                BrmCardAddRequest.builder()
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardAddResponse cardAddResponse =
                iClient.doAction(cardAddRequest, cardAddRequest.getResponseClass());
        printLog(cardAddRequest, cardAddResponse);
        Assertions.assertTrue(cardAddResponse.isSuccess());
        // 更新卡片
        BrmCardUpdateRequest cardUpdateRequest =
                BrmCardUpdateRequest.builder()
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.formatDateTime(DateUtil.offsetDay(new Date(), 100)))
                        .departmentId(departmentId)
                        .cardNumber(code)
                        .build();
        BrmCardUpdateResponse cardUpdateResponse =
                iClient.doAction(cardUpdateRequest, cardUpdateRequest.getResponseClass());
        printLog(cardUpdateRequest, cardUpdateResponse);
        Assertions.assertTrue(cardUpdateResponse.isSuccess());
        logger.info("----结束执行----{}------", "卡片管理-更新");
    }

    /**
     * 基础资源->卡片管理-详情
     *
     * <p>接口编号 evo_brm_054
     *
     * <p>方法类型 get
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/card/{cardNumber}
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("卡片管理-详情")
    @Tag("基础资源")
    public void evo_brm_054_card_detail() throws ClientException {
        logger.info("----开始执行----{}------", "卡片管理-详情");
        // 新增
        IClient iClient = new DefaultClient();
        String code = RandomUtil.randomNumbers(8);
        // 新增卡片
        BrmCardAddRequest cardAddRequest =
                BrmCardAddRequest.builder()
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardAddResponse cardAddResponse =
                iClient.doAction(cardAddRequest, cardAddRequest.getResponseClass());
        printLog(cardAddRequest, cardAddResponse);
        Assertions.assertTrue(cardAddResponse.isSuccess());
        // 查看详情
        BrmCardQueryRequest cardQueryRequest = new BrmCardQueryRequest(code);
        BrmCardQueryResponse cardQueryResponse =
                iClient.doAction(cardQueryRequest, cardQueryRequest.getResponseClass());
        printLog(cardQueryRequest, cardQueryResponse);
        Assertions.assertTrue(cardQueryResponse.isSuccess());
        logger.info("----结束执行----{}------", "卡片管理-详情");
    }

    /**
     * 基础资源->卡片管理-激活
     *
     * <p>接口编号 evo_brm_055
     *
     * <p>方法类型 put
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/card/active
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("卡片管理-激活")
    @Tag("基础资源")
    public void evo_brm_055_card_active() throws ClientException {
        logger.info("----开始执行----{}------", "卡片管理-激活");
        // 新增
        IClient iClient = new DefaultClient();
        String code = RandomUtil.randomNumbers(8);
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        String name = ChineseNameGenerator.getInstance().generate();
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

        // 新增卡片
        BrmCardAddRequest cardAddRequest =
                BrmCardAddRequest.builder()
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardAddResponse cardAddResponse =
                iClient.doAction(cardAddRequest, cardAddRequest.getResponseClass());
        printLog(cardAddRequest, cardAddResponse);
        Assertions.assertTrue(cardAddResponse.isSuccess());

        // 激活卡片
        BrmCardActiveRequest activeRequest =
                BrmCardActiveRequest.builder()
                        .personId(genIdResponse.getData().getId())
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardActiveResponse activeResponse =
                iClient.doAction(activeRequest, activeRequest.getResponseClass());
        printLog(activeRequest, activeResponse);
        Assertions.assertTrue(activeResponse.isSuccess());
        logger.info("----结束执行----{}------", "卡片管理-激活");
    }

    /**
     * 基础资源->卡片管理-换卡
     *
     * <p>接口编号 evo_brm_056
     *
     * <p>方法类型 put
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/card/replace
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("卡片管理-换卡")
    @Tag("基础资源")
    public void evo_brm_056_card_replace() throws ClientException {
        logger.info("----开始执行----{}------", "卡片管理-换卡");
        // 新增
        IClient iClient = new DefaultClient();
        String code = RandomUtil.randomNumbers(8);
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        String name = ChineseNameGenerator.getInstance().generate();
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

        // 新增卡片
        BrmCardAddRequest cardAddRequest =
                BrmCardAddRequest.builder()
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardAddResponse cardAddResponse =
                iClient.doAction(cardAddRequest, cardAddRequest.getResponseClass());
        printLog(cardAddRequest, cardAddResponse);
        Assertions.assertTrue(cardAddResponse.isSuccess());

        // 激活卡片
        BrmCardActiveRequest activeRequest =
                BrmCardActiveRequest.builder()
                        .personId(genIdResponse.getData().getId())
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardActiveResponse activeResponse =
                iClient.doAction(activeRequest, activeRequest.getResponseClass());
        // 更换卡片
        String newCode = RandomUtil.randomNumbers(8);
        BrmCardReplaceRequest replaceRequest =
                BrmCardReplaceRequest.builder().cardNumber(code).newCardNumber(newCode).build();
        BrmCardReplaceResponse replaceResponse =
                iClient.doAction(replaceRequest, replaceRequest.getResponseClass());
        printLog(activeRequest, activeResponse);
        Assertions.assertTrue(activeResponse.isSuccess());
        logger.info("----结束执行----{}------", "卡片管理-换卡");
    }

    /**
     * 基础资源->卡片管理-批量退卡
     *
     * <p>接口编号 evo_brm_057
     *
     * <p>方法类型 put
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/card/return
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("卡片管理-批量退卡")
    @Tag("基础资源")
    public void evo_brm_057_card_return() throws ClientException {
        logger.info("----开始执行----{}------", "卡片管理-批量退卡");
        // 新增
        IClient iClient = new DefaultClient();
        String code = RandomUtil.randomNumbers(8);
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        String name = ChineseNameGenerator.getInstance().generate();
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

        // 新增卡片
        BrmCardAddRequest cardAddRequest =
                BrmCardAddRequest.builder()
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardAddResponse cardAddResponse =
                iClient.doAction(cardAddRequest, cardAddRequest.getResponseClass());
        printLog(cardAddRequest, cardAddResponse);
        Assertions.assertTrue(cardAddResponse.isSuccess());

        // 激活卡片
        BrmCardActiveRequest activeRequest =
                BrmCardActiveRequest.builder()
                        .personId(genIdResponse.getData().getId())
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardActiveResponse activeResponse =
                iClient.doAction(activeRequest, activeRequest.getResponseClass());
        printLog(activeRequest, activeResponse);
        Assertions.assertTrue(activeResponse.isSuccess());

        // 批量退卡
        List<Long> cardIds = new ArrayList<>();
        cardIds.add(cardAddResponse.getData().getId());
        BrmCardReturnRequest returnRequest = new BrmCardReturnRequest();
        returnRequest.setCardIds(cardIds);
        BrmCardReturnResponse delResponse = iClient.doAction(returnRequest, returnRequest.getResponseClass());
        printLog(returnRequest, delResponse);
        Assertions.assertTrue(delResponse.isSuccess());
        logger.info("----结束执行----{}------", "卡片管理-批量退卡");
    }

    /**
     * 基础资源->卡片管理-删除
     *
     * <p>接口编号 evo_brm_058
     *
     * <p>方法类型 delete
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/card/delete
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("卡片管理-删除")
    @Tag("基础资源")
    public void evo_brm_058_card_delete() throws ClientException {
        logger.info("----开始执行----{}------", "卡片管理-删除");
        // 新增
        IClient iClient = new DefaultClient();
        String code = RandomUtil.randomNumbers(8);
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        String name = ChineseNameGenerator.getInstance().generate();
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

        // 新增卡片
        BrmCardAddRequest cardAddRequest =
                BrmCardAddRequest.builder()
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardAddResponse cardAddResponse =
                iClient.doAction(cardAddRequest, cardAddRequest.getResponseClass());
        printLog(cardAddRequest, cardAddResponse);
        Assertions.assertTrue(cardAddResponse.isSuccess());

        // 删除卡片
        List<Long> cardIds = new ArrayList<>();
        cardIds.add(cardAddResponse.getData().getId());
        BrmCardDelRequest delRequest = new BrmCardDelRequest();
        delRequest.setCardIds(cardIds);
        BrmCardDelResponse delResponse = iClient.doAction(delRequest, delRequest.getResponseClass());
        printLog(delRequest, delResponse);
        Assertions.assertTrue(delResponse.isSuccess());
        logger.info("----结束执行----{}------", "卡片管理-删除");
    }

    /**
     * 基础资源->卡片管理-挂失
     *
     * <p>接口编号 evo_brm_059
     *
     * <p>方法类型 put
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/card/lose
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("卡片管理-挂失")
    @Tag("基础资源")
    public void evo_brm_059_card_lose() throws ClientException {
        logger.info("----开始执行----{}------", "卡片管理-挂失");
        // 新增
        IClient iClient = new DefaultClient();
        String code = RandomUtil.randomNumbers(8);
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        String name = ChineseNameGenerator.getInstance().generate();
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

        // 新增卡片
        BrmCardAddRequest cardAddRequest =
                BrmCardAddRequest.builder()
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardAddResponse cardAddResponse =
                iClient.doAction(cardAddRequest, cardAddRequest.getResponseClass());
        printLog(cardAddRequest, cardAddResponse);
        Assertions.assertTrue(cardAddResponse.isSuccess());

        // 激活卡片
        BrmCardActiveRequest activeRequest =
                BrmCardActiveRequest.builder()
                        .personId(genIdResponse.getData().getId())
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardActiveResponse activeResponse =
                iClient.doAction(activeRequest, activeRequest.getResponseClass());
        printLog(activeRequest, activeResponse);
        Assertions.assertTrue(activeResponse.isSuccess());

        // 挂失卡片
        String newCode = RandomUtil.randomNumbers(8);
        List<Long> cardIds = new ArrayList<>();
        cardIds.add(cardAddResponse.getData().getId());
        BrmCardLoseRequest loseRequest = new BrmCardLoseRequest(cardIds);
        BrmCardLoseResponse loseResponse =
                iClient.doAction(loseRequest, loseRequest.getResponseClass());
        printLog(loseRequest, loseResponse);
        Assertions.assertTrue(loseResponse.isSuccess());
        logger.info("----结束执行----{}------", "卡片管理-挂失");
    }


    /**
     * 基础资源->卡片管理-解挂
     *
     * <p>接口编号 evo_brm_060
     *
     * <p>方法类型 put
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/card/relieve
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("卡片管理-解挂")
    @Tag("基础资源")
    public void evo_brm_060_card_relieve() throws ClientException {
        logger.info("----开始执行----{}------", "卡片管理-解挂");
        // 新增
        IClient iClient = new DefaultClient();
        String code = RandomUtil.randomNumbers(8);
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        String name = ChineseNameGenerator.getInstance().generate();
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

        // 新增卡片
        BrmCardAddRequest cardAddRequest =
                BrmCardAddRequest.builder()
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardAddResponse cardAddResponse =
                iClient.doAction(cardAddRequest, cardAddRequest.getResponseClass());
        printLog(cardAddRequest, cardAddResponse);
        Assertions.assertTrue(cardAddResponse.isSuccess());

        // 激活卡片
        BrmCardActiveRequest activeRequest =
                BrmCardActiveRequest.builder()
                        .personId(genIdResponse.getData().getId())
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardActiveResponse activeResponse =
                iClient.doAction(activeRequest, activeRequest.getResponseClass());
        printLog(activeRequest, activeResponse);
        Assertions.assertTrue(activeResponse.isSuccess());

        // 挂失卡片
        String newCode = RandomUtil.randomNumbers(8);
        List<Long> cardIds = new ArrayList<>();
        cardIds.add(cardAddResponse.getData().getId());
        BrmCardLoseRequest loseRequest = new BrmCardLoseRequest(cardIds);
        BrmCardLoseResponse loseResponse =
                iClient.doAction(loseRequest, loseRequest.getResponseClass());
        printLog(loseRequest, loseResponse);
        Assertions.assertTrue(loseResponse.isSuccess());

        // 解决挂失
        BrmCardRelieveRequest relieveRequest = new BrmCardRelieveRequest(cardIds);
        BrmCardRelieveResponse relieveResponse =
                iClient.doAction(relieveRequest, relieveRequest.getResponseClass());
        printLog(relieveRequest, relieveResponse);
        Assertions.assertTrue(relieveResponse.isSuccess());

        logger.info("----结束执行----{}------", "卡片管理-解挂");
    }

    /**
     * 基础资源->卡片管理-回收
     *
     * <p>接口编号 evo_brm_061
     *
     * <p>方法类型 put
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/card/recycle
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("卡片管理-回收")
    @Tag("基础资源")
    public void evo_brm_061_card_recycle() throws ClientException {
        logger.info("----开始执行----{}------", "卡片管理-回收");
        // 新增
        IClient iClient = new DefaultClient();
        String code = RandomUtil.randomNumbers(8);
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        String name = ChineseNameGenerator.getInstance().generate();
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

        // 新增卡片
        BrmCardAddRequest cardAddRequest =
                BrmCardAddRequest.builder()
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardAddResponse cardAddResponse =
                iClient.doAction(cardAddRequest, cardAddRequest.getResponseClass());
        printLog(cardAddRequest, cardAddResponse);
        Assertions.assertTrue(cardAddResponse.isSuccess());

        // 激活卡片
        BrmCardActiveRequest activeRequest =
                BrmCardActiveRequest.builder()
                        .personId(genIdResponse.getData().getId())
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardActiveResponse activeResponse =
                iClient.doAction(activeRequest, activeRequest.getResponseClass());
        printLog(activeRequest, activeResponse);
        Assertions.assertTrue(activeResponse.isSuccess());

        // 更换卡片
        String newCode = RandomUtil.randomNumbers(8);

        BrmCardReplaceRequest replaceRequest =
                BrmCardReplaceRequest.builder().cardNumber(code).newCardNumber(newCode).build();
        BrmCardReplaceResponse replaceResponse =
                iClient.doAction(replaceRequest, replaceRequest.getResponseClass());
        printLog(replaceRequest, replaceResponse);
        Assertions.assertTrue(replaceResponse.isSuccess());
        List<Long> cardIds = new ArrayList<>();
        cardIds.add(cardAddResponse.getData().getId());

        // 回收旧卡片
        BrmCardRecycleRequest recycleRequest = new BrmCardRecycleRequest(cardIds);
        BrmCardRecycleResponse recycleResponse =
                iClient.doAction(recycleRequest, recycleRequest.getResponseClass());
        printLog(recycleRequest, recycleResponse);
        Assertions.assertTrue(recycleResponse.isSuccess());
        logger.info("----结束执行----{}------", "卡片管理-回收");
    }

    /**
     * 基础资源->卡片管理-全局ID生成
     *
     * <p>接口编号 evo_brm_062
     *
     * <p>方法类型 get
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/card/generate-id
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("卡片管理-全局ID生成")
    @Tag("基础资源")
    public void evo_brm_062_card_generate_id() throws ClientException {
        logger.info("----开始执行----{}------", "卡片管理-全局ID生成");
        IClient iClient = new DefaultClient();
        // 产生ID
        BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
        BrmPersonGenIdResponse genIdResponse =
                iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
        printLog(genIdRequest, genIdResponse);
        Assertions.assertTrue(genIdResponse.isSuccess());
        logger.info("----结束执行----{}------", "卡片管理-全局ID生成");
    }

    /**
     * 基础资源->卡片管理-全局ID批量生成
     *
     * <p>接口编号 evo_brm_063
     *
     * <p>方法类型 get
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/card/batch-generate-id
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("卡片管理-全局ID批量生成")
    @Tag("基础资源")
    public void evo_brm_063_card_batch_generate_id() throws ClientException {
        logger.info("----开始执行----{}------", "卡片管理-全局ID批量生成");
        IClient iClient = new DefaultClient();
        // 产生ID
        BrmCardBatchGenIdRequest batchGenIdRequest = new BrmCardBatchGenIdRequest(6);
        BrmCardBatchGenIdResponse batchGenIdResponse =
                iClient.doAction(batchGenIdRequest, batchGenIdRequest.getResponseClass());
        printLog(batchGenIdRequest, batchGenIdResponse);
        Assertions.assertTrue(batchGenIdResponse.isSuccess());
        logger.info("----结束执行----{}------", "卡片管理-全局ID批量生成");
    }



    /**
     * 基础资源->卡片管理-分页查询
     *
     * <p>接口编号 evo_brm_064
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/card/subsystem/page
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("卡片管理-分页查询")
    @Tag("基础资源")
    public void evo_brm_064_card_page() throws ClientException {
        logger.info("----开始执行----{}------", "卡片管理-分页查询");
        IClient iClient = new DefaultClient();
        BrmCardPageRequest pageRequest = new BrmCardPageRequest();
        BrmCardPageResponse pageResponse =
                iClient.doAction(pageRequest, pageRequest.getResponseClass());
        if ("28110015".equalsIgnoreCase(pageResponse.getCode())) {
            return;
        }
        printLog(pageRequest, pageResponse);
        Assertions.assertTrue(pageResponse.isSuccess());
        logger.info("----结束执行----{}------", "卡片管理-分页查询");
    }

    /**
     * 基础资源->卡片管理-全量同步
     *
     * <p>接口编号 evo_brm_065
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/card/page
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("卡片管理-全量同步")
    @Tag("基础资源")
    public void evo_brm_065_card_sync() throws ClientException {
        logger.info("----开始执行----{}------", "卡片管理-全量同步");
        IClient iClient = new DefaultClient();
        // 产生数据
        String code = RandomUtil.randomNumbers(8);
        // 新增卡片
        BrmCardAddRequest request =
                BrmCardAddRequest.builder()
                        .startDate(DateUtil.now())
                        .endDate(DateUtil.now())
                        .cardNumber(code)
                        .category(cardGory)
                        .cardType(cardType)
                        .departmentId(departmentId)
                        .build();
        BrmCardAddResponse response =
                iClient.doAction(request, request.getResponseClass());
        printLog(request, response);
        Assertions.assertTrue(response.isSuccess());
        // 执行分页 查询
        BrmCardSyncRequest cardSyncRequest = new BrmCardSyncRequest();
        BrmCardSyncResponse cardSyncResponse =
                iClient.doAction(cardSyncRequest, cardSyncRequest.getResponseClass());
        printLog(cardSyncRequest, cardSyncResponse);
        Assertions.assertTrue(cardSyncResponse.isSuccess());
        logger.info("----结束执行----{}------", "卡片管理-全量同步");
    }
}
