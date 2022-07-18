/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanliKhachsan;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oOOo
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2811);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Scanner input = new Scanner(System.in);
            int luachon = 0;
            String message = "";
            do {
                System.out.println("======MENU TINH TIEN======");
                System.out.println("1. Them thong tin khach hang");
                System.out.println("2. Tinh tien phong");
                System.out.println("3. Thoat ra");
                System.out.println("Ban lua chon > ");
                luachon = Integer.parseInt(input.nextLine());
                dos.writeInt(luachon);
                switch (luachon) {
                    case 1: {
                        message = "";
                        System.out.println("Them khach hang: ");
                        System.out.println("ID > ");
                        String id = input.nextLine();
                        System.out.println("Ho ten > ");
                        String hoten = input.nextLine();
                        System.out.println("Loai phong > ");
                        String loaiphong = input.nextLine();
                        message = id + "$" + hoten + "$" + loaiphong;
                        dos.writeUTF(message);
                        System.out.println("Them thanh cong!!!");
                        break;
                    }
                    case 2: {
                        message = "";
                        System.out.println("Tinh tien phong!");
                        System.out.println("Nhap vao ho ten khach hang > ");
                        String tenKH = input.nextLine();
                        dos.writeUTF(tenKH);
                        message = dis.readUTF();
                        System.out.println(message);
                        if(message.equals("Tim thay")) {
                            System.out.println("So ngay luu tru > ");
                            int ngay = Integer.parseInt(input.nextLine());
                            dos.writeInt(ngay);
                            int ketqua = dis.readInt();
                            System.out.println("Thanh tien : " + ketqua + " VND");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Tam biet!");
                        break;
                    }
                    default: {
                        System.out.println("Khong co chuc nang nay!");
                        break;
                    }
                }
            } while (luachon != 3);

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
