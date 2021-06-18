
import java.util.ArrayList;
import java.util.Date;

public class Ogretim_Gorevlisi extends Calisan{

    private String unvan;
    private ArrayList<Ders> dersler;

    public Ogretim_Gorevlisi() {
    }

    public Ogretim_Gorevlisi(String unvan, ArrayList<Ders> dersler, int sicilNo, int derece, String isim, String soyisim, String cinsiyet, int tcNo, String telNo, String email, Date dogumtarihi) {
        super(sicilNo, derece, isim, soyisim, cinsiyet, tcNo, telNo, email, dogumtarihi);
        this.unvan = unvan;
        this.dersler = dersler;
    }

    
    public Ogretim_Gorevlisi(String unvan) {
        this.unvan = unvan;
        this.dersler = new ArrayList<>();
    }

    public Ogretim_Gorevlisi(String unvan, ArrayList<Ders> dersler) {
        this.unvan = unvan;
        this.dersler = dersler;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public ArrayList<Ders> getDersler() {
        return dersler;
    }

    public void setDersler(ArrayList<Ders> dersler) {
        this.dersler = dersler;
    }

    @Override
    public String toString() {
        return "Ogretim_Gorevlisi{" + "unvan=" + unvan + ", dersler=" + dersler + '}';
    }

}
