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

@AnnotMap(nomTable = "stock")
public class Stock {
    @Attribut(attr = "idmatiere")
    String idMatiere;
    @Attribut(attr = "nom")
    String nomMatiere;
    @Attribut(attr = "total_quantity")
    double quantite;
    @Attribut(attr = "entrer")
    double entrer;
    @Attribut(attr = "sortie")
    double sortie;

    public Stock(String idMatiere, double quantite) {
        this.idMatiere = idMatiere;
        this.quantite = quantite;
    }

    public Stock() {
    }

    public String getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(String idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getEntrer() {
        return entrer;
    }

    public void setEntrer(double entrer) {
        this.entrer = entrer;
    }

    public double getSortie() {
        return sortie;
    }

    public void setSortie(double sortie) {
        this.sortie = sortie;
    }
    
    public static List<Stock> getAllStock(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<Stock> allStock = new ArrayList<>();
        Stock stock = new Stock();
        try {
            obj = GenericDAO.selectAll(stock, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allStock.add((Stock)o);
        }
        
        return allStock;
    }
    
    public static Stock getStockByIdMatiere(Connect c, String id) throws Exception {
        Stock ans = new Stock();
        List<Object> obj = new ArrayList<>();
        String sql = "Select * from stock where idmatiere = '"+id+"'";
        try {
            obj = GenericDAO.executeQuery(sql, c, ans);
        } catch (Exception ex) {
            throw ex;
        }
        for (Object o : obj) {
            ans = (Stock) o;
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
