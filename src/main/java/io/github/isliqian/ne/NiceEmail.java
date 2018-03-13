package io.github.isliqian.ne;


import com.sun.mail.util.MailSSLSocketFactory;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * Created by LiQian_Nice on 2018/3/13
 */
public class NiceEmail {

    private static Session session;
    private static String  user;
    private MimeMessage msg;
    private String  text;
    public static Properties defaultConfig() {
        //1.创建连接对象，连接到邮箱服务器
        Properties props=new Properties();
        props.setProperty("mail.smtp.auth", "true");// 打开认证
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.debug", "false");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.timeout", "10000");
        props.put("mail.smtp.port", "465");
        return props;
    }

    /**
     * smtp entnterprise qq
     *
     * @return
     */
    public static Properties SMTP_ENT_QQ() {
        Properties props = defaultConfig();
        props.put("mail.smtp.host", "smtp.exmail.qq.com");
        return props;
    }

    /**
     * smtp qq
     *
     * @return
     */
    public static Properties SMTP_QQ() throws GeneralSecurityException {
        Properties props = defaultConfig();
        props.put("mail.smtp.host", "smtp.qq.com");
        //QQ邮箱需要下面这段代码，163邮箱不需要
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.socketFactory", sf);
        return props;
    }

    /**
     * smtp 163
     *
     * @return
     */
    public static Properties SMTP_163() {
        Properties props = defaultConfig();
        props.put("mail.smtp.host", "smtp.163.com");
        return props;
    }

    /**
     * config username and password
     *
     * @param props    email property config
     * @param username email auth username
     * @param password email auth password
     */
    public static void config(Properties props, final String username, final String password) {
        user=username;
        session = Session.getDefaultInstance(props, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password); // 发件人邮箱账号、授权码
            }
        });
    }

    /**
     * set email subject
     *
     * @param subject subject title
     * @return
     * @throws MessagingException
     */
    public static NiceEmail subject(String subject) throws MessagingException {
        NiceEmail niceEmail = new NiceEmail();
        niceEmail.msg = new MimeMessage(session);
        niceEmail.msg.setSubject(subject);
        return niceEmail;
    }

    /**
     * set email from
     *
     * @param nickName from nickname
     * @return
     * @throws MessagingException
     */
    public NiceEmail from(String nickName) throws MessagingException {
        return from(nickName, user);
    }

    /**
     * set email nickname and from user
     *
     * @param nickName
     * @param from
     * @return
     * @throws MessagingException
     */
    public NiceEmail from(String nickName, String from) throws MessagingException {
        try {
            nickName = MimeUtility.encodeText(nickName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        msg.setFrom(new InternetAddress(nickName + " <" + from + ">"));
        return this;
    }

    public NiceEmail to(String to) throws MessagingException {
        return addRecipient(to, Message.RecipientType.TO);
    }

    private NiceEmail addRecipient(String recipient, Message.RecipientType type) throws MessagingException {
        msg.setRecipients(type, InternetAddress.parse(recipient.replace(";", ",")));
        return this;
    }

    public NiceEmail text(String text) {
        this.text = text;
        return this;
    }



    public void send() throws MessagingException {
        if (text == null)
            throw new NullPointerException("At least one context has to be provided: Text or Html");
        MimeMultipart cover;
        cover = new MimeMultipart("mixed");
        cover.addBodyPart(textPart());
        msg.setSentDate(new Date());
        msg.setContent(cover);
        Transport.send(msg);
    }

    private MimeBodyPart textPart() throws MessagingException {
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(text);
        return bodyPart;
    }

}
