import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

//diğer sınıflarda da aynı methodlar bulundukları için tekrar açıklama yapılmamıştır
public abstract class acMain implements iMain {
    
    //sınıfa ait özellikler
    private String tbl_ad;
    private amlMain model;
    
    //işlem nesneleri
    Connection conn;
    Statement stmt;
    ResultSet result;
    
    //kurucu method
    public acMain(amlMain model) {
        try {
            this.tbl_ad = model.gettblad();
            this.model = model;
            conn = new cVeritabani().Baglanti();
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(acMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
   /*id bilgisine göre kayidin olup olmamasi kontrolü*/ public boolean KayitKontrol(int id) {
        String sorgu = "Select * From " + tbl_ad + " Where id=" + id;

        try {
            conn = new cVeritabani().Baglanti();
            result = stmt.executeQuery(sorgu);
            if (result.next()) {
                result.close();
                conn.close();
                return true;
            }
            result.close();
            conn.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(acMain.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    /*id bilgisine göre kayidin silinmesi*/ public boolean KayitSil(int id) {
        String sorgu = "Delete From " + tbl_ad + " Where id=" + id;
        System.out.println(sorgu);
        return new cVeritabani().Sorgu(sorgu);
    }
    
    //tablo adının geriye döndürülmesi
    public String gettblad() {
        return tbl_ad;
    }

    //tablo adının ayarlanması
    public void setblad(String tbl_ad) {
        this.tbl_ad = tbl_ad;
    }

    //sınıftaki özelliklerin string olarak geriye döndürülmesi
    @Override
    public String toString() {
        return "Controller_Main{" + "tbl_ad=" + tbl_ad + '}';
    }

    @Override
    /*ilgili kaydın id bilgisine göre güncellenmesi*/ public void KayitGuncelle(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    /*ilgili pencerenin gösterilmesi*/ public void PencereAc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //kullanılan modelin geri döndürülmesi
    public amlMain getModel() {
        return model;
    }

    //kullanılacak kaydın ayarlanması
    public void setModel(amlMain model) {
        this.model = model;
    }

    //tablodaki tüm kayıtları listeleme
    @Override
    public ArrayList<amlMain> KayitlariListele(JTable Tablo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //ilgili değere göre kayıtları arama
    @Override
    public ArrayList<amlMain> KayitAra(JTable Tablo, String aranan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //yeni bir kayit ekleme
    @Override
    public boolean KayitEkle(amlMain model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //mevcut kaydı güncelleme
    @Override
    public boolean KayitGuncelle(amlMain model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //kaydın bilgilerinin alınması
    @Override
    public amlMain KayitBilgisi(amlMain model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
