package Model;

public class Model_Salon {

    private int Id;
    private String ad;
    private int koltukAdet;

    public Model_Salon() {
    }

    public Model_Salon(int Id, String ad, int koltukAdet) {
        this.Id = Id;
        this.ad = ad;
        this.koltukAdet = koltukAdet;
    }

    public Model_Salon(int Id) {
        this.Id = Id;
    }

    public Model_Salon(String ad) {
        this.ad = ad;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getKoltukAdet() {
        return koltukAdet;
    }

    public void setKoltukAdet(int koltukAdet) {
        this.koltukAdet = koltukAdet;
    }

    @Override
    public String toString() {
        return "Model_Salon{" + "Id=" + Id + ", ad=" + ad + ", koltukAdet=" + koltukAdet + '}';
    }

    public Object[] toObject() {
        return new Object[]{Id, ad, koltukAdet};
    }
}
