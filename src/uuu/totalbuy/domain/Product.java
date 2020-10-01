package uuu.totalbuy.domain;
//課本3-13習題，4-12習題改3-13
//產品 

import java.text.NumberFormat;


public class Product {

    private int id;//auto increment自動給號
    private String name;//名稱
    private double unitPrice;//單價
    //自行設定的值，如:10元商品單價全都10的情況下
    //private double unitPrice = 10;
    private boolean free;//判斷是否免費
    private int stock;//庫存
    private String url;
    private String description;//描述
    private int status;//狀態 0:新產品 1:上架 2:停售 3:停產
    public static final NumberFormat PRICE_FORMAT;//數字格式
     
    //5-7習題
    //jsp需要無參數建構子
    static {
        PRICE_FORMAT = NumberFormat.getInstance();
        PRICE_FORMAT.setMaximumFractionDigits(2);//數字最大範圍
        PRICE_FORMAT.setMinimumFractionDigits(0);//最小範圍
    }

    public Product() {
    }
    
    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Product(int id, String name, double unitPrice) {
        this(id, name);
        this.unitPrice = unitPrice;
    }
   
    
     //商品不是10元的時候
    public Product(int id, String name, double unitPrice,
              boolean free, int stock) {
        this(id, name);
        this.unitPrice = unitPrice;
        this.free = free;
        this.stock = stock;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

      public int getStatus() {
        return status;
    }
      
    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    //回傳free是true(免費)還是false(不是免費)
    public boolean isFree() {
        return free;
    }
    
    //產品是否免費，設定free是true還是false
    public void setFree(boolean free) {
        this.free = free;
    }
    
     public int getStock() {
        return stock;
    }
    
     public void setStock(int stock) {
        this.stock = stock;
    }
     
    //進貨
    public void incStock(int amount) {
        stock = stock + amount;

    }

    //出貨 要判斷不能超額
    public void decStock(int amount) {
        if (amount <= stock) {
            stock = stock - amount;
        }

    }
//    會亂數
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    
     @Override
    public boolean equals(Object obj) {        
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
     @Override
    public String toString() {
        
        return "ID      :" + getId() + "\n" + 
               "產品    : " + getName() + "\n" + 
               "單價    : " + getUnitPrice() + "\n" +
                //判斷isFree是不是免費，用三元運算子?:
               "是否免費: " + (isFree() ? "YES" : "NO") + "\n" +
               "庫存    : " + getStock()+ "\n" +
               "URL     :" + getUrl()+ "\n";
        
    }
}
