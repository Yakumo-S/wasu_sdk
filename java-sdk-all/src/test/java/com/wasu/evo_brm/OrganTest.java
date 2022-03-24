package com.wasu.evo_brm;

import com.wasu.hutool.core.lang.Console;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.ExtentUtils;
import com.wasu.model.v202010.organization.BrmOrganizationAddRequest;
import com.wasu.model.v202010.organization.BrmOrganizationAddResponse;
import com.wasu.model.v202010.organization.BrmOrganizationBatchAddRequest;
import com.wasu.model.v202010.organization.BrmOrganizationBatchAddResponse;
import com.wasu.model.v202010.organization.BrmOrganizationDeleteRequest;
import com.wasu.model.v202010.organization.BrmOrganizationDeleteResponse;
import com.wasu.model.v202010.organization.BrmOrganizationQueryRequest;
import com.wasu.model.v202010.organization.BrmOrganizationQueryResponse;
import com.wasu.model.v202010.organization.BrmOrganizationSubSysPageRequest;
import com.wasu.model.v202010.organization.BrmOrganizationSubSysPageResponse;
import com.wasu.model.v202010.organization.BrmOrganizationSyncRequest;
import com.wasu.model.v202010.organization.BrmOrganizationSyncResponse;
import com.wasu.model.v202010.organization.BrmOrganizationUpdateLockRequest;
import com.wasu.model.v202010.organization.BrmOrganizationUpdateLockResponse;
import com.wasu.model.v202010.organization.BrmOrganizationUpdateRequest;
import com.wasu.model.v202010.organization.BrmOrganizationUpdateResponse;
import com.wasu.model.v202010.organization.OperateLock;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 232676
 * @since 2020/10/21 16:39
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrganTest extends ExtentUtils {
  private static final String SYSTEM_NAME = "evo-brm";
  private static String orgName = "junit5组织";
  private static String orgNameUpdate = "junit5组织更新";

  private static String orgType = "subWey";

  private static String orgPreCode = "001";
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
    BrmOrganizationSubSysPageRequest pageRequest = new BrmOrganizationSubSysPageRequest();
    pageRequest.setPageSize(100);
    BrmOrganizationSubSysPageResponse pageResponse =
        iClient.doAction(pageRequest, pageRequest.getResponseClass());
    printLog(pageRequest, pageResponse);
    if (pageResponse.isSuccess()
        && pageResponse.getData() != null
        && pageResponse.getData().getPageData() != null) {
      List<BrmOrganizationSubSysPageResponse.OrganPageList> pages =
          pageResponse.getData().getPageData();
      if (pages != null && pages.size() > 0) {
        for (BrmOrganizationSubSysPageResponse.OrganPageList pg : pages) {
          if (pg.getOrgName().equals(orgName)) {
            BrmOrganizationDeleteRequest deleteRequest =
                BrmOrganizationDeleteRequest.builder()
                    .orgCodes(Stream.of(pg.getOrgCode()).collect(Collectors.toList()))
                    .build();
            BrmOrganizationDeleteResponse deleteResponse =
                iClient.doAction(deleteRequest, deleteRequest.getResponseClass());
            printLog(deleteRequest, deleteResponse);
          }
        }
      }
    }
  }
  /**
   * 基础资源->组织管理-新增
   *
   * <p>接口编号 evo_brm_010
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/organization/add
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("组织管理-新增")
  @Tag("基础资源")
  public void evo_brm_010_organ_add() throws ClientException {
    logger.info("----开始执行----{}------", "组织管理-新增");
    IClient iClient = new DefaultClient();
    // 产生数据
    BrmOrganizationAddRequest request =
        BrmOrganizationAddRequest.builder()
            .orgPreCode(orgPreCode)
            .orgName(orgName)
            .orgType(orgType)
            .operateLock(new OperateLock())
            .build();
    BrmOrganizationAddResponse response = iClient.doAction(request, request.getResponseClass());
    Assertions.assertTrue(response.isSuccess());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "组织管理-新增");
  }
  /**
   * 基础资源->组织管理-更新
   *
   * <p>接口编号 evo_brm_011
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/organization/update
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("组织管理-更新")
  @Tag("基础资源")
  public void evo_brm_011_organ_update() throws ClientException {
    logger.info("----开始执行----{}------", "组织管理-更新");

    IClient iClient = new DefaultClient();
    // 产生数据
    BrmOrganizationAddRequest request =
        BrmOrganizationAddRequest.builder()
            .orgPreCode(orgPreCode)
            .orgName(orgName)
            .orgType(orgType)
            .operateLock(new OperateLock())
            .build();
    BrmOrganizationAddResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 执行更新
    BrmOrganizationUpdateRequest orgUpdate =
        BrmOrganizationUpdateRequest.builder()
            .orgCode(response.getData().getOrgCode())
            .orgName(orgName)
            .orgType(orgType)
            .operateLock(new OperateLock())
            .build();
    orgUpdate.setCity("杭州");
    orgUpdate.setProvince("浙江省");
    orgUpdate.setCounty("江干区");
    BrmOrganizationUpdateResponse orgResp =
        iClient.doAction(orgUpdate, orgUpdate.getResponseClass());
    printLog(orgUpdate, orgResp);
    Assertions.assertTrue(orgResp.isSuccess());
    logger.info("----结束执行----{}------", "组织管理-更新");
  }

  /**
   * 基础资源->组织管理-删除
   *
   * <p>接口编号 evo_brm_012
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/organization/delete
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("组织管理-删除")
  @Tag("基础资源")
  public void evo_brm_012_organ_delete() throws ClientException {
    logger.info("----开始执行----{}------", "组织管理-删除");
    IClient iClient = new DefaultClient();
    // 产生数据
    BrmOrganizationAddRequest request =
        BrmOrganizationAddRequest.builder()
            .orgPreCode(orgPreCode)
            .orgName(orgName)
            .orgType(orgType)
            .operateLock(new OperateLock())
            .build();
    BrmOrganizationAddResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());

    // 执行删除
    List<String> orgCodes = new ArrayList<>();
    orgCodes.add(response.getData().getOrgCode());
    BrmOrganizationDeleteRequest deleteRequest =
        BrmOrganizationDeleteRequest.builder().orgCodes(orgCodes).build();
    BrmOrganizationDeleteResponse deleteResponse =
        iClient.doAction(deleteRequest, deleteRequest.getResponseClass());
    printLog(deleteRequest, deleteResponse);
    Assertions.assertTrue(deleteResponse.isSuccess());
    logger.info("----结束执行----{}------", "组织管理-删除");
  }

  /**
   * 基础资源->组织管理-批量新增
   *
   * <p>接口编号 evo_brm_013
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/organization/delete
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("组织管理-批量新增")
  @Tag("基础资源")
  public void evo_brm_013_organ_batch_add() throws ClientException {
    logger.info("----开始执行----{}------", "组织管理-批量新增");
    IClient iClient = new DefaultClient();
    BrmOrganizationBatchAddRequest.OrgBath batch = new BrmOrganizationBatchAddRequest.OrgBath();

    batch.setOrgPreCode(orgPreCode);
    batch.setOrgName(orgName);
    batch.setOperateLock(new OperateLock());
    batch.setOrgType(orgType);
    List<BrmOrganizationBatchAddRequest.OrgBath> orgList = new ArrayList<>();
    orgList.add(batch);
    BrmOrganizationBatchAddRequest request =
        BrmOrganizationBatchAddRequest.builder().orgList(orgList).build();
    BrmOrganizationBatchAddResponse response =
        iClient.doAction(request, request.getResponseClass());
    Assertions.assertTrue(response.isSuccess());
    printLog(request, response);

    logger.info("----结束执行----{}------", "组织管理-批量新增");
  }

  /**
   * 基础资源->组织管理-全量同步
   *
   * <p>接口编号 evo_brm_014
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/organization/page
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("组织管理-全量同步")
  @Tag("基础资源")
  public void evo_brm_014_organ_sync() throws ClientException {
    logger.info("----开始执行----{}------", "组织管理-全量同步");
    IClient iClient = new DefaultClient();
    // 产生数据
    BrmOrganizationAddRequest request =
        BrmOrganizationAddRequest.builder()
            .orgPreCode(orgPreCode)
            .orgName(orgName)
            .orgType(orgType)
            .operateLock(new OperateLock())
            .build();
    request.setService(SYSTEM_NAME);
    BrmOrganizationAddResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 执行分页 查询
    BrmOrganizationSyncRequest pageRequest =
        BrmOrganizationSyncRequest.builder().maxRangeId(1000L).build();
    BrmOrganizationSyncResponse pageResponse =
        iClient.doAction(pageRequest, pageRequest.getResponseClass());
    printLog(pageRequest, pageResponse);
    Assertions.assertTrue(pageResponse.isSuccess());
    logger.info("----结束执行----{}------", "组织管理-全量同步");
  }
  /**
   * 基础资源->组织管理-分页查询
   *
   * <p>接口编号 evo_brm_015
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/organization/page
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("组织管理-分页查询")
  @Tag("基础资源")
  public void evo_brm_015_organ_sub_page() throws ClientException {
    logger.info("----开始执行----{}------", "组织管理-分页查询");
    IClient iClient = new DefaultClient();
    // 产生数据
    BrmOrganizationAddRequest request =
        BrmOrganizationAddRequest.builder()
            .orgPreCode(orgPreCode)
            .orgName(orgName)
            .orgType(orgType)
            .operateLock(new OperateLock())
            .build();
    request.setService(SYSTEM_NAME);
    BrmOrganizationAddResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 执行分页 查询
    BrmOrganizationSubSysPageRequest pageRequest = new BrmOrganizationSubSysPageRequest();
    Console.log(pageRequest);
    BrmOrganizationSubSysPageResponse pageResponse =
        iClient.doAction(pageRequest, pageRequest.getResponseClass());
    printLog(pageRequest, pageResponse);
    Assertions.assertTrue(pageResponse.isSuccess());
    logger.info("----结束执行----{}------", "组织管理-分页查询");
  }
  /**
   * 基础资源->组织管理-详情
   *
   * <p>接口编号 evo_brm_016
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/organization/{orgCode}
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("组织管理-详情")
  @Tag("基础资源")
  public void evo_brm_016_organ_detail() throws ClientException {
    logger.info("----开始执行----{}------", "组织管理-详情");
    IClient iClient = new DefaultClient();
    // 产生数据
    BrmOrganizationAddRequest request =
        BrmOrganizationAddRequest.builder()
            .orgPreCode(orgPreCode)
            .orgName(orgName)
            .orgType(orgType)
            .operateLock(new OperateLock())
            .build();
    request.setService(SYSTEM_NAME);
    BrmOrganizationAddResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 执行分页 查询
    BrmOrganizationQueryRequest queryRequest =
        new BrmOrganizationQueryRequest(response.getData().getOrgCode());
    BrmOrganizationQueryResponse queryResponse =
        iClient.doAction(queryRequest, queryRequest.getResponseClass());
    printLog(queryRequest, queryResponse);
    Assertions.assertTrue(queryResponse.isSuccess());
    logger.info("----结束执行----{}------", "组织管理-详情");
  }
  /**
   * 批量更新操作权限
   *
   * @throws ClientException
   */
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
    Assertions.assertTrue(lockResponse.isSuccess());
  }
}
