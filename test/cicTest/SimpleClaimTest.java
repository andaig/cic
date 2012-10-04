/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.controller.CClaimManager;
import cic.controller.CCommunicationManager;
import cic.entity.ClaimStatus;
import cic.entity.SimpleClaim;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alfredo
 */
public class SimpleClaimTest {
    
    public SimpleClaimTest() {
    }
    
   
     @Test
     public void phoneGarageTest() {
         
         SimpleClaim sc=new SimpleClaim("1234567890", "desc", 10.0, 11.1);
         
        assertTrue(sc.getPhoneGarageStatus()==ClaimStatus.NOT_COMPLETED);
         
         CClaimManager control=CClaimManager.getInstance();
      
         Boolean success=control.phoneGarageForSimpleClaim(sc);
                  
         assertTrue(sc.getPhoneGarageStatus()==ClaimStatus.COMPLETED);
                
         assertTrue(success);
         
     
     }
}
