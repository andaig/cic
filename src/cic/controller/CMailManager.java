/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.controller;

import cic.entity.User;

/**
 *
 * @author alfredo
 */
public class CMailManager {

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
    
}
