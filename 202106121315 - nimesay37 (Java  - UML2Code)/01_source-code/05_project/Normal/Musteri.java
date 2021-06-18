
public class Musteri {

    private String adi;
    private Hesap hesap;

    public Musteri(String ad, Hesap h) {
        this.adi = ad;
        this.hesap = h;
    }

    public int getHesapNo() {
        return hesap.numara;
    }

}
