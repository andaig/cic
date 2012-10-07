/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.Cic;
import cic.controller.CAuthentication;
import cic.controller.CClaimManager;
import cic.controller.CUserManager;
import cic.entity.Claim;
import cic.entity.ClaimComplexity;
import cic.entity.User;
import java.util.ArrayList;
import javax.naming.AuthenticationException;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author alfredo
 */
public class ViewUnclassifiedClaimsTest {
    
    
    
    public ViewUnclassifiedClaimsTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Before
    public void setup(){
    Cic.populate();
    }
    
    @After
    public void clean(){
        Cic.clean();
    }
    
    
    @Test
    public void classifyTest() throws AuthenticationException{
        CAuthentication.getInstance().authenticate("cha", "password");
        
        Claim c1=new Claim("a", "b", 1.0, 2.9);
        assertTrue(c1.getComplexity()==ClaimComplexity.NOT_CLASSIFIED);
        
        c1.classifyAsSimple();
        assertTrue(c1.getComplexity()==ClaimComplexity.SIMPLE);
        
        c1.classifyAsComplex();
        assertTrue(c1.getComplexity()==ClaimComplexity.COMPLEX);
        
    }
    
    @Test(expected=AuthenticationException.class)
    public void classifyTestAuthorizationException() throws AuthenticationException{
        CAuthentication.getInstance().authenticate("employee", "password");
         
        Claim c1=new Claim("a", "b", 1.0, 2.9);
        assertTrue(c1.getComplexity()==ClaimComplexity.NOT_CLASSIFIED);
        
        c1.classifyAsSimple();
        assertTrue(c1.getComplexity()==ClaimComplexity.SIMPLE);
        
        c1.classifyAsComplex();
        assertTrue(c1.getComplexity()==ClaimComplexity.COMPLEX);
        
    }
    
     @Test
     public void getUnclassified() throws AuthenticationException {
          
         
         
         //classify two of these claims
         Cic.claim0.classifyAsSimple();
         Cic.claim1.classifyAsComplex();
         
         
         
         ArrayList<Claim> unclassifiedClaims=CClaimManager.getInstance().getUnclassifiedClaims();
         assertTrue(unclassifiedClaims.isEmpty());
         
     }
}
