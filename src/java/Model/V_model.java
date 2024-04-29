/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import back.frame.AnnotMap;
import back.frame.Attribut;

/**
 *
 * @author Tohy
 */

@AnnotMap(nomTable = "v_model")
public class V_model {
    @Attribut(attr = "idmodel", primary_key = true)
    String idModele;
    @Attribut(attr = "idtype")
    String idType;
    @Attribut(attr = "nomtype")
    String nomType;
    @Attribut(attr = "idlook")
    String idLook;
    @Attribut(attr = "nomlook")
    String nomLook;
    @Attribut(attr = "idtaille")
    String idTaille;
    @Attribut(attr = "nomtaille")
    String nomTaille;

    public V_model(String idModele, String idType, String nomType, String idLook, String nomLook, String idTaille, String nomTaille) {
        this.idModele = idModele;
        this.idType = idType;
        this.nomType = nomType;
        this.idLook = idLook;
        this.nomLook = nomLook;
        this.idTaille = idTaille;
        this.nomTaille = nomTaille;
    }

    public V_model() {
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

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }

    public String getIdLook() {
        return idLook;
    }

    public void setIdLook(String idLook) {
        this.idLook = idLook;
    }

    public String getNomLook() {
        return nomLook;
    }

    public void setNomLook(String nomLook) {
        this.nomLook = nomLook;
    }

    public String getIdTaille() {
        return idTaille;
    }

    public void setIdTaille(String idTaille) {
        this.idTaille = idTaille;
    }

    public String getNomTaille() {
        return nomTaille;
    }

    public void setNomTaille(String nomTaille) {
        this.nomTaille = nomTaille;
    }
}
