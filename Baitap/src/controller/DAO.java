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
import model.Flight;

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
    
    public ArrayList<Flight> getListFlight() {
        ArrayList<Flight> list = new ArrayList<>();
        String sql = "SELECT * FROM TESTWEB.FLIGHTS";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Flight s = new Flight();
                s.setId(rs.getInt("ID"));
                s.setName(rs.getString("NAME"));
                s.setCost(rs.getInt("COST"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        new DAO();
    }
}

