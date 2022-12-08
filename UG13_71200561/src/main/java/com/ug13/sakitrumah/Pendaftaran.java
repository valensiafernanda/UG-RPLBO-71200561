package com.ug13.sakitrumah;

import java.util.Scanner;

public class Pendaftaran {
    private String nama;

    public Pendaftaran(String nama){
        this.nama = nama;
    }

    public void mengaturJadwal(Pengunjung pengunjung, Pemeriksa pemeriksa, Jadwal jadwal){
        if(pengunjung.getStatus().equals("False")){
            jadwal.sudahDaftar();
            System.out.println("=================Proses Pengaturan Pengaturan Jadwal Berhasil=================");
        }
    }

    public Pengunjung registrasi(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama anda: ");
        String nama = sc.next();
        System.out.print("Masukkan usia anda: ");
        int usia = sc.nextInt();
        System.out.print("Masukkan alamat anda: ");
        String alamat = sc.next();
        Pengunjung pengunjung = new Pengunjung(nama, usia, alamat);
        System.out.print("Masukkan penyakit anda: ");
        String penyakit = sc.next();
        pengunjung.setPenyakit(penyakit);
        System.out.println();
        System.out.println("==========Proses Registrasi Berhasil==========");
        return pengunjung;
    }
}
