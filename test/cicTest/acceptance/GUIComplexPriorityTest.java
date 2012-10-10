/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest.acceptance;

import cic.Cic;
import cic.entity.ClaimStatus;
import cic.view.ClassifiedClaimsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alfredo
 */
public class GUIComplexPriorityTest {
    
    public GUIComplexPriorityTest() {
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
    public void checkPriorityComplexCase() {
        
        
        
       assertTrue(Cic.claim4.getCheckHistoryStatus()==ClaimStatus.NOT_COMPLETED);
       assertTrue(Cic.claim4.getCheckInsuranceStatus()==ClaimStatus.NOT_COMPLETED);
       assertTrue(Cic.claim4.getPhoneGarageStatus()==ClaimStatus.NOT_COMPLETED);
       assertTrue(Cic.claim4.getPreliminaryStatus()==ClaimStatus.NOT_COMPLETED);
       
       ClassifiedClaimsPage ccp=new ClassifiedClaimsPage();
              
        ccp.selectClaimNumber(4);
        ccp.clickCheckInsuranceButton();
        ccp=new ClassifiedClaimsPage();
        ccp.selectClaimNumber(4);
        ccp.clickConfirmHistoryButton();
        ccp=new ClassifiedClaimsPage();
        ccp.selectClaimNumber(4);
        ccp.clickSendSmsButton();
        
       assertTrue(Cic.claim4.getCheckHistoryStatus()==ClaimStatus.COMPLETED);
       assertTrue(Cic.claim4.getCheckInsuranceStatus()==ClaimStatus.COMPLETED);
       assertTrue(Cic.claim4.getPhoneGarageStatus()==ClaimStatus.COMPLETED);
       assertTrue(Cic.claim4.getPreliminaryStatus()==ClaimStatus.COMPLETED);
        
       
    
    }
}
