/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_Practice;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oOOo
 */
public class Client {

    DatagramPacket packet;
    DatagramSocket socket;

    public static void main(String[] args) {
        Client cl = new Client();
        cl.connect();
        Scanner input = new Scanner(System.in);
        String message = "";

        System.out.println("Nhap username: ");
        String username = input.nextLine();
        System.out.println("nhap password: ");
        String password = input.nextLine();
        String s = username + "$" + password;
        cl.write(s);
        message = cl.read();
        System.out.println(message);
        if (message.equals("Dang nhap thanh cong!")) {
            System.out.println("Bat dau chat");
            while (true) {
                System.out.println("Say something...");
                String message1, message2 = "";
                message1 = input.nextLine();
                cl.write(message1);
                if (message1.equals("exit")) {
                    System.out.println("Chat ended");
                    break;
                }
                
                message2 = cl.read();
                System.out.println("Server: " + message2);
                if (message2.equals("exit")) {
                    System.out.println("Chat ended");
                    break;
                }
            }
        } else {
            System.out.println("Ban da thoat");
        }
    }

    public void connect() {
        try {
            socket = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void write(String s) {
        try {
            byte[] data = new byte[1024];
            data = s.getBytes();
            InetAddress ipServer = InetAddress.getByName("localhost");
            packet = new DatagramPacket(data, data.length, ipServer, 2811);
            socket.send(packet);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String read() {
        try {
            byte[] data = new byte[1024];
            packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            String s = new String(packet.getData()).trim();
            return s;
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
}
