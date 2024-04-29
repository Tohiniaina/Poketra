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

@AnnotMap (nomTable = "unite")
public class Unite {
    @Attribut(attr = "idunite", primary_key = true)
    String idUnite;
    @Attribut(attr = "libelle")
    String libelle;
    @Attribut(attr = "nomunite")
    String nomUnite;

    public Unite(String idUnite, String libelle, String nomUnite) {
        this.libelle = libelle;
        this.idUnite = idUnite;
        this.nomUnite = nomUnite;
    }

    public Unite(String libelle, String nomUnite) {
        this.libelle = libelle;
        this.nomUnite = nomUnite;
    }

    public Unite() {
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(String idUnite) {
        this.idUnite = idUnite;
    }

    public String getNomUnite() {
        return nomUnite;
    }

    public void setNomUnite(String nomUnite) {
        this.nomUnite = nomUnite;
    }
    
    public static List<Unite> getAllUnite(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<Unite> allUnite = new ArrayList<>();
        Unite unite = new Unite();
        try {
            obj = GenericDAO.selectAll(unite, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allUnite.add((Unite)o);
        }
        
        return allUnite;
    }
    
    public static Unite getUniteById(Connect c, String id) throws SQLException {
        List<Object> obj = new ArrayList<>();
        Unite ans = new Unite();
        ans.setIdUnite(id);
        try {
            obj = GenericDAO.getById(ans, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            ans = (Unite) o;
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
