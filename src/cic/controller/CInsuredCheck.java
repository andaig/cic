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
public class CInsuredCheck {



    public Boolean checkInsured(String ssn) {
        User us;
        us = new User();
        us.load(ssn);
        
        if(us.getSsn().compareTo(ssn)==0){
            
            return true;           
        }
        else {
            return false;
        }
    }
    
}
