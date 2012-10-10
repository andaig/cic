/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cicTest;

import cic.controller.CAuthentication;
import cic.entity.Employee;
import cic.entity.Role;
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
         assertTrue(controller!=null);         
         Boolean isCorrect=controller.authenticate(username, password);
         assertFalse(isCorrect);
     }
    
    @Test
    public void LoadAChaTest(){
        
        Employee emp=new Employee();
        emp.load("cha");
        assertTrue(emp!=null);
        assertTrue(emp.getUsername().compareTo("cha")==0);
        assertTrue(emp.getRole()==Role.CHA);
    }
    
    @Test
    public void LoadAbChbTest(){
        
        Employee emp=new Employee();
        emp.load("chb");
        assertTrue(emp!=null);
        assertTrue(emp.getUsername().compareTo("chb")==0);
        assertTrue(emp.getRole()==Role.CHB);
    }
    
    @Test
    public void LoadAnEmployeeTest(){
        
        Employee emp=new Employee();
        emp.load("employee");
        assertTrue(emp!=null);
        assertTrue(emp.getUsername().compareTo("employee")==0);
        assertTrue(emp.getRole()==Role.EMPLOYEE);
    }
    
    @Test
    public void LoadAFinanceEmployeeTest(){
        
        Employee emp=new Employee();
        emp.load("femployee");
        assertTrue(emp!=null);
        assertTrue(emp.getUsername().compareTo("femployee")==0);
        assertTrue(emp.getRole()==Role.FINANCEEMPLOYEE);
    }
    
   
}
