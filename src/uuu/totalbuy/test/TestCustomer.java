
package uuu.totalbuy.test;

import uuu.totalbuy.domain.Customer;

public class TestCustomer {

    public static void main(String[] args) {
        Customer c = new Customer("A222664447","John","台北市復興北路");
        //10-20 方法加static
        System.out.println(Customer.checkId("1234567890"));
        //c.setGender('M');
        
        //用%轉換字元為一個單位，顯示基本資料
        System.out.println(c.toString());
        
    }
    
}
