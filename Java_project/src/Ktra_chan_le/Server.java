/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ktra_chan_le;

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
            System.out.println("Server khoi tao xong, cho client!!!");
            while(true) {
                Socket socket = myServer.accept();
                System.out.println("Client da ket noi!!!");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                int n = dis.readInt();
                
                if(n%2==0) {
                    dos.writeUTF(n + " LA SO CHAN");
                }else{
                    dos.writeUTF(n + " LA SO LE");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
