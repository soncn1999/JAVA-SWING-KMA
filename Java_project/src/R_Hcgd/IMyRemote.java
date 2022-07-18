/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package R_Hcgd;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author oOOo
 */
public interface IMyRemote extends Remote{
    public String randomMathang() throws RemoteException;
    public String ktraDudoan(String tenMatHang, int gia) throws RemoteException;
}
