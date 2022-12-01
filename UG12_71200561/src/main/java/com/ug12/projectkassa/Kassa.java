package com.ug12.projectkassa;

import java.util.ArrayList;
import java.util.HashMap;

public class Kassa {
    private HashMap<Produk, Integer> pesanan = new HashMap<Produk, Integer>();
    private ArrayList<Kasir> arrKasir = new ArrayList<Kasir>();
    private Kasir kasir;

    public void login(String username, String password){
        boolean flag = false;
        for(int i = 0; i < this.arrKasir.size(); i++){
            Kasir iter = this.arrKasir.get(i);
            if((iter.getUsername().equals(username) && iter.getPassword().equals(password))) {
                flag = true;
                this.kasir = iter;
            }
        }
        if(flag) {
            System.out.println("Login berhasil!");
        } else {
            System.out.println("Username/password Anda salah!");
        }
    }

    public void register(Kasir kasir) {
        this.arrKasir.add(kasir);
        System.out.println("Kasir " + kasir.getNama() + " berhasil ditambahkan ke dalam sistem.");
    }

    public void tambahPesanan(Produk produk, int jumlah) {
        this.pesanan.put(produk, jumlah);
    }

    public void printNota() {
        System.out.println("==========Nota==========");
        System.out.println("Kasir: " + this.kasir.getNama());
        System.out.println("No.\tNama Barang\t\tJumlah\t\tHarga\t\tSub Total");
        int inc = 1;
        int total = 0;
        for(Produk i : this.pesanan.keySet()) {
            int sub = (int) (i.getHarga() * this.pesanan.get(i));
            total += sub;
            System.out.println(inc + ".\t" + i.getNama() + "\t\t" + this.pesanan.get(i) + "x" + "\t\t" + i.getHarga() + "\t\t" + sub);
            inc += 1;
        }
        this.kasir.setTotalPenjualan(total);
        System.out.println("Total: Rp" + total);
        this.pesanan.clear();
    }

    public void printPenjualanKasir() {
        System.out.println("Daftar Kasir:");
        System.out.println("No.\tNama\t\t\t\tTotal Penjualan");
        for(int i = 0; i < this.arrKasir.size(); i++) {
            Kasir iter = this.arrKasir.get(i);
            System.out.println(i+1 + ".\t" + iter.getNama() + "\t\tRp" + iter.getTotalPenjualan());
        }
    }
}

