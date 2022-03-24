package com.dahuatech.icc.test;

import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.model.v202011.BlockAddRequest;
import com.dahuatech.icc.hrms.model.v202011.BlockAddResponse;
import com.dahuatech.icc.hrms.model.v202011.OrganizationViewRequest;
import com.dahuatech.icc.hrms.model.v202011.OrganizationViewResponse;
import com.dahuatech.icc.oauth.http.DefaultClient;
import com.dahuatech.icc.oauth.http.IClient;
import org.junit.Test;

/**
 * @author 232676
 * @since 1.0.0 2020/11/2 16:22
 */
public class HrmsTest {

  @Test
  public void addBlock() throws ClientException {
    IClient iClient = new DefaultClient();
    String body =
        "{\"blockAddress\":\"1-1-402\",\"blockCode\":\"3301081002\",\"blockName\":\"复兴东苑\",\"blockType\":\"1\",\"countyCode\":\"330108\",\"cityCode\":\"330100\",\"orgType\":\"5\",\"parentId\":\"001\",\"orgCode\":\"\",\"provinceCode\":\"330000\"}";
    BlockAddRequest request = new BlockAddRequest();
    request.body(body);
    BlockAddResponse response = iClient.doAction(request, request.getResponseClass());
    System.out.println(response);
  }

  @Test
  public void blockView() throws ClientException {
    IClient iClient = new DefaultClient();
    OrganizationViewRequest request = new OrganizationViewRequest("001001002001001");
    OrganizationViewResponse response = iClient.doAction(request, request.getResponseClass());
    System.out.println(response);
  }
}
