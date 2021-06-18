package Controller;

import Model.Model_Main;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public abstract class Controller_Main implements Interface.Interface_Main {

    private String tabloAd;
    private Model_Main model;
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    

    public Controller_Main(Model_Main model) {
        try {
            this.tabloAd = model.getTabloAd();
            this.model = model;
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean Kontrol(int Id) {
        String sorgu = "Select * From " + tabloAd + " Where Id=" + Id;

        try {
            connection = new Controller_Veritabani().Baglanti();
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
            Logger.getLogger(Controller_Main.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean Sil(int Id) {
        String sorgu = "Delete From " + tabloAd + " Where Id=" + Id;     
        return new Controller_Veritabani().Sorgu(sorgu);
    }

    public String getTabloAd() {
        return tabloAd;
    }

    public void setTabloAd(String tabloAd) {
        this.tabloAd = tabloAd;
    }

    @Override
    public String toString() {
        return "Controller_Main{" + "tabloAd=" + tabloAd + '}';
    }

    @Override
    public void Guncelle(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Ac() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Model_Main getModel() {
        return model;
    }

    public void setModel(Model_Main model) {
        this.model = model;
    }

    @Override
    public ArrayList<Model_Main> Listele(JTable Tablo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Ekle(Model_Main model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Guncelle(Model_Main model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model_Main Getir(Model_Main model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
