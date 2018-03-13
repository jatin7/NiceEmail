package io.github.isliqian.ne;


import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

/**
 * Created by LiQian_Nice on 2018/3/13
 */
public class Test {

    public static void main(String[] args) throws GeneralSecurityException, MessagingException {
        // 配置，一次即可
        NiceEmail.config(NiceEmail.SMTP_QQ(), "51103942@qq.com", "jtmoybnwknrnbjha");
        NiceEmail.subject("这是一封测试TEXT邮件")//主题
                .from("LqNice")//发件人昵称
                .to("51103942@qq.com")//收件人
                .text("信件内容")//内容
                .send();//发送
    }
}
