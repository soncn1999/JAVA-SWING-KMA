/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package R_Hcgd;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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
            IMyRemote obj = (IMyRemote) Naming.lookup("rmi://localhost:1099/ABC");
            System.out.println("======Game Show======");
            System.out.println("He thong se dua ra mot mat hang, ban co 7 luot doan!");
            String TenMH = obj.randomMathang();
            System.out.println("San pham do la: " +TenMH);
            Scanner input = new Scanner(System.in);
            int luotchoi = 1;
            while(luotchoi <= 7) {
                System.out.println("Luot du doan thu: " + luotchoi + ": ");
                int n = input.nextInt();
                String ketqua = obj.ktraDudoan(TenMH, n);
                System.out.println(ketqua);
                if(ketqua.equals("Gia du doan chinh xac")) {
                    System.out.println("Chuc mung ban da chien thang!");
                    return;
                }
            }
            if(luotchoi > 7) {
                System.out.println("Chuc ban may man lan sau!");
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
