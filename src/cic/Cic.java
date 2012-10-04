/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic;

import cic.controller.CClaimManager;
import cic.controller.CUserManager;
import cic.entity.Claim;
import cic.entity.User;
import cic.view.LoginPage;

/**
 *
 * @author alfredo
 */
public class Cic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        LoginPage logpg=new LoginPage();
        
        logpg.setVisible(true);
        populate();
    }
    
    public static void populate(){
        
        //add this user to the users
         User us=new User("9999", "Alfredo", "Scaccialepre");
         CUserManager userController=CUserManager.getInstance();
         userController.addUser(us);
         
         
         //create claims
         Claim claim0=new Claim(us.getSsn(), "desc", 9.0, 13.0);
         Claim claim1=new Claim(us.getSsn(), "desc", 10.0, 15.0);
         Claim claim2=new Claim(us.getSsn(), "desc", 12.0, 17.0);
         Claim claim3=new Claim(us.getSsn(), "desc", 14.0, 19.0);
         
         //add claims      
         CClaimManager claimController=CClaimManager.getInstance();
         claimController.registerClaim(us.getSsn(), claim0);
         claimController.registerClaim(us.getSsn(), claim1);
         claimController.registerClaim(us.getSsn(), claim2);
         claimController.registerClaim(us.getSsn(), claim3);
         
         claim2.classifyAsComplex();
         claim3.classifyAsSimple();
         claim2.setPreliminaryCompleted();
         claim3.setOverallCompleted();
         
         
         //classify two of these claims
         //claim1.classifyAsSimple();
         //claim2.classifyAsComplex();
         
         
    
    }
   
}
