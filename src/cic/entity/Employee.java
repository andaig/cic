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
    private Role role;
    
            
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
    
    public Role getRole(){
        return role;
    }
    
    //simulates interaction with db
    public void load(String username){

   
        if(username.compareTo("employee")==0){
        
            this.username="employee";
            this.password="password";     
            this.role=Role.EMPLOYEE;
        }
        else if(username.compareTo("femployee")==0){
        
            this.username="femployee";
            this.password="password";     
            this.role=Role.FINANCEEMPLOYEE;
        }
        else if (username.compareTo("cha")==0){
            this.username="cha";
            this.password="password";     
            this.role=Role.CHA;
        
        }
        else if (username.compareTo("chb")==0){
            this.username="chb";
            this.password="password";     
            this.role=Role.CHB;
        
        }
        else {
            this.username=null;
            this.password="";
            
        }

    }
    
    
    
}
