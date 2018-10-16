

package exercise_202;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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

    public void save(File f) throws Exception{
        FileOutputStream fos = new  FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Sender sender : senders) {
            System.out.println("true");
            oos.writeObject(sender);
        }
        oos.flush();
        oos.close();
        fos.flush();
        fos.close();
    }
    
    public void load(File f)throws Exception{
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object input=null;
        try{
            while((input=ois.readObject())!=null){
                if(input instanceof Sender){
                    senders.add((Sender)input);
                }
            }
        }catch(EOFException e){
            e.printStackTrace();
        }
        fis.close();
        ois.close();
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
