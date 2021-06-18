
import java.util.Date;

public class Calisan extends Kisi {

    private int sicilNo;
    private int derece;

    public Calisan(int sicilNo, int derece) {
        this.sicilNo = sicilNo;
        this.derece = derece;
    }

    public Calisan(int sicilNo, int derece, String isim, String soyisim, String cinsiyet, int tcNo, String telNo, String email, Date dogumtarihi) {
        super(isim, soyisim, cinsiyet, tcNo, telNo, email, dogumtarihi);
        this.sicilNo = sicilNo;
        this.derece = derece;
    }

    public Calisan() {
    }

    public int getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(int sicilNo) {
        this.sicilNo = sicilNo;
    }

    public int getDerece() {
        return derece;
    }

    public void setDerece(int derece) {
        this.derece = derece;
    }

    @Override
    public String toString() {
        return "Calisan{" + "sicilNo=" + sicilNo + ", derece=" + derece + '}';
    }

    public int Maas_Hesapla() {
        return 0;
    }

}
