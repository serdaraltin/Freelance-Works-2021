
public class Ders {

    private String ad;
    private int kredi;

    public Ders(String ad, int kredi) {
        this.ad = ad;
        this.kredi = kredi;
    }

    public Ders() {
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getKredi() {
        return kredi;
    }

    public void setKredi(int kredi) {
        this.kredi = kredi;
    }

    @Override
    public String toString() {
        return "Ders{" + "ad=" + ad + ", kredi=" + kredi + '}';
    }

}
