
import java.util.Date;

public class Memur extends Calisan {

    private String calistigiBirim;

    public Memur(String calistigiBirim, int sicilNo, int derece, String isim, String soyisim, String cinsiyet, int tcNo, String telNo, String email, Date dogumtarihi) {
        super(sicilNo, derece, isim, soyisim, cinsiyet, tcNo, telNo, email, dogumtarihi);
        this.calistigiBirim = calistigiBirim;
    }

    public Memur(String calistigiBirim, int sicilNo, int derece) {
        super(sicilNo, derece);
        this.calistigiBirim = calistigiBirim;
    }

    public Memur(String calistigiBirim) {
        this.calistigiBirim = calistigiBirim;
    }

    public Memur() {
    }

    public String getCalistigiBirim() {
        return calistigiBirim;
    }

    public void setCalistigiBirim(String calistigiBirim) {
        this.calistigiBirim = calistigiBirim;
    }

    @Override
    public String toString() {
        return "Memur{" + "calistigiBirim=" + calistigiBirim + '}';
    }

}
