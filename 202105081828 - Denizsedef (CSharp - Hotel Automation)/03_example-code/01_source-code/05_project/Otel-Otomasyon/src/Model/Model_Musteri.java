package Model;

public class Model_Musteri extends Model_Main {

    private String tcno;
    private String ad;
    private String soyad;
    private String telefon;
    private String adres;

    public Model_Musteri() {
         super.setTabloAd("musteri");
    }

    public Model_Musteri(int Id) {
        super(Id);
    }

    public Model_Musteri(int Id, String tcno, String ad, String soyad, String telefon, String adres) {
        super(Id);
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.adres = adres;
    }

    public Model_Musteri(String tcno, String ad, String soyad, String telefon, String adres) {
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.adres = adres;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getId() {
        return super.getId();
    }

    public void setId(int Id) {
        super.setId(Id);
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), tcno, ad, soyad, telefon, adres};
    }

    @Override
    public String toString() {
        return "Model_Musteri{" + "Id=" + super.getId() + "tcno=" + tcno + ", ad=" + ad + ", soyad=" + soyad + ", telefon=" + telefon + ", adres=" + adres + '}';
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "TC No", "Ad", "Soyad", "Telefon", "Adres"};
    }

}
