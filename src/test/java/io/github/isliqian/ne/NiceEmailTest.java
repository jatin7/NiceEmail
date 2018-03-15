package io.github.isliqian.ne;




import org.junit.Before;
import org.junit.Test;
import javax.mail.MessagingException;
import java.io.File;

/**
 * Created by LiQian_Nice on 2018/3/13
 */
public class NiceEmailTest {


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

    @Test
    public void testVerifcationCode(){
        System.out.println(VerificationCode.letter(9));
    }

}
