package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model_Kategori extends Model_Main {

    private String ad;

    public Model_Kategori() {
        super.setTabloAd("kategori");
    }

    public Model_Kategori(String ad) {
        this.ad = ad;
    }

    public Model_Kategori(ResultSet resultSet) {
        try {
            super.setId(resultSet.getInt("Id"));
            ad = resultSet.getString("ad");
        } catch (SQLException ex) {
            Logger.getLogger(Model_FaturaUrun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Model_Kategori(int Id) {
        super(Id);
    }

    public Model_Kategori(int Id, String ad) {
        super(Id);
        this.ad = ad;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Model_Kategori{" + "Id=" + super.getId() + ", ad=" + ad + '}';
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), ad};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Ad"};
    }

    @Override
    public String getInsert() {
        String sorgu = "insert into " + super.getTabloAd()
                + " (ad) values("
                + "'" + ad + "'"
                + ")";
        return sorgu;
    }

    @Override
    public String getUpdate() {
        String sorgu = "update " + super.getTabloAd() + " set "
                + "ad='" + ad + "'"
                + " Where Id=" + super.getId();
        return sorgu;
    }

    @Override
    public String getSearch(String value) {
        String sorgu = "select * from " + super.getTabloAd() + " Where "
                + "ad LIKE '%" + value + "%'";

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
