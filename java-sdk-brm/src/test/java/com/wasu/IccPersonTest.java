package com.wasu;

import cn.binarywang.tools.generator.ChineseIDCardNumberGenerator;
import cn.binarywang.tools.generator.ChineseNameGenerator;
import com.wasu.hutool.core.date.DateUtil;
import com.wasu.hutool.core.lang.Console;
import com.wasu.hutool.core.util.RandomUtil;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.model.v202010.person.BrmPersonAddRequest;
import com.wasu.model.v202010.person.BrmPersonAddResponse;
import com.wasu.model.v202010.person.BrmPersonBatchAddRequest;
import com.wasu.model.v202010.person.BrmPersonBatchAddResponse;
import com.wasu.model.v202010.person.BrmPersonBatchUpdateImgRequest;
import com.wasu.model.v202010.person.BrmPersonBatchUpdateImgResponse;
import com.wasu.model.v202010.person.BrmPersonCar;
import com.wasu.model.v202010.person.BrmPersonCard;
import com.wasu.model.v202010.person.BrmPersonDelRequest;
import com.wasu.model.v202010.person.BrmPersonDelResponse;
import com.wasu.model.v202010.person.BrmPersonGenIdRequest;
import com.wasu.model.v202010.person.BrmPersonGenIdResponse;
import com.wasu.model.v202010.person.BrmPersonOnceRequest;
import com.wasu.model.v202010.person.BrmPersonOnceResponse;
import com.wasu.model.v202010.person.BrmPersonPageRequest;
import com.wasu.model.v202010.person.BrmPersonPageResponse;
import com.wasu.model.v202010.person.BrmPersonQueryByIdCardRequest;
import com.wasu.model.v202010.person.BrmPersonQueryByIdCardResponse;
import com.wasu.model.v202010.person.BrmPersonQueryRequest;
import com.wasu.model.v202010.person.BrmPersonQueryResponse;
import com.wasu.model.v202010.person.BrmPersonSyncRequest;
import com.wasu.model.v202010.person.BrmPersonSyncResponse;
import com.wasu.model.v202010.person.BrmPersonUpdateRequest;
import com.wasu.model.v202010.person.BrmPersonUpdateResponse;
import com.wasu.model.v202010.person.BrmPersonUploadImgRequest;
import com.wasu.model.v202010.person.BrmPersonUploadImgResponse;
import com.wasu.model.v202010.person.PersonBioSignatures;
import com.wasu.model.v202010.person.PersonData;
import com.wasu.model.v202010.person.PersonDepartment;
import org.junit.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 232676
 * @since 2020/10/21 16:39
 */
public class IccPersonTest {

  private static Integer paperType = 111;
  private static Long departmentId = 1L;
  private static String car_prefix = "浙";

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
   * 人员新增
   *
   * @throws ClientException
   */
  @Test
  public void personAdd() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String code = RandomUtil.randomString(6);
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
    Assert.assertTrue(response.isSuccess());
  }

  /**
   * 人员批量新增
   *
   * @throws ClientException
   */
  @Test
  public void personBatchAdd() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String code = RandomUtil.randomString(6);
    String name = ChineseNameGenerator.getInstance().generate();
    // 产生ID
    BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
    BrmPersonGenIdResponse genIdResponse =
        iClient.doAction(genIdRequest, genIdRequest.getResponseClass());

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
    Assert.assertTrue(batchAddResponse.isSuccess());
  }

  /**
   * 人员详情查看
   *
   * @throws ClientException
   */
  @Test
  public void personDetail() throws ClientException {

    IClient iClient = new DefaultClient();
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String code = RandomUtil.randomString(6);
    String name = ChineseNameGenerator.getInstance().generate();
    // 产生ID
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
    addRequest.setPaperNumber(ChineseIDCardNumberGenerator.getInstance().generate());
    BrmPersonAddResponse addResponse = iClient.doAction(addRequest, addRequest.getResponseClass());
    Assert.assertTrue(addResponse.isSuccess());
    // 查询
    BrmPersonQueryRequest queryRequest = new BrmPersonQueryRequest(addResponse.getData().getId());
    BrmPersonQueryResponse queryResponse =
        iClient.doAction(queryRequest, queryRequest.getResponseClass());
    Assert.assertTrue(queryResponse.isSuccess());
  }

  /**
   * 人员详情查看-身份证
   *
   * @throws ClientException
   */
  @Test
  public void personDetailByIdCard() throws ClientException {

    IClient iClient = new DefaultClient();
    // 产生ID
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String code = RandomUtil.randomString(6);
    String name = ChineseNameGenerator.getInstance().generate();

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
    Assert.assertTrue(addResponse.isSuccess());
    // 查询
    BrmPersonQueryByIdCardRequest idCardRequest = new BrmPersonQueryByIdCardRequest(idCard);
    BrmPersonQueryByIdCardResponse idCardResponse =
        iClient.doAction(idCardRequest, idCardRequest.getResponseClass());
    Assert.assertTrue(idCardResponse.isSuccess());
  }

  /**
   * 人员ID生成
   *
   * @throws ClientException
   */
  @Test
  public void personGenId() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
    BrmPersonGenIdResponse genIdResponse =
        iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
    Assert.assertTrue(genIdResponse.isSuccess());
  }

  /**
   * 文件上传
   *
   * @throws ClientException
   */
  @Test
  public void personUploadImg() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    File file = new File(this.getClass().getResource("/2.jpg").getPath());
    BrmPersonUploadImgRequest uploadImgRequest = new BrmPersonUploadImgRequest(file);
    BrmPersonUploadImgResponse uploadImgResponse =
        iClient.doAction(uploadImgRequest, uploadImgRequest.getResponseClass());
    Assert.assertTrue(uploadImgResponse.isSuccess());
  }

  /**
   * 人员ID删除
   *
   * @throws ClientException
   */
  @Test
  public void personDel() throws ClientException {
    IClient iClient = new DefaultClient();

    // 新增
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String code = RandomUtil.randomString(6);
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

    List<Long> ids = new ArrayList<>();
    ids.add(response.getData().getId());
    BrmPersonDelRequest delRequest = BrmPersonDelRequest.builder().ids(ids).build();
    BrmPersonDelResponse delResponse = iClient.doAction(delRequest, delRequest.getResponseClass());
    Assert.assertTrue(delResponse.isSuccess());
  }

  /**
   * 人员全量同步
   *
   * @throws ClientException
   */
  @Test
  public void personSync() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    BrmPersonSyncRequest syncRequest = new BrmPersonSyncRequest();
    BrmPersonSyncResponse syncResponse =
        iClient.doAction(syncRequest, syncRequest.getResponseClass());
    Assert.assertTrue(syncResponse.isSuccess());
  }

  /**
   * 人员分页查询
   *
   * @throws ClientException
   */
  @Test
  public void personPage() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    List<Integer> status = new ArrayList<>();
    status.add(0);
    BrmPersonPageRequest pageRequest = BrmPersonPageRequest.builder().statusList(status).build();

    BrmPersonPageResponse pageResponse =
        iClient.doAction(pageRequest, pageRequest.getResponseClass());
    Assert.assertTrue(pageResponse.isSuccess());
  }

  /**
   * 人员分页查询
   *
   * @throws ClientException
   */
  @Test
  public void personSaveOnce() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    // 产生ID
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String code = RandomUtil.randomString(6);
    String name = ChineseNameGenerator.getInstance().generate();
    BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
    BrmPersonGenIdResponse genIdResponse =
        iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
    // 新增人员
    BrmPersonOnceRequest onceRequest =
        BrmPersonOnceRequest.builder()
            .code(code)
            .id(genIdResponse.getData().getId())
            .name(name)
            .paperType(paperType)
            .build();
    onceRequest.setPaperNumber(idCard);
    // 设置车辆
    List<BrmPersonCar> cars = new ArrayList<>();
    BrmPersonCar car =
        BrmPersonCar.builder()
            .carNum(car_prefix + RandomUtil.randomString(6).toUpperCase())
            .build();
    car.setCarType("12");
    cars.add(car);
    onceRequest.setCars(cars);
    // 设置卡片
    List<BrmPersonCard> cards = new ArrayList<>();
    BrmPersonCard card =
        BrmPersonCard.builder()
            .cardNumber(RandomUtil.randomNumbers(6))
            .category("0")
            .endDate(DateUtil.now())
            .startDate(DateUtil.now())
            .departmentId(departmentId)
            .build();
    cards.add(card);
    onceRequest.setCards(cards);
    List<PersonDepartment> departments = new ArrayList<>();
    PersonDepartment department = new PersonDepartment(1L, 1);
    departments.add(department);
    onceRequest.setDepartmentList(departments);
    List<PersonBioSignatures> personBioSignatures = new ArrayList<>();
    PersonBioSignatures signatures = new PersonBioSignatures();
    signatures.setType(3);
    signatures.setPath(
        "71f193ee-b2cb-11ea-a94e-000af7e4d68a/20201109/1/a84832f0-227d-11eb-9cff-000af7e4d68a.jpg");
    personBioSignatures.add(signatures);
    onceRequest.setPersonBiosignatures(personBioSignatures);
    onceRequest.setService("brm");
    BrmPersonOnceResponse onceResponse =
        iClient.doAction(onceRequest, onceRequest.getResponseClass());
    Assert.assertTrue(onceResponse.isSuccess());
  }

  /**
   * 批量更新人员照片
   *
   * @throws ClientException
   */
  @Test
  public void personUpdateImg() throws ClientException {
    IClient iClient = new DefaultClient();
    // 新增
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String code = RandomUtil.randomString(6);
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

    List<PersonBioSignatures> personBiosignatures = new ArrayList<>();
    PersonBioSignatures signatures = new PersonBioSignatures();
    signatures.setPath(
        "71f193ee-b2cb-11ea-a94e-000af7e4d68a/20201109/1/f5259745-227d-11eb-9cff-000af7e4d68a.jpg");
    signatures.setType(3);
    signatures.setIndex(1);
    signatures.setPersonId(response.getData().getId());
    personBiosignatures.add(signatures);
    BrmPersonBatchUpdateImgRequest batchUpdateImgRequest =
        BrmPersonBatchUpdateImgRequest.builder().personBiosignatures(personBiosignatures).build();

    BrmPersonBatchUpdateImgResponse batchUpdateImgResponse =
        iClient.doAction(batchUpdateImgRequest, batchUpdateImgRequest.getResponseClass());
    Assert.assertTrue(batchUpdateImgResponse.isSuccess());
  }

  /**
   * 人员更新
   *
   * @throws ClientException
   */
  @Test
  public void personUpdate() throws ClientException {
    IClient iClient = new DefaultClient();
    // 新增
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String code = RandomUtil.randomString(6);
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

    BrmPersonUpdateRequest updateRequest =
        BrmPersonUpdateRequest.builder()
            .departmentId(departmentId)
            .paperType(paperType)
            .paperNumber(idCard)
            .code(code)
            .name(name)
            .id(response.getData().getId())
            .build();
    updateRequest.setPhone("13282821333");
    BrmPersonUpdateResponse updateResponse =
        iClient.doAction(updateRequest, updateRequest.getResponseClass());

    Assert.assertTrue(updateResponse.isSuccess());
  }
}
