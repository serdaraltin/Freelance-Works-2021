package Kayit;

public class Kisi {
    private int Id;
    private String ad;
    private String soyad;
    private String parola;

    public Kisi(int Id, String ad, String soyad, String parola) {
        this.Id = Id;
        this.ad = ad;
        this.soyad = soyad;
        this.parola = parola;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return Id + "	" + ad + "	"+ soyad + "	"+ parola;
    }

}
