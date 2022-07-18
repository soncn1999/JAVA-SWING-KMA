/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doandbms;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author Son Thuol
 */
public class function {
    MySQLConnect connect = new MySQLConnect();
    //hien thi ket qua
    public void HienThiKQ(){
        Connection conn = connect.ConnectMySQL();
        Statement stmt = null;
        ResultSet rs = null;
        try {
        stmt = (Statement) conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM ketqua");
             System.out.println("Hien thi thong thong tin bang ket qua");
             System.out.printf("%-10s | %-10s | %-10s|\n", "MSSV", "MA_HP", "Diem");
            while(rs.next()){
                String mssv = rs.getString("mssv");
                String mahp = rs.getString("mahp");
                String diem = rs.getString("diem");
                System.out.printf(" %-10s | %-10s | %-10s|\n", mssv, mahp, diem);
            }
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }finally{
            //giai phong tai nguyen khi khong su dung nua: 
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException sqlEX) {}
                
                rs = null;
            }
            
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException sqlEX) {}
                
                stmt = null;
            }
        }
    }
    //hienthi thong tin trong bang học phan
    public void HTHocPhan(){
        Connection conn = connect.ConnectMySQL();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = (Statement) conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM hocphan");
            System.out.println("Hien thi thong tin hoc phan");
            System.out.printf("%-10s | %-40s | %-10s |\n", "MA_HP", "Ten_HP", "TinChi");
            while(rs.next()){
                String Mahp = rs.getString("mahp");
                String Tenhp = rs.getString("tenhp");
                String Tinchi = rs.getString("tinchi");
            System.out.printf("%-10s | %-40s | %-10s |\n", Mahp, Tenhp, Tinchi);
            }
        } catch (Exception e) {
            System.out.println("MySQL Exception" + e.getMessage());
        }finally{
            //giai phong du lieu khi kong su dung nua
            if(rs != null){
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }
        }
    }
    
    public void HTKhoa(){
        Connection conn = connect.ConnectMySQL();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = (Statement) conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM khoa");
            System.out.println("Hien thi thong tin cua khoa");
            System.out.printf("%-10s | %-40s|\n", "Ma Khoa", "Ten Khoa");
            while(rs.next()){
                String makhoa = rs.getString("makhoa");
                String tenkhoa = rs.getString("tenkhoa");
                System.out.printf("%-10s | %-40s|\n", makhoa, tenkhoa);
            }
        } catch (Exception e) {
            System.out.println("MYSQL Exception: " + e.getMessage());
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }
        }
    }
    
    public void HTSinhVien(){
        Connection conn = connect.ConnectMySQL();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = (Statement) conn.createStatement();
            rs = stmt.executeQuery("SELECT sv.mssv, sv.hoten, sv.makhoa, kq.diem "
                    + "AS ketqua FROM sinhvien sv, ketqua kq WHERE sv.mssv = kq.mssv");
            System.out.println("Hien thi thong tin sinh vien");
            System.out.printf("%-8s | %-20s | %-10s | %-10s |\n", "MMSV", "Ho Ten",
                    "MA Khoa", "Ket Qua");
            while(rs.next()){
                String mssv = rs.getString("mssv");
                String hoten = rs.getString("hoten");
                String makhoa = rs.getString("makhoa");
                String ketqua = rs.getString("ketqua");
                 System.out.printf("%-8s | %-20s | %-10s | %-10s |\n", mssv, hoten,
                    makhoa, ketqua);
            }       
        } catch (Exception e) {
            System.out.println("MySQL Exception: " + e.getMessage());
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }
        }
    }
    
    
}
