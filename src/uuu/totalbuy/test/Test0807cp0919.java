
package uuu.totalbuy.test;

import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.Outlet;
import uuu.totalbuy.domain.Product;
import uuu.totalbuy.domain.VIP;
//09-19 Object父類別的方法
public class Test0807cp0919 {

    public static void main(String[] args) {
        Product p = new Product(11,"Mouse");
        System.out.println(p);
        Outlet o = new Outlet(12,"Pen",10,true, 100,20);
        System.out.println(o);
        
        
        /*
        VIP vip = new VIP("111","John");
        System.out.println(vip);
        Customer c = new Customer("222","Marry");
        System.out.println(c);
        */
        /*
        Customer c = new Customer("10","John");
        //直接顯示物件參考變數，會自動加上.toString()
        System.out.println(c);
        //自串連接物件參考變數，會自動加上.toString()
        String s = "Customer: " +  c;//c.toString
        System.out.println(c.toString());
        */
    }
    
}
