# 快速开始

Hi，欢迎使用大华ICC开发者工具套件（SDK），ICC Java SDK 让你不用复杂编程可以调用ICC 系统服务。

## 环境准备

-   使用大华ICC Java SDK，您需要一个申请访问凭证。 申请访问凭证，登录ICC平台管理端，右上角【OpenAPI】->【申请访问凭证】。或联系您的系统管理员。
-   大华ICC Java SDK需要1.7以上的JDK。

## 安装ICC Java SDK

如果您使用Apache Maven来管理Java项目，只需在项目的pom.xml中文件加入相应的依赖项即可。

无论您要使用哪个产品的开发工具包，都必须安装SDK核心库。比如，授权访问凭证的SDK调用，您需要安装SDK核心库。

您只需在pom.xml中声明这个开发工具包，如下所示：

```
<dependency>
    <artifactId>java-sdk-oauth</artifactId>
    <groupId>com.dahuatech.icc</groupId>
    <version>1.0.3</version>
</dependency>
```

## 使用Java SDK 

以下这个代码示例展示了调用ICC Java SDK的3个主要步骤：

1. 创建并初始化IClient实例。

2. 创建API请求并设置参数。

3. 发起请求并处理应答或异常。

   ```java
   
   public class IccDemo {
       public static void main(String[] args) {
   
           try {
              IClient client = new DefaultClient("127.0.0.1", "clientId","clientSecret");
              IccTokenResponse.IccToken clientToken = client.getAccessToken(GrantType.client_credentials);
   
   
           } catch (ClientException e) {
               e.printStackTrace();
           }
   
       }
   }
   ```



## Spring 集成 

以下这个代码示例展示了集成到spring 的2个主要步骤：

1. 在您的项目中resources\config\下增加iccSdk.properties配置文件，ICC SDK 会自动加载该配置信息

   ```properties
   #host,可以带端口127.0.0.1:83
   icc.sdk.host=127.0.0.1
   #客户端模式
   icc.sdk.clientId=xxxxx
   icc.sdk.clientSecret=xxxxx
   #密码校验模式
   icc.sdk.pwdClientId=xxxx
   icc.sdk.pwdClientSecret=xxxxx
   icc.sdk.username=xxxxx
   icc.sdk.password=xxxxx
   #使用授权类型password,client_credentials
   icc.sdk.grantType=xxxxx
   #关闭https
   icc.sdk.enable.https=false
   ```

2. 初始化一个spring bean

   ```java
   @Bean
   public IClient iccDefaultClient() throws ClientException {
       return new DefaultClient();
   }
   ```

   如果你项目没有办法增加iccSdk.properties配置文件，你也可以

   ```java
   @Bean
   public IClient iccDefaultClient() throws ClientException {
       return new DefaultClient("127.0.0.1", "clientId", "clientSecret")
   }
   ```

   

3. 开始使用

   ```java
   @Autowired
   private IClient iClient;
   
   
   ```

## [文档](https://open-icc.dahuatech.com/#/)

## 许可证

[Apache-2.0](http://www.apache.org/licenses/LICENSE-2.0)