package com.rplbo.uasprojectpos;

import java.util.HashMap;

public class App
{
    public static void main( String[] args )
    {
        PointOfSales pos = new PointOfSales();
        Barang mouse1 = new Barang("Mouse Rexus Arka 107",5,285000);
        Barang mouse2 = new Barang("Mouse Logitech G-102",10,250000);
        Barang headset1 = new Barang("Headset Logitech G-331",2,600000);
        Barang keyboard1 = new Barang("Keyboard Keychron K3",1,1500000);
        pos.inputBarang(mouse1);
        pos.inputBarang(mouse2);
        pos.inputBarang(headset1);
        pos.inputBarang(keyboard1);
        System.out.println("\n==========Skenario 1: Tampil Stok Barang==========");
        pos.tampilDaftarBarang();
        System.out.println("\n==========Skenario 2: Checkout Barang==========");
        HashMap<Barang, Integer> keranjang1 = new HashMap<>();
        keranjang1.put(mouse1,2);
        keranjang1.put(mouse2,3);
        pos.checkout(keranjang1,1350000);
        System.out.println("\n==========Skenario 3: Tampil Stok Barang==========");
        pos.tampilDaftarBarang();
    }
}