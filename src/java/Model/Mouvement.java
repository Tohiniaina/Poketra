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
import java.sql.SQLException;
import utils.Connect;

/**
 *
 * @author Tohy
 */

@AnnotMap(nomTable = "mouvement")
public class Mouvement {
    @Attribut(attr = "idmouvement", primary_key = true)
    private String idmouvement;
    @Attribut(attr = "idmatiere")
    private String idmatiere;
    @Attribut(attr = "entrer")
    private double entrer;
    @Attribut(attr = "sortie")
    private double sortie;
    @Attribut(attr = "datemouvement")
    private Date datemouvement;
    
    private double reste;

    public Mouvement() {
    }

    public Mouvement(String idmatiere, double entrer, double sortie, Date datemouvement) {
        this.idmatiere = idmatiere;
        this.entrer = entrer;
        this.sortie = sortie;
        this.datemouvement = datemouvement;
        this.reste = reste;
    }

    public Mouvement(String idmatiere, Date datemouvement) {
        this.idmatiere = idmatiere;
        this.datemouvement = datemouvement;
        this.reste = reste;
    }

    public String getIdmouvement() {
        return idmouvement;
    }

    public void setIdmouvement(String idmouvement) {
        this.idmouvement = idmouvement;
    }
    public String getIdmatiere() {
        return idmatiere;
    }

    public void setIdmatiere(String idmatiere) {
        this.idmatiere = idmatiere;
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
    
    public String getNomMatiere(Connect c) throws SQLException {
        return Matiere.getMatiereById(c, idmatiere).getNom();
    }
    
    public void setQuantite(double quantite, Connect c, int type) throws Exception {
        Stock stock = Stock.getStockByIdMatiere(c, idmatiere);
        if (stock.getQuantite() < quantite) {
            System.out.println("Stock "+stock.getQuantite()+"-- Quantite "+quantite);
            this.reste = quantite - stock.getQuantite();
        }
        if (type == 0) {
            this.sortie = quantite;
        }
        if (type == 1) {
            this.entrer = quantite;
        }
    }

    public Date getDatemouvement() {
        return datemouvement;
    }

    public void setDatemouvement(Date datemouvement) {
        this.datemouvement = datemouvement;
    }

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }
    
    public void insert(Connect conn) throws Exception {
        try {
            GenericDAO.save(this, conn);
        } catch (Exception e) {
            throw e;
        } 
    }
}
