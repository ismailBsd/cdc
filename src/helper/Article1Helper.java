/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.ArticleChp1;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Boolean;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author kamal
 */
public class Article1Helper extends AbstractViewHelper<ArticleChp1> {

    public Article1Helper(JTable jTable, List<ArticleChp1> articleChp1s) {
        super(new String[]{"Article chaitre1"});
        this.jTable = jTable;
        this.list = articleChp1s;

    }

//    private List<ArticleChp1> Articlecocher(List<ArticleChp1> articleChp1s) {
//
//        for (int i = 0; i < articleChp1s.size(); i++) {
//            articleChp1s.get(i).setC(false);
//        }
//        return articleChp1s;
//    }

    @Override

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < list.size()) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getTitre();
                default:
                    return null;
            }
        }
        return null;
    }
}
