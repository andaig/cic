/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.controller;

import cic.entity.Claim;
import cic.entity.ClaimComplexity;
import cic.entity.ClaimStatus;
import cic.entity.Decision;
import cic.entity.Role;

import cic.entity.User;
import cic.entity.exceptions.PriorityException;
import java.util.ArrayList;
import javax.naming.AuthenticationException;

/**
 *
 * @author alfredo
 */
public class CClaimManager {
 private static CClaimManager instance;
 private ArrayList<Claim> claims= new  ArrayList<Claim>();
 
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
        ArrayList<Claim> ret= new ArrayList<Claim>();
        for(Claim cl:this.claims ){
            if(cl.getStatus()==ClaimComplexity.NOT_CLASSIFIED){
                ret.add(cl);
            }
        }
        return ret;
    }

    public ArrayList<Claim> getHistoryOfUser(String ssn) {
        ArrayList<Claim> ret=new ArrayList<Claim>();
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

    
    public void CheckHistory(Claim c) throws PriorityException{
        
        c.setCheckHistoryCompleted();
        updateClaimPreliminaryStatus(c);
    
    }
    public Boolean phoneGarage(Claim sc) throws PriorityException {
         String number="0767155358";
         String text = sc.generateGarageText();
         
         CCommunicationManager comMan= new CCommunicationManager();
         Boolean smsSuccess=comMan.sendSms(number, text);
         if(smsSuccess){
            sc.setPhoneGarageCompleted();
         }        
         updateClaimPreliminaryStatus(sc);
         
         return smsSuccess;
    }
   
    
    public void updateClaimPreliminaryStatus(Claim c){
        //Simple claim
        if(c.getComplexity()==ClaimComplexity.SIMPLE){
            if(c.getPhoneGarageStatus() == ClaimStatus.COMPLETED &&
                    c.getCheckInsuranceStatus() == ClaimStatus.COMPLETED){
                c.setPreliminaryCompleted();
            }
                
        }
        
        //Complex claim
        if(c.getComplexity()==ClaimComplexity.COMPLEX){
            if(c.getPhoneGarageStatus() == ClaimStatus.COMPLETED &&
                    c.getCheckInsuranceStatus() == ClaimStatus.COMPLETED &&
                    c.getCheckHistoryStatus()== ClaimStatus.COMPLETED){
                
                c.setPreliminaryCompleted();
                
            }
        }
    }

    public ArrayList<Claim> getPreliminaryCompleteClaims() {
        ArrayList<Claim> ret=new ArrayList<Claim>();
        for(Claim c : this.claims){
            if(c.getPreliminaryStatus()==ClaimStatus.COMPLETED && 
                    c.getOverallStatus()==ClaimStatus.NOT_COMPLETED){
                ret.add(c);
            }
        }
        return ret;
    }

    public Boolean decide(Claim sc, Decision decision, String decisionText) throws AuthenticationException {
        
        if(CAuthentication.getInstance().getEmployeeRole()!=Role.CHA){
            throw new AuthenticationException("decision authorization error");
        }
        
        sc.decide(decision);
        CCommunicationManager com=new CCommunicationManager();
        User u=new User();
        u.load(sc.getOwnerSsn());
        
        return com.sendDecision(decisionText, u.getEmail());
    }

    public ArrayList<Claim> getSimpleClaimsNotPreliminaryComplete() {
        ArrayList<Claim> ret=new ArrayList<Claim>();
        for(Claim c:this.claims){
            if(c.getPreliminaryStatus()==ClaimStatus.NOT_COMPLETED &&
                    c.getComplexity() == ClaimComplexity.SIMPLE){
                ret.add(c);
            }
                
        
        }
        return ret;
    }

    public ArrayList<Claim> getComplexClaimsNotPreliminaryComplete() {
        ArrayList<Claim> ret=new ArrayList<Claim>();
        for(Claim c:this.claims){
            if(c.getPreliminaryStatus()==ClaimStatus.NOT_COMPLETED &&
                    c.getComplexity() == ClaimComplexity.COMPLEX){
                ret.add(c);
            }
                
        
        }
        return ret;
    }

    public ArrayList<Claim> getClassifiedClaimsNotPreliminaryComplete() {
        ArrayList<Claim> ret=new ArrayList<Claim>();
        
        ret.addAll(this.getSimpleClaimsNotPreliminaryComplete());
        ret.addAll(this.getComplexClaimsNotPreliminaryComplete());
              
        return ret;
    }

    public ArrayList<Claim> search(String string) {
        ArrayList<Claim> ret=new ArrayList<Claim>();
        if(string.compareTo("")==0){
            for(Claim c:this.claims){
                ret.add(c);
            }
            
        }
        else{
            for(Claim c:this.claims){
                if(c.getId().toString().matches(string)){
                    ret.add(c);
                }
            }
        }
        
        return ret;
    }

    public void pay(Claim claim0) throws AuthenticationException {
        if(CAuthentication.getInstance().getEmployeeRole()!=Role.FINANCEEMPLOYEE){
            throw new AuthenticationException("only finance employee can pay a claim.");
        }
        
        claim0.setPayed();
        
    }

    public ArrayList<Claim> getClaimsToPay() {
        ArrayList<Claim> ret=new ArrayList<Claim>();
        
        for(Claim c : this.claims){
            if(c.getFinalDecision()==Decision.OK &&
                    !c.isPayed() ){
                ret.add(c);
            }
        }
        return ret;
    }

    
    
}
