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

@AnnotMap(nomTable = "prixvente")
public class PrixVente {
    @Attribut(attr = "idmodele")
    String idModele;
    @Attribut(attr = "montant")
    double montant;  

    public PrixVente() {
    }

    public PrixVente(String idModele, double montant) {
        this.idModele = idModele;
        this.montant = montant;
    }

    public String getIdModele() {
        return idModele;
    }

    public void setIdModele(String idModele) {
        this.idModele = idModele;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    
    public static List<PrixVente> getAllPrixVente(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<PrixVente> allPrixVente = new ArrayList<>();
        PrixVente pv = new PrixVente();
        try {
            obj = GenericDAO.selectAll(pv, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allPrixVente.add((PrixVente)o);
        }
        
        return allPrixVente;
    }
    
    public static PrixVente getPrixVenteByIdModele(Connect c, String id) throws Exception {
        PrixVente ans = new PrixVente();
        List<Object> obj = new ArrayList<>();
        String sql = "Select * from prixvente where idmodele = '"+id+"'";
        try {
            obj = GenericDAO.executeQuery(sql, c, ans);
        } catch (Exception ex) {
            throw ex;
        }
        for (Object o : obj) {
            ans = (PrixVente) o;
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
