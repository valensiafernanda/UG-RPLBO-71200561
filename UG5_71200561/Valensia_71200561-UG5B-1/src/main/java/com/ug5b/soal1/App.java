package com.ug5b.soal1;

public class App
{
    public static void main( String[] args )
    {
        SmartCard sc = new SmartCard();
        sc.setNama("Guntur Putra");
        sc.setSaldo(50000);
        Voucher vc1 = new Voucher();
        vc1.setNominal(-50000);
        vc1.buatVoucher();
        Voucher vc2 = new Voucher();
        vc2.setNominal(50000);
        vc2.buatVoucher();
        Voucher vc3 = new Voucher();
        vc3.setNominal(150000);
        vc3.buatVoucher();
        System.out.println("=====Skenario 1: Top Up Gagal=====");
        sc.topUp(vc1);
        System.out.println("===> Saldo "+sc.getNama()+" saat ini Rp "+sc.getSaldo());
        System.out.println("\n=====Skenario 2: Top Up Sukses=====");
        sc.topUp(vc2);
        sc.topUp(vc3);
        System.out.println("===> Saldo "+sc.getNama()+" saat ini Rp "+sc.getSaldo());
    }
}