package com.ug13.sakitrumah;

public class App {
    public static void main(String[] args) {
        System.out.println("===========================================PROSES INISIALISASI============================================");
        System.out.println();
        Jadwal jadwal = new Jadwal();
        Pengunjung illegal = new Pengunjung("test",21,"di mana saja");
        Pendaftaran pendaftaran = new Pendaftaran("Andi");
        Perawat perawat = new Perawat("Siti");
        Pemeriksa pemeriksa = new Pemeriksa("Budi", "Organ Dalam", "A123");
        Pengunjung pengunjung = pendaftaran.registrasi();
        pendaftaran.mengaturJadwal(pengunjung, pemeriksa, jadwal);
        System.out.println("===========================================PROSES UJI COBA PASIEN DAN JADWAL ILLEGAL============================================");
        System.out.println();
        perawat.screening(illegal, jadwal);
        pemeriksa.memeriksa(illegal, jadwal);
        System.out.println("===========================================PROSES UJI COBA PASIEN DAN JADWAL ILLEGAL BERHASIL============================================");
        System.out.println();
        System.out.println("===========================================PROSES SCREENING SUSTER============================================");
        System.out.println();
        perawat.screening(pengunjung, jadwal);
        System.out.println("===========================================PROSES SCREENING SUTER BERHASIL============================================");
        System.out.println();
        System.out.println("===========================================PROSES PEMERIKSAAN DOKTER============================================");
        System.out.println();
        int x = pengunjung.getLevelPenyakit();
        for(int i = 0; i <= x; i++) {
            pemeriksa.memeriksa(pengunjung, jadwal);
            pemeriksa.cekStatus(pengunjung);
        }
        System.out.println("===========================================PROSES PEMERIKSAAN DOKTER BERHASIL============================================");
        System.out.println();
        System.out.println(jadwal.getPengunjung().getStatus());
        System.out.println(jadwal.getPengunjung().getLevelPenyakit());
    }
}
