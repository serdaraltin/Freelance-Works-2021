package Model;

public class Urun {

    private int no;
    private String ad;
    private String birim;
    private float fiyat;

    public Urun() {
    }

    public Urun(int no, String ad, String birim, float fiyat) {
        this.no = no;
        this.ad = ad;
        this.birim = birim;
        this.fiyat = fiyat;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public float getFiyat() {
        return fiyat;
    }

    public void setFiyat(float fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "Urun{" + "no=" + no + ", ad=" + ad + ", birim=" + birim + ", fiyat=" + fiyat + '}';
    }

}
