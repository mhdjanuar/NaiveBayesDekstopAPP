/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.daoimpl;

import application.dao.DataTraining;
import application.models.DataTrainingModel;
import application.utils.DataItem;
import application.utils.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mhdja
 */
public class DataTrainingDaoImpl implements DataTraining {
    private Connection dbConnection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    private String query;
    
    public DataTrainingDaoImpl() {
        dbConnection = DatabaseUtil.getInstance().getConnection();
    }

    @Override
    public List<DataItem> findAsDataItem() {
        List<DataItem> dataList = new ArrayList<>();

        try {
            query = "SELECT * FROM data_training";
            pstmt = dbConnection.prepareStatement(query);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                Map<String, String> fitur = new HashMap<>();
                fitur.put("Penjualan", resultSet.getString("kriteria1"));
                fitur.put("Absen", resultSet.getString("kriteria2"));
                fitur.put("Pelayanan", resultSet.getString("kriteria3"));
                fitur.put("Kedisiplinan", resultSet.getString("kriteria4"));
                fitur.put("Lama Kerja", resultSet.getString("kriteria5"));

                String label = resultSet.getString("label");

                dataList.add(new DataItem(label, fitur));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }

        return dataList;
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
    public List<DataTrainingModel> findAll() {
        List<DataTrainingModel> list = new ArrayList<>();

        try {
            query = "SELECT data_training.*, lady_yakult.nama AS nama_karyawan FROM data_training " +
                    "INNER JOIN lady_yakult ON lady_yakult.id = data_training.lady_yakult_id";
            pstmt = dbConnection.prepareStatement(query);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                DataTrainingModel model = new DataTrainingModel();
                model.setId(resultSet.getInt("id"));
                model.setNama(resultSet.getString("nama_karyawan")); // ini betul sekarang
                model.setKriteria1(resultSet.getString("kriteria1"));
                model.setKriteria2(resultSet.getString("kriteria2"));
                model.setKriteria3(resultSet.getString("kriteria3"));
                model.setKriteria4(resultSet.getString("kriteria4"));
                model.setKriteria5(resultSet.getString("kriteria5"));
                model.setLabel(resultSet.getString("label"));
                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }

        return list;
    }

    @Override
    public int create(DataTrainingModel model) {
        int generatedId = -1;

        try {
            query = "INSERT INTO data_training (lady_yakult_id, kriteria1, kriteria2, kriteria3, kriteria4, kriteria5, label) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, model.getLadyYakultId());
            pstmt.setString(2, model.getKriteria1());
            pstmt.setString(3, model.getKriteria2());
            pstmt.setString(4, model.getKriteria3());
            pstmt.setString(5, model.getKriteria4());
            pstmt.setString(6, model.getKriteria5());
            pstmt.setString(7, model.getLabel());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                resultSet = pstmt.getGeneratedKeys();
                if (resultSet.next()) {
                    generatedId = resultSet.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }

        return generatedId;
    }


    
}
