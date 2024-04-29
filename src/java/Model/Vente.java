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
@AnnotMap(nomTable = "vente")
public class Vente {
    @Attribut(attr = "idvente", primary_key = true)
    private String idVente;
    @Attribut(attr = "idmodele")
    private String idModele;
    @Attribut(attr = "nombre")
    private int nombre;
    @Attribut(attr = "idpersonne")
    private String idClient;

    public Vente(String idModele, int nombre, String idClient) {
        this.idModele = idModele;
        this.nombre = nombre;
        this.idClient = idClient;
    }

    public Vente() {
    }

    public String getIdVente() {
        return idVente;
    }

    public void setIdVente(String idVente) {
        this.idVente = idVente;
    }

    public String getIdModele() {
        return idModele;
    }

    public void setIdModele(String idModele) {
        this.idModele = idModele;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
    
    public static List<Vente> getAllVente(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<Vente> allVente = new ArrayList<>();
        Vente vente = new Vente();
        try {
            obj = GenericDAO.selectAll(vente, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allVente.add((Vente)o);
        }
        
        return allVente;
    }
    
    public void insert(Connect conn) throws Exception {
        try {
            GenericDAO.save(this, conn);
        } catch (Exception e) {
            throw e;
        } 
    }
}
