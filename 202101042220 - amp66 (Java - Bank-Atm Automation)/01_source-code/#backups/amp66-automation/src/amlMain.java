

public abstract class amlMain implements iModel {

    int id;
    private String[] kolonlar;
    private String tbl_ad;

    public amlMain() {

    }

    public amlMain(int id, String[] kolonlar, String tbl_ad) {
        this.id = id;
        this.kolonlar = kolonlar;
        this.tbl_ad = tbl_ad;
    }

    public amlMain(int id) {
        this.id = id;
    }

    public amlMain(String tbl_ad) {
        this.tbl_ad = tbl_ad;
    }

    public amlMain(String[] kolonlar, String tbl_ad) {
        this.kolonlar = kolonlar;
        this.tbl_ad = tbl_ad;
    }

    public String gettblad() {
        return tbl_ad;
    }

    public void setblad(String tbl_ad) {
        this.tbl_ad = tbl_ad;
    }

    public String[] gettablokolon() {
        return kolonlar;
    }

    public void settablokolon(String[] kolonlar) {
        this.kolonlar = kolonlar;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Model_Main{" + "id=" + id + ", kolonlar=" + kolonlar + ", tbl_ad=" + tbl_ad + '}';
    }

    @Override
    public Object[] getveri() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
