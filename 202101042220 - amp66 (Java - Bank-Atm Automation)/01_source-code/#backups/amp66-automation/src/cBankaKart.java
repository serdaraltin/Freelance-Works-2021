
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class cBankaKart extends acMain {

    public cBankaKart() {
        super(new mlBankaKart());
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
                mlBankaKart kayit = new mlBankaKart(
                        result.getInt("id"),
                        result.getInt("mID"),
                        result.getInt("mBakiye")
                );
                mlMusteri mMusteri = new cMusteri().KayitBilgisi(new mlMusteri(kayit.getMID()));
                model.addRow(new Object[]{
                    kayit.getId(),
                    mMusteri.getAd() + " " + mMusteri.getSoyad(),
                    kayit.getBakiye()
                }
                );

                arrayList.add(kayit);
            }

            conn.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(cBankaKart.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<amlMain> KayitAra(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.gettblad() + " Where "
                    + "mID=" + aranan;
            
            conn = new cVeritabani().Baglanti();
            stmt = conn.createStatement();
            result = stmt.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<amlMain> arrayList = new ArrayList<>();

            while (result.next()) {
                mlBankaKart kayit = new mlBankaKart(
                        result.getInt("id"),
                        result.getInt("mID"),
                        result.getInt("mBakiye")
                );

                mlMusteri mMusteri = new cMusteri().KayitBilgisi(new mlMusteri(kayit.getMID()));
                model.addRow(new Object[]{
                    kayit.getId(),
                    mMusteri.getAd() + " " + mMusteri.getSoyad(),
                    kayit.getBakiye()
                }
                );
                arrayList.add(kayit);
            }
            result.close();
            conn.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(cBankaKart.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean KayitEkle(amlMain model) {
        mlBankaKart model2 = (mlBankaKart) model;
        String sorgu = "Insert Into " + super.gettblad() + " ("
                + "mID,mBakiye) values("
                + model2.getMID() + ","
                + model2.getBakiye() + ""
                + ")";

        return new cVeritabani().Sorgu(sorgu);
    }

    @Override
    public boolean KayitGuncelle(amlMain model) {
        mlBankaKart model2 = (mlBankaKart) model;
        String sorgu = "Update " + super.gettblad() + " set "
                + "mID=" + model2.getMID()
                + ",mBakiye=" + model2.getBakiye()
                + " Where id=" + model2.getId();
        return new cVeritabani().Sorgu(sorgu);
    }

    @Override
    public mlBankaKart KayitBilgisi(amlMain model) {
        mlBankaKart model2 = (mlBankaKart) model;
        try {
            String sorgu = "Select * From " + super.gettblad()
                    + " Where id=" + model.getId();
            conn = new cVeritabani().Baglanti();
            stmt = conn.createStatement();
            result = stmt.executeQuery(sorgu);
            while (result.next()) {
                model2.setId(result.getInt("id"));
                model2.setMID(result.getInt("mID"));
                model2.setBakiye(result.getInt("mBakiye"));
            }
            result.close();
            conn.close();
            return model2;
        } catch (SQLException ex) {
            Logger.getLogger(cBankaKart.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    /*ilgili kaydın id bilgisine göre güncellenmesi*/ public void KayitGuncelle(int id) {
        new pBankaKart(id).setVisible(true);
    }

    @Override
    /*ilgili pencerenin gösterilmesi*/ public void PencereAc() {
        new pBankaKart().setVisible(true);
    }
}
