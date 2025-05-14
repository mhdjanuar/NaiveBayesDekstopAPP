/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package application.dao;

import application.models.DataTrainingModel;
import application.utils.DataItem;
import java.util.List;

/**
 *
 * @author mhdja
 */
public interface DataTraining {
     List<DataItem> findAsDataItem();
     List<DataTrainingModel> findAll();
}
