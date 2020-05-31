
package uuu.totalbuy.test;
//cp11-4 static
public class TestMyStatic {
    // JVM(虛擬機器) 呼叫 main()
    // public:
    // static:
    // java TestStatic Hello Simon "Hi Mary" (遇到空格轉換一個元素)
    // args [0] = "Hello"
    // args [1] = "Simon"
    // args [2] = "Hi Mary"
    public static void main(String[] args) {
        
        MyStatic ms = new MyStatic();
        MyStatic ms2 = new MyStatic();
        //MyStatic.counter = 100; //counter的方法有累加，所以這裡會從100+1
        MyStatic ms3 = new MyStatic();
        MyStatic ms4 = new MyStatic();
        MyStatic ms5 = new MyStatic();
        //加了static的屬性，建立了累加的方法以後的結果
        //怕被破壞流水號，屬性改private的時候，這邊直接呼叫方法就好
        System.out.println(ms.getSerial());
        System.out.println(ms2.getSerial());
        System.out.println(ms3.getSerial());
        System.out.println(ms4.getSerial());
        System.out.println(ms5.getSerial());
        
        /*
        System.out.println(ms.v);
        System.out.println(ms2.v);
        System.out.println(ms3.v);
        //沒加static
        ms2.v = 3; //(ms = 0, ms2 = 3, ms3 = 0)
        //有加static，ms全部都會是static
        // ms2.sv = 3; (ms = 3, ms2 = 3, ms3 = 3)
        System.out.println(ms.v);
        System.out.println(ms2.v);
        System.out.println(ms3.v);
        */          
        
    }
    
}
