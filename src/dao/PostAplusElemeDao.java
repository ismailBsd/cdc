/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import bean.CorpDetat;
import bean.PostAplusEleme;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * postapluseleme
 *
 * @author kamal
 */
public class PostAplusElemeDao {

    public int save(PostAplusEleme postAplusEleme) throws SQLException {
        String requet = "INSERT INTO postapluseleme VALUES('0',"
                + postAplusEleme.getCorpdetat().getId() + ",'" + postAplusEleme.getTitre()
                + "','" + postAplusEleme.getDescription() + "'," + postAplusEleme.getPrix() + ")";
        System.out.println(requet);
        return ConnectDB.exec(requet);
    }
    
    public int update(PostAplusEleme postAplusEleme) throws SQLException {
        
        String reuet = "UPDATE  postapluseleme SET titre='" + postAplusEleme.getTitre() + "'"
                + ",description='" + postAplusEleme.getDescription() + "',prix = '" + postAplusEleme.getPrix()
                + "' WHERE id=" + postAplusEleme.getId();
        System.out.println(reuet);
        return ConnectDB.exec(reuet);
    }
    
    public int delete(PostAplusEleme postAplusEleme) throws SQLException {
        String requet = "DELETE FROM  postapluseleme WHERE id=" + postAplusEleme.getId();
        System.out.println(requet);
        return ConnectDB.exec(requet);
    }
    
    public List<PostAplusEleme> load(String requet) throws SQLException {
        
        ResultSet resltset = ConnectDB.load(requet);
        List<PostAplusEleme> postAplusElemes = new ArrayList<>();
        while (resltset.next()) {
            PostAplusEleme loadpostAplusEleme = new PostAplusEleme(resltset.getInt("id"),resltset.getString("titre"), resltset.getString("description"));
            loadpostAplusEleme.setPrix(resltset.getDouble("prix"));
            loadpostAplusEleme.getCorpdetat().setId(resltset.getInt("idsup"));
            postAplusElemes.add(loadpostAplusEleme);
            
        }
        return postAplusElemes;
        
    }
    
    public List<PostAplusEleme> finAll() throws SQLException {
        String requet = "SELECT * FROM postapluseleme ";
        System.out.println(requet);
        List<PostAplusEleme> postAplusElemes = load(requet);
        if (!postAplusElemes.isEmpty()) {
            return postAplusElemes;
        }
        return null;
    }

    public List<PostAplusEleme> finAllByCorpDetat(CorpDetat corpDetat) throws SQLException {
        String requet = "SELECT * FROM postapluseleme WHERE idsup=" + corpDetat.getId();
        System.out.println(requet);
        List<PostAplusEleme> postAplusElemes = load(requet);
        if (!postAplusElemes.isEmpty()) {
            return postAplusElemes;
        }
        return null;
    }

    public PostAplusEleme find(PostAplusEleme aplusEleme) throws SQLException {
        String requet = "SELECT * FROM postapluseleme WHERE titre='" + aplusEleme.getTitre() + "'";
        System.out.println(requet);
        List<PostAplusEleme> postAplusElemes = load(requet);
        if (!postAplusElemes.isEmpty()) {
            return postAplusElemes.get(0);
        }
        return null;
    }    
}
