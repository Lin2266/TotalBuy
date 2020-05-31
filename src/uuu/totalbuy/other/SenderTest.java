package uuu.totalbuy.other;
 
import java.util.*;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

 /*
要下載commons-email放在文庫裡
*/
public class SenderTest extends Thread {
    private String content;
 
    private org.apache.log4j.Logger log;
    private String subject;
    private String to;
    private static Properties p = null;
 
    public static void loadProperties() {
        try {
            p = new Properties();
            // log.info(this.getClass().getResource("/mail.properties").getPath());
            System.out.println(Sender.class.getResource("/mail.properties"));
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.FileReader(Sender.class.getResource(
                            "/mail.properties").getFile()));
            ;
            String str = null;
            while ((str = reader.readLine()) != null) {
                String sp[] = str.split("=");
                p.put(sp[0].trim(), sp[1].trim());
                System.out.println(sp[0].trim() + "," + sp[1].trim());
            }
 
            reader.close();
        } catch (java.io.IOException e) {
 
        }
    }
 
    public SenderTest(String to, String subject, String content) {
        super();
        if (p == null)
            loadProperties();
        this.content = content;
        this.to = to;
        log = org.apache.log4j.Logger.getLogger(this.getClass());
        // this.p = p;
        this.subject = subject;
    }
 
    public void run() {
        HtmlEmail email = new HtmlEmail();
 
        try {
 
            String host = p.getProperty("host");
 
            String from = p.getProperty("from");
            String from_name = p.getProperty("fromName");
 
            String user = p.getProperty("user");
            String pwd = p.getProperty("pwd");
            String port = p.getProperty("port");
 
            email.setTLS(true); // 是否TLS檢驗，某些email需要TLS安全檢驗，同理有SSL檢驗
            // email.setSSL(true);
            email.setHostName(host);
            email.setAuthenticator(new DefaultAuthenticator(user, pwd)); // 使用者帳號及密碼
            //email.setAuthentication(user, user);
            // email.setSslSmtpPort(port);
            email.setSmtpPort(Integer.parseInt(port));
 
            email.setFrom(from, from_name);
            email.setCharset("utf-8");
            
            email.addTo(to); // 接收方
            // email.addCc("yyyyyy@gmail.com"); //副本
            // email.addBcc("zzzzzz@gmail.com"); //密件副本
            email.setSubject(subject); // 標題
 
            // email.setTextMsg("Your email client does not support HTML messages");
            email.setHtmlMsg(content); // 内容
            email.send();
 
        } catch (EmailException e) {
            e.printStackTrace();
            log.info(e);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e);
        }
    }
    public static void main(String args[])
    {
        (new SenderTest("q1378520@yahoo.com","test","test")).start();
    }
 
}