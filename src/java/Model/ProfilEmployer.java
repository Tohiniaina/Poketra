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
import java.sql.Date;
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

@AnnotMap(nomTable = "profilemploye")
public class ProfilEmployer {
    @Attribut(attr = "idprofil")
    String idProfil;
    @Attribut(attr = "dateembauche")
    Date dateembauche;
    @Attribut(attr = "idpersonne")
    String idpersonne;

    public ProfilEmployer(String idProfil, Date dateembauche, String idpersonne) {
        this.idProfil = idProfil;
        this.dateembauche = dateembauche;
        this.idpersonne = idpersonne;
    }

    public ProfilEmployer() {
    }

    public String getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(String idProfil) {
        this.idProfil = idProfil;
    }

    public Date getDateembauche() {
        return dateembauche;
    }

    public void setDateembauche(Date dateembauche) {
        this.dateembauche = dateembauche;
    }

    public String getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(String idpersonne) {
        this.idpersonne = idpersonne;
    }
    
    public static List<ProfilEmployer> getAllProfilEmployer(Connection connection) throws Exception {
        List<Object> obj = new ArrayList<>();
        List<ProfilEmployer> allProfilEmployer = new ArrayList<>();
        
        String sql = "select * from profilemploye";
        System.out.println(sql);   

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idProfil = resultSet.getString("idprofil");
                Date dateembauche = resultSet.getDate("dateembauche");
                String idpersonne = resultSet.getString("idpersonne");
                
                allProfilEmployer.add(new ProfilEmployer(idProfil, dateembauche, idpersonne));
            }

            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            throw e;
        }
        
        return allProfilEmployer;
    }
    
    public void insert(Connect conn) throws Exception {
        try {
            GenericDAO.save(this, conn);
        } catch (Exception e) {
            throw e;
        } 
    }
}
