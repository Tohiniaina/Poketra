/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tohy
 */
public class V_prix_model {
    private String idmodel;
    private String idtype;
    private String idlook;
    private String idtaille;
    private String nomtype;
    private String nomlook;
    private String nomtaille;
    private double prix;
    
    public V_prix_model() {
    }

    public V_prix_model(String idmodel, String idtype, String idlook, String idtaille, String nomtype, String nomlook, String nomtaille, double prix) {
        this.idmodel = idmodel;
        this.idtype = idtype;
        this.idlook = idlook;
        this.idtaille = idtaille;
        this.nomtype = nomtype;
        this.nomlook = nomlook;
        this.nomtaille = nomtaille;
        this.prix = prix;
    }

    public String getIdmodel() {
        return idmodel;
    }

    public void setIdmodel(String idmodel) {
        this.idmodel = idmodel;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getIdlook() {
        return idlook;
    }

    public void setIdlook(String idlook) {
        this.idlook = idlook;
    }

    public String getIdtaille() {
        return idtaille;
    }

    public void setIdtaille(String idtaille) {
        this.idtaille = idtaille;
    }

    public String getNomtype() {
        return nomtype;
    }

    public void setNomtype(String nomtype) {
        this.nomtype = nomtype;
    }

    public String getNomlook() {
        return nomlook;
    }

    public void setNomlook(String nomlook) {
        this.nomlook = nomlook;
    }

    public String getNomtaille() {
        return nomtaille;
    }

    public void setNomtaille(String nomtaille) {
        this.nomtaille = nomtaille;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public static List<V_prix_model> getTriModelPrix(Connection connection, double prixmin, double prixmax) throws Exception {
        List<Object> obj = new ArrayList<>();
        List<V_prix_model> ans = new ArrayList<>();
        V_prix_model form = new V_prix_model();
        String sql = "SELECT * FROM v_prix_model WHERE prix >= "+prixmin+" and prix <="+prixmax;
        System.out.println(sql);   

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idmodel = resultSet.getString("idmodel");
                String idtype = resultSet.getString("idtype");
                String idlook = resultSet.getString("idlook");
                String idtaille = resultSet.getString("idtaille");
                String nomtype = resultSet.getString("nomtype");
                String nomlook = resultSet.getString("nomlook");
                String nomtaille = resultSet.getString("nomtaille");
                double prix = resultSet.getDouble("prix");
                
                V_prix_model f = new V_prix_model(idmodel, idtype, idlook, idtaille, nomtype, nomlook, nomtaille, prix);
                ans.add(f);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            throw e;
        } 
        return ans;
    }
}
