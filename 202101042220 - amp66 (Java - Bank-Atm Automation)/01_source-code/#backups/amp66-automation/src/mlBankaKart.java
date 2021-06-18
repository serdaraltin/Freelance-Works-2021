

public class mlBankaKart extends amlMain {

    private int mID;
    private int mBakiye;

    public mlBankaKart() {
        super.setblad("banka_kart");
    }

    public mlBankaKart(int id) {
        super(id);
    }

    
    public mlBankaKart(int id, int mID, int mBakiye) {
        super.setId(id);
        this.mID = mID;
        this.mBakiye = mBakiye;
    }

    public mlBankaKart(int mID, int mBakiye) {
        this.mID = mID;
        this.mBakiye = mBakiye;
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

    @Override
    public String toString() {
        return "Model_BankaKart{" + "id=" + super.getId() + ", mID=" + mID + ", mBakiye=" + mBakiye + '}';
    }

    @Override
    public String[] gettablokolon() {
        return new String[]{"id", "Musteri Ad", "Bakiye"};
    }

    @Override
    public Object[] getveri() {
        return new Object[]{super.getId(), mID, mBakiye};
    }

}
