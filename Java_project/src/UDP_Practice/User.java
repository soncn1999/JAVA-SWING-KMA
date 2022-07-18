/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_Practice;

/**
 *
 * @author oOOo
 */
public class User {

    public String Username;
    public String Password;

    public User(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String showAll() {
        return "User{" + "Username=" + Username + ", Password=" + Password + '}';
    }

}
