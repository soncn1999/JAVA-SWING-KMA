/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanliSV;

/**
 *
 * @author oOOo
 */
public class Sinhvien {

    public String Hoten;
    public String Ngaysinh;
    public String Masv;
    public String Quequan;

    public Sinhvien() {
    }

    public Sinhvien(String Hoten, String Ngaysinh, String Masv, String Quequan) {
        this.Hoten = Hoten;
        this.Ngaysinh = Ngaysinh;
        this.Masv = Masv;
        this.Quequan = Quequan;
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

    public String getMasv() {
        return Masv;
    }

    public void setMasv(String Masv) {
        this.Masv = Masv;
    }

    public String getQuequan() {
        return Quequan;
    }

    public void setQuequan(String Quequan) {
        this.Quequan = Quequan;
    }

    public String ThongtinSV() {
        return "Sinhvien{" + "Hoten=" + Hoten + ", Ngaysinh=" + Ngaysinh + ", Masv=" + Masv + ", Quequan=" + Quequan + '}';
    }
}
