package uuu.totalbuy.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//訂單
public class Order {

    private int id;
    private Date orderTime;//訂單時間
    private PaymentType paymentType; ///{0:面交,1:ATM,2:便利店,3:貨到付款}用列舉型別 
    private double paymentAmount;//運費
    private String paymentNote;

    private ShippingType shippingType; //{0:自取,1:便利店取貨, 2:送貨到府}用列舉型別  
    private double shippingAmount;//購物多少錢
    private String shippingNote;
    private String receiverName;//收件人名字
    private String receiverEmail;//收件人信箱
    private String receiverPhone;//收件人電話
    private String shippingAddress;
    private Status status;//0:新訂單 1:已付款 2:處理中 3:已出貨 4:已到貨 5:已簽收 6:已結案
    private BadStatus badStatus;//取消 0: 1:要求取消(還沒出貨前) 2:已取消 3:要求退貨 4:已退貨 5:要求退款 6:已退款 
    private Customer customer;
    //訂單明細的集合
    private List<OrderItem> orderItem;
    private double totalAmount;

    //non(非)-static initializer 類別載入記憶體時就會執行

    {
        orderTime = new Date();
        orderItem = new ArrayList<>();
    }

    public Order() {

    }

    //查詢客戶的一筆歷史訂單
    public Order(Customer customer) {
        this.customer = customer;
    }
    
    //結帳時建立新訂單
    public Order(Customer customer, ShoppingCart cart) {
        this.customer = customer;
        this.add(cart);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentNote() {
        return paymentNote;
    }

    public void setPaymentNote(String paymentNote) {
        this.paymentNote = paymentNote;
    }

    public ShippingType getShippingType() {
        return shippingType;
    }

    public void setShippingType(ShippingType shippingType) {
        this.shippingType = shippingType;
    }

    public double getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(double shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public String getShippingNote() {
        return shippingNote;
    }

    public void setShippingNote(String shippingNote) {
        this.shippingNote = shippingNote;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverphone) {
        this.receiverPhone = receiverphone;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BadStatus getBadStatus() {
        return badStatus;
    }

    public void setBadStatus(BadStatus badStatus) {
        this.badStatus = badStatus;
    }

    

    //訂單明細的管理程式
    //從資料庫查詢明細時使用
    public void add(OrderItem item) {
        orderItem.add(item);
    }

    //從結帳功能傳入購物車時使用
    public void add(ShoppingCart cart) {
//        購物車裡面的產品
        for (Product p : cart.getKeySet()) {
//            orderitem訂單明細
            OrderItem item = new OrderItem();
            item.setProduct(p);
            //當產品p不是outlet
            if(!(p instanceof Outlet) && this.customer instanceof VIP){
                //打折
                item.setPrice(p.getUnitPrice() * (100-((VIP)this.customer).getDiscount()) / 100);
            }else{
                //不打折, 設定產品單價
                item.setPrice(p.getUnitPrice());
            }
            
            item.setQuantity(cart.getQuentity(p));
            item.setFree(false);
            orderItem.add(item);
        }
    }

    //delegate methods(委托方法) 數量by List<OrderItem>
    public int size() {
        return orderItem.size();
    }

    public boolean isEmpty() {
        return orderItem.isEmpty();
    }

    //明細總金額(運費 + 購物多少錢),有總金額才看的到明細
    public double getTotalAmount() {
        //訂單明細不是null而且數量大於0時
        if (orderItem != null && orderItem.size() > 0) {
            double sum = 0;
            for (OrderItem item : orderItem) {
                //訂單明細是免費時，0:價錢乘以數量
                sum += (item.isFree() ? 0 : item.getPrice() * item.getQuantity());
            }
            //運費 + 購物多少錢
            sum += paymentAmount + shippingAmount;
            return sum;
        } else {
            return totalAmount + paymentAmount + shippingAmount;
        }
    }

    //computed column from DB

    public void setTotalAmount(double amount) {
        this.totalAmount = amount;
    }
   
    //訂單有明細怎麼讓人看到,不能讓人改，集合不能get跟set，以下列子可以
    public List<OrderItem> getItems() {
        //Collections.unmodifiableList(集合修改列表)
        //不能更改明細，改變明細內容就會錯
        //return Collections.unmodifiableList(this.orderItem);//回傳readonly(只讀)的集合
        //clone副本(把物件變成副本)回傳原集合的副本,但沒有寫clone這個東西
        //會自動排序列表，被改也不會有影響
        return new ArrayList<>(this.orderItem);//回傳原集合的副本
    }

//    付款方式 + (維護方式)
    public enum PaymentType {
//        列舉值(付款方式)建構子有設定字串描述，列舉值就要加字串
        //宣告陣列直接指派時，可以省略中括號
        FACE("面交", new ShippingType[]{ShippingType.SELF}),
        ATM("ATM轉帳", new ShippingType[]{ShippingType.STORE, ShippingType.HOME}),
        STORE("便利店付款", new ShippingType[]{ShippingType.STORE}),
        HOME("貨到付款", 50, new ShippingType[]{ShippingType.HOME});

//        列出中文描述
        private final String description;//ReadOnly ("面交")
        private final double amount;//ReadOnly(運費)
        private final ShippingType[] shippingArray;
        //列舉值透過建構子設定字串

        private PaymentType(String description, ShippingType[] shippingArray) {
            this(description, 0, shippingArray);
        }
        //面交、運費、取貨方式
        private PaymentType(String description, double amount, ShippingType[] shippingArray) {
            this.description = description;
            this.amount = amount;
            this.shippingArray = shippingArray;
            
        }

        public String getDescription() {
            return description;
        }

        public double getAmount() {
            return amount;
        }
         public ShippingType[] getShippingArray() {
            return shippingArray.clone();
        }
         @Override
        public String toString() {
            return  String.format("%s-%s", this.name(), description);
        }      

    }

    //購物型態
    public enum ShippingType {

        SELF("自取"), STORE("便利店取貨", 60), HOME("送貨到府", 100);
        private final String description;//ReadOnly
        private final double amount;//ReadOnly

        private ShippingType(String description) {
            this(description, 0);

        }

        private ShippingType(String description, double amount) {
            this.description = description;
            this.amount = amount;
        }

        public String getDescription() {
            return description;
        }

        public double getAmount() {
            return amount;
        }
         @Override
        public String toString() {
            return  String.format("%s-%s", this.name(), description);
        }   

    }

    public enum Status {

        NEW("新訂單"), PAID("已付款"), PROCESS("處理中"), SHIPPED("已出貨"), ARRIVED("已到貨"), CHECKED("已簽收"), CLOSED("已結案");
        private final String description;

        private Status(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
         @Override
        public String toString() {
            return  String.format("%s-%s", this.name(), description);
        }      

    }

    public enum BadStatus {

        NONE("無"), CANCEL("要求取消"), CANCELED("已取消"), REJECT("要求退貨"), REJECTED("已退貨"), REFUND("要求退款"), REFUNDED("已退款");
        private final String description;

        private BadStatus(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
         @Override
        public String toString() {
            return  String.format("%s-%s", this.name(), description);
        }      
    }

}
