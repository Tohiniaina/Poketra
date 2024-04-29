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

@AnnotMap(nomTable = "v_profil")
public class V_profil {
    @Attribut(attr = "nom")
    String nom;
    @Attribut(attr = "idprofil")
    String idprofil;
    @Attribut(attr = "profil")
    String profil;
    @Attribut(attr = "taux")
    double taux;  

    public V_profil(String nom, String idprofil, String profil, double taux) {
        this.nom = nom;
        this.idprofil = idprofil;
        this.profil = profil;
        this.taux = taux;
    }

    public V_profil() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdprofil() {
        return idprofil;
    }

    public void setIdprofil(String idprofil) {
        this.idprofil = idprofil;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
    
    public static List<V_profil> getAllV_profil(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<V_profil> allProfil = new ArrayList<>();
        V_profil profil = new V_profil();
        try {
            obj = GenericDAO.selectAll(profil, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allProfil.add((V_profil)o);
        }
        
        return allProfil;
    }
    
    public void insert(Connect conn) throws Exception {
        try {
            GenericDAO.save(this, conn);
        } catch (Exception e) {
            throw e;
        } 
    }
}
