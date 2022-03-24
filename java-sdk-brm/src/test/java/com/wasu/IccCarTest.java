package com.wasu;

import com.wasu.hutool.core.lang.Console;
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
import com.wasu.model.v202010.department.BrmDeptDeleteRequest;
import com.wasu.model.v202010.department.BrmDeptDeleteResponse;
import com.wasu.model.v202010.department.BrmDeptPageRequest;
import com.wasu.model.v202010.department.BrmDeptPageResponse;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 232676
 * @since 2020/10/21 16:39
 */
public class IccCarTest {

  private static String CAR_NUM = "浙A88888";
  private static Long DEPT_ID = 1L;

  @BeforeClass
  public static void beforeClass() throws ClientException {
    Console.log("开始执行环境清理");
    IClient iClient = new DefaultClient();
    // 执行分页 查询
    BrmCarSyncRequest syncRequest = new BrmCarSyncRequest();
    BrmCarSyncResponse syncResponse = iClient.doAction(syncRequest, syncRequest.getResponseClass());
    Assert.assertTrue(syncResponse.isSuccess());
    if (syncResponse.isSuccess()
        && syncResponse.getData() != null
        && syncResponse.getData().getPageData() != null) {
      List<BrmCarSyncResponse.CarSyncData> pages = syncResponse.getData().getPageData();
      if (pages != null && pages.size() > 0) {
        List<String> carCords = new ArrayList<>();
        for (BrmCarSyncResponse.CarSyncData cs : pages) {
          carCords.add(cs.getCarCode());
        }
        if (carCords.size() > 0) {
          // 开始删除
          BrmCarDelRequest delRequest = BrmCarDelRequest.builder().carCodeList(carCords).build();
          BrmCarDelResponse delResponse =
              iClient.doAction(delRequest, delRequest.getResponseClass());
        }
      }
    }
    Console.log("结束执行环境清理");
  }

  @Before
  public void before() throws ClientException {
    Console.log("单元执行结束清理环境开始");

    IClient iClient = new DefaultClient();
    // 执行分页 查询
    BrmCarSyncRequest syncRequest = new BrmCarSyncRequest();
    BrmCarSyncResponse syncResponse = iClient.doAction(syncRequest, syncRequest.getResponseClass());
    Assert.assertTrue(syncResponse.isSuccess());
    if (syncResponse.isSuccess()
        && syncResponse.getData() != null
        && syncResponse.getData().getPageData() != null) {
      List<BrmCarSyncResponse.CarSyncData> pages = syncResponse.getData().getPageData();
      if (pages != null && pages.size() > 0) {
        List<String> carCords = new ArrayList<>();
        for (BrmCarSyncResponse.CarSyncData cs : pages) {
          carCords.add(cs.getCarCode());
        }
        if (carCords.size() > 0) {
          // 开始删除
          BrmCarDelRequest delRequest = BrmCarDelRequest.builder().carCodeList(carCords).build();
          BrmCarDelResponse delResponse =
              iClient.doAction(delRequest, delRequest.getResponseClass());
        }
      }
    }
    Console.log("单元执行结束清理环境结束");
  }

  @After
  public void after() throws ClientException {
    IClient iClient = new DefaultClient();
    // 执行分页 查询
    BrmDeptPageRequest pageRequest = new BrmDeptPageRequest();
    pageRequest.setParentId(1L);
    Console.log(pageRequest);
    BrmDeptPageResponse response = iClient.doAction(pageRequest, pageRequest.getResponseClass());
    if (response.isSuccess()
        && response.getData() != null
        && response.getData().getPageData() != null) {
      List<BrmDeptPageResponse.DeptPageList> pages = response.getData().getPageData();
      if (pages != null && pages.size() > 0) {
        for (BrmDeptPageResponse.DeptPageList pg : pages) {
          BrmDeptDeleteRequest deleteRequest =
              BrmDeptDeleteRequest.builder().id(pg.getId()).service("evo-brm").build();
          BrmDeptDeleteResponse deleteResponse =
              iClient.doAction(deleteRequest, deleteRequest.getResponseClass());
        }
      }
    }
  }

  /**
   * 车辆新增
   *
   * @throws ClientException
   */
  @Test
  public void carAdd() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    BrmCarAddRequest request =
        BrmCarAddRequest.builder().departmentId(DEPT_ID).carNum(CAR_NUM).build();
    BrmCarAddResponse response = iClient.doAction(request, request.getResponseClass());
    Assert.assertTrue(response.isSuccess());
  }

  /**
   * 车辆新增
   *
   * @throws ClientException
   */
  @Test
  public void carUpdate() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();

    BrmCarAddRequest request =
        BrmCarAddRequest.builder().departmentId(DEPT_ID).carNum(CAR_NUM).build();
    BrmCarAddResponse response = iClient.doAction(request, request.getResponseClass());
    // 更新
    BrmCarPageRequest pageRequest = new BrmCarPageRequest();
    BrmCarPageResponse syncResponse = iClient.doAction(pageRequest, pageRequest.getResponseClass());
    Assert.assertTrue(syncResponse.isSuccess());
    List<BrmCarPageResponse.CarPageData> carPageData = syncResponse.getData().getPageData();
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
      Assert.assertTrue(updateResponse.isSuccess());
    }
  }

  /**
   * 车辆删除
   *
   * @throws ClientException
   */
  @Test
  public void carDel() throws ClientException {
    // 产生数据
    IClient iClient = new DefaultClient();
    BrmCarAddRequest request =
        BrmCarAddRequest.builder().departmentId(DEPT_ID).carNum(CAR_NUM).build();
    BrmCarAddResponse response = iClient.doAction(request, request.getResponseClass());
    Assert.assertTrue(response.isSuccess());
    List<String> carNums = new ArrayList<>();
    carNums.add(CAR_NUM);
    // 开始删除
    BrmCarDelRequest delRequest = BrmCarDelRequest.builder().carNumList(carNums).build();
    BrmCarDelResponse delResponse = iClient.doAction(delRequest, delRequest.getResponseClass());
    Assert.assertTrue(delResponse.isSuccess());
  }

  /**
   * 车辆查询
   *
   * @throws ClientException
   */
  @Test
  public void carQuery() throws ClientException {
    // 产生数据
    IClient iClient = new DefaultClient();
    BrmCarAddRequest request =
        BrmCarAddRequest.builder().departmentId(DEPT_ID).carNum(CAR_NUM).build();
    BrmCarAddResponse response = iClient.doAction(request, request.getResponseClass());
    Assert.assertTrue(response.isSuccess());
    // 更新
    BrmCarPageRequest pageRequest = new BrmCarPageRequest();
    BrmCarPageResponse syncResponse = iClient.doAction(pageRequest, pageRequest.getResponseClass());
    Assert.assertTrue(syncResponse.isSuccess());
    List<BrmCarPageResponse.CarPageData> carPageData = syncResponse.getData().getPageData();
    if (carPageData != null && carPageData.size() > 0) {
      // 开始查询
      BrmCarPageResponse.CarPageData data = carPageData.get(0);
      BrmCarQueryRequest delRequest = new BrmCarQueryRequest(data.getCarCode());
      BrmCarQueryResponse delResponse = iClient.doAction(delRequest, delRequest.getResponseClass());
      Assert.assertTrue(delResponse.isSuccess());
    }
  }

  /**
   * 批量新增
   *
   * @throws ClientException
   */
  @Test
  public void batchAdd() throws ClientException {
    // 产生数据
    IClient iClient = new DefaultClient();
    BrmCarBatchAddRequest.CarBatchAddData data = new BrmCarBatchAddRequest.CarBatchAddData();
    data.setCarNum(CAR_NUM);
    data.setDepartmentId(DEPT_ID);
    List<BrmCarBatchAddRequest.CarBatchAddData> carList = new ArrayList<>();
    carList.add(data);
    BrmCarBatchAddRequest batchAddRequest =
        BrmCarBatchAddRequest.builder().carList(carList).build();
    BrmCarBatchAddResponse batchAddResponse =
        iClient.doAction(batchAddRequest, batchAddRequest.getResponseClass());
    Assert.assertTrue(batchAddResponse.isSuccess());
  }

  /**
   * 分页查询
   *
   * @throws ClientException
   */
  @Test
  public void pageCar() throws ClientException {
    // 产生数据
    IClient iClient = new DefaultClient();

    BrmCarAddRequest request =
        BrmCarAddRequest.builder().departmentId(DEPT_ID).carNum(CAR_NUM).build();
    BrmCarAddResponse response = iClient.doAction(request, request.getResponseClass());
    // 开始查询
    BrmCarPageRequest pageRequest = new BrmCarPageRequest();
    BrmCarPageResponse syncResponse = iClient.doAction(pageRequest, pageRequest.getResponseClass());
    Assert.assertTrue(syncResponse.isSuccess());
  }

  /**
   * 批量新增
   *
   * @throws ClientException
   */
  @Test
  public void syncCar() throws ClientException {
    // 产生数据
    IClient iClient = new DefaultClient();
    BrmCarSyncRequest syncRequest = new BrmCarSyncRequest();
    BrmCarSyncResponse syncResponse = iClient.doAction(syncRequest, syncRequest.getResponseClass());
    Assert.assertTrue(syncResponse.isSuccess());
  }
}
