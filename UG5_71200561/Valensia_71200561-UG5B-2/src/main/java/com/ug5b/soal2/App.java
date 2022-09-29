package com.ug5b.soal2;

public class App
{
    public static void main( String[] args )
    {
        Buku bukuA = new Buku("Cinta itu Alasan Sekaligus Tujuan","Kang Maman",62400,5);
        Buku bukuB = new Buku("Autumn in Paris","Ilana Tan",63200,7);
        Buku bukuC = new Buku("Critical Eleven","Ika Natassa",74400,2);
        System.out.println("\n========== Daftar Buku Gramedia==========\n");
        infoBuku(bukuA);
        infoBuku(bukuB);
        infoBuku(bukuC);
    }

    private static void infoBuku(Buku buku) {
        System.out.println("Kode: "+buku.getKode());
        System.out.println("Penulis: "+buku.getPenulis());
        System.out.println("Harga: "+buku.getHarga());
        System.out.println("Stok: "+buku.getStok());
    }
}
