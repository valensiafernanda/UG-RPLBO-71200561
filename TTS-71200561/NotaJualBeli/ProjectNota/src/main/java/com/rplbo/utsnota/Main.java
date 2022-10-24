package com.rplbo.utsnota;
import java.util.Scanner;
public class Main {
    //entry point
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        KertasHVS[] kertasygdibeli = null;
        BukuTulis[] bukuygdibeli = null;
        Pulpen[] pulpenygdibeli = null;
        int n;
        System.out.print("Apakah akan membeli Buku Tulis? [Y/T] : ");
        String jwb = sc.nextLine();
        if(jwb.equals("Y") || jwb.equals("y")){
            System.out.print("Berapa jumlah Buku Tulis? ");
            jwb = sc.nextLine();
            n = Integer.parseInt(jwb);
            bukuygdibeli = new BukuTulis[n];
            for (int i=1;i<=Integer.parseInt(jwb);i++){
                System.out.print("Masukkan Kode Buku Tulis: ");
                String kode = sc.nextLine();
                System.out.print("Masukkan Nama Buku Tulis: ");
                String deskripsi = sc.nextLine();
                System.out.print("Masukkan Harga Buku Tulis: ");
                int harga = Integer.parseInt(sc.nextLine());
                System.out.print("Masukkan Berat Buku Tulis: ");
                int berat = Integer.parseInt(sc.nextLine());
                System.out.print("Masukkan Merk Buku Tulis: ");
                String merk = sc.nextLine();
                System.out.println();
                bukuygdibeli[i-1] = new
                        BukuTulis(kode,harga,berat,deskripsi,merk);
            }
        }
        System.out.println();
        System.out.print("Apakah akan membeli Pulpen? [Y/T] : ");
        jwb = sc.nextLine();
        if(jwb.equals("Y") || jwb.equals("y")){
            System.out.print("Berapa jumlah Pulpen? ");
            jwb = sc.nextLine();
            n = Integer.parseInt(jwb);
            pulpenygdibeli = new Pulpen[n];
            for (int i=1;i<=Integer.parseInt(jwb);i++){
                System.out.print("Masukkan Kode Pulpen: ");
                String kode = sc.nextLine();
                System.out.print("Masukkan Nama Pulpen: ");
                String deskripsi = sc.nextLine();
                System.out.print("Masukkan Harga Pulpen: ");
                int harga = Integer.parseInt(sc.nextLine());
                System.out.print("Masukkan Berat Pulpen: ");
                int berat = Integer.parseInt(sc.nextLine());
                System.out.print("Masukkan Warna Pulpen: ");
                String warna = sc.nextLine();
                System.out.println();
                pulpenygdibeli[i-1] = new
                        Pulpen(kode,harga,berat,deskripsi,warna);
            }
        }
        System.out.println();
        System.out.print("Apakah akan membeli Kertas HVS? [Y/T] : ");
        jwb = sc.nextLine();
        if(jwb.equals("Y") || jwb.equals("y")){
            System.out.print("Berapa jumlah Kertas HVS? ");
            jwb = sc.nextLine();
            n = Integer.parseInt(jwb);
            kertasygdibeli = new KertasHVS[n];
            for (int i=1;i<=Integer.parseInt(jwb);i++){
                System.out.print("Masukkan Kode Kertas HVS: ");
                String kode = sc.nextLine();
                System.out.print("Masukkan Nama Kertas HVS: ");
                String deskripsi = sc.nextLine();
                System.out.print("Masukkan Harga Kertas HVS: ");
                int harga = Integer.parseInt(sc.nextLine());
                System.out.print("Masukkan Berat Kertas HVS: ");
                int berat = Integer.parseInt(sc.nextLine());
                System.out.print("Masukkan Berat Kertas HVS (gram): ");
                int gram = Integer.parseInt(sc.nextLine());
                System.out.println();
                kertasygdibeli[i-1] = new
                        KertasHVS(kode,harga,berat,deskripsi,gram);
            }
        }
        System.out.println();
        Item it = new Item(bukuygdibeli,kertasygdibeli,pulpenygdibeli);
        Nota nota1 = new Nota("N001","Antonius Rachmat", "0812111222",it);
        nota1.tampilNota();
        System.out.println("TOTAL BAYAR: "+nota1.hitungTotalBayar());
    }
}

