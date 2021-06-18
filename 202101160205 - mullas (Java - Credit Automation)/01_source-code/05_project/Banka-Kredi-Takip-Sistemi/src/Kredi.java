
public class Kredi {

    private Musteri musteri;
    private float krediMiktar;
    private String durum;

    public Kredi() {
    }

    public Kredi(Musteri musteri, float krediMiktar, String durum) {
        this.musteri = musteri;
        this.krediMiktar = krediMiktar;
        this.durum = durum;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public float getKrediMiktar() {
        return krediMiktar;
    }

    public void setKrediMiktar(float krediMiktar) {
        this.krediMiktar = krediMiktar;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    @Override
    public String toString() {
        return musteri
                + "\nKredi : " + krediMiktar
                + "\nDurum : " + durum;
    }

}
