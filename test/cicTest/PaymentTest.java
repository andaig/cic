/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.Cic;
import cic.controller.CAuthentication;
import cic.controller.CClaimManager;
import cic.entity.Claim;
import cic.entity.Decision;
import java.util.ArrayList;
import javax.naming.AuthenticationException;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


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
    public void makeThePayment() throws AuthenticationException {
        CAuthentication.getInstance().authenticate("femployee","password");
                       
        assertFalse(Cic.claim0.isPayed());
        CClaimManager.getInstance().pay(Cic.claim0);
        assertTrue(Cic.claim0.isPayed());
        
    
    }
    @Test(expected=AuthenticationException.class)
    public void makeThePaymentAuthorizationException1() throws AuthenticationException {
        CAuthentication.getInstance().authenticate("employee","password");
                     
        assertFalse(Cic.claim0.isPayed());
        CClaimManager.getInstance().pay(Cic.claim0);
        assertTrue(Cic.claim0.isPayed());
    }
    @Test(expected=AuthenticationException.class)
    public void makeThePaymentAuthorizationException2() throws AuthenticationException {
        CAuthentication.getInstance().authenticate("cha","password");
                     
        assertFalse(Cic.claim0.isPayed());
        CClaimManager.getInstance().pay(Cic.claim0);
        assertTrue(Cic.claim0.isPayed());
    }
    @Test(expected=AuthenticationException.class)
    public void makeThePaymentAuthorizationException3() throws AuthenticationException {
        CAuthentication.getInstance().authenticate("chb","password");
                     
        assertFalse(Cic.claim0.isPayed());
        CClaimManager.getInstance().pay(Cic.claim0);
        assertTrue(Cic.claim0.isPayed());
    }
    
    
    @Test
    public void getClaimsToPayTest() throws AuthenticationException{
        CAuthentication.getInstance().authenticate("cha", "password");
        ArrayList<Claim> claims;
        CClaimManager.getInstance().decide(Cic.claim2, Decision.OK, "pay it!");
        
        claims=CClaimManager.getInstance().getClaimsToPay();
        
        
        assertTrue(claims.contains(Cic.claim2));
        
        assertFalse(claims.contains(Cic.claim3));
        assertFalse(claims.contains(Cic.claim0));
        assertFalse(claims.contains(Cic.claim1));
        
        assertFalse(claims.contains(Cic.claim4));
        assertFalse(claims.contains(Cic.claim5));
        assertFalse(claims.contains(Cic.claim6));
    
    }
}
