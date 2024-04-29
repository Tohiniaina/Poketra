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

@AnnotMap(nomTable = "caracteristiqueprofil")
public class CaracteristiqueProfil {
    @Attribut(attr = "idprofil")
    String idProfil;
    @Attribut(attr = "annee1")
    int annee1;
    @Attribut(attr = "annee2")
    int annee2;

    public CaracteristiqueProfil(String idProfil, int annee1, int annee2) {
        this.idProfil = idProfil;
        this.annee1 = annee1;
        this.annee2 = annee2;
    }

    public CaracteristiqueProfil() {
    }

    public String getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(String idProfil) {
        this.idProfil = idProfil;
    }

    public int getAnnee1() {
        return annee1;
    }

    public void setAnnee1(int annee1) {
        this.annee1 = annee1;
    }

    public int getAnnee2() {
        return annee2;
    }

    public void setAnnee2(int annee2) {
        this.annee2 = annee2;
    }
    
    public static List<CaracteristiqueProfil> getAllCaracteristiqueProfil(Connection connection) throws Exception {
        List<Object> obj = new ArrayList<>();
        List<CaracteristiqueProfil> carac = new ArrayList<>();
        
        String sql = "select * from caracteristiqueprofil";
        System.out.println(sql);   

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idProf = resultSet.getString("idprofil");
                int annee1 = resultSet.getInt("annee1");
                int annee2 = resultSet.getInt("annee2");
                
                carac.add(new CaracteristiqueProfil(idProf, annee1, annee2));
            }

            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            throw e;
        }
        
        return carac;
    }
    
    public static CaracteristiqueProfil getCaracteristiqueProfil(Connection connection, String idProfil) throws Exception {
        List<Object> obj = new ArrayList<>();
        CaracteristiqueProfil carac = new CaracteristiqueProfil();
        
        String sql = "select * from caracteristiqueprofil where idprofil = '"+idProfil+"'";
        System.out.println(sql);   

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idProf = resultSet.getString("idprofil");
                int annee1 = resultSet.getInt("annee1");
                int annee2 = resultSet.getInt("annee2");
                
                carac = new CaracteristiqueProfil(idProf, annee1, annee2);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            throw e;
        }
        
        return carac;
    }
    
    public void insert(Connect conn) throws Exception {
        try {
            GenericDAO.save(this, conn);
        } catch (Exception e) {
            throw e;
        } 
    }
}
