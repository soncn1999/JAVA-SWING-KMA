/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Qly_nhanvien;

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
        ArrayList<Nhanvien> listnv = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Nhanvien.txt"));
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] a = s.split("\\$");
                Nhanvien nv = new Nhanvien(a[0], a[1], a[2]);
                listnv.add(nv);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ServerSocket myServer = new ServerSocket(2811);
            System.out.println("Thiet lap Server xong!");
            while (true) {
                Socket socket = myServer.accept();
                System.out.println("Dang cho Client!");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                int luachon = 0;
                String message = "";
                do {
                    luachon = dis.readInt();
                    switch (luachon) {
                        case 1: {
                            message = "";
                            for (Nhanvien nv : listnv) {
                                message = message + nv.showInfo() + "\n";
                            }
                            System.out.println(message);
                            dos.writeUTF(message);
                            break;
                        }
                        case 2: {
                            message = dis.readUTF();
                            String[] s = message.split("\\$");
                            Nhanvien nv = new Nhanvien(s[0], s[1], s[2]);
                            listnv.add(nv);
                            break;
                        }
                        case 3: {
                            message = "";
                            String tenNV = dis.readUTF();
                            int count = 0;
                            for(Nhanvien nv: listnv) {
                                if(tenNV.equalsIgnoreCase(nv.Hoten)) {
                                    message = message + nv.showInfo();
                                    count ++;
                                }
                            }
                            if(count == 0) {
                                message = "Khong tim thay NV";
                            }
                            dos.writeUTF(message);
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                } while (luachon != 4);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
