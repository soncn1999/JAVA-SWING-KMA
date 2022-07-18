/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author oOOo
 */
public class main {

    public static void main(String[] args) {
        //Vao ra File
//        try {
//            //Viet vao file
//            BufferedWriter bw
//                    = new BufferedWriter(new FileWriter("Sinhvien.txt", true));
//            Scanner input = new Scanner(System.in);
//            System.out.println("Masv > ");
//            String ID = input.nextLine();
//            System.out.println("Hoten > ");
//            String Hoten = input.nextLine();
//            System.out.println("Lop > ");
//            String Lop = input.nextLine();
//            System.out.println("Tuoi > ");
//            int Tuoi = Integer.parseInt(input.nextLine());
//            String s = ID + "$" + Hoten + "$" + Lop + "$" + Tuoi + "$";
//            System.out.println("Ban vua nhap: " + s);
//            bw.write(s);
//            bw.newLine();
//            bw.close();
//            System.out.println("Ghi thanh cong!!!");
//        } catch (Exception e) {
//            System.out.println("Ghi that bai: " + " " + e);
//        }

        ArrayList<Sinhvien> listsv = new ArrayList<>();
        try {
            //Doc ra file
            BufferedReader br = new BufferedReader(
                    new FileReader("Sinhvien.txt"));
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] a = s.split("\\$");
                Sinhvien sv
                        = new Sinhvien(a[0], a[1], a[2], Integer.parseInt(a[3]));
                listsv.add(sv);
            }
            br.close();
            for (Sinhvien sv : listsv) {
                sv.showInfo();
            }
        } catch (Exception e) {
            System.out.println("Doc that bai: " + " " + e);
        }
    }
}
