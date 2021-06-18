package Controller;

import Model.Model_Main;
import Model.Model_Departman;
import View.View_Departman;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_Departman extends Controller_Main {

    public Controller_Departman() {
        super(new Model_Departman());
    }

    @Override
    public boolean Ekle(Model_Main model) {
        Model_Departman departman = (Model_Departman) model;
        String sorgu = "Insert Into " + super.getTabloAd()
                + "(ad,amac,aciklama)"
                + " values("
                + "'" + departman.getAd() + "',"
                + "'" + departman.getAmac() + "',"
                + "'" + departman.getAciklama() + "'"
                + ")";

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Model_Main model) {
        Model_Departman model2 = (Model_Departman) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "ad='" + model2.getAd()
                + "',amac='" + model2.getAmac()
                + "',aciklama='" + model2.getAciklama()
                + "' Where Id=" + model2.getId();

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    public Model_Departman Getir(int Id) {
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where Id=" + Id;
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            Model_Departman departman = new Model_Departman();
            while (resultSet.next()) {
                departman.setId(resultSet.getInt("Id"));
                departman.setAd(resultSet.getString("ad"));
                departman.setAmac(resultSet.getString("amac"));
                departman.setAciklama(resultSet.getString("aciklama"));
            }
            resultSet.close();
            connection.close();
            return departman;
        } catch (SQLException ex) {
            Logger.getLogger(Model_Departman.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Model_Departman Getir(String ad) {
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where ad='" + ad + "'";
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            Model_Departman departman = new Model_Departman();
            while (resultSet.next()) {
                departman.setId(resultSet.getInt("Id"));
                departman.setAd(resultSet.getString("ad"));
                departman.setAmac(resultSet.getString("amac"));
                departman.setAciklama(resultSet.getString("aciklama"));
            }
            resultSet.close();
            connection.close();
            return departman;
        } catch (SQLException ex) {
            Logger.getLogger(Model_Departman.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd() + " Where "
                    + " ad LIKE '%" + aranan + "%' or "
                    + " amac LIKE '%" + aranan + "%' or "
                    + " aciklama LIKE '%" + aranan + "%'";
            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_Departman kayit = new Model_Departman(
                        resultSet.getInt("Id"),
                        resultSet.getString("ad"),
                        resultSet.getString("amac"),
                        resultSet.getString("aciklama")
                );

                model.addRow(kayit.getObject());

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Departman.class.getName()).log(Level.SEVERE, null, ex);
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
                Model_Departman kayit = new Model_Departman(
                        resultSet.getInt("Id"),
                        resultSet.getString("ad"),
                        resultSet.getString("amac"),
                        resultSet.getString("aciklama")
                );

                model.addRow(kayit.getObject());

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Departman.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Ac() {
        new View_Departman().setVisible(true);
    }

    @Override
    public void Guncelle(int Id) {
        new View_Departman(Id).setVisible(true);
    }

}
