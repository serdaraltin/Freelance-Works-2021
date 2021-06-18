package MD;

public class MKullanici extends Abs_M_Ana {

    private String tip;
    private String kullanici_ad;
    private String parola;

    public MKullanici() {
        super.setTabloAd("kullanici");
    }

    public MKullanici(int Id) {
        super(Id);
    }

    public MKullanici(int Id, String tip, String kullanici_ad, String parola) {
        super.setId(Id);
        this.tip = tip;
        this.kullanici_ad = kullanici_ad;
        this.parola = parola;
    }

    public MKullanici(String tip, String kullanici_ad, String parola) {
        this.kullanici_ad = kullanici_ad;
        this.parola = parola;
        this.tip = tip;
    }

    public MKullanici(String kullanici_ad, String parola) {
        this.kullanici_ad = kullanici_ad;
        this.parola = parola;
        this.tip = "personel";
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getKullanici_ad() {
        return kullanici_ad;
    }

    public void setKullanici_ad(String kullanici_ad) {
        this.kullanici_ad = kullanici_ad;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Model_Kullanici{" + "Id=" + super.getId() + ", tip=" + tip + ", kullanici_ad=" + kullanici_ad + ", parola=" + parola + '}';
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Tip", "Kullanıcı Adı", "Parola"};
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), tip, kullanici_ad, parola};
    }

}
