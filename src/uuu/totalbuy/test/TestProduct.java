//套件宣告檔案在哪個目錄下
package uuu.totalbuy.test;
//匯入宣告要匯入的檔案在哪個目錄下
import uuu.totalbuy.domain.Product;
import uuu.totalbuy.model.OrderService;
import uuu.totalbuy.model.ProductService;
//課本3-13習題，4-12習題改3-13
public class TestProduct {

    public static void main(String[] args) {
        
        
        //宣告一個Product型態的p物件裡面存的是參考值(物件參考變數) 
        // 呼叫Product建構子
        Product p = new Product(101,"pen");
        
        
        //p.setId(101);
        //p.setName("pen");
//        p.setUnitPrice(20);
//        p.setFree(false);
//        p.incStock(100);
//        p.decStock(50);
        
        /*
        System.out.println(p.getId());
        System.out.println(p.getName());
        System.out.println(p.getUnitPrice());
        System.out.println(p.isFree());
        System.out.println(p.getStock());
        */
        Product p1 = new Product(102,"test", 50,true,100); 
        p1.incStock(50);
        
        ProductService ps = new ProductService();
        
        //ps物件呼叫calculateProductInventory()方法幫p運算總價值在回傳
//        System.out.println(ps.calculateProductInventory( p ));
//        System.out.println(ps.calculateProductInventory( p1 ));
        /*
        +
        p.id = 10;
        p.name = "pen";
        p.unitPrice = 10;
        p.free = false;
        p.stock = 100;
        
        System.out.println("編號:"     + p.id);
        System.out.println("名稱:"     + p.name);
        System.out.println("單價:"     + p.unitPrice);
        System.out.println("是否免費:" + p.free);
        System.out.println("庫存:"     + p.stock);
        */
                  
        
    }
    
}
