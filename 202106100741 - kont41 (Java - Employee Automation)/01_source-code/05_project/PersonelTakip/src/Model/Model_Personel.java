package Model;

import Controller.Controller_Departman;

public class Model_Personel extends Model_Main {

    private String tcno;
    private String ad;
    private String soyad;
    private String telefon;
    private String eposta;
    private String adres;
    private int departmanId;
    private int maas;

    public Model_Personel() {
        super.setTabloAd("personel");
    }

    public Model_Personel(int Id) {
        super(Id);
    }

    public Model_Personel(String tcno) {
        this.tcno = tcno;
    }

    public Model_Personel(int Id, String tcno, String ad, String soyad, String telefon, String eposta, String adres, int departmanId, int maas) {
        super(Id);
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.eposta = eposta;
        this.adres = adres;
        this.departmanId = departmanId;
        this.maas = maas;
    }

    public Model_Personel(String tcno, String ad, String soyad, String telefon, String eposta, String adres, int departmanId, int maas) {
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.eposta = eposta;
        this.adres = adres;
        this.departmanId = departmanId;
        this.maas = maas;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public int getDepartmanId() {
        return departmanId;
    }

    public void setDepartmanId(int departmanId) {
        this.departmanId = departmanId;
    }

    public String getTcno() {
        return tcno;
    }

    public void setTcno(String tcno) {
        this.tcno = tcno;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int Id) {
        super.setId(Id);
    }

    @Override
    public String toString() {
        return "Model_Personel{" + "tcno=" + tcno + ", ad=" + ad + ", soyad=" + soyad + ", telefon=" + telefon + ", eposta=" + eposta + ", adres=" + adres + ", departmanId=" + departmanId + ", maas=" + maas + '}';
    }

    @Override
    public Object[] getObject() {
        Model_Departman departman = new Controller_Departman().Getir(departmanId);
        return new Object[]{super.getId(), tcno, ad, soyad, telefon, eposta, adres, departman.getAd(), maas};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "TC No", "Ad", "Soyad", "Telefon", "Eposta", "Adres", "Departman", "Maaş"};
    }

    @Override
    public void setTabloAd(String tabloAd) {
        super.setTabloAd("personel");
    }

}
