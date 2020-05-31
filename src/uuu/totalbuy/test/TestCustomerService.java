
package uuu.totalbuy.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.TotalBuyException;
import uuu.totalbuy.model.CustomerService;

public class TestCustomerService {

    public static void main(String[] args) {
        CustomerService cs = new CustomerService();
        
        try {Customer c1 = cs.login("A123456789", "123456");
          System.out.println(c1); 
        } catch (TotalBuyException ex) {
            System.out.println(ex);
        }
        
    }
    
}
