/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.daoimpl;

import application.dao.KaryawanDao;
import application.models.KaryawanModel;
import application.utils.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mhdja
 */
public class KaryawanDaoImpl implements KaryawanDao {
    
    private Connection dbConnection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    private String query;
    
    public KaryawanDaoImpl() {
        dbConnection = DatabaseUtil.getInstance().getConnection();
    }

    @Override
    public List<KaryawanModel> findAll() {
        List<KaryawanModel> listDataAll = new ArrayList<>();

        try {
            query = "SELECT * FROM lady_yakult";
            pstmt = dbConnection.prepareStatement(query);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                KaryawanModel listData = new KaryawanModel();
                listData.setId(resultSet.getInt("id"));
                listData.setName(resultSet.getString("nama"));
                listData.setUsia(resultSet.getInt("umur"));
                listData.setKontak(resultSet.getString("telepon"));
                listData.setEmail(resultSet.getString("email"));
                listData.setAlamat(resultSet.getString("alamat"));

                listDataAll.add(listData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeStatement();
        }

        return listDataAll;
    }


    @Override
    public int create(KaryawanModel karyawan) {
        try {
            query = "INSERT INTO lady_yakult(nama, umur, alamat, telepon, email) VALUES (?, ?, ?, ?, ?)";
            pstmt = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, karyawan.getName());
            pstmt.setInt(2, karyawan.getUsia());
            pstmt.setString(3, karyawan.getAlamat());
            pstmt.setString(4, karyawan.getKontak());
            pstmt.setString(5, karyawan.getEmail());

            // Log sebelum insert
            System.out.println("=== Menyimpan Data Karyawan ===");
            System.out.println("Nama: " + karyawan.getName());
            System.out.println("Usia: " + karyawan.getUsia());
            System.out.println("Kontak: " + karyawan.getKontak());
            System.out.println("Email: " + karyawan.getEmail());
            System.out.println("Gender: " + karyawan.getGender());
            System.out.println("Alamat: " + karyawan.getAlamat());

            int result = pstmt.executeUpdate();
            resultSet = pstmt.getGeneratedKeys();
            if (resultSet.next()) {
                int insertedId = resultSet.getInt(1);
                System.out.println("Data karyawan berhasil disimpan. ID: " + insertedId);
                return insertedId;
            }

            System.out.println("Data karyawan disimpan tanpa ID yang dihasilkan.");
            return result;
        } catch (SQLException e) {
            System.out.println("Gagal menyimpan data karyawan: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            closeStatement();
        }
    }

    
    private void closeStatement() {
        try {
            if(pstmt != null){
                pstmt.close();
                pstmt = null;
            }
            if(resultSet != null){
                resultSet.close();
                resultSet = null;
            }   
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(KaryawanModel karyawan) {
        int result = 0;
        try {
            // Query untuk mengupdate data karyawan
            query = "UPDATE lady_yakult SET nama = ?, umur = ?, telepon = ?, email = ?, alamat = ? WHERE id = ?";

            pstmt = dbConnection.prepareStatement(query);
            pstmt.setString(1, karyawan.getName());  // Nama karyawan
            pstmt.setInt(2, karyawan.getUsia());  // Usia karyawan
            pstmt.setString(3, karyawan.getKontak());  // Kontak karyawan
            pstmt.setString(4, karyawan.getEmail());  // Email karyawan
            pstmt.setString(5, karyawan.getAlamat());  // Alamat karyawan
            pstmt.setInt(6, karyawan.getId());  // ID karyawan yang akan diupdate

            result = pstmt.executeUpdate();  // Eksekusi query update
        } catch (SQLException e) {
            // Jika ada error, lempar exception
            e.printStackTrace();
        } finally {
            closeStatement();  // Pastikan koneksi ditutup
        }

        return result;  // Kembalikan jumlah baris yang terupdate
    }

    @Override
    public int deleteKaryawan(int id) {
        int result = 0;
        try {
            query = "DELETE FROM lady_yakult WHERE id = ?";
            pstmt = dbConnection.prepareStatement(query);
            pstmt.setInt(1, id);

            result = pstmt.executeUpdate(); // eksekusi dan simpan jumlah baris yang terhapus
        } catch (SQLException e) {
            e.printStackTrace(); // log error
        } finally {
            closeStatement(); // tutup statement
        }

        return result; // return jumlah baris yang terhapus
    }
    
}
