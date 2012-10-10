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
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 
 */
public class ClassifiedClaimTest {
    
    public ClassifiedClaimTest() {
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
    public void retrieveSimpleClaimsTest(){
        CClaimManager control=CClaimManager.getInstance();
        ArrayList<Claim> sclaims=control.getSimpleClaimsNotPreliminaryComplete();
       
        assertTrue(sclaims.contains(Cic.claim5));
        assertFalse(sclaims.contains(Cic.claim0));
        assertFalse(sclaims.contains(Cic.claim1));
        assertFalse(sclaims.contains(Cic.claim2));
        assertFalse(sclaims.contains(Cic.claim3));
        assertFalse(sclaims.contains(Cic.claim4));
        assertFalse(sclaims.contains(Cic.claim6));
        
        
       
    }
    
    @Test
    public void retrieveComplexClaimsTest(){
    
        CClaimManager control=CClaimManager.getInstance();
        ArrayList<Claim> cclaims=control.getComplexClaimsNotPreliminaryComplete();
        
        assertTrue(cclaims.contains(Cic.claim4));
        assertFalse(cclaims.contains(Cic.claim0));
        assertFalse(cclaims.contains(Cic.claim1));
        assertFalse(cclaims.contains(Cic.claim2));
        assertFalse(cclaims.contains(Cic.claim3));
        assertFalse(cclaims.contains(Cic.claim5));
        assertFalse(cclaims.contains(Cic.claim6));
       
    }
    
    @Test
    public void retrieveCLassifiedClaimsTest(){
    
        CClaimManager control=CClaimManager.getInstance();
        ArrayList<Claim> cclaims=control.getClassifiedClaimsNotPreliminaryComplete();
        
        assertTrue(cclaims.contains(Cic.claim4));
        assertTrue(cclaims.contains(Cic.claim5));
        assertFalse(cclaims.contains(Cic.claim1));
        assertFalse(cclaims.contains(Cic.claim2));
        assertFalse(cclaims.contains(Cic.claim3));
        
        assertFalse(cclaims.contains(Cic.claim6));
    }
    
    
    
    
     @Test
     public void phoneGarageSimpleClaimTest() throws PriorityException {
      
         assertTrue(Cic.claim5.getPhoneGarageStatus()==ClaimStatus.NOT_COMPLETED);
         CClaimManager control=CClaimManager.getInstance();
         Boolean success=control.phoneGarage(Cic.claim5);
         assertTrue(Cic.claim5.getPhoneGarageStatus()==ClaimStatus.COMPLETED);
         assertTrue(success);
     }
     
  
     
    @Test
    public void CheckInsuranceSimpleClaimTest() {
         
      
         assertTrue(Cic.claim5.getCheckInsuranceStatus()==ClaimStatus.NOT_COMPLETED);
         
         CInsuredCheck control=new CInsuredCheck();
      
         control.checkInsuranceOfUserGivenClaim(Cic.claim5);
                  
         assertTrue(Cic.claim5.getCheckInsuranceStatus()==ClaimStatus.COMPLETED);
                
     }
    
    @Test
    public void CheckHistoryComplexClaimTest() throws PriorityException {
        Cic.claim4.setCheckInsuranceCompleted();
        assertTrue(Cic.claim4.getPreliminaryStatus()==ClaimStatus.NOT_COMPLETED);
        assertTrue(Cic.claim4.getCheckInsuranceStatus()==ClaimStatus.COMPLETED);
        assertTrue(Cic.claim4.getCheckHistoryStatus()==ClaimStatus.NOT_COMPLETED);
        assertTrue(Cic.claim4.getPhoneGarageStatus()==ClaimStatus.NOT_COMPLETED);
        
        CClaimManager.getInstance().CheckHistory(Cic.claim4);
        
        
        
        assertTrue(Cic.claim4.getCheckInsuranceStatus()==ClaimStatus.COMPLETED);
        assertTrue(Cic.claim4.getCheckHistoryStatus()==ClaimStatus.COMPLETED);
        assertTrue(Cic.claim4.getPhoneGarageStatus()==ClaimStatus.NOT_COMPLETED);
        assertTrue(Cic.claim4.getPreliminaryStatus()==ClaimStatus.NOT_COMPLETED);
     }
    
     @Test
    public void PhoneGarageComplexClaimTest() throws PriorityException {
        Cic.claim4.setCheckInsuranceCompleted();
        Cic.claim4.setCheckHistoryCompleted();
       
        assertTrue(Cic.claim4.getPreliminaryStatus()==ClaimStatus.NOT_COMPLETED);
        assertTrue(Cic.claim4.getCheckInsuranceStatus()==ClaimStatus.COMPLETED);
        assertTrue(Cic.claim4.getCheckHistoryStatus()==ClaimStatus.COMPLETED);
        assertTrue(Cic.claim4.getPhoneGarageStatus()==ClaimStatus.NOT_COMPLETED);
        
        
        CClaimManager.getInstance().phoneGarage(Cic.claim4);
        
        
        assertTrue(Cic.claim4.getCheckInsuranceStatus()==ClaimStatus.COMPLETED);
        assertTrue(Cic.claim4.getCheckHistoryStatus()==ClaimStatus.COMPLETED);
        assertTrue(Cic.claim4.getPhoneGarageStatus()==ClaimStatus.COMPLETED);
        assertTrue(Cic.claim4.getPreliminaryStatus()==ClaimStatus.COMPLETED);

     }
     
    @Test
    public void CheckInsuranceComplexClaimTest() {
        
        
        assertTrue(Cic.claim4.getPreliminaryStatus()==ClaimStatus.NOT_COMPLETED);
        assertTrue(Cic.claim4.getCheckInsuranceStatus()==ClaimStatus.NOT_COMPLETED);
        assertTrue(Cic.claim4.getCheckHistoryStatus()==ClaimStatus.NOT_COMPLETED);
        assertTrue(Cic.claim4.getPhoneGarageStatus()==ClaimStatus.NOT_COMPLETED);
        

        CInsuredCheck cont=new CInsuredCheck();
        cont.checkInsuranceOfUserGivenClaim(Cic.claim4);
        
        
        assertTrue(Cic.claim4.getCheckInsuranceStatus()==ClaimStatus.COMPLETED);
        assertTrue(Cic.claim4.getCheckHistoryStatus()==ClaimStatus.NOT_COMPLETED);
        assertTrue(Cic.claim4.getPhoneGarageStatus()==ClaimStatus.NOT_COMPLETED);
        assertTrue(Cic.claim4.getPreliminaryStatus()==ClaimStatus.NOT_COMPLETED);

     }
     
     
}
