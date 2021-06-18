package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model_Kitap extends Model_Main {

    private String ad;
    private String tur;
    private int fiyat;

    public Model_Kitap(String ad) {
        this.ad = ad;
    }

    public Model_Kitap() {
        super.setTabloAd("kitap");
    }

    public Model_Kitap(int Id) {
        super(Id);
    }

    public Model_Kitap(int Id, String ad, String tur, int fiyat) {
        super(Id);
        this.ad = ad;
        this.tur = tur;
        this.fiyat = fiyat;
    }

    public Model_Kitap(String ad, String tur, int fiyat) {
        this.ad = ad;
        this.tur = tur;
        this.fiyat = fiyat;
    }

    public Model_Kitap(ResultSet resultSet) {
        try {
            super.setId(resultSet.getInt("Id"));
            ad = resultSet.getString("ad");
            tur = resultSet.getString("tur");
            fiyat = resultSet.getInt("fiyat");
        } catch (SQLException ex) {
            Logger.getLogger(Model_Kitap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Ad", "Tür", "Fiyat"};
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), ad, tur, fiyat};
    }

    @Override
    public String getInsert() {
        String sorgu = "insert into " + super.getTabloAd()
                + " (ad, tur, fiyat) values("
                + "'" + ad + "', '" + tur + "', " + fiyat
                + ")";
        return sorgu;
    }

    @Override
    public String getUpdate() {
        String sorgu = "update " + super.getTabloAd() + " set "
                + "ad='" + ad + "', tur='" + tur + "', fiyat=" + fiyat
                + " Where Id=" + super.getId();
        return sorgu;
    }

    @Override
    public String getSearch(String value) {
        String sorgu = "select * from " + super.getTabloAd()
                + "ad LIKE '%" + value + "%' or"
                + "tur LIKE '%" + value + "%'";
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
                + " Where ad='" + ad + "'";
        return sorgu;
    }

}
