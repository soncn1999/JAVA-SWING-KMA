/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

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
            System.out.println("Gui Server: ");
            Scanner input = new Scanner(System.in);
            String s = input.nextLine();
            dos.writeUTF(s);
//              Truyen di
//            dos.writeInt(0);
//            dos.writeUTF("Hello");
            //Nhan ve
//            dis.readInt();
//            dis.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
