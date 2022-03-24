package com.wasu.evo_brm;

import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.ExtentUtils;
import com.wasu.model.v202010.role.BrmRoleAddRequest;
import com.wasu.model.v202010.role.BrmRoleAddResponse;
import com.wasu.model.v202010.role.BrmRoleDeleteRequest;
import com.wasu.model.v202010.role.BrmRoleDeleteResponse;
import com.wasu.model.v202010.role.BrmRoleDetailRequest;
import com.wasu.model.v202010.role.BrmRoleDetailResponse;
import com.wasu.model.v202010.role.BrmRolePageRequest;
import com.wasu.model.v202010.role.BrmRolePageResponse;
import com.wasu.model.v202010.role.BrmRoleSyncRequest;
import com.wasu.model.v202010.role.BrmRoleSyncResponse;
import com.wasu.model.v202010.role.BrmRoleUpdateRequest;
import com.wasu.model.v202010.role.BrmRoleUpdateResponse;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 基础资源-角色管理
 *
 * @author 237417
 * @since 2021/02/23
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RoleTest extends ExtentUtils {
    private static final String SYSTEM_NAME = "evo-brm";
    private static String roleName = "测试角色";
    private static Integer roleGrade = 1;
    private static String ownerCode = "001";

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
        BrmRolePageRequest pageRequest = new BrmRolePageRequest();
        pageRequest.setPageSize(20);
        BrmRolePageResponse response = iClient.doAction(pageRequest, pageRequest.getResponseClass());
        printLog(pageRequest, response);
        if (response.isSuccess()
                && response.getData() != null
                && response.getData().getPageData() != null) {
            List<BrmRolePageResponse.RolePageList> pages = response.getData().getPageData();
            if (pages != null && pages.size() > 0) {
                for (BrmRolePageResponse.RolePageList pg : pages) {
                    if (pg.getRoleName().equals(roleName)) {
                        BrmRoleDeleteRequest deleteRequest =
                                BrmRoleDeleteRequest.builder().ids(Stream.of(Long.parseLong(pg.getId())).collect(Collectors.toList())).build();
                        BrmRoleDeleteResponse deleteResponse =
                                iClient.doAction(deleteRequest, deleteRequest.getResponseClass());
                        printLog(deleteRequest, deleteResponse);
                    }
                }
            }
        }
    }

    /**
     * 基础资源->角色管理-新增
     *
     * <p>接口编号 evo_brm_032
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/%{version}/role
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("角色管理-新增")
    @Tag("基础资源")
    public void evo_brm_032_role_add() throws ClientException {

        logger.info("----开始执行----{}------", "角色管理-新增");
        IClient iClient = new DefaultClient();
        BrmRoleAddRequest request =
                BrmRoleAddRequest.builder().roleName(roleName).roleGrade(roleGrade).owenCode(ownerCode).build();
        BrmRoleAddResponse response = iClient.doAction(request, request.getResponseClass());
        Assertions.assertTrue(response.isSuccess());
        printLog(request, response);
        Assertions.assertTrue(response.isSuccess());
        logger.info("----结束执行----{}------", "角色管理-新增");
    }


    /**
     * 基础资源->角色管理-更新
     *
     * <p>接口编号 evo_brm_033
     *
     * <p>方法类型 put
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/role
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("角色管理-更新")
    @Tag("基础资源")
    public void evo_brm_033_role_update() throws ClientException {
        logger.info("----开始执行----{}------", "角色管理-更新");
        IClient iClient = new DefaultClient();
        // 产生角色
        BrmRoleAddRequest request =
                BrmRoleAddRequest.builder().roleName(roleName).roleGrade(roleGrade).owenCode(ownerCode).build();
        BrmRoleAddResponse response = iClient.doAction(request, request.getResponseClass());
        Assertions.assertTrue(response.isSuccess());
        printLog(request, response);
        // 更新部分信息
        BrmRoleUpdateRequest updateRequest =
                BrmRoleUpdateRequest.builder()
                        .id(response.getData().getId())
                        .roleName(roleName)
                        .roleGrade(2)
                        .ownerCode(ownerCode)
                        .build();
        // TODO name,parentId是否真的必须
        BrmRoleUpdateResponse updateResponse =
                iClient.doAction(updateRequest, updateRequest.getResponseClass());
        printLog(updateRequest, updateResponse);
        Assertions.assertTrue(updateResponse.isSuccess());
        logger.info("----结束执行----{}------", "角色管理-更新");
    }

    /**
     * 基础资源->角色管理-删除
     *
     * <p>接口编号 evo_brm_034
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/role/delete
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("角色管理-删除")
    @Tag("基础资源")
    public void evo_brm_034_role_delete() throws ClientException {
        logger.info("----开始执行----{}------", "角色管理-删除");
        // 新增
        IClient iClient = new DefaultClient();
        BrmRoleAddRequest request =
                BrmRoleAddRequest.builder().roleName(roleName).roleGrade(roleGrade).owenCode(ownerCode).build();
        BrmRoleAddResponse response = iClient.doAction(request, request.getResponseClass());
        printLog(request, response);
        Assertions.assertTrue(response.isSuccess());
        // 删除信息
        BrmRoleDeleteRequest deleteRequest =
                BrmRoleDeleteRequest.builder().ids(Stream.of(response.getData().getId()).collect(Collectors.toList())).build();
        BrmRoleDeleteResponse deleteResponse =
                iClient.doAction(deleteRequest, deleteRequest.getResponseClass());
        printLog(deleteRequest, deleteResponse);
        Assertions.assertTrue(deleteResponse.isSuccess());
        logger.info("----结束执行----{}------", "角色管理-删除");
    }

    /**
     * 基础资源->角色管理-详情
     *
     * <p>接口编号 evo_brm_035
     *
     * <p>方法类型 get
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/role/detail/{id}
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("角色管理-详情")
    @Tag("基础资源")
    public void evo_brm_035_role_detail() throws ClientException {
        logger.info("----开始执行----{}------", "角色管理-详情");
        IClient iClient = new DefaultClient();
        // 产生数据
        BrmRoleAddRequest request =
                BrmRoleAddRequest.builder().roleName(roleName).roleGrade(roleGrade).owenCode(ownerCode).build();
        BrmRoleAddResponse response = iClient.doAction(request, request.getResponseClass());
        Assertions.assertTrue(response.isSuccess());
        printLog(request, response);
        Assertions.assertTrue(response.isSuccess());
        // 执行查询
        BrmRoleDetailRequest detailRequest = new BrmRoleDetailRequest(response.getData().getId());
        BrmRoleDetailResponse detailResponse =
                iClient.doAction(detailRequest, detailRequest.getResponseClass());
        printLog(detailRequest, detailResponse);
        Assertions.assertTrue(detailResponse.isSuccess());
        logger.info("----结束执行----{}------", "角色管理-详情");
    }

    /**
     * 基础资源->角色管理-分页查询
     *
     * <p>接口编号 evo_brm_036
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/role/subsystem/page
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("角色管理-分页查询")
    @Tag("基础资源")
    public void evo_brm_036_role_page() throws ClientException {
        logger.info("----开始执行----{}------", "角色管理-分页查询");
        IClient iClient = new DefaultClient();
        BrmRolePageRequest pageRequest = new BrmRolePageRequest();
        BrmRolePageResponse pageResponse =
                iClient.doAction(pageRequest, pageRequest.getResponseClass());
        printLog(pageRequest, pageResponse);
        Assertions.assertTrue(pageResponse.isSuccess());
        logger.info("----结束执行----{}------", "角色管理-分页查询");
    }

    /**
     * 基础资源->角色管理-全量同步
     *
     * <p>接口编号 evo_brm_037
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/role/list-page
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("角色管理-全量同步")
    @Tag("基础资源")
    public void evo_brm_037_role_sync() throws ClientException {
        logger.info("----开始执行----{}------", "角色管理-全量同步");
        IClient iClient = new DefaultClient();
        // 产生数据
        List<Long> roleIdList = new ArrayList<>();
        roleIdList.add(5L);
        BrmRoleAddRequest addRequest =
                BrmRoleAddRequest.builder().roleName(roleName).roleGrade(roleGrade).owenCode(ownerCode).build();
        BrmRoleAddResponse addResponse = iClient.doAction(addRequest, addRequest.getResponseClass());
        printLog(addRequest, addResponse);
        Assertions.assertTrue(addResponse.isSuccess());
        // 执行分页 查询
        BrmRoleSyncRequest pageRequest =
                BrmRoleSyncRequest.builder().pageSize(10).pageNum(1).build();
        BrmRoleSyncResponse pageResponse =
                iClient.doAction(pageRequest, pageRequest.getResponseClass());
        printLog(pageRequest, pageResponse);
        Assertions.assertTrue(pageResponse.isSuccess());
        logger.info("----结束执行----{}------", "角色管理-全量同步");
    }
}
