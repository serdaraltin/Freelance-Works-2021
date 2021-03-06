package Model;

public class Model_Musteri extends Model_Main {

    private String unvan, tcno, ad, soyad, dogum, telefon, eposta, adres;

    public Model_Musteri() {
        super.setTabloAd("musteri");
        this.unvan = "standart";
    }

    public Model_Musteri(String tcno) {
        this.tcno = tcno;
    }

    public Model_Musteri(int Id) {
        super(Id);
    }

    
    public Model_Musteri(int Id, String unvan, String tcno, String ad, String soyad, String dogum, String telefon, String eposta, String adres) {
        super.setId(Id);
        this.unvan = unvan;
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
        this.dogum = dogum;
        this.telefon = telefon;
        this.eposta = eposta;
        this.adres = adres;
    }

    public Model_Musteri(String tcno, String ad, String soyad, String dogum, String telefon, String eposta, String adres) {
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
        this.dogum = dogum;
        this.telefon = telefon;
        this.eposta = eposta;
        this.adres = adres;
        this.unvan = "standart";
    }

    public Model_Musteri(String unvan, String tcno, String ad, String soyad, String dogum, String telefon, String eposta, String adres) {
        this.unvan = unvan;
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
        this.dogum = dogum;
        this.telefon = telefon;
        this.eposta = eposta;
        this.adres = adres;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getTcno() {
        return tcno;
    }

    public void setTcno(String tcno) {
        this.tcno = tcno;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getDogum() {
        return dogum;
    }

    public void setDogum(String dogum) {
        this.dogum = dogum;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Model_Musteri{" + "Id=" + super.getId() + ", unvan=" + unvan + ", tcno=" + tcno + ", ad=" + ad + ", soyad=" + soyad + ", dogum=" + dogum + ", telefon=" + telefon + ", eposta=" + eposta + ", adres=" + adres + '}';
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "??nvan", "TC No", "Ad", "Soyad", "Do??um Tarihi", "Telefon", "Eposta", "Adres"};
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), unvan, tcno, ad, soyad, dogum, telefon, eposta, adres};
    }

}
