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

            String tbl_kitap = "CREATE TABLE kitap("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "ad TEXT,"
                    + "tur TEXT,"
                    + "fiyat INTEGER"
                    + ")";

            String tbl_kitap_verilen = "CREATE TABLE kitap_verilen("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "kitap_id INTEGER,"
                    + "musteri_id INTEGER,"
                    + "gun INTEGER,"
                    + "tarih TEXT,"
                    + "tarih_iade TEXT"
                    + ")";

            statement.executeUpdate(tbl_kullanici);
            statement.executeUpdate(tbl_musteri);
            statement.executeUpdate(tbl_kitap);
            statement.executeUpdate(tbl_kitap_verilen);

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
            String tbl_kitap = "DROP TABLE kitap";
            String tbl_kitap_verilen = "DROP TABLE kitap_verilen";

            statement.executeUpdate(tbl_kullanici);
            statement.executeUpdate(tbl_musteri);
            statement.executeUpdate(tbl_kitap);
            statement.executeUpdate(tbl_kitap_verilen);

            statement.close();
            connection.close();
            return TabloOlustur();
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Veritabani.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
