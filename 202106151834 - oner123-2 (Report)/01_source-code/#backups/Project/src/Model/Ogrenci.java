package Model;

public class Ogrenci extends Kisi {

    public Ogrenci() {
    }

    public Ogrenci(int no, String parola, String tcNo, String ad, String soyad, String cinsiyet, String dogumTarih, String telefon, String eposta, String adres, String bolum) {
        super(no, parola, tcNo, ad, soyad, cinsiyet, dogumTarih, telefon, eposta, adres, bolum);
    }

    public Ogrenci(String[] veri) {
        super(veri);
    }

}
