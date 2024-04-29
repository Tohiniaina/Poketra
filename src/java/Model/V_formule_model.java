/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tohy
 */
public class V_formule_model {
    private String idmodel;
    private String idtype;
    private String nomtype;
    private String idlook;
    private String nomlook;
    private String idtaille;
    private String nomtaille;
    private String idmatiere;
    private String nommatiere;
    private double quantite;
    private String idunite;
    private String libelle;
    private String nomunite;

    public V_formule_model() {
    }

    public V_formule_model(String idmodel, String idtype, String nomtype, String idlook, String nomlook, String idtaille, String nomtaille, String idmatiere, String nommatiere, double quantite, String idunite, String libelle, String nomunite) {
        this.idmodel = idmodel;
        this.idtype = idtype;
        this.nomtype = nomtype;
        this.idlook = idlook;
        this.nomlook = nomlook;
        this.idtaille = idtaille;
        this.nomtaille = nomtaille;
        this.idmatiere = idmatiere;
        this.nommatiere = nommatiere;
        this.quantite = quantite;
        this.idunite = idunite;
        this.libelle = libelle;
        this.nomunite = nomunite;
    }

    public String getIdmodel() {
        return this.idmodel;
    }

    public void setIdmodel(String idmodel) {
        this.idmodel = idmodel;
    }

    public String getIdtype() {
        return this.idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getNomtype() {
        return this.nomtype;
    }

    public void setNomtype(String nomtype) {
        this.nomtype = nomtype;
    }

    public String getIdlook() {
        return this.idlook;
    }

    public void setIdlook(String idlook) {
        this.idlook = idlook;
    }

    public String getNomlook() {
        return this.nomlook;
    }

    public void setNomlook(String nomlook) {
        this.nomlook = nomlook;
    }

    public String getIdtaille() {
        return this.idtaille;
    }

    public void setIdtaille(String idtaille) {
        this.idtaille = idtaille;
    }

    public String getNomtaille() {
        return this.nomtaille;
    }

    public void setNomtaille(String nomtaille) {
        this.nomtaille = nomtaille;
    }

    public String getIdmatiere() {
        return this.idmatiere;
    }

    public void setIdmatiere(String idmatiere) {
        this.idmatiere = idmatiere;
    }

    public String getNommatiere() {
        return this.nommatiere;
    }

    public void setNommatiere(String nommatiere) {
        this.nommatiere = nommatiere;
    }

    public double getQuantite() {
        return this.quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public String getIdunite() {
        return this.idunite;
    }

    public void setIdunite(String idunite) {
        this.idunite = idunite;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNomunite() {
        return this.nomunite;
    }

    public void setNomunite(String nomunite) {
        this.nomunite = nomunite;
    }
    
    public static List<V_formule_model> getFormuleByIdModel(Connection connection, String id) throws Exception {
        List<Object> obj = new ArrayList<>();
        List<V_formule_model> ans = new ArrayList<>();
        V_formule_model form = new V_formule_model();
        String sql = "SELECT * FROM v_formule_model WHERE idmodel = '"+id+"'";
        System.out.println(sql);   

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idmodel = resultSet.getString("idmodel");
                String idtype = resultSet.getString("idtype");
                String nomtype = resultSet.getString("nomtype");
                String idlook = resultSet.getString("idlook");
                String nomlook = resultSet.getString("nomlook");
                String idtaille = resultSet.getString("idtaille");
                String nomtaille = resultSet.getString("nomtaille");
                String idmatiere = resultSet.getString("idmatiere");
                String nommatiere = resultSet.getString("nommatiere");
                double quantite = resultSet.getDouble("quantite");
                String idunite = resultSet.getString("idunite");
                String libelle = resultSet.getString("libelle");
                String nomunite = resultSet.getString("nomunite");
                
                V_formule_model f = new V_formule_model(idmodel, idtype, nomtype, idlook, nomlook, idtaille, nomtaille, idmatiere, nommatiere, quantite, idunite, libelle, nomunite);
                ans.add(f);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            throw e;
        } 
        return ans;
    }
    
    public static List<V_formule_model> getFormuleByIdMatiere(Connection connection, String id) throws Exception {
        List<Object> obj = new ArrayList<>();
        List<V_formule_model> ans = new ArrayList<>();
        V_formule_model form = new V_formule_model();
        String sql = "SELECT * FROM v_formule_model WHERE idmatiere = '"+id+"'";
        System.out.println(sql);   

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idmodel = resultSet.getString("idmodel");
                String idtype = resultSet.getString("idtype");
                String nomtype = resultSet.getString("nomtype");
                String idlook = resultSet.getString("idlook");
                String nomlook = resultSet.getString("nomlook");
                String idtaille = resultSet.getString("idtaille");
                String nomtaille = resultSet.getString("nomtaille");
                String idmatiere = resultSet.getString("idmatiere");
                String nommatiere = resultSet.getString("nommatiere");
                double quantite = resultSet.getDouble("quantite");
                String idunite = resultSet.getString("idunite");
                String libelle = resultSet.getString("libelle");
                String nomunite = resultSet.getString("nomunite");
                
                V_formule_model f = new V_formule_model(idmodel, idtype, nomtype, idlook, nomlook, idtaille, nomtaille, idmatiere, nommatiere, quantite, idunite, libelle, nomunite);
                ans.add(f);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            throw e;
        } 
        return ans;
    }
}
