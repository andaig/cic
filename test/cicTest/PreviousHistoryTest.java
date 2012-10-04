/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.controller.CClaimManager;
import cic.controller.CUserManager;
import cic.entity.Claim;
import cic.entity.User;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alfredo
 */
public class PreviousHistoryTest {
    
    public PreviousHistoryTest() {
    }
    private Claim claim1;
    private Claim claim2;
    private Claim claim3;
    private User us;
    @Before
    public void setUp() {
         us=new User("9999", "Alfredo", "Scaccialepre");
         CUserManager userController=CUserManager.getInstance();
         userController.addUser(us);
         
         
         //create claims
         claim1=new Claim(us.getSsn(), "desc", 10.0, 15.0);
         claim2=new Claim(us.getSsn(), "desc", 10.0, 15.0);
         claim3=new Claim(us.getSsn(), "desc", 10.0, 15.0);
         
         claim1.setOverallCompleted();
         claim2.setOverallCompleted();
         
         
         
         //add claims      
         CClaimManager claimController=CClaimManager.getInstance();
         claimController.registerClaim(us.getSsn(), claim1);
         claimController.registerClaim(us.getSsn(), claim2);
         claimController.registerClaim(us.getSsn(), claim3);
         
         
         //classify two of these claims
         claim1.classifyAsSimple();
         claim2.classifyAsComplex();
         
            
        
    }
    @Test
    public void pastHistoryTest(){
    
      String ssn=us.getSsn();
      CClaimManager c= CClaimManager.getInstance();
      ArrayList<Claim> otherClaims=c.getHistoryOfUser(ssn);
      
      assertTrue(otherClaims.contains(claim1));
      assertTrue(otherClaims.contains(claim2));
      assertFalse(otherClaims.contains(claim3));
    
    }
    
    @After
    public void tearDown() {
        
        CUserManager userController=CUserManager.getInstance();
        userController.removeUser(us);
        
        CClaimManager claimC=CClaimManager.getInstance();
        
        claimC.removeClaim(claim1);
        claimC.removeClaim(claim2);
        claimC.removeClaim(claim3);
        
    }
    
    
}
