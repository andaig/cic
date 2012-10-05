/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.Cic;
import cic.controller.CInsuredCheck;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

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
    @Before
    public void setUp(){
        Cic.populate();
    }
    
    @After
    public void clean(){
        Cic.clean();
    }
    
     @Test
     public void checkInsuredSuccessful() {
         String ssn=Cic.user.getSsn();
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
