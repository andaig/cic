/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.controller;

import cic.entity.Employee;
import cic.entity.Role;


/**
 *
 * @author 
 */
public class CAuthentication {
    
    
    private static CAuthentication instance=null;
    private String username;
    
    private CAuthentication(){
    
    }
    
    public static CAuthentication getInstance(){
        if(instance==null){
            instance=new CAuthentication();
        }
        return instance;
    }
    
    private Employee employee;

    
    public Role getEmployeeRole(){
        return this.employee.getRole();
    }
    
    
    public Boolean authenticate(String username, String password) {
        Employee emp;
        emp = new Employee();
        emp.load(username);
        if(emp.getUsername()!=null  && emp.getUsername().compareTo(username)==0){
            
                this.employee=emp;
                this.username=username;
                return true;           
        }
        else {
            return false;
        }
        

    }

    public String getUsername() {
        return this.username;
    }
    
}
