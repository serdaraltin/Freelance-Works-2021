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

            String tbl_banka_kart = "CREATE TABLE banka_kart ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "musteri_Id INTEGER,"
                    + "bakiye INTEGER"
                    + ")";

            String tbl_kredi_kart = "CREATE TABLE kredi_kart ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "musteri_Id INTEGER,"
                    + "bakiye INTEGER,"
                    + "kart_limit INTEGER"
                    + ")";

            String tbl_para_yatirma = "CREATE TABLE para_yatirma ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "kart_tur TEXT,"
                    + "kart_Id INTEGER,"
                    + "miktar INTEGER,"
                    + "tarih TEXT"
                    + ")";

            String tbl_para_cekme = "CREATE TABLE para_cekme ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "kart_tur TEXT,"
                    + "kart_Id INTEGER,"
                    + "miktar INTEGER,"
                    + "tarih TEXT"
                    + ")";

            String tbl_fatura_odeme = "CREATE TABLE fatura_odeme ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "kart_tur TEXT,"
                    + "kart_Id INTEGER,"
                    + "kurum TEXT,"
                    + "miktar INTEGER,"
                    + "tarih TEXT"
                    + ")";

            String tbl_transfer = "CREATE TABLE transfer ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "gonderici_kart_tur TEXT,"
                    + "gonderici_kart_Id INTEGER,"
                    + "alici_kart_tur TEXT,"
                    + "alici_kart_Id INTEGER,"
                    + "miktar INTEGER,"
                    + "tarih TEXT"
                    + ")";

            statement.executeUpdate(tbl_kullanici);
            statement.executeUpdate(tbl_musteri);
            statement.executeUpdate(tbl_banka_kart);
            statement.executeUpdate(tbl_kredi_kart);
            statement.executeUpdate(tbl_para_yatirma);
            statement.executeUpdate(tbl_para_cekme);
            statement.executeUpdate(tbl_transfer);
            statement.executeUpdate(tbl_fatura_odeme);

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
            String tbl_banka_kart = "DROP TABLE banka_kart";
            String tbl_kredi_kart = "DROP TABLE kredi_kart";
            String tbl_para_yatirma = "DROP TABLE para_yatirma";
            String tbl_para_cekme = "DROP TABLE para_cekme";
            String tbl_transfer = "DROP TABLE transfer";
            String tbl_fatura_odeme = "DROP TABLE fatura_odeme";
            statement.executeUpdate(tbl_kullanici);
            statement.executeUpdate(tbl_musteri);
            statement.executeUpdate(tbl_banka_kart);
            statement.executeUpdate(tbl_kredi_kart);
            statement.executeUpdate(tbl_para_yatirma);
            statement.executeUpdate(tbl_para_cekme);
            statement.executeUpdate(tbl_transfer);
            statement.executeUpdate(tbl_fatura_odeme);

            statement.close();
            connection.close();
            return TabloOlustur();
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Veritabani.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
