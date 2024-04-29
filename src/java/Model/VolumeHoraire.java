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
@AnnotMap (nomTable = "volumehoraire")
public class VolumeHoraire {
    @Attribut(attr = "idlook")
    String idLook;
    @Attribut(attr = "duree")
    double duree;    

    public VolumeHoraire() {
    }

    public VolumeHoraire(String idLook, double duree) {
        this.idLook = idLook;
        this.duree = duree;
    }

    public String getIdLook() {
        return idLook;
    }

    public void setIdLook(String idLook) {
        this.idLook = idLook;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }
    
    public static VolumeHoraire getVolumeHoraireByIdLook(Connect c, String id) throws Exception {
        VolumeHoraire ans = new VolumeHoraire();
        List<Object> obj = new ArrayList<>();
        String sql = "Select * from volumehoraire where idlook = '"+id+"'";
        try {
            obj = GenericDAO.executeQuery(sql, c, ans);
        } catch (Exception ex) {
            throw ex;
        }
        for (Object o : obj) {
            ans = (VolumeHoraire) o;
        }
        
        return ans;
    }
    
    public static List<VolumeHoraire> getAllVolumeHoraire(Connect c) throws SQLException {
        List<Object> obj = new ArrayList<>();
        List<VolumeHoraire> allVolumeHoraire = new ArrayList<>();
        VolumeHoraire vh = new VolumeHoraire();
        try {
            obj = GenericDAO.selectAll(vh, c);
        } catch (SQLException ex) {
            throw ex;
        }
        for (Object o : obj) {
            allVolumeHoraire.add((VolumeHoraire)o);
        }
        
        return allVolumeHoraire;
    }
    
    public void insert(Connect conn) throws Exception {
        try {
            GenericDAO.save(this, conn);
        } catch (Exception e) {
            throw e;
        } 
    }
}
