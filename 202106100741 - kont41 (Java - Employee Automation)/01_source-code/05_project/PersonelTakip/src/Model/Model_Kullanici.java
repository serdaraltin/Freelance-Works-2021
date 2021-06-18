package Model;

import Controller.Controller_Personel;

public class Model_Kullanici extends Model_Main {

    private String kullaniciAd;
    private String parola;
    private int personelId;
    private int yetki;

    public Model_Kullanici() {
        super.setTabloAd("kullanici");
    }

    public Model_Kullanici(int Id) {
        super(Id);
    }

    public Model_Kullanici(int Id, String kullaniciAd, String parola, int personelId, int yetki) {
        super(Id);
        this.kullaniciAd = kullaniciAd;
        this.parola = parola;
        this.personelId = personelId;
        this.yetki = yetki;
    }

    public Model_Kullanici(String kullaniciAd, String parola, int personelId, int yetki) {
        this.kullaniciAd = kullaniciAd;
        this.parola = parola;
        this.personelId = personelId;
        this.yetki = yetki;
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Kullanıcı Ad", "Parola", "Personel Tc No", "Yetki"};
    }

    @Override
    public Object[] getObject() {
        Model_Personel personel = new Controller_Personel().Getir(personelId);
        String yetkiMetni = "Normal";
        if(yetki == 1)
            yetkiMetni = "Yönetici";
        return new Object[]{super.getId(), kullaniciAd, parola, personel.getTcno(), yetkiMetni};
    }

    @Override
    public String toString() {
        return "Model_Kullanici{" + "kullaniciAd=" + kullaniciAd + ", parola=" + parola + ", personelId=" + personelId + ", yetki=" + yetki + '}';
    }

    public String getKullaniciAd() {
        return kullaniciAd;
    }

    public void setKullaniciAd(String kullaniciAd) {
        this.kullaniciAd = kullaniciAd;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public int getPersonelId() {
        return personelId;
    }

    public void setPersonelId(int personelId) {
        this.personelId = personelId;
    }

    public int getYetki() {
        return yetki;
    }

    public void setYetki(int yetki) {
        this.yetki = yetki;
    }

}
