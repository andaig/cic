/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic;

import cic.controller.CAuthentication;
import cic.controller.CClaimManager;
import cic.controller.CUserManager;
import cic.entity.Claim;
import cic.entity.Decision;
import cic.entity.User;
import cic.view.LoginPage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.AuthenticationException;

/**
 *
 * @author alfredo
 */
public class Cic {

    /**
     * @param args the command line arguments
     */
    public static User user;
    public static Claim claim0;
    public static Claim claim1;
    public static Claim claim2;
    public static Claim claim3;
    public static Claim claim4;
    public static Claim claim5;
    public static Claim claim6;
    public static Boolean done=false;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        LoginPage logpg=new LoginPage();
        
        logpg.setVisible(true);
        populate();
    }
    
    public static void populate() {
        if(done==true){
            return;
        }
        done=true;
        
        
        CAuthentication.getInstance().authenticate("cha", "password");
        
        //add this user to the users
         user=new User("9999", "Alfredo", "Scaccialepre");
        
         CUserManager userController=CUserManager.getInstance();
         userController.addUser(user);
         
         
         //create claims
         claim0=new Claim(user.getSsn(), "desc", 9.0, 13.0);
         claim1=new Claim(user.getSsn(), "desc", 10.0, 15.0);
         claim2=new Claim(user.getSsn(), "desc", 12.0, 17.0);
         claim3=new Claim(user.getSsn(), "desc", 14.0, 19.0);
         claim4=new Claim(user.getSsn(), "desc", 15.0, 21.0);
         claim5=new Claim(user.getSsn(), "desc", 16.0, 22.0);
         claim6=new Claim(user.getSsn(), "desc", 17.0, 23.0);
         
         
         //add claims      
         CClaimManager claimController=CClaimManager.getInstance();
         claimController.registerClaim(user.getSsn(), claim0);
         claimController.registerClaim(user.getSsn(), claim1);
         claimController.registerClaim(user.getSsn(), claim2);
         claimController.registerClaim(user.getSsn(), claim3);
         claimController.registerClaim(user.getSsn(), claim4);
         claimController.registerClaim(user.getSsn(), claim5);
         claimController.registerClaim(user.getSsn(), claim6);
        try {
            claim2.classifyAsComplex();
            claim3.classifyAsSimple();
            claim4.classifyAsComplex();
            claim5.classifyAsSimple();
            claim6.classifyAsComplex();
        } catch (AuthenticationException ex) {
            Logger.getLogger(Cic.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         claim2.setPreliminaryCompleted();
         claim3.setPreliminaryCompleted();
         claim6.setPreliminaryCompleted();
        try {
            CClaimManager.getInstance().decide(claim3, Decision.OK, "Approved");
            CClaimManager.getInstance().decide(claim6, Decision.NOK, "Not Approved");
        } catch (AuthenticationException ex) {
            Logger.getLogger(Cic.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         claim3.setPayed();
         
         
         claim3.setOverallCompleted();
         claim6.setOverallCompleted();
          
    
    }
    
      public static void clean(){
               
          done=false;
        //add this user to the users        
         CUserManager userController=CUserManager.getInstance();
         userController.removeUser(user);
         user=new User("9999", "Alfredo", "Scaccialepre");
         
         CClaimManager claimController=CClaimManager.getInstance();
         claimController.removeClaim(claim0);
         claimController.removeClaim(claim1);
         claimController.removeClaim(claim2);
         claimController.removeClaim(claim3);
         claimController.removeClaim(claim4);
         claimController.removeClaim(claim5);
         claimController.removeClaim(claim6);
         
         //create claims
         claim0=new Claim(user.getSsn(), "desc", 9.0, 13.0);
         claim1=new Claim(user.getSsn(), "desc", 10.0, 15.0);
         claim2=new Claim(user.getSsn(), "desc", 12.0, 17.0);
         claim3=new Claim(user.getSsn(), "desc", 14.0, 19.0);
         claim4=new Claim(user.getSsn(), "desc", 15.0, 21.0);
         claim5=new Claim(user.getSsn(), "desc", 16.0, 22.0);
         claim6=new Claim(user.getSsn(), "desc", 17.0, 23.0);
         
          
    
    }
   
}
