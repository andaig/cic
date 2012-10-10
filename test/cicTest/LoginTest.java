/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.controller.CAuthentication;
import org.junit.Test;
import static org.junit.Assert.*;
import cic.entity.Role;

/**
 *
 * @author alfredo
 */
public class LoginTest {
    
    public LoginTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void successfulLoginTest() {
         
         String username="employee";
         String password = "password";
         Role role;
         CAuthentication controller= CAuthentication.getInstance();
         Boolean isCorrect=controller.authenticate(username, password);
         assertTrue(isCorrect);
         role = controller.getEmployeeRole();
         assertTrue(role == Role.EMPLOYEE);
         
         
     }
    @Test
     public void unsuccessfulLoginTest() {
         
         String username="asdfghjk";
         String password = "qwertyu";
         
         CAuthentication controller= CAuthentication.getInstance();
         Boolean isCorrect=controller.authenticate(username, password);
         assertFalse(isCorrect);
     }
    
    @Test
    public void checkCAuthenticationGet(){
        assertTrue(CAuthentication.getInstance() != null);
    }
    
}
