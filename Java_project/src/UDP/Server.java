/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
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
        System.out.println("Thong diep tu client: " + s);
        sv.write("Day la Server, chao Client!");
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
