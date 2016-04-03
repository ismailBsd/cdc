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
public class Consomation {
   private  int  id;
   private CorpDetat corpDetat=new CorpDetat();
   private List<ConsomationItem> consomationItems=new ArrayList<>();

    public Consomation(int id) {
        this.id = id;
    }

    public Consomation() {
    }

    public int  getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CorpDetat getCorpDetat() {
        return corpDetat;
    }

    public void setCorpDetat(CorpDetat corpDetat) {
        this.corpDetat = corpDetat;
    }

    public List<ConsomationItem> getConsomationItems() {
        return consomationItems;
    }

    public void setConsomationItems(List<ConsomationItem> consomationItems) {
        this.consomationItems = consomationItems;
    }

    @Override
    public String toString() {
        return "Consomation{" + "id=" + id + ", corpDetat=" + corpDetat + ", consomationItems=" + consomationItems + '}';
    }
 
   
}
