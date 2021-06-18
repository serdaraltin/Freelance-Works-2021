package Model;

public class Ariza {

    private Musteri musteri;
    private String tur;
    private int ucret;
    private String kayitTarih;
    private String durum;
    private String teslimTarih;

    public Ariza() {
        this.durum = "henuz onarilmadi";
        this.teslimTarih = "teslim edilmedi";
    }

    public Ariza(Musteri musteri, String tur, int ucret, String kayitTarih) {
        this.musteri = musteri;
        this.tur = tur;
        this.ucret = ucret;
        this.kayitTarih = kayitTarih;
        this.durum = "henuz onarilmadi";
        this.teslimTarih = "teslim edilmedi";
    }

    public Ariza(Musteri musteri, String tur, int ucret, String kayitTarih, String durum, String teslimTarih) {
        this.musteri = musteri;
        this.tur = tur;
        this.ucret = ucret;
        this.kayitTarih = kayitTarih;
        this.durum = durum;
        this.teslimTarih = teslimTarih;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getKayitTarih() {
        return kayitTarih;
    }

    public void setKayitTarih(String kayitTarih) {
        this.kayitTarih = kayitTarih;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public String getTeslimTarih() {
        return teslimTarih;
    }

    public void setTeslimTarih(String teslimTarih) {
        this.teslimTarih = teslimTarih;
    }

    public int getUcret() {
        return ucret;
    }

    public void setUcret(int ucret) {
        this.ucret = ucret;
    }

    @Override
    public String toString() {
        return "Musteri Ad    : " + musteri.getAd()
                + "\nMusteri Soyad : " + musteri.getSoyad()
                + "\nTur           : " + tur
                + "\nUcret         : " + ucret + " TL"
                + "\nKayit Tarih   : " + kayitTarih
                + "\nDurum         : " + durum
                + "\nTeslim Tarih  : " + teslimTarih;
    }

}
