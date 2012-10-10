/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.controller;

import cic.entity.User;

/**
 *Simple interface that simulates the ability of 
 * sending sms, email, decision and notifications
 * @author 
 */
public class CCommunicationManager {

    public Boolean sendNotificationNotInsured(String email) {
        
        return sendMail(email);
        
        
    }
    public Boolean sendMail(String email){
        //returs true if successful
        if(email.compareTo("invalidEmail")==0){
            return false;
        }
        return true;
    }

    public Boolean sendSms(String number, String text) {
      return true;
    }

    Boolean sendDecision(String decisionText, String email) {
        return true;
    }
    
}
