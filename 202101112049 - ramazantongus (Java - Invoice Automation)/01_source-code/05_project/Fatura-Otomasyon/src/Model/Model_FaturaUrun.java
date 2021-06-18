package Model;

import Controller.Controller_Fatura;
import Controller.Controller_Musteri;
import Controller.Controller_Urun;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model_FaturaUrun extends Model_Main {

    private int fatura_Id;
    private int urun_Id;
    private int adet;
    private int tutar;

    public Model_FaturaUrun() {
        super.setTabloAd("fatura_urun");
    }

    public Model_FaturaUrun(int Id) {
        super(Id);
    }

    public Model_FaturaUrun(ResultSet resultSet) {
        try {
            super.setId(resultSet.getInt("Id"));
            fatura_Id = resultSet.getInt("fatura_Id");
            urun_Id = resultSet.getInt("urun_Id");
            adet = resultSet.getInt("adet");
            tutar = resultSet.getInt("tutar");
        } catch (SQLException ex) {
            Logger.getLogger(Model_FaturaUrun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Model_FaturaUrun(int fatura_Id, int urun_Id, int adet, int tutar) {
        this.fatura_Id = fatura_Id;
        this.urun_Id = urun_Id;
        this.adet = adet;
        this.tutar = tutar;
    }

    public Model_FaturaUrun(int Id, int fatura_Id, int urun_Id, int adet, int tutar) {
        super(Id);
        this.fatura_Id = fatura_Id;
        this.urun_Id = urun_Id;
        this.adet = adet;
        this.tutar = tutar;
    }

    public int getFatura_Id() {
        return fatura_Id;
    }

    public void setFatura_Id(int fatura_Id) {
        this.fatura_Id = fatura_Id;
    }

    public int getUrun_Id() {
        return urun_Id;
    }

    public void setUrun_Id(int urun_Id) {
        this.urun_Id = urun_Id;
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

    @Override
    public String toString() {
        return "Model_FaturaUrun{Id=" + super.getId() + ", fatura_Id=" + fatura_Id + ", urun_Id=" + urun_Id + ", adet=" + adet + ", tutar=" + tutar + '}';
    }

    @Override
    public Object[] getObject() {
        Model_Fatura fatura = new Controller_Fatura().Getir(new Model_Fatura(fatura_Id));
        Model_Musteri musteri = new Controller_Musteri().Getir(new Model_Musteri(fatura.getMusteri_Id()));
        Model_Urun urun = new Controller_Urun().Getir(new Model_Urun(urun_Id));
        return new Object[]{super.getId(), musteri.getAd() + " " + musteri.getSoyad() + " [" + musteri.getTcno() + "]", urun.getAd(), adet, tutar};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Müşteri", "Ürün", "Adet", "Tutar"};
    }

    @Override
    public String getInsert() {
        String sorgu = "insert into " + super.getTabloAd()
                + " (fatura_Id, urun_Id, adet, tutar) values("
                + fatura_Id + ", " + urun_Id + ", " + adet + ", " + tutar
                + ")";
        return sorgu;
    }

    @Override
    public String getUpdate() {
        String sorgu = "update " + super.getTabloAd() + " set "
                + "fatura_Id=" + fatura_Id + ", urun_Id=" + urun_Id + ", adet=" + adet + ", tutar=" + tutar
                + " Where Id=" + super.getId();
        return sorgu;
    }

    @Override
    public String getSearch(String value) {
        String sorgu = "select * from " + super.getTabloAd()
                + "fatura_Id=" + value + "%' or"
                + "urun_Id=" + value + " or "
                + "adet=" + value;
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
