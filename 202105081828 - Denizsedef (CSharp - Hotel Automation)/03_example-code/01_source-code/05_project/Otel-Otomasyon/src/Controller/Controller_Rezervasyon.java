package Controller;

import Model.Model_Main;
import Model.Model_Rezervasyon;
import View.View_Rezervasyon;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_Rezervasyon extends Controller_Main {

    public Controller_Rezervasyon() {
        super(new Model_Rezervasyon());
    }

    @Override
    public boolean Ekle(Model_Main model) {
        Model_Rezervasyon musteri = (Model_Rezervasyon) model;
        String sorgu = "Insert Into " + super.getTabloAd() + "(oda_Id,musteri_Id,giris_tarih,cikis_tarih) values("
                + musteri.getOda_Id() + ","
                + musteri.getMusteri_Id() + ","
                + "'" + musteri.getGiris_tarih() + "',"
                + "'" + musteri.getCikis_tarih() + "'"
                + ")";
        return new Controller_Veritabani().Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Model_Main model) {
        Model_Rezervasyon model2 = (Model_Rezervasyon) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "oda_Id=" + model2.getOda_Id()
                + ",musteri_Id=" + model2.getMusteri_Id()
                + ",giris_tarih='" + model2.getGiris_tarih() + "'"
                + ",cikis_tarih='" + model2.getGiris_tarih() + "'"
                + " Where Id=" + model2.getId();

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    public boolean Kontrol(int oda_Id) {
        try {
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where oda_Id=" + oda_Id;
            resultSet = statement.executeQuery(sorgu);
            while (resultSet.next()) {
                String cikis = resultSet.getString("cikis_tarih");
                if (cikis.equals("Çıkış Yapılmadı")) {
                    resultSet.close();
                    connection.close();
                    return true;
                } 
            }
            resultSet.close();
            connection.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Model_Rezervasyon.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Model_Rezervasyon Getir(int Id) {
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where Id=" + Id;
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            Model_Rezervasyon personel = new Model_Rezervasyon();
            while (resultSet.next()) {
                personel.setId(resultSet.getInt("Id"));
                personel.setOda_Id(resultSet.getInt("oda_Id"));
                personel.setMusteri_Id(resultSet.getInt("musteri_Id"));
                personel.setGiris_tarih(resultSet.getString("giris_tarih"));
                personel.setCikis_tarih(resultSet.getString("cikis_tarih"));
            }
            resultSet.close();
            connection.close();
            return personel;
        } catch (SQLException ex) {
            Logger.getLogger(Model_Rezervasyon.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd() + " Where "
                    + " giris_tarih LIKE '%" + aranan + "%' or"
                    + " cikis_tarih LIKE '%" + aranan + "%'";
            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_Rezervasyon kayit = new Model_Rezervasyon(
                        resultSet.getInt("Id"),
                        resultSet.getInt("oda_Id"),
                        resultSet.getInt("musteri_Id"),
                        resultSet.getString("giris_tarih"),
                        resultSet.getString("cikis_tarih")
                );

                model.addRow(new Object[]{
                    kayit.getId(),
                    new Controller_Oda().Getir(kayit.getOda_Id()).getNo(),
                    new Controller_Musteri().Getir(kayit.getMusteri_Id()).getAd() + " " + new Controller_Musteri().Getir(kayit.getMusteri_Id()).getAd(),
                    kayit.getGiris_tarih(),
                    kayit.getCikis_tarih()
                }
                );

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Rezervasyon.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Model_Main> Listele(JTable Tablo) {
        try {
            String sorgu = "Select * From " + super.getTabloAd();
            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_Rezervasyon kayit = new Model_Rezervasyon(
                        resultSet.getInt("Id"),
                        resultSet.getInt("oda_Id"),
                        resultSet.getInt("musteri_Id"),
                        resultSet.getString("giris_tarih"),
                        resultSet.getString("cikis_tarih")
                );

                model.addRow(new Object[]{
                    kayit.getId(),
                    new Controller_Oda().Getir(kayit.getOda_Id()).getNo(),
                    new Controller_Musteri().Getir(kayit.getMusteri_Id()).getAd() + " " + new Controller_Musteri().Getir(kayit.getMusteri_Id()).getAd(),
                    kayit.getGiris_tarih(),
                    kayit.getCikis_tarih()
                }
                );

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Rezervasyon.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Ac() {
        new View_Rezervasyon().setVisible(true);
    }

    @Override
    public void Guncelle(int Id) {
        new View_Rezervasyon(Id).setVisible(true);
    }

}
