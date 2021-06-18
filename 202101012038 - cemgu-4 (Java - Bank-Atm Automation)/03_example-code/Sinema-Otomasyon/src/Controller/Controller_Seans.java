package Controller;

import Interface.Interface_Controller;
import Model.Model_Film;
import Model.Model_Salon;
import Model.Model_Seans;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_Seans implements Interface_Controller<Model_Seans> {

    String tablo = "seans";
    Controller_Veritabani veritabani = new Controller_Veritabani();
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public Controller_Seans() {
        try {
            connection = veritabani.Baglanti();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Film.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean Kontrol(Model_Seans veri) {
        try {
            connection = veritabani.Baglanti();
            String sorgu = "Select * From " + tablo
                    + " Where tarih='" + veri.getTarih() + "' and filmId=" + veri.getFilmId() + " and salonId=" + veri.getSalonId();
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
    public ArrayList<Model_Seans> Listele(JTable Tablo) {
        try {
            connection = veritabani.Baglanti();
            String sorgu = "Select * From " + tablo;
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Seans> arrayList = new ArrayList<Model_Seans>();

            while (resultSet.next()) {
                Model_Seans kayit = new Model_Seans(
                        resultSet.getInt("Id"),
                        resultSet.getInt("filmId"),
                        resultSet.getInt("salonId"),
                        resultSet.getString("tarih")
                );
                model.addRow(
                        new Object[]{
                            kayit.getId(),
                            new Controller_Film().Getir(new Model_Film(kayit.getFilmId())).getAd(),
                            new Controller_Salon().Getir(new Model_Salon(kayit.getSalonId())).getAd(),
                            kayit.getTarih()
                        }
                );
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
    public boolean Ekle(Model_Seans veri) {
        String sorgu = "Insert Into " + tablo + " ("
                + "filmId,salonId,tarih) values("
                + veri.getFilmId() + ","
                + veri.getSalonId() + ",'"
                + veri.getTarih() + "'"
                + ")";

        return veritabani.Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Model_Seans veri) {
        String sorgu = "Update " + tablo + " set "
                + "filmId=" + veri.getFilmId()
                + ",salonId=" + veri.getSalonId()
                + ",tarih='" + veri.getTarih() + "'"
                + " Where Id=" + veri.getId();

        return veritabani.Sorgu(sorgu);
    }

    @Override
    public boolean Sil(Model_Seans veri) {
        String sorgu = "Delete From " + tablo + " Where Id=" + veri.getId();

        return veritabani.Sorgu(sorgu);
    }

    @Override
    public Model_Seans Getir(Model_Seans veri) {
        try {
            connection = veritabani.Baglanti();
            String sorgu = "Select * From " + tablo
                    + " Where Id=" + veri.getId();
            resultSet = statement.executeQuery(sorgu);
            while (resultSet.next()) {
                veri.setId(resultSet.getInt("Id"));
                veri.setFilmId(resultSet.getInt("filmId"));
                veri.setSalonId(resultSet.getInt("salonId"));
                veri.setTarih(resultSet.getString("tarih"));
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
    public ArrayList<Model_Seans> Ara(JTable Tablo, String aranan) {
        try {
            connection = veritabani.Baglanti();
            int filmId = new Controller_Film().Getir(new Model_Film(aranan)).getId();
            int salonId = new Controller_Salon().Getir(new Model_Salon(aranan)).getId();
            String sorgu = "Select * From " + tablo
                    + " Where tarih LIKE '%" + aranan + "%' or filmId=" + filmId + " or salonId=" + salonId;
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Seans> arrayList = new ArrayList<Model_Seans>();

            while (resultSet.next()) {
                Model_Seans kayit = new Model_Seans(
                        resultSet.getInt("Id"),
                        resultSet.getInt("filmId"),
                        resultSet.getInt("salonId"),
                        resultSet.getString("tarih")
                );
                model.addRow(
                        new Object[]{
                            kayit.getId(),
                            new Controller_Film().Getir(new Model_Film(kayit.getFilmId())).getAd(),
                            new Controller_Salon().Getir(new Model_Salon(kayit.getSalonId())).getAd(),
                            kayit.getTarih()
                        }
                );
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
