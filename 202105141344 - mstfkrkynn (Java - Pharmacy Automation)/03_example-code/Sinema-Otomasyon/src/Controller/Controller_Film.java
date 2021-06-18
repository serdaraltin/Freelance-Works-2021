package Controller;

import Interface.Interface_Controller;
import Model.Model_Film;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_Film implements Interface_Controller<Model_Film> {

    String tablo = "film";
    Controller_Veritabani veritabani = new Controller_Veritabani();
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public Controller_Film() {
        try {
            connection = veritabani.Baglanti();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Film.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean Kontrol(Model_Film veri) {
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
            resultSet.close();
            connection.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Film.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList<Model_Film> Listele(JTable Tablo) {
        try {
            connection = veritabani.Baglanti();
            String sorgu = "Select * From " + tablo;
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Film> arrayList = new ArrayList<Model_Film>();

            while (resultSet.next()) {
                Model_Film kayit = new Model_Film(
                        resultSet.getInt("Id"),
                        resultSet.getString("ad"),
                        resultSet.getString("kategori"),
                        resultSet.getString("yonetmen"),
                        resultSet.getInt("yil")
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
    public boolean Ekle(Model_Film veri) {
        String sorgu = "Insert Into " + tablo + " ("
                + "ad,kategori,yonetmen,yil) values("
                + "'" + veri.getAd()
                + "','" + veri.getKategori()
                + "','" + veri.getYonetmen()
                + "'," + veri.getYil() + ")";

        return veritabani.Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Model_Film veri) {
        String sorgu = "Update " + tablo + " set "
                + "ad='" + veri.getAd()
                + "',kategori='" + veri.getKategori()
                + "',yonetmen='" + veri.getYonetmen()
                + "',yil=" + veri.getYil() + " Where Id=" + veri.getId();

        return veritabani.Sorgu(sorgu);
    }

    @Override
    public boolean Sil(Model_Film veri) {
        String sorgu = "Delete From " + tablo + " Where Id=" + veri.getId();

        return veritabani.Sorgu(sorgu);
    }

    @Override
    public Model_Film Getir(Model_Film veri) {
        try {
            connection = veritabani.Baglanti();
            String sorgu = "Select * From " + tablo
                    + " Where ad='" + veri.getAd() + "' or Id=" + veri.getId();
            resultSet = statement.executeQuery(sorgu);
            while (resultSet.next()) {
                veri.setId(resultSet.getInt("Id"));
                veri.setAd(resultSet.getString("ad"));
                veri.setKategori(resultSet.getString("kategori"));
                veri.setYonetmen(resultSet.getString("yonetmen"));
                veri.setYil(resultSet.getInt("yil"));
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
    public ArrayList<Model_Film> Ara(JTable Tablo, String aranan) {
        try {
            connection = veritabani.Baglanti();
            String sorgu = "Select * From " + tablo
                    + " Where ad LIKE '%" + aranan
                    + "%' or kategori LIKE '%" + aranan
                    + "%' or yonetmen LIKE '%" + aranan + "%'";
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Film> arrayList = new ArrayList<Model_Film>();

            while (resultSet.next()) {
                Model_Film kayit = new Model_Film(
                        resultSet.getInt("Id"),
                        resultSet.getString("ad"),
                        resultSet.getString("kategori"),
                        resultSet.getString("yonetmen"),
                        resultSet.getInt("yil")
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
