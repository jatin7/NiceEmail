# NiceEmail
支持各种功能的邮件发送库
# 特性
* 简洁的邮件发送API
* 支持自定义发件人昵称
* 支持各种邮箱验证
* 提供各种发送邮箱模板样式及使用?
* 支持发送HTML/附件?
* 支持异步发送?
* 支持定时发送邮件?
# 如何使用
maven坐标

    <dependency>
        <groupId>io.github.isliqian</groupId>
        <artifactId>NiceEmail</artifactId>
        <version>1.0.0</version>
    </dependency>

样例

    @Before
    public void before(){
        // 配置，一次即可
        NiceEmail.config(NiceEmail.SMTP_QQ(), "51103942@qq.com", "邮箱密钥");
    }
    
    @Test
    public void testSenteText() throws MessagingException {
        NiceEmail.subject("这是一封测试TEXT邮件")//主题
                .from("LqNice")//发件人昵称
                .to("???@qq.com")//收件人
                .text("信件内容")//内容
                .send();//发送
    }
    
