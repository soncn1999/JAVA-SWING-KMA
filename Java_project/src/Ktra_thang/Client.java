/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ktra_thang;

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
            boolean c = false;
            while (c == false) {
                System.out.println("Nhap vao thang trong nam");
                int n = input.nextInt();
                if (n > 0 && n <= 12) {
                    dos.writeInt(n);
                    c = true;
                } else {
                    System.out.println("Thang vua nhap khong dung!!!");
                }
            }

            String result = dis.readUTF();
            System.out.println("Ket qua kiem tra thang: " + result);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
