package Model;

public class Talep {

    private int No;
    private int HesapNo;
    private int Tip;
    private String Baslik;
    private String Icerik;
    private String Yanit = "yanitlanmadi";

    public Talep() {
    }

    public Talep(String[] veri) {
        this.No = Integer.valueOf(veri[0]);
        this.HesapNo = Integer.valueOf(veri[1]);
        this.Tip = Integer.valueOf(veri[2]);
        this.Baslik = veri[3];
        this.Icerik = veri[4];
        this.Yanit = veri[5];
    }

    public Talep(int No, int HesapNo, int Tip, String Baslik, String Icerik, String Yanit) {
        this.No = No;
        this.HesapNo = HesapNo;
        this.Tip = Tip;
        this.Baslik = Baslik;
        this.Icerik = Icerik;
        this.Yanit = Yanit;
    }

    @Override
    public String toString() {
        return No + "," + HesapNo + "," + Tip + "," + Baslik + "," + Icerik + "," + Yanit;
    }

    public String[] kolonlar() {
        return new String[]{"No", "Kişi No", "Tip", "Başlık", "İçerik", "Yanit"};
    }

    public Object[] toObject() {
        String sTip = "Öğrenci";
        if (Tip == 2) {
            sTip = "Öğretim Görevlisi";
        }
        return new Object[]{No, HesapNo, sTip, Baslik, Icerik, Yanit};
    }

    public int getNo() {
        return No;
    }

    public void setNo(int No) {
        this.No = No;
    }

    public int getHesapNo() {
        return HesapNo;
    }

    public void setHesapNo(int HesapNo) {
        this.HesapNo = HesapNo;
    }

    public int getTip() {
        return Tip;
    }

    public void setTip(int Tip) {
        this.Tip = Tip;
    }

    public String getBaslik() {
        return Baslik;
    }

    public void setBaslik(String Baslik) {
        this.Baslik = Baslik;
    }

    public String getIcerik() {
        return Icerik;
    }

    public void setIcerik(String Icerik) {
        this.Icerik = Icerik;
    }

    public String getYanit() {
        return Yanit;
    }

    public void setYanit(String Yanit) {
        this.Yanit = Yanit;
    }

}
