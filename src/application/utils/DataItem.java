/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.utils;

import java.util.Map;

/**
 *
 * @author mhdja
 */
public class DataItem {
    String label;
    Map<String, String> features;

    public DataItem(String label, Map<String, String> features) {
        this.label = label;
        this.features = features;
    }
    
    public String getLabel() {
        return label;
    }

    public Map<String, String> getFeatures() {
        return features;
    }
}
