/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package R_Hcgd;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author oOOo
 */
public class Sample extends UnicastRemoteObject implements IMyRemote {

    ArrayList<Mathang> listMatHang;

    public Sample(ArrayList<Mathang> listMH) throws RemoteException {
        super();
        listMatHang = listMH;
    }

    @Override
    public String randomMathang() throws RemoteException {
        Random rd = new Random();
        int i = rd.nextInt(listMatHang.size());
        return listMatHang.get(i).Tenhanghoa;
    }

    @Override
    public String ktraDudoan(String tenMatHang, int gia) throws RemoteException {
        for (Mathang mh : listMatHang) {
            if (mh.Tenhanghoa.equals(tenMatHang)) {
                if (mh.Giatien < gia) {
                    return "Gia du doan cao";
                }
                if (mh.Giatien > gia) {
                    return "Gia du doan thap";
                }
                return "Gia du doan chinh xac";
            }
        }
        return "";
    }

}
