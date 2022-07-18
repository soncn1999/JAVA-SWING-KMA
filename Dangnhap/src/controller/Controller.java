/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author oOOo
 */
public class Controller {
    User user;
    public Controller() {}
    
    public boolean Login(String username, String password) {
        Boolean result = false;
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        if(new DAO().getUser(user)) {
            result = true;
        } 
        return result;
    }
    
    public boolean Register(String username, String password) {
        Boolean result = false;
        user = new User();
        user.setName(username);
        user.setPassword(password);
        if(new DAO().add(user)) {
            result = true;
        }
        return result;
    }
}
