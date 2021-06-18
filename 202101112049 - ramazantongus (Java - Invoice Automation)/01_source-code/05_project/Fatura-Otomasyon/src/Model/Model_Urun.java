package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model_Urun extends Model_Main {

    private int kategori_Id;
    private int marka_Id;
    private String barkod;
    private String ad;
    private String birim;
    private int fiyat;
    private int miktar;
    private String eklenme_tarih;

    public Model_Urun() {
        super.setTabloAd("urun");
    }

    public Model_Urun(int Id) {
        super(Id);
    }

    public Model_Urun(ResultSet resultSet) {
        try {
            super.setId(resultSet.getInt("Id"));
            this.kategori_Id = resultSet.getInt("kategori_Id");
            this.marka_Id = resultSet.getInt("marka_Id");
            this.barkod = resultSet.getString("barkod");
            this.ad = resultSet.getString("ad");
            this.birim = resultSet.getString("birim");
            this.miktar = resultSet.getInt("miktar");
            this.fiyat = resultSet.getInt("fiyat");
            this.eklenme_tarih = resultSet.getString("eklenme_tarih");

        } catch (SQLException ex) {
            Logger.getLogger(Model_Urun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Model_Urun(int Id, int kategori_Id, int marka_Id, String barkod, String ad, String birim, int fiyat, int miktar, String eklenme_tarih) {
        super(Id);
        this.kategori_Id = kategori_Id;
        this.marka_Id = marka_Id;
        this.barkod = barkod;
        this.ad = ad;
        this.birim = birim;
        this.fiyat = fiyat;
        this.miktar = miktar;
        this.eklenme_tarih = eklenme_tarih;
    }

    public Model_Urun(int kategori_Id, int marka_Id, String barkod, String ad, String birim, int fiyat, int miktar, String eklenme_tarih) {
        this.kategori_Id = kategori_Id;
        this.marka_Id = marka_Id;
        this.barkod = barkod;
        this.ad = ad;
        this.birim = birim;
        this.fiyat = fiyat;
        this.miktar = miktar;
        this.eklenme_tarih = eklenme_tarih;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public int getKategori_Id() {
        return kategori_Id;
    }

    public void setKategori_Id(int kategori_Id) {
        this.kategori_Id = kategori_Id;
    }

    public int getMarka_Id() {
        return marka_Id;
    }

    public void setMarka_Id(int marka_Id) {
        this.marka_Id = marka_Id;
    }

    public String getBarkod() {
        return barkod;
    }

    public void setBarkod(String barkod) {
        this.barkod = barkod;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public String getEklenme_tarih() {
        return eklenme_tarih;
    }

    public void setEklenme_tarih(String eklenme_tarih) {
        this.eklenme_tarih = eklenme_tarih;
    }

    @Override
    public String toString() {
        return "Model_Urun{Id=" + super.getId() + ", ad=" + ad + ", barkod=" + barkod + ", kategori_Id=" + kategori_Id + ", marka_Id=" + marka_Id + ", birim=" + birim + ", miktar=" + miktar + ", fiyat=" + fiyat + ", eklenme_tarih=" + eklenme_tarih + '}';
    }

    @Override
    public Object[] getObject() {
        Model_Kategori kategori = new Controller.Controller_Kategori().Getir(new Model_Kategori(kategori_Id));
        Model_Marka marka = new Controller.Controller_Marka().Getir(new Model_Marka(marka_Id));
        return new Object[]{super.getId(), ad, barkod, kategori.getAd(), marka.getAd(), birim, miktar, fiyat, eklenme_tarih};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Ürün", "Ad", "Barkod", "Kategori", "Marka", "Birim", "Miktar", "Fiyat", "Eklenme Tarih"};
    }

    @Override
    public String getInsert() {
        String sorgu = "insert into " + super.getTabloAd()
                + " (ad,kategori_Id,marka_Id,barkod,birim,miktar,fiyat,eklenme_tarih) values("
                + "'" + ad + "',"
                + kategori_Id + ","
                + marka_Id + ","
                + "'" + barkod + "',"
                + "'" + birim + "',"
                + miktar + ","
                + fiyat + ","
                + "'" + eklenme_tarih + "'"
                + ")";
        return sorgu;
    }

    @Override
    public String getUpdate() {
        String sorgu = "update " + super.getTabloAd() + " set "
                + "ad='" + ad + "', kategori_Id=" + kategori_Id + ", marka_Id=" + marka_Id + ", barkod='" + barkod + "', ad='" + ad + "', birim='" + birim + "', miktar=" + miktar + ", fiyat=" + fiyat + ", eklenme_tarih='" + eklenme_tarih + "'"
                + " Where Id=" + super.getId();
        return sorgu;
    }

    @Override
    public String getSearch(String value) {
        String sorgu = "select * from " + super.getTabloAd()
                + " Where Id=" + value;
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
