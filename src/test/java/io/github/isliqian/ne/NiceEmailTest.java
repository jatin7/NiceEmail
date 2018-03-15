package io.github.isliqian.ne;




import org.junit.Before;
import org.junit.Test;

import javax.mail.MessagingException;

/**
 * Created by LiQian_Nice on 2018/3/13
 */
public class NiceEmailTest {


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
}
