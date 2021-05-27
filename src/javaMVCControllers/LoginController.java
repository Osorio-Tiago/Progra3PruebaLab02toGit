/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaMVCControllers;

import javaMVCModels.*;
import javaMVCViews.*;

public class LoginController {
    
    public void startApplication(){
        LoginView login= new LoginView();
        login.setVisible(true);   
    }
    
    public boolean succesfullLogin(String user, String password) {
        LoginModel model= new LoginModel();
        try {
            return model.Confirmation(user, password);
        } catch (Exception ex) {
            return false;
        }
    }   
}