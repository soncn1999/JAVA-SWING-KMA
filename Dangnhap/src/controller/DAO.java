/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author oOOo
 */
public class DAO {
    private Connection conn;
    
    public DAO () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testweb","root","");
            System.out.println("Successful Connection");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed Connection");
        }
    }
    
    public boolean getUser(User u) {
        boolean result = false;
        String sql = "SELECT * FROM TESTWEB.USERS WHERE USERS.USERNAME = ? AND PASSWORD = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getPassword());
            ResultSet rs = ps.executeQuery();
            User user = new User();
            while(rs.next()) {
                user.setId(rs.getString("ID"));
                user.setName(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
            }
            
            if(user.id != "") {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean add(User u) {
        String sql = "INSERT INTO TESTWEB.USERS (USERNAME, PASSWORD) VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getPassword());
            return ps.executeUpdate() > 0; //Insert thi dung Execute Update
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
        new DAO();
    }
}
