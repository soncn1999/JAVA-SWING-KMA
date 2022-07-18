/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doandbms;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Son Thuol
 */
public class MySQLConnection {
    public Connection ConnectMySQL(){
        Connection connec = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
           // connec = DriverManager.getConnection("jdbc:mysql://localhost/doan_dbms?" + "user=root");
           connec = DriverManager.getConnection("jdbc:mysql://localhost:3306/doan_dbms?useUnicode=true&characterEncoding=UTF-8","root","");
//          System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
//          System.out.println("Ket noi khong hop le");
            e.printStackTrace();
        }
        return connec;
    } 
}
