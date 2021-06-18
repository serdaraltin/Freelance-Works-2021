package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model_Kullanici extends Model_Main {

    private String tip;
    private String kullanici_ad;
    private String parola;

    public Model_Kullanici() {
        super.setTabloAd("kullanici");
    }

    public Model_Kullanici(int Id) {
        super(Id);
    }

    public Model_Kullanici(ResultSet resultSet) {
        try {
            super.setId(resultSet.getInt("Id"));
            tip = resultSet.getString("tip");
            kullanici_ad = resultSet.getString("kullanici_ad");
            parola = resultSet.getString("parola");
        } catch (SQLException ex) {
            Logger.getLogger(Model_Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Model_Kullanici(int Id, String tip, String kullanici_ad, String parola) {
        super.setId(Id);
        this.tip = tip;
        this.kullanici_ad = kullanici_ad;
        this.parola = parola;
    }

    public Model_Kullanici(String tip, String kullanici_ad, String parola) {
        this.kullanici_ad = kullanici_ad;
        this.parola = parola;
        this.tip = tip;
    }

    public Model_Kullanici(String kullanici_ad, String parola) {
        this.kullanici_ad = kullanici_ad;
        this.parola = parola;
        this.tip = "personel";
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getKullanici_ad() {
        return kullanici_ad;
    }

    public void setKullanici_ad(String kullanici_ad) {
        this.kullanici_ad = kullanici_ad;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Model_Kullanici{" + "Id=" + super.getId() + ", tip=" + tip + ", kullanici_ad=" + kullanici_ad + ", parola=" + parola + '}';
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Tip", "Kullanıcı Adı", "Parola"};
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), tip, kullanici_ad, parola};
    }

    @Override
    public String getInsert() {
        String sorgu = "insert into " + super.getTabloAd()
                + " (tip, kullanici_ad, parola) values("
                + "'" + tip + "', '" + kullanici_ad + "', '" + parola + "'"
                + ")";
        return sorgu;
    }

    @Override
    public String getUpdate() {
        String sorgu = "update " + super.getTabloAd() + " set "
                + "tip=" + tip + ", kullanici_ad='" + kullanici_ad + "', parola='" + kullanici_ad + "'"
                + " Where Id=" + super.getId();
        return sorgu;
    }

    @Override
    public String getSearch(String value) {
        String sorgu = "select * from " + super.getTabloAd()
                + "tip LIKE '%" + value + "%' or"
                + "kullanici_ad LIKE '%" + value + "%' or"
                + "kullanici_ad LIKE '%" + value + "%'";
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
                + " Where kullanici_ad='" + kullanici_ad + "' and parola='" + parola + "'";
        return sorgu;
    }

}
