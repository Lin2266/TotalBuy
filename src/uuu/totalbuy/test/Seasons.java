
package uuu.totalbuy.test;
//cp 11-22~25 判斷春、夏、秋、冬，各自要做什麼事
// enum(列舉)專門在處理像四季、或血型之類的，與MySeasons檔案的switch運用
//列舉四個就只會有四個
public enum Seasons {
    //列舉型態的成員，基礎
    //SPRING,SUMMER,FALL,WINTER
    
    //(1)
    //加強:成員名稱後面使用左右括號，裡面設定對應的資料,最後要加;
    //全部設定完錯誤才會消失(規則) 
    //想像成呼叫建構子，然後把值給建構子設定
    SPRING("Spring"), SUMMER("Summer"), FALL("Fall"), WINTER("Winter");
    
    //(2)
    //宣告儲存成員對應資料的屬性
    private String name;
    
    //(3)
    //接收成員對應資料的建構子
    //到這邊三個部份做完錯誤就會消失
    //值過來這邊會給name做設定
    private Seasons(String name) {
        this.name = name;
    }
    
    //(4)可有可無
    //把值在建構子裡設定完就可以直接呼叫這邊
    public String getName(){
        return name;
    }
    
    
    
    
}
