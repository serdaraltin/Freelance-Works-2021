package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database implements IDatabase {

    @Override
    public Connection Connection() {
        try {
            Connection con = null;
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:veritabani.db");
            return con;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean Query(String query) {
        try {
            Connection con = new Database().Connection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean CreateTables() {
        try {
            Connection con = new Database().Connection();
            Statement stmt = con.createStatement();

            String tbl_kullanici = "CREATE TABLE kullanici ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "tip TEXT,"
                    + "kullanici_ad TEXT,"
                    + "parola TEXT"
                    + ")";

            String tbl_musteri = "CREATE TABLE customer ("
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

            stmt.executeUpdate(tbl_kullanici);
            stmt.executeUpdate(tbl_musteri);
            stmt.executeUpdate(tbl_banka_kart);
            stmt.executeUpdate(tbl_kredi_kart);
            stmt.executeUpdate(tbl_para_yatirma);
            stmt.executeUpdate(tbl_para_cekme);
            stmt.executeUpdate(tbl_transfer);
            stmt.executeUpdate(tbl_fatura_odeme);

            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean FactoryReset() {
        try {
            Connection con = Connection();
            Statement stmt = con.createStatement();

            String tbl_kullanici = "DROP TABLE kullanici";
            String tbl_musteri = "DROP TABLE customer";
            String tbl_banka_kart = "DROP TABLE banka_kart";
            String tbl_kredi_kart = "DROP TABLE kredi_kart";
            String tbl_para_yatirma = "DROP TABLE para_yatirma";
            String tbl_para_cekme = "DROP TABLE para_cekme";
            String tbl_transfer = "DROP TABLE transfer";
            String tbl_fatura_odeme = "DROP TABLE fatura_odeme";
            stmt.executeUpdate(tbl_kullanici);
            stmt.executeUpdate(tbl_musteri);
            stmt.executeUpdate(tbl_banka_kart);
            stmt.executeUpdate(tbl_kredi_kart);
            stmt.executeUpdate(tbl_para_yatirma);
            stmt.executeUpdate(tbl_para_cekme);
            stmt.executeUpdate(tbl_transfer);
            stmt.executeUpdate(tbl_fatura_odeme);

            stmt.close();
            con.close();
            return CreateTables();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
