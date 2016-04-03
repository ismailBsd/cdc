/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.ArticleChp1;
import dao.ArticleChp1Dao;

import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author kamal
 */
public class ArticleChp1Service {

    ArticleChp1Dao articleChp1Dao = new ArticleChp1Dao();

    public int save(ArticleChp1 articleChp1) throws SQLException {

        return articleChp1Dao.save(articleChp1);
    }

    public int update(ArticleChp1 articleChp1) throws SQLException {

        return articleChp1Dao.update(articleChp1);
    }

    public int delete(ArticleChp1 articleChp1) throws SQLException {

        return articleChp1Dao.delete(articleChp1);
    }

    public List<ArticleChp1> finAll() throws SQLException {

        List<ArticleChp1> articleChp1s = articleChp1Dao.finAll();

        return articleChp1s;

    }
public static ObservableList<ArticleChp1>listToObservable(List<ArticleChp1> list) {
    ObservableList<ArticleChp1>list1=FXCollections.observableArrayList();
    for(ArticleChp1 obj:list){
        list1.add(obj);
    }
    return list1;
}
}