/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author kamal
 */
public class CorpDetat {

    private int id;
    private final StringProperty  titre;
    private List<Post> posts=new ArrayList<Post>();
    private List<PostSolidaire> postsolidairs = new ArrayList<PostSolidaire>();
    private List<PostAplusEleme> postepluselemes = new ArrayList<PostAplusEleme>();

    public CorpDetat() {
        this.titre = new SimpleStringProperty("");
    }

    public CorpDetat(int id, String titre) {
        this.id = id;
        this.titre = new SimpleStringProperty(titre);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    
 
    public CorpDetat(String titre) {

        this.titre =  new SimpleStringProperty(titre);
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

    public List<PostSolidaire> getPostsolidairs() {
        return postsolidairs;
    }

    public void setPostsolidairs(List<PostSolidaire> postsolidairs) {
        this.postsolidairs = postsolidairs;
    }

    public List<PostAplusEleme> getPostepluselemes() {
        return postepluselemes;
    }

    public void setPostepluselemes(List<PostAplusEleme> postepluselemes) {
        this.postepluselemes = postepluselemes;
    }

    @Override
    public String toString() {
        return "CorpDetat{" + "id=" + id + ", titre=" + titre + '}';
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
        final CorpDetat other = (CorpDetat) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        return true;
    }

   
   
}
