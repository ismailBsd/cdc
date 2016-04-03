/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import bean.CorpDetat;
import bean.Post;
import bean.PostAplusEleme;

import dao.PostAplusElemeDao;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author kamal
 */
public class PostAplusElemeService {

    PostAplusElemeDao postAplusElemeDao = new PostAplusElemeDao();

    public int save(PostAplusEleme postAplusEleme) throws SQLException {

        return postAplusElemeDao.save(postAplusEleme);
    }

    public int update(PostAplusEleme postAplusEleme) throws SQLException {

        return postAplusElemeDao.update(postAplusEleme);
    }

    public int delete(PostAplusEleme postAplusEleme) throws SQLException {

        return postAplusElemeDao.delete(postAplusEleme);
    }

    public List<PostAplusEleme> finAll() throws SQLException {

        List<PostAplusEleme> postAplusElemes = postAplusElemeDao.finAll();

        return postAplusElemes;

    }

    public PostAplusEleme find(PostAplusEleme aplusEleme) throws SQLException {

        return postAplusElemeDao.find(aplusEleme);
    }

    public List<PostAplusEleme> finAllByCorpDeta(CorpDetat corpDetat) throws SQLException {

        List<PostAplusEleme> postAplusElemes = postAplusElemeDao.finAllByCorpDetat(corpDetat);

        return postAplusElemes;

    }
    public PostAplusEleme castPostToPostApluselem(Post post) {
        PostAplusEleme postaplusEleme = new PostAplusEleme();
        postaplusEleme.setId(post.getId());
        postaplusEleme.setTitre(post.getTitre());
        postaplusEleme.setPrix(post.getPrix());
        postaplusEleme.setDescription(post.getDescription());
        postaplusEleme.setCorpdetat(post.getCorpdetat());
        return postaplusEleme;
    }
    public static ObservableList<PostAplusEleme>listToObservable(List<PostAplusEleme> list) {
    ObservableList<PostAplusEleme>list1=FXCollections.observableArrayList();
    for(PostAplusEleme obj:list){
        list1.add(obj);
    }
    return list1;
}
}
