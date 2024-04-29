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

@AnnotMap(nomTable = "mouvementsac")
public class MouvementSac {
    @Attribut(attr = "idmouvementsac", primary_key = true)
    private String idMouvementSac;
    @Attribut(attr = "idmodele")
    private String idModele;
    @Attribut(attr = "entrer")
    private double entrer;
    @Attribut(attr = "sortie")
    private double sortie;
    @Attribut(attr = "datemouvement")
    private Date datemouvement;

    public MouvementSac(String idModele, double entrer, double sortie, Date datemouvement) {
        this.idModele = idModele;
        this.entrer = entrer;
        this.sortie = sortie;
        this.datemouvement = datemouvement;
    }

    public MouvementSac() {
    }

    public String getIdMouvementSac() {
        return idMouvementSac;
    }

    public void setIdMouvementSac(String idMouvementSac) {
        this.idMouvementSac = idMouvementSac;
    }

    public String getIdModele() {
        return idModele;
    }

    public void setIdModele(String idModele) {
        this.idModele = idModele;
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

    public Date getDatemouvement() {
        return datemouvement;
    }

    public void setDatemouvement(Date datemouvement) {
        this.datemouvement = datemouvement;
    }
    
    public void insert(Connect conn) throws Exception {
        try {
            GenericDAO.save(this, conn);
        } catch (Exception e) {
            throw e;
        } 
    }
}
