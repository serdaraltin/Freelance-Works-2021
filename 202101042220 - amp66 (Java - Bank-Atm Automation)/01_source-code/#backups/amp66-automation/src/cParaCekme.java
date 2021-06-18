

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class cParaCekme extends acMain {

    public cParaCekme() {
        super(new mlParaCekme());
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
                mlParaCekme kayit = new mlParaCekme(
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
            Logger.getLogger(cParaCekme.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<amlMain> KayitAra(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.gettblad();

            conn = new cVeritabani().Baglanti();
            result = stmt.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<amlMain> arrayList = new ArrayList<>();

            while (result.next()) {
                mlParaCekme kayit = new mlParaCekme(
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
            Logger.getLogger(cParaCekme.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public boolean KayitEkle(amlMain model) {
        mlParaCekme model2 = (mlParaCekme) model;

        String kartTabloAd;
        int kalan_bakiye;
        int mBakiye;
        if (model2.getKart_tur().equals("Banka Kartı")) {
            kartTabloAd = new mlBankaKart().gettblad();
            mlBankaKart mKBanka = new cBankaKart().KayitBilgisi(new mlBankaKart(model2.getKart_Id()));
            mBakiye = mKBanka.getBakiye();
            int kalan = mKBanka.getBakiye();
            kalan_bakiye = kalan - model2.getMiktar();
            if (kalan_bakiye < 0) {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "Yeterli kMiktar yok!\nKalan : " + kalan + " TL");
                return false;
            }
        } else {
            kartTabloAd = new mlKrediKart().gettblad();
            mlKrediKart mKKredi = new cKrediKart().KayitBilgisi(new mlKrediKart(model2.getKart_Id()));
            mBakiye = mKKredi.getBakiye();
            int kalan_limit = mKKredi.getKart_limit() - mBakiye;
            kalan_bakiye = kalan_limit - model2.getMiktar();
            if (kalan_bakiye < 0) {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "Limitinizden fazla kMiktar çekilemez\nKalan : " + kalan_limit + " TL");
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

        String sorgu2 = "Update " + kartTabloAd + " set mBakiye=" + kalan_bakiye + " Where id=" + model2.getKart_Id();

        return new cVeritabani().Sorgu(sorgu) && new cVeritabani().Sorgu(sorgu2);
    }

    @Override
    public boolean KayitGuncelle(amlMain model) {
        mlParaCekme model2 = (mlParaCekme) model;
        String sorgu = "Update " + super.gettblad() + " set "
                + "ktur='" + model2.getKart_tur() + "'"
                + ",kID=" + model2.getKart_Id()
                + ",kMiktar=" + model2.getMiktar()
                + ",kTarih='" + model2.getKart_tur() + "'"
                + " Where id=" + model2.getId();
        return new cVeritabani().Sorgu(sorgu);
    }

    @Override
    public mlParaCekme KayitBilgisi(amlMain model) {
        mlParaCekme model2 = (mlParaCekme) model;
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
            Logger.getLogger(cParaCekme.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void PencereAc(String ktur, int id) {
        new pParaCekme(ktur, id).setVisible(true);
    }
}
