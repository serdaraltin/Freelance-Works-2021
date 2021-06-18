package Controller;

import Model.Model_Main;
import Model.Model_Personel;
import View.View_Personel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_Personel extends Controller_Main {

    public Controller_Personel() {
        super(new Model_Personel());
    }

    @Override
    public boolean Ekle(Model_Main model) {
        Model_Personel personel = (Model_Personel) model;
        String sorgu = "Insert Into " + super.getTabloAd() + "(kullanici_ad,parola,tcno,ad,soyad,telefon,adres,maas) values("
                + "'" + personel.getKullanici_ad() + "',"
                + "'" + personel.getParola() + "',"
                + "'" + personel.getTcno() + "',"
                + "'" + personel.getAd() + "',"
                + "'" + personel.getSoyad() + "',"
                + "'" + personel.getTelefon() + "',"
                + "'" + personel.getAdres() + "',"
                + personel.getMaas()
                + ")";

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Model_Main model) {
        Model_Personel model2 = (Model_Personel) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "kullanici_ad='" + model2.getKullanici_ad()
                + "',parola='" + model2.getParola()
                + "',tcno='" + model2.getTcno()
                + "',ad='" + model2.getAd()
                + "',soyad='" + model2.getSoyad()
                + "',telefon='" + model2.getTelefon()
                + "',adres='" + model2.getAdres()
                 + "',maas=" + model2.getMaas()
                + " Where Id=" + model2.getId();

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    public boolean Kontrol(String kullanici_ad, String parola) {
        try {
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where kullanici_ad='" + kullanici_ad + "' and parola='" + parola + "'";
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
            Logger.getLogger(Model_Personel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Kontrol(String kullanici_ad) {
        try {
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where kullanici_ad='" + kullanici_ad + "'";
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
            Logger.getLogger(Model_Personel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Model_Personel Getir(int Id) {
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where Id=" + Id;
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            Model_Personel personel = new Model_Personel();
            while (resultSet.next()) {
                personel.setId(resultSet.getInt("Id"));
                personel.setKullanici_ad(resultSet.getString("kullanici_ad"));
                personel.setParola(resultSet.getString("parola"));
                personel.setTcno(resultSet.getString("tcno"));
                personel.setAd(resultSet.getString("ad"));
                personel.setSoyad(resultSet.getString("soyad"));
                personel.setTelefon(resultSet.getString("telefon"));
                personel.setAdres(resultSet.getString("adres"));
                personel.setMaas(resultSet.getInt("maas"));
            }
            resultSet.close();
            connection.close();
            return personel;
        } catch (SQLException ex) {
            Logger.getLogger(Model_Personel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd() + " Where "
                    + " kullanici_ad LIKE '%" + aranan + "%' or "
                    + " parola LIKE '%" + aranan + "%' or "
                    + " tcno LIKE '%" + aranan + "%' or "
                    + " ad LIKE '%" + aranan + "%' or "
                    + " soyad LIKE '%" + aranan + "%' or "
                    + " telefon LIKE '%" + aranan + "%' or "
                    + " adres LIKE '%" + aranan + "%' or "
                    + " maas=" + aranan;
            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_Personel kayit = new Model_Personel(
                        resultSet.getInt("Id"),
                        resultSet.getString("kullanici_ad"),
                        resultSet.getString("parola"),
                        resultSet.getString("tcno"),
                        resultSet.getString("ad"),
                        resultSet.getString("soyad"),
                        resultSet.getString("telefon"),
                        resultSet.getString("adres"),
                        resultSet.getInt("maas")
                );

                model.addRow(kayit.getObject());

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Personel.class.getName()).log(Level.SEVERE, null, ex);
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
                Model_Personel kayit = new Model_Personel(
                        resultSet.getInt("Id"),
                        resultSet.getString("kullanici_ad"),
                        resultSet.getString("parola"),
                        resultSet.getString("tcno"),
                        resultSet.getString("ad"),
                        resultSet.getString("soyad"),
                        resultSet.getString("telefon"),
                        resultSet.getString("adres"),
                        resultSet.getInt("maas")
                );

                model.addRow(kayit.getObject());

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Personel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Ac() {
        new View_Personel().setVisible(true);
    }

    @Override
    public void Guncelle(int Id) {
        new View_Personel(Id).setVisible(true);
    }

}
