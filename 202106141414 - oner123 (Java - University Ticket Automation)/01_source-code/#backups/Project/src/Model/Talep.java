package Model;

public class Talep {

    private int no;
    private int hesapNo;
    private int tur;
    private String baslik;
    private String icerik;
    private String tarih;
    private int durum;

    public Talep() {
    }

    public Talep(String[] veri) {
        this.no = Integer.valueOf(veri[0]);
        this.hesapNo = Integer.valueOf(veri[1]);
        this.tur = Integer.valueOf(veri[2]);
        this.baslik = veri[3];
        this.icerik = veri[4];
        this.tarih = veri[5];
        this.durum = Integer.valueOf(veri[6]);
    }

    public Talep(int no, int hesapNo, int tur, String baslik, String icerik, String tarih, int durum) {

        this.no = no;
        this.hesapNo = hesapNo;
        this.tur = tur;
        this.baslik = baslik;
        this.icerik = icerik;
        this.tarih = tarih;
        this.durum = durum;
    }

    @Override
    public String toString() {
        return no + "," + hesapNo + "," + tur + "," + baslik + "," + icerik + "," + tarih + "," + durum;
    }

    public String[] getColumn() {
        return new String[]{"No", "Hesap No", "Tür", "Başlık", "İçerik", "Tarih", "Durum"};
    }

    public Object[] getObject() {
        String sdurum = "Beklemede";
        if (durum == 1) {
            sdurum = "Cevaplandi";
        }
        String stur = "Öğrenci";
        if (tur == 1) {
            stur = "Öğretim Görevlisi";
        }
        
        return new Object[]{hesapNo, stur, baslik, icerik, tarih, sdurum};
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getHesapNo() {
        return hesapNo;
    }

    public void setHesapNo(int hesapNo) {
        this.hesapNo = hesapNo;
    }

    public int getTur() {
        return tur;
    }

    public void setTur(int tur) {
        this.tur = tur;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public int getDurum() {
        return durum;
    }

    public void setDurum(int durum) {
        this.durum = durum;
    }

}
