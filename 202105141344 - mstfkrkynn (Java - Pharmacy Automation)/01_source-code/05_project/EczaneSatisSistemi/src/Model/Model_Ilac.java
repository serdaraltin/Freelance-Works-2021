package Model;

//Model_Main sınıfından genişletilen (kalıtılan) sınıf
public class Model_Ilac extends Model_Main {

    //İlgili değişkenlerin tanımlanması
    private String barkod;
    private String ad;
    private String marka;
    private String tur;
    private int fiyat;

    //Parametresiz kurucu tanımlanması
    public Model_Ilac() {
        //üst sınıfın tabloAd değişkeninin ayarlanması
        super.setTabloAd("ilac");
    }

    //Parametreli kurucu ilgili değerlerin ayarlanması (kayıt için)
    public Model_Ilac(String barkod, String ad, String marka, String tur, int fiyat) {
        this.barkod = barkod;
        this.ad = ad;
        this.marka = marka;
        this.tur = tur;
        this.fiyat = fiyat;
    }

    //Parametreli kurucu ilgili değerlerin ayarlanması (güncelleme için)
    public Model_Ilac(int Id, String barkod, String ad, String marka, String tur, int fiyat) {
        super(Id);
        this.barkod = barkod;
        this.ad = ad;
        this.marka = marka;
        this.tur = tur;
        this.fiyat = fiyat;
    }

    public Model_Ilac(int Id) {
        super(Id);
    }

    public String getBarkod() {
        return barkod;
    }

    public void setBarkod(String barkod) {
        this.barkod = barkod;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "Model_Ilac{" + "barkod=" + barkod + ", ad=" + ad + ", marka=" + marka + ", tur=" + tur + ", fiyat=" + fiyat + '}';
    }

    //Bu method ile sınıfa ve katılttığı sınıfa ait değeler bir dizi halinde geriye döndürülmekte
    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), barkod, ad, marka, tur, fiyat};
    }

    //Bu method ile sınıfa ve katılttığı sınıfa ait başlık isimleri bir dizi halinde geriye döndürülmekte
    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Barkod", "Ad", "Marka", "Tur", "Fiyat"};
    }

}
