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
    
    public void addUser(User u){
        this.users.add(u);
    }

}
