/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.Cic;
import cic.entity.ClaimComplexity;
import cic.entity.ClaimStatus;
import cic.entity.Decision;
import javax.naming.AuthenticationException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author
 */
public class CicTest {
    
    public CicTest() {
    }
    
   
    /**
     * Test of main method, of class Cic.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Cic.main(args);
        
    }
    
    @Test
    public void testPopulate() throws AuthenticationException{
        //claim0=new Claim(user.getSsn(), "desc", 9.0, 13.0);
        
        Cic.populate();
        assertTrue(Cic.claim0.getId()==0);
        assertTrue(Cic.claim0.getOwnerSsn().compareTo("9999")==0);
        assertTrue(Cic.claim0.getDescription().compareTo("desc")==0);
        assertTrue(Cic.claim0.getCostOfDamage()==9.0);
        assertTrue(Cic.claim0.getPriceOfCar()==13.0);
        
       
        
        assertTrue(Cic.claim0.getComplexity()==ClaimComplexity.NOT_CLASSIFIED);
        Cic.claim0.classifyAsComplex();
        assertTrue(Cic.claim0.getComplexity()==ClaimComplexity.COMPLEX);
        Cic.claim0.classifyAsSimple();
        assertTrue(Cic.claim0.getComplexity()==ClaimComplexity.SIMPLE);
        
        assertTrue(Cic.claim0.getPreliminaryStatus()==ClaimStatus.NOT_COMPLETED);
        Cic.claim0.setPreliminaryCompleted();
        assertTrue(Cic.claim0.getPreliminaryStatus()==ClaimStatus.COMPLETED);
        
        assertTrue(Cic.claim0.getOverallStatus()==ClaimStatus.NOT_COMPLETED);
        Cic.claim0.setOverallCompleted();
        assertTrue(Cic.claim0.getOverallStatus()==ClaimStatus.COMPLETED);
        
        assertFalse(Cic.claim0.isPayed());
        Cic.claim0.setPayed();
        assertTrue(Cic.claim0.isPayed());
        
        assertTrue(Cic.claim0.getFinalDecision()==Decision.NOT_TAKEN);
        Cic.claim0.decide(Decision.OK);
        assertTrue(Cic.claim0.getFinalDecision()==Decision.OK);
        
        Cic.claim0.decide(Decision.NOK);
        assertTrue(Cic.claim0.getFinalDecision()==Decision.NOK);
        
    }
}
