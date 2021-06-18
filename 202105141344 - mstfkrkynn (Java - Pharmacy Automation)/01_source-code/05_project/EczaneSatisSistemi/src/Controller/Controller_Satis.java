package Controller;

import Model.Model_Main;
import Model.Model_Satis;
import View.View_Satis;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_Satis extends Controller_Main {

    public Controller_Satis() {
        super(new Model_Satis());
    }

    @Override
    public boolean Ekle(Model_Main model) {
        Model_Satis item = (Model_Satis) model;
        String sorgu = "Insert Into " + super.getTabloAd() + "(ilac_id,musteri_id,personel_id,tarih) values("
                + item.getIlac_id() + ","
                + item.getMusteri_id() + ","
                + item.getPersonel_id() + ","
                + "'" + item.getTarih() + "'"
                + ")";
        return new Controller_Veritabani().Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Model_Main model) {
        Model_Satis item = (Model_Satis) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "ilac_id=" + item.getIlac_id() + ","
                + "musteri_id=" + item.getMusteri_id() + ","
                + "personel_id=" + item.getPersonel_id() + ","
                + "tarih='" + item.getTarih() + "'"
                + " Where Id=" + item.getId();

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    public boolean Kontrol(int Id) {
        try {
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where Id=" + Id;
            resultSet = statement.executeQuery(sorgu);
            while (resultSet.next()) {
                resultSet.close();
                connection.close();
                return true;
            }
            resultSet.close();
            connection.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Model_Satis.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Model_Satis Getir(int Id) {
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where Id=" + Id;
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            Model_Satis item = new Model_Satis();
            while (resultSet.next()) {
                item.setId(resultSet.getInt("Id"));
                item.setIlac_id(resultSet.getInt("ilac_id"));
                item.setMusteri_id(resultSet.getInt("musteri_id"));
                item.setPersonel_id(resultSet.getInt("personel_id"));
                item.setTarih(resultSet.getString("tarih"));
            }
            resultSet.close();
            connection.close();
            return item;
        } catch (SQLException ex) {
            Logger.getLogger(Model_Satis.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd() + " Where "
                    + " tarih LIKE '%" + aranan + "%'";
            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_Satis kayit = new Model_Satis(
                        resultSet.getInt("Id"),
                        resultSet.getInt("ilac_id"),
                        resultSet.getInt("musteri_id"),
                        resultSet.getInt("personel_id"),
                        resultSet.getString("tarih")
                );

                model.addRow(new Object[]{
                    kayit.getId(),
                    new Controller_Ilac().Getir(kayit.getIlac_id()).getAd(),
                    new Controller_Musteri().Getir(kayit.getMusteri_id()).getAd() + " " + new Controller_Musteri().Getir(kayit.getMusteri_id()).getAd(),
                    new Controller_Personel().Getir(kayit.getPersonel_id()).getAd() + " " + new Controller_Personel().Getir(kayit.getPersonel_id()).getAd(),
                    kayit.getTarih()
                }
                );

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Satis.class.getName()).log(Level.SEVERE, null, ex);
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
                Model_Satis kayit = new Model_Satis(
                        resultSet.getInt("Id"),
                        resultSet.getInt("ilac_id"),
                        resultSet.getInt("musteri_id"),
                        resultSet.getInt("personel_id"),
                        resultSet.getString("tarih")
                );
                model.addRow(new Object[]{
                    kayit.getId(),
                    new Controller_Ilac().Getir(kayit.getIlac_id()).getAd(),
                    new Controller_Musteri().Getir(kayit.getMusteri_id()).getAd() + " " + new Controller_Musteri().Getir(kayit.getMusteri_id()).getAd(),
                    new Controller_Personel().Getir(kayit.getPersonel_id()).getAd() + " " + new Controller_Personel().Getir(kayit.getPersonel_id()).getAd(),
                    kayit.getTarih()
                }
                );

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Satis.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Ac() {
        new View_Satis().setVisible(true);
    }

    @Override
    public void Guncelle(int Id) {
        new View_Satis(Id).setVisible(true);
    }

}
