/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.CorpDetat;
import bean.Post;
import bean.PostAplusEleme;
import bean.PostSolidaire;
import dao.PostSolidaireDao;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author kamal
 */
public class PostSolidaireService {

    PostSolidaireDao postSolidaireDao = new PostSolidaireDao();

    public int save(PostSolidaire postSolidaire) throws SQLException {

        return postSolidaireDao.save(postSolidaire);
    }

    public int update(PostSolidaire postSolidaire) throws SQLException {

        return postSolidaireDao.update(postSolidaire);
    }

    public int delete(PostSolidaire postSolidaire) throws SQLException {

        return postSolidaireDao.delete(postSolidaire);
    }

    public List<PostSolidaire> finAll() throws SQLException {

        List<PostSolidaire> postSolidaires = postSolidaireDao.finAll();

        return postSolidaires;

    }

    public List<PostSolidaire> findAllByCorpDeat(CorpDetat corpDetat) throws SQLException {

        List<PostSolidaire> postSolidaires = postSolidaireDao.findAllByCorpDeat(corpDetat);

        return postSolidaires;

    }

    public PostSolidaire find(PostSolidaire postSolidaire) throws SQLException {

        return postSolidaireDao.find(postSolidaire);
    }
    public PostSolidaire castPostToPostSolidair(Post post) {
        PostSolidaire postSolidaire = new PostSolidaire();
        postSolidaire.setId(post.getId());
        postSolidaire.setTitre(post.getTitre());
        postSolidaire.setPrix(post.getPrix());
        postSolidaire.setDescription(post.getDescription());
        postSolidaire.setCorpdetat(post.getCorpdetat());
        return postSolidaire;
    }
     public static ObservableList<PostSolidaire>listToObservable(List<PostSolidaire> list) {
    ObservableList<PostSolidaire>list1=FXCollections.observableArrayList();
    for(PostSolidaire obj:list){
        list1.add(obj);
    }
    return list1;
}
}
