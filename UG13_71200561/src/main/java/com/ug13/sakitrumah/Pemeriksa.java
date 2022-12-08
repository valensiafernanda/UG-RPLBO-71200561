package com.ug13.sakitrumah;

public class Pemeriksa {
    private String nama;
    private String spesialis;
    private String ruangan;

    public Pemeriksa(String nama, String spesialis, String ruangan){
        this.nama = nama;
        this.spesialis = spesialis;
        this.ruangan = ruangan;
    }

    public void memeriksa(Pengunjung pengunjung, Jadwal jadwal){
        if(jadwal.getStatusScreening() == false){
            System.out.println("===============ANDA HARUS MELAKUKAN PROSES PEMBAYARAN TERLEBIH DAHULU DIBAGIAN PELAYANAN===============");
        }else{

            if(pengunjung.getLevelPenyakit()==0){
                pengunjung.sembuh();
            }
        }
    }

    public void cekStatus(Pengunjung pengunjung){
        if(pengunjung.getStatus().equals("False")){
            System.out.println("==========PASIEN ANDA MASIH SAKIT==========");
        }else{
                System.out.println("==========SELAMAT PASIEN ANDA SUDAH SEMBUH DAN SEHAT==========");
        }
    }


}
