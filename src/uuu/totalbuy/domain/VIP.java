
package uuu.totalbuy.domain;
//9-18作業繼承Customer vip9-5
public class VIP extends Customer{
    private int discount=10;//10=打9折

    public VIP() {
    }
    
    //p2-20
    public VIP(String id, String name){
        super(id, name);
    }

    public VIP(String id, String name, String password) {
        super(id, name, password);
    }

    public VIP(String id, String name, String password, String email) {
        super(id, name, password, email);
    }

    public VIP(int discount, String id, String name, String password, String email) {
        super(id, name, password, email);
        this.discount = discount;
    }

    
    /* Ｐ9-29
    public VIP(String id, String name, String address){
        super();
        this.discount = discount;
    }
     */         
    /*這是測試 p9-29
    //父類別沒有這個建構子
    public VIP(int discount){
        this.discount = discount;
    }
    */
    
    public int getDiscount() {
        return discount;
    }
    //方法不用拋例外，因為不是給使用者知道的
    public void setDiscount(int discount) {
        if (discount >= 0 && discount <= 95) {
            this.discount = discount;   
        }else{
            //給系統一個錯誤訊息
            //throw new IllegalArgumentException("discount必須在0~95之間");
            System.out.println("discount必須在0~95之間");
            
        }
    }
  
    public double getRate(){
        return ((100 - getDiscount()) / 100.0);
    }
    @Override
    public String toString(){
        return super.toString() + "\n" +
                     "Discount:  " + getDiscount();
    }
    
    
    
}
