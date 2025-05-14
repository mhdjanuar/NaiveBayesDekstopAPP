/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package application.dao;

import application.models.KandidatModel;
import java.util.List;

/**
 *
 * @author mhdja
 */
public interface KandidatDao {
    public List<KandidatModel> findAll();
    public int create(KandidatModel kandidatData);
}
