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
@AnnotMap(nomTable = "type")
public class Type {
    @Attribut(attr = "idtype", primary_key = true)
    String idType;
    @Attribut(attr = "nom")
    String nom;

    public Type(String nom) {
        this.nom = nom;
    }    
    
    public Type(String idType, String nom) {
        this.idType = idType;
        this.nom = nom;
    }

    public Type() {
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
  
    public static List<Type> getAllType(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<Type> allType = new ArrayList<>();
        Type type = new Type();
        try {
            obj = GenericDAO.selectAll(type, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allType.add((Type)o);
        }
        
        return allType;
    }
    
    public static Type getTypeById(Connect c, String id) throws SQLException {
        List<Object> obj = new ArrayList<>();
        Type ans = new Type();
        ans.setIdType(id);
        try {
            obj = GenericDAO.getById(ans, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            ans = (Type) o;
        }
        
        return ans;
    }
    
    public void insert(Connection connection) throws Exception {
        
        String query = "INSERT INTO type(nom) VALUES('"+this.nom+"')";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int row = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (Exception e) {
            throw e;
        } 
    }

}
