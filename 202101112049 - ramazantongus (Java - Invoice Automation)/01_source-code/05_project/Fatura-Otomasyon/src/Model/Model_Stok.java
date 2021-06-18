package Model;

import Controller.Controller_Tedarikci;
import Controller.Controller_Urun;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model_Stok extends Model_Main {

    private int urun_Id;
    private int tedarikci_Id;
    private int adet;
    private int tutar;
    private String eklenme_tarih;

    public Model_Stok() {
        super.setTabloAd("stok");
    }

    public Model_Stok(int Id) {
        super(Id);
    }

    public Model_Stok(ResultSet resultSet) {
        try {
            super.setId(resultSet.getInt("Id"));
            this.urun_Id = resultSet.getInt("urun_Id");
            this.tedarikci_Id = resultSet.getInt("tedarikci_Id");
            this.adet = resultSet.getInt("adet");
            this.tutar = resultSet.getInt("tutar");
            this.eklenme_tarih = resultSet.getString("eklenme_tarih");

        } catch (SQLException ex) {
            Logger.getLogger(Model_Stok.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Model_Stok(int Id, int urun_Id, int tedarikci_Id, int adet, int tutar, String eklenme_tarih) {
        super(Id);
        this.urun_Id = urun_Id;
        this.tedarikci_Id = tedarikci_Id;
        this.adet = adet;
        this.tutar = tutar;
        this.eklenme_tarih = eklenme_tarih;
    }

    public Model_Stok(int urun_Id, int tedarikci_Id, int adet, int tutar, String eklenme_tarih) {
        this.urun_Id = urun_Id;
        this.tedarikci_Id = tedarikci_Id;
        this.adet = adet;
        this.tutar = tutar;
        this.eklenme_tarih = eklenme_tarih;
    }

    public int getUrun_Id() {
        return urun_Id;
    }

    public void setUrun_Id(int urun_Id) {
        this.urun_Id = urun_Id;
    }

    public int getTedarikci_Id() {
        return tedarikci_Id;
    }

    public void setTedarikci_Id(int tedarikci_Id) {
        this.tedarikci_Id = tedarikci_Id;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public int getTutar() {
        return tutar;
    }

    public void setTutar(int tutar) {
        this.tutar = tutar;
    }

    public String getEklenme_tarih() {
        return eklenme_tarih;
    }

    public void setEklenme_tarih(String eklenme_tarih) {
        this.eklenme_tarih = eklenme_tarih;
    }

    @Override
    public String toString() {
        return "Model_Stok{Id=" + super.getId() + ", urun_Id=" + urun_Id + ", tedarikci_Id=" + tedarikci_Id + ", adet=" + adet + ", tutar=" + tutar + ", eklenme_tarih=" + eklenme_tarih + '}';
    }

    @Override
    public Object[] getObject() {
        Model_Tedarikci tedarikci =new Controller_Tedarikci().Getir(new Model_Tedarikci(tedarikci_Id));
        Model_Urun urun = new Controller_Urun().Getir(new Model_Urun(urun_Id));
        return new Object[]{super.getId(), urun.getAd(), tedarikci.getAd(), adet, tutar, eklenme_tarih};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Ürün", "Tedarikçi", "Adet", "Tutar", "Eklenme Tarih"};
    }

    @Override
    public String getInsert() {
        String sorgu = "insert into " + super.getTabloAd()
                + " (urun_Id,tedarikci_Id,adet,tutar,eklenme_tarih) values("
                + urun_Id + ", " + tedarikci_Id + ", " + adet + ", " + tutar + ", '" + eklenme_tarih + "'"
                + ")";
        return sorgu;
    }

    @Override
    public String getUpdate() {
        String sorgu = "update " + super.getTabloAd() + " set "
                + "urun_Id=" + urun_Id + ", tedarikci_Id=" + tedarikci_Id + ", adet=" + adet + ", tutar=" + tutar + ", eklenme_tarih='" + eklenme_tarih + "'"
                + "' Where Id=" + super.getId();
        return sorgu;
    }

    @Override
    public String getSearch(String value) {
        String sorgu = "select * from " + super.getTabloAd()
                + " Where eklenme_tarih LIKE '%" + value + "%'";
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
