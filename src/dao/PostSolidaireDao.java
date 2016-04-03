/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CorpDetat;
import bean.PostSolidaire;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * postsolidaire
 *
 * @author kamal
 */
public class PostSolidaireDao {

    public int save(PostSolidaire postSolidaire) throws SQLException {
        String requet = "INSERT INTO postsolidaire VALUES('0',"
                + postSolidaire.getCorpdetat().getId() + ",'" + postSolidaire.getTitre()+"','"
                +postSolidaire.getDescription()+"', "+postSolidaire.getPrix()+ ")";
        System.out.println(requet);
        return ConnectDB.exec(requet);
    }

    public int update(PostSolidaire postSolidaire) throws SQLException {

        String reuet = "UPDATE  postsolidaire SET titre='" + postSolidaire.getTitre() +"'"
        +",description='"+postSolidaire.getDescription() +"',prix = '"+postSolidaire.getPrix()+ "' WHERE id=" + postSolidaire.getId();
        System.out.println(reuet);
        return ConnectDB.exec(reuet);
    }

    public int delete(PostSolidaire postSolidaire) throws SQLException {
        String requet = "DELETE FROM  postsolidaire WHERE id=" + postSolidaire.getId();
        System.out.println(requet);
        return ConnectDB.exec(requet);
    }

    public List<PostSolidaire> load(String requet) throws SQLException {

        ResultSet resltset = ConnectDB.load(requet);
        List<PostSolidaire> postSolidaires = new ArrayList();
        while (resltset.next()) {
            PostSolidaire loadPostSolidaire = new PostSolidaire(resltset.getInt("id"), resltset.getString("titre"),resltset.getString("description"));
            loadPostSolidaire.setPrix(resltset.getDouble("prix"));
            loadPostSolidaire.getCorpdetat().setId(resltset.getInt("idsup"));
            postSolidaires.add(loadPostSolidaire);

        }
        return postSolidaires;

    }

    public List<PostSolidaire> finAll() throws SQLException {
        String requet = "SELECT * FROM postsolidaire  ";
        System.out.println(requet);
        List<PostSolidaire> postSolidaires = load(requet);
        if (!postSolidaires.isEmpty()) {
            return postSolidaires;
        }
        return null;
    }

    public List<PostSolidaire> findAllByCorpDeat(CorpDetat corpDetat) throws SQLException {
        String requet = "SELECT * FROM postsolidaire WHERE idsup= " + corpDetat.getId();
        System.out.println(requet);
        List<PostSolidaire> postSolidaires = load(requet);
        if (!postSolidaires.isEmpty()) {
            return postSolidaires;
        }
        return null;
    }
    public PostSolidaire find(PostSolidaire postSolidaire) throws SQLException {
        String requet = "SELECT * FROM postsolidaire WHERE titre='"+postSolidaire.getTitre()+"'";
        System.out.println(requet);
        List<PostSolidaire> postSolidaires = load(requet);
        if (!postSolidaires.isEmpty()) {
            return postSolidaires.get(0);
        }
        return null;
    }
}
