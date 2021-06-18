package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model_Musteri extends Model_Main {

    private String unvan, tcno, ad, soyad, dogum, telefon, eposta, adres;

    public Model_Musteri() {
        super.setTabloAd("musteri");
        this.unvan = "standart";
    }

    public Model_Musteri(String tcno) {
        this.tcno = tcno;
    }

    public Model_Musteri(int Id) {
        super(Id);
    }

    public Model_Musteri(ResultSet resultSet) {
        try {
            super.setId(resultSet.getInt("Id"));
            this.unvan = resultSet.getString("unvan");
            this.tcno = resultSet.getString("tcno");
            this.ad = resultSet.getString("ad");
            this.soyad = resultSet.getString("soyad");
            this.dogum = resultSet.getString("dogum");
            this.telefon = resultSet.getString("telefon");
            this.eposta = resultSet.getString("eposta");
            this.adres = resultSet.getString("adres");

        } catch (SQLException ex) {
            Logger.getLogger(Model_Musteri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Model_Musteri(int Id, String unvan, String tcno, String ad, String soyad, String dogum, String telefon, String eposta, String adres) {
        super.setId(Id);
        this.unvan = unvan;
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
        this.dogum = dogum;
        this.telefon = telefon;
        this.eposta = eposta;
        this.adres = adres;
    }

    public Model_Musteri(String tcno, String ad, String soyad, String dogum, String telefon, String eposta, String adres) {
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
        this.dogum = dogum;
        this.telefon = telefon;
        this.eposta = eposta;
        this.adres = adres;
        this.unvan = "standart";
    }

    public Model_Musteri(String unvan, String tcno, String ad, String soyad, String dogum, String telefon, String eposta, String adres) {
        this.unvan = unvan;
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
        this.dogum = dogum;
        this.telefon = telefon;
        this.eposta = eposta;
        this.adres = adres;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
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

    public String getDogum() {
        return dogum;
    }

    public void setDogum(String dogum) {
        this.dogum = dogum;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Model_Musteri{" + "Id=" + super.getId() + ", unvan=" + unvan + ", tcno=" + tcno + ", ad=" + ad + ", soyad=" + soyad + ", dogum=" + dogum + ", telefon=" + telefon + ", eposta=" + eposta + ", adres=" + adres + '}';
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Ünvan", "TC No", "Ad", "Soyad", "Doğum Tarihi", "Telefon", "Eposta", "Adres"};
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), unvan, tcno, ad, soyad, dogum, telefon, eposta, adres};
    }

    @Override
    public String getInsert() {
        String sorgu = "insert into " + super.getTabloAd()
                + " (unvan, tcno, ad, soyad, dogum, telefon, eposta, adres) values("
                + "'" + unvan + "', '" + tcno + "', '" + ad + "', '" + soyad + "', '" + dogum + "', '" + telefon + "', '" + eposta + "', '" + adres + "'"
                + ")";
        return sorgu;
    }

    @Override
    public String getUpdate() {
        String sorgu = "update " + super.getTabloAd() + " set "
                + "unvan='" + unvan + "', tcno='" + tcno + "', ad='" + ad + "', soyad='" + soyad + "', dogum='" + dogum + "', telefon='" + telefon + "', eposta='" + eposta + "', adres='" + adres + "'"
                + " Where Id=" + super.getId();
        return sorgu;
    }

    @Override
    public String getSearch(String value) {
        String sorgu = "select * from " + super.getTabloAd() + " Where "
                + "ad LIKE '%" + value + "%' or "
                + "tcno LIKE '%" + value + "%' or "
                + "ad LIKE '%" + value + "%' or "
                + "soyad LIKE '%" + value + "%' or "
                + "dogum LIKE '%" + value + "%' or "
                + "telefon LIKE '%" + value + "%' or "
                + "eposta LIKE '%" + value + "%' or "
                + "adres LIKE '%" + value + "%'";
        return sorgu;
    }

    @Override
    public String getGet() {
        String sorgu = "select * from " + super.getTabloAd()
                + " Where Id=" + super.getId();
        return sorgu;
    }

    public String getGetTcNo() {
        String sorgu = "select * from " + super.getTabloAd()
                + " Where tcno='" + tcno + "'";
        return sorgu;
    }

    @Override
    public String getControl() {
        String sorgu = "select * from " + super.getTabloAd()
                + " Where tcno='" + tcno + "'";
        return sorgu;
    }
}
