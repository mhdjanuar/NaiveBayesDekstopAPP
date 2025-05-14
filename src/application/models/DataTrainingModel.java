/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.models;

/**
 *
 * @author mhdja
 */
public class DataTrainingModel {
    private int id;
    private String nama;
    private String kedisiplinan;
    private String penjualan;
    private String kepuasan;
    private String label;
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the kedisiplinan
     */
    public String getKedisiplinan() {
        return kedisiplinan;
    }

    /**
     * @param kedisiplinan the kedisiplinan to set
     */
    public void setKedisiplinan(String kedisiplinan) {
        this.kedisiplinan = kedisiplinan;
    }

    /**
     * @return the penjualan
     */
    public String getPenjualan() {
        return penjualan;
    }

    /**
     * @param penjualan the penjualan to set
     */
    public void setPenjualan(String penjualan) {
        this.penjualan = penjualan;
    }

    /**
     * @return the kepuasan
     */
    public String getKepuasan() {
        return kepuasan;
    }

    /**
     * @param kepuasan the kepuasan to set
     */
    public void setKepuasan(String kepuasan) {
        this.kepuasan = kepuasan;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }
}
