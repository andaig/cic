/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.entity;

/**
 *
 * @author alfredo
 */
public class Employee {
    protected String username;
    protected String password;
    
    public Employee(){
    }
        
    public Employee(String usr, String pwd){
        this.password=pwd;
        this.username=usr;        
    }
    
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    
    
    //simulates interaction with db
    public void load(String username){

   
        if(username.compareTo("employee")==0){
        
            this.username="employee";
            this.password="password";           
        }
        else {
            this.username="";
            this.password="";
            
        }

    }
    
    
    
}
