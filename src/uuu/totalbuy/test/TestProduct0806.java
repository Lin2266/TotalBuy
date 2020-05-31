
package uuu.totalbuy.test;

import uuu.totalbuy.domain.Product;

public class TestProduct0806 {

    public static void main(String[] args) {
        //建立好物件的的時候，參考值(地址)會把存放在記憶體空間的物件放在p物件裡，
        //然後互相連結
        Product p = new Product(1, "Mouse", 100,true,100);
        Product p2 = new Product(2, "Keyboard", 200,true,100);
        
        System.out.println(p.toString());
        System.out.println("=================");
        System.out.println(p2.toString());
        System.out.println("=================");
        //指定參考值(考試會考)
        //p2指定值(參考值)給p，所以p顯示出來的會是跟p2一樣
        //自動回收(GC):清除沒有使用的物件
        p = p2;
        p.setUnitPrice(300);
        //p重新宣告一個物件時，p的參考值會變新宣告的參考值，原本的參考值會清除
        p = new Product(3, "Phone", 500,true,100);
        System.out.println(p.getUnitPrice());
        System.out.println(p2.getUnitPrice());
        //把兩個物件變成請java幫我們回收狀態
        p = null;
        p2 = null;

        //System.out.println(p.getDetails());
        //System.out.println(p2.getDetails());
        
        //物件參考變數不可以使用==比較它們是否一樣
        //物件參考變數使用==是比較它們的參考值
        //System.out.println(p == p2);
    }
    
}
