
package uuu.totalbuy.test;

import uuu.totalbuy.domain.BloodType;

public class TestBloodType {

    public static void main(String[] args) {
        
        for(BloodType bType:BloodType.values()){
            System.out.println(bType);
        }
        
        System.out.println(BloodType.A);
    }
    
}
