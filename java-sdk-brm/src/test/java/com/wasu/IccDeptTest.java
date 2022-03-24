package com.wasu;

import com.wasu.hutool.core.lang.Console;
import com.wasu.hutool.json.JSONUtil;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.model.v202010.department.BrmDeptAddRequest;
import com.wasu.model.v202010.department.BrmDeptAddResponse;
import com.wasu.model.v202010.department.BrmDeptBatchAddRequest;
import com.wasu.model.v202010.department.BrmDeptBatchAddResponse;
import com.wasu.model.v202010.department.BrmDeptDeleteRequest;
import com.wasu.model.v202010.department.BrmDeptDeleteResponse;
import com.wasu.model.v202010.department.BrmDeptGenIdRequest;
import com.wasu.model.v202010.department.BrmDeptGenIdResponse;
import com.wasu.model.v202010.department.BrmDeptPageRequest;
import com.wasu.model.v202010.department.BrmDeptPageResponse;
import com.wasu.model.v202010.department.BrmDeptQueryRequest;
import com.wasu.model.v202010.department.BrmDeptQueryResponse;
import com.wasu.model.v202010.department.BrmDeptTreeRequest;
import com.wasu.model.v202010.department.BrmDeptTreeResponse;
import com.wasu.model.v202010.department.BrmDeptUpdateRequest;
import com.wasu.model.v202010.department.BrmDeptUpdateResponse;
import com.wasu.model.v202010.department.DeptOperateLock;
import com.wasu.model.v202010.organization.BrmOrganizationAddRequest;
import com.wasu.model.v202010.organization.BrmOrganizationAddResponse;
import com.wasu.model.v202010.organization.BrmOrganizationBatchAddRequest;
import com.wasu.model.v202010.organization.BrmOrganizationBatchAddResponse;
import com.wasu.model.v202010.organization.BrmOrganizationDeleteRequest;
import com.wasu.model.v202010.organization.BrmOrganizationDeleteResponse;
import com.wasu.model.v202010.organization.BrmOrganizationPageRequest;
import com.wasu.model.v202010.organization.BrmOrganizationPageResponse;
import com.wasu.model.v202010.organization.BrmOrganizationSubSysPageRequest;
import com.wasu.model.v202010.organization.BrmOrganizationSubSysPageResponse;
import com.wasu.model.v202010.organization.BrmOrganizationSyncRequest;
import com.wasu.model.v202010.organization.BrmOrganizationSyncResponse;
import com.wasu.model.v202010.organization.BrmOrganizationUpdateLockRequest;
import com.wasu.model.v202010.organization.BrmOrganizationUpdateLockResponse;
import com.wasu.model.v202010.organization.BrmOrganizationUpdateRequest;
import com.wasu.model.v202010.organization.BrmOrganizationUpdateResponse;
import com.wasu.model.v202010.organization.OperateLock;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 232676
 * @since 2020/10/21 16:39
 */
public class IccDeptTest {

  @BeforeClass
  public static void beforeClass() throws ClientException {
    Console.log("开始执行环境清理");
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
    Console.log("结束执行环境清理");
  }

  @Before
  public void before() throws ClientException {
    System.out.println("执行前");
    IClient iClient = new DefaultClient();
    BrmOrganizationPageRequest request = new BrmOrganizationPageRequest();
    request.setOrgPreCode("001");
    System.out.println(JSONUtil.toJsonStr(request));
    BrmOrganizationPageResponse response = iClient.doAction(request, request.getResponseClass());
    if (response.isSuccess()
        && response.getData() != null
        && response.getData().getPageData() != null) {
      List<BrmOrganizationPageResponse.OrganPageList> pages = response.getData().getPageData();
      List<String> orgCodes = new ArrayList<>();
      for (BrmOrganizationPageResponse.OrganPageList list : pages) {
        orgCodes.add(list.getOrgCode());
      }
      BrmOrganizationDeleteRequest deleteRequest =
          BrmOrganizationDeleteRequest.builder().orgCodes(orgCodes).build();
      BrmOrganizationDeleteResponse deleteResponse =
          iClient.doAction(deleteRequest, deleteRequest.getResponseClass());
    }
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
   * 部门新增
   *
   * @throws ClientException
   */
  @Test
  public void deptAdd() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    BrmDeptAddRequest request = BrmDeptAddRequest.builder().name("复兴路1").parentId(1L).build();
    BrmDeptAddResponse response = iClient.doAction(request, request.getResponseClass());
    Assert.assertTrue(response.isSuccess());
  }

  /**
   * 部门批量新增
   *
   * @throws ClientException
   */
  @Test
  public void deptBatchAdd() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    List<BrmDeptBatchAddRequest.DeptInfo> departmentList = new ArrayList<>();
    BrmDeptBatchAddRequest.DeptInfo deptInfo = new BrmDeptBatchAddRequest.DeptInfo();
    deptInfo.setDepOperateLock(new DeptOperateLock());
    deptInfo.setId(2L);
    deptInfo.setParentId(1L);
    deptInfo.setName("批量添加1");
    departmentList.add(deptInfo);
    BrmDeptBatchAddRequest request =
        BrmDeptBatchAddRequest.builder().departmentList(departmentList).build();
    BrmDeptBatchAddResponse response = iClient.doAction(request, request.getResponseClass());
    Assert.assertTrue(response.isSuccess());
  }

  /**
   * 部门更新
   *
   * @throws ClientException
   */
  @Test
  public void deptUpdate() throws ClientException {
    // 产生数据
    IClient iClient = new DefaultClient();
    BrmDeptAddRequest request =
        BrmDeptAddRequest.builder().name("测试deptUpdate").parentId(1L).build();
    BrmDeptAddResponse response = iClient.doAction(request, request.getResponseClass());
    Assert.assertTrue(response.isSuccess());
    BrmDeptUpdateRequest updateRequest =
        BrmDeptUpdateRequest.builder()
            .id(response.getData().getId())
            .name("Update测试deptUpdate")
            .parentId(1L)
            .build();
    updateRequest.setMemo("更新");
    BrmDeptUpdateResponse updateResponse =
        iClient.doAction(updateRequest, updateRequest.getResponseClass());
    Assert.assertTrue(updateResponse.isSuccess());
  }

  /**
   * 部门删除
   *
   * @throws ClientException
   */
  @Test
  public void deptDelete() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    BrmDeptAddRequest request =
        BrmDeptAddRequest.builder().name("测试deptDelete").parentId(1L).build();
    BrmDeptAddResponse response = iClient.doAction(request, request.getResponseClass());
    Assert.assertTrue(response.isSuccess());
    // 删除信息
    BrmDeptDeleteRequest deleteRequest =
        BrmDeptDeleteRequest.builder().id(response.getData().getId()).service("evo-brm").build();
    BrmDeptDeleteResponse deleteResponse =
        iClient.doAction(deleteRequest, deleteRequest.getResponseClass());
    Assert.assertTrue(deleteResponse.isSuccess());
  }

  /**
   * 分页查询
   *
   * @throws ClientException
   */
  @Test
  public void deptPageQuery() throws ClientException {
    IClient iClient = new DefaultClient();
    // 产生数据
    // 执行分页 查询
    BrmDeptPageRequest pageRequest = new BrmDeptPageRequest();
    pageRequest.setParentId(1L);
    Console.log(pageRequest);
    BrmDeptPageResponse pageResponse =
        iClient.doAction(pageRequest, pageRequest.getResponseClass());
    Console.log(pageResponse);
    Assert.assertTrue(pageResponse.isSuccess());
  }

  /**
   * 部门查询
   *
   * @throws ClientException
   */
  @Test
  public void deptQuery() throws ClientException {
    IClient iClient = new DefaultClient();
    // 产生数据
    BrmDeptAddRequest request =
        BrmDeptAddRequest.builder().name("测试deptDelete").parentId(1L).build();
    BrmDeptAddResponse response = iClient.doAction(request, request.getResponseClass());
    // 执行查询
    BrmDeptQueryRequest queryRequest = new BrmDeptQueryRequest(response.getData().getId());
    BrmDeptQueryResponse queryResponse =
        iClient.doAction(queryRequest, queryRequest.getResponseClass());
    Assert.assertTrue(queryResponse.isSuccess());
  }

  /**
   * 部门查询
   *
   * @throws ClientException
   */
  @Test
  public void deptTree() throws ClientException {
    IClient iClient = new DefaultClient();
    // 产生数据
    BrmDeptAddRequest request =
        BrmDeptAddRequest.builder().name("测试deptDelete").parentId(1L).build();
    BrmDeptAddResponse response = iClient.doAction(request, request.getResponseClass());
    // 执行查询
    BrmDeptTreeRequest queryRequest = new BrmDeptTreeRequest();
    BrmDeptTreeResponse treeResponse =
        iClient.doAction(queryRequest, queryRequest.getResponseClass());
    Assert.assertTrue(treeResponse.isSuccess());
  }

  /**
   * 批量生成ID
   *
   * @throws ClientException
   */
  @Test
  public void deptBatchGenId() throws ClientException {
    IClient iClient = new DefaultClient();
    BrmDeptGenIdRequest genIdRequest = new BrmDeptGenIdRequest(2);
    BrmDeptGenIdResponse genIdResponse =
        iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
    Assert.assertTrue(genIdResponse.isSuccess());
  }

  /**
   * 组织更新
   *
   * @throws ClientException
   */
  @Test
  public void organUpdate() throws ClientException {
    IClient iClient = new DefaultClient();

    // 产生数据
    BrmOrganizationAddRequest request =
        BrmOrganizationAddRequest.builder()
            .orgPreCode("001")
            .orgName("南星桥")
            .orgType("subWey")
            .operateLock(new OperateLock())
            .build();
    BrmOrganizationAddResponse response = iClient.doAction(request, request.getResponseClass());
    // 执行更新
    BrmOrganizationUpdateRequest orgUpdate =
        BrmOrganizationUpdateRequest.builder()
            .orgCode(response.getData().getOrgCode())
            .orgName("市民中心")
            .orgType("realWayStation")
            .operateLock(new OperateLock())
            .build();
    orgUpdate.setCity("杭州");
    orgUpdate.setProvince("浙江省");
    orgUpdate.setCounty("江干区");
    System.out.println(JSONUtil.toJsonStr(orgUpdate));
    BrmOrganizationUpdateResponse orgResp =
        iClient.doAction(orgUpdate, orgUpdate.getResponseClass());
    Assert.assertTrue(orgResp.isSuccess());
  }

  /**
   * 组织删除
   *
   * @throws ClientException
   */
  @Test
  public void organDel() throws ClientException {
    IClient iClient = new DefaultClient();

    // 产生数据
    BrmOrganizationAddRequest request =
        BrmOrganizationAddRequest.builder()
            .orgPreCode("001")
            .orgName("南星桥")
            .orgType("subWey")
            .operateLock(new OperateLock())
            .build();
    BrmOrganizationAddResponse response = iClient.doAction(request, request.getResponseClass());
    // 执行删除
    List<String> orgCodes = new ArrayList<>();
    orgCodes.add(response.getData().getOrgCode());
    BrmOrganizationDeleteRequest deleteRequest =
        BrmOrganizationDeleteRequest.builder().orgCodes(orgCodes).build();
    BrmOrganizationDeleteResponse deleteResponse =
        iClient.doAction(deleteRequest, deleteRequest.getResponseClass());
    Assert.assertTrue(deleteResponse.isSuccess());
  }

  /**
   * 批量添加组织
   *
   * @throws ClientException
   */
  @Test
  public void organBatchAdd() throws ClientException {
    IClient iClient = new DefaultClient();
    BrmOrganizationBatchAddRequest.OrgBath batch = new BrmOrganizationBatchAddRequest.OrgBath();
    batch.setOrgPreCode("001");
    batch.setOrgName("长河站");
    batch.setOperateLock(new OperateLock());
    batch.setOrgType("subwey");
    List<BrmOrganizationBatchAddRequest.OrgBath> orgList = new ArrayList<>();
    orgList.add(batch);
    BrmOrganizationBatchAddRequest request =
        BrmOrganizationBatchAddRequest.builder().orgList(orgList).build();
    BrmOrganizationBatchAddResponse response =
        iClient.doAction(request, request.getResponseClass());
    Assert.assertTrue(response.isSuccess());
    // After会清理环境
  }

  /**
   * 批量更新操作权限
   *
   * @throws ClientException
   */
  @Test
  public void organBatchUpdateOperateLock() throws ClientException {
    IClient iClient = new DefaultClient();

    // 产生数据
    BrmOrganizationAddRequest request =
        BrmOrganizationAddRequest.builder()
            .orgPreCode("001")
            .orgName("南星桥")
            .orgType("subWey")
            .operateLock(new OperateLock())
            .build();
    BrmOrganizationAddResponse response = iClient.doAction(request, request.getResponseClass());

    // 更新权限
    OperateLock operateLock = new OperateLock();
    operateLock.setAddDevice(1);
    List<String> orgCodes = new ArrayList<>();
    orgCodes.add(response.getData().getOrgCode());
    BrmOrganizationUpdateLockRequest lockRequest =
        BrmOrganizationUpdateLockRequest.builder()
            .service("api")
            .operateLock(operateLock)
            .orgCodes(orgCodes)
            .build();
    BrmOrganizationUpdateLockResponse lockResponse =
        iClient.doAction(lockRequest, lockRequest.getResponseClass());
    Assert.assertTrue(lockResponse.isSuccess());
  }

  /**
   * 全量同步查询
   *
   * @throws ClientException
   */
  @Test
  public void organPageSync() throws ClientException {
    IClient iClient = new DefaultClient();
    // 产生数据
    BrmOrganizationAddRequest request =
        BrmOrganizationAddRequest.builder()
            .orgPreCode("001")
            .orgName("南星桥")
            .orgType("subWey")
            .operateLock(new OperateLock())
            .build();
    request.setService("杭州");
    Console.log(request);
    BrmOrganizationAddResponse response = iClient.doAction(request, request.getResponseClass());
    Assert.assertTrue(response.isSuccess());

    // 执行分页 查询
    BrmOrganizationSyncRequest pageRequest =
        BrmOrganizationSyncRequest.builder().maxRangeId(1000L).build();
    Console.log(pageRequest);
    BrmOrganizationSyncResponse pageResponse =
        iClient.doAction(pageRequest, pageRequest.getResponseClass());
    Console.log(pageResponse);
    Assert.assertTrue(pageResponse.isSuccess());
  }

  /**
   * 全量同步查询
   *
   * @throws ClientException
   */
  @Test
  public void organSubSysPage() throws ClientException {
    IClient iClient = new DefaultClient();
    // 产生数据
    BrmOrganizationAddRequest request =
        BrmOrganizationAddRequest.builder()
            .orgPreCode("001")
            .orgName("南星桥")
            .orgType("subWey")
            .operateLock(new OperateLock())
            .build();
    request.setService("杭州");
    Console.log(request);
    BrmOrganizationAddResponse response = iClient.doAction(request, request.getResponseClass());
    Assert.assertTrue(response.isSuccess());

    // 执行分页 查询
    BrmOrganizationSubSysPageRequest pageRequest = new BrmOrganizationSubSysPageRequest();
    Console.log(pageRequest);
    BrmOrganizationSubSysPageResponse pageResponse =
        iClient.doAction(pageRequest, pageRequest.getResponseClass());
    Console.log(pageResponse);
    Assert.assertTrue(pageResponse.isSuccess());
  }
}
