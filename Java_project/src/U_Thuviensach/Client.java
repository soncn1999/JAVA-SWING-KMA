/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U_Thuviensach;

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

    DatagramSocket socket;
    DatagramPacket packet;

    public static void main(String[] args) {
        Client cl = new Client();
        cl.connect();
        Scanner input = new Scanner(System.in);
        String k = "";

        while (!k.equals("4")) {
            System.out.println("===========MENU==========");
            System.out.println("1. Hien thi thong tin sach");
            System.out.println("2. Muon sach");
            System.out.println("3. Tra sach");
            System.out.println("4. Thoat");
            System.out.println("Ban lua chon > ");
            k = input.nextLine();
            cl.write(k);

            switch (k) {
                case "1": {
                    String Thongtinsach = cl.read();
                    System.out.println("Thong tin toan bo sach!");
                    System.out.println(Thongtinsach);
                    break;
                }
                case "2": {
                    System.out.println("Nhap ID sach ban can muon > ");
                    String id = input.nextLine();
                    cl.write(id);
                    System.out.println(cl.read());
                    break;
                }
                case "3": {
                    System.out.println("Nhap ID sach ban muon tra > ");
                    String id = input.nextLine();
                    cl.write(id);
                    System.out.println(cl.read());
                    break;
                }
                case "4": {
                    System.out.println("Thoat thanh cong!");
                    break;
                }
                default: {
                    System.out.println("Ban da chon sai!!!");
                    break;
                }
            }
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
            return "";
        }
    }
}
