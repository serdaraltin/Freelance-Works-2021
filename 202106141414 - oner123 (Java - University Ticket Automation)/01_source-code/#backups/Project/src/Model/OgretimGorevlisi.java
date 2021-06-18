package Model;

public class OgretimGorevlisi extends Kisi {

    public OgretimGorevlisi() {
    }

    public OgretimGorevlisi(int no, String parola, String tcNo, String ad, String soyad, String cinsiyet, String dogumTarih, String telefon, String eposta, String adres, String bolum) {
        super(no, parola, tcNo, ad, soyad, cinsiyet, dogumTarih, telefon, eposta, adres, bolum);
    }

    public OgretimGorevlisi(String[] veri) {
        super(veri);
    }

}
