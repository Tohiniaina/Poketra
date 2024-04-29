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

@AnnotMap(nomTable = "metierpersonnelmodele")
public class MetierPersonnelModele {
    @Attribut(attr = "idModele")
    private String idmodele;
    @Attribut(attr = "idpersonnel")
    private String idPersonnel;
    @Attribut(attr = "nbr")
    private int nbr;

    public MetierPersonnelModele() {
    }

    public MetierPersonnelModele(String idmodele, String idPersonnel, int nbr) {
        this.idmodele = idmodele;
        this.idPersonnel = idPersonnel;
        this.nbr = nbr;
    }

    public String getIdmodele() {
        return idmodele;
    }

    public void setIdmodele(String idmodele) {
        this.idmodele = idmodele;
    }

    public String getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(String idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }
    
    public static int getNbrMetier(Connection connection, String idmode) throws Exception {
        int ans = 0;
        String query = "select sum(nbr) as nbr from MetierPersonnelModele where idmodele = '"+idmode+"' group by idmodele";
        System.out.println(query);

        // Préparation et exécution de la requête
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
            ans = resultSet.getInt(1);
        }
        
        return ans;
    }
    
    public static List<MetierPersonnelModele> getAllMetierPersonnelModele(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<MetierPersonnelModele> allMetierPersonnelModele = new ArrayList<>();
        MetierPersonnelModele personnel = new MetierPersonnelModele();
        try {
            obj = GenericDAO.selectAll(personnel, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allMetierPersonnelModele.add((MetierPersonnelModele)o);
        }
        
        return allMetierPersonnelModele;
    }
    
    public static List<MetierPersonnelModele> getMetierPersonnelModeleByIdModele(Connect c, String id) throws Exception {
        List<MetierPersonnelModele> ans = new ArrayList<>();
        MetierPersonnelModele mpm = new MetierPersonnelModele();
        List<Object> obj = new ArrayList<>();
        String sql = "Select * from metierpersonnelmodele where idmodele = '"+id+"'";
        try {
            obj = GenericDAO.executeQuery(sql, c, mpm);
        } catch (Exception ex) {
            throw ex;
        }
        for (Object o : obj) {
            ans.add((MetierPersonnelModele) o);
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
