package uuu.totalbuy.other;
 
import java.util.Properties;
 

/*
主程式

也是個thread，讀取外部email清單，取得edm的html內容，配製寄送的thread。

mail清單列表需要是一個文字檔，每一個mail一行。
*/
public class Main extends java.lang.Thread {
    private org.apache.log4j.Logger log;
    private java.util.ArrayList<String> toList;
 
    private Properties p;
    private String content;
    private String subject;
 
    public Main() throws java.io.IOException {
        super();
 
        log = org.apache.log4j.Logger.getLogger(this.getClass());
        java.io.FileReader fis = null;
        java.io.BufferedReader bis = null;
        toList = new java.util.ArrayList<String>();
 
        try {
            // 從外部取得設定檔資料
            p = new Properties();
            log.info(this.getClass().getResource("/mail.properties").getPath());
            java.io.FileReader fr = new java.io.FileReader(this.getClass()
                    .getResource("/mail.properties").getPath());
            java.io.BufferedReader br = new java.io.BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                String[] tmp = str.split("=");
                p.setProperty(tmp[0], tmp[1]);
            }
            br.close();
            fr.close();
 
            // 名單
            fis = new java.io.FileReader(p.getProperty("edmList"));
            bis = new java.io.BufferedReader(fis);
 
            while ((str = bis.readLine()) != null) {
                toList.add(str.trim());
            }
            fis.close();
            bis.close();
            fis = null;
            bis = null;
 
            // 取得網頁內容
            WebModule web = new WebModule();
            if (web.doGet(p.getProperty("edmUrl"), null, null, "utf-8")) {
                content = web.getContent();
            } else {
                throw new java.io.IOException("取得網頁資料錯誤!");
            }
 
            // 郵件標題
            this.subject = p.getProperty("edmSubject");
 
        } catch (java.io.IOException e) {
            log.info(e.getMessage());
 
            throw e;
        } finally {
            try {
                if (bis != null)
                    bis.close();
 
                if (fis != null)
                    fis.close();
                bis = null;
                fis = null;
            } catch (java.io.IOException ex) {
 
            }
        }
 
    }
 
    public void run() {
 
        java.io.FileWriter fw = null;
 
        try {
 
            for (int i = 0; i < toList.size(); i++) {
 
                // 啟動thread開始寄信
                Sender sender = new Sender(
                        toList.get(i), subject, content, p);
                sender.start();
                // 暫停數秒後再開始寄信
                Thread.sleep(Integer.parseInt(p.getProperty("sleep")));
 
                if (fw != null) {
                    fw.flush();
                    fw.write(toList.get(i) + "\r\n");
                }
 
            }
 
        } catch (Exception e) {
            log.info(e.getMessage());
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.flush();
                    fw.close();
                } catch (Exception e) {
                }
 
            }
        }
 
    }
 
    public static void main(String args[]) throws java.io.IOException {
        Main m = new Main();
        m.start();
    }
}