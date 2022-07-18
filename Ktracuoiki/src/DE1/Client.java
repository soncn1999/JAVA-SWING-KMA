/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DE1;

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
        System.out.println("Nhập vào lượng điện tiêu thụ > ");
        int n = Integer.parseInt(input.nextLine());

        String s = "";
        s = "Chỉ số điện tiêu thụ: " + n;
        cl.write(s);
        String message = cl.read();
        System.out.println(message);
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
