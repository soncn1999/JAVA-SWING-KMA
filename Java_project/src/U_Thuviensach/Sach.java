/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U_Thuviensach;

/**
 *
 * @author oOOo
 */
public class Sach {

    public String ID;
    public String Tensach;
    public String NXB;
    public int Tongsoluong;
    public int Soluongchomuon;

    public Sach() {
    }

    public Sach(String ID, String Tensach, String NXB, int Tongsoluong, int Soluongchomuon) {
        this.ID = ID;
        this.Tensach = Tensach;
        this.NXB = NXB;
        this.Tongsoluong = Tongsoluong;
        this.Soluongchomuon = Soluongchomuon;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTensach() {
        return Tensach;
    }

    public void setTensach(String Tensach) {
        this.Tensach = Tensach;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public int getTongsoluong() {
        return Tongsoluong;
    }

    public void setTongsoluong(int Tongsoluong) {
        this.Tongsoluong = Tongsoluong;
    }

    public int getSoluongchomuon() {
        return Soluongchomuon;
    }

    public void setSoluongchomuon(int Soluongchomuon) {
        this.Soluongchomuon = Soluongchomuon;
    }

    public String ShowInfo() {
        return "Sach{" + "ID=" + ID + ", Tensach=" + Tensach + ", NXB=" + NXB + ", Tongsoluong=" + Tongsoluong + ", Soluongchomuon=" + Soluongchomuon + '}';
    }
}
