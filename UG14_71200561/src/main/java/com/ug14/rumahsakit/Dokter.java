package com.ug14.rumahsakit;

public class Dokter {
    private int idDokter;
    private String nama;
    private String spesialis;
    private String ruangan;

    public Dokter(String nama, String spesialis, String ruangan){
        this.nama = nama;
        this.spesialis = spesialis;
        this.ruangan = ruangan;
    }

    public void memeriksa(Pasien pasien, Jadwal jadwal){
        if(jadwal.getStatusScreening() == false){
            System.out.println("=====================SAYA HARUS MELAKUKAN PROSES PENDAFTARAN TERLEBIH DAHULU DI BAGIAN PELAYANAN===========================");
        }else {
            pasien.descLevelPenyakit();
            if(pasien.getLevelPenyakit() == 0){
                pasien.sembuh();
                DAO dao = new DAO();
                dao.updateStatusPasien(pasien.getRm());
            }
        }
    }

    public void cekStatus(Pasien pasien, Jadwal jadwal){
        if(pasien.getStatus().equals("False")){
            System.out.println("============PASIEN ANDA MASIH SAKIT==========");
        }else {
            System.out.println("============PASIEN ANDA SUDAH SEMBUH DAN SEHAT============");
        }
    }

    private int idDokter(){
        return idDokter;
    }

    public String getNama() {
        return nama;
    }

    public int getIdDokter() {
        return idDokter;
    }
}
