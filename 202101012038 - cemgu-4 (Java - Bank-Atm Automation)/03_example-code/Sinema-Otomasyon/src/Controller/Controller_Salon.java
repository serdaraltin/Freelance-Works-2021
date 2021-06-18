package Controller;

import Interface.Interface_Controller;
import Model.Model_Salon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_Salon implements Interface_Controller<Model_Salon> {

    String tablo = "salon";
    Controller_Veritabani veritabani = new Controller_Veritabani();
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public Controller_Salon() {
        try {
            connection = veritabani.Baglanti();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Film.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean Kontrol(Model_Salon veri) {
        try {
            connection = veritabani.Baglanti();
            String sorgu = "Select * From " + tablo
                    + " Where ad='" + veri.getAd() + "' or Id=" + veri.getId();
            resultSet = statement.executeQuery(sorgu);
            if (resultSet.next()) {
                resultSet.close();
                connection.close();
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Film.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList<Model_Salon> Listele(JTable Tablo) {
        try {
            connection = veritabani.Baglanti();
            String sorgu = "Select * From " + tablo;
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Salon> arrayList = new ArrayList<Model_Salon>();

            while (resultSet.next()) {
                Model_Salon kayit = new Model_Salon(
                        resultSet.getInt("Id"),
                        resultSet.getString("ad"),
                        resultSet.getInt("koltukAdet")
                );
                model.addRow(kayit.toObject());
                arrayList.add(kayit);
            }
            resultSet.close();
            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Film.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean Ekle(Model_Salon veri) {
        String sorgu = "Insert Into " + tablo + " ("
                + "ad,koltukAdet) values("
                + "'" + veri.getAd()
                + "'," + veri.getKoltukAdet() + ")";

        return veritabani.Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Model_Salon veri) {
        String sorgu = "Update " + tablo + " set "
                + "ad='" + veri.getAd()
                + "',koltukAdet=" + veri.getKoltukAdet() + " Where Id=" + veri.getId();

        return veritabani.Sorgu(sorgu);
    }

    @Override
    public boolean Sil(Model_Salon veri) {
        String sorgu = "Delete From " + tablo + " Where Id=" + veri.getId();

        return veritabani.Sorgu(sorgu);
    }

    @Override
    public Model_Salon Getir(Model_Salon veri) {
        try {
            connection = veritabani.Baglanti();
            String sorgu = "Select * From " + tablo
                    + " Where ad='" + veri.getAd() + "' or Id=" + veri.getId();
            resultSet = statement.executeQuery(sorgu);
            while (resultSet.next()) {
                veri.setId(resultSet.getInt("Id"));
                veri.setAd(resultSet.getString("ad"));
                veri.setKoltukAdet(resultSet.getInt("koltukAdet"));
            }
            resultSet.close();
            connection.close();
            return veri;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Model_Salon> Ara(JTable Tablo, String aranan) {
        try {
            connection = veritabani.Baglanti();
            String sorgu = "Select * From " + tablo + " Where ad LIKE '%" + aranan + "%'";
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Salon> arrayList = new ArrayList<Model_Salon>();

            while (resultSet.next()) {
                Model_Salon kayit = new Model_Salon(
                        resultSet.getInt("Id"),
                        resultSet.getString("ad"),
                        resultSet.getInt("koltukAdet")
                );
                model.addRow(kayit.toObject());
                arrayList.add(kayit);
            }
            resultSet.close();
            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Film.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
