package Controller;

import Interface.Interface_Veritabani;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller_Veritabani implements Interface_Veritabani {

    @Override
    public Connection Baglanti() {
        try {
            Connection connection = null;
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:veritabani.db");
            return connection;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Controller_Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean Sorgu(String sorgu) {
        try {
            Connection connection = new Controller_Veritabani().Baglanti();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sorgu);
            stmt.close();
            connection.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean TabloOlustur() {
        try {
            Connection connection = new Controller_Veritabani().Baglanti();
            Statement statement = connection.createStatement();

            String tbl_kullanici = "CREATE TABLE kullanici ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "tip TEXT,"
                    + "kullanici_ad TEXT,"
                    + "parola TEXT"
                    + ")";

            String tbl_musteri = "CREATE TABLE musteri ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "unvan TEXT,"
                    + "tcno TEXT,"
                    + "ad TEXT,"
                    + "soyad TEXT,"
                    + "dogum TEXT,"
                    + "telefon TEXT,"
                    + "eposta TEXT,"
                    + "adres TEXT"
                    + ")";

            String tbl_fatura = "CREATE TABLE fatura("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "musteri_Id INTEGER,"
                    + "toplam_tutar INTEGER,"
                    + "tarih TEXT"
                    + ")";

            String tbl_fatura_urun = "CREATE TABLE fatura_urun("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "fatura_Id INTEGER,"
                    + "urun_Id INTEGER,"
                    + "adet INTEGER,"
                    + "tutar INTEGER"
                    + ")";

            String tbl_urun = "CREATE TABLE urun ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "kategori_Id INTEGER,"
                    + "marka_ID INTEGER,"
                    + "barkod TEXT,"
                    + "ad TEXT,"
                    + "birim TEXT,"
                    + "fiyat INTEGER,"
                    + "miktar INTEGER,"
                    + "eklenme_tarih TEXT"
                    + ")";

            String tbl_kategori = "CREATE TABLE kategori ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "ad TEXT"
                    + ")";

            String tbl_marka = "CREATE TABLE marka ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "ad TEXT"
                    + ")";

            String tbl_stok = "CREATE TABLE stok ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "urun_Id INTEGER,"
                    + "tedarikci_Id INTEGER,"
                    + "adet INTEGER,"
                    + "tutar INTEGER,"
                    + "eklenme_tarih TEXT"
                    + ")";

            String tbl_tedarikci = "CREATE TABLE tedarikci ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "ad TEXT,"
                    + "telefon TEXT,"
                    + "adres TEXT"
                    + ")";

            statement.executeUpdate(tbl_kullanici);
            statement.executeUpdate(tbl_musteri);
            statement.executeUpdate(tbl_fatura);
            statement.executeUpdate(tbl_fatura_urun);
            statement.executeUpdate(tbl_urun);
            statement.executeUpdate(tbl_kategori);
            statement.executeUpdate(tbl_marka);
            statement.executeUpdate(tbl_stok);
            statement.executeUpdate(tbl_tedarikci);

            statement.close();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Veritabani.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean Sifirla() {
        try {
            Connection connection = Baglanti();
            Statement statement = connection.createStatement();

            String tbl_kullanici = "DROP TABLE kullanici";
            String tbl_musteri = "DROP TABLE musteri";
            String tbl_fatura = "DROP TABLE fatura";
            String tbl_fatura_urun = "DROP TABLE fatura_urun";
            String tbl_urun = "DROP TABLE urun";
            String tbl_marka = "DROP TABLE marka";
            String tbl_stok = "DROP TABLE stok";
            String tbl_tedarikci = "DROP TABLE tedarikci";
            statement.executeUpdate(tbl_kullanici);
            statement.executeUpdate(tbl_musteri);
            statement.executeUpdate(tbl_fatura);
            statement.executeUpdate(tbl_fatura_urun);
            statement.executeUpdate(tbl_urun);
            statement.executeUpdate(tbl_marka);
            statement.executeUpdate(tbl_stok);
            statement.executeUpdate(tbl_tedarikci);

            statement.close();
            connection.close();
            return TabloOlustur();
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Veritabani.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
