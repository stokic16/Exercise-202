

package exercise_202;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * @author Kilian Stöckler
 */
public class SenderTableModel extends AbstractTableModel{
    
    private String[] names= {"Sender","Frequenz","Band"};
    private ArrayList<Sender> senders = new ArrayList<>();
    
    public void add(Sender s){
        senders.add(s);
        fireTableRowsInserted(senders.size()-1, senders.size()-1);
    }
    

    public void hideBand(){
        names = new String[] {"Sender","Frequenz"};
        fireTableStructureChanged();
    }
    
    public void showBand(){
        names = new String[] {"Sender","Frequenz","Band"};
        fireTableStructureChanged();
    }

    @Override
    public int getRowCount() {
        return senders.size();
    }

    @Override
    public int getColumnCount() {
        return names.length;
    }

    @Override
    public String getColumnName(int column) {
        return names[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return senders.get(rowIndex);
    }

}
