package Controller;

import Model.Model_Kullanici;
import Model.Model_Main;
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
            Logger.getLogger(Controller_Kullanici.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Controller_Kullanici.class.getName()).log(Level.SEVERE, null, ex);
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
                        resultSet.getString("tip"),
                        resultSet.getString("kullanici_ad"),
                        resultSet.getString("parola")
                );

                model.addRow(
                        kayit.getObject()
                );

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
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd() + " Where "
                    + " tip LIKE '%" + aranan + "%' or kullanici_ad LIKE '%" + aranan + "%' or parola LIKE '%" + aranan + "%'";
            ;
            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_Kullanici kayit = new Model_Kullanici(
                        resultSet.getInt("Id"),
                        resultSet.getString("tip"),
                        resultSet.getString("kullanici_ad"),
                        resultSet.getString("parola")
                );

                model.addRow(
                        kayit.getObject()
                );
                arrayList.add(kayit);
            }
            resultSet.close();
            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean Ekle(Model_Main model) {
        Model_Kullanici model2 = (Model_Kullanici) model;
        String sorgu = "Insert Into " + super.getTabloAd() + " ("
                + "tip,kullanici_ad,parola) values('"
                + model2.getTip() + "','"
                + model2.getKullanici_ad() + "','"
                + model2.getParola() + "'"
                + ")";

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Model_Main model) {
        Model_Kullanici model2 = (Model_Kullanici) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "tip='" + model2.getTip()
                + "',kullanici_ad='" + model2.getKullanici_ad()
                + "',parola='" + model2.getParola()
                + "' Where Id=" + model2.getId();

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    @Override
    public Model_Kullanici Getir(Model_Main model) {
        Model_Kullanici model2 = (Model_Kullanici) model;
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where kullanici_ad='" + model2.getKullanici_ad() + "' and parola='" + model2.getParola() + "'";
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            while (resultSet.next()) {
                model2.setId(resultSet.getInt("Id"));
                model2.setTip(resultSet.getString("tip"));
                model2.setKullanici_ad(resultSet.getString("kullanici_ad"));
                model2.setParola(resultSet.getString("parola"));
            }
            resultSet.close();
            connection.close();
            return model2;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Guncelle(int Id) {
        new View.View_Kullanici(Id).setVisible(true);
    }

    @Override
    public void Ac() {
        new View.View_Kullanici().setVisible(true);
    }
}
