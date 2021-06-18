package Controller;

public interface IController<T> {

    public boolean Kontrol(T[] kayitlar, T kayit);

    public int Ekle(T[] kayitlar, int sonIndex, T kayit);

    public int Degistir(T[] kayitlar, T kayit);

    public int Sil(T[] kayitlar, T kayit);

    public int Getir(T[] kayitlar, T kayit);

    public void Listele(T[] kayitlar);

}
