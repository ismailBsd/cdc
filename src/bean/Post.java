/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author kamal
 */
public class Post {

    protected int id;
    protected  final StringProperty  titre;
    protected String description;
    protected double prix;
    protected CorpDetat corpdetat = new CorpDetat();
   

    public Post() {
         this.titre = new SimpleStringProperty("");
    }

    
    public Post(int id, String titre, String description, double prix) {
        this.id = id;
        this.titre = new SimpleStringProperty(titre);
        this.description = description;
        this.prix = prix;
    }

    public Post(int id, String titre, String description) {
        this.id = id;
       this.titre = new SimpleStringProperty(titre);
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre.get();
    }

    public void setTitre(String titre) {
        this.titre.set(titre);
    }
    public StringProperty titreProperty() {
		return titre;
	}
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public CorpDetat getCorpdetat() {
        return corpdetat;
    }

    public void setCorpdetat(CorpDetat corpdetat) {
        this.corpdetat = corpdetat;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", prix=" + prix + ", corpdetat=" + corpdetat + '}';
    }

   

   

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Post other = (Post) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        return true;
    }
public static ObservableList<Post>listToObservable(List<Post> list) {
    ObservableList<Post>list1=FXCollections.observableArrayList();
    for(Post obj:list){
        list1.add(obj);
    }
    return list1;
}
}
