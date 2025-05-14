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
                fitur.put("Kedisiplinan", resultSet.getString("kedisiplinan"));
                fitur.put("Penjualan", resultSet.getString("penjualan"));
                fitur.put("Kepuasan", resultSet.getString("kepuasan"));

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
                model.setKedisiplinan(resultSet.getString("kedisiplinan"));
                model.setPenjualan(resultSet.getString("penjualan"));
                model.setKepuasan(resultSet.getString("kepuasan"));
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

    
}
