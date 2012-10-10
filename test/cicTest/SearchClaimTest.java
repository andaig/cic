/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.Cic;
import cic.controller.CClaimManager;
import cic.entity.Claim;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alfredo
 */
public class SearchClaimTest {
    
    public SearchClaimTest() {
    }
    
    @Before
    public void setUp() {
        Cic.populate();
    }
    
    @After
    public void tearDown() {
        Cic.clean();
    
    }
   
     @Test
     public void searchEmpty() {
        //should return all claims
        CClaimManager cm=CClaimManager.getInstance();
        ArrayList<Claim> all=cm.search("");
        assertTrue(all.contains(Cic.claim0));
        assertTrue(all.contains(Cic.claim1));
        assertTrue(all.contains(Cic.claim2));
        assertTrue(all.contains(Cic.claim3));
        assertTrue(all.contains(Cic.claim4));
        assertTrue(all.contains(Cic.claim5));
        assertTrue(all.contains(Cic.claim6));

    }
     
     @Test
     public void searchZero() {
        CClaimManager cm=CClaimManager.getInstance();
        ArrayList<Claim> all;
        all = cm.search(Cic.claim0.getId().toString());
        
                       
        assertTrue(all.contains(Cic.claim0));
        assertFalse(all.contains(Cic.claim1));
        assertFalse(all.contains(Cic.claim2));
        assertFalse(all.contains(Cic.claim3));
        assertFalse(all.contains(Cic.claim4));
        assertFalse(all.contains(Cic.claim5));
        assertFalse(all.contains(Cic.claim6));
        
        
    }
    
}
