/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CorpDetat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * CorpDetat corpdetat
 *
 * @author kamal
 */
public class CorpDetatDao {

    public int save(CorpDetat corpdetat) throws SQLException {
        String requet = "INSERT INTO corpdetat VALUES('0','" + corpdetat.getTitre() + "')";
        System.out.println(requet);
        return ConnectDB.exec(requet);
    }

    public int update(CorpDetat corpdetat) throws SQLException {

        String reuet = "UPDATE  corpdetat SET titre='" + corpdetat.getTitre() + "' WHERE id=" + corpdetat.getId();
        System.out.println(reuet);
        return ConnectDB.exec(reuet);
    }

    public int delete(CorpDetat corpdetat) throws SQLException {
        String requet = "DELETE FROM  corpdetat WHERE id=" + corpdetat.getId();
        System.out.println(requet);
        return ConnectDB.exec(requet);
    }

    public List<CorpDetat> load(String requet) throws SQLException {

        ResultSet resltset = ConnectDB.load(requet);
        List<CorpDetat> corpdetats = new ArrayList();
        while (resltset.next()) {
            CorpDetat loadcorpdetat = new CorpDetat(resltset.getString("titre"));
            loadcorpdetat.setId(resltset.getInt("id"));
            corpdetats.add(loadcorpdetat);

        }
        return corpdetats;

    }
/*
    public CorpDetat findById(CorpDetat corpdetat) throws SQLException {

        String reuet = "SELECT  * FROM corpdetat WHERE id=" + corpdetat.getId();
        System.out.println(reuet);
        List<CorpDetat> corpDetats = load(reuet);
        if (corpDetats != null) {
            return corpDetats.get(0);
        }
        return null;
    }*/
     public CorpDetat find(CorpDetat corpdetat) throws SQLException {

        String reuet = "SELECT  * FROM corpdetat WHERE titre='" + corpdetat.getTitre()+"'";
        System.out.println(reuet);
        List<CorpDetat> corpDetats = load(reuet);
        if (corpDetats != null) {
            return corpDetats.get(0);
        }
        return null;
    }

    public List<CorpDetat> finAll() throws SQLException {
        String requet = "SELECT * FROM corpdetat  ";
        System.out.println(requet);
        List<CorpDetat> corpDetats = load(requet);
        if (!corpDetats.isEmpty()) {
            return corpDetats;
        }
        return null;
    }

}
