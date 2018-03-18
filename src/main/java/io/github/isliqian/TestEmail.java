package io.github.isliqian;

import org.junit.Before;
import org.junit.Test;

import javax.mail.MessagingException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


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
            to="51103942@qq.com")
    public void sendEmail(){
        trackUseCases(TestEmail.class);
    }
    public static void trackUseCases( Class<?> c1){
        for(Method m:c1.getDeclaredMethods()){
            //  getDeclaredMethods    including public, protected, default (package) access, and private methods, but excluding inherited methods.
            AnnNiceEmail uc=m.getAnnotation(AnnNiceEmail.class);
            if(uc !=null){
                System.out.println("Found Use Case:inUse= "+uc.inUse()+"from= "+uc.from()+"subject="+uc.subject()+"to="+uc.to()+"html="+uc.html()+"text="+uc.text()+"verificationCode="+uc.verificationCode());


            }
        }
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
                .verificationCode(4, verificationCodeArrary)
                .send();
    System.out.println(NiceEmail.code);
    }

  @Test
    public void testAnn() {

    }
}