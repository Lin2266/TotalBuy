package uuu.totalbuy.other;
////9-18作業繼承Prodact Outletp9-14

public class Outlet extends Product {

    private int discount = 20;//打八折

    public Outlet() {
    }
    

    public Outlet(int id, String name, double unitPrice,
                 boolean free, int stock,int discount) {
        super(id, name, unitPrice, free, stock);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override //售價
    public double getUnitPrice() {
        //單價 * (100-20(幾折)/100) = (0.8) 
        return super.getUnitPrice() * ((100 - getDiscount()) / 100.0);
    }

    //原價

    public double getListPrice() {
        return super.getUnitPrice();
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + 
               "Discount:  " + getDiscount();

    }

    //覆寫equals

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        
        if (obj != null) {
            if (obj instanceof Outlet) {
                Outlet o = (Outlet) obj;
                if (super.equals(obj) && 
                    getDiscount() == o.getDiscount()) {
                    result = true;
                }

            }
        }
        return result;
    }
}
