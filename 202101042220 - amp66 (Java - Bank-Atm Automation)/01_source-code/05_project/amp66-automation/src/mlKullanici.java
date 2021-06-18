

public class mlKullanici extends amlMain {

    private String tip;
    private String kullanici;
    private String parola;

    public mlKullanici() {
        super.setblad("kullanici");
    }

    public mlKullanici(int id) {
        super(id);
    }

    public mlKullanici(int id, String tip, String kullanici, String parola) {
        super.setId(id);
        this.tip = tip;
        this.kullanici = kullanici;
        this.parola = parola;
    }

    public mlKullanici(String tip, String kullanici, String parola) {
        this.kullanici = kullanici;
        this.parola = parola;
        this.tip = tip;
    }

    public mlKullanici(String kullanici, String parola) {
        this.kullanici = kullanici;
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
        return kullanici;
    }

    public void setKullanici_ad(String kullanici) {
        this.kullanici = kullanici;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Model_Kullanici{" + "id=" + super.getId() + ", tip=" + tip + ", kullanici=" + kullanici + ", parola=" + parola + '}';
    }

    @Override
    public String[] gettablokolon() {
        return new String[]{"id", "Tip", "Kullanıcı Adı", "Parola"};
    }

    @Override
    public Object[] getveri() {
        return new Object[]{super.getId(), tip, kullanici, parola};
    }

}
