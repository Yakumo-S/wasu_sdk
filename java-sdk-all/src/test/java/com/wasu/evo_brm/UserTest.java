package com.wasu.evo_brm;

import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.ExtentUtils;
import com.wasu.model.v202010.user.BrmUserAddRequest;
import com.wasu.model.v202010.user.BrmUserAddResponse;
import com.wasu.model.v202010.user.BrmUserBatchAddRequest;
import com.wasu.model.v202010.user.BrmUserBatchAddResponse;
import com.wasu.model.v202010.user.BrmUserDeleteRequest;
import com.wasu.model.v202010.user.BrmUserDeleteResponse;
import com.wasu.model.v202010.user.BrmUserDetailRequest;
import com.wasu.model.v202010.user.BrmUserDetailResponse;
import com.wasu.model.v202010.user.BrmUserKeepAliveRequest;
import com.wasu.model.v202010.user.BrmUserKeepAliveResponse;
import com.wasu.model.v202010.user.BrmUserPageRequest;
import com.wasu.model.v202010.user.BrmUserPageResponse;
import com.wasu.model.v202010.user.BrmUserPrivilegeMenusRequest;
import com.wasu.model.v202010.user.BrmUserPrivilegeMenusResponse;
import com.wasu.model.v202010.user.BrmUserSyncRequest;
import com.wasu.model.v202010.user.BrmUserSyncResponse;
import com.wasu.model.v202010.user.BrmUserUpdateRequest;
import com.wasu.model.v202010.user.BrmUserUpdateResponse;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础资源-用户管理
 *
 * @author 237417
 * @since 2021/02/03
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTest extends ExtentUtils {
    private static final String SYSTEM_NAME = "evo-brm";
    private static String loginName = "test_user";
    private static String ownerCode = "001";
    private static Integer isReuse = 1;
    private static Long personId = 10000L;
    private static Integer clientType = 1;
    private static String magicId = "678789898xxfhtgjdf";
    private static String terminal = "1";
    private static String systemCode = "evo-brm";

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
        BrmUserPageRequest pageRequest = new BrmUserPageRequest();
        pageRequest.setPageSize(20);
        BrmUserPageResponse pageResponse = iClient.doAction(pageRequest, pageRequest.getResponseClass());
        printLog(pageRequest, pageResponse);
        if (pageResponse.isSuccess()
                && pageResponse.getData() != null
                && pageResponse.getData().getPageData() != null) {
            List<BrmUserPageResponse.UserPageList> pages =
                    pageResponse.getData().getPageData();
            if (pages != null && pages.size() > 0) {
                for (BrmUserPageResponse.UserPageList pg : pages) {
                    if (pg.getLoginName().equals(loginName)) {
                        BrmUserDeleteRequest deleteRequest =
                                BrmUserDeleteRequest.builder()
                                        .ids(pg.getId().toString())
                                        .build();
                        BrmUserDeleteResponse deleteResponse =
                                iClient.doAction(deleteRequest, deleteRequest.getResponseClass());
                        printLog(deleteRequest, deleteResponse);
                    }
                }
            }
        }
    }

    /**
     * 基础资源->用户管理-新增
     *
     * <p>接口编号 evo_brm_022
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/user/add
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("用户管理-新增")
    @Tag("基础资源")
    public void evo_brm_022_user_add() throws ClientException {
        logger.info("----开始执行----{}------", "用户管理-新增");
        IClient iClient = new DefaultClient();
        List<Long> roleIdList = new ArrayList<>();
        roleIdList.add(5L);
        BrmUserAddRequest addRequest =
                BrmUserAddRequest.builder().loginName(loginName).ownerCode(ownerCode).isReuse(isReuse).personId(personId).roleIdList(roleIdList).build();
        BrmUserAddResponse addResponse = iClient.doAction(addRequest, addRequest.getResponseClass());
        Assertions.assertTrue(addResponse.isSuccess());
        printLog(addRequest, addResponse);
        Assertions.assertTrue(addResponse.isSuccess());
        logger.info("----结束执行----{}------", "用户管理-新增");
    }

    /**
     * 基础资源->用户管理-更新
     *
     * <p>接口编号 evo_brm_023
     *
     * <p>方法类型 put
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/user/update
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("用户管理-更新")
    @Tag("基础资源")
    public void evo_brm_023_user_update() throws ClientException {
        logger.info("----开始执行----{}------", "用户管理-更新");
        IClient iClient = new DefaultClient();
        // 产生数据
        List<Long> roleIdList = new ArrayList<>();
        roleIdList.add(5L);
        BrmUserAddRequest request =
                BrmUserAddRequest.builder().loginName(loginName).ownerCode(ownerCode).isReuse(isReuse).personId(personId).roleIdList(roleIdList).build();
        BrmUserAddResponse response = iClient.doAction(request, request.getResponseClass());
        printLog(request, response);
        Assertions.assertTrue(response.isSuccess());
        // 执行更新
        BrmUserUpdateRequest userUpdate =
                BrmUserUpdateRequest.builder()
                        .id(response.getData().getId().longValue())
                        .ownerCode(ownerCode)
                        .isReuse(isReuse)
                        .loginName(loginName)
                        .personId(personId)
                        .roleIdList(roleIdList)
                        .build();
        BrmUserUpdateResponse userResp =
                iClient.doAction(userUpdate, userUpdate.getResponseClass());
        printLog(userUpdate, userResp);
        Assertions.assertTrue(userResp.isSuccess());
        logger.info("----结束执行----{}------", "用户管理-更新");
    }

    /**
     * 基础资源->用户管理-删除
     *
     * <p>接口编号 evo_brm_024
     *
     * <p>方法类型 delete
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/user/delete
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("用户管理-删除")
    @Tag("基础资源")
    public void evo_brm_024_user_delete() throws ClientException {
        logger.info("----开始执行----{}------", "用户管理-删除");
        IClient iClient = new DefaultClient();
        // 产生数据-新增用户
        List<Long> roleIdList = new ArrayList<>();
        roleIdList.add(5L);
        BrmUserAddRequest addRequest =
                BrmUserAddRequest.builder().loginName(loginName).ownerCode(ownerCode).isReuse(isReuse).personId(personId).roleIdList(roleIdList).build();
        BrmUserAddResponse addResponse = iClient.doAction(addRequest, addRequest.getResponseClass());
        printLog(addRequest, addResponse);
        Assertions.assertTrue(addResponse.isSuccess());
        // 删除信息
        BrmUserDeleteRequest deleteRequest =
                BrmUserDeleteRequest.builder().ids(addResponse.getData().getId().toString()).build();
        BrmUserDeleteResponse deleteResponse =
                iClient.doAction(deleteRequest, deleteRequest.getResponseClass());
        printLog(deleteRequest,deleteResponse);
        Assertions.assertTrue(deleteResponse.isSuccess());
        logger.info("----结束执行----{}------", "用户管理-删除");
    }

    /**
     * 基础资源->用户管理-详情
     *
     * <p>接口编号 evo_brm_025
     *
     * <p>方法类型 get
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/user/{id}
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("用户管理-详情")
    @Tag("基础资源")
    public void evo_brm_025_user_detail() throws ClientException {
        IClient iClient = new DefaultClient();
        // 产生数据
        List<Long> roleIdList = new ArrayList<>();
        roleIdList.add(5L);
        BrmUserAddRequest addRequest =
                BrmUserAddRequest.builder().loginName(loginName).ownerCode(ownerCode).isReuse(isReuse).personId(personId).roleIdList(roleIdList).build();
        BrmUserAddResponse addResponse = iClient.doAction(addRequest, addRequest.getResponseClass());
        printLog(addRequest, addResponse);
        Assertions.assertTrue(addResponse.isSuccess());
        // 执行查询
        logger.info("----开始执行----{}------", "用户管理-详情");
        BrmUserDetailRequest userDetailRequest = new BrmUserDetailRequest(addResponse.getData().getId().longValue());
        BrmUserDetailResponse userDetailResponse = iClient.doAction(userDetailRequest, userDetailRequest.getResponseClass());
        Assertions.assertTrue(userDetailResponse.isSuccess());
        logger.info("----结束执行----{}------", "用户管理-详情");
    }

    /**
     * 基础资源->用户管理-有权限的菜单获取
     *
     * <p>接口编号 evo_brm_026
     *
     * <p>方法类型 get
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/user/privilege-menus
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("用户管理-有权限的菜单获取")
    @Tag("基础资源")
    public void evo_brm_026_user_privilege_menus() throws ClientException {
        logger.info("----开始执行----{}------", "用户管理-有权限的菜单获取");
        IClient iClient = new DefaultClient();
        BrmUserPrivilegeMenusRequest menusRequest = new BrmUserPrivilegeMenusRequest(terminal,systemCode);
        BrmUserPrivilegeMenusResponse menusResponse =
                iClient.doAction(menusRequest, menusRequest.getResponseClass());
        printLog(menusRequest, menusResponse);
        Assertions.assertTrue(menusResponse.isSuccess());
        logger.info("----结束执行----{}------", "用户管理-有权限的菜单获取");
    }

    /**
     * 基础资源->用户管理-分页查询
     *
     * <p>接口编号 evo_brm_027
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/user/subsystem/page
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("用户管理-分页查询")
    @Tag("基础资源")
    public void evo_brm_027_user_sub_page() throws ClientException {
        logger.info("----开始执行----{}------", "用户管理-分页查询");
        IClient iClient = new DefaultClient();
        BrmUserPageRequest userPageRequest = new BrmUserPageRequest();
        userPageRequest.setPageSize(200);
        BrmUserPageResponse userPageResponse =
                iClient.doAction(userPageRequest, userPageRequest.getResponseClass());
        Assertions.assertTrue(userPageResponse.isSuccess());
        logger.info("----结束执行----{}------", "用户管理-分页查询");
    }

    /**
     * 基础资源->用户管理-批量新增
     *
     * <p>接口编号 evo_brm_028
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/user/add-batch
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("用户管理-批量新增")
    @Tag("基础资源")
    public void evo_brm_028_user_batch_add() throws ClientException {
        logger.info("----开始执行----{}------", "用户管理-批量新增");
        IClient iClient = new DefaultClient();
        BrmUserBatchAddRequest.UserBatch batch = new BrmUserBatchAddRequest.UserBatch();
        batch.setLoginName(loginName);
        batch.setOwnerCode(ownerCode);
        batch.setIsReuse(isReuse);
        batch.setPersonId(personId);
        List<Long> roleIdList = new ArrayList<>();
        roleIdList.add(5L);
        batch.setRoleIdList(roleIdList);
        List<BrmUserBatchAddRequest.UserBatch> userList = new ArrayList<>();
        userList.add(batch);
        BrmUserBatchAddRequest request =
                BrmUserBatchAddRequest.builder().userAddList(userList).build();
        BrmUserBatchAddResponse response =
                iClient.doAction(request, request.getResponseClass());
        printLog(request, response);
        Assertions.assertTrue(response.isSuccess());

        logger.info("----结束执行----{}------", "用户管理-批量新增");
    }

    /**
     * 基础资源->用户管理-保活
     *
     * <p>接口编号 evo_brm_030
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/user/keepalive
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("用户管理-保活")
    @Tag("基础资源")
    public void evo_brm_030_user_keep_alive() throws ClientException {
        logger.info("----开始执行----{}------", "用户管理-保活");
        IClient iClient = new DefaultClient();
        BrmUserKeepAliveRequest request =
                BrmUserKeepAliveRequest.builder().clientType(clientType).magicId(magicId).build();
        BrmUserKeepAliveResponse response =
                iClient.doAction(request, request.getResponseClass());
        printLog(request,response);
        Assertions.assertTrue(response.isSuccess());
        logger.info("----结束执行----{}------", "用户管理-保活");
    }

    /**
     * 基础资源->用户管理-全量同步
     *
     * <p>接口编号 evo_brm_031
     *
     * <p>方法类型 post
     *
     * <p>接口地址 /evo-apigw/evo-brm/${version}/user/list-page
     *
     * @throws ClientException
     */
    @Test
    @DisplayName("用户管理-全量同步")
    @Tag("基础资源")
    public void evo_brm_031_user_sync() throws ClientException {
        logger.info("----开始执行----{}------", "用户管理-全量同步");
        IClient iClient = new DefaultClient();
        // 产生数据
        List<Long> roleIdList = new ArrayList<>();
        roleIdList.add(5L);
        BrmUserAddRequest addRequest =
                BrmUserAddRequest.builder().loginName(loginName).ownerCode(ownerCode).isReuse(isReuse).personId(personId).roleIdList(roleIdList).build();
        BrmUserAddResponse addResponse = iClient.doAction(addRequest, addRequest.getResponseClass());
        printLog(addRequest, addResponse);
        Assertions.assertTrue(addResponse.isSuccess());
        // 执行分页 查询
        BrmUserSyncRequest pageRequest =
                BrmUserSyncRequest.builder().build();
        BrmUserSyncResponse pageResponse =
                iClient.doAction(pageRequest, pageRequest.getResponseClass());
        printLog(pageRequest, pageResponse);
        Assertions.assertTrue(pageResponse.isSuccess());
        logger.info("----结束执行----{}------", "用户管理-全量同步");
    }
}
