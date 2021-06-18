package Controller;

import Model.Model_BankaKart;
import Model.Model_BankaKart;
import Model.Model_Main;
import Model.Model_Musteri;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_BankaKart extends Controller_Main {

    public Controller_BankaKart() {
        super(new Model_BankaKart());
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
                Model_BankaKart kayit = new Model_BankaKart(
                        resultSet.getInt("Id"),
                        resultSet.getInt("musteri_Id"),
                        resultSet.getInt("bakiye")
                );
                Model_Musteri musteri = new Controller_Musteri().Getir(new Model_Musteri(kayit.getMusteri_Id()));
                model.addRow(new Object[]{
                    kayit.getId(),
                    musteri.getAd() + " " + musteri.getSoyad(),
                    kayit.getBakiye()
                }
                );

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_BankaKart.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd() + " Where "
                    + "musteri_Id=" + aranan;
            
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_BankaKart kayit = new Model_BankaKart(
                        resultSet.getInt("Id"),
                        resultSet.getInt("musteri_Id"),
                        resultSet.getInt("bakiye")
                );

                Model_Musteri musteri = new Controller_Musteri().Getir(new Model_Musteri(kayit.getMusteri_Id()));
                model.addRow(new Object[]{
                    kayit.getId(),
                    musteri.getAd() + " " + musteri.getSoyad(),
                    kayit.getBakiye()
                }
                );
                arrayList.add(kayit);
            }
            resultSet.close();
            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_BankaKart.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean Ekle(Model_Main model) {
        Model_BankaKart model2 = (Model_BankaKart) model;
        String sorgu = "Insert Into " + super.getTabloAd() + " ("
                + "musteri_Id,bakiye) values("
                + model2.getMusteri_Id() + ","
                + model2.getBakiye() + ""
                + ")";

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Model_Main model) {
        Model_BankaKart model2 = (Model_BankaKart) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "musteri_Id=" + model2.getMusteri_Id()
                + ",bakiye=" + model2.getBakiye()
                + " Where Id=" + model2.getId();
        return new Controller_Veritabani().Sorgu(sorgu);
    }

    @Override
    public Model_BankaKart Getir(Model_Main model) {
        Model_BankaKart model2 = (Model_BankaKart) model;
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where Id=" + model.getId();
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            while (resultSet.next()) {
                model2.setId(resultSet.getInt("Id"));
                model2.setMusteri_Id(resultSet.getInt("musteri_Id"));
                model2.setBakiye(resultSet.getInt("bakiye"));
            }
            resultSet.close();
            connection.close();
            return model2;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_BankaKart.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Guncelle(int Id) {
        new View.View_BankaKart(Id).setVisible(true);
    }

    @Override
    public void Ac() {
        new View.View_BankaKart().setVisible(true);
    }
}
