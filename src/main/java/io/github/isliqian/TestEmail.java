package io.github.isliqian;

import org.junit.Before;
import org.junit.Test;

import javax.mail.MessagingException;

import java.lang.reflect.InvocationTargetException;


import static io.github.isliqian.NiceEmail.send;
import static io.github.isliqian.VerificationCode.verificationCodeArrary;

/**
 * Created by LiQian_Nice on 2018/3/16
 */
@AnnNiceConfig(type = "SMTP_QQ",
        username = "51103942@qq.com",
        password = "jtmoybnwknrnbjha")
public class TestEmail {

    @Test
    @AnnNiceEmail(inUse = TestEmail.class,
            subject = "测试注解邮件",
            from = "LqNice",
            to="51103942@qq.com",
            text = "textAnn",//text与html不能同时显示
            html = "<h1>aha</h1>")
    public void sendEmail() throws InvocationTargetException, IllegalAccessException, MessagingException {
        send(TestEmail.class);
    }

   /* @Before
    public void before() {
        NiceEmail.config(NiceEmail.SMTP_QQ(), "51103942@qq.com", "jtmoybnwknrnbjha");

    }*/
    @Test
    public  void sendMail() throws MessagingException, InvocationTargetException, IllegalAccessException {
        NiceEmail.inUse(TestEmail.class)
                .subject("您的注册验证码邮件")
                .from("LqNice")
                .to("51103942@qq.com")
                .text ( "textAnn")//text与html不能同时显示
                 .html ("<h1>aha</h1>")
                .send();
    System.out.println(NiceEmail.code);
    }

  @Test
    public void testAnn() {

    }
}