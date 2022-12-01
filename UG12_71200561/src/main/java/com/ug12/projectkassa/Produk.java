package com.ug12.projectkassa;

public class Produk {
    private long harga;
    private String nama;

    public Produk(String nama, long harga) {
        this.harga = harga;
        this.nama = nama;
    }

    public String getNama() {
         return nama;
    }

    public long getHarga() {
        return harga;
    }
}

