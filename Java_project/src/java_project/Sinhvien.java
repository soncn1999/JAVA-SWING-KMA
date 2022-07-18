/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_project;

/**
 *
 * @author oOOo
 */
public class Sinhvien {

    public String ID;
    public String HoTen;
    public String Khoa;
    public int Tuoi;

    public Sinhvien() {
    }

    public Sinhvien(String ID, String HoTen, String Khoa, int Tuoi) {
        this.ID = ID;
        this.HoTen = HoTen;
        this.Khoa = Khoa;
        this.Tuoi = Tuoi;
    }

    public String getID() {
        return ID;
    }

    public String getHoTen() {
        return HoTen;
    }

    public String getKhoa() {
        return Khoa;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setKhoa(String Khoa) {
        this.Khoa = Khoa;
    }

    public void setTuoi(int Tuoi) {
        this.Tuoi = Tuoi;
    }

    public void showInfo() {
        System.out.println("Sinhvien{" + "ID=" + ID + ", HoTen=" + HoTen
                + ", Khoa=" + Khoa + ", Tuoi=" + Tuoi + '}');
    }
}
