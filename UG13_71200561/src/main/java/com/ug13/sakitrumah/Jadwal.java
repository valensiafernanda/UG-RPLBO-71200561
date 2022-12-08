package com.ug13.sakitrumah;

public class Jadwal {
    private Pengunjung pengunjung;
    private Pemeriksa pemeriksa;
    private Perawat perawat;
    private Pendaftaran pendaftaran;
    private Boolean statusDaftar = false;
    private Boolean statusScreening = false;

    public Pengunjung getPengunjung() {
        return pengunjung;
    }

    public void sudahDaftar(){
        this.statusDaftar = true;
    }

    public void sudahScreening(){
        this.statusScreening = true;
    }

    public Boolean getStatusDaftar() {
        return statusDaftar;
    }

    public Boolean getStatusScreening() {
        return statusScreening;
    }
}


