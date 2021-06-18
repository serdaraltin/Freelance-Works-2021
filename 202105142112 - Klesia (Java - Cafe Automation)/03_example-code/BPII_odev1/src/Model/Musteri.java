package Model;

public class Musteri {
    private String tcNo;
    private String ad;
    private String soyad;
    private String telefon;
    private String eposta;
    private String adres;

    public Musteri() {
    }

    
    public Musteri(String tcNo, String ad, String soyad, String telefon, String eposta, String adres) {
        this.tcNo = tcNo;
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.eposta = eposta;
        this.adres = adres;
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
        return "Musteri{" + "tcNo=" + tcNo + ", ad=" + ad + ", soyad=" + soyad + ", telefon=" + telefon + ", eposta=" + eposta + ", adres=" + adres + '}';
    }

    
}
