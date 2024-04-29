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
@AnnotMap(nomTable = "statistique")
public class StatistiqueVente {
    @Attribut(attr = "idmodel")
    String idModele;
    @Attribut(attr = "sexe")
    String sexe;
    @Attribut(attr = "nombre")
    double nombre;

    public StatistiqueVente(String idModele, String sexe, double nombre) {
        this.idModele = idModele;
        this.sexe = sexe;
        this.nombre = nombre;
    }

    public StatistiqueVente() {
    }

    public String getIdModele() {
        return idModele;
    }

    public void setIdModele(String idModele) {
        this.idModele = idModele;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public double getNombre() {
        return nombre;
    }

    public void setNombre(double nombre) {
        this.nombre = nombre;
    }
    public static List<StatistiqueVente> getAllStatistiqueVente(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<StatistiqueVente> allStatistiqueVente = new ArrayList<>();
        StatistiqueVente stat = new StatistiqueVente();
        try {
            obj = GenericDAO.selectAll(stat, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allStatistiqueVente.add((StatistiqueVente)o);
        }
        
        return allStatistiqueVente;
    }
    
    public static List<StatistiqueVente> getStatistiqueVente(Connection connection, String idmodel) throws Exception {
        List<Object> obj = new ArrayList<>();
        List<StatistiqueVente> allStatistiqueVente = new ArrayList<>();
        
        String sql = "select * from statistique where idmodel = '"+idmodel+"'";
        System.out.println(sql);   

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idmod = resultSet.getString("idmodel");
                String sexe = resultSet.getString("sexe");
                int nombre = Integer.parseInt(resultSet.getString("nombre"));
                
                allStatistiqueVente.add(new StatistiqueVente(idmod, sexe, nombre));
            }

            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            throw e;
        }
        
        return allStatistiqueVente;
    }
}
