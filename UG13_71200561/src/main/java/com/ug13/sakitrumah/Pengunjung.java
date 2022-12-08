package com.ug13.sakitrumah;

public class Pengunjung {
    private String nama;
    private int usia;
    private String alamat;
    private String penyakit;
    private int levelPenyakit = 5;
    private String status = "False";

    public Pengunjung(String nama, int usia, String alamat){
        this.nama = nama;
        this.usia = usia;
        this.alamat = alamat;
        this.penyakit = penyakit;
    }


    public String getStatus() {
        return status;
    }

    public void sembuh(){
        this.status = "true";
    }

    public void setLevelPenyakit(int levelPenyakit) {
        this.levelPenyakit -= 1;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public int getLevelPenyakit() {
        return levelPenyakit;
    }
}
