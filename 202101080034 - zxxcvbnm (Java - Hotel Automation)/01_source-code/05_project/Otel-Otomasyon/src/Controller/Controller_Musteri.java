package Controller;

import Model.Model_Main;
import Model.Model_Musteri;
import View.View_Musteri;
import View.View_Personel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_Musteri extends Controller_Main {

    public Controller_Musteri() {
        super(new Model_Musteri());
    }

    @Override
    public boolean Ekle(Model_Main model) {
        Model_Musteri musteri = (Model_Musteri) model;
        String sorgu = "Insert Into " + super.getTabloAd() + "(tcno,ad,soyad,telefon,adres) values("
                + "'" + musteri.getTcno() + "',"
                + "'" + musteri.getAd() + "',"
                + "'" + musteri.getSoyad() + "',"
                + "'" + musteri.getTelefon() + "',"
                + "'" + musteri.getAdres() + "'"
                + ")";
        return new Controller_Veritabani().Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Model_Main model) {
        Model_Musteri model2 = (Model_Musteri) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "tcno='" + model2.getTcno()
                + "',ad='" + model2.getAd()
                + "',soyad='" + model2.getSoyad()
                + "',telefon='" + model2.getTelefon()
                + "',adres='" + model2.getAdres()
                + "' Where Id=" + model2.getId();

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    public boolean Kontrol(String tcno) {
        try {
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where tcno='" + tcno + "'";
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
            Logger.getLogger(Model_Musteri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Model_Musteri Getir(int Id) {
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where Id=" + Id;
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            Model_Musteri personel = new Model_Musteri();
            while (resultSet.next()) {
                personel.setId(resultSet.getInt("Id"));
                personel.setTcno(resultSet.getString("tcno"));
                personel.setAd(resultSet.getString("ad"));
                personel.setSoyad(resultSet.getString("soyad"));
                personel.setTelefon(resultSet.getString("telefon"));
                personel.setAdres(resultSet.getString("adres"));
            }
            resultSet.close();
            connection.close();
            return personel;
        } catch (SQLException ex) {
            Logger.getLogger(Model_Musteri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd() + " Where "
                    + " tcno LIKE '%" + aranan + "%' or "
                    + " ad LIKE '%" + aranan + "%' or "
                    + " soyad LIKE '%" + aranan + "%' or "
                    + " telefon LIKE '%" + aranan + "%' or "
                    + " adres LIKE '%" + aranan + "%'";
            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_Musteri kayit = new Model_Musteri(
                        resultSet.getInt("Id"),
                        resultSet.getString("tcno"),
                        resultSet.getString("ad"),
                        resultSet.getString("soyad"),
                        resultSet.getString("telefon"),
                        resultSet.getString("adres")
                );

                model.addRow(kayit.getObject());

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Musteri.class.getName()).log(Level.SEVERE, null, ex);
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
                Model_Musteri kayit = new Model_Musteri(
                        resultSet.getInt("Id"),
                        resultSet.getString("tcno"),
                        resultSet.getString("ad"),
                        resultSet.getString("soyad"),
                        resultSet.getString("telefon"),
                        resultSet.getString("adres")
                );

                model.addRow(kayit.getObject());

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Musteri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Ac() {
        new View_Musteri().setVisible(true);
    }

    @Override
    public void Guncelle(int Id) {
        new View_Musteri(Id).setVisible(true);
    }

}
