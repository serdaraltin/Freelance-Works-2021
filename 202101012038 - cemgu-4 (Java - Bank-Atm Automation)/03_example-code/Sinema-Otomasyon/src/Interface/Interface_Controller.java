package Interface;

import java.util.ArrayList;
import javax.swing.JTable;

public interface Interface_Controller<T> {

    public boolean Kontrol(T veri);

    public ArrayList<T> Listele(JTable Tablo);

    public ArrayList<T> Ara(JTable Tablo, String aranan);

    public boolean Ekle(T veri);

    public boolean Guncelle(T veri);

    public boolean Sil(T veri);

    public T Getir(T veri);

}
