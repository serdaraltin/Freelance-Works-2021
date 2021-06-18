package Model;

public class Kisi extends Hesap {

    private String tcNo;
    private String ad;
    private String soyad;
    private String cinsiyet;
    private String dogumTarih;
    private String telefon;
    private String eposta;
    private String adres;
    private String bolum;

    public Kisi() {
    }

    public Kisi(String[] veri) {
        super(Integer.valueOf(veri[0]), veri[1]);
        this.tcNo = veri[2];
        this.ad = veri[3];
        this.soyad = veri[4];
        this.cinsiyet = veri[5];
        this.dogumTarih = veri[6];
        this.telefon = veri[7];
        this.eposta = veri[8];
        this.adres = veri[9];
        this.bolum = veri[10];
    }

    public Kisi(int no, String parola, String tcNo, String ad, String soyad, String cinsiyet, String dogumTarih, String telefon, String eposta, String adres, String bolum) {
        super(no, parola);
        this.tcNo = tcNo;
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.dogumTarih = dogumTarih;
        this.telefon = telefon;
        this.eposta = eposta;
        this.adres = adres;
        this.bolum = bolum;
    }

    @Override
    public String toString() {
        return super.getNo() + "," + super.getParola() + "," + tcNo + "," + ad + "," + soyad + "," + cinsiyet + "," + dogumTarih + "," + telefon + "," + eposta + "," + adres + "," + bolum;
    }

    public Object[] getObject() {
        return new Object[]{super.getNo(), super.getParola(), tcNo, ad, soyad, cinsiyet, dogumTarih, telefon, eposta, adres, bolum};
    }

    public String[] getColumn() {
        return new String[]{"No", "Parola", "Tc No", "Ad", "Soyad", "Cinsiyet", "Doğum Tarih", "Telefon", "Eposta", "Adres", "Bolum"};
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
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

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getDogumTarih() {
        return dogumTarih;
    }

    public void setDogumTarih(String dogumTarih) {
        this.dogumTarih = dogumTarih;
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

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

}
