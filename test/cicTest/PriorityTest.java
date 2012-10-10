/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.Cic;
import cic.controller.CClaimManager;
import cic.controller.CInsuredCheck;
import cic.entity.ClaimStatus;
import cic.entity.exceptions.PriorityException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alfredo
 */
public class PriorityTest {
    
    public PriorityTest() {
    }
    
    @Before
    public void setUp() {
        Cic.populate();
    }
    
    @After
    public void tearDown() {
        Cic.clean();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    public void simpleClaimPriorityPhoneFirst() throws PriorityException {
         //phone garage is performed before check insurance 
         //for simple claim
     
         assertTrue(Cic.claim5.getPhoneGarageStatus()==ClaimStatus.NOT_COMPLETED);
         assertTrue(Cic.claim5.getCheckInsuranceStatus()==ClaimStatus.NOT_COMPLETED);
         assertTrue(Cic.claim5.getPreliminaryStatus()==ClaimStatus.NOT_COMPLETED);
         
         CClaimManager.getInstance().phoneGarage(Cic.claim5);
         CInsuredCheck ci=new CInsuredCheck();
         ci.checkInsuranceOfUserGivenClaim(Cic.claim5);
     
         assertTrue(Cic.claim5.getPhoneGarageStatus()==ClaimStatus.COMPLETED);
         assertTrue(Cic.claim5.getCheckInsuranceStatus()==ClaimStatus.COMPLETED);
         assertTrue(Cic.claim5.getPreliminaryStatus()==ClaimStatus.COMPLETED);
  
    }
     
     
    @Test
    public void simpleClaimPriorityCheckInsuranceFirst() throws PriorityException {
         //phone garage is performed before check insurance 
         //for simple claim
    
         assertTrue(Cic.claim5.getPhoneGarageStatus()==ClaimStatus.NOT_COMPLETED);
         assertTrue(Cic.claim5.getCheckInsuranceStatus()==ClaimStatus.NOT_COMPLETED);
         assertTrue(Cic.claim5.getPreliminaryStatus()==ClaimStatus.NOT_COMPLETED);

         CInsuredCheck ci=new CInsuredCheck();
         ci.checkInsuranceOfUserGivenClaim(Cic.claim5);

         CClaimManager.getInstance().phoneGarage(Cic.claim5);
     
         assertTrue(Cic.claim5.getPhoneGarageStatus()==ClaimStatus.COMPLETED);
         assertTrue(Cic.claim5.getCheckInsuranceStatus()==ClaimStatus.COMPLETED);
         assertTrue(Cic.claim5.getPreliminaryStatus()==ClaimStatus.COMPLETED);
    }
    
    
    @Test
    public void complexClaimNormalFlow() throws PriorityException {
         //phone garage is performed before check insurance 
         //for simple claim
     
         assertTrue(Cic.claim4.getPhoneGarageStatus()==ClaimStatus.NOT_COMPLETED);
         assertTrue(Cic.claim4.getCheckInsuranceStatus()==ClaimStatus.NOT_COMPLETED);
         assertTrue(Cic.claim4.getCheckHistoryStatus()==ClaimStatus.NOT_COMPLETED);
         assertTrue(Cic.claim4.getPreliminaryStatus()==ClaimStatus.NOT_COMPLETED);
         
         CInsuredCheck ci=new CInsuredCheck();
         ci.checkInsuranceOfUserGivenClaim(Cic.claim4);
     
         CClaimManager.getInstance().phoneGarage(Cic.claim4);
         CClaimManager.getInstance().CheckHistory(Cic.claim4);
         
         assertTrue(Cic.claim4.getCheckHistoryStatus()==ClaimStatus.COMPLETED);
         assertTrue(Cic.claim4.getPhoneGarageStatus()==ClaimStatus.COMPLETED);
         assertTrue(Cic.claim4.getCheckInsuranceStatus()==ClaimStatus.COMPLETED);
         assertTrue(Cic.claim4.getPreliminaryStatus()==ClaimStatus.COMPLETED);
  
    }
    
   
    @Test(expected=PriorityException.class)
    public void complexClaimHistoryInsurancePhone() throws PriorityException {
         //phone garage is performed before check insurance 
         //for simple claim
     
         assertTrue(Cic.claim4.getPhoneGarageStatus()==ClaimStatus.NOT_COMPLETED);
         assertTrue(Cic.claim4.getCheckInsuranceStatus()==ClaimStatus.NOT_COMPLETED);
         assertTrue(Cic.claim4.getCheckHistoryStatus()==ClaimStatus.NOT_COMPLETED);
         assertTrue(Cic.claim4.getPreliminaryStatus()==ClaimStatus.NOT_COMPLETED);
         
         CClaimManager.getInstance().CheckHistory(Cic.claim4);
         
         CInsuredCheck ci=new CInsuredCheck();
         ci.checkInsuranceOfUserGivenClaim(Cic.claim4);
     
         CClaimManager.getInstance().phoneGarage(Cic.claim4);
         
         
         assertTrue(Cic.claim4.getCheckHistoryStatus()==ClaimStatus.COMPLETED);
         assertTrue(Cic.claim4.getPhoneGarageStatus()==ClaimStatus.COMPLETED);
         assertTrue(Cic.claim4.getCheckInsuranceStatus()==ClaimStatus.COMPLETED);
         assertTrue(Cic.claim4.getPreliminaryStatus()==ClaimStatus.COMPLETED);
  
    }
    
    
    @Test(expected=PriorityException.class)
    public void complexClaimPhoneHistoryInsurance() throws PriorityException {
         //phone garage is performed before check insurance 
         //for simple claim
     
         assertTrue(Cic.claim4.getPhoneGarageStatus()==ClaimStatus.NOT_COMPLETED);
         assertTrue(Cic.claim4.getCheckInsuranceStatus()==ClaimStatus.NOT_COMPLETED);
         assertTrue(Cic.claim4.getCheckHistoryStatus()==ClaimStatus.NOT_COMPLETED);
         assertTrue(Cic.claim4.getPreliminaryStatus()==ClaimStatus.NOT_COMPLETED);
  
         CClaimManager.getInstance().phoneGarage(Cic.claim4);
         CClaimManager.getInstance().CheckHistory(Cic.claim4);
         CInsuredCheck ci=new CInsuredCheck();
         ci.checkInsuranceOfUserGivenClaim(Cic.claim4);
      
         assertTrue(Cic.claim4.getCheckHistoryStatus()==ClaimStatus.COMPLETED);
         assertTrue(Cic.claim4.getPhoneGarageStatus()==ClaimStatus.COMPLETED);
         assertTrue(Cic.claim4.getCheckInsuranceStatus()==ClaimStatus.COMPLETED);
         assertTrue(Cic.claim4.getPreliminaryStatus()==ClaimStatus.COMPLETED);
  
    }
}
