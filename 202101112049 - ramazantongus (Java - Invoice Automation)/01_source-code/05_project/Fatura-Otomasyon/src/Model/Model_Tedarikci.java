package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model_Tedarikci extends Model_Main {

    private String ad;
    private String telefon;
    private String adres;

    public Model_Tedarikci() {
        super.setTabloAd("tedarikci");
    }

    public Model_Tedarikci(int Id) {
        super(Id);
    }

    public Model_Tedarikci(ResultSet resultSet) {
        try {
            super.setId(resultSet.getInt("Id"));
            this.ad = resultSet.getString("ad");
            this.telefon = resultSet.getString("telefon");
            this.adres = resultSet.getString("adres");

        } catch (SQLException ex) {
            Logger.getLogger(Model_Tedarikci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Model_Tedarikci(String ad, String telefon, String adres) {
        this.ad = ad;
        this.telefon = telefon;
        this.adres = adres;
    }

    public Model_Tedarikci(int Id, String ad, String telefon, String adres) {
        super(Id);
        this.ad = ad;
        this.telefon = telefon;
        this.adres = adres;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
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
        return "Model_Tedarikci{" + "Id=" + super.getId() + ", ad=" + ad + ", telefon=" + telefon + ", adres=" + adres + '}';
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), ad, telefon, adres};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Ad", "Telefon", "Adres"};
    }

    @Override
    public String getInsert() {
        String sorgu = "insert into " + super.getTabloAd()
                + " (ad,telefon,adres) values("
                + "'" + ad + "', '" + telefon + "','" + adres + "'"
                + ")";
        return sorgu;
    }

    @Override
    public String getUpdate() {
        String sorgu = "update " + super.getTabloAd() + " set "
                + "ad='" + ad + "', telefon='" + telefon + "', adres='" + adres + "'"
                + "' Where Id=" + super.getId();
        return sorgu;
    }

    @Override
    public String getSearch(String value) {
        String sorgu = "select * from " + super.getTabloAd()
                + " Where ad LIKE '%" + value + "%' od telefon LIKE '%" + telefon + "%' or adres LIKE '%" + adres + "%'";
        return sorgu;
    }

    @Override
    public String getGet() {
        String sorgu = "select * from " + super.getTabloAd()
                + " Where Id=" + super.getId();
        return sorgu;
    }

    @Override
    public String getControl() {
        String sorgu = "select * from " + super.getTabloAd()
                + " Where Id=" + super.getId();
        return sorgu;
    }
}
