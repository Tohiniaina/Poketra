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
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Connect;

/**
 *
 * @author Tohy
 */
@AnnotMap(nomTable = "model")
public class Modele {
    @Attribut(attr = "idmodel", primary_key = true)
    String idModele;
    @Attribut(attr = "idType")
    String idType;
    @Attribut(attr = "idlook")
    String idLook;
    @Attribut(attr = "idtaille")
    String idTaille;

    public Modele() {
    }

    public Modele(String idType, String idLook, String idTaille) {
        this.idType = idType;
        this.idLook = idLook;
        this.idTaille = idTaille;
    }

    public Modele(String idModele, String idType, String idLook, String idTaille) {
        this.idModele = idModele;
        this.idType = idType;
        this.idLook = idLook;
        this.idTaille = idTaille;
    }

    public String getNomModel() {
        Connect c;
        String ans = "";
        try {
            c = new Connect();
            Type type = Type.getTypeById(c, this.idType);
            Look look = Look.getLookById(c, this.idLook);
            Taille taille = Taille.getTailleById(c, this.idTaille);
            ans = type.getNom()+" "+look.getNomLook()+" "+taille.getNom();
            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ans;
    }

    public String getIdTaille() {
        return idTaille;
    }

    public void setIdTaille(String idTaille) {
        this.idTaille = idTaille;
    }
    
    public String getIdModele() {
        return idModele;
    }

    public void setIdModele(String idModele) {
        this.idModele = idModele;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdLook() {
        return idLook;
    }

    public void setIdLook(String idLook) {
        this.idLook = idLook;
    }
    
    public static List<Modele> getAllModele(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<Modele> allModele = new ArrayList<>();
        Modele model = new Modele();
        try {
            obj = GenericDAO.selectAll(model, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allModele.add((Modele)o);
        }
        
        return allModele;
    }
    
    public static Modele getModelById(Connect c, String id) throws SQLException {
        List<Object> obj = new ArrayList<>();
        Modele ans = new Modele();
        ans.setIdModele(id);
        try {
            obj = GenericDAO.getById(ans, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            ans = (Modele) o;
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
