
public class Odeme {

    private Kredi kredi;
    private float miktar;
    private String tarih;

    public Odeme() {
    }

    public Odeme(Kredi kredi, float miktar, String tarih) {
        this.kredi = kredi;
        this.miktar = miktar;
        this.tarih = tarih;
    }

    public Kredi getKredi() {
        return kredi;
    }

    public void setKredi(Kredi kredi) {
        this.kredi = kredi;
    }

    public float getMiktar() {
        return miktar;
    }

    public void setMiktar(float miktar) {
        this.miktar = miktar;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    @Override
    public String toString() {
        return kredi
                + "\nÖdeme Miktar : " + miktar
                + "\nTarih        : " + tarih;
    }

}
