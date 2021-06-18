package Model;

public class Model_BankaKart extends Model_Main {

    private int musteri_Id;
    private int bakiye;

    public Model_BankaKart() {
        super.setTabloAd("banka_kart");
    }

    public Model_BankaKart(int Id) {
        super(Id);
    }

    
    public Model_BankaKart(int Id, int musteri_Id, int bakiye) {
        super.setId(Id);
        this.musteri_Id = musteri_Id;
        this.bakiye = bakiye;
    }

    public Model_BankaKart(int musteri_Id, int bakiye) {
        this.musteri_Id = musteri_Id;
        this.bakiye = bakiye;
    }

    public int getMusteri_Id() {
        return musteri_Id;
    }

    public void setMusteri_Id(int musteri_Id) {
        this.musteri_Id = musteri_Id;
    }

    public int getBakiye() {
        return bakiye;
    }

    public void setBakiye(int bakiye) {
        this.bakiye = bakiye;
    }

    @Override
    public String toString() {
        return "Model_BankaKart{" + "Id=" + super.getId() + ", musteri_Id=" + musteri_Id + ", bakiye=" + bakiye + '}';
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Musteri Ad", "Bakiye"};
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), musteri_Id, bakiye};
    }

}
