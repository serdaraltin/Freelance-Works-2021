
package Interface;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface IController<T> {
    public boolean Ekle(ArrayList<T> liste, T veri);
    public boolean Sil(ArrayList<T> liste, T veri);
    public boolean Guncelle(ArrayList<T> liste, T veri);
    public DefaultTableModel Listele(ArrayList<T> liste, JTable tablo);
    public boolean Ara(ArrayList<T> liste, T veri, JTable tablo);
    public T Sec(ArrayList<T> liste, T veri);
}
