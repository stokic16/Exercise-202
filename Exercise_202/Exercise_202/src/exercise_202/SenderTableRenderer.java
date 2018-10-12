

package exercise_202;

import exercise_202.Sender.Band;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * @author Kilian Stöckler
 */
public class SenderTableRenderer implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        if(value instanceof Sender){
            Sender sender =(Sender) value;
            if(sender.getBand()==Band.AM){
                label.setBackground(Color.blue);
            }else{
                label.setBackground(Color.red);
            }
            switch(column){
                case 0: label.setText(sender.getName());break;
                case 1: label.setText(String.format("%.2f",sender.getFrequenz()));break;
                case 2: label.setText(sender.getBand().name());
            }
        }
        return label;
    }

}
