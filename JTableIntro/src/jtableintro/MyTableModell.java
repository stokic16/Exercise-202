

package jtableintro;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * @author Kilian Stöckler
 */
public class MyTableModell extends AbstractTableModel{
    
    private static String[] colName ={"Firstname","Lastname","Birthday","Haircolor"};
    
    private ArrayList<Student> students = new ArrayList<>();
    
    public void add(Student e){
        students.add(e);
        fireTableRowsInserted(students.size()-1, students.size()-1);
    }

    @Override
    public String getColumnName(int column) {
        return colName[column];
    }

    
    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student s = students.get(rowIndex);
        return s;
//        switch(columnIndex){
//            case 0: return s.getFirstname();
//            case 1: return s.getLastname();
//            case 2: return s.getBirthday().toString();
//            case 3: return s.getHairColor().toString();
//            default: return "???";
//        }
    }

}
