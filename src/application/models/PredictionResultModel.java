/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.models;

/**
 *
 * @author mhdja
 */
public class PredictionResultModel {
    private final String label;
    private final String explanation;
    
    public PredictionResultModel(String label, String explanation) {
        this.label = label;
        this.explanation = explanation;
    }
    
    public String getLabel() {
        return label;
    }

    public String getExplanation() {
        return explanation;
    }
}
