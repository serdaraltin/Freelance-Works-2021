package Model;

public class Yonetici {

    private String kullaniciAd;
    private String parola;

    public Yonetici() {
    }

    public Yonetici(String kullaniciAd, String parola) {
        this.kullaniciAd = kullaniciAd;
        this.parola = parola;
    }

    public String getKullaniciAd() {
        return kullaniciAd;
    }

    public void setKullaniciAd(String kullaniciAd) {
        this.kullaniciAd = kullaniciAd;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Yonetici{" + "kullaniciAd=" + kullaniciAd + ", parola=" + parola + '}';
    }

}
