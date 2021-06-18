
package Interface;

import java.util.ArrayList;
import javax.swing.JTable;

public interface Interface_Controller<T> {
    public ArrayList<T> Listele(JTable tablo);
    public ArrayList<T> Ara(JTable tablo, String aranan);
    public int Ekle(T veri);
    public T Guncelle(T veri);
    public boolean Sil(int Id);
    public T Getir(int Id);
    public int GetirIndex(T veri);
    public void Ac();
    public void Guncelle(int Id);
    
}
