package cicTest;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import cic.Cic;
import cic.controller.CClaimManager;
import cic.controller.CUserManager;
import cic.entity.Claim;
import cic.entity.ClaimStatus;
import cic.entity.Decision;

import cic.entity.User;
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author alfredo
 */
public class DecideTest {
   
    
    public DecideTest() {
    }
    
    @Before
    public void setUp() {
       Cic.populate();
        
          
    }
    
    @Test
       
    public void getClaimsToDecideTest() {
        ArrayList<Claim> preliminaryCompleteClaims;
        CClaimManager cont=CClaimManager.getInstance();
        preliminaryCompleteClaims=cont.getPreliminaryCompleteClaims();
        assertTrue(preliminaryCompleteClaims.contains(Cic.claim2));
        assertFalse(preliminaryCompleteClaims.contains(Cic.claim3));
        
    }
    
    
    @Test
    public void decideNotOk(){
        
        CClaimManager cont=CClaimManager.getInstance();
        Boolean res=cont.decide(Cic.claim6, Decision.NOK, "Your claim was not approved");
        assertTrue(res);
        assertTrue(Cic.claim6.getFinalDecision()==Decision.NOK);
        assertTrue(Cic.claim6.getPreliminaryStatus()==ClaimStatus.COMPLETED);
        assertTrue(Cic.claim6.getOverallStatus()==ClaimStatus.COMPLETED);        
    }
    
    
    @After
    public void clean(){
     
    }

}
