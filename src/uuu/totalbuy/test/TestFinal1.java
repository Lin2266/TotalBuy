package uuu.totalbuy.test;

public class TestFinal1 {
    //
    final int v;
    
    //
    public static final int sv;
    
    static {
        // 讀取並設定SV的值
        sv = 5;
    }
        
    public TestFinal1() {
        //v = 0;
        this(3);
    }
    
    public TestFinal1(int v) {
        this.v = v;
    }
    
}
