/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import back.dao.GenericDAO;
import back.frame.AnnotMap;
import back.frame.Attribut;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Connect;

/**
 *
 * @author Tohy
 */
@AnnotMap (nomTable = "formule")
public class Formule {
    @Attribut(attr = "idmodel")
    String idModel;
    @Attribut(attr = "idmatiere")
    String idMatiere;
    @Attribut(attr = "quantite")
    double quantite;
    double quantiteBesoin;

    public Formule(String idModel, String idMatiere, double quantite, double quantiteBesoin) {
        this.idModel = idModel;
        this.idMatiere = idMatiere;
        this.quantite = quantite;
        this.quantiteBesoin = quantiteBesoin;
    }

    public Formule() {
    }

    public Formule(String idModel, String idMatiere, double quantite) {
        this.idModel = idModel;
        this.idMatiere = idMatiere;
        this.quantite = quantite;
    }

    public String getIdModel() {
        return idModel;
    }

    public void setIdModel(String idModel) {
        this.idModel = idModel;
    }

    public String getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(String idMatiere) {
        this.idMatiere = idMatiere;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getQuantiteBesoin() {
        return quantiteBesoin;
    }

    public void setQuantiteBesoin(double quantiteBesoin) {
        this.quantiteBesoin = quantiteBesoin;
    }   
    
    public static List<Formule> getAllFormule(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<Formule> allFormule = new ArrayList<>();
        Formule formule = new Formule();
        try {
            obj = GenericDAO.selectAll(formule, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allFormule.add((Formule)o);
        }
        
        return allFormule;
    }
    
    public static List<Formule> getFormuleByIdModel(Connection connection, String id) throws Exception {
        List<Object> obj = new ArrayList<>();
        List<Formule> ans = new ArrayList<>();
        Formule form = new Formule();
        String sql = "SELECT * FROM formule WHERE idmodel = '"+id+"'";
        System.out.println(sql);   

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idmodel = resultSet.getString("idmodel");
                String idmatiere = resultSet.getString("idmatiere");
                double quantite = resultSet.getDouble("quantite");
                
                Formule f = new Formule(idmodel, idmatiere, quantite);
                ans.add(f);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            throw e;
        } 
        return ans;
    }
    
    public static List<Formule> getFormuleBesoinModel(Connection connection, String id, double nbr) throws Exception {
        List<Object> obj = new ArrayList<>();
        List<Formule> ans = new ArrayList<>();
        Formule form = new Formule();
        String sql = "SELECT *, (quantite*"+nbr+") quantitebesoin FROM formule WHERE idmodel = '"+id+"'";
        System.out.println(sql);   

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idmodel = resultSet.getString("idmodel");
                String idmatiere = resultSet.getString("idmatiere");
                double quantite = resultSet.getDouble("quantite");
                double quantitebesoin = resultSet.getDouble("quantitebesoin");
                
                Formule f = new Formule(idmodel, idmatiere, quantite, quantitebesoin);
                ans.add(f);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            throw e;
        } 
        return ans;
    }
    
    public void insert(Connect conn) throws Exception {
        try {
            GenericDAO.save(this, conn);
        } catch (Exception e) {
            throw e;
        } 
    }
}
