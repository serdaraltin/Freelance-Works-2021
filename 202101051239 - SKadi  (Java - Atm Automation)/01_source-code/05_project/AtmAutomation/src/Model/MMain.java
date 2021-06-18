package Model;

public abstract class MMain implements IModel {

    int Id;
    private String[] kolonlar;
    private String tblName;

    public MMain() {

    }

    public MMain(int Id, String[] kolonlar, String tblName) {
        this.Id = Id;
        this.kolonlar = kolonlar;
        this.tblName = tblName;
    }

    public MMain(int Id) {
        this.Id = Id;
    }

    public MMain(String tblName) {
        this.tblName = tblName;
    }

    public MMain(String[] kolonlar, String tblName) {
        this.kolonlar = kolonlar;
        this.tblName = tblName;
    }

    public String getTblName() {
        return tblName;
    }

    public void setTabloAd(String tblName) {
        this.tblName = tblName;
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
        return "MMain{" + "Id=" + Id + ", kolonlar=" + kolonlar + ", tblName=" + tblName + '}';
    }

    @Override
    public Object[] getObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
