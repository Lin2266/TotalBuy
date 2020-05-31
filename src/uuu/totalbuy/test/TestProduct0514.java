
package uuu.totalbuy.test;
//課本5-14

import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.Product;
import uuu.totalbuy.model.OrderService;
import uuu.totalbuy.model.OutOfStockException;
import uuu.totalbuy.model.ProductService;

public class TestProduct0514 {

    public static void main(String[] args) {
        Product p = new Product(1, "Mouse",50,true,100);
        Customer c = new Customer("A222664447","John","台北市復興北路");
        ProductService ps = new ProductService();
        
        //呼叫方法/建構子參數傳遞，如果是物件的時候，傳送的值是參考值
        //ps呼叫addPrice把p物件帶到addPrice的參數裡
        
        //10-20 方法加static
        //TestCustomerException檔有拋例外，所以這邊也要強制做處理
        try {
            OrderService.order(c, p, 50);
        } 
        //庫存量不足時要處理
        catch (OutOfStockException e) {
            System.out.println(e.toString());
        }
        ProductService.addPrice(p);
        System.out.println(ProductService.calculateProductInventory(p));
    }
    
}
