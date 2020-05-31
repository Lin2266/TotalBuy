
package uuu.totalbuy.test;
//cp11-4 static
public class MyStatic {
    /*
    public int v;
    //加入static的屬性(sv),(配置記憶體),static的sv的值都會是一樣的
    public static int sv;
    */
    //為了不被破壞流水號，所以改private
    private int serial;
    private static int counter;
    //只要使用類別就會先從static方法優先跑過一次
    //把該建立好的東西先建立好可以建立多個static方法
    //static方法可以建立多個，由上往下
    //這方法的概念，如流水號想從哪邊接
    static{
        //從檔案讀取上次的值...(counter值改12)執行時流水號會從13開始
        counter = 12;
        System.out.println("static block");
    }
    
    public MyStatic(){
        System.out.println("Constructor");
        //如果屬性沒有加static，counter++加出來的每次顯示就會都是1
        counter++;
        serial = counter;
    }
    //屬性改private要建立get方法才可以呼叫
    public int getSerial(){
        return serial;
    }
    
    public static int getCounter(){
        //System.out.println(serial); (static方法不能直接存取物件)
        return counter;
    }
    
    

}
