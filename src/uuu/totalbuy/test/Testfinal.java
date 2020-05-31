
package uuu.totalbuy.test;
//cp11-18 final變數
public class Testfinal {
    // final變數:宣告時沒有指派值給變數會編譯錯誤
    //v沒有值又是final不能動時，就要透過建構子設定
     final int v;
     //final變數又加static沒有設定值時，要先在static區塊中設定初值
     public static final int sv;
     //執行類別時，這個區塊就會先執行一次
     static {
         //讀取並設定sv的值
         sv = 5;
     }
     //final變數(v)透過建構子設定完以後，就不會改了
     public Testfinal(int v){
         this.v = v; //(v = 3)
         
     }
     //呼叫this把類別的建構子裡面有3的值拿出來用(v)
     public Testfinal(){
         this(3);
     }
     
     
    
    
    
    
}
