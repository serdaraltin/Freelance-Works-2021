
public class Musteri {

    private String tcno;
    private String ad;
    private String soyad;
    private String telefon;
    private String eposta;
    private String sehir;

    public Musteri() {
    }

    public Musteri(String tcno, String ad, String soyad, String telefon, String eposta, String sehir) {
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.eposta = eposta;
        this.sehir = sehir;
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

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    @Override
    public String toString() {
        return "TC No   : " + tcno
                + "\nAd      : " + ad
                + "\nSoyad   : " + soyad
                + "\nTelefon : " + telefon
                + "\nEposta  : " + eposta
                + "\nŞehir   : " + sehir;
    }

}
