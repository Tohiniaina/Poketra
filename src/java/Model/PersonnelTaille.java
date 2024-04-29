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
@AnnotMap(nomTable = "personneltaille")
public class PersonnelTaille {
    @Attribut(attr = "idtaille")
    private String idTaille;
    @Attribut(attr = "nbrperso")
    private double nbrPerso;

    public PersonnelTaille() {
    }

    public PersonnelTaille(String idTaille, double nbr) {
        this.idTaille = idTaille;
        this.nbrPerso = nbr;
    }

    public String getIdTaille() {
        return idTaille;
    }

    public void setIdTaille(String idTaille) {
        this.idTaille = idTaille;
    }

    public double getNbrPerso() {
        return nbrPerso;
    }

    public void setNbrPerso(double nbr) {
        this.nbrPerso = nbr;
    }
    
    public static PersonnelTaille getPersonnelTailleByIdTaille(Connect c, String id) throws Exception {
        PersonnelTaille ans = new PersonnelTaille();
        List<Object> obj = new ArrayList<>();
        String sql = "Select * from personneltaille where idtaille = '"+id+"'";
        try {
            obj = GenericDAO.executeQuery(sql, c, ans);
        } catch (Exception ex) {
            throw ex;
        }
        for (Object o : obj) {
            ans = (PersonnelTaille) o;
        }
        
        return ans;
    }
    
    public static List<PersonnelTaille> getAllPersonnelTaille(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<PersonnelTaille> allPersonnel = new ArrayList<>();
        PersonnelTaille personnel = new PersonnelTaille();
        try {
            obj = GenericDAO.selectAll(personnel, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allPersonnel.add((PersonnelTaille)o);
        }
        
        return allPersonnel;
    }
    
    public void insert(Connect conn) throws Exception {
        try {
            GenericDAO.save(this, conn);
        } catch (Exception e) {
            throw e;
        } 
    }
}
