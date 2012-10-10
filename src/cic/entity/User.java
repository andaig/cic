/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.entity;

import cic.controller.CUserManager;

/**
 *
 * @author
 */
public class User {
    
    private String ssn;
    private String fname;
    private String lname;
    private String email;
    
    public User(){
    }
    public User(String s, String f, String l){
        this.ssn=s;
        this.fname=f;
        this.lname=l;
    }
    
    public String getSsn(){
        return this.ssn;
    }
    public String getFname(){
        return this.fname;
    }
    public String getLname(){
        return this.lname;
    }
    public String getEmail(){
    return this.email;
    }
    
      //simulates interaction with db
    public void load(String ssnArg){
         
        CUserManager con=CUserManager.getInstance();
        User x=con.search(ssnArg);
        
        this.ssn=x.getSsn();
        this.fname=x.getFname();
        this.lname=x.getLname();

    }
    
    
    
    
}
