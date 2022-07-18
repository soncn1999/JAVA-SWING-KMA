/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ktra_thang;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oOOo
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket myServer = new ServerSocket(2811);
            System.out.println("Thiet lap xong Server, cho Client!!!");
            while (true) {
                Socket socket = myServer.accept();
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                int n = dis.readInt();
                if (n == 2) {
                    dos.writeUTF("Thang " + n + " co 28 ngay!!!");
                } else if (n == 1 || n == 3 || n == 5 || n == 7 || n == 8 || n == 10 || n == 12) {
                    dos.writeUTF("Thang " + n + " co 31 ngay!!!");
                } else {
                    dos.writeUTF("Thang " + n + " co 31 ngay!!!");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
