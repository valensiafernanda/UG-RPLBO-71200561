package com.V71200561-1.app;

import java.util.Scanner;
public class App
{
    public static void main( String[] args )
    {
        String namaMakanan;
        String tanggal;
        int jumlah;
        int berat;
        Scanner scan = new Scanner(System.in);
        System.out.println("======Data Product======");
        System.out.println("Masukkan Data Product: ");
        System.out.println("Nama Makanan: ");
        namaMakanan = scan.nextLine();
        System.out.println("Tanggal Kadaluarsa: ");
        tanggal = scan.nextLine();
        System.out.println("jumlah (quantity): ");
        jumlah = scan.nextInt();
        System.out.println("berat (gram): ");
        berat = scan.nextInt();

        System.out.println("======Data Product======");
        System.out.println("Nama Makanan = "+namaMakanan);
        System.out.println("Tanggal Kadaluarsa = " + tanggal);
        System.out.println("Jumlah(q) = " +jumlah);
        System.out.println("Berat = " + berat+"gram");
        System.out.println("======================");
    }
}
