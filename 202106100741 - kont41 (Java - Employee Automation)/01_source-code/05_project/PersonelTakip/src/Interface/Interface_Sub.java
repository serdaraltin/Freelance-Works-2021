package Interface;

import java.util.ArrayList;
import javax.swing.JTable;

//Bu interface diğer Controller sınıfları için bir alt şablon görevi görmektedir
public interface Interface_Sub<T> {
    //Verilen tabloya ilgili tablodaki tüm kayıtları listeleme ve kayıları ilgili model türünde bir ArrayList olarak dönme
    public ArrayList<T> Listele(JTable Tablo);
    //Verilen tabloya ilgili tablodaki aranan değeri barındıran tüm kayıtları listeleme ve kayıları ilgili model türünde bir ArrayList olarak dönme
    public ArrayList<T> Ara(JTable Tablo, String aranan);
    //İlgili tabloya ilgili kaydı ekleme
    public boolean Ekle(T model);
    //İlgili tablodan ilgili kaydı güncelleme (Id bilgisine göre)
    public boolean Guncelle(T model);
    //Opsiyonel olarak model (sınıf, kayıt) ait varsa spesifik özellik ile kaydın bulunması ve geriye döndürülmesi
    public T Getir(T model);

}
