package Interface;

import java.util.ArrayList;
import javax.swing.JTable;

public interface Interface_Sub<T> {

    public ArrayList<T> Listele(JTable Tablo);

    public ArrayList<T> Ara(JTable Tablo, String aranan);

    public boolean Ekle(T model);

    public boolean Guncelle(T model);

    public T Getir(T model);

}
