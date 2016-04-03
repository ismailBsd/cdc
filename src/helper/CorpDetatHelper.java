/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.CorpDetat;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author kamal
 */
public class CorpDetatHelper extends AbstractViewHelper<CorpDetat>{
 public CorpDetatHelper(JTable jTable, List<CorpDetat> corpDetats) {
        super(new String[]{ "Corp Detat"});
        this.jTable = jTable;
        this.list = corpDetats;
    }

   
@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < list.size()) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getTitre();
                case 1:
                   return null;
              
                default:
                    return null;
            }
        }
        return null;
    }
   
}
