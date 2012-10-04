/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.controller.CClaimManager;
import cic.entity.Claim;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alfredo
 */
public class RegisterTest {
    
    public RegisterTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void registerClaimTest() {
    
        CClaimManager controller= CClaimManager.getInstance();
        String description="The car jumped down from the bridge!";
        Double costOfDamage=1000.0;
        Double priceOfCar=99999.0;
        String ssn="1234567890";
        Claim claim=new Claim(ssn, description,costOfDamage,priceOfCar);
        Boolean res=controller.registerClaim(ssn,claim);
        assertTrue(res);
        
        
    
    }
}
