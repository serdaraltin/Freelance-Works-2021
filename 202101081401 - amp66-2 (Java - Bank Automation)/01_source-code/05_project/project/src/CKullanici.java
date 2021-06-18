
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CKullanici extends Abs_C_Ana {

    public CKullanici() {
        super(new MKullanici());
    }

    public boolean Kontrol(String kullanici_ad, String parola) {
        try {
            connection = new CVeritabani().Baglanti();
            statement = connection.createStatement();
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where kullanici_ad='" + kullanici_ad + "' and parola='" + parola + "'";
            resultSet = statement.executeQuery(sorgu);
            while (resultSet.next()) {
                resultSet.close();
                connection.close();
                return true;
            }
            resultSet.close();
            connection.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(CKullanici.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Kontrol(String kullanici_ad) {
        try {
            connection = new CVeritabani().Baglanti();
            statement = connection.createStatement();
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where kullanici_ad='" + kullanici_ad + "'";
            resultSet = statement.executeQuery(sorgu);
            while (resultSet.next()) {
                resultSet.close();
                connection.close();
                return true;
            }
            resultSet.close();
            connection.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(CKullanici.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList<Abs_M_Ana> Listele(JTable Tablo) {
        try {
            String sorgu = "Select * From " + super.getTabloAd();
            connection = new CVeritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Abs_M_Ana> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                MKullanici kayit = new MKullanici(
                        resultSet.getInt("Id"),
                        resultSet.getString("tip"),
                        resultSet.getString("kullanici_ad"),
                        resultSet.getString("parola")
                );

                model.addRow(
                        kayit.getObject()
                );

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(CKullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<Abs_M_Ana> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd() + " Where "
                    + " tip LIKE '%" + aranan + "%' or kullanici_ad LIKE '%" + aranan + "%' or parola LIKE '%" + aranan + "%'";
            ;
            connection = new CVeritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Abs_M_Ana> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                MKullanici kayit = new MKullanici(
                        resultSet.getInt("Id"),
                        resultSet.getString("tip"),
                        resultSet.getString("kullanici_ad"),
                        resultSet.getString("parola")
                );

                model.addRow(
                        kayit.getObject()
                );
                arrayList.add(kayit);
            }
            resultSet.close();
            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(CKullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean Ekle(Abs_M_Ana model) {
        MKullanici model2 = (MKullanici) model;
        String sorgu = "Insert Into " + super.getTabloAd() + " ("
                + "tip,kullanici_ad,parola) values('"
                + model2.getTip() + "','"
                + model2.getKullanici_ad() + "','"
                + model2.getParola() + "'"
                + ")";

        return new CVeritabani().Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Abs_M_Ana model) {
        MKullanici model2 = (MKullanici) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "tip='" + model2.getTip()
                + "',kullanici_ad='" + model2.getKullanici_ad()
                + "',parola='" + model2.getParola()
                + "' Where Id=" + model2.getId();

        return new CVeritabani().Sorgu(sorgu);
    }

    @Override
    public MKullanici Getir(Abs_M_Ana model) {
        MKullanici model2 = (MKullanici) model;
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where kullanici_ad='" + model2.getKullanici_ad() + "' and parola='" + model2.getParola() + "'";
            connection = new CVeritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            while (resultSet.next()) {
                model2.setId(resultSet.getInt("Id"));
                model2.setTip(resultSet.getString("tip"));
                model2.setKullanici_ad(resultSet.getString("kullanici_ad"));
                model2.setParola(resultSet.getString("parola"));
            }
            resultSet.close();
            connection.close();
            return model2;
        } catch (SQLException ex) {
            Logger.getLogger(CKullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Guncelle(int Id) {
        new VKullanici(Id).setVisible(true);
    }

    @Override
    public void Ac() {
        new VKullanici().setVisible(true);
    }
}
