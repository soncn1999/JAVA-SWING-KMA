/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_Practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oOOo
 */
public class Server {

    DatagramPacket packet;
    DatagramSocket socket;

    public static void main(String[] args) {
        Server sv = new Server();
        sv.connect();

        ArrayList<User> listUser = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("User.txt"));
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] a = s.split("\\$");
                User user = new User(a[0], a[1]);
                listUser.add(user);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        String s = sv.read();
        String[] a1 = s.split("\\$");
        String message = "";
        Scanner input = new Scanner(System.in);
        int count = 0;
        for (User i : listUser) {
            if (i.Username.equals(a1[0]) && i.Password.equals(a1[1])) {
                message = "Dang nhap thanh cong!";
                sv.write(message);
                System.out.println("Dang nhap thanh cong!");
                count++;
                while (true) {
                    String message1, message2 = "";
                    message1 = sv.read();
                    System.out.println("Client : " + message1);
                    if (message1.equals("exit")) {
                        System.out.println("Chat ended");
                        break;
                    }
                    System.out.println("Say something...");
                    message2 = input.nextLine();
                    sv.write(message2);
                    if (message2.equals("exit")) {
                        System.out.println("Chat ended");
                        break;
                    }
                }
            }
        }
        if (count == 0) {
            message = "Dang nhap that bai";
            sv.write(message);
            System.out.println("Dang nhap that bai");
        }

    }

    public void connect() {
        try {
            socket = new DatagramSocket(2811);
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void write(String s) {
        try {
            byte[] data = new byte[1024];
            data = s.getBytes();
            InetAddress ipClient = packet.getAddress();
            int portClient = packet.getPort();
            packet = new DatagramPacket(data, data.length, ipClient, portClient);
            socket.send(packet);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
}
