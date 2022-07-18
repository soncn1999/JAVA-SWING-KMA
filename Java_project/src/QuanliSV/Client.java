/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanliSV;

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
            int k = 0; //luachon
            String message = "";//thong diep gui server

            do {
                System.out.println("========MENU=======");
                System.out.println("1. Xem danh sach SV");
                System.out.println("2. Them SV moi");
                System.out.println("3. Xem thong tin SV");
                System.out.println("4. Tim nhom SV theo que quan/ nam sinh");
                System.out.println("5. Thoat");
                System.out.println("Ban chon MENU > ");
                k = Integer.parseInt(input.nextLine());
                dos.writeInt(k);
                switch (k) {
                    case 1: { //Xem ds sinh vien
                        message = dis.readUTF();
                        System.out.println("DS Ten SV: ");
                        System.out.println(message);
                        break;
                    }
                    case 2: { //Them sinh vien
                        System.out.println("Nhap vao thong tin SV moi: ");
                        System.out.println("Ho ten > ");
                        String hoten = input.nextLine();
                        System.out.println("Ngay sinh > ");
                        String ngaysinh = input.nextLine();
                        System.out.println("Masv > ");
                        String masv = input.nextLine();
                        System.out.println("Que quan > ");
                        String quequan = input.nextLine();
                        message = hoten + "$" + ngaysinh + "$" + masv + "$" + quequan;
                        dos.writeUTF(message);
                        System.out.println("Them SV thanh cong!!!");
                        break;
                    }
                    case 3: { //xem thong tin sv
                        message = dis.readUTF();
                        System.out.println("Thong tin toan bo SV: ");
                        System.out.println(message);
                        break;
                    }
                    case 4: { //tim sv theo nhom
                        System.out.println("Ban muon tim theo: "
                                + "\n1.Que quan"
                                + "\n2.Nam sinh"
                                + "\nBan chon >");
                        int k2 = Integer.parseInt(input.nextLine());
                        String s = ""; // key search
                        dos.writeInt(k2);
                        switch (k2) {
                            case 1: { //Search Que quan
                                System.out.println("Nhap que quan: ");
                                s = input.nextLine();
                                dos.writeUTF(s);
                                message = dis.readUTF();
                                System.out.println(message);
                                break;
                            }
                            case 2: { //Search nam sinh
                                System.out.println("Nhap nam sinh: ");
                                s = input.nextLine();
                                dos.writeUTF(s);
                                message = dis.readUTF();
                                System.out.println(message);
                                break;
                            }
                            default: {
                                System.out.println("Lua chon ko hop le!");
                                break;
                            }
                        }
                        break;
                    }
                    case 5: { //thoat
                        System.out.println("Thoat thanh cong!");
                        break;
                    }
                    default: {
                        System.out.println("Lua chon khong hop le!");
                        break;
                    }
                }
            } while (k != 5);

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
