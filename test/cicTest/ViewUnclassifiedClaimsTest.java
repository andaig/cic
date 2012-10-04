/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.controller.CClaimManager;
import cic.controller.CUserManager;
import cic.entity.Claim;
import cic.entity.ClaimComplexity;
import cic.entity.User;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

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
    
    @Test
    public void classifyTest(){
        Claim c1=new Claim("a", "b", 1.0, 2.9);
        assertTrue(c1.getComplexity()==ClaimComplexity.NOT_CLASSIFIED);
        
        c1.classifyAsSimple();
        assertTrue(c1.getComplexity()==ClaimComplexity.SIMPLE);
        
        c1.classifyAsComplex();
        assertTrue(c1.getComplexity()==ClaimComplexity.COMPLEX);
        
    }
    
     @Test
     public void getUnclassified() {
         //add this user to the users
         User us=new User("9999", "Alfredo", "Scaccialepre");
         CUserManager userController=CUserManager.getInstance();
         userController.addUser(us);
         
         
         //create claims
         Claim claim1=new Claim(us.getSsn(), "desc", 10.0, 15.0);
         Claim claim2=new Claim(us.getSsn(), "desc", 10.0, 15.0);
         Claim claim3=new Claim(us.getSsn(), "desc", 10.0, 15.0);
         
         //add claims      
         CClaimManager claimController=CClaimManager.getInstance();
         claimController.registerClaim(us.getSsn(), claim1);
         claimController.registerClaim(us.getSsn(), claim2);
         claimController.registerClaim(us.getSsn(), claim3);
         
         
         //classify two of these claims
         claim1.classifyAsSimple();
         claim2.classifyAsComplex();
         
         
         
         ArrayList<Claim> unclassifiedClaims=claimController.getUnclassifiedClaims();
         assertFalse(unclassifiedClaims.contains(claim1));
         assertFalse(unclassifiedClaims.contains(claim2));
         assertTrue(unclassifiedClaims.contains(claim3));
         
         
         
     }
}
