/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.daoimpl;

import application.dao.KandidatDao;
import application.models.KandidatModel;
import application.utils.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mhdja
 */
public class KandidatDaoImpl implements KandidatDao {
    
    private Connection dbConnection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    private String query;
    
    public KandidatDaoImpl() {
        dbConnection = DatabaseUtil.getInstance().getConnection();
    }

    @Override
    public List<KandidatModel> findAll() {
        List<KandidatModel> listDataAll = new ArrayList<>();

        try {
            query = "SELECT k.*, ka.nama AS name_karyawan, " +
                    "(k.productivity + k.quality + k.tanggung_jawab + k.improvement + k.absensi + k.psikotes) AS total_skor, " +
                    "CASE " +
                    "WHEN (k.productivity + k.quality + k.tanggung_jawab + k.improvement + k.absensi + k.psikotes) >= 16 THEN 'Sangat Baik' " +
                    "WHEN (k.productivity + k.quality + k.tanggung_jawab + k.improvement + k.absensi + k.psikotes) >= 12 THEN 'Cukup Baik' " +
                    "ELSE 'Kurang Baik' " +
                    "END AS hasil_dinamis " +
                    "FROM kandidat k " +
                    "INNER JOIN karyawan ka ON k.id_karyawan = ka.id_karyawan";

            pstmt = dbConnection.prepareStatement(query);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                KandidatModel kandidat = new KandidatModel();
                kandidat.setId(resultSet.getInt("id"));
                kandidat.setNameKaryawan(resultSet.getString("name_karyawan"));
                kandidat.setProductivity(convertToLabel(resultSet.getInt("productivity")));
                kandidat.setQuality(convertToLabel(resultSet.getInt("quality")));
                kandidat.setTanggungJawab(convertToLabel(resultSet.getInt("tanggung_jawab")));
                kandidat.setImprovment(convertToLabel(resultSet.getInt("improvement"))); // kolom improvement
                kandidat.setAbsensi(convertToLabel(resultSet.getInt("absensi")));
                kandidat.setPsikotes(convertToLabel(resultSet.getInt("psikotes")));
                kandidat.setHasil(resultSet.getString("hasil_dinamis"));

                listDataAll.add(kandidat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeStatement();
        }

        return listDataAll;
    }




    private String convertToLabel(int value) {
        switch (value) {
            case 3:
                return "Sangat Baik";
            case 2:
                return "Cukup Baik";
            case 1:
                return "Kurang Baik";
            default:
                return "Tidak Diketahui";
        }
    }

    private void closeStatement() {
        try {
            if (resultSet != null) resultSet.close();
            if (pstmt != null) pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int create(KandidatModel kandidat) {
        try {
            query = "INSERT INTO kandidat(id_karyawan, productivity, quality, tanggung_jawab, " +
                    "improvement, absensi, psikotes) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)";

            pstmt = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, kandidat.getIdkaryawan());

            // Konversi label ke angka
            int productivity = convertToInt(kandidat.getProductivity());
            int quality = convertToInt(kandidat.getQuality());
            int tanggungJawab = convertToInt(kandidat.getTanggungJawab());
            int improvement = convertToInt(kandidat.getImprovment());
            int absensi = convertToInt(kandidat.getAbsensi());
            int psikotes = convertToInt(kandidat.getPsikotes());

            pstmt.setInt(2, productivity);
            pstmt.setInt(3, quality);
            pstmt.setInt(4, tanggungJawab);
            pstmt.setInt(5, improvement);
            pstmt.setInt(6, absensi);
            pstmt.setInt(7, psikotes);

            // Log nilai sebelum disimpan
            System.out.println("=== Menyimpan Data Kandidat ===");
            System.out.println("ID Karyawan: " + kandidat.getIdkaryawan());
            System.out.println("Productivity: " + kandidat.getProductivity() + " -> " + productivity);
            System.out.println("Quality: " + kandidat.getQuality() + " -> " + quality);
            System.out.println("Tanggung Jawab: " + kandidat.getTanggungJawab() + " -> " + tanggungJawab);
            System.out.println("Improvement: " + kandidat.getImprovment() + " -> " + improvement);
            System.out.println("Absensi: " + kandidat.getAbsensi() + " -> " + absensi);
            System.out.println("Psikotes: " + kandidat.getPsikotes() + " -> " + psikotes);

            int result = pstmt.executeUpdate();
            resultSet = pstmt.getGeneratedKeys();

            if (resultSet.next()) {
                int insertedId = resultSet.getInt(1);
                System.out.println("Data berhasil disimpan. ID: " + insertedId);
                return insertedId;
            }

            System.out.println("Data disimpan tanpa ID yang dihasilkan.");
            return result;
        } catch (SQLException e) {
            System.out.println("Gagal menyimpan data kandidat: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            closeStatement();
        }
    }

    
    private int convertToInt(String label) {
        switch (label) {
            case "Sangat Baik":
                return 3;
            case "Cukup Baik":
                return 2;
            case "Kurang Baik":
                return 1;
            default:
                return 0;  // Atau nilai default lainnya jika label tidak ditemukan
        }
    }


    
}
