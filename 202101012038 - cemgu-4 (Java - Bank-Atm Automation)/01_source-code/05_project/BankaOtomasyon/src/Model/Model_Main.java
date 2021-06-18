package Model;

import Interface.Interface_Model;

public abstract class Model_Main implements Interface_Model {

    int Id;
    private String[] kolonlar;
    private String tabloAd;

    public Model_Main() {

    }

    public Model_Main(int Id, String[] kolonlar, String tabloAd) {
        this.Id = Id;
        this.kolonlar = kolonlar;
        this.tabloAd = tabloAd;
    }

    public Model_Main(int Id) {
        this.Id = Id;
    }

    public Model_Main(String tabloAd) {
        this.tabloAd = tabloAd;
    }

    public Model_Main(String[] kolonlar, String tabloAd) {
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
