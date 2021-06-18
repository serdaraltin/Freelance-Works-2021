package Model;

public class Tekniker extends Kisi {

    private Ariza[] arizalar = new Ariza[100];
    private int indexAriza;

    public Tekniker() {
        this.indexAriza = 0;
    }

    public Tekniker(String tcno, String ad, String soyad) {
        super(tcno, ad, soyad);
    }

    public void arizaEkle(Ariza ariza){
        arizalar[indexAriza++] = ariza;
    }
    public Ariza[] getArizalar() {
        return arizalar;
    }

    public void setArizalar(Ariza[] arizalar) {
        this.arizalar = arizalar;
    }

    public int getIndexAriza() {
        return indexAriza;
    }

    public void setIndexAriza(int indexAriza) {
        this.indexAriza = indexAriza;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
