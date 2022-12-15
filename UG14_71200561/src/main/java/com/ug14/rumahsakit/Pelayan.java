package com.ug14.rumahsakit;

import java.sql.*;
import java.util.Scanner;

public class Pelayan {
    private int idPelayanan;
    private String nama;

    public void setIdPelayanan(int idPelayanan) {
        this.idPelayanan = idPelayanan;
    }

    public Pelayan(String nama){
        this.nama = nama;
    }

    public void mengaturJadwal(Pasien pasien, Dokter dokter, Jadwal jadwal){
        if(pasien.getStatus().equals("False")){
            jadwal.sudahDaftar();
            System.out.println("==================Proses Pengaturan Jadwal Berhasil=============");
        }
    }
    
    public Pasien registrasi(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan rm baru: ");
        String rm = sc.next();
        System.out.print("Masukkan nama anda: ");
        String nama = sc.next();
        System.out.print("Masukkan usia anda: ");
        int usia = sc.nextInt();
        System.out.print("Masukkan alamat anda: ");
        String alamat = sc.next();
        Pasien pasien = new Pasien(nama, usia, alamat);
        System.out.print("Masukkan penyakit anda: ");
        String penyakit = sc.next();
        pasien.setPenyakit(penyakit);
        System.out.println();
        System.out.println("==========Proses Registrasi Berhasil==========");
        createNewDatabase();
        createNewTable();
        DAO dao = new DAO();
        Jadwal jadwal = new Jadwal();
        dao.inputPasien(pasien);
        dao.inputJadwal(jadwal);
        sc.close();
        return pasien;
    }

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:rumahsakit.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }

    public void createNewDatabase() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:rumahsakit.db")) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createNewTable() {
        String pasien = "CREATE TABLE IF NOT EXISTS pasien (\n" + " rm varchar(5) NOT NULL PRIMARY KEY,\n" + " nama varchar(255) NOT NULL,\n" + " usia int NOT NULL,\n" + " alamat varchar(255) NOT NULL\n" + ");";
        String jadwal = "CREATE TABLE IF NOT EXISTS jadwal (\n" + " idPemeriksaan int NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" + " rm int NOT NULL,\n" + " idDokter int NOT NULL,\n" + " idSuster int NOT NULL,\n" + " idPelayanan int NOT NULL,\n" + " status int NOT NULL\n" + ");";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:rumahsakit.db");
             Statement stmt = conn.createStatement()) {
            stmt.execute(pasien);
            stmt.execute(jadwal);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getIdPelayan() {
        return idPelayanan;
    }
}
