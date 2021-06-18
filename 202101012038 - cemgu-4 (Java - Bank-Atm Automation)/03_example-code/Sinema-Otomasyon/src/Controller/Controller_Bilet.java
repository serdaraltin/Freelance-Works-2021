package Controller;

//Kullanılacak kütüphanelerin dahil edilmesi
import Interface.Interface_Controller;
import Model.Model_Film;
import Model.Model_Salon;
import Model.Model_Seans;
import Model.Model_Bilet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//sınfıfa interface implementasyonunun yapılması
public class Controller_Bilet implements Interface_Controller<Model_Bilet> {

    String tablo = "bilet";
    Controller_Veritabani veritabani = new Controller_Veritabani();
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    Controller_Seans controller_Seans = new Controller_Seans();
    Controller_Salon controller_Salon = new Controller_Salon();
    Controller_Film controller_Film = new Controller_Film();

    //kurucu method ile ilgili atamaların yapılması
    public Controller_Bilet() {
        try {
            connection = veritabani.Baglanti();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Film.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //burada gelen değerin veritabanında olup olmadığı kontrolü yapılıyor
    @Override
    public boolean Kontrol(Model_Bilet veri) {
        try {
            connection = veritabani.Baglanti();
            String sorgu = "Select * From " + tablo
                    + " Where seansId=" + veri.getSeansId() + " and koltukNo=" + veri.getKoltukNo();
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
            Logger.getLogger(Controller_Film.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //bırada ilgili tablodaki veriler listeleniyor
    @Override
    public ArrayList<Model_Bilet> Listele(JTable Tablo) {
        try {
            connection = veritabani.Baglanti();
            String sorgu = "Select * From " + tablo;
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Bilet> arrayList = new ArrayList<Model_Bilet>();

            while (resultSet.next()) {
                Model_Bilet kayit = new Model_Bilet(
                        resultSet.getInt("Id"),
                        resultSet.getString("musteriTip"),
                        resultSet.getInt("seansId"),
                        resultSet.getInt("koltukNo")
                );
                int filmId = controller_Seans.Getir(new Model_Seans(kayit.getSeansId())).getFilmId();
                int salonId = controller_Seans.Getir(new Model_Seans(kayit.getSeansId())).getSalonId();
                String tarih = controller_Seans.Getir(new Model_Seans(kayit.getSeansId())).getTarih();

                model.addRow(
                        new Object[]{
                            kayit.getId(),
                            kayit.getMusteriTip(),
                            controller_Film.Getir(new Model_Film(filmId)).getAd(),
                            controller_Salon.Getir(new Model_Salon(salonId)).getAd(),
                            tarih,
                            kayit.getKoltukNo()
                        }
                );
                arrayList.add(kayit);
            }
            resultSet.close();
            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Film.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //burada ilgili tabloya kayıt ekleme işlemi yapılıyor
    @Override
    public boolean Ekle(Model_Bilet veri) {

        String sorgu = "Insert Into " + tablo + " ("
                + "musteriTip,seansId,koltukNo) values('"
                + veri.getMusteriTip() + "',"
                + veri.getSeansId() + ","
                + veri.getKoltukNo() + ""
                + ")";

        return veritabani.Sorgu(sorgu);
    }

    //burada ilgili kaydın yeni değer ile güncellenmesi sağlanıyor
    @Override
    public boolean Guncelle(Model_Bilet veri) {
        String sorgu = "Update " + tablo + " set "
                + "musteriTip='" + veri.getMusteriTip()
                + "',seansId=" + veri.getSeansId()
                + ",koltukNo=" + veri.getKoltukNo()
                + " Where Id=" + veri.getId();

        return veritabani.Sorgu(sorgu);
    }

    //burada ilgili kaydın silinmesi sağlanıyor
    @Override
    public boolean Sil(Model_Bilet veri) {
        String sorgu = "Delete From " + tablo + " Where Id=" + veri.getId();

        return veritabani.Sorgu(sorgu);
    }

    //gelen Id değerine göre kayıt bulunup geriye döndürülüyor
    @Override
    public Model_Bilet Getir(Model_Bilet veri) {
        try {
            connection = veritabani.Baglanti();
            String sorgu = "Select * From " + tablo
                    + " Where Id=" + veri.getId();
            resultSet = statement.executeQuery(sorgu);
            while (resultSet.next()) {
                veri.setId(resultSet.getInt("Id"));
                veri.setMusteriTip(resultSet.getString("musteriTip"));
                veri.setSeansId(resultSet.getInt("seansId"));
                veri.setKoltukNo(resultSet.getInt("koltukNo"));
            }
            resultSet.close();
            connection.close();
            return veri;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //gelen değere göre arama işlemi yapılıp sonuç listeleniyor
    @Override
    public ArrayList<Model_Bilet> Ara(JTable Tablo, String aranan) {
        try {
            connection = veritabani.Baglanti();
            int filmId = controller_Film.Getir(new Model_Film(aranan)).getId();
            int salonId = controller_Salon.Getir(new Model_Salon(aranan)).getId();

            String sorgu = "Select * From " + tablo
                    + " Where musteriTip LIKE '%" + aranan + "%' or koltukNo=" + Integer.valueOf(aranan);
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Bilet> arrayList = new ArrayList<Model_Bilet>();

            while (resultSet.next()) {
                Model_Bilet kayit = new Model_Bilet(
                        resultSet.getInt("Id"),
                        resultSet.getString("musteriTip"),
                        resultSet.getInt("seansId"),
                        resultSet.getInt("koltukNo")
                );

                filmId = controller_Seans.Getir(new Model_Seans(kayit.getSeansId())).getFilmId();
                salonId = controller_Seans.Getir(new Model_Seans(kayit.getSeansId())).getSalonId();
                String tarih = controller_Seans.Getir(new Model_Seans(kayit.getSeansId())).getTarih();

                model.addRow(
                        new Object[]{
                            kayit.getId(),
                            kayit.getMusteriTip(),
                            controller_Film.Getir(new Model_Film(filmId)).getAd(),
                            controller_Salon.Getir(new Model_Salon(salonId)).getAd(),
                            tarih,
                            kayit.getKoltukNo()
                        }
                );
                arrayList.add(kayit);
            }
            resultSet.close();
            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Film.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
