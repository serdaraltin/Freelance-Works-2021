package Model;

public class Ogrenci extends Kisi {

    private String Bolum;

    public Ogrenci() {
    }

    public Ogrenci(String[] veri) {
        super(veri);
        this.Bolum = veri[5];
    }

    public Ogrenci(int No, String TcNo, String Ad, String Soyad, String Eposta, String Bolum) {
        super(No, TcNo, Ad, Soyad, Eposta);
        this.Bolum = Bolum;
    }

    @Override
    public String toString() {
        return super.toString() + "," + Bolum;
    }

    @Override
    public String[] kolonlar() {
        return new String[]{"No", "Tc No", "Ad", "Soyad", "Eposta", "Bolum"};
    }

    @Override
    public Object[] toObject() {
        return new Object[]{super.getNo(), super.getTcNo(), super.getAd(), super.getSoyad(), super.getEposta(), Bolum};
    }

    public String getBolum() {
        return Bolum;
    }

    public void setBolum(String Bolum) {
        this.Bolum = Bolum;
    }

}
