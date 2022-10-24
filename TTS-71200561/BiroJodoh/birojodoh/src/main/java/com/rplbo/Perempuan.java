package com.rplbo;

public class Perempuan {
    private String nama;
    private int usia;
    private String status;
    private double jumlahCinta;
    private Pria jodoh;
    private Pria temanKencan;
    private Double standarJumlahCinta;

    public Perempuan(String nama, int i, double v) {
    }

    public void Mengajakkencan(Pria pria){

    }

    public String getNama(){
        return nama;
    }

    public int getUsia(){
        return usia;
    }

    public String getStatus(){
        return status;
    }

    public double getJumlahCinta(){
        return jumlahCinta;
    }

    public Pria getJodoh(){
        return jodoh;
    }

    public Pria getTemanKencan(){
        return temanKencan;
    }

    public Double getStandarJumlahCinta(){
        return standarJumlahCinta;
    }

    public void setNama(){
        this.nama = nama;
    }

    public void setUsia(){
        this.usia = usia;
    }

    public void setStatus(){
        this.status = status;
    }

    public void setJodoh(){
        this.jodoh = jodoh;
    }

    public void setJumlahCinta(){
        this.jumlahCinta = jumlahCinta;
    }

    public void setTemanKencan(){
        this.temanKencan = temanKencan;
    }

}
