/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helper;

import bean.PostSolidaire;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author kamal
 */
public class PostSolidaireHelper  extends AbstractViewHelper<PostSolidaire>{
    public PostSolidaireHelper(JTable jTable, List<PostSolidaire >posts) {
        super(new String[]{ "postsolaidaire"});
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
