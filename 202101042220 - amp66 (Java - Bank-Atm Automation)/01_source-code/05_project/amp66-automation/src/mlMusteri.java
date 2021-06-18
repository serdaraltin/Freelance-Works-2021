

public class mlMusteri extends amlMain {

    private String unvan, tcno, ad, soyad, dogum, telefon, eposta, adres;

    public mlMusteri() {
        super.setblad("musteri");
        this.unvan = "standart";
    }

    public mlMusteri(String tcno) {
        this.tcno = tcno;
    }

    public mlMusteri(int id) {
        super(id);
    }

    
    public mlMusteri(int id, String unvan, String tcno, String ad, String soyad, String dogum, String telefon, String eposta, String adres) {
        super.setId(id);
        this.unvan = unvan;
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
        this.dogum = dogum;
        this.telefon = telefon;
        this.eposta = eposta;
        this.adres = adres;
    }

    public mlMusteri(String tcno, String ad, String soyad, String dogum, String telefon, String eposta, String adres) {
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
        this.dogum = dogum;
        this.telefon = telefon;
        this.eposta = eposta;
        this.adres = adres;
        this.unvan = "standart";
    }

    public mlMusteri(String unvan, String tcno, String ad, String soyad, String dogum, String telefon, String eposta, String adres) {
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
        return "Model_Musteri{" + "id=" + super.getId() + ", unvan=" + unvan + ", tcno=" + tcno + ", ad=" + ad + ", soyad=" + soyad + ", dogum=" + dogum + ", telefon=" + telefon + ", eposta=" + eposta + ", adres=" + adres + '}';
    }

    @Override
    public String[] gettablokolon() {
        return new String[]{"id", "Ünvan", "TC No", "Ad", "Soyad", "Doğum Tarihi", "Telefon", "Eposta", "Adres"};
    }

    @Override
    public Object[] getveri() {
        return new Object[]{super.getId(), unvan, tcno, ad, soyad, dogum, telefon, eposta, adres};
    }

}
