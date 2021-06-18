

public class mlKrediKart extends amlMain {

    private int mid;
    private int mBakiye, kLimit;

    public mlKrediKart() {
        super.setblad("kredi_kart");
    }

    public mlKrediKart(int id) {
        super(id);
    }

    public mlKrediKart(int id, int mid, int mBakiye, int kLimit) {
        super.setId(id);
        this.mid = mid;
        this.mBakiye = mBakiye;
        this.kLimit = kLimit;
    }

    public mlKrediKart(int mid, int mBakiye, int kLimit) {
        this.mid = mid;
        this.mBakiye = mBakiye;
        this.kLimit = kLimit;
    }

    public mlKrediKart(int mid, int kLimit) {
        this.mid = mid;
        this.kLimit = kLimit;
    }

    public int getMID() {
        return mid;
    }

    public void setMID(int mid) {
        this.mid = mid;
    }

    public int getBakiye() {
        return mBakiye;
    }

    public void setBakiye(int mBakiye) {
        this.mBakiye = mBakiye;
    }

    public int getKart_limit() {
        return kLimit;
    }

    public void setKart_limit(int kLimit) {
        this.kLimit = kLimit;
    }

    @Override
    public String toString() {
        return "Model_KrediKart{" + "id=" + super.getId() + ", id=" + id + ", mBakiye=" + mBakiye + ", kLimit=" + kLimit + '}';
    }

    @Override
    public String[] gettablokolon() {
        return new String[]{"id", "Musteri Ad", "Bakiye", "Limit"};
    }

    @Override
    public Object[] getveri() {
        return new Object[]{super.getId(), id, mBakiye, kLimit};
    }

}
