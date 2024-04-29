/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import back.dao.GenericDAO;
import back.frame.AnnotMap;
import back.frame.Attribut;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Connect;

/**
 *
 * @author Tohy
 */
@AnnotMap(nomTable = "taille")
public class Taille {
    @Attribut(attr = "idtaille", primary_key = true)
    String idTaille;
    @Attribut(attr = "nom")
    String nom;

    public Taille() {
    }

    public Taille(String nom) {
        this.nom = nom;
    }

    public Taille(String idTaille, String nom) {
        this.idTaille = idTaille;
        this.nom = nom;
    }

    public String getIdTaille() {
        return idTaille;
    }

    public void setIdTaille(String idTaille) {
        this.idTaille = idTaille;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public static List<Taille> getAllTaille(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<Taille> allTaille = new ArrayList<>();
        Taille taille = new Taille();
        try {
            obj = GenericDAO.selectAll(taille, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allTaille.add((Taille)o);
        }
        
        return allTaille;
    }
    
    public static Taille getTailleById(Connect c, String id) throws SQLException {
        List<Object> obj = new ArrayList<>();
        Taille ans = new Taille();
        ans.setIdTaille(id);
        try {
            obj = GenericDAO.getById(ans, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            ans = (Taille) o;
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
