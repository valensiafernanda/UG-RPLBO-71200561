package com.ug14.rumahsakit;

public class Pasien {
    private int rm;
    private String nama;
    private int usia;
    private String alamat;
    private String penyakit;
    private int levelPenyakit = 5;
    private Boolean status = false;

    

    public Pasien(String nama, int usia, String alamat){
        this.nama = nama;
        this.usia = usia;
        this.alamat = alamat;
    }

    public int getRm(){
        return rm;
    }

    public int getLevelPenyakit() {
        return levelPenyakit;
    }

    public Boolean getStatus() {
        return status;
    }

    public void sembuh(){
        this.status = true;
    }

    public void descLevelPenyakit(){
        this.levelPenyakit -= 1;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public String getNama() {
        return nama;
    }

    public int getUsia() {
        return usia;
    }

    public String getAlamat() {
        return alamat;
    }


}
