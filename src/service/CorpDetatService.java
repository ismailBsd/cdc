/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.CorpDetat;
import dao.CorpDetatDao;

import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author kamal
 */
public class CorpDetatService {

    CorpDetatDao corpDetatDao = new CorpDetatDao();

    public int save(CorpDetat corpdetat) throws SQLException {

        return corpDetatDao.save(corpdetat);
    }

    public int update(CorpDetat corpdetat) throws SQLException {

        return corpDetatDao.update(corpdetat);
    }

    public int delete(CorpDetat corpdetat) throws SQLException {

        return corpDetatDao.delete(corpdetat);
    }

    public List<CorpDetat> finAll() throws SQLException {

        List<CorpDetat> corpDetats = corpDetatDao.finAll();

        return corpDetats;

    }
    public static ObservableList<CorpDetat>listToObservable(List<CorpDetat> list) {
    ObservableList<CorpDetat>list1=FXCollections.observableArrayList();
    for(CorpDetat obj:list){
        list1.add(obj);
    }
    return list1;
}

    public CorpDetat find(CorpDetat corpDetat) throws SQLException {
        return corpDetatDao.find(corpDetat);
    }
    
}
