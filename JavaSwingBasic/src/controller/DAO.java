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
import model.Student;

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
    
    public boolean add(Student s) {
        String sql = "INSERT INTO TESTWEB.STUDENTS (ID,NAME,DOB,ADDRESS,PHONE,EMAIL,MARK) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getDob());
            ps.setString(4, s.getAddress());
            ps.setString(5, s.getPhone());
            ps.setString(6, s.getEmail());
            ps.setFloat(7, s.getMark());
            return ps.executeUpdate() > 0; //Insert thi dung Execute Update
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<Student> getListStudent() {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM TESTWEB.STUDENTS";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Student s = new Student();
                s.setId(rs.getString("ID"));
                s.setName(rs.getString("NAME"));
                s.setDob(rs.getString("DOB"));
                s.setAddress(rs.getString("ADDRESS"));
                s.setPhone(rs.getString("PHONE"));
                s.setMark(rs.getFloat("MARK"));
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
