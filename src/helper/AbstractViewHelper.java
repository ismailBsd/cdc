/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dell
 */
public abstract class AbstractViewHelper<T> extends AbstractTableModel {

    protected String[] titres;
    protected List<T> list = new ArrayList<T>();
    protected JTable jTable = new JTable();

    public JTable getjTable() {
        return jTable;
    }

    public AbstractViewHelper() {
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

    public AbstractViewHelper(String[] titres) {
        this.titres = titres;
        
    }

    public AbstractViewHelper(String[] titres, JTable jTable) {
        this.titres = titres;
        this.jTable = jTable;
    }

    public void save(T t) {
        list.add(t);
        for (int i = 0; i < titres.length; i++) {
            fireTableRowsInserted(titres.length - 1, i);
        }
    }

    public void remove(T t) {
        int selected = jTable.getSelectedRow();
        list.remove(selected);
        for (int i = 0; i < titres.length; i++) {
            fireTableRowsDeleted(selected, i);

        }
    }

    public void update(T t) {
        int selected = jTable.getSelectedRow();
        list.set(selected, t);
        for (int i = 0; i < titres.length; i++) {
            fireTableRowsUpdated(selected, i);
        }
    }

    public T getSelected() {
        return list.get(jTable.getSelectedRow());
    }

    @Override
    public int getRowCount() {
        if (list!=null)
        return list.size();
        return -1;
        
    }

    @Override
    public int getColumnCount() {
        return titres.length;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public T getValueAt(int rowIndex) {
        if (rowIndex < list.size()) {
            return list.get(rowIndex);
        }

        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return titres[columnIndex];
    }

    public String[] getTitres() {
        return titres;
    }

    public void setTitres(String[] titres) {
        this.titres = titres;
    }
}
