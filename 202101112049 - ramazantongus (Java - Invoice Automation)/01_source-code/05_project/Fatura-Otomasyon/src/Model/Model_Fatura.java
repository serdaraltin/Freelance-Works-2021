package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model_Fatura extends Model_Main {

    private int musteri_Id;
    private int toplam_tutar;
    private String tarih;

    public Model_Fatura() {
        super.setTabloAd("fatura");
    }

    public Model_Fatura(int musteri_Id, String tarih) {
        this.musteri_Id = musteri_Id;
        this.tarih = tarih;
    }

    public Model_Fatura(ResultSet resultSet) {
        try {
            super.setId(resultSet.getInt("Id"));
            musteri_Id = resultSet.getInt("musteri_Id");
            toplam_tutar = resultSet.getInt("toplam_tutar");
            tarih = resultSet.getString("tarih");
        } catch (SQLException ex) {
            Logger.getLogger(Model_Fatura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Model_Fatura(int Id) {
        super(Id);
    }

    public Model_Fatura(int musteri_Id, int toplam_tutar, String tarih) {
        this.musteri_Id = musteri_Id;
        this.toplam_tutar = toplam_tutar;
        this.tarih = tarih;
    }

    public Model_Fatura(int Id, int musteri_Id, int toplam_tutar, String tarih) {
        super(Id);
        this.musteri_Id = musteri_Id;
        this.toplam_tutar = toplam_tutar;
        this.tarih = tarih;
    }

    public int getMusteri_Id() {
        return musteri_Id;
    }

    public void setMusteri_Id(int musteri_Id) {
        this.musteri_Id = musteri_Id;
    }

    public int getToplam_tutar() {
        return toplam_tutar;
    }

    public void setToplam_tutar(int toplam_tutar) {
        this.toplam_tutar = toplam_tutar;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    @Override
    public String toString() {
        return "Model_Fatura{Id=" + super.getId() + ", musteri_Id=" + musteri_Id + ", toplam_tutar=" + toplam_tutar + ", tarih=" + tarih + '}';
    }

    @Override
    public Object[] getObject() {
        Model_Musteri musteri = new Controller.Controller_Musteri().Getir(new Model_Musteri(musteri_Id));
        String musteriAdSoyad = musteri.getAd() + " " + musteri.getSoyad() + " [" + musteri.getTcno() + "]";
        return new Object[]{super.getId(), musteriAdSoyad, toplam_tutar, tarih};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Müşteri", "Toplam Tutar", "Tarih"};
    }

    @Override
    public String getInsert() {
        String sorgu = "insert into " + super.getTabloAd()
                + " (musteri_Id,toplam_tutar,tarih) values("
                + musteri_Id + "," + 0 + ",'" + tarih + "')";
        return sorgu;
    }

    @Override
    public String getUpdate() {
        String sorgu = "update " + super.getTabloAd() + " set "
                + "musteri_Id=" + musteri_Id
                + ",toplam_tutar=" + toplam_tutar
                + ",tarih='" + tarih
                + "' Where Id=" + super.getId();
        return sorgu;
    }

    @Override
    public String getSearch(String value) {
        String sorgu = "select * from " + super.getTabloAd()
                + " Where musteri_Id=" + value;
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
