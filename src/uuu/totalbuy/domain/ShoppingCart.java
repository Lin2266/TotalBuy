/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class ShoppingCart {

    private Customer user;
    //因為購物車要有『產品跟數量』所以用map『key,vaule』
    private Map<Product, Integer> cart;

    public ShoppingCart() {
        cart = new HashMap<Product, Integer>() {
            @Override
            public String toString() {//info信息
                StringBuilder info = new StringBuilder();
                for (Product p : this.keySet()) {
                    info.append(p.toString());
                    info.append("\n共買了 " + this.get(p) + " 支");                              
                }
                return info.toString();
            }
        };
    }
    //會員登入購物車時，會呼叫自已的無參數建構子
    public ShoppingCart(Customer user) {
        this();
        this.user = user;
    }

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

    public void add(Product p) {
        add(p, 1);
    }
    //增加(產品，數量)
    public void add(Product p, int quantity) {
        Integer q = cart.get(p);//取得幾1產品到購物車包裝成數字物件
        if (q != null) {//產品不是null
            //哪個產品，0數量+幾個產品=產品數量(quantity)增加到購物車
            cart.put(p, quantity + q);
        } else {
            cart.put(p, quantity);//為0
        }
    }

    public void update(Product p, int quantity) {
        cart.put(p, quantity);
    }

    public void remove(Product p) {
        cart.remove(p);
    }
//一筆
    public Set<Product> getKeySet() {
        return cart.keySet();
    }
    //產品數量
    public int getQuentity(Product p) {
        Integer q = cart.get(p);
        return (q == null ? 0 : q);
    }
//    一般客戶的總額計算
    public double getListTotalAmount() {
        if (cart != null && !cart.isEmpty()) {
            double total = 0;
            for (Product p : cart.keySet()) {
                total += p.getUnitPrice() * cart.get(p);
            }
            return total;
        } else {
            return 0;
        }
        
    }
//    vip總金額,最後交易在四捨五入，不然金額會有誤差
    public double getTotalAmount() {
        
        if (user==null || !(user instanceof VIP)){
            return this.getListTotalAmount();
        }
//        購物車不是空的而且是vip
        if (cart != null && !cart.isEmpty()) {
            double total = 0;
            for (Product p : cart.keySet()) {
              if(p instanceof Outlet) {  
                total += p.getUnitPrice() * cart.get(p);
              }else{
//                  VIP要測試，要注意整數要先算，不要跟double一起算
                  total += p.getUnitPrice() * (100 - ((VIP)user).getDiscount())/100* cart.get(p);
              }
            }
            return total;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "購物車:\n" + "客戶:" + user + "\n"
                  + "買了產品:\n" + cart + "\n"
                  + "總金額:" + this.getTotalAmount();
    }

}
