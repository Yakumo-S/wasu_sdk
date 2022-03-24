package com.wasu;

import cn.binarywang.tools.generator.ChineseIDCardNumberGenerator;
import cn.binarywang.tools.generator.ChineseNameGenerator;
import com.wasu.hutool.core.date.DateUtil;
import com.wasu.hutool.core.lang.Console;
import com.wasu.hutool.core.util.RandomUtil;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
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
import com.wasu.model.v202010.card.BrmCardGenIdRequest;
import com.wasu.model.v202010.card.BrmCardGenIdResponse;
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
import org.junit.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 232676
 * @since 2020/10/21 16:39
 */
public class IccCardTest {

  private static Integer paperType = 111;
  private static Long departmentId = 1L;
  private static String car_prefix = "浙";
  private static String cardType = "0";
  private static String cardGory = "0";

  @BeforeClass
  public static void beforeClass() throws ClientException {
    Console.log("开始执行环境清理");
    IClient iClient = new DefaultClient();
    // 新增
    BrmPersonSyncRequest syncRequest = new BrmPersonSyncRequest();
    BrmPersonSyncResponse syncResponse =
        iClient.doAction(syncRequest, syncRequest.getResponseClass());
    Assert.assertTrue(syncResponse.isSuccess());
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
        Assert.assertTrue(delResponse.isSuccess());
      }
    }
    Console.log("结束执行环境清理");
  }

  @Before
  public void before() throws ClientException {}

  @After
  public void after() throws ClientException {
    IClient iClient = new DefaultClient();
    // 新增
    BrmPersonSyncRequest syncRequest = new BrmPersonSyncRequest();
    BrmPersonSyncResponse syncResponse =
        iClient.doAction(syncRequest, syncRequest.getResponseClass());
    Assert.assertTrue(syncResponse.isSuccess());
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
        Assert.assertTrue(delResponse.isSuccess());
      }
    }
  }

  /**
   * 卡片新增
   *
   * @throws ClientException
   */
  @Test
  public void cardAdd() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    String code = RandomUtil.randomNumbers(8);

    // 新增人员
    BrmCardAddRequest cardAddRequest =
        BrmCardAddRequest.builder()
            .startDate(DateUtil.now())
            .endDate(DateUtil.now())
            .cardNumber(code)
            .category(cardGory)
            .cardType(cardType)
            .departmentId(departmentId)
            .build();
    BrmCardAddResponse response =
        iClient.doAction(cardAddRequest, cardAddRequest.getResponseClass());
    Assert.assertTrue(response.isSuccess());
  }

  /**
   * 卡片批量新增
   *
   * @throws ClientException
   */
  @Test
  public void cardBatchAdd() throws ClientException {
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
    Assert.assertTrue(batchAddResponse.isSuccess());
  }

  /**
   * 卡片更新
   *
   * @throws ClientException
   */
  @Test
  public void cardUpdate() throws ClientException {
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

    Assert.assertTrue(cardUpdateResponse.isSuccess());
  }

  /**
   * 卡片详情
   *
   * @throws ClientException
   */
  @Test
  public void cardDetail() throws ClientException {
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
    // 查看详情
    BrmCardQueryRequest cardQueryRequest = new BrmCardQueryRequest(code);
    BrmCardQueryResponse cardQueryResponse =
        iClient.doAction(cardQueryRequest, cardQueryRequest.getResponseClass());

    Assert.assertTrue(cardQueryResponse.isSuccess());
  }

  /**
   * 卡片激活
   *
   * @throws ClientException
   */
  @Test
  public void cardActive() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    String code = RandomUtil.randomNumbers(8);
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String name = ChineseNameGenerator.getInstance().generate();

    // 产生ID
    BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
    BrmPersonGenIdResponse genIdResponse =
        iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
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

    Assert.assertTrue(activeResponse.isSuccess());
  }

  /**
   * 给注销卡、激活卡换卡
   *
   * <p>卡片替换
   *
   * @throws ClientException
   */
  @Test
  public void cardReplace() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    String code = RandomUtil.randomNumbers(8);
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String name = ChineseNameGenerator.getInstance().generate();

    // 产生ID
    BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
    BrmPersonGenIdResponse genIdResponse =
        iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
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

    Assert.assertTrue(replaceResponse.isSuccess());
  }
  /**
   * 卡片删除，> 满足换卡条件，卡片已绑定人员，卡片已激活
   *
   * @throws ClientException
   */
  @Test
  public void cardDel() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    String code = RandomUtil.randomNumbers(8);
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String name = ChineseNameGenerator.getInstance().generate();

    // 产生ID
    BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
    BrmPersonGenIdResponse genIdResponse =
        iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
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
    // 激活卡片
    //        BrmCardActiveRequest activeRequest =
    // BrmCardActiveRequest.builder().personId(genIdResponse.getData().getId()).startDate(DateUtil.now()).endDate(DateUtil.now()).cardNumber(code).category(cardGory).cardType(cardType).departmentId(departmentId).build();
    //        BrmCardActiveResponse activeResponse = iClient.doAction(activeRequest,
    // activeRequest.getResponseClass());
    //        Assert.assertTrue(activeResponse.isSuccess());
    List<Long> cardIds = new ArrayList<>();
    cardIds.add(cardAddResponse.getData().getId());
    BrmCardDelRequest delRequest = new BrmCardDelRequest();
    delRequest.setCardIds(cardIds);
    BrmCardDelResponse delResponse = iClient.doAction(delRequest, delRequest.getResponseClass());
    Assert.assertTrue(delResponse.isSuccess());
  }
  /**
   * 卡片挂失，只有已激活的卡片才能挂失
   *
   * @throws ClientException
   */
  @Test
  public void cardLose() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    String code = RandomUtil.randomNumbers(8);
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String name = ChineseNameGenerator.getInstance().generate();

    // 产生ID
    BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
    BrmPersonGenIdResponse genIdResponse =
        iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
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
    Assert.assertTrue(activeResponse.isSuccess());
    // 挂失卡片
    String newCode = RandomUtil.randomNumbers(8);
    List<Long> cardIds = new ArrayList<>();
    cardIds.add(cardAddResponse.getData().getId());
    BrmCardLoseRequest loseRequest = new BrmCardLoseRequest(cardIds);
    BrmCardLoseResponse loseResponse =
        iClient.doAction(loseRequest, loseRequest.getResponseClass());
    Assert.assertTrue(loseResponse.isSuccess());
  }

  /**
   * 卡片解挂，只有挂失的卡片才可以
   *
   * @throws ClientException
   */
  @Test
  public void cardRelieve() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    String code = RandomUtil.randomNumbers(8);
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String name = ChineseNameGenerator.getInstance().generate();

    // 产生ID
    BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
    BrmPersonGenIdResponse genIdResponse =
        iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
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
    Assert.assertTrue(activeResponse.isSuccess());
    // 挂失卡片
    String newCode = RandomUtil.randomNumbers(8);
    List<Long> cardIds = new ArrayList<>();
    cardIds.add(cardAddResponse.getData().getId());
    BrmCardLoseRequest loseRequest = new BrmCardLoseRequest(cardIds);
    BrmCardLoseResponse loseResponse =
        iClient.doAction(loseRequest, loseRequest.getResponseClass());
    // 解决挂失
    BrmCardRelieveRequest relieveRequest = new BrmCardRelieveRequest(cardIds);
    BrmCardRelieveResponse relieveResponse =
        iClient.doAction(relieveRequest, relieveRequest.getResponseClass());

    Assert.assertTrue(relieveResponse.isSuccess());
  }

  /**
   * 卡片回收，只有注销的卡才能回收
   *
   * <p>业务场景，换卡操作的时候，旧的卡被注销了，然后回收
   *
   * @throws ClientException
   */
  @Test
  public void cardCycle() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    String code = RandomUtil.randomNumbers(8);
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String name = ChineseNameGenerator.getInstance().generate();

    // 产生ID
    BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
    BrmPersonGenIdResponse genIdResponse =
        iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
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
    List<Long> cardIds = new ArrayList<>();
    cardIds.add(cardAddResponse.getData().getId());
    // 回收旧卡片
    BrmCardRecycleRequest recycleRequest = new BrmCardRecycleRequest(cardIds);
    BrmCardRecycleResponse recycleResponse =
        iClient.doAction(recycleRequest, recycleRequest.getResponseClass());

    Assert.assertTrue(recycleResponse.isSuccess());
  }

  /**
   * 卡片ID生成
   *
   * @throws ClientException
   */
  @Test
  public void cardGenId() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    String code = RandomUtil.randomNumbers(8);
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String name = ChineseNameGenerator.getInstance().generate();

    // 产生卡片ID
    BrmCardGenIdRequest genIdRequest = new BrmCardGenIdRequest();
    BrmCardGenIdResponse genIdResponse =
        iClient.doAction(genIdRequest, genIdRequest.getResponseClass());

    Assert.assertTrue(genIdResponse.isSuccess());
  }

  /**
   * 卡批量片ID生成
   *
   * @throws ClientException
   */
  @Test
  public void cardBatchGenId() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    String code = RandomUtil.randomNumbers(8);
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String name = ChineseNameGenerator.getInstance().generate();

    // 产生卡片ID
    BrmCardBatchGenIdRequest batchGenIdRequest = new BrmCardBatchGenIdRequest(6);
    BrmCardBatchGenIdResponse batchGenIdResponse =
        iClient.doAction(batchGenIdRequest, batchGenIdRequest.getResponseClass());

    Assert.assertTrue(batchGenIdResponse.isSuccess());
  }

  /**
   * 卡批量片ID生成
   *
   * @throws ClientException
   */
  @Test
  public void cardPage() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    String code = RandomUtil.randomNumbers(8);
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String name = ChineseNameGenerator.getInstance().generate();

    // 开始分页查询
    BrmCardPageRequest cardPageRequest = new BrmCardPageRequest();
    BrmCardPageResponse cardPageResponse =
        iClient.doAction(cardPageRequest, cardPageRequest.getResponseClass());
    if ("28110015".equalsIgnoreCase(cardPageResponse.getCode())) {
      return;
    }
    Assert.assertTrue(cardPageResponse.isSuccess());
  }

  /**
   * 卡批量片ID生成
   *
   * @throws ClientException
   */
  @Test
  public void cardSync() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    String code = RandomUtil.randomNumbers(8);
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String name = ChineseNameGenerator.getInstance().generate();

    // 全量同步
    BrmCardSyncRequest cardSyncRequest = new BrmCardSyncRequest();
    BrmCardSyncResponse cardSyncResponse =
        iClient.doAction(cardSyncRequest, cardSyncRequest.getResponseClass());

    Assert.assertTrue(cardSyncResponse.isSuccess());
  }
}
