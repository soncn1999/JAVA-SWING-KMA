/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package R_Hcgd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oOOo
 */
public class Server {
    public static void main(String[] args) {
        ArrayList<Mathang> listMathang = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Mathang.txt"));
            String s = "";
            while((s = br.readLine()) != null) {
                String[] a = s.split("\\$");
                Mathang mathang = new Mathang(a[0], a[1], Integer.parseInt(a[2]));
                listMathang.add(mathang);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Connect RMI
        try {
            IMyRemote obj = new Sample(listMathang);
            LocateRegistry.createRegistry(1099);
            Naming.rebind("ABC", obj);
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
