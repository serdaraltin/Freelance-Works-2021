

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class cKullanici extends acMain {

    public cKullanici() {
        super(new mlKullanici());
    }

    public boolean KayitKontrol(String kullanici, String parola) {
        try {
            conn = new cVeritabani().Baglanti();
            stmt = conn.createStatement();
            String sorgu = "Select * From " + super.gettblad()
                    + " Where kullanici='" + kullanici + "' and parola='" + parola + "'";
            result = stmt.executeQuery(sorgu);
            while (result.next()) {
                result.close();
                conn.close();
                return true;
            }
            result.close();
            conn.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(cKullanici.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean KayitKontrol(String kullanici) {
        try {
            conn = new cVeritabani().Baglanti();
            stmt = conn.createStatement();
            String sorgu = "Select * From " + super.gettblad()
                    + " Where kullanici='" + kullanici + "'";
            result = stmt.executeQuery(sorgu);
            while (result.next()) {
                result.close();
                conn.close();
                return true;
            }
            result.close();
            conn.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(cKullanici.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList<amlMain> KayitlariListele(JTable Tablo) {
        try {
            String sorgu = "Select * From " + super.gettblad();
            conn = new cVeritabani().Baglanti();
            result = stmt.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<amlMain> arrayList = new ArrayList<>();

            while (result.next()) {
                mlKullanici kayit = new mlKullanici(
                        result.getInt("id"),
                        result.getString("tip"),
                        result.getString("kullanici"),
                        result.getString("parola")
                );

                model.addRow(
                        kayit.getveri()
                );

                arrayList.add(kayit);
            }

            conn.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(cKullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<amlMain> KayitAra(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.gettblad() + " Where "
                    + " tip LIKE '%" + aranan + "%' or kullanici LIKE '%" + aranan + "%' or parola LIKE '%" + aranan + "%'";
            ;
            conn = new cVeritabani().Baglanti();
            result = stmt.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<amlMain> arrayList = new ArrayList<>();

            while (result.next()) {
                mlKullanici kayit = new mlKullanici(
                        result.getInt("id"),
                        result.getString("tip"),
                        result.getString("kullanici"),
                        result.getString("parola")
                );

                model.addRow(
                        kayit.getveri()
                );
                arrayList.add(kayit);
            }
            result.close();
            conn.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(cKullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean KayitEkle(amlMain model) {
        mlKullanici model2 = (mlKullanici) model;
        String sorgu = "Insert Into " + super.gettblad() + " ("
                + "tip,kullanici,parola) values('"
                + model2.getTip() + "','"
                + model2.getKullanici_ad() + "','"
                + model2.getParola() + "'"
                + ")";

        return new cVeritabani().Sorgu(sorgu);
    }

    @Override
    public boolean KayitGuncelle(amlMain model) {
        mlKullanici model2 = (mlKullanici) model;
        String sorgu = "Update " + super.gettblad() + " set "
                + "tip='" + model2.getTip()
                + "',kullanici='" + model2.getKullanici_ad()
                + "',parola='" + model2.getParola()
                + "' Where id=" + model2.getId();

        return new cVeritabani().Sorgu(sorgu);
    }

    @Override
    public mlKullanici KayitBilgisi(amlMain model) {
        mlKullanici model2 = (mlKullanici) model;
        try {
            String sorgu = "Select * From " + super.gettblad()
                    + " Where kullanici='" + model2.getKullanici_ad() + "' and parola='" + model2.getParola() + "'";
            conn = new cVeritabani().Baglanti();
            stmt = conn.createStatement();
            result = stmt.executeQuery(sorgu);
            while (result.next()) {
                model2.setId(result.getInt("id"));
                model2.setTip(result.getString("tip"));
                model2.setKullanici_ad(result.getString("kullanici"));
                model2.setParola(result.getString("parola"));
            }
            result.close();
            conn.close();
            return model2;
        } catch (SQLException ex) {
            Logger.getLogger(cKullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    /*ilgili kaydın id bilgisine göre güncellenmesi*/ public void KayitGuncelle(int id) {
        new pKullanici(id).setVisible(true);
    }

    @Override
    /*ilgili pencerenin gösterilmesi*/ public void PencereAc() {
        new pKullanici().setVisible(true);
    }
}
