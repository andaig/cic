/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.Cic;
import org.junit.After;
import org.junit.Before;

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
    // @Test
    // public void hello() {}
}
