package com.wasu.evo_brm;

import com.wasu.hutool.core.util.RandomUtil;
import com.wasu.hutool.http.Method;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.model.v202010.GeneralRequest;
import com.wasu.model.v202010.GeneralResponse;
import com.wasu.profile.IccProfile;
import com.wasu.ExtentUtils;
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
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础资源-部门管理
 *
 * @author 232676
 * @since 2021/01/21 14:20
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DeptTest extends ExtentUtils {
  private static final String SYSTEM_NAME = "evo-brm";
  private static String orgName = "junit5部门";
  private static String deptName = "junit5部门";
  private static String deptMemo = "junit5-memo";

  private static String preCode = "001";
  private static Long parentDeptId = 1L;

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
    BrmDeptPageRequest pageRequest = new BrmDeptPageRequest();
    pageRequest.setParentId(parentDeptId);
    pageRequest.setPageSize(20);
    pageRequest.setSearchKey(deptName);
    BrmDeptPageResponse response = iClient.doAction(pageRequest, pageRequest.getResponseClass());
    printLog(pageRequest, response);
    if (response.isSuccess()
        && response.getData() != null
        && response.getData().getPageData() != null) {
      List<BrmDeptPageResponse.DeptPageList> pages = response.getData().getPageData();
      if (pages != null && pages.size() > 0) {
        for (BrmDeptPageResponse.DeptPageList pg : pages) {
          if (pg.getName().equals(deptName)) {
            BrmDeptDeleteRequest deleteRequest =
                BrmDeptDeleteRequest.builder().id(pg.getId()).service("evo-brm").build();
            BrmDeptDeleteResponse deleteResponse =
                iClient.doAction(deleteRequest, deleteRequest.getResponseClass());
            printLog(deleteRequest, deleteResponse);
          }
        }
      }
    }
  }
  /**
   * 基础资源->部门管理-新增
   *
   * <p>接口编号 evo_brm_001
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/department/subsystem/page
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("部门管理-新增")
  @Tag("基础资源")
  public void evo_brm_001_dept_add() throws ClientException {

    logger.info("----开始执行----{}------", "部门管理-新增");
    IClient iClient = new DefaultClient();
    BrmDeptAddRequest request =
        BrmDeptAddRequest.builder().name(deptName).parentId(parentDeptId).build();
    BrmDeptAddResponse response = iClient.doAction(request, request.getResponseClass());
    Assertions.assertTrue(response.isSuccess());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "部门管理-新增");
  }
  /**
   * 基础资源->部门管理-批量新增
   *
   * <p>接口编号 evo_brm_002
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/department/batch-add
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("部门管理-批量新增")
  @Tag("基础资源")
  public void evo_brm_002_dept_batch_add() throws ClientException {
    logger.info("----开始执行----{}------", "部门管理-批量新增");
    IClient iClient = new DefaultClient();
    // 产生部门ID
    BrmDeptGenIdRequest deptGenIdRequest = new BrmDeptGenIdRequest(1);
    BrmDeptGenIdResponse deptGenIdResponse =
        iClient.doAction(deptGenIdRequest, deptGenIdRequest.getResponseClass());
    printLog(deptGenIdRequest, deptGenIdResponse);
    Assertions.assertTrue(deptGenIdResponse.isSuccess());
    // 开始批量新增部门
    List<BrmDeptBatchAddRequest.DeptInfo> departmentList = new ArrayList<>();
    BrmDeptBatchAddRequest.DeptInfo deptInfo = new BrmDeptBatchAddRequest.DeptInfo();
    deptInfo.setDepOperateLock(new DeptOperateLock());
    deptInfo.setId(deptGenIdResponse.getData().getIdList().get(0));
    deptInfo.setParentId(parentDeptId);
    deptInfo.setName(deptName);
    departmentList.add(deptInfo);
    BrmDeptBatchAddRequest request =
        BrmDeptBatchAddRequest.builder().departmentList(departmentList).build();
    BrmDeptBatchAddResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "部门管理-批量新增");
  }

  /**
   * 基础资源->部门管理-更新
   *
   * <p>接口编号 evo_brm_003
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/department/update
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("部门管理-更新")
  @Tag("基础资源")
  public void evo_brm_003_dept_update() throws ClientException {
    logger.info("----开始执行----{}------", "部门管理-更新");
    IClient iClient = new DefaultClient();
    // 产生部门
    BrmDeptAddRequest request =
        BrmDeptAddRequest.builder().name(deptName).parentId(parentDeptId).build();
    BrmDeptAddResponse response = iClient.doAction(request, request.getResponseClass());
    Assertions.assertTrue(response.isSuccess());
    printLog(request, response);
    // 更新部分信息
    BrmDeptUpdateRequest updateRequest =
        BrmDeptUpdateRequest.builder()
            .id(response.getData().getId())
            .name(deptName)
            .parentId(parentDeptId)
            .build();
    updateRequest.setMemo(deptMemo);
    // TODO name,parentId是否真的必须
    BrmDeptUpdateResponse updateResponse =
        iClient.doAction(updateRequest, updateRequest.getResponseClass());
    printLog(updateRequest, updateResponse);
    Assertions.assertTrue(updateResponse.isSuccess());
    logger.info("----结束执行----{}------", "部门管理-更新");
  }

  /**
   * 基础资源->部门管理-删除
   *
   * <p>接口编号 evo_brm_004
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/department/delete
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("部门管理-删除")
  @Tag("基础资源")
  public void evo_brm_004_dept_delete() throws ClientException {
    logger.info("----开始执行----{}------", "部门管理-删除");
    // 新增
    IClient iClient = new DefaultClient();
    BrmDeptAddRequest request =
        BrmDeptAddRequest.builder().name(deptName).parentId(parentDeptId).build();
    BrmDeptAddResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 删除信息
    BrmDeptDeleteRequest deleteRequest =
        BrmDeptDeleteRequest.builder().id(response.getData().getId()).service(SYSTEM_NAME).build();
    BrmDeptDeleteResponse deleteResponse =
        iClient.doAction(deleteRequest, deleteRequest.getResponseClass());
    printLog(deleteRequest, deleteResponse);
    Assertions.assertTrue(deleteResponse.isSuccess());
    logger.info("----结束执行----{}------", "部门管理-删除");
  }

  /**
   * 基础资源->部门管理-分页查询
   *
   * <p>接口编号 evo_brm_005
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/department/page
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("部门管理-分页查询")
  @Tag("基础资源")
  public void evo_brm_005_dept_page() throws ClientException {
    logger.info("----开始执行----{}------", "部门管理-分页查询");
    IClient iClient = new DefaultClient();
    BrmDeptPageRequest pageRequest = new BrmDeptPageRequest();
    pageRequest.setParentId(parentDeptId);
    BrmDeptPageResponse pageResponse =
        iClient.doAction(pageRequest, pageRequest.getResponseClass());
    printLog(pageRequest, pageResponse);
    Assertions.assertTrue(pageResponse.isSuccess());
    logger.info("----结束执行----{}------", "部门管理-分页查询");
  }

  /**
   * 基础资源->部门管理-详情
   *
   * <p>接口编号 evo_brm_006
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/department/{id}
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("部门管理-详情")
  @Tag("基础资源")
  public void evo_brm_006_dept_detail() throws ClientException {
    logger.info("----开始执行----{}------", "部门管理-详情");
    IClient iClient = new DefaultClient();
    // 产生数据
    BrmDeptAddRequest request =
        BrmDeptAddRequest.builder().name(deptName).parentId(parentDeptId).build();
    BrmDeptAddResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    // 执行查询
    BrmDeptQueryRequest queryRequest = new BrmDeptQueryRequest(response.getData().getId());
    BrmDeptQueryResponse queryResponse =
        iClient.doAction(queryRequest, queryRequest.getResponseClass());
    printLog(queryRequest, queryResponse);
    Assertions.assertTrue(queryResponse.isSuccess());
    logger.info("----结束执行----{}------", "部门管理-详情");
  }

  /**
   * 基础资源->部门管理-部门树
   *
   * <p>接口编号 evo_brm_007
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/department/tree
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("部门管理-部门树")
  @Tag("基础资源")
  public void evo_brm_007_dept_tree() throws ClientException {
    logger.info("----开始执行----{}------", "部门管理-部门树");
    IClient iClient = new DefaultClient();
    // 产生数据
    BrmDeptAddRequest request =
        BrmDeptAddRequest.builder().name(deptName).parentId(parentDeptId).build();
    BrmDeptAddResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);

    // 执行查询
    BrmDeptTreeRequest queryRequest = new BrmDeptTreeRequest();
    queryRequest.setName(deptName);
    BrmDeptTreeResponse treeResponse =
        iClient.doAction(queryRequest, queryRequest.getResponseClass());
    printLog(queryRequest, treeResponse);
    Assertions.assertTrue(treeResponse.isSuccess());
    logger.info("----开始执行----{}------", "部门管理-部门树");
  }

  /**
   * 基础资源->部门管理-批量生成部门ID
   *
   * <p>接口编号 evo_brm_008
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/department/batch-generate-id
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("部门管理-批量生成部门ID")
  @Tag("基础资源")
  public void evo_brm_008_dept_batch_gen_id() throws ClientException {
    logger.info("----开始执行----{}------", "部门管理-批量生成部门ID");
    IClient iClient = new DefaultClient();
    BrmDeptGenIdRequest genIdRequest = new BrmDeptGenIdRequest(RandomUtil.randomInt(1, 3));
    BrmDeptGenIdResponse genIdResponse =
        iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
    printLog(genIdRequest, genIdResponse);
    Assertions.assertTrue(genIdResponse.isSuccess());
    logger.info("----开始执行----{}------", "部门管理-批量生成部门ID");
  }

  /**
   * 基础资源->部门管理-部门id
   *
   * <p>接口编号 evo_brm_009
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/department/update
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("部门管理-生成部门ID")
  @Tag("基础资源")
  public void evo_brm_009_dept_gen_id() throws ClientException {
    logger.info("----开始执行----{}------", "部门管理-生成部门ID");
    // 1、设置url版本
    String url = "/evo-apigw/evo-brm/%s/department/generate-id";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.GET);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----开始执行----{}------", "部门管理-生成部门ID");
  }
}
