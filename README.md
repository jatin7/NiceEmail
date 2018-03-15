## NiceEmail
支持各种功能的邮件发送库
## 特性
* 简洁的邮件发送API
* 支持自定义发件人昵称
* 支持各种邮箱验证
* 提供各种发送邮箱模板样式及使用?
* 支持发送HTML/附件?
* 支持异步发送?
* 支持定时发送邮件?
## 如何使用
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
                    .html("<h1 font=red>信件内容</h1>")
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
                    .attach(new File("/Users/DELL/Pictures/Saved Pictures/000028.jpg"), "测试图片.jpeg")
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
                      .verificationCode(VerificationCode.number(6))
                      .send();
    
        }
    
