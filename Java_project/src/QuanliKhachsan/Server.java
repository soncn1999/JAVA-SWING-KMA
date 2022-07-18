/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanliKhachsan;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oOOo
 */
public class Server {

    public static void main(String[] args) {

        ArrayList<Khachhang> listKhachhang = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Khachhang.txt"));
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] a = s.split("\\$");
                Khachhang khachhang = new Khachhang(a[0], a[1], a[2]);
                listKhachhang.add(khachhang);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ServerSocket myServer = new ServerSocket(2811);
            System.out.println("Khoi tao Server thanh cong!");
            while (true) {
                Socket socket = myServer.accept();
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                int luachon = 0;
                String message = "";
                do {
                    luachon = dis.readInt();
                    switch (luachon) {
                        case 1: {
                            message = dis.readUTF();
                            String[] s = message.split("\\$");
                            Khachhang khachhang = new Khachhang(s[0], s[1], s[2]);
                            listKhachhang.add(khachhang);
                            for (Khachhang i : listKhachhang) {
                                System.out.println(i.ShowAll());
                            }
                            break;
                        }
                        case 2: {
                            message = "";
                            String tenKH = dis.readUTF();
                            int count = 0;
                            int ketqua = 0;
                            String loaiphong = "";
                            for (Khachhang i : listKhachhang) {
                                if (tenKH.equalsIgnoreCase(i.Hoten)) {
                                    message = "Tim thay";
                                    loaiphong = i.Loaiphong;
                                    count++;
                                }
                            }
                            if (count == 0) {
                                message = "Ko tim thay";
                            }
                            dos.writeUTF(message);

                            int ngay = dis.readInt();
                            if (loaiphong.equals("A")) {
                                ketqua = ngay * 250000;
                            } else if (loaiphong.equals("B")) {
                                ketqua = ngay * 100000;
                            } else {
                                ketqua = ngay * 500000;
                            }
                            dos.writeInt(ketqua);
                            break;
                        }
                        default: {
                            System.out.println("Ket thuc!");
                            break;
                        }
                    }
                } while (luachon != 3);

            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
