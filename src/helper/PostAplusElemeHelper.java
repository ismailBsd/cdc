/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helper;

import bean.PostAplusEleme;
import bean.PostSolidaire;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author kamal
 */

    public class PostAplusElemeHelper  extends AbstractViewHelper<PostAplusEleme>{
    public PostAplusElemeHelper(JTable jTable, List<PostAplusEleme> posts) {
        super(new String[]{ "PostAplusEleme"});
        this.jTable = jTable;
        this.list = posts;
    }

   
@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < list.size()) {
                    return list.get(rowIndex).getTitre();
        }
        return null;
    }
}

