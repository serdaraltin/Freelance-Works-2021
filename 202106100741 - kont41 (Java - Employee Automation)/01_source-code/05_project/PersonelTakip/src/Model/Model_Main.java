package Model;

import Interface.Interface_Model;

//Bu sınıf diğer Model sınıfları için temel oluşturmaktadır
public abstract class Model_Main implements Interface_Model {

    //Genel olarak geçerli olan ilgili değişkenlerin tanımlanması
    int Id;
    private String[] kolonlar;
    private String tabloAd;

    //Boş kurucu (constractur)
    public Model_Main() {

    }

    //Tüm parametreleri alan kurucu (constractur)
    public Model_Main(int Id, String[] kolonlar, String tabloAd) {
        this.Id = Id;
        this.kolonlar = kolonlar;
        this.tabloAd = tabloAd;
    }

    //Sadece Id değerini alan kurucu (constractur)
    public Model_Main(int Id) {
        this.Id = Id;
    }

    //Sadece tablo adı değerini alan kurucu (constractur)
    public Model_Main(String tabloAd) {
        this.tabloAd = tabloAd;
    }

    //Sadece kolon adlarını ve tablo adını değerini alan kurucu (constractur)
    public Model_Main(String[] kolonlar, String tabloAd) {
        this.kolonlar = kolonlar;
        this.tabloAd = tabloAd;
    }

    //tabloAd değişkeni için get methodu
    public String getTabloAd() {
        return tabloAd;
    }

    //tabload değişkeni için set methodu
    public void setTabloAd(String tabloAd) {
        this.tabloAd = tabloAd;
    }

    //kolonlar değişkeni için get methodu
    public String[] getKolonlar() {
        return kolonlar;
    }

    //kolonlar değişkeni için set methodu
    public void setKolonlar(String[] kolonlar) {
        this.kolonlar = kolonlar;
    }

    //Id değişkeni için get methodu
    @Override
    public int getId() {
        return this.Id;
    }

    //Id değişkeni için set methodu
    @Override
    public void setId(int Id) {
        this.Id = Id;
    }

    //toString methodunun override edilmesi (ezilmesi)
    @Override
    public String toString() {
        return "Model_Main{" + "Id=" + Id + ", kolonlar=" + kolonlar + ", tabloAd=" + tabloAd + '}';
    }

    //getObject methodu (boş)
    @Override
    public Object[] getObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
