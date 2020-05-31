
package uuu.totalbuy.test;
//cp 11-22~25 判斷春、夏、秋、冬，各自要做什麼事
public class TestMySeasons {

    public static void main(String[] args) {
        
        //Seasons.values() => Seasons[]
        //四季都跑一遍
        for (Seasons s : Seasons.values()){
            //System.out.println(s.getName());
            System.out.println(s.name());
            //java會自動幫enum做編號
            System.out.println(s.ordinal());
            //if判斷四字
            if (s == Seasons.SUMMER){
                System.out.println(s.getName());
                
            }
        }
        
        
        
        //enum加強完，Seasons呼叫SUMMER裡的名字，會直接到屬性那把值給建構子設定，
        //在從呼叫getName()回傳，這時就用不到MySeasons檔的switch了
        //System.out.println(Seasons.SUMMER.getName());
        //System.out.println(Seasons.SPRING.getName());
        
        //Seasons類別加enum列舉的時候與MySeasons檔案裡的switch運用，
        //show裡的switch可以不用加default
        //MySeasons.show(Seasons.SUMMER);
        //MySeasons.show(Seasons.SPRING);
        /*
        //show裡面沒有這些值，
        MySeasons.show(32);
        MySeasons.show(-25);
        */
        }
    
}
