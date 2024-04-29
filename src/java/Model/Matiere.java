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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Connect;

/**
 *
 * @author Tohy
 */
@AnnotMap (nomTable = "matiere")
public class Matiere {
    @Attribut(attr = "idmatiere", primary_key = true)
    String idMatiere;
    @Attribut(attr = "nom")
    String nom;    
    @Attribut(attr = "idunite")
    String idUnite;

    public Matiere(String nom, String idUnite) {
        this.nom = nom;
        this.idUnite = idUnite;
    }

    public Matiere(String idMatiere, String nom, String idUnite) {
        this.idMatiere = idMatiere;
        this.nom = nom;
        this.idUnite = idUnite;
    }

    public Matiere() {
    }

    public String getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(String idUnite) {
        this.idUnite = idUnite;
    }

    public String getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(String idMatiere) {
        this.idMatiere = idMatiere;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public static List<Matiere> getAllMatiere(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<Matiere> allMatiere = new ArrayList<>();
        Matiere matiere = new Matiere();
        try {
            obj = GenericDAO.selectAll(matiere, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allMatiere.add((Matiere)o);
        }
        
        return allMatiere;
    }
    
    public static Matiere getMatiereById(Connect c, String id) throws SQLException {
        List<Object> obj = new ArrayList<>();
        Matiere ans = new Matiere();
        ans.setIdMatiere(id);
        try {
            obj = GenericDAO.getById(ans, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            ans = (Matiere) o;
        }
        
        return ans;
    }

/*    public static List<Matiere> getMatiereByIdLook(Connect c, String id) throws SQLException {
        List<Object> obj = new ArrayList<>();
        Matiere mat = new Matiere();
        List<Matiere> allMatiere = new ArrayList<>();
        ans.setIdModel(id);
        try {
            obj = GenericDAO.getById(ans, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            ans = (Formule) o;
        }
        
        return ans;
    }*/
    
    public void insert(Connection connection) throws Exception {
        
        String query = "INSERT INTO matiere(nom, idunite) VALUES('"+this.nom+"','"+this.idUnite+"')";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int row = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (Exception e) {
            throw e;
        } 
    }
}
