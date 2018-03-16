package io.github.isliqian;

import org.junit.Before;
import org.junit.Test;

import javax.mail.MessagingException;

import static io.github.isliqian.VerificationCode.verificationCodeArrary;

/**
 * Created by LiQian_Nice on 2018/3/16
 */
public class TestEmail {
    @Before
    public void before() {
        NiceEmail.config(NiceEmail.SMTP_QQ(), "51103942@qq.com", "jtmoybnwknrnbjha");

    }

    @Test
    public  void sendMail() throws MessagingException {
        NiceEmail.subject("您的注册验证码邮件")
                .from("LqNice")
                .to("51103942@qq.com")
                .verificationCode(4, verificationCodeArrary)
                 .send();
    System.out.println(NiceEmail.code);
    }
}