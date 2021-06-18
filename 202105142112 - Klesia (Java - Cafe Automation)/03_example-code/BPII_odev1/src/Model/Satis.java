package Model;

public class Satis {

    private int satisNo;
    private String musteriTcNo;
    private int urunNo;
    private int adet;
    private float tutar;
    private String tarih;

    public Satis() {
    }

    public Satis(int satisNo, String musteriTcNo, int urunNo, int adet, float tutar, String tarih) {
        this.satisNo = satisNo;
        this.musteriTcNo = musteriTcNo;
        this.urunNo = urunNo;
        this.adet = adet;
        this.tutar = tutar;
        this.tarih = tarih;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public int getSatisNo() {
        return satisNo;
    }

    public void setSatisNo(int satisNo) {
        this.satisNo = satisNo;
    }

    public String getMusteriTcNo() {
        return musteriTcNo;
    }

    public void setMusteriTcNo(String musteriTcNo) {
        this.musteriTcNo = musteriTcNo;
    }

    public int getUrunNo() {
        return urunNo;
    }

    public void setUrunNo(int urunNo) {
        this.urunNo = urunNo;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public float getTutar() {
        return tutar;
    }

    public void setTutar(float tutar) {
        this.tutar = tutar;
    }

    @Override
    public String toString() {
        return "Satis{" + "satisNo=" + satisNo + ", musteriTcNo=" + musteriTcNo + ", urunNo=" + urunNo + ", adet=" + adet + ", tutar=" + tutar + ", tarih=" + tarih + '}';
    }

}
