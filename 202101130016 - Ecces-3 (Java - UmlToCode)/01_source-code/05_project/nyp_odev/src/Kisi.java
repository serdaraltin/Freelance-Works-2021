
import java.util.Date;

public class Kisi implements Gozlemlenebilir{

    private String isim, soyisim, cinsiyet;
    private int tcNo;
    private String telNo;
    private String email;
    private Date dogumtarihi;

    public Kisi(String isim, String soyisim, String cinsiyet, int tcNo, String telNo, String email, Date dogumtarihi) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.cinsiyet = cinsiyet;
        this.tcNo = tcNo;
        this.telNo = telNo;
        this.email = email;
        this.dogumtarihi = dogumtarihi;
    }

    public Kisi() {
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public int getTcNo() {
        return tcNo;
    }

    public void setTcNo(int tcNo) {
        this.tcNo = tcNo;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDogumtarihi() {
        return dogumtarihi;
    }

    public void setDogumtarihi(Date dogumtarihi) {
        this.dogumtarihi = dogumtarihi;
    }

    @Override
    public String toString() {
        return "Kisi{" + "isim=" + isim + ", soyisim=" + soyisim + ", cinsiyet=" + cinsiyet + ", tcNo=" + tcNo + ", telNo=" + telNo + ", email=" + email + ", dogumtarihi=" + dogumtarihi + '}';
    }

    @Override
    public void Kimlik_Bilgisi_Yazdir() {
        String bilgi =
                "isim=" +isim+
                "\nsoyisim=" + soyisim + 
                "\ncinsiyet=" + cinsiyet +
                "\ntcNo=" + tcNo + 
                "\ntelNo=" + telNo +
                "\nemail=" + email +
                "\ndogumtarihi=" + dogumtarihi;
        System.out.println(bilgi);
    }

}
