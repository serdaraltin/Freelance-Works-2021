

import java.util.ArrayList;
import javax.swing.JTable;

public interface iSub<T> {

    public ArrayList<T> KayitlariListele(JTable Tablo);

    public ArrayList<T> KayitAra(JTable Tablo, String aranan);

    public boolean KayitEkle(T model);

    public boolean KayitGuncelle(T model);

    public T KayitBilgisi(T model);

}
