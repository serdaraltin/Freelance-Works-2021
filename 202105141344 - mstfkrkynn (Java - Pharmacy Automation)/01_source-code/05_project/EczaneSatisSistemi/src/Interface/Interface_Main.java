package Interface;

import Model.Model_Main;

//Bu interface diğer Controller sınıfları için bir şablon görevi görmektedir
public interface Interface_Main extends Interface_Sub<Model_Main>{
    //Gelen Id değerine ait kaydın varolma durumunun kontrolü
    public boolean Kontrol(int Id);
    //Gelen Id değerindeki kaydın silinmesi
    public boolean Sil(int Id);
    //Gelen Id değeri ile ilgili güncelleme penceresinin açılması
    public void Guncelle(int Id);
    //İlgili kayıt penceresinin açılması
    public void Ac();

}
