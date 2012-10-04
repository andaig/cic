/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.controller;

import cic.entity.Claim;
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
            if(cl.getStatus()==ClaimStatus.NOT_CLASSIFIED){
                ret.add(cl);
            }
        }
        return ret;
    }
    
}
