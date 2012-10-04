/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.controller;

import cic.entity.Claim;
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
    
}
