
package uuu.totalbuy.test;

public class TestAssertion {
    //除錯工具:資料或流程的錯誤
    public static void main(String[] args) {
        // age是從某地方讀來的值時
        int age = -2;
        
        // assert boolean;
        // assert boolean : 訊息;
        // 例外時只會顯示AssertionError
        // assert age >= 0; //年齡不能是負數
        // Assertion預設是關閉的，在run的vm加-ea才會啟動
        // assert在檢查age，後面加一些字，例外發生時AssertionError後面會加上這些字
        assert age >= 0 : "Age less than zero";
        // 除錯的工用，造成副作用，不應該有改變應用程式的資料
        assert age++ >= 0;
        
        
        
        
    }
    
}
