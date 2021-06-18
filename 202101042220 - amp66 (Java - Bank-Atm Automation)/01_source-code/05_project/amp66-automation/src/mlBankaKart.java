

public class mlBankaKart extends amlMain {

    private int mid;
    private int mBakiye;

    public mlBankaKart() {
        super.setblad("banka_kart");
    }

    public mlBankaKart(int id) {
        super(id);
    }

    
    public mlBankaKart(int id, int mid, int mBakiye) {
        super.setId(id);
        this.mid = mid;
        this.mBakiye = mBakiye;
    }

    public mlBankaKart(int mid, int mBakiye) {
        this.mid = mid;
        this.mBakiye = mBakiye;
    }

    public int getMID() {
        return mid;
    }

    public void setMID(int id) {
        this.mid = mid;
    }

    public int getBakiye() {
        return mBakiye;
    }

    public void setBakiye(int mBakiye) {
        this.mBakiye = mBakiye;
    }

    @Override
    public String toString() {
        return "Model_BankaKart{" + "id=" + super.getId() + ", id=" + id + ", mBakiye=" + mBakiye + '}';
    }

    @Override
    public String[] gettablokolon() {
        return new String[]{"id", "Musteri Ad", "Bakiye"};
    }

    @Override
    public Object[] getveri() {
        return new Object[]{super.getId(), id, mBakiye};
    }

}
