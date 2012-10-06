/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.Cic;
import cic.controller.CClaimManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author alfredo
 */
public class PaymentTest {
    
    public PaymentTest() {
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
    public void makeThePayment() {
        
        assertFalse(Cic.claim0.isPayed());
        CClaimManager.getInstance().pay(Cic.claim0);
        assertTrue(Cic.claim0.isPayed());
        
    
    }
    @Test
    public void hello2() {
    
    }
}
