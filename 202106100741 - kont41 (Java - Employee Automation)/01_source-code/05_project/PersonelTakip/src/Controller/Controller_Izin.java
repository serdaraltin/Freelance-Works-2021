package Controller;

import Model.Model_Main;
import Model.Model_Izin;
import View.View_Izin;
import View.View_Mesai;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_Izin extends Controller_Main {

    public Controller_Izin() {
        super(new Model_Izin());
    }

    @Override
    public boolean Ekle(Model_Main model) {
        Model_Izin izin = (Model_Izin) model;
        String sorgu = "Insert Into " + super.getTabloAd()
                + "(personelId,tur,aciklama,baslangicTarih,bitisTarih)"
                + " values("
                + izin.getPersonelId() + ","
                + "'" + izin.getTur() + "',"
                + "'" + izin.getAciklama() + "',"
                + "'" + izin.getBaslangicTarih() + "',"
                + "'" + izin.getBitisTarih() + "'"
                + ")";

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Model_Main model) {
        Model_Izin model2 = (Model_Izin) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "personelId=" + model2.getPersonelId()
                + ",tur='" + model2.getTur()
                + "',aciklama='" + model2.getAciklama()
                + "',baslangicTarih='" + model2.getBaslangicTarih()
                + "',bitisTarih='" + model2.getBitisTarih() + "'"
                + " Where Id=" + model2.getId();

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    public Model_Izin Getir(int Id) {
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where Id=" + Id;
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            Model_Izin izin = new Model_Izin();
            while (resultSet.next()) {
                izin.setId(resultSet.getInt("Id"));
                izin.setPersonelId(resultSet.getInt("personelId"));
                izin.setTur(resultSet.getString("tur"));
                izin.setAciklama(resultSet.getString("aciklama"));
                izin.setBaslangicTarih(resultSet.getString("baslangicTarih"));
                izin.setBitisTarih(resultSet.getString("bitisTarih"));
            }
            resultSet.close();
            connection.close();
            return izin;
        } catch (SQLException ex) {
            Logger.getLogger(Model_Izin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd() + " Where "
                    + " tur LIKE '%" + aranan + "%' or "
                    + " aciklama LIKE '%" + aranan + "%' or "
                    + " baslangicTarih LIKE '%" + aranan + "%' or "
                    + " bitisTarih LIKE '%" + aranan + "%' or "
                    + " personelId=" + aranan;
            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_Izin kayit = new Model_Izin(
                        resultSet.getInt("Id"),
                        resultSet.getInt("personelId"),
                        resultSet.getString("tur"),
                        resultSet.getString("aciklama"),
                        resultSet.getString("baslangicTarih"),
                        resultSet.getString("bitisTarih")
                );

                model.addRow(kayit.getObject());

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Izin.class.getName()).log(Level.SEVERE, null, ex);
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
                Model_Izin kayit = new Model_Izin(
                        resultSet.getInt("Id"),
                        resultSet.getInt("personelId"),
                        resultSet.getString("tur"),
                        resultSet.getString("aciklama"),
                        resultSet.getString("baslangicTarih"),
                        resultSet.getString("bitisTarih")
                );

                model.addRow(kayit.getObject());

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Izin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Ac() {
        new View_Izin().setVisible(true);
    }

    @Override
    public void Guncelle(int Id) {
        new View_Izin(Id).setVisible(true);
    }

}
