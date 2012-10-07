/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.Cic;
import cic.controller.CClaimManager;
import cic.entity.Claim;
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author alfredo
 */
public class PreviousHistoryTest {
    
    public PreviousHistoryTest() {
    }
    
    @Before
    public void setUp() {
        Cic.populate();
        
    }
    @Test
    public void pastHistoryTest(){
    
      String ssn=Cic.user.getSsn();
      CClaimManager c= CClaimManager.getInstance();
      ArrayList<Claim> otherClaims=c.getHistoryOfUser(ssn);
      
      assertTrue(otherClaims.contains(Cic.claim3));
      assertTrue(otherClaims.contains(Cic.claim6));
      
      assertFalse(otherClaims.contains(Cic.claim0));
      assertFalse(otherClaims.contains(Cic.claim1));
      assertFalse(otherClaims.contains(Cic.claim2));
      assertFalse(otherClaims.contains(Cic.claim4));
      assertFalse(otherClaims.contains(Cic.claim5));
      
    
    }
    
    @After
    public void tearDown() {
        
        Cic.clean();
    }
    
    
}
