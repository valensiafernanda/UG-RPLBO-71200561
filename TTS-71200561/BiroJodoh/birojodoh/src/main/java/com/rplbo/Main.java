package com.rplbo;

public class Main {
    //entry point
    public static void main( String[] args )
    {
        Pria farel = new Pria("Farel", 20);
        Perempuan sage = new Perempuan("Sage", 20, 5.0);
        farel.PDKT(sage);
        for (int i = 0; i < 10; i++) {
            farel.MengajakKencan(sage);
        }
        farel.MenembakKekasih();
        Perempuan pelakor = new Perempuan ("Jett", 21, 1.0);
        System.out.println("==========================================");
        farel.PDKT(pelakor);
        farel.MengajakKencan(pelakor);
        System.out.println("======================================");
        Pria vito = new Pria("Vito", 21);
        vito.MenembakKekasih();
    }
}