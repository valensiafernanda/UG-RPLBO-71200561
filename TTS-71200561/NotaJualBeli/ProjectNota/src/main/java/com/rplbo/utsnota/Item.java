package com.rplbo.utsnota;

public class Item {
    KertasHVS krhvs;
    BukuTulis bktulis;
    Pulpen pen;

    public Item(KertasHVS kertasHVS[]){

    }

    public Item(BukuTulis bukuTulis[]){

    }

    public Item(Pulpen pulpens[]){

    }

    public Item(BukuTulis bukuTulis[], Pulpen pulpens[]){

    }

    public Item(KertasHVS kertasHVS[], Pulpen pulpen[]){

    }

    public Item(BukuTulis bukuTulis[], KertasHVS kertasHVS[]){

    }

    public Item(BukuTulis bukuTulis[], KertasHVS kertasHVS[], Pulpen pulpen[]){

    }

    public int getJumlahBukuTulis(){

        return 0;
    }

    public int getJumlahPen(){
        return 0;
    }

    public Pulpen getPen() {
        return pen;
    }

    public int getJumlahKertasHVS(){

        return 0;
    }

    public BukuTulis getBktulis(){
        return null;
    }

    public KertasHVS getKrhvs() {
        return krhvs;
    }

}

