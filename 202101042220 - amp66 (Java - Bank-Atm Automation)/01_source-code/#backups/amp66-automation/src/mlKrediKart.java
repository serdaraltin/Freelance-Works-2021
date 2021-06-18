

public class mlKrediKart extends amlMain {

    private int mID;
    private int mBakiye, kLimit;

    public mlKrediKart() {
        super.setblad("kredi_kart");
    }

    public mlKrediKart(int id) {
        super(id);
    }

    public mlKrediKart(int id, int mID, int mBakiye, int kLimit) {
        super.setId(id);
        this.mID = mID;
        this.mBakiye = mBakiye;
        this.kLimit = kLimit;
    }

    public mlKrediKart(int mID, int mBakiye, int kLimit) {
        this.mID = mID;
        this.mBakiye = mBakiye;
        this.kLimit = kLimit;
    }

    public mlKrediKart(int mID, int kLimit) {
        this.mID = mID;
        this.kLimit = kLimit;
    }

    public int getMID() {
        return mID;
    }

    public void setMID(int mID) {
        this.mID = mID;
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
        return "Model_KrediKart{" + "id=" + super.getId() + ", mID=" + mID + ", mBakiye=" + mBakiye + ", kLimit=" + kLimit + '}';
    }

    @Override
    public String[] gettablokolon() {
        return new String[]{"id", "Musteri Ad", "Bakiye", "Limit"};
    }

    @Override
    public Object[] getveri() {
        return new Object[]{super.getId(), mID, mBakiye, kLimit};
    }

}
