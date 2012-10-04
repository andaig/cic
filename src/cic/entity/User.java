/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.entity;

/**
 *
 * @author alfredo
 */
public class User {
    
    private String ssn;
    private String fname;
    private String lname;
    
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
    
    
      //simulates interaction with db
    public void load(String ssnArg){

   
        if(ssnArg.compareTo("1234567890")==0){
        
            this.ssn="1234567890";
            this.fname="Alfredo";
            this.lname="Scaccialepre";
        }
        else {
            this.ssn="";
            this.fname="";
            this.lname="";
                        
        }

    }
    
    
    
    
}
