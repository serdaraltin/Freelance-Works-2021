package Interface;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface IController<T> {

    public boolean Ekle(ArrayList<T> liste, T veri);

    public boolean Sil(ArrayList<T> liste,int no);

    public boolean Guncelle(ArrayList<T> liste, T veri);

    public DefaultTableModel Listele(ArrayList<T> liste, JTable tablo);

    public T Sec(ArrayList<T> liste, int no);
}
