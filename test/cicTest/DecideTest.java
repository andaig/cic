package cicTest;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import cic.controller.CClaimManager;
import cic.controller.CUserManager;
import cic.entity.Claim;
import cic.entity.ClaimStatus;
import cic.entity.Decision;
import cic.entity.SimpleClaim;
import cic.entity.User;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author alfredo
 */
public class DecideTest {
    SimpleClaim sc;
    SimpleClaim sc2;
    User u;
    
    public DecideTest() {
    }
    
    @Before
    public void setUp() {
        u=new User("1234567890", "Alfredo", "Scaccialepre");
         sc=new SimpleClaim(u.getSsn(), "desc", 10.0, 100.0);
         sc2=new SimpleClaim(u.getSsn(), "desc2", 12.0, 10.0);
        
        CUserManager cu=CUserManager.getInstance();
        cu.addUser(u);
        
        CClaimManager cc=CClaimManager.getInstance();
        cc.registerClaim(u.getSsn(), sc);
        cc.registerClaim(u.getSsn(), sc2);
        
        sc.classifyAsComplex();
        sc.setPhoneGarageCompleted();
        sc.setPreliminaryCompleted();
        
          
    }
    
    @Test
       
    public void getClaimsToDecideTest() {
        ArrayList<Claim> preliminaryCompleteClaims;
        CClaimManager cont=CClaimManager.getInstance();
        preliminaryCompleteClaims=cont.getPreliminaryCompleteClaims();
        assertTrue(preliminaryCompleteClaims.contains(sc));
        assertFalse(preliminaryCompleteClaims.contains(sc2));
        
    }
    
    
    @Test
    public void decideNotOk(){
        
        CClaimManager cont=CClaimManager.getInstance();
        Boolean res=cont.decide(sc, Decision.NOK, "Your claim was not approved");
        assertTrue(res);
        assertTrue(sc.getFinalDecision()==Decision.NOK);
        assertTrue(sc.getPreliminaryStatus()==ClaimStatus.COMPLETED);
        assertTrue(sc.getOverallStatus()==ClaimStatus.COMPLETED);        
    }
    
    
    @After
    public void clean(){
       CUserManager.getInstance().removeUser(u);
       CClaimManager.getInstance().removeClaim(sc);
       CClaimManager.getInstance().removeClaim(sc2);
    
    }

}
