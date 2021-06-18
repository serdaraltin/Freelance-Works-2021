

public class MKrediKart extends Abs_M_Ana {

    private int musteri_Id;
    private int bakiye, kart_limit;

    public MKrediKart() {
        super.setTabloAd("kredi_kart");
    }

    public MKrediKart(int Id) {
        super(Id);
    }

    public MKrediKart(int Id, int musteri_Id, int bakiye, int kart_limit) {
        super.setId(Id);
        this.musteri_Id = musteri_Id;
        this.bakiye = bakiye;
        this.kart_limit = kart_limit;
    }

    public MKrediKart(int musteri_Id, int bakiye, int kart_limit) {
        this.musteri_Id = musteri_Id;
        this.bakiye = bakiye;
        this.kart_limit = kart_limit;
    }

    public MKrediKart(int musteri_Id, int kart_limit) {
        this.musteri_Id = musteri_Id;
        this.kart_limit = kart_limit;
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

    public int getKart_limit() {
        return kart_limit;
    }

    public void setKart_limit(int kart_limit) {
        this.kart_limit = kart_limit;
    }

    @Override
    public String toString() {
        return "Model_KrediKart{" + "Id=" + super.getId() + ", musteri_Id=" + musteri_Id + ", bakiye=" + bakiye + ", kart_limit=" + kart_limit + '}';
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Musteri Ad", "Bakiye", "Limit"};
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), musteri_Id, bakiye, kart_limit};
    }

}
