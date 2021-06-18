

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cVeritabani implements iVeritabani {

    @Override
    public Connection Baglanti() {
        try {
            Connection conn = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:veritabani.db");
            return conn;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(cVeritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean Sorgu(String sorgu) {
        try {
            Connection conn = new cVeritabani().Baglanti();
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

    @Override
    public boolean TabloOlustur() {
        try {
            Connection conn = new cVeritabani().Baglanti();
            Statement stmt = conn.createStatement();

            String tbl_kullanici = "CREATE TABLE kullanici ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "tip TEXT,"
                    + "kullanici TEXT,"
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
                    + "id INTEGER,"
                    + "bakiye INTEGER"
                    + ")";

            String tbl_kredi_kart = "CREATE TABLE kredi_kart ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "id INTEGER,"
                    + "mBakiye INTEGER,"
                    + "kLimit INTEGER"
                    + ")";

            String tbl_para_yatirma = "CREATE TABLE para_yatirma ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "ktur TEXT,"
                    + "kID INTEGER,"
                    + "kMiktar INTEGER,"
                    + "kTarih TEXT"
                    + ")";

            String tbl_para_cekme = "CREATE TABLE para_cekme ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "ktur TEXT,"
                    + "kID INTEGER,"
                    + "kMiktar INTEGER,"
                    + "kTarih TEXT"
                    + ")";

            String tbl_fatura_odeme = "CREATE TABLE fatura_odeme ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "ktur TEXT,"
                    + "kID INTEGER,"
                    + "kKurum TEXT,"
                    + "kMiktar INTEGER,"
                    + "kTarih TEXT"
                    + ")";

            String tbl_transfer = "CREATE TABLE transfer ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "gonderici_kart_tur TEXT,"
                    + "gonderici_kart_Id INTEGER,"
                    + "alici_kart_tur TEXT,"
                    + "alici_kart_Id INTEGER,"
                    + "kMiktar INTEGER,"
                    + "kTarih TEXT"
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
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(cVeritabani.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean Sifirla() {
        try {
            Connection conn = Baglanti();
            Statement stmt = conn.createStatement();

            String tbl_kullanici = "DROP TABLE kullanici";
            String tbl_musteri = "DROP TABLE mMusteri";
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
            conn.close();
            return TabloOlustur();
        } catch (SQLException ex) {
            Logger.getLogger(cVeritabani.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
