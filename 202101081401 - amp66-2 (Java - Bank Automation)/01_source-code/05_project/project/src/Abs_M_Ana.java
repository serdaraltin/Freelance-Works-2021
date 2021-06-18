public abstract class Abs_M_Ana implements IModel {

    int Id;
    private String[] kolonlar;
    private String tabloAd;

    public Abs_M_Ana() {

    }

    public Abs_M_Ana(int Id, String[] kolonlar, String tabloAd) {
        this.Id = Id;
        this.kolonlar = kolonlar;
        this.tabloAd = tabloAd;
    }

    public Abs_M_Ana(int Id) {
        this.Id = Id;
    }

    public Abs_M_Ana(String tabloAd) {
        this.tabloAd = tabloAd;
    }

    public Abs_M_Ana(String[] kolonlar, String tabloAd) {
        this.kolonlar = kolonlar;
        this.tabloAd = tabloAd;
    }

    public String getTabloAd() {
        return tabloAd;
    }

    public void setTabloAd(String tabloAd) {
        this.tabloAd = tabloAd;
    }

    public String[] getKolonlar() {
        return kolonlar;
    }

    public void setKolonlar(String[] kolonlar) {
        this.kolonlar = kolonlar;
    }

    @Override
    public int getId() {
        return this.Id;
    }

    @Override
    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "Model_Main{" + "Id=" + Id + ", kolonlar=" + kolonlar + ", tabloAd=" + tabloAd + '}';
    }

    @Override
    public Object[] getObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
