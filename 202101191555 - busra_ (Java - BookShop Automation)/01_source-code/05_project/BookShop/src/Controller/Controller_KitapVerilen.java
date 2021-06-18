package Controller;

import Model.Model_KitapVerilen;
import Model.Model_KitapVerilen;
import Model.Model_Main;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_KitapVerilen extends Controller_Main {

    public Controller_KitapVerilen() {
        super(new Model_KitapVerilen());
    }

    public boolean Kontrol(int kitap_id) {
        try {
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where kitap_id=" + kitap_id;
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
            Logger.getLogger(Controller_KitapVerilen.class.getName()).log(Level.SEVERE, null, ex);
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
                Model_KitapVerilen kayit = new Model_KitapVerilen(resultSet);
                model.addRow(kayit.getObject());
                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_KitapVerilen.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        try {
            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(new Model_KitapVerilen().getSearch(aranan));

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_KitapVerilen kayit = new Model_KitapVerilen(resultSet);
                model.addRow(kayit.getObject());
                arrayList.add(kayit);
            }
            resultSet.close();
            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_KitapVerilen.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean Ekle(Model_Main model) {
        Model_KitapVerilen model2 = (Model_KitapVerilen) model;
        model2.setTabloAd(super.getTabloAd());
        return new Controller_Veritabani().Sorgu(model2.getInsert());
    }

    @Override
    public boolean Guncelle(Model_Main model) {
        Model_KitapVerilen model2 = (Model_KitapVerilen) model;
        model2.setTabloAd(super.getTabloAd());
        return new Controller_Veritabani().Sorgu(model2.getUpdate());
    }

    @Override
    public Model_KitapVerilen Getir(Model_Main model) {
        Model_KitapVerilen model2 = (Model_KitapVerilen) model;
        model2.setTabloAd(super.getTabloAd());
        try {
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
    
            resultSet = statement.executeQuery(model2.getGet());
            while (resultSet.next()) {
                model2 = new Model_KitapVerilen(resultSet);
              
                resultSet.close();
                connection.close();
                return model2;
            }
            resultSet.close();
            connection.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Model_KitapVerilen.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Guncelle(int Id) {
        new View.View_KitapVerilen(Id).setVisible(true);
    }

    @Override
    public void Ac() {
        new View.View_KitapVerilen().setVisible(true);
    }

    @Override
    public boolean Kontrol(Model_Main model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
