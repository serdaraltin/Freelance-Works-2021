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
                Model_Kullanici kayit = new Model_Kullanici(resultSet);
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
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        try {
            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(new Model_Kullanici().getSearch(aranan));
            
            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();
            
            while (resultSet.next()) {
                Model_Kullanici kayit = new Model_Kullanici(resultSet);
                model.addRow(kayit.getObject());
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
        model2.setTabloAd(super.getTabloAd());
        return new Controller_Veritabani().Sorgu(model2.getInsert());
    }
    
    @Override
    public boolean Guncelle(Model_Main model) {
        Model_Kullanici model2 = (Model_Kullanici) model;
        model2.setTabloAd(super.getTabloAd());
        return new Controller_Veritabani().Sorgu(model2.getUpdate());
    }
    
    @Override
    public Model_Kullanici Getir(Model_Main model) {
        Model_Kullanici model2 = (Model_Kullanici) model;
        model2.setTabloAd(super.getTabloAd());
        try {
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(model.getGet());
            while (resultSet.next()) {
                model2 = new Model_Kullanici(resultSet);
                resultSet.close();
                connection.close();
                return model2;
            }
            resultSet.close();
            connection.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Kategori.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Model_Kullanici Getir(String kullanici_ad, String parola) {
        Model_Kullanici kullanici = new Model_Kullanici(kullanici_ad, parola);
        kullanici.setTabloAd(super.getTabloAd());
        try {
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(kullanici.getControl());
            
            while (resultSet.next()) {
                kullanici = new Model_Kullanici(resultSet);
                resultSet.close();
                connection.close();
                return kullanici;
            }
            resultSet.close();
            connection.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Kategori.class.getName()).log(Level.SEVERE, null, ex);
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
    
    @Override
    public boolean Kontrol(Model_Main model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
