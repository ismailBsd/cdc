/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ArticleChp1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * articlechp1
 *
 * @author kamal
 */
public class ArticleChp1Dao {

    public int save(ArticleChp1 articleChp1) throws SQLException {
        String requet = "INSERT INTO articlechp1 VALUES('0','" + articleChp1.getTitre()
                + "','" + articleChp1.getContenu() + "',5)";
        System.out.println(requet);
        return ConnectDB.exec(requet);
    }

    public int update(ArticleChp1 articleChp1) throws SQLException {

        String reuet = "UPDATE  articlechp1 SET titre='" + articleChp1.getTitre()
                + "',contenu='" + articleChp1.getContenu() + "' WHERE id=" + articleChp1.getId();
        System.out.println(reuet);
        return ConnectDB.exec(reuet);
    }

    public int delete(ArticleChp1 articleChp1) throws SQLException {
        String requet = "DELETE FROM  articlechp1 WHERE id=" + articleChp1.getId();
        System.out.println(requet);
        return ConnectDB.exec(requet);
    }

    public List<ArticleChp1> load(String requet) throws SQLException {

        ResultSet resltset = ConnectDB.load(requet);
        List<ArticleChp1> articleChp1s = new ArrayList();
        while (resltset.next()) {
            // ArticleChp1 loadArticleChp1 = new ArticleChp1();
            ArticleChp1 loadArticleChp1 = new ArticleChp1(resltset.getInt("id"), resltset.getString("titre"), resltset.getString("contenu"));
            /*
             loadArticleChp1.setId(resltset.getInt("id"));
             loadArticleChp1.setContenu(resltset.getString("contenu"));
             loadArticleChp1.setTitre(resltset.getString("titre"));
             */
            articleChp1s.add(loadArticleChp1);

        }
        return articleChp1s;

    }

    public List<ArticleChp1> finAll() throws SQLException {
        String requet = "SELECT * FROM articlechp1  ";
        System.out.println(requet);
        List<ArticleChp1> articleChp1s = load(requet);
        if (!articleChp1s.isEmpty()) {
            return articleChp1s;
        }
        return null;
    }

}
