package com.ug14.rumahsakit;
import java.sql.*;

public class DAO {
    public Dokter getDokterByID(int id) {
        String sql = "SELECT * FROM jadwal WHERE idDokter";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:rumahsakit.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            rs.getInt("idDokter");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return null;
        }
    }

    public Suster getSusterByID(int id) {
        String sql = "SELECT * FROM jadwal WHERE idSuster";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:rumahsakit.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            rs.getInt("idSuster");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return null;
        }
    }

    public Pelayan getPelayananByID(int id) {
        String sql = "SELECT * FROM jadwal WHERE idPelayanan";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:rumahsakit.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            rs.getInt("idPelayanan");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return null;
        }
    }

    public void inputPasien(Pasien pasien) {
        String sql = "INSERT INTO pasien values " + "('" + pasien.getRm() + "','" + pasien.getNama() + "'," + pasien.getUsia() + ",'" + pasien.getAlamat() + "');";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:rumahsakit.db");
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void inputJadwal(Jadwal jadwal) {
        String sql = "INSERT INTO jadwal values " + "('" + jadwal.getPasien().getRm() + "', " + jadwal.getDokter().getIdDokter() + ", " + jadwal.getSuster().getIdSuster() + ", " + jadwal.getPelayan().getIdPelayan() + ", 0);";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:rumahsakit.db");
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getPasienSembuh() {
        String sql = "SELECT * FROM jadwal WHERE status = 0;";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:rumahsakit.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("idPemeriksaan") + "\t" +
                        rs.getString("rm") + "\t" +
                        rs.getInt("idDokter") + "\t" +
                        rs.getInt("idSuster") + "\t" +
                        rs.getInt("idPelayanan") + "\t" +
                        rs.getInt("status"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateStatusPasien(int rm) {
        String sql = "UPDATE jadwal SET status = 1 WHERE rm = " + rm + ";";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:rumahsakit.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
