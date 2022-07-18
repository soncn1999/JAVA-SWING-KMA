/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

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
            System.out.println("Khoi tao xong, cho client!!!");
            while(true) {
                Socket socket = myServer.accept();
                System.out.println("Client da ket noi!");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                System.out.println("Server nhan: " + dis.readUTF());
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
