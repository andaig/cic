/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.controller;

import cic.entity.Claim;
import cic.entity.User;

/**
 *
 * @author alfredo
 */
public class CInsuredCheck {



    public Boolean checkUserIsInDb(String ssn) {
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
    
    public Boolean checkInsuranceOfUserGivenClaim(Claim c) {
       Boolean res=this.checkUserIsInDb(c.getOwnerSsn());
       
       if(res){
           c.setCheckInsuranceCompleted();
       }
       CClaimManager.getInstance().updateClaimPreliminaryStatus(c);
 
       
       return res;
    }
    
    
}
