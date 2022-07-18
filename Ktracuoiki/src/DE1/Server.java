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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oOOo
 */
public class Server {

    DatagramSocket socket;
    DatagramPacket packet;

    public static void main(String[] args) {
        Server sv = new Server();
        sv.connect();
        String s = sv.read();
        System.out.println(s);
        String message = "";
        String[] a = s.split("\\:");
        int n = Integer.parseInt(a[1].trim());
        
        double result = 0;
        if (n >= 0 && n <= 50) {
            message = "";
            result = n * 1.7;
            message = "Hoá đơn của bạn: " + result;
        }
        if (n >= 51 && n <= 100) {
            message = "";
            result = n * 2.0;
            message = "Hoá đơn của bạn: " + result;
        }
        if (n >= 101) {
            message = "";
            result = n * 2.5;
            message = "Hoá đơn của bạn: " + result;
        }
        sv.write(message);
    }

    public void connect() {
        try {
            socket = new DatagramSocket(2811);
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
}
