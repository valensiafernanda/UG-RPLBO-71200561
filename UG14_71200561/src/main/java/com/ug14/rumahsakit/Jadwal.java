package com.ug14.rumahsakit;

public class Jadwal {
    private int idPemeriksaan;
    private Pasien pasien;
    private Dokter dokter;
    private Suster suster;
    private Pelayan pelayan;
    private Boolean statusDaftar = false;
    private Boolean statusScreening = false;

    public Dokter getDokter(){
        return dokter;
    }

    public Suster getSuster() {
        return suster;
    }

    public Pelayan getPelayan() {
        return pelayan;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void sudahDaftar() {
        this.statusDaftar = true;
    }

    public void sudahScreening() {
        this.statusScreening = true;
    }

    public Boolean getStatusScreening() {
        return statusScreening;
    }

    public Boolean getStatusDaftar() {
        return statusDaftar;
    }
}
