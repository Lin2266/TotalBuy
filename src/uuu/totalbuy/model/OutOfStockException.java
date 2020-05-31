
package uuu.totalbuy.model;
// 例外類別, Checked
public class OutOfStockException extends Exception{
    //建構子:
    //OrderService檔throw new 呼叫OutOfStockException建構子把p.getName()
    //給message參數做設定，message接收p.getName()(Mouse)
    public OutOfStockException(String message) {
        //這邊沒有屬性，所以呼叫父類別把意外的訊息設定好
        super(message);
    }
}
