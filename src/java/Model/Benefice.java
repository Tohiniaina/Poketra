/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Tohy
 */
public class Benefice {
    private String idModele;
    private double montant;

    public Benefice() {
    }

    public Benefice(String idModele, double montant) {
        this.idModele = idModele;
        this.montant = montant;
    }

    public String getIdModele() {
        return idModele;
    }

    public void setIdModele(String idModele) {
        this.idModele = idModele;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
