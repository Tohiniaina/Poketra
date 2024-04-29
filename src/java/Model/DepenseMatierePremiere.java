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
import java.util.ArrayList;
import java.util.List;
import utils.Connect;

/**
 *
 * @author Tohy
 */
@AnnotMap(nomTable = "depensematierepremiere")
public class DepenseMatierePremiere {
    @Attribut(attr = "idmodel")    
    private String idmodel;
    @Attribut(attr = "prixtotal")
    private double prixtotal;

    public DepenseMatierePremiere() {
    }

    public DepenseMatierePremiere(String idmodel, double prixtotal) {
        this.idmodel = idmodel;
        this.prixtotal = prixtotal;
    }

    public String getIdmodel() {
        return idmodel;
    }

    public void setIdmodel(String idmodel) {
        this.idmodel = idmodel;
    }

    public double getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(double prixtotal) {
        this.prixtotal = prixtotal;
    }
    
    public static DepenseMatierePremiere getDepenseMatierePremiereModel(Connection connection, String id) throws Exception {
        DepenseMatierePremiere ans = new DepenseMatierePremiere();
        List<Object> obj = new ArrayList<>();
        
        String sql = "select * from depensematierepremiere where idmodel = '"+id+"'";
        System.out.println(sql);   

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idmodel = resultSet.getString("idmodel");
                double prixtotal = resultSet.getDouble("prixtotal");
                
                ans = new DepenseMatierePremiere(idmodel, prixtotal);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            throw e;
        } 
        return ans;
    }
}
