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
public class V_details_matiere_look {
    public String idml;
    public String idlook;
    public String idmatiere;
    public String nomlook;
    public String nommatiere;

    public V_details_matiere_look(String idml, String idlook, String idmatiere, String nomlook, String nommatiere) {
        this.idml = idml;
        this.idlook = idlook;
        this.idmatiere = idmatiere;
        this.nomlook = nomlook;
        this.nommatiere = nommatiere;
    }
    
    public static List<V_details_matiere_look> getMatiere(Connection connection, String id) throws Exception {
        List<V_details_matiere_look> ans = new ArrayList<>();
        String query = "select * from v_details_matiere_look where idlook = '"+id+"'";
        System.out.println(query);        

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idml = resultSet.getString("idml");
                String idlook = resultSet.getString("idlook");
                String idmatiere = resultSet.getString("idmatiere");
                String nomlook = resultSet.getString("nomlook");
                String nommatiere = resultSet.getString("nommatiere");
                
                V_details_matiere_look v = new V_details_matiere_look(idml, idlook, idmatiere, nomlook, nommatiere);
                ans.add(v);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            throw e;
        } 
        return ans;
    }
}
