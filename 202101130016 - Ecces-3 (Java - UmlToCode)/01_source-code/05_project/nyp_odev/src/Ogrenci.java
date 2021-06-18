
import java.util.ArrayList;
import java.util.Date;

public class Ogrenci extends Kisi {

    private int ogrenciNo;
    private int mezuniyetKredisi;
    private ArrayList<Ders> dersler;

    public Ogrenci(int ogrenciNo, int mezuniyetKredisi, String isim, String soyisim, String cinsiyet, int tcNo, String telNo, String email, Date dogumtarihi) {
        super(isim, soyisim, cinsiyet, tcNo, telNo, email, dogumtarihi);
        this.ogrenciNo = ogrenciNo;
        this.mezuniyetKredisi = mezuniyetKredisi;
    }

    public Ogrenci(int ogrenciNo, int mezuniyetKredisi, ArrayList<Ders> dersler) {
        this.ogrenciNo = ogrenciNo;
        this.mezuniyetKredisi = mezuniyetKredisi;
        this.dersler = dersler;
    }

    public Ogrenci(int ogrenciNo, int mezuniyetKredisi) {
        this.ogrenciNo = ogrenciNo;
        this.mezuniyetKredisi = mezuniyetKredisi;
        this.dersler = new ArrayList<>();
    }

    public Ogrenci() {
    }

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(int ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public int getMezuniyetKredisi() {
        return mezuniyetKredisi;
    }

    public void setMezuniyetKredisi(int mezuniyetKredisi) {
        this.mezuniyetKredisi = mezuniyetKredisi;
    }

    public ArrayList<Ders> getDersler() {
        return dersler;
    }

    public void setDersler(ArrayList<Ders> dersler) {
        this.dersler = dersler;
    }

    @Override
    public String toString() {
        return "Ogrenci{" + "ogrenciNo=" + ogrenciNo + ", mezuniyetKredisi=" + mezuniyetKredisi + ", dersler=" + dersler + '}';
    }

    public String Mezuniyet_Durumu() {
        if(this.mezuniyetKredisi > 40){
            return "Mezun olabilir";
        }
        return "Yetersiz kredi, mezun olamaz";
    }

}
