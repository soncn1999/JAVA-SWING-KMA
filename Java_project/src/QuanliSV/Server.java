/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanliSV;

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
        ArrayList<Sinhvien> listsv = new ArrayList<>();
        try {
            //doc file
            BufferedReader br = new BufferedReader(new FileReader("Sinhvien.txt"));
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] a = s.split("\\$");
                Sinhvien sv = new Sinhvien(a[0], a[1], a[2], a[3]);
                listsv.add(sv);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ServerSocket myServer = new ServerSocket(2811);
            System.out.println("Server khoi tao xong, cho Client!!!");
            while (true) {
                Socket socket = myServer.accept();
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                int k = 0;
                String message = "";
                do {
                    k = dis.readInt();
                    switch (k) {
                        case 1: { //Xem ds sinh vien
                            message = "";
                            for (Sinhvien sv : listsv) {
                                message = message + sv.Hoten + "\n";
                            }
                            dos.writeUTF(message);
                            break;

                        }
                        case 2: { //Them sinh vien
                            message = dis.readUTF();
                            String[] a = message.split("\\$");
                            Sinhvien sv = new Sinhvien(a[0], a[1], a[2], a[3]);
                            listsv.add(sv);
                            break;
                        }
                        case 3: { //xem thong tin sv
                            message = "";
                            for (Sinhvien sv : listsv) {
                                message = message + sv.ThongtinSV() + "\n";
                            }
                            dos.writeUTF(message);
                            break;
                        }
                        case 4: { //tim sv theo nhom
                            message = "";
                            int k2 = dis.readInt();
                            int count; //ktra kqua tra ve cho client
                            switch (k2) {
                                case 1: { //Tim theo que quan
                                    count = 0;
                                    String s = dis.readUTF();
                                    for (Sinhvien sv : listsv) {
                                        if (s.equalsIgnoreCase(sv.Quequan)) {
                                            message = message + sv.ThongtinSV() + "\n";
                                            count++;
                                        }
                                    }
                                    if (count == 0) {
                                        message = "Ko tim thay SV!";
                                        dos.writeUTF(message);
                                    } else {
                                        dos.writeUTF(message);
                                    }
                                    break;
                                }
                                case 2: {
                                    count = 0;
                                    String s = dis.readUTF();
                                    for (Sinhvien sv : listsv) {
                                        String[] arr = sv.Ngaysinh.split("/");
                                        if (s.equalsIgnoreCase(arr[2])) {
                                            message = message + sv.ThongtinSV() + "\n";
                                            count++;
                                        }
                                    }
                                    if (count == 0) {
                                        message = "Ko tim thay SV!";
                                        dos.writeUTF(message);
                                    } else {
                                        dos.writeUTF(message);
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                        default: {
                            System.out.println("Lua chon khong hop le!");
                            break;
                        }
                    }
                } while (k != 5);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
