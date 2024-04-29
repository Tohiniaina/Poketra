/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import back.dao.GenericDAO;
import back.frame.AnnotMap;
import back.frame.Attribut;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Connect;

/**
 *
 * @author Tohy
 */

@AnnotMap(nomTable = "personnel")
public class Personnel {
    @Attribut(attr = "idpersonnel", primary_key = true)
    private String idPersonnel;
    @Attribut(attr = "fonction")
    private String fonction;
    @Attribut(attr = "tauxhoraire")
    private double tauxHoraire;

    public Personnel(String fonction, double tauxHoraire) {
        this.fonction = fonction;
        this.tauxHoraire = tauxHoraire;
    }

    public Personnel() {
    }

    public String getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(String idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }   
    
    public static List<Personnel> getAllPersonnel(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<Personnel> allPersonnel = new ArrayList<>();
        Personnel personnel = new Personnel();
        try {
            obj = GenericDAO.selectAll(personnel, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allPersonnel.add((Personnel)o);
        }
        
        return allPersonnel;
    }
    
    public void insert(Connect conn) throws Exception {
        try {
            GenericDAO.save(this, conn);
        } catch (Exception e) {
            throw e;
        } 
    }
}
