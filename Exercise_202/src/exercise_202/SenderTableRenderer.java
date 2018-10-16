package exercise_202;

import exercise_202.Sender.Band;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * @author Kilian Stöckler
 */
public class SenderTableRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setFont(new Font("Arial", 1 | 2, 14));
        label.setForeground(Color.LIGHT_GRAY);
        if (value instanceof Sender) {
            Sender sender = (Sender) value;
            if (isSelected) {
               label.setBackground(Color.BLACK);
               label.setForeground(Color.white);
            } else {
                if (sender.getBand() == Band.AM) {
                    label.setBackground(Color.BLUE);
                } else {
                    label.setBackground(Color.RED);
                }
            }

            switch (column) {
                case 0:
                    label.setText(sender.getName());
                    break;
                case 1:
                    label.setText(String.format("%.2f", sender.getFrequenz()));
                    break;
                case 2:
                    label.setText(sender.getBand().name());
            }
        }
        return label;
    }

}
