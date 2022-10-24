package com.rplbo.utsnota;

public class Nota {
    private String nonota;
    private String notelppembeli;
    private Item items;
    private String namapembeli;

    public Nota(String nonota, String notelppembeli, String namapembeli, Item items){

    }

    public void setNotelppembeli(String notelppembeli) {
        this.notelppembeli = notelppembeli;
    }

    public void setNamapembeli(String namapembeli) {
        this.namapembeli = namapembeli;
    }

    public String getNonota() {
        return nonota;
    }

    public String getNamapembeli() {
        return namapembeli;
    }

    public void setNonota(String nonota) {
        this.nonota = nonota;
    }

    public void tampilNota(){

    }

    public String getNotelppembeli() {
        return notelppembeli;
    }

    public int hitungTotalBayar(){

        return 0;
    }
}
