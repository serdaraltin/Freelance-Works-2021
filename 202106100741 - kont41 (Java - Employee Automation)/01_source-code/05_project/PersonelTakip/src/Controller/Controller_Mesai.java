package Controller;

import Model.Model_Main;
import Model.Model_Mesai;
import View.View_Departman;
import View.View_Mesai;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_Mesai extends Controller_Main {

    public Controller_Mesai() {
        super(new Model_Mesai());
    }

    @Override
    public boolean Ekle(Model_Main model) {
        Model_Mesai izin = (Model_Mesai) model;
        String sorgu = "Insert Into " + super.getTabloAd()
                + "(personelId,tarih,sure,ucret)"
                + " values("
                + izin.getPersonelId() + ","
                + "'" + izin.getTarih() + "',"
                + izin.getSure() + ","
                + izin.getUcret() + ""
                + ")";

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Model_Main model) {
        Model_Mesai model2 = (Model_Mesai) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "personelId=" + model2.getPersonelId()
                + ",tarih='" + model2.getTarih()
                + "',sure=" + model2.getSure()
                + ",ucret=" + model2.getUcret()
                + " Where Id=" + model2.getId();

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    public Model_Mesai Getir(int Id) {
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where Id=" + Id;
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            Model_Mesai izin = new Model_Mesai();
            while (resultSet.next()) {
                izin.setId(resultSet.getInt("Id"));
                izin.setPersonelId(resultSet.getInt("personelId"));
                izin.setTarih(resultSet.getString("tarih"));
                izin.setSure(resultSet.getInt("sure"));
                izin.setUcret(resultSet.getInt("ucret"));
            }
            resultSet.close();
            connection.close();
            return izin;
        } catch (SQLException ex) {
            Logger.getLogger(Model_Mesai.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd() + " Where "
                    + " tarih LIKE '%" + aranan + "%' or "
                    + " personelId=" + aranan + " or "
                    + " sure=" + aranan + " or "
                    + " ucret=" + aranan;
            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_Mesai kayit = new Model_Mesai(
                        resultSet.getInt("Id"),
                        resultSet.getInt("personelId"),
                        resultSet.getString("tarih"),
                        resultSet.getInt("sure"),
                        resultSet.getInt("ucret")
                );

                model.addRow(kayit.getObject());

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Mesai.class.getName()).log(Level.SEVERE, null, ex);
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
                Model_Mesai kayit = new Model_Mesai(
                        resultSet.getInt("Id"),
                        resultSet.getInt("personelId"),
                        resultSet.getString("tarih"),
                        resultSet.getInt("sure"),
                        resultSet.getInt("ucret")
                );

                model.addRow(kayit.getObject());

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Mesai.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Ac() {
        new View_Mesai().setVisible(true);
    }

    @Override
    public void Guncelle(int Id) {
        new View_Mesai(Id).setVisible(true);
    }

}
