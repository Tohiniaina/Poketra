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
@AnnotMap (nomTable = "look")
public class Look {
    @Attribut(attr = "idlook", primary_key = true)
    String idLook;
    @Attribut(attr = "nomlook")
    String nomLook;

    public Look(String nomLook) {
        this.nomLook = nomLook;
    }
    public Look(String idLook, String nomLook) {
        this.idLook = idLook;
        this.nomLook = nomLook;
    }

    public Look() {
    }

    public String getIdLook() {
        return idLook;
    }

    public void setIdLook(String idLook) {
        this.idLook = idLook;
    }

    public String getNomLook() {
        return nomLook;
    }

    public void setNomLook(String nomLook) {
        this.nomLook = nomLook;
    }
    
    public static List<Look> getAllLook(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<Look> allLook = new ArrayList<>();
        Look look = new Look();
        try {
            obj = GenericDAO.selectAll(look, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allLook.add((Look)o);
        }
        
        return allLook;
    }
    
    public static Look getLookById(Connect c, String id) throws SQLException {
        List<Object> obj = new ArrayList<>();
        Look ans = new Look();
        ans.setIdLook(id);
        try {
            obj = GenericDAO.getById(ans, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            ans = (Look) o;
        }
        
        return ans;
    }
    
    public void insert(Connection connection) throws Exception {
        
        String query = "INSERT INTO look(nomLook) VALUES('"+this.nomLook+"')";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int row = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (Exception e) {
            throw e;
        } 
    }
    
}
