
package uuu.totalbuy.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import uuu.totalbuy.domain.TotalBuyException;
//連線用
public class RDBConnection {
    private static final String driver; //= "com.mysql.jdbc.Driver";
    private static final String url; //= "jdbc:mysql://localhost:3306/totalbuy?zeroDateTimeBehavior=convertToNull&characterEncoding=utf-8";
    private static final String userId; //= "root";
    private static final String pwd; //= "root1234";
    
    static{
        ResourceBundle bundle = ResourceBundle.getBundle("uuu.totalbuy.model.TotalbuyJDBC");
        String dr = bundle.getString("totalbuy.jdbc.driver");
        if(dr!=null) {
            driver=dr;
        }else{
            driver="com.mysql.jdbc.Driver";
        }
        String u = bundle.getString("totalbuy.jdbc.url");
        if(u!=null) {
            url=u;
        }else{
            url="jdbc:mysql://localhost:3306/totalbuy?zeroDateTimeBehavior=convertToNull";
        }
        String us = bundle.getString("totalbuy.jdbc.userId");
        if(us!=null) {
            userId=us;
        }else{
            userId="root";
        }
        String pw = bundle.getString("totalbuy.jdbc.pwd");
        if(pw!=null) {
            pwd=pw;
        }else{
            pwd="123456";
        }
        
    }
   
   //連接池
    public static Connection getConnection() throws TotalBuyException {
//        設定Data Source(ConnectionPool)
        DataSource ds = null;

        try {
//            找context.xml的name:jdbc/totalbuy
            Context ctx = new InitialContext();
             //        連線環境尋找要的資源
            ds = (DataSource)ctx.lookup("java:comp/env/jdbc/totalbuy");
            //檢查失敗就拋錯
            if(ds==null) {
                throw new RuntimeException("無法取得Connection Pool!");
            }
            Connection connection = ds.getConnection();
            System.out.println("取得Connection Pool: " + connection);
            return connection;
            
        } catch (Exception nex) {
            System.out.println("無法取得Connection Pool: " + nex);
            try {
//             Connection Pool無法連線就由這裡連線   
            //1. load MySQL JDBC driver
            Class.forName(driver);
            try {//2. get connection
                Connection connection = DriverManager.getConnection(url, userId, pwd);
                System.out.println("取得JDBC連線: " + connection);
                return connection;
            } catch (SQLException ex) {
                System.out.println("RDBConnection.getConnection-無法建立連線: " + url);
                throw new TotalBuyException("無法建立JDBC連線!", ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("RDBConnection.getConnection-無法載入JDBC Driver: " + driver);
            throw new TotalBuyException("無法載入JDBC Driver", ex);
            }
        }
        

        
    }

  

    
}
