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

@AnnotMap(nomTable = "profil")
public class Profil {
    @Attribut(attr = "idprofil", primary_key = true)
    String idProfil;
    @Attribut(attr = "libelle")
    String libelle;    

    public Profil() {
    }

    public Profil(String libelle) {
        this.libelle = libelle;
    }

    public String getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(String idProfil) {
        this.idProfil = idProfil;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    public static List<Profil> getAllProfil(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<Profil> allProfil = new ArrayList<>();
        Profil profil = new Profil();
        try {
            obj = GenericDAO.selectAll(profil, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allProfil.add((Profil)o);
        }
        
        return allProfil;
    }
    
    public static Profil getProfilById(Connect c, String id) throws SQLException {
        List<Object> obj = new ArrayList<>();
        Profil ans = new Profil();
        ans.setIdProfil(id);
        try {
            obj = GenericDAO.getById(ans, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            ans = (Profil) o;
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
