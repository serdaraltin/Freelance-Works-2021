package Controller;

import Model.Model_Main;
import Model.Model_Oda;
import View.View_Oda;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_Oda extends Controller_Main {

    public Controller_Oda() {
        super(new Model_Oda());
    }

    @Override
    public boolean Ekle(Model_Main model) {
        Model_Oda musteri = (Model_Oda) model;
        String sorgu = "Insert Into " + super.getTabloAd() + "(no,kat,tur) values("
                + "" + musteri.getNo() + ","
                + "" + musteri.getKat() + ","
                + "'" + musteri.getTur() + "'"
                + ")";
        return new Controller_Veritabani().Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Model_Main model) {
        Model_Oda model2 = (Model_Oda) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "no=" + model2.getNo()
                + ",kat=" + model2.getKat()
                + ",tur='" + model2.getTur()
                + "' Where Id=" + model2.getId();

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    public boolean Kontrol(int no) {
        try {
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where no=" + no;
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
            Logger.getLogger(Model_Oda.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Model_Oda Getir(int Id) {
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where Id=" + Id;
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            Model_Oda personel = new Model_Oda();
            while (resultSet.next()) {
                personel.setId(resultSet.getInt("Id"));
                personel.setNo(resultSet.getInt("no"));
                personel.setKat(resultSet.getInt("kat"));
                personel.setTur(resultSet.getString("tur"));
            }
            resultSet.close();
            connection.close();
            return personel;
        } catch (SQLException ex) {
            Logger.getLogger(Model_Oda.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd() + " Where "
                    + " tur LIKE '%" + aranan + "%'";
            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_Oda kayit = new Model_Oda(
                        resultSet.getInt("Id"),
                        resultSet.getInt("no"),
                        resultSet.getInt("kat"),
                        resultSet.getString("tur")
                );

                model.addRow(kayit.getObject());

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Oda.class.getName()).log(Level.SEVERE, null, ex);
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
                Model_Oda kayit = new Model_Oda(
                        resultSet.getInt("Id"),
                        resultSet.getInt("no"),
                        resultSet.getInt("kat"),
                        resultSet.getString("tur")
                );

                model.addRow(kayit.getObject());

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Oda.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Ac() {
        new View_Oda().setVisible(true);
    }

    @Override
    public void Guncelle(int Id) {
        new View_Oda(Id).setVisible(true);
    }

}
