package uuu.totalbuy.model;

import java.util.List;
import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.Order;
import uuu.totalbuy.domain.Product;
import uuu.totalbuy.domain.TotalBuyException;
import uuu.totalbuy.domain.VIP;

public class OrderService {
// 庫存量不夠的問題可以用例外,OutOfStockException檔    
    private OrdersDAO dao = new OrdersDAO();
    
    public OrderService() {
    }
    //訂單結帳
    public void checkOut(Order order) throws TotalBuyException{
        dao.insert(order);
    }
    
    public Order get(int orderId) throws TotalBuyException{
        Order order = dao.get(orderId);
        return order;
    }
    //查詢訂單歷史
    public List<Order> getOrdersHistory(String id) throws TotalBuyException{
        return dao.getAllByCustomerId(id);
    }
    //訂單，哪種客戶有哪種折扣傳回折扣後的金額
    public static double order(Customer c, Product p, int quantity)
              throws OutOfStockException {
        //方法加throws:庫存量不夠時，呼叫訂單時就會把錯拋出去
        if (p.getStock() < quantity) {
        //庫存量不夠的時候就拋錯，產品的名稱:庫存量剩多少
            throw new OutOfStockException(p.getName());
        }

        // rtn(購買的金額) = 單價 * 數量
        double rtn = p.getUnitPrice() * quantity;

        if (c instanceof VIP) {
            VIP v = (VIP) c;
//            rtn *= (100 - v.getDiscount()) / 100; //(100 -(v)20) / 100 = 0.8
           rtn *= v.getRate();
        }
        return rtn;//回傳打折後的金額
    }

}
