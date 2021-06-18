

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class cParaYatirma extends acMain {

    public cParaYatirma() {
        super(new mlParaYatirma());
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
                mlParaYatirma kayit = new mlParaYatirma(
                        result.getInt("id"),
                        result.getString("ktur"),
                        result.getInt("kID"),
                        result.getInt("kMiktar"),
                        result.getString("kTarih")
                );
                mlBankaKart mKBanka = new cBankaKart().KayitBilgisi(new mlBankaKart(kayit.getKart_Id()));
                mlMusteri mMusteri = new cMusteri().KayitBilgisi(new mlMusteri(mKBanka.getMID()));
                model.addRow(new Object[]{
                    kayit.getId(),
                    mMusteri.getAd() + " " + mMusteri.getSoyad(),
                    kayit.getMiktar(),
                    kayit.getKart_tur(),
                    kayit.getTarih()
                }
                );

                arrayList.add(kayit);
            }

            conn.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(cParaYatirma.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<amlMain> KayitAra(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.gettblad()
                    + " Where kTarih LIKE '%" + aranan + "%' or kID=" + aranan + " or id=" + aranan;

            conn = new cVeritabani().Baglanti();
            result = stmt.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<amlMain> arrayList = new ArrayList<>();

            while (result.next()) {
                mlParaYatirma kayit = new mlParaYatirma(
                        result.getInt("id"),
                        result.getString("ktur"),
                        result.getInt("kID"),
                        result.getInt("kMiktar"),
                        result.getString("kTarih")
                );
                mlBankaKart mKBanka = new cBankaKart().KayitBilgisi(new mlBankaKart(kayit.getKart_Id()));
                mlMusteri mMusteri = new cMusteri().KayitBilgisi(new mlMusteri(mKBanka.getMID()));
                model.addRow(new Object[]{
                    kayit.getId(),
                    mMusteri.getAd() + " " + mMusteri.getSoyad(),
                    kayit.getMiktar(),
                    kayit.getKart_tur(),
                    kayit.getTarih()
                }
                );

                arrayList.add(kayit);
            }

            conn.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(cParaYatirma.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public boolean KayitEkle(amlMain model) {
        mlParaYatirma model2 = (mlParaYatirma) model;

        String kartTabloAd;
        int mBakiye;
        if (model2.getKart_tur().equals("Banka Kartı")) {
            kartTabloAd = new mlBankaKart().gettblad();
            mBakiye = new cBankaKart().KayitBilgisi(new mlBankaKart(model2.getKart_Id())).getBakiye();
        } else {
            kartTabloAd = new mlKrediKart().gettblad();
            mlKrediKart mKKredi = new cKrediKart().KayitBilgisi(new mlKrediKart(model2.getKart_Id()));
            mBakiye = mKKredi.getBakiye();
            if (mBakiye + model2.getMiktar() > mKKredi.getKart_limit()) {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "Kredi kartı borcunuzdan fazla para yatırıyorsunuz !!!");
                return false;
            }
        }
        mBakiye += model2.getMiktar();

        String sorgu = "Insert Into " + super.gettblad() + " ("
                + "ktur,kID,kMiktar,kTarih) values('"
                + model2.getKart_tur() + "',"
                + model2.getKart_Id() + ","
                + model2.getMiktar() + ",'"
                + model2.getTarih() + "'"
                + ")";

        String sorgu2 = "Update " + kartTabloAd + " set mBakiye=" + mBakiye + " Where id=" + model2.getKart_Id();

        return new cVeritabani().Sorgu(sorgu) && new cVeritabani().Sorgu(sorgu2);
    }

    @Override
    public boolean KayitGuncelle(amlMain model) {
        mlParaYatirma model2 = (mlParaYatirma) model;
        String sorgu = "Update " + super.gettblad() + " set "
                + "ktur='" + model2.getKart_tur() + "'"
                + ",kID=" + model2.getKart_Id()
                + ",kMiktar=" + model2.getMiktar()
                + ",kTarih='" + model2.getKart_tur() + "'"
                + " Where id=" + model2.getId();
        return new cVeritabani().Sorgu(sorgu);
    }

    @Override
    public mlParaYatirma KayitBilgisi(amlMain model) {
        mlParaYatirma model2 = (mlParaYatirma) model;
        try {
            String sorgu = "Select * From " + super.gettblad()
                    + " Where id=" + model.getId();
            conn = new cVeritabani().Baglanti();
            stmt = conn.createStatement();
            result = stmt.executeQuery(sorgu);
            while (result.next()) {
                model2.setId(result.getInt("id"));
                model2.setKart_tur(result.getString("ktur"));
                model2.setKart_Id(result.getInt("kID"));
                model2.setMiktar(result.getInt("kMiktar"));
                model2.setTarih(result.getString("kTarih"));
            }
            result.close();
            conn.close();
            return model2;
        } catch (SQLException ex) {
            Logger.getLogger(cParaYatirma.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
    public void PencereAc(String ktur, int id) {
        new pParaYatirma(ktur, id).setVisible(true);
    }

}
