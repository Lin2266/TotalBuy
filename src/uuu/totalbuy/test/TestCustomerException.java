package uuu.totalbuy.test;

import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.Product;
import uuu.totalbuy.model.OrderService;
import uuu.totalbuy.model.OutOfStockException;

public class TestCustomerException {

    public static void main(String[] args) {
        Customer c = new Customer("A222664447", "John", "台北市復興北路");
        Product p = new Product(1, "Mouse", 50, true, 100);
        
        //方法加throws例外時，呼叫會產生錯誤
        //OrderService.order(c, p, 500);
        
        //throw new 會把例外物件丟到JVM(編譯器)，這邊執行有錯誤時
        try {
            OrderService.order(c, p, 50);
        } 
        //庫存量不足時要處理
        catch (OutOfStockException e) {
            System.out.println(e.toString());
        }
    }

}
