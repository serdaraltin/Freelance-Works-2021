package MD;

public class MBankaKart extends Abs_M_Ana {

    private int musteri_Id;
    private int bakiye;

    public MBankaKart() {
        super.setTabloAd("banka_kart");
    }

    public MBankaKart(int Id) {
        super(Id);
    }

    
    public MBankaKart(int Id, int musteri_Id, int bakiye) {
        super.setId(Id);
        this.musteri_Id = musteri_Id;
        this.bakiye = bakiye;
    }

    public MBankaKart(int musteri_Id, int bakiye) {
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
