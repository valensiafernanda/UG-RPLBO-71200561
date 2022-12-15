package com.ug14.rumahsakit;

public class Suster {
    private int idSuster;
    private String nama;

    public void setIdSuster(int idSuster) {
        this.idSuster = idSuster;
    }

    public Suster(String nama){
        this.nama = nama;
    }

    public void screening(Pasien pasien, Jadwal jadwal){
        if(jadwal.getStatusDaftar() == false){
            System.out.println("==============ANDA HARUS MELAKUKAN PROSES PENDAFTARAN TERLEBIH DAHULU DI BAGIAN PELAYANAN===================");
        }else {
            jadwal.sudahScreening();
        }
    }

    public int getIdSuster() {
        return idSuster;
    }
}
