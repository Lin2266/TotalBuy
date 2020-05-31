
package uuu.totalbuy.model;

import java.util.List;
import uuu.totalbuy.domain.Product;
import uuu.totalbuy.domain.TotalBuyException;

public class ProductService {
    //隱藏dao實作細節，降低依賴
    final private ProductsDAO dao = new ProductsDAO();
    
    public ProductService (){  
    
    }
    
    public Product get(Integer id) throws TotalBuyException {
        return dao.get(id);
    }

    public List<Product> getAll() throws TotalBuyException {
        return dao.getAll();
    }

    public void insert(Product p) throws TotalBuyException {
        dao.insert(p);
    }

    public void update(Product p) throws TotalBuyException {
        dao.update(p);
    }

    public void delete(Product p) throws TotalBuyException {
        dao.delete(p);
    }

    
    //計算產品的總價值
    //當ps物件呼叫calculateProductInventory()並運算p的總價值時，
    //product接收產品的物件(p)參考值，做完運算後在回傳給p
    public static double calculateProductInventory(Product product){
        //回傳總價值
        return product.getUnitPrice() * product.getStock();
        
    }
    //運算單價
    public static void addPrice(Product p){
        //當設定單價的時候，並讀取原來的單價 + 100
        //原本的單價100 + 100運算完會存在p = 200
        //這個方法不可以加這行，p重新宣告，100只會加在addPrice的p參數裡，
        //main的Product p 不會有任何改變
        //p = new Product (999, "Hello", 50);
        p.setUnitPrice(p.getUnitPrice() + 100);
    }
    
    
    
}
