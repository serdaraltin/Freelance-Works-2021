import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class Abs_C_Ana implements IAna {

    private String tabloAd;
    private Abs_M_Ana model;
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    

    public Abs_C_Ana(Abs_M_Ana model) {
        try {
            this.tabloAd = model.getTabloAd();
            this.model = model;
            connection = new CVeritabani().Baglanti();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Abs_C_Ana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean Kontrol(int Id) {
        String sorgu = "Select * From " + tabloAd + " Where Id=" + Id;

        try {
            connection = new CVeritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);
            if (resultSet.next()) {
                resultSet.close();
                connection.close();
                return true;
            }
            resultSet.close();
            connection.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Abs_C_Ana.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean Sil(int Id) {
        String sorgu = "Delete From " + tabloAd + " Where Id=" + Id;
        return new CVeritabani().Sorgu(sorgu);
    }

    public String getTabloAd() {
        return tabloAd;
    }

    public void setTabloAd(String tabloAd) {
        this.tabloAd = tabloAd;
    }

    @Override
    public String toString() {
        return "Controller_Main{" + "tabloAd=" + tabloAd + '}';
    }

    @Override
    public void Guncelle(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Ac() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Abs_M_Ana getModel() {
        return model;
    }

    public void setModel(Abs_M_Ana model) {
        this.model = model;
    }


 

    
}
