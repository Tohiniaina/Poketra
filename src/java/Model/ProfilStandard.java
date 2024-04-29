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

@AnnotMap(nomTable = "profilstandard")
public class ProfilStandard {
    @Attribut(attr = "idprofil")
    String idProfil;
    @Attribut(attr = "dateheure")
    Timestamp dateHeure;
    @Attribut(attr = "tauxhoraire")
    double tauxhoraire;

    public ProfilStandard(String idProfil, Timestamp dateHeure, double tauxhoraire) {
        this.idProfil = idProfil;
        this.dateHeure = dateHeure;
        this.tauxhoraire = tauxhoraire;
    }

    public ProfilStandard() {
    }

    public String getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(String idProfil) {
        this.idProfil = idProfil;
    }

    public Timestamp getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Timestamp dateHeure) {
        this.dateHeure = dateHeure;
    }

    public double getTauxhoraire() {
        return tauxhoraire;
    }

    public void setTauxhoraire(double tauxhoraire) {
        this.tauxhoraire = tauxhoraire;
    }
    
    public static List<ProfilStandard> getAllProfilStandard(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<ProfilStandard> allProfilStandard = new ArrayList<>();
        ProfilStandard profil = new ProfilStandard();
        try {
            obj = GenericDAO.selectAll(profil, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allProfilStandard.add((ProfilStandard)o);
        }
        
        return allProfilStandard;
    }
    
    public static ProfilStandard getCurrentProfilStandard(Connection connection) throws Exception {
        List<Object> obj = new ArrayList<>();
        ProfilStandard profil = new ProfilStandard();
        
        String sql = "select * from profilstandard order by dateheure desc limit 1";
        System.out.println(sql);   

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idProfil = resultSet.getString("idprofil");
                Timestamp dateheure = resultSet.getTimestamp("dateheure");
                double tauxhoraire = resultSet.getDouble("tauxhoraire");
                
                profil = new ProfilStandard(idProfil, dateheure, tauxhoraire);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            throw e;
        }
        
        return profil;
    }
    
    public void insert(Connect conn) throws Exception {
        try {
            GenericDAO.save(this, conn);
        } catch (Exception e) {
            throw e;
        } 
    }
}
