package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller_Veritabani {

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

    public boolean TabloOlustur() {
        try {
            Connection connection = Baglanti();
            Statement statement = connection.createStatement();

            String tbl_kullanici = "CREATE TABLE kullanici ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "kullaniciAd TEXT,"
                    + "parola TEXT)";

            String tbl_film = "CREATE TABLE film ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "ad TEXT,"
                    + "kategori TEXT,"
                    + "yonetmen TEXT,"
                    + "yil INTEGER)";

            String tbl_salon = "CREATE TABLE salon ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "ad TEXT,"
                    + "koltukAdet INTEGER)";

            String tbl_seans = "CREATE TABLE seans ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "filmId INTEGER,"
                    + "salonId INTEGER,"
                    + "tarih TEXT)";

            String tbl_bilet = "CREATE TABLE bilet ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "musteriTip TEXT,"
                    + "seansId INTEGER,"
                    + "koltukNo INTEGER)";

            statement.executeUpdate(tbl_kullanici);
            statement.executeUpdate(tbl_film);
            statement.executeUpdate(tbl_salon);
            statement.executeUpdate(tbl_seans);
            statement.executeUpdate(tbl_bilet);
            statement.close();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Veritabani.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Sıfırla() {
        try {
            Connection connection = Baglanti();
            Statement statement = connection.createStatement();

            String tbl_kullanici = "DROP TABLE kullanici";
            String tbl_film = "DROP TABLE film";
            String tbl_salon = "DROP TABLE salon";
            String tbl_seans = "DROP TABLE seans";
            String tbl_bilet = "DROP TABLE bilet";
            statement.executeUpdate(tbl_kullanici);
            statement.executeUpdate(tbl_film);
            statement.executeUpdate(tbl_salon);
            statement.executeUpdate(tbl_seans);
            statement.executeUpdate(tbl_bilet);
            statement.close();
            connection.close();
            return TabloOlustur();
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Veritabani.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
