package Model;

public class Model_Oda extends Model_Main {

    private int no;
    private int kat;
    private String tur;

    public Model_Oda() {
        super.setTabloAd("oda");
    }

    public Model_Oda(int Id) {
        super(Id);
    }

    public Model_Oda(int Id, int no, int kat, String tur) {
        super(Id);
        this.no = no;
        this.kat = kat;
        this.tur = tur;
    }

    public Model_Oda(int no, int kat, String tur) {
        this.no = no;
        this.kat = kat;
        this.tur = tur;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getKat() {
        return kat;
    }

    public void setKat(int kat) {
        this.kat = kat;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int Id) {
        super.setId(Id);
    }

    @Override
    public String toString() {
        return "Model_Oda{" + "Id=" + super.getId() + "no=" + no + ", kat=" + kat + ", tur=" + tur + '}';
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), no, kat, tur};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "No", "Kat", "Tur"};
    }

}
