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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import utils.Connect;

/**
 *
 * @author Tohy
 */

@AnnotMap(nomTable = "profilnonstandard")
public class ProfilNonStandard {
    @Attribut(attr = "idprofil")
    String idProfil;
    @Attribut(attr = "coefficient")
    double coefficient;

    public ProfilNonStandard(String idProfil, double coefficient) {
        this.idProfil = idProfil;
        this.coefficient = coefficient;
    }

    public ProfilNonStandard() {
    }

    public String getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(String idProfil) {
        this.idProfil = idProfil;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }
    
    public static List<ProfilNonStandard> getAllProfilNonStandard(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<ProfilNonStandard> allProfilStandard = new ArrayList<>();
        ProfilNonStandard profil = new ProfilNonStandard();
        try {
            obj = GenericDAO.selectAll(profil, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allProfilStandard.add((ProfilNonStandard)o);
        }
        
        return allProfilStandard;
    }
    
    public void insert(Connect conn) throws Exception {
        try {
            GenericDAO.save(this, conn);
        } catch (Exception e) {
            throw e;
        } 
    }

}
