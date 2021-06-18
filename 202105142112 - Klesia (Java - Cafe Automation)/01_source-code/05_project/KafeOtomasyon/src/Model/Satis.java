package Model;

public class Satis {

    private int satisNo;
    private String garsonTcNo;
    private int urunNo;
    private int adet;
    private int tutar;
    private String tarih;

    public Satis() {
    }

    public Satis(int satisNo, String garsonTcNo, int urunNo, int adet, int tutar, String tarih) {
        this.satisNo = satisNo;
        this.garsonTcNo = garsonTcNo;
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

    public String getGarsonTcNo() {
        return garsonTcNo;
    }

    public void setGarsonTcNo(String garsonTcNo) {
        this.garsonTcNo = garsonTcNo;
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

    public int getTutar() {
        return tutar;
    }

    public void setTutar(int tutar) {
        this.tutar = tutar;
    }

    @Override
    public String toString() {
        return satisNo + "," + garsonTcNo + "," + urunNo + "," + adet + "," + tutar + "," + tarih;
    }

}
