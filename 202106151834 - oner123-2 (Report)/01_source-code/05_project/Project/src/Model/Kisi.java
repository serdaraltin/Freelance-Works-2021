package Model;

public class Kisi {

    private int No;
    private String TcNo;
    private String Ad;
    private String Soyad;
    private String Eposta;

    public Kisi() {
    }

    public Kisi(String[] veri) {
        this.No = Integer.valueOf(veri[0]);
        this.TcNo = veri[1];
        this.Ad = veri[2];
        this.Soyad = veri[3];
        this.Eposta = veri[4];
    }

    public Kisi(int No, String TcNo, String Ad, String Soyad, String Eposta) {
        this.No = No;
        this.TcNo = TcNo;
        this.Ad = Ad;
        this.Soyad = Soyad;
        this.Eposta = Eposta;
    }

    @Override
    public String toString() {
        return No + "," + TcNo + "," + Ad + "," + Soyad + "," + Eposta;
    }

    public String[] kolonlar() {
        return new String[]{"No", "Tc No", "Ad", "Soyad", "Eposta"};
    }

    public Object[] toObject() {
        return new Object[]{No, TcNo, Ad, Soyad, Eposta};
    }

    public int getNo() {
        return No;
    }

    public void setNo(int No) {
        this.No = No;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String Soyad) {
        this.Soyad = Soyad;
    }

    public String getEposta() {
        return Eposta;
    }

    public void setEposta(String Eposta) {
        this.Eposta = Eposta;
    }

    public String getTcNo() {
        return TcNo;
    }

    public void setTcNo(String TcNo) {
        this.TcNo = TcNo;
    }

}
