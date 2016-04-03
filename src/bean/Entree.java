/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.time.LocalDate;

/**
 *
 * @author i
 */
public class Entree {

    private int nDEnregistrement;

    private String DateDEnregistrement;

    private int versionDuProjet;

    private String designationDuProjet;

    private String sigle;

    private String delai;

    public Entree() {

    }

    public Entree(int nDEnregistrement, int versionDuProjet, String designationDuProjet) {
        this.nDEnregistrement = nDEnregistrement;
        this.versionDuProjet = versionDuProjet;
        this.designationDuProjet = designationDuProjet;
    }

    public int getnDEnregistrement() {
        return nDEnregistrement;
    }

    public void setnDEnregistrement(int nDEnregistrement) {
        this.nDEnregistrement = nDEnregistrement;
    }

    public String getDateDEnregistrement() {
        return DateDEnregistrement;
    }

    public void setDateDEnregistrement(String DateDEnregistrement) {
        this.DateDEnregistrement = DateDEnregistrement;
    }

    public int getVersionDuProjet() {
        return versionDuProjet;
    }

    public void setVersionDuProjet(int versionDuProjet) {
        this.versionDuProjet = versionDuProjet;
    }

    public String getDesignationDuProjet() {
        return designationDuProjet;
    }

    public void setDesignationDuProjet(String designationDuProjet) {
        this.designationDuProjet = designationDuProjet;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getDelai() {
        return delai;
    }

    public void setDelai(String delai) {
        this.delai = delai;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.nDEnregistrement;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entree other = (Entree) obj;
        if (this.nDEnregistrement != other.nDEnregistrement) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entree{" + "nDEnregistrement=" + nDEnregistrement + ", DateDEnregistrement=" + DateDEnregistrement + ", versionDuProjet=" + versionDuProjet + ", designationDuProjet=" + designationDuProjet + ", sigle=" + sigle + ", delai=" + delai + '}';
    }

}
