/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U_Thuviensach;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
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
        //Doc file
        ArrayList<Sach> listsach = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Sach.txt"));
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] a = s.split("\\$");
                Sach sach = new Sach(a[0], a[1], a[2],
                        Integer.parseInt(a[3]),
                        Integer.parseInt(a[4]));
                listsach.add(sach);
            }
        } catch (Exception e) {
            System.out.println("error: " + e);
        }

        Server sv = new Server();
        sv.connect();

        String k = "";
        String message = "";
        while (!k.equals("4")) {
            k = sv.read();
            switch (k) {
                case "1": {
                    String Thongtinsach = "";
                    for (Sach sach : listsach) {
                        Thongtinsach = Thongtinsach + sach.ShowInfo() + "\n";
                    }
                    sv.write(Thongtinsach);
                    break;
                }
                case "2": {
                    String id = sv.read();
                    int count = 0;
                    for (Sach sach : listsach) {
                        if (sach.ID.equals(id)
                                && sach.Soluongchomuon < sach.Tongsoluong) {
                            message = "Muon thanh cong";
                            count++;
                            sach.Soluongchomuon++;
                        }
                    }
                    if (count == 0) {
                        message = "Khong tim thay sach hoac da het sach muon!";
                    }
                    sv.write(message);
                    break;
                }
                case "3": {
                    String id = sv.read();
                    int count = 0;
                    for(Sach sach: listsach) {
                        if(sach.ID.equals(id)) {
                            message="Tra sach thanh cong";
                            sach.Soluongchomuon--;
                            count++;
                        }
                    }
                    if(count==0){
                        message = "Khong tim thay sach can tra!";
                    }
                    sv.write(message);
                    break;
                }
            }
        }

    }

    public void connect() {
        try {
            //Thay doi so voi client
            socket = new DatagramSocket(2811);
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void write(String s) {
        try {
            //Thay doi so voi client
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
            return "";
        }
    }
}
