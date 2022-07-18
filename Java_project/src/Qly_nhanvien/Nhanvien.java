/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Qly_nhanvien;

/**
 *
 * @author oOOo
 */
public class Nhanvien {

    public String Hoten;
    public String Ngaysinh;
    public String Chucdanh;

    public Nhanvien(String Hoten, String Ngaysinh, String Chucdanh) {
        this.Hoten = Hoten;
        this.Ngaysinh = Ngaysinh;
        this.Chucdanh = Chucdanh;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public String getChucdanh() {
        return Chucdanh;
    }

    public void setChucdanh(String Chucdanh) {
        this.Chucdanh = Chucdanh;
    }

    
    public String showInfo() {
        return "Nhanvien{" + "Hoten=" + Hoten + ", Ngaysinh=" + Ngaysinh + 
                ", Chucdanh=" + Chucdanh + '}';
    }
}
