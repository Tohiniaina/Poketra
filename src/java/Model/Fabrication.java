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
@AnnotMap (nomTable = "fabrication")
public class Fabrication {
    @Attribut(attr = "idfabrication", primary_key = true)
    String idFabrication;
    @Attribut(attr = "idmodele")
    String idModel;
    @Attribut(attr = "datefabrication")
    Date dateFabrication;
    @Attribut(attr = "nombre")
    double nombre;

    public Fabrication(String idModel, Date dateFabrication, double nombre) {
        this.idModel = idModel;
        this.dateFabrication = dateFabrication;
        this.nombre = nombre;
    }
    
    public Fabrication() {
    }

    public String getIdFabrication() {
        return idFabrication;
    }

    public void setIdFabrication(String idFabrication) {
        this.idFabrication = idFabrication;
    }

    public String getIdModel() {
        return idModel;
    }

    public void setIdModel(String idModel) {
        this.idModel = idModel;
    }    
    
    public String getNomModel() {
        Connect c;
        String ans = "";
        try {
            c = new Connect();
            Modele mod = Modele.getModelById(c, this.getIdModel());
            Type type = Type.getTypeById(c, mod.getIdType());
            Look look = Look.getLookById(c, mod.getIdLook());
            Taille taille = Taille.getTailleById(c, mod.getIdTaille());
            ans = type.getNom()+" "+look.getNomLook()+" "+taille.getNom();
            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ans;
    }

    public Date getDateFabrication() {
        return dateFabrication;
    }

    public void setDateFabrication(Date dateFabrication) {
        this.dateFabrication = dateFabrication;
    }

    public double getNombre() {
        return nombre;
    }

    public void setNombre(double nombre) {
        this.nombre = nombre;
    }
    
    public static List<Fabrication> getAllFabrication(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<Fabrication> allFabrication = new ArrayList<>();
        Fabrication fabrication = new Fabrication();
        try {
            obj = GenericDAO.selectAll(fabrication, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allFabrication.add((Fabrication)o);
        }
        
        return allFabrication;
    }
    
    public void insert(Connect conn) throws Exception {
        try {
            GenericDAO.save(this, conn);
        } catch (Exception e) {
            throw e;
        } 
    }
}
