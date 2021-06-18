package Model;

public class OgretimGorevlisi extends Kisi {

    private String Alan;

    public OgretimGorevlisi() {
    }

    public OgretimGorevlisi(String[] veri) {
        super(veri);
        this.Alan = veri[5];
    }

    public OgretimGorevlisi(int No, String TcNo, String Ad, String Soyad, String Eposta, String Alan) {
        super(No, TcNo, Ad, Soyad, Eposta);
        this.Alan = Alan;
    }

    @Override
    public String toString() {
        return super.toString() + "," + Alan;
    }

    @Override
    public String[] kolonlar() {
        return new String[]{"No", "Tc No", "Ad", "Soyad", "Eposta", "Alan"};
    }

    @Override
    public Object[] toObject() {
        return new Object[]{super.getNo(), super.getTcNo(), super.getAd(), super.getSoyad(), super.getEposta(), Alan};
    }

    public String getAlan() {
        return Alan;
    }

    public void setAlan(String Alan) {
        this.Alan = Alan;
    }

}
