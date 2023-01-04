package com.rplbo.uasprojectpos;

public class Barang {
    public Barang(String kode, int stok, long harga) {

    }

    private String kode;
    private int stok;
    private int nextNum;
    private String nama;
    private long harga;

    public int getStok() {
        return stok;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public long getHarga() {
        return harga;
    }
}