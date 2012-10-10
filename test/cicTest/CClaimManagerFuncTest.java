/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.Cic;
import cic.controller.CClaimManager;
import cic.controller.CInsuredCheck;
import cic.entity.Claim;
import cic.entity.ClaimStatus;
import cic.entity.User;
import cic.entity.exceptions.PriorityException;
import cic.controller.CUserManager;
import cic.entity.ClaimComplexity;
import java.util.ArrayList;
import javax.naming.AuthenticationException;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author alfredo
 */
public class CClaimManagerFuncTest {
    
    public CClaimManagerFuncTest() {
    }
    
    @Before
    public void setup(){
        Cic.populate();
    }
    
    @After 
     public void clean(){
     Cic.clean();
    }
    
    
    @Test
    public void checkCClaimManagerGetInstance(){
        CClaimManager control=CClaimManager.getInstance();
        assertTrue(control != null);
       
    }
    
    @Test
    public void checkCClaimManagerGetUnclassifiedClaims() throws AuthenticationException{
        
        ArrayList<Claim> unclassifiedClaims=CClaimManager.getInstance().getUnclassifiedClaims();
        assertFalse(unclassifiedClaims.isEmpty());
       
    }
    
    @Test
    public void checkCClaimManagerremoveClaim(){
      
      Claim claim;
      
      CClaimManager c= CClaimManager.getInstance();
      Integer id = Cic.claim0.getId();
      c.removeClaim(Cic.claim0);
      assertFalse(c.search(id.toString()).contains(Cic.claim0));
       
    }
    
    
    @Test
    public void checkCClaimManagerUpdateClaimPreliminaryStatus1simple(){
      
        CClaimManager control=CClaimManager.getInstance();
        
        
        assertTrue(Cic.claim5.getPreliminaryStatus() == ClaimStatus.NOT_COMPLETED);
        
        Cic.claim5.setPhoneGarageCompleted();
        assertTrue(Cic.claim5.getPreliminaryStatus() == ClaimStatus.NOT_COMPLETED);
        
        Cic.claim5.setCheckInsuranceCompleted();
        
        control.updateClaimPreliminaryStatus(Cic.claim5);
        
        assertTrue(Cic.claim5.getPreliminaryStatus() == ClaimStatus.COMPLETED);
        
        
    }
    
        @Test
    public void checkCClaimManagerUpdateClaimPreliminaryStatus2simple(){
      
        CClaimManager control=CClaimManager.getInstance();
        
        assertTrue(Cic.claim5.getPreliminaryStatus() == ClaimStatus.NOT_COMPLETED);
        Cic.claim5.setCheckInsuranceCompleted();
        
        assertTrue(Cic.claim5.getPreliminaryStatus() == ClaimStatus.NOT_COMPLETED);
        
        Cic.claim5.setPhoneGarageCompleted();
        
        control.updateClaimPreliminaryStatus(Cic.claim5);
        
        assertTrue(Cic.claim5.getPreliminaryStatus() == ClaimStatus.COMPLETED);
        
        
    }
        
    @Test
    public void checkCClaimManagerUpdateClaimPreliminaryStatusComplex() throws PriorityException{
      
        CClaimManager control=CClaimManager.getInstance();
        
        assertTrue(Cic.claim4.getPreliminaryStatus() == ClaimStatus.NOT_COMPLETED);
        Cic.claim4.setCheckInsuranceCompleted();
        
        assertTrue(Cic.claim4.getPreliminaryStatus() == ClaimStatus.NOT_COMPLETED);
        
        Cic.claim4.setCheckHistoryCompleted();
        
        assertTrue(Cic.claim4.getPreliminaryStatus() == ClaimStatus.NOT_COMPLETED);
        
        Cic.claim4.setPhoneGarageCompleted();
        
        control.updateClaimPreliminaryStatus(Cic.claim4);
        
        assertTrue(Cic.claim4.getPreliminaryStatus() == ClaimStatus.COMPLETED);
        
        
    }
    
    
    
    
    
}
