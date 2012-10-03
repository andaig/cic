/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.controller;

import cic.entity.Employee;

/**
 *
 * @author alfredo
 */
public class CAuthentication {

    public Boolean authenticate(String username, String password) {
        Employee emp;
        emp = new Employee();
        emp.load(username);
        if(emp.getUsername().compareTo(username)==0){
            System.out.println(emp.getUsername());
            return true;           
        }
        else {
            return false;
        }
        

    }
    
}
