package uuu.totalbuy.test;

import uuu.totalbuy.domain.BloodType;
import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.model.CustomersDAO;

public class TestCustomersDAO {

    public static void main(String[] args) {
        //TODO code application logic here
        CustomersDAO dao = new CustomersDAO();
        
        //Customer c = new Customer();
        
        try {//Customer c = new Customer("A123456222","彼得");
            //dao.delete(c);
            //Customer c = new Customer("A123456111","彼得","123555","021111");
            //dao.update(c);
            
//            Customer c = new Customer("B123456789","大衛","123456");
//            dao.insert(c);
            
//            Customer c = dao.get("A123456789");//bloo
//            System.out.println(c);//只要印出物件就會叫出toString
            //System.out.println(dao.getAll());
            
            for (Customer e : dao.getAll()) {
                System.out.println(e);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            //System.out.println(ex.getCause());
            
        }
        /*
        try {
            Customer c = dao.get("A246810111");
            System.out.println(c);
        } catch (Exception ex) {
            System.out.println(ex);
            //getCause()取得錯誤原來的原因
            System.out.println(ex.getCause());
        }
                  */
    }
    /*
    // TODO code application logic here
        CustomersDAO dao = new CustomersDAO();
        try{
            Customer c = new Customer(
                    "A123456761", "李四", "123456", "four_lee@uuu.com.tw");
            c.setBirthDate("1988/5/6");
            c.setBloodType(BloodType.AB);
            dao.insert(c);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
        try {            
            System.out.println(dao.getAll());        
            
            Customer c = dao.get("A123456789"); //block variable
            System.out.println(c);
            
            c.setAddress("台北市復興北路101號12F");
            dao.update(c);
            System.out.println(dao.get("A123456789"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        try {
            Customer c = dao.get("A223456761");
            System.out.println(c);
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println(ex.getCause());
        }
        
        try{
            Customer c = dao.get("A123456770");
            dao.delete(c);
            System.out.println(dao.get("A123456770"));
        }catch (Exception ex) {
            System.out.println(ex);
            System.out.println(ex.getCause());
        }
    }
    */
}
