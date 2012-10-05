/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.controller;

import cic.entity.User;
import java.util.ArrayList;

/**
 *
 * @author alfredo
 */
public class CUserManager {
    
    private static CUserManager instance=null;
    private ArrayList<User> users= new ArrayList<>();
    private CUserManager(){
        
    }
    
    public static CUserManager getInstance(){
        if(instance==null){
            instance = new CUserManager();
        }
        return instance;
    }
    
    public User search(String ssn){
        User res=new User("","","");
        
        for (User u: this.users){
            
            
            if(u.getSsn().compareTo(ssn)==0){
                res=u;     
                
            }
        }
        return res;
    
    }
    
    public void addUser(User u){
        this.users.add(u);
    }

    public void removeUser(User us) {
        this.users.remove(us);
    }

}
