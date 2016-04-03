/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.ArticleChp1;
import bean.ArticleChp2;
import dao.ArticleChp2Dao;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author kamal
 */
public class ArticleChp2Service {

    ArticleChp2Dao articleChp2Dao = new ArticleChp2Dao();

    public int save(ArticleChp2 articleChp2) throws SQLException {

        return articleChp2Dao.save(articleChp2);
    }

    public int update(ArticleChp2 articleChp2) throws SQLException {

        return articleChp2Dao.update(articleChp2);
    }

    public int delete(ArticleChp2 articleChp2) throws SQLException {

        return articleChp2Dao.delete(articleChp2);
    }

    public List<ArticleChp2> finAll() throws SQLException {

        List<ArticleChp2> articleChp2s = articleChp2Dao.finAll();

        return articleChp2s;

    }
    public static ObservableList<ArticleChp2>listToObservable(List<ArticleChp2> list) {
    ObservableList<ArticleChp2>list1=FXCollections.observableArrayList();
    for(ArticleChp2 obj:list){
        list1.add(obj);
    }
    return list1;
}
}
