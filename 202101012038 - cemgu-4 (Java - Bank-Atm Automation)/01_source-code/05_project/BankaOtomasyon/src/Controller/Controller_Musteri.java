package Controller;

import Model.Model_Main;
import Model.Model_Musteri;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_Musteri extends Controller_Main {

    public Controller_Musteri() {
        super(new Model_Musteri());
    }

    public boolean Kontrol(String tcno) {
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where tcno='" + tcno + "'";
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
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
            Logger.getLogger(Controller_KrediKart.class.getName()).log(Level.SEVERE, null, ex);
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
                Model_Musteri kayit = new Model_Musteri(
                        resultSet.getInt("Id"),
                        resultSet.getString("unvan"),
                        resultSet.getString("tcno"),
                        resultSet.getString("ad"),
                        resultSet.getString("soyad"),
                        resultSet.getString("dogum"),
                        resultSet.getString("telefon"),
                        resultSet.getString("eposta"),
                        resultSet.getString("adres")
                );

                model.addRow(
                        kayit.getObject()
                );

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Musteri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd() + " Where "
                    + " ad LIKE '%" + aranan
                    + "%' or unvan LIKE '%" + aranan
                    + "%' or tcno LIKE '%" + aranan
                    + "%' or ad LIKE '%" + aranan
                    + "%' or soyad LIKE '%" + aranan
                    + "%' or dogum LIKE '%" + aranan
                    + "%' or telefon LIKE '%" + aranan
                    + "%' or eposta LIKE '%" + aranan
                    + "%' or adres LIKE '%" + aranan + "%'";
            ;
            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_Musteri kayit = new Model_Musteri(
                        resultSet.getInt("Id"),
                        resultSet.getString("unvan"),
                        resultSet.getString("tcno"),
                        resultSet.getString("ad"),
                        resultSet.getString("soyad"),
                        resultSet.getString("dogum"),
                        resultSet.getString("telefon"),
                        resultSet.getString("eposta"),
                        resultSet.getString("adres")
                );

                model.addRow(
                        kayit.getObject()
                );

                arrayList.add(kayit);
            }
            resultSet.close();
            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Musteri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean Ekle(Model_Main model) {
        Model_Musteri model2 = (Model_Musteri) model;
        String sorgu = "Insert Into " + super.getTabloAd() + " ("
                + "unvan,tcno,ad,soyad,dogum,telefon,eposta,adres) values('"
                + model2.getUnvan() + "','"
                + model2.getTcno() + "','"
                + model2.getAd() + "','"
                + model2.getSoyad() + "','"
                + model2.getDogum() + "','"
                + model2.getTelefon() + "','"
                + model2.getEposta() + "','"
                + model2.getAdres() + "'"
                + ")";

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Model_Main model) {
        Model_Musteri model2 = (Model_Musteri) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "'unvan='" + model2.getUnvan()
                + "','tcno=" + model2.getTcno()
                + "','ad=" + model2.getAd()
                + "','soyad=" + model2.getSoyad()
                + "','dogum=" + model2.getDogum()
                + "','telefon=" + model2.getTelefon()
                + "','eposta=" + model2.getEposta()
                + "','adres=" + model2.getAdres()
                + "' Where Id=" + model2.getId();

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    @Override
    public Model_Musteri Getir(Model_Main model) {
        Model_Musteri model2 = (Model_Musteri) model;
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where tcno='" + model2.getTcno() + "' or Id=" + model.getId();
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            while (resultSet.next()) {
                model2.setId(resultSet.getInt("Id"));
                model2.setUnvan(resultSet.getString("unvan"));
                model2.setTcno(resultSet.getString("tcno"));
                model2.setAd(resultSet.getString("ad"));
                model2.setSoyad(resultSet.getString("soyad"));
                model2.setDogum(resultSet.getString("dogum"));
                model2.setTelefon(resultSet.getString("telefon"));
                model2.setEposta(resultSet.getString("eposta"));
                model2.setAdres(resultSet.getString("adres"));

            }
            resultSet.close();
            connection.close();
            return model2;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Musteri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Guncelle(int Id) {
        new View.View_Musteri(Id).setVisible(true);
    }

    @Override
    public void Ac() {
        new View.View_Musteri().setVisible(true);
    }

}
