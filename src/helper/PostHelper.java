/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helper;

import bean.Post;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author kamal
 */
public class PostHelper extends AbstractViewHelper<Post>{
    
  public PostHelper(JTable jTable, List<Post> posts) {
        super(new String[]{ "post"});
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
