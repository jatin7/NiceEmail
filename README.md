## NiceEmail
支持各种功能的邮件发送库
## 特性
- [x] 简洁的邮件发送API
- [x] 支持自定义发件人昵称
- [x] 支持各种邮箱验证
- [ ] 提供各种发送邮箱模板样式及使用?
- [x] 支持发送HTML/附件
- [x] 支持异步发送
- [x] 支持定时发送邮件
- [x] 自定义注解，更加简单方便
## 如何使用

maven坐标

    <dependency>
        <groupId>io.github.isliqian</groupId>
        <artifactId>NiceEmail</artifactId>
        <version>2.0.0</version>
    </dependency>

样例

          
           
               @Before
               public void before(){
                   // 配置，一次即可：邮箱与密码
                   NiceEmail.config(NiceEmail.SMTP_QQ(), "51103942@qq.com", "jtmoybnwknrnbjha");
               }
           
               /**
                * 测试发送文字
                * @throws MessagingException
                */
               @Test
               public void testSendText() throws MessagingException {
                   NiceEmail.subject("这是一封测试TEXT邮件")//主题
                           .from("LqNice")//发件人昵称
                           .to("???@qq.com")//收件人
                           .text("信件内容")//内容
                           .send();//发送
               }
           
               /**
                * 测试发送Html
                * @throws MessagingException
                */
               @Test
               public void testSendHtml() throws MessagingException {
                   NiceEmail.subject("这是一封测试HTML邮件")
                           .from("LqNice")
                           .to("51103942@qq.com")
                           //html内容即可
                           .html("<h1>信件内容</h1>")
                           .send();
               }
           
               /**
                * 测试附件邮件
                * @throws MessagingException
                */
               @Test
               public void testSendAttach() throws MessagingException {
                   NiceEmail.subject("这是一封测试附件邮件")
                           .from("LqNice")
                           .to("51103942@qq.com")
                           .html("<h1 font=red>信件内容</h1>")
                           //附近的路径，以及名称
                           .attach(new File("/Users/DELL/Pictures/Saved Pictures/000028.jpg"), "测试图片.jpeg")
                           //名称可以不设置
                           //.attach(new File("/Users/DELL/Pictures/Saved Pictures/000028.jpg"))
                           .send();
               }
               /**
                * 测试发送验证码
                * @throws MessagingException
                */
               @Test
               public void testSendVerifcationCode() throws MessagingException{
                   NiceEmail.subject("来自远方的验证码")
                             .from("LqNice")
                             .to("51103942@qq.com")
                              //验证码长度为6，如果类型为null,验证码类型为数字英文混合验证码
                             .verificationCode(6,null)
                             //支持纯英文验证码
                             //.verificationCode(4,verificationEnglishArrary)
                             //如果验证码位数不配置，则按照6位验证码发送
                             //.verificationCode(0,verificationNumberArrary)
                             .send();
           
               }
           
               /**
                * 测试定时发送邮件
                * @param args
                * @throws MessagingException
                */
               public static void  main(String[] args) throws MessagingException {
                   NiceEmail.config(NiceEmail.SMTP_QQ(), "51103942@qq.com", "jtmoybnwknrnbjha");
                   NiceEmail.subject("来自远方的验证码")
                           .from("LqNice")
                           .to("51103942@qq.com")
                           .verificationCode(6,verificationCodeArrary)
                           //定时发送为21点51分，发送完成，自动停止。
                           .waitTimeSend(21,51);
               }
           
### 新特性 
自定义注解如何使用 **@AnnNiceConfig** + **@AnnNiceEmail** 
    
    @AnnNiceConfig(type = "SMTP_QQ",
            username = "51103942@qq.com",
            password = "jtmoybnwknrnbjha")
    public class TestEmail {
        @Test
        @AnnNiceEmail(inUse = TestEmail.class,
                subject = "测试 注解邮件",
                from = "LqNice",
                to="51103942@qq.com")
        public void sendEmail(){
            trackUseCases(TestEmail.class);
        }
        
###发现bug
* html与text不能同时显示。。。                 
###[个人博客](www.imqian.top)
作者 51103942@qq.com             
          

    
