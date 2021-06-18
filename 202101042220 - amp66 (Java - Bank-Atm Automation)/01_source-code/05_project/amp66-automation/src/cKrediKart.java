

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class cKrediKart extends acMain {

    public cKrediKart() {
        super(new mlKrediKart());
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
                mlKrediKart kayit = new mlKrediKart(
                        result.getInt("id"),
                        result.getInt("id"),
                        result.getInt("mBakiye"),
                        result.getInt("kLimit")
                );
                mlMusteri mMusteri = new cMusteri().KayitBilgisi(new mlMusteri(kayit.getMID()));
                model.addRow(new Object[]{
                    kayit.getId(),
                    mMusteri.getAd() + " " + mMusteri.getSoyad(),
                    kayit.getBakiye(),
                    kayit.getKart_limit()
                }
                );

                arrayList.add(kayit);
            }

            conn.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(cKrediKart.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<amlMain> KayitAra(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.gettblad() + " Where id=" + aranan;
            conn = new cVeritabani().Baglanti();
            stmt = conn.createStatement();
            result = stmt.executeQuery(sorgu);
   
            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<amlMain> arrayList = new ArrayList<>();

            while (result.next()) {
                mlKrediKart kayit = new mlKrediKart(
                        result.getInt("id"),
                        result.getInt("id"),
                        result.getInt("mBakiye"),
                        result.getInt("kLimit")
                );
           
                mlMusteri mMusteri = new cMusteri().KayitBilgisi(new mlMusteri(kayit.getMID()));
                model.addRow(new Object[]{
                    kayit.getId(),
                    mMusteri.getAd() + " " + mMusteri.getSoyad(),
                    kayit.getBakiye(),
                    kayit.getKart_limit()
                }
                );
                arrayList.add(kayit);
            }
            result.close();
            conn.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(cKrediKart.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean KayitEkle(amlMain model) {
        mlKrediKart model2 = (mlKrediKart) model;
        String sorgu = "Insert Into " + super.gettblad() + " ("
                + "id,mBakiye,kLimit) values("
                + model2.getMID() + ","
                + model2.getBakiye() + ","
                + model2.getKart_limit() + ""
                + ")";

        return new cVeritabani().Sorgu(sorgu);
    }

    @Override
    public boolean KayitGuncelle(amlMain model) {
        mlKrediKart model2 = (mlKrediKart) model;
        String sorgu = "Update " + super.gettblad() + " set "
                + "id=" + model2.getMID()
                + ",mBakiye=" + model2.getBakiye()
                + ",kLimit=" + model2.getKart_limit()
                + " Where id=" + model2.getId();
        return new cVeritabani().Sorgu(sorgu);
    }

    @Override
    public mlKrediKart KayitBilgisi(amlMain model) {
        mlKrediKart model2 = (mlKrediKart) model;
        try {
            String sorgu = "Select * From " + super.gettblad()
                    + " Where id=" + model.getId();
            conn = new cVeritabani().Baglanti();
            stmt = conn.createStatement();
            result = stmt.executeQuery(sorgu);
            while (result.next()) {
                model2.setId(result.getInt("id"));
                model2.setMID(result.getInt("id"));
                model2.setBakiye(result.getInt("mBakiye"));
                model2.setKart_limit(result.getInt("kLimit"));
            }
            result.close();
            conn.close();
            return model2;
        } catch (SQLException ex) {
            Logger.getLogger(cKrediKart.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    /*ilgili kaydın id bilgisine göre güncellenmesi*/ public void KayitGuncelle(int id) {
        new pKrediKart(id).setVisible(true);
    }

    @Override
    /*ilgili pencerenin gösterilmesi*/ public void PencereAc() {
        new pKrediKart().setVisible(true);
    }
}
