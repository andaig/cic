/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.controller;

import cic.entity.Claim;
import cic.entity.ClaimComplexity;
import cic.entity.ClaimStatus;
import java.util.ArrayList;

/**
 *
 * @author alfredo
 */
public class CClaimManager {
 private static CClaimManager instance;
 private ArrayList<Claim> claims= new  ArrayList<>();
 
 private CClaimManager(){
 }
 
 public static CClaimManager getInstance()
  {
    if (instance== null)
    {
      instance = new CClaimManager();
    }

    return instance; 
  }
 
 public Boolean registerClaim(String ssn, Claim claim) {
     claims.add(claim);
     return true;
 }

    public ArrayList<Claim> getUnclassifiedClaims() {
        ArrayList<Claim> ret= new ArrayList<>();
        for(Claim cl:this.claims ){
            if(cl.getStatus()==ClaimComplexity.NOT_CLASSIFIED){
                ret.add(cl);
            }
        }
        return ret;
    }

    public ArrayList<Claim> getHistoryOfUser(String ssn) {
        ArrayList<Claim> ret=new ArrayList<>();
        for(Claim c:claims){
           
            if((c.getOwnerSsn().compareTo(ssn)==0)){
                
                if(c.getOverallStatus()==ClaimStatus.COMPLETED ) {
                    
                    ret.add(c);
                }
            }
        }
        
        return ret;
        
        
    }

    public void removeClaim(Claim c) {
        this.claims.remove(c);
    }
    
}
