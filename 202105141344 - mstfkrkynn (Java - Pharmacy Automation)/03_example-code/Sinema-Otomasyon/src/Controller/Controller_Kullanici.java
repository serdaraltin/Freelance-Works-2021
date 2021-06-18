package Controller;

import Interface.Interface_Controller;
import Model.Model_Kullanici;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public class Controller_Kullanici implements Interface_Controller<Model_Kullanici> {

    String tablo = "kullanici";
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Override
    public boolean Kontrol(Model_Kullanici veri) {
        try {
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            String sorgu = "Select * From " + tablo
                    + " Where kullaniciAd='" + veri.getKullaniciAd() + "' and parola='" + veri.getParola() + "'";
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
    public ArrayList<Model_Kullanici> Listele(JTable Tablo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Ekle(Model_Kullanici veri) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Guncelle(Model_Kullanici veri) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Sil(Model_Kullanici veri) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model_Kullanici Getir(Model_Kullanici veri) {
        try {
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            String sorgu = "Select * From " + tablo
                    + " Where kullaniciAd='" + veri.getKullaniciAd() + "' and parola='" + veri.getParola() + "'";
            resultSet = statement.executeQuery(sorgu);

            while (resultSet.next()) {
                veri.setId(resultSet.getInt("Id"));
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
    public ArrayList<Model_Kullanici> Ara(JTable Tablo, String aranan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
