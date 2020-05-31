
package uuu.totalbuy.test;

import java.util.Date;
import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.Outlet;
import uuu.totalbuy.domain.Product;

public class Test0810ch0923 {
    //Customer equals()判斷 ch09-24  ch9-37包裝類別
    
    public static void main(String[] args) {
        //把資料型態轉換成物件，然後讀取物件裡面的資料
        //字串轉整數
        String ageStr = "35";
        //parse固定
        int age = Integer.parseInt(ageStr);
        System.out.println(age);
        System.out.println(age * 12);
        
        /*
        Date d = new Date();//建立一個Date物件
        //不同身份，同資料，判斷兩個資料一不一樣(只判斷id跟email而已)
        Customer c = new Customer("a123","John","Taipei",d,'M',true,"123@yahoo");
        Customer c2 = new Customer("a123","John","Taipei",d,'M',true,"123@yahoo");
        //System.out.println(c.equals(c2));
        
        Product p = new Product(10,"John",50,true,100);
        Product p2 = new Product(10,"John",50,true,100);
        
        System.out.println(p.equals(p2));
        
        Outlet o = new Outlet(10,"John",50,true,100,20);
        Outlet o2 = new Outlet(10,"John",50,true,100,20);
        
        System.out.println(o.equals(o2));
        
        
        
        


        //System.out.println(c == c2);//(c == c2)是在比參考值
        //System.out.println(c.equals(c2));
        */
        
    }
    
}
