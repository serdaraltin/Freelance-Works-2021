package Model;

public class Urun {

    private int no;
    private String ad;
    private String birim;
    private int fiyat;

    public Urun() {
    }

    public Urun(int no) {
        this.no = no;
    }

    
    public Urun(int no, String ad, String birim, int fiyat) {
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

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return no + "," + ad + "," + birim + "," + fiyat;
    }

}
