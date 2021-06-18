package Model;

public class Model_Departman extends Model_Main {

    private String ad;
    private String amac;
    private String aciklama;

    public Model_Departman() {
        super.setTabloAd("departman");
    }

    public Model_Departman(int Id) {
        super(Id);
    }

    public Model_Departman(int Id, String ad, String amac, String aciklama) {
        super(Id);
        this.ad = ad;
        this.amac = amac;
        this.aciklama = aciklama;
    }

    public Model_Departman(String ad, String amac, String aciklama) {
        this.ad = ad;
        this.amac = amac;
        this.aciklama = aciklama;
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), ad, amac, aciklama};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Ad", "Amaç", "Açıklama"};
    }

    @Override
    public String toString() {
        return "Model_Departman{" + "ad=" + ad + ", amac=" + amac + ", aciklama=" + aciklama + '}';
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAmac() {
        return amac;
    }

    public void setAmac(String amac) {
        this.amac = amac;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

}
