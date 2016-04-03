/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Bordereau;
import bean.Consomation;
import bean.ConsomationItem;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author kamal
 */
public class BordereauService {

    public List<Bordereau> rmplairBordereux(List<Consomation> consomations) {
        List<Bordereau> bordereaus = new ArrayList<>();

        for (Consomation loadconsomation : consomations) {
            Bordereau bordereau1 = new Bordereau();
       
            bordereau1.setDesignation(loadconsomation.getCorpDetat().getTitre());
            bordereaus.add(bordereau1);
            for (ConsomationItem loadconsomationItem : loadconsomation.getConsomationItems()) {
                Bordereau bordereau2 = new Bordereau();
                bordereau2.setDesignation(loadconsomationItem.getPost().getTitre());
                bordereau2.setPrix(loadconsomationItem.getPost().getPrix());
                bordereau2.setUnite(loadconsomationItem.getUnite());
                bordereau2.setQuanite(loadconsomationItem.getQuanite());
                double montant = bordereau2.getQuanite() * bordereau2.getPrix();
                bordereau2.setMontant(montant);
                bordereaus.add(bordereau2);

            }
        }

        return bordereaus;
    }
     public static ObservableList<Bordereau>listToObservable(List<Bordereau> list) {
    ObservableList<Bordereau>list1=FXCollections.observableArrayList();
    for(Bordereau obj:list){
        list1.add(obj);
    }
    return list1;
}
}
