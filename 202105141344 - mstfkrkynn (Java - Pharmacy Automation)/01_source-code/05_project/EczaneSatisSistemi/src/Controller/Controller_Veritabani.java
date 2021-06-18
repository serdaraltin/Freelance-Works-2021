package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

//Bu sınıf genel veritabanı işlemlerinin yapılmasını sağlamaktadır
public class Controller_Veritabani {

    //boş constructor
    public Controller_Veritabani() {
    }

    //ilgili veritabanına bağlantıyı sağlayan  ve geriye bağlantı nesnesini döndüren method
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

    //gelen sorguyu veritabanında çalıştıran ve başarılı olup olmama durumunu geriye döndüren method
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

    //veritabanı için ilgili tabloların oluşturulmasını sağlayan method
    public boolean TabloOlustur() {
        try {
            //yeni bir bağlantı nesnesi tanımlama
            Connection conn = new Controller_Veritabani().Baglanti();
            Statement stmt = conn.createStatement();

            //personel tablosu için SQL sorgusu tanımlaması
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

            //müşteri tablosu için SQL sorgusu tanımlaması
            String tbl_musteri = "CREATE TABLE musteri ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "tcno TEXT,"
                    + "ad TEXT,"
                    + "soyad TEXT,"
                    + "telefon TEXT,"
                    + "adres TEXT"
                    + ")";
            //ilaç tablosu için SQL sorgusu tanımlaması
            String tbl_ilac = "CREATE TABLE ilac ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "barkod TEXT,"
                    + "ad TEXT,"
                    + "marka TEXT,"
                    + "tur TEXT,"
                    + "fiyat INTEGER"
                    + ")";

            //satış tablosu için SQL sorgusu tanımlaması
            String tbl_satis = "CREATE TABLE satis ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "ilac_id INTEGER,"
                    + "musteri_id INTEGER,"
                    + "personel_id INTEGER,"
                    + "tarih TEXT"
                    + ")";

            //ilgili sorgu ifadelerinin yürütülmesi
            stmt.executeUpdate(tbl_personel);
            stmt.executeUpdate(tbl_musteri);
            stmt.executeUpdate(tbl_ilac);
            stmt.executeUpdate(tbl_satis);

            stmt.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Veritabani.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //veritabnaındaki tabloların silinmesi ve tekrar inşaa edilmesi
    public boolean Sifirla() {
        try {
            Connection conn = Baglanti();
            Statement stmt = conn.createStatement();

            //ilgili tabloların silinme sorguları
            String tbl_personel = "DROP TABLE personel";
            String tbl_musteri = "DROP TABLE musteri";
            String tbl_ilac = "DROP TABLE ilac";
            String tbl_satis = "DROP TABLE satis";

            //ilgili sorgu ifadelerinin yürütülmesi
            stmt.executeUpdate(tbl_personel);
            stmt.executeUpdate(tbl_musteri);
            stmt.executeUpdate(tbl_ilac);
            stmt.executeUpdate(tbl_satis);

            stmt.close();
            conn.close();
            return TabloOlustur();
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Veritabani.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
