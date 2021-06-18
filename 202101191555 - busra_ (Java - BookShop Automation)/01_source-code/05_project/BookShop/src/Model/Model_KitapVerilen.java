package Model;

import Controller.Controller_Kitap;
import Controller.Controller_Musteri;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model_KitapVerilen extends Model_Main {

    private int kitap_id;
    private int musteri_id;
    private int gun;
    private String tarih;
    private String tarih_iade;
    private int tutar;

    public Model_KitapVerilen() {
        super.setTabloAd("kitap_verilen");
    }

    public Model_KitapVerilen(int Id) {
        super(Id);
    }

    public Model_KitapVerilen(int Id, int kitap_id, int musteri_id, int gun, String tarih, String tarih_iade, int tutar) {
        super(Id);
        this.kitap_id = kitap_id;
        this.musteri_id = musteri_id;
        this.gun = gun;
        this.tarih = tarih;
        this.tarih_iade = tarih_iade;
        this.tutar = tutar;
    }

    public Model_KitapVerilen(int Id, int kitap_id, int musteri_id, int gun, String tarih) {
        super(Id);
        this.kitap_id = kitap_id;
        this.musteri_id = musteri_id;
        this.gun = gun;
        this.tarih = tarih;
        this.tarih_iade = "";
        this.tutar = 0;
    }

    public Model_KitapVerilen(int kitap_id, int musteri_id, int gun, String tarih, String tarih_iade, int tutar) {
        this.kitap_id = kitap_id;
        this.musteri_id = musteri_id;
        this.gun = gun;
        this.tarih = tarih;
        this.tarih_iade = tarih_iade;
        this.tutar = tutar;
    }

    public Model_KitapVerilen(int kitap_id, int musteri_id, int gun, String tarih) {
        this.kitap_id = kitap_id;
        this.musteri_id = musteri_id;
        this.gun = gun;
        this.tarih = tarih;
        this.tarih_iade = "";
        this.tutar = 0;
    }

    public Model_KitapVerilen(ResultSet resultSet) {
        try {
            super.setId(resultSet.getInt("Id"));
            kitap_id = resultSet.getInt("kitap_id");
            musteri_id = resultSet.getInt("musteri_id");
            gun = resultSet.getInt("gun");
            tarih = resultSet.getString("tarih");
            tarih_iade = resultSet.getString("tarih_iade");
            tutar = resultSet.getInt("tutar");
        } catch (SQLException ex) {
            Logger.getLogger(Model_KitapVerilen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getKitap_id() {
        return kitap_id;
    }

    public void setKitap_id(int kitap_id) {
        this.kitap_id = kitap_id;
    }

    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(int musteri_id) {
        this.musteri_id = musteri_id;
    }

    public int getGun() {
        return gun;
    }

    public void setGun(int gun) {
        this.gun = gun;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getTarih_iade() {
        return tarih_iade;
    }

    public void setTarih_iade(String tarih_iade) {
        this.tarih_iade = tarih_iade;
    }

    public int getTutar() {
        return tutar;
    }

    public void setTutar(int tutar) {
        this.tutar = tutar;
    }

    @Override
    public String toString() {
        return "Model_KitapVerilen{" + "kitap_id=" + kitap_id + ", musteri_id=" + musteri_id + ", gun=" + gun + ", tarih=" + tarih + ", tarih_iade=" + tarih_iade + ", tutar=" + tutar + '}';
    }
    

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Kitap", "Müşteri", "Gün", "Tarih", "İade Tarih", "Tutar"};
    }

    @Override
    public Object[] getObject() {
        String kitap_ad = new Controller_Kitap().Getir(new Model_Kitap(kitap_id)).getAd();
        Model_Musteri musteri = new Controller_Musteri().Getir(new Model_Musteri(musteri_id));
        return new Object[]{super.getId(), kitap_ad, musteri.getAd() + " " + musteri.getSoyad(), gun, tarih, tarih_iade, tutar};
    }

    @Override
    public String getInsert() {
        String sorgu = "insert into " + super.getTabloAd()
                + " (kitap_id, musteri_id, gun,tarih,tarih_iade,tutar) values("
                + kitap_id + "," + musteri_id + "," + gun + ",'" + tarih + "','-',0"
                + ")";
        return sorgu;
    }

    @Override
    public String getUpdate() {
        String sorgu = "update " + super.getTabloAd() + " set "
                + "kitap_id=" + kitap_id + ", musteri_id=" + musteri_id + ", gun=" + gun + ",tarih='" + tarih + "',tarih_iade='" + tarih_iade + "',tutar=" + tutar
                + " Where Id=" + super.getId();
        return sorgu;
    }

    @Override
    public String getSearch(String value) {
        String sorgu = "select * from " + super.getTabloAd()
                + " Where musteri_id=" + value;

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
                + " Where kitap_id=" + kitap_id;
        return sorgu;
    }

}
