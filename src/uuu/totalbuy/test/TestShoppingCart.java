/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.test;

import java.util.List;
import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.Product;
import uuu.totalbuy.domain.ShoppingCart;
import uuu.totalbuy.domain.TotalBuyException;
import uuu.totalbuy.model.CustomerService;
import uuu.totalbuy.model.ProductService;

/**
 *
 * @author Administrator
 */
public class TestShoppingCart {
    public static void main(String[] args) throws TotalBuyException {
//        會員客戶登入
        Customer user = new CustomerService().login("A123456789", "123456");
        System.out.println("登入的會員客戶:\n"+user);
//        取得所有產品清單
        List<Product> list = new ProductService().getAll();
        System.out.println("所有產品清單:");
        for(Product p: list)
        System.out.println(p + "\n");//共6項產品
        System.out.println("==========================================");
        
        ShoppingCart cart = new ShoppingCart(user);//會員客戶到購物車
        //add(參數1)產品，取得index 0為1號產品增加到購物車
        //cart.add(list.get(0));
        //add(參數1，參數2)產品，數量，index 1為1號產品index 2為增加2支
        cart.add(new ProductService().get(1), 2);
        System.out.println(cart);
        
        
//        cart.add(list.get(3), 2);//3號產品增加2支
//        System.out.println(cart);
        
    }
}
