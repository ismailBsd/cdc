/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kamal
 */
public class Projet {

    private String num;
    private String dateEnregestrement;
    private String desgnation;
    private String versionProjet;
    private String sigleSD;// sigle des service demandeur
    private String delai;
   private  List<Consomation> consomations=new ArrayList();

    public Projet(String num, String dateEnregestrement, String desgnation, String versionProjet, String sigleDuServiceDemandeur, String delai) {
        this.num = num;
        this.dateEnregestrement = dateEnregestrement;
        this.desgnation = desgnation;
        this.versionProjet = versionProjet;
        this.sigleSD = sigleDuServiceDemandeur;
        this.delai = delai;
    }

    public String getSigleSD() {
        return sigleSD;
    }

    public void setSigleSD(String sigleSD) {
        this.sigleSD = sigleSD;
    }

    

    
    public Projet() {
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDateEnregestrement() {
        return dateEnregestrement;
    }

    public void setDateEnregestrement(String dateEnregestrement) {
        this.dateEnregestrement = dateEnregestrement;
    }

    public String getDesgnation() {
        return desgnation;
    }

    public void setDesgnation(String desgnation) {
        this.desgnation = desgnation;
    }

    public String getVersionProjet() {
        return versionProjet;
    }

    public void setVersionProjet(String versionProjet) {
        this.versionProjet = versionProjet;
    }

    public String getSigleDuServiceDemandeur() {
        return sigleSD;
    }

    public void setSigleDuServiceDemandeur(String sigleDuServiceDemandeur) {
        this.sigleSD = sigleDuServiceDemandeur;
    }

    public String getDelai() {
        return delai;
    }

    public void setDelai(String delai) {
        this.delai = delai;
    }

    public List<Consomation> getConsomations() {
        return consomations;
    }

    public void setConsomations(List<Consomation> consomations) {
        this.consomations = consomations;
    }

    @Override
    public String toString() {
        return "Projet{" + "num=" + num + ", dateEnregestrement=" + dateEnregestrement + ", desgnation=" + desgnation + ", versionProjet=" + versionProjet + ", sigleSD=" + sigleSD + ", delai=" + delai + ", consomations=" + consomations + '}';
    }


   

}
