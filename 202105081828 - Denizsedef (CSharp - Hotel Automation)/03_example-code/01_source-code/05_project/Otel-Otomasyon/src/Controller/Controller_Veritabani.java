package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller_Veritabani {

    public Controller_Veritabani() {
    }

    public Connection Baglanti() {
        try {
            Connection conn = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:veritabani.db");
            return conn;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Controller_Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean Sorgu(String sorgu) {
        try {
            Connection conn = new Controller_Veritabani().Baglanti();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sorgu);
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    public boolean TabloOlustur() {
        try {
            Connection conn = new Controller_Veritabani().Baglanti();
            Statement stmt = conn.createStatement();

            String tbl_personel = "CREATE TABLE personel ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "kullanici_ad TEXT,"
                    + "parola TEXT,"
                    + "tcno TEXT,"
                    + "ad TEXT,"
                    + "soyad TEXT,"
                    + "telefon TEXT,"
                    + "adres TEXT,"
                    + "maas INTEGER"
                    + ")";

            String tbl_musteri = "CREATE TABLE musteri ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "tcno TEXT,"
                    + "ad TEXT,"
                    + "soyad TEXT,"
                    + "telefon TEXT,"
                    + "adres TEXT"
                    + ")";

            String tbl_oda = "CREATE TABLE oda ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "no INTEGER,"
                    + "kat INTEGER,"
                    + "tur TEXT"
                    + ")";

            String tbl_rezervasyon = "CREATE TABLE rezervasyon ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "oda_Id INTEGER,"
                    + "musteri_Id INTEGER,"
                    + "giris_tarih TEXT,"
                    + "cikis_tarih TEXT"
                    + ")";

            stmt.executeUpdate(tbl_personel);
            stmt.executeUpdate(tbl_musteri);
            stmt.executeUpdate(tbl_oda);
            stmt.executeUpdate(tbl_rezervasyon);

            stmt.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Veritabani.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Sifirla() {
        try {
            Connection conn = Baglanti();
            Statement stmt = conn.createStatement();

            String tbl_personel = "DROP TABLE personel";
            String tbl_musteri = "DROP TABLE musteri";
            String tbl_oda = "DROP TABLE oda";
            String tbl_rezervasyon = "DROP TABLE rezarvasyon";

            stmt.executeUpdate(tbl_personel);
            stmt.executeUpdate(tbl_musteri);
            stmt.executeUpdate(tbl_oda);
            stmt.executeUpdate(tbl_rezervasyon);

            stmt.close();
            conn.close();
            return TabloOlustur();
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Veritabani.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
