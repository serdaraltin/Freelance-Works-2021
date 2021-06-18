package Model;

public class Model_Kullanici {

    private int Id;
    private String kullaniciAd;
    private String parola;

    public Model_Kullanici(int Id, String kullaniciAd, String parola) {
        this.Id = Id;
        this.kullaniciAd = kullaniciAd;
        this.parola = parola;
    }

    public Model_Kullanici(String kullaniciAd, String parola) {

        this.kullaniciAd = kullaniciAd;
        this.parola = parola;
    }

    public Model_Kullanici() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getKullaniciAd() {
        return kullaniciAd;
    }

    public void setKullaniciAd(String kullaniciAd) {
        this.kullaniciAd = kullaniciAd;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Model_Kullanici{" + "Id=" + Id + ", kullaniciAd=" + kullaniciAd + ", parola=" + parola + '}';
    }

    public Object[] toObject() {
        return new Object[]{Id, kullaniciAd, parola};
    }

}
