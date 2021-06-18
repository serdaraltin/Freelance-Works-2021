package Model;

public class Model_Masa extends Model_Main {

    private String ad;
    private int kapasite;
    private String tur;

    public Model_Masa(int Id) {
        super(Id);
    }

    public Model_Masa(int Id, String ad, int kapasite, String tur) {
        super(Id);
        this.ad = ad;
        this.kapasite = kapasite;
        this.tur = tur;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    @Override
    public String toString() {
        return "Model_Masa{" + "Id=" + super.getId() + " ,ad=" + ad + ", kapasite=" + kapasite + ", tur=" + tur + '}';
    }

    @Override
    public Object[] getNesne() {
        return new Object[]{super.getId(), ad, kapasite, tur};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id","Ad","Kapasite","Tür"};
    }

}
