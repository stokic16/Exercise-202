package bl;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lb
 */
public class TableModel extends AbstractTableModel {

    private static String[] colNames = {};
    private ArrayList<Data> dataArray = new ArrayList<>();

    public void addData(Data d) {
        dataArray.add(d);
        fireTableDataChanged();
    }

    public void updateNumCols(int numCols) {
        colNames = new String[numCols];
        for (int i = 0; i < numCols; i++) {
            colNames[i] = "Col " + i;
        }

        fireTableStructureChanged();
    }

    @Override
    public String getColumnName(int i) {
        return colNames[i];
    }

    @Override
    public int getRowCount() {
        return dataArray.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return dataArray.get(row).getColValue(col);
    }

}
