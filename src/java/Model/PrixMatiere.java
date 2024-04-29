/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import back.dao.GenericDAO;
import back.frame.AnnotMap;
import back.frame.Attribut;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import utils.Connect;

/**
 *
 * @author Tohy
 */

@AnnotMap(nomTable = "prixmatiere")
public class PrixMatiere {
    @Attribut(attr = "idmatiere")
    String idMatiere; 
    @Attribut(attr = "prix")
    double prix; 
    @Attribut(attr = "date")
    Date date;

    public PrixMatiere(String idMatiere, double prix, Date date) {
        this.idMatiere = idMatiere;
        this.prix = prix;
        this.date = date;
    }

    public PrixMatiere() {
    }

    public String getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(String idMatiere) {
        this.idMatiere = idMatiere;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    public static PrixMatiere getPrixMatiereByIdMatiere(Connect c, String id) throws Exception {
        PrixMatiere ans = new PrixMatiere();
        List<Object> obj = new ArrayList<>();
        String sql = "Select * from prixmatiere where idmatiere = '"+id+"'";
        try {
            obj = GenericDAO.executeQuery(sql, c, ans);
        } catch (Exception ex) {
            throw ex;
        }
        for (Object o : obj) {
            ans = (PrixMatiere) o;
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
