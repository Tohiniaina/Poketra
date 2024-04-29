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
import java.util.ArrayList;
import java.util.List;
import utils.Connect;

/**
 *
 * @author Tohy
 */

@AnnotMap(nomTable = "personne")
public class Personne {
    @Attribut(attr = "idpersonne", primary_key = true)
    private String idPersonne;
    @Attribut(attr = "nom")
    private String nom;
    @Attribut(attr = "genre")
    private int genre;
    @Attribut(attr = "dtn")
    private Date dtn;
    @Attribut(attr = "adresse")
    private String adresse;

    public Personne(String nom, int genre, Date dtn, String adresse) {
        this.nom = nom;
        this.genre = genre;
        this.dtn = dtn;
        this.adresse = adresse;
    }
    
    public Personne() {
    }

    public String getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(String idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getGenre() {
        return genre;
    }
    
    public String getGenreString() {
        if (this.genre == 1) {
            return  "Homme";
        } else {
            return "Femme";
        }
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public Date getDtn() {
        return dtn;
    }

    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }   
    
    public static List<Personne> getAllPersonne(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<Personne> allPersonne = new ArrayList<>();
        Personne personne = new Personne();
        try {
            obj = GenericDAO.selectAll(personne, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allPersonne.add((Personne)o);
        }
        
        return allPersonne;
    }
    
    public void insert(Connect conn) throws Exception {
        try {
            GenericDAO.save(this, conn);
        } catch (Exception e) {
            throw e;
        } 
    }
}
