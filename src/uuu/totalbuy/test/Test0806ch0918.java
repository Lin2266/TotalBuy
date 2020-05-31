
package uuu.totalbuy.test;

import uuu.totalbuy.domain.Outlet;
import uuu.totalbuy.domain.VIP;

public class Test0806ch0918 {

    public static void main(String[] args) {
        VIP rv = new VIP("1001","John");
        
        System.out.println(rv.getDiscount());
        
        Outlet o = new Outlet(1,"John",50,true,100,30);
        
        System.out.println(o.getUnitPrice());
        System.out.println(o.getDiscount());//折扣
        System.out.println(o.getListPrice());//原價
       
    }
    
}
