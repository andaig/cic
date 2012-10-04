/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.controller.CInsuredCheck;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alfredo
 */
public class CheckInsuredTest {
    
    public CheckInsuredTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void checkInsuredSuccessful() {
         String ssn="1234567890";
         CInsuredCheck controller= new CInsuredCheck();
         Boolean isInsured=controller.checkInsured(ssn);
         assertTrue(isInsured);
     
     }
     
     
     @Test
     public void checkInsuredUnsuccessful() {
         String ssn="whatever";
         
         CInsuredCheck controller= new CInsuredCheck();
         Boolean isInsured=controller.checkInsured(ssn);
         assertFalse(isInsured);
     
     }
}
