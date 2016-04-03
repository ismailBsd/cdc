/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ArticleChp2;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kamal
 */
public class ArticleChp2Dao {

    public int save(ArticleChp2 articleChp2) throws SQLException {
        String requet = "INSERT INTO articlechp2 VALUES('0','" + articleChp2.getTitre() + "','"
                + articleChp2.getContenu() + "')";
        System.out.println(requet);
        return ConnectDB.exec(requet);
    }

    public int update(ArticleChp2 articleChp2) throws SQLException {

        String reuet = "UPDATE  articlechp2  SET titre='" + articleChp2.getTitre()+ "'"
               + ",contenu='" + articleChp2.getContenu() + "' WHERE id=" + articleChp2.getId();
        System.out.println(reuet);
        return ConnectDB.exec(reuet);
    }

    public int delete(ArticleChp2 articleChp2) throws SQLException {
        String requet = "DELETE FROM  articlechp2  WHERE id=" + articleChp2.getId();
        System.out.println(requet);
        return ConnectDB.exec(requet);
    }

    public List<ArticleChp2> load(String requet) throws SQLException {

        ResultSet resltset = ConnectDB.load(requet);
        List<ArticleChp2> articleChp2s = new ArrayList();
        while (resltset.next()) {
            ArticleChp2 loadArticleChp1 = new ArticleChp2(resltset.getInt("id"), resltset.getString("titre"),resltset.getString("contenu"));
            articleChp2s.add(loadArticleChp1);

        }
        return articleChp2s;

    }

    public List<ArticleChp2> finAll() throws SQLException {
        String requet = "SELECT * FROM articlechp2   ";
        System.out.println(requet);
        List<ArticleChp2> articleChp2s = load(requet);
        if (!articleChp2s.isEmpty()) {
            return articleChp2s;
        }
        return null;
    }
}
