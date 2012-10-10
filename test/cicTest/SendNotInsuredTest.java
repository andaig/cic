/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.controller.CCommunicationManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author
 */
public class SendNotInsuredTest {
    
    public SendNotInsuredTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void sendNotificationNotInsuredSuccessful() {
        CCommunicationManager controller=new CCommunicationManager();
        String ssn="1234567890";
        Boolean res=controller.sendNotificationNotInsured(ssn);
        assertTrue(res);
     }
    
    @Test
    public void sendNotificationNotInsuredUnsuccessful() {
        CCommunicationManager controller=new CCommunicationManager();
        String email="invalidEmail";
        Boolean res=controller.sendNotificationNotInsured(email);
        assertFalse(res);
     }
}
