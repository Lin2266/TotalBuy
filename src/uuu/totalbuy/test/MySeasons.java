
package uuu.totalbuy.test;
 
//cp 11-22~25 判斷春、夏、秋、冬，各自要做什麼事
public class MySeasons {
    
    public static void show(Seasons s){
        
        // Seasons檔案的enum列舉加在類別時，直接宣告四季，只能有四季這四種
        // 所以switch只能有這四種，可以不用default，其它的會編譯錯誤
        // show這邊就不用在宣告屬性
        
        switch (s){
            case SPRING:
                System.out.println("Spring");
                break;
            case SUMMER:
                System.out.println("Summer");
                break;
            case FALL:
                System.out.println("Fall");
                break;
            case WINTER:
                System.out.println("Winter");
                break;
            
                
            /*
            default:
                System.out.println("Error");
                break;
            */
        }
    }
    /*
    //變數名稱會是大寫(慣例)
    public static final int SPRING = 0;
    public static final int SUMMER = 1;
    public static final int FALL = 2;
    public static final int WINTER = 3;
    
    public static void show(int s) {
        switch (s){
            case SPRING:
                System.out.println("Spring");
                break;
            case SUMMER:
                System.out.println("Summer");
                break;
            case FALL:
                System.out.println("Fall");
                break;
            case WINTER:
                System.out.println("Winter");
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
    */
    
}
