package uuu.totalbuy.other;

import java.util.Date;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;




//寄件人，要下載javamail放在文庫裡
public class Sender extends Thread {

    private String content;
    // log
    private org.apache.log4j.Logger log;
    // 郵件標題
    private String subject;
    // 寄件對向
    private String to;
    // 設定檔
    private Properties p;
 
    // 建構
    public Sender(String to, String subject, String content, Properties p) {
        super();
        this.content = content;
        this.to = to;
        log = org.apache.log4j.Logger.getLogger(this.getClass());
        this.p = p;
        this.subject = subject;
    }
 
    // thread run
    public void run() {
        try {
 
            // 設定傳送基本資訊
            // 取得mail host名稱
            String host = p.getProperty("host");
            // 取得寄信者mail
            String from = p.getProperty("from");
 
            // 取得寄信者帳號
            String user = p.getProperty("user");
            // 取得寄信者帳號密碼
            String pwd = p.getProperty("pwd");
 
            Properties props = System.getProperties();
 
            // 設定SMTP server
 
            props.put("mail.smtp.host", host);
            // 是否需要認證
            props.put("mail.smtp.auth", "true");
 
            // 依據Properties建立一個Session
 
            Session mailSession = Session.getInstance(props, null);
 
            // 從Session建立一個Message
            MimeMessage message = new MimeMessage(mailSession);
 
            // 設定mail From
            message.setFrom(new InternetAddress(from, p.getProperty("fromName",
                    "utf-8")));
            // 設定mail To
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    to));
            // 設定標題
            message.setSubject(this.subject);
 
            // 設定寄件日期
            message.setSentDate(new Date());
            // 建立郵件本文內容
            Multipart multipart = new MimeMultipart();
 
            // 郵件內容
            BodyPart contentPart = new MimeBodyPart();
            // 給BodyPart對像設置內容和格式/編碼方式
            contentPart.setContent(content, "RegisterServlet.java;charset=utf8");
 
            // 加入郵件內容到mutipart裡
            multipart.addBodyPart(contentPart);
 
            // 將multipart加到mail的message裡
            message.setContent(multipart);
            // 產生mail message
            message.saveChanges();
 
            Transport transport = mailSession.getTransport("smtp");
            // 傳送
            transport.connect(host, user, pwd);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            log.info(to + ",寄送完成");
 
        } catch (Exception e) {
 
            log.info(this.to + "-" + e.getMessage());
            e.printStackTrace();
 
        }
 
    }

}
