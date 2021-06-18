package Controller;

import Model.Model_Main;
import Model.Model_Kullanici;
import View.View_Kullanici;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_Kullanici extends Controller_Main {

    public Controller_Kullanici() {
        super(new Model_Kullanici());
    }

    @Override
    public boolean Ekle(Model_Main model) {
        Model_Kullanici kullanici = (Model_Kullanici) model;
        String sorgu = "Insert Into " + super.getTabloAd()
                + "(kullaniciAd,parola,personelId,yetki)"
                + " values("
                + "'" + kullanici.getKullaniciAd() + "',"
                + "'" + kullanici.getParola() + "',"
                + kullanici.getPersonelId() + ","
                + kullanici.getYetki()
                + ")";

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Model_Main model) {
        Model_Kullanici model2 = (Model_Kullanici) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "kullaniciAd='" + model2.getKullaniciAd()
                + "',parola='" + model2.getParola()
                + "',personelId=" + model2.getPersonelId()
                + ",yetki=" + model2.getYetki()
                + " Where Id=" + model2.getId();

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    public Model_Kullanici Getir(int Id) {
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where Id=" + Id;
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            Model_Kullanici kullanici = new Model_Kullanici();
            while (resultSet.next()) {
                kullanici.setId(resultSet.getInt("Id"));
                kullanici.setKullaniciAd(resultSet.getString("kullaniciAd"));
                kullanici.setParola(resultSet.getString("parola"));
                kullanici.setPersonelId(resultSet.getInt("personelId"));
                kullanici.setYetki(resultSet.getInt("yetki"));
            }
            resultSet.close();
            connection.close();
            return kullanici;
        } catch (SQLException ex) {
            Logger.getLogger(Model_Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Model_Kullanici Getir(String kullanici_ad, String parola) {
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where kullaniciAd='" + kullanici_ad + "' and parola='" + parola + "'";
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            Model_Kullanici kullanici = new Model_Kullanici();
            while (resultSet.next()) {
                kullanici.setId(resultSet.getInt("Id"));
                kullanici.setKullaniciAd(resultSet.getString("kullaniciAd"));
                kullanici.setParola(resultSet.getString("parola"));
                kullanici.setPersonelId(resultSet.getInt("personelId"));
                kullanici.setYetki(resultSet.getInt("yetki"));
            }
            resultSet.close();
            connection.close();
            return kullanici;
        } catch (SQLException ex) {
            Logger.getLogger(Model_Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd() + " Where "
                    + " kullaniciAd LIKE '%" + aranan + "%' or "
                    + " parola LIKE '%" + aranan + "%' or "
                    + " personelId=" + aranan + " or"
                    + " yetki=" + aranan;
            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_Kullanici kayit = new Model_Kullanici(
                        resultSet.getInt("Id"),
                        resultSet.getString("kullaniciAd"),
                        resultSet.getString("perola"),
                        resultSet.getInt("personelId"),
                        resultSet.getInt("yetki")
                );

                model.addRow(kayit.getObject());

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean Kontrol(String kullanici_ad, String parola) {
        try {
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where kullaniciAd='" + kullanici_ad + "' and parola='" + parola + "'";
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
            Logger.getLogger(Model_Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Kontrol(String kullaniciAd) {
        try {
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where kullaniciAd='" + kullaniciAd + "'";
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
            Logger.getLogger(Model_Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return false;
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
                Model_Kullanici kayit = new Model_Kullanici(
                        resultSet.getInt("Id"),
                        resultSet.getString("kullaniciAd"),
                        resultSet.getString("parola"),
                        resultSet.getInt("personelId"),
                        resultSet.getInt("yetki")
                );

                model.addRow(kayit.getObject());

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Ac() {
        new View_Kullanici().setVisible(true);
    }

    @Override
    public void Guncelle(int Id) {
        new View_Kullanici(Id).setVisible(true);
    }

}
