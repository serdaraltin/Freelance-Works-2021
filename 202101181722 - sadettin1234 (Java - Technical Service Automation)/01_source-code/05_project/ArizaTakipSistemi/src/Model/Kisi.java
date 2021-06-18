package Model;

public class Kisi {

    private String tcno;
    private String ad;
    private String soyad;

    public Kisi() {
    }

    public Kisi(String tcno, String ad, String soyad) {
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
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

    @Override
    public String toString() {
        return "Tc No   : " + tcno +
               "\nAd      : " + ad +
               "\nSoyad   : " + soyad;
    }

}
