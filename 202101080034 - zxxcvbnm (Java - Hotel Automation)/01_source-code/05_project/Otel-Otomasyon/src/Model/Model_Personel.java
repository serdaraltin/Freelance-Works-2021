package Model;

public class Model_Personel extends Model_Main {

    private String kullanici_ad;
    private String parola;
    private String tcno;
    private String ad;
    private String soyad;
    private String telefon;
    private String adres;
    private int maas;

    public Model_Personel() {
        super.setTabloAd("personel");
    }

    public Model_Personel(int Id) {
        super(Id);
    }

    public Model_Personel(int Id,String kullanici_ad, String parola, String tcno, String ad, String soyad, String telefon, String adres, int maas) {
        super(Id);
        this.kullanici_ad = kullanici_ad;
        this.parola = parola;
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.adres = adres;
        this.maas = maas;
    }

    public Model_Personel(String kullanici_ad, String parola, String tcno, String ad, String soyad, String telefon, String adres, int maas) {
        this.kullanici_ad = kullanici_ad;
        this.parola = parola;
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.adres = adres;
        this.maas = maas;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getKullanici_ad() {
        return kullanici_ad;
    }

    public void setKullanici_ad(String kullanici_ad) {
        this.kullanici_ad = kullanici_ad;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int Id) {
        super.setId(Id);
    }

    @Override
    public String toString() {
        return "Model_Personel{" + "Id=" + super.getId() + ",kullanici_ad=" + kullanici_ad + ", parola=" + parola + ", tcno=" + tcno + ", ad=" + ad + ", soyad=" + soyad + ", telefon=" + telefon + ", adres=" + adres + ", maas=" + maas + '}';
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), kullanici_ad, parola, tcno, ad, soyad, telefon, adres, maas};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Kullanıcı Adı", "Parola", "TC No", "Ad", "Soyad", "Telefon", "Adres", "Maaş"};
    }

    @Override
    public void setTabloAd(String tabloAd) {
        super.setTabloAd("personel");
    }

}
