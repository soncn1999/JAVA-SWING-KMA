/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Qly_nhanvien;

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
            int luachon;
            String message = "";
            do {
                System.out.println("======MENU QUAN LY NHAN VIEN======");
                System.out.println("1. Xem danh sach nhan vien");
                System.out.println("2. Them moi nhan vien");
                System.out.println("3. Tim nhan vien theo ten");
                System.out.println("4. Thoat chuong trinh");
                System.out.println("Ban lua chon > ");
                luachon = Integer.parseInt(input.nextLine());
                dos.writeInt(luachon);
                
                switch(luachon) { //Nhan ket qua tra ve tu server cho tung TH
                    case 1: {
                        message = "";
                        message = dis.readUTF();
                        System.out.println("Danh sach Nhan vien!");
                        System.out.println(message);
                        break;
                    }
                    case 2: {
                        message = "";
                        System.out.println("Them moi nhan vien");
                        System.out.println("Ho ten > ");
                        String hoten = input.nextLine();
                        System.out.println("Ngay sinh > ");
                        String ngaysinh = input.nextLine();
                        System.out.println("Chuc vu > ");
                        String chucvu = input.nextLine();
                        message = hoten + "$" + ngaysinh + "$" + chucvu;
                        dos.writeUTF(message);
                        System.out.println("Them moi thanh cong!!!");
                        break;
                    }
                    case 3: {
                        message = "";
                        System.out.println("Nhap ten nhan vien can tim > ");
                        String tenNV = input.nextLine();
                        dos.writeUTF(tenNV);
                        message = dis.readUTF();
                        System.out.println(message);
                        break;
                    }
                    case 4: {
                        System.out.println("Tam biet!");
                        break;
                    }
                    default: {
                        System.out.println("Khong ton tai chuc nang nay");
                        break;
                    }
                }
                
            } while (luachon != 4);

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
