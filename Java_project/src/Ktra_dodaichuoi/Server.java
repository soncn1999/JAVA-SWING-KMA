/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ktra_dodaichuoi;

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
            System.out.println("Khoi tao thanh cong Server, cho Client!!!");
            while(true) {
                Socket socket = myServer.accept();
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                String s = dis.readUTF();
                dos.writeUTF("Chuoi " + "'"+ s +"'" + " dai: " + s.length());
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
