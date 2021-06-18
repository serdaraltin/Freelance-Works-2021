

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CVeritabani implements IDb {

    @Override
    public Connection Baglanti() {
        try {
            Connection connection = null;
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            String dbURL = "jdbc:derby:database;create=true";
            connection = DriverManager.getConnection(dbURL);
            return connection;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CVeritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean Sorgu(String sorgu) {
        try {
            Connection connection = new CVeritabani().Baglanti();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sorgu);
            stmt.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean TabloOlustur() {
        try {
            Connection connection = new CVeritabani().Baglanti();
            Statement statement = connection.createStatement();

            String tbl_kullanici = "CREATE TABLE kullanici ("
                    + "id INT not null primary key        GENERATED ALWAYS AS IDENTITY        (START WITH 1, INCREMENT BY 1),"
                    + "tip VARCHAR(100),"
                    + "kullanici_ad VARCHAR(100),"
                    + "parola VARCHAR(100)"
                    + ")";

            String tbl_musteri = "CREATE TABLE musteri ("
                    + "id INT not null primary key        GENERATED ALWAYS AS IDENTITY        (START WITH 1, INCREMENT BY 1),"
                    + "unvan VARCHAR(100),"
                    + "tcno VARCHAR(100),"
                    + "ad VARCHAR(100),"
                    + "soyad VARCHAR(100),"
                    + "dogum VARCHAR(100),"
                    + "telefon VARCHAR(100),"
                    + "eposta VARCHAR(100),"
                    + "adres VARCHAR(100)"
                    + ")";

            String tbl_banka_kart = "CREATE TABLE banka_kart ("
                    + "id INT not null primary key        GENERATED ALWAYS AS IDENTITY        (START WITH 1, INCREMENT BY 1),"
                    + "musteri_Id INTEGER,"
                    + "bakiye INTEGER"
                    + ")";

            String tbl_kredi_kart = "CREATE TABLE kredi_kart ("
                    + "id INT not null primary key        GENERATED ALWAYS AS IDENTITY        (START WITH 1, INCREMENT BY 1),"
                    + "musteri_Id INTEGER,"
                    + "bakiye INTEGER,"
                    + "kart_limit INTEGER"
                    + ")";

            String tbl_para_yatirma = "CREATE TABLE para_yatirma ("
                    + "id INT not null primary key        GENERATED ALWAYS AS IDENTITY        (START WITH 1, INCREMENT BY 1),"
                    + "kart_tur VARCHAR(100),"
                    + "kart_Id INTEGER,"
                    + "miktar INTEGER,"
                    + "tarih VARCHAR(100)"
                    + ")";

            String tbl_para_cekme = "CREATE TABLE para_cekme ("
                    + "id INT not null primary key        GENERATED ALWAYS AS IDENTITY        (START WITH 1, INCREMENT BY 1),"
                    + "kart_tur VARCHAR(100),"
                    + "kart_Id INTEGER,"
                    + "miktar INTEGER,"
                    + "tarih VARCHAR(100)"
                    + ")";

            String tbl_fatura_odeme = "CREATE TABLE fatura_odeme ("
                    + "id INT not null primary key        GENERATED ALWAYS AS IDENTITY        (START WITH 1, INCREMENT BY 1),"
                    + "kart_tur VARCHAR(100),"
                    + "kart_Id INTEGER,"
                    + "kurum VARCHAR(100),"
                    + "miktar INTEGER,"
                    + "tarih VARCHAR(100)"
                    + ")";

    
            statement.executeUpdate(tbl_kullanici);
            statement.executeUpdate(tbl_musteri);
            statement.executeUpdate(tbl_banka_kart);
            statement.executeUpdate(tbl_kredi_kart);
            statement.executeUpdate(tbl_para_yatirma);
            statement.executeUpdate(tbl_para_cekme);
            statement.executeUpdate(tbl_fatura_odeme);

            statement.close();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CVeritabani.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CVeritabani.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
