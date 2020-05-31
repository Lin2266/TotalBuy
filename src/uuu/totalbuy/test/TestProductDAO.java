/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.test;

import uuu.totalbuy.domain.Product;
import uuu.totalbuy.domain.TotalBuyException;
import uuu.totalbuy.model.ProductsDAO;

/**
 *
 * @author LIN
 */
public class TestProductDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TotalBuyException {
        ProductsDAO pd = new ProductsDAO();
       try{
//           Product p = new Product("mouse",200,false,50);
//           pd.insert(p);
            //Product p = new Product(2,"KEY");
           //pd.update(p);
           //Product p = new Product(2,"KEY");
           //pd.delete(p);
           //Product p = pd.get(2);
           //.out.println(p);
           for(Product p:pd.getAll()){
               System.out.println(p);
           }
           
       } 
       catch(Exception ex){
            ex.printStackTrace();
            System.out.println("查詢失敗:"+ ex.getCause());
       }
        
        
    }
    
}
