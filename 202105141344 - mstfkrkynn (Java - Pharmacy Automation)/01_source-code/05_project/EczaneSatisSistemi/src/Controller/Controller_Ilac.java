package Controller;

import Model.Model_Main;
import Model.Model_Ilac;
import View.View_Ilac;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//bu sınıf genel olarak bir ilaç listesine ekleme, güncelleme, silme, gelirme işlemlerini yapar
public class Controller_Ilac extends Controller_Main {

    public Controller_Ilac() {
        super(new Model_Ilac());
    }

    //gelen bir modelin (ilaç) mevcut tabloya kaydının eklenmesi
    @Override
    public boolean Ekle(Model_Main model) {
        Model_Ilac item = (Model_Ilac) model;
        String sorgu = "Insert Into " + super.getTabloAd() + "(barkod,ad,marka,tur,fiyat) values("
                + "'" + item.getBarkod() + "',"
                + "'" + item.getAd() + "',"
                + "'" + item.getMarka() + "',"
                + "'" + item.getTur() + "',"
                + "" + item.getFiyat() + ""
                + ")";
        return new Controller_Veritabani().Sorgu(sorgu);
    }

    //gelen bir modelin (ilaç) ilgili değerine göre (Id) kaydının güncellenmesi
    @Override
    public boolean Guncelle(Model_Main model) {
        Model_Ilac item = (Model_Ilac) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "barko='" + item.getBarkod() + "',"
                + "ad='" + item.getAd() + "',"
                + "marka='" + item.getMarka() + "',"
                + "tur='" + item.getTur() + "',"
                + "fiyat=" + item.getFiyat() + ""
                + " Where Id=" + item.getId();

        return new Controller_Veritabani().Sorgu(sorgu);
    }

    //barkod numarasına ait kaydın var olup olmadığının kontrolü
    public boolean Kontrol(String barkod) {
        try {
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where barkod=" + barkod;
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
            Logger.getLogger(Model_Ilac.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //Id değerine sahip kaydın getirilmesi
    public Model_Ilac Getir(int Id) {
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where Id=" + Id;
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            Model_Ilac item = new Model_Ilac();
            while (resultSet.next()) {
                item.setId(resultSet.getInt("Id"));
                item.setBarkod(resultSet.getString("barkod"));
                item.setAd(resultSet.getString("ad"));
                item.setMarka(resultSet.getString("marka"));
                item.setTur(resultSet.getString("tur"));
                item.setFiyat(resultSet.getInt("fiyat"));
            }
            resultSet.close();
            connection.close();
            return item;
        } catch (SQLException ex) {
            Logger.getLogger(Model_Ilac.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //kayıtlar içerisinde ad değerleri arasında arama işlemi yapılması ve sonucun tabloya aktarılması
    @Override
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd() + " Where "
                    + " ad LIKE '%" + aranan + "%'";
            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_Ilac item = new Model_Ilac(
                        resultSet.getInt("Id"),
                        resultSet.getString("barkod"),
                        resultSet.getString("ad"),
                        resultSet.getString("marka"),
                        resultSet.getString("tur"),
                        resultSet.getInt("fiyat")
                );

                model.addRow(item.getObject());

                arrayList.add(item);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Ilac.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //tabloya ilgili tüm kayıtların listelenmesi
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
                Model_Ilac item = new Model_Ilac(
                        resultSet.getInt("Id"),
                        resultSet.getString("barkod"),
                        resultSet.getString("ad"),
                        resultSet.getString("marka"),
                        resultSet.getString("tur"),
                        resultSet.getInt("fiyat")
                );

                model.addRow(item.getObject());

                arrayList.add(item);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Ilac.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //ilgili kayıt penceresinin açılması
    @Override
    public void Ac() {
        new View_Ilac().setVisible(true);
    }

    //ilgili güncelleme penceresinin açılması
    @Override
    public void Guncelle(int Id) {
        new View_Ilac(Id).setVisible(true);
    }

}
