package Model;

public class Musteri extends Kisi {

    private String telefon;
    private String adres;

    public Musteri() {
    }

    public Musteri(String tcno, String ad, String soyad, String telefon, String adres) {
        super(tcno, ad, soyad);
        this.telefon = telefon;
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nTelefon : " + telefon
                + "\nAdres   : " + adres;
    }

}
