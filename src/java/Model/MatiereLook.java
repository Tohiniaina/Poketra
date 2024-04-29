/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tohy
 */
public class MatiereLook {
    int idML;
    String idLook;
    String idMatiere;

    public MatiereLook(int id, String idLook, String idMatiere) {
        this.idML = id;
        this.idLook = idLook;
        this.idMatiere = idMatiere;
    }

    public MatiereLook(String idLook, String idMatiere) {
        this.idLook = idLook;
        this.idMatiere = idMatiere;
    }

    public MatiereLook() {
    }

    public int getIdML() {
        return idML;
    }

    public void setIdML(int id) {
        this.idML = id;
    }

    public String getIdLook() {
        return idLook;
    }

    public void setIdLook(String idLook) {
        this.idLook = idLook;
    }

    public String getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(String idMatiere) {
        this.idMatiere = idMatiere;
    }
    
    
    public static int getSequence(Connection connection) throws SQLException {
        String query = "SELECT idml FROM matierelook order by idml desc limit 1";
        System.out.println(query);

        // Préparation et exécution de la requête
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        int sequenceValue = 0;
        while (resultSet.next()) {
            sequenceValue = resultSet.getInt(1);
            System.out.println("id : "+resultSet.getString(1));
        }
        
        return sequenceValue;
    }
    
    public void insert(Connection connection) throws Exception {
        
        String query = "INSERT INTO matierelook(idlook, idmatiere) VALUES('"+this.idLook+"','"+this.idMatiere+"')";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int row = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (Exception e) {
            throw e;
        } 
    }
}
