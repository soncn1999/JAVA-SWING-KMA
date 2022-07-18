/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanliKhachsan;

/**
 *
 * @author oOOo
 */
public class Khachhang {

    public String Id;
    public String Hoten;
    public String Loaiphong;

    public Khachhang(String Id, String Hoten, String Loaiphong) {
        this.Id = Id;
        this.Hoten = Hoten;
        this.Loaiphong = Loaiphong;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getLoaiphong() {
        return Loaiphong;
    }

    public void setLoaiphong(String Loaiphong) {
        this.Loaiphong = Loaiphong;
    }

    public String ShowAll() {
        return "Khachhang{" + "Id=" + Id + ", Hoten=" + Hoten + ", Loaiphong=" + Loaiphong + '}';
    }
}
