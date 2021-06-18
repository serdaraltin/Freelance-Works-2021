
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CFaturaOdeme extends Abs_C_Ana {

    public CFaturaOdeme() {
        super(new MFaturaOdeme());
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
                MFaturaOdeme kayit = new MFaturaOdeme(
                        resultSet.getInt("Id"),
                        resultSet.getString("kart_tur"),
                        resultSet.getInt("kart_Id"),
                        resultSet.getString("kurum"),
                        resultSet.getInt("miktar"),
                        resultSet.getString("tarih")
                );
                MBankaKart bankaKart = new CBankaKart().Getir(new MBankaKart(kayit.getKart_Id()));
                MMusteri musteri = new CMusteri().Getir(new MMusteri(bankaKart.getMusteri_Id()));
                model.addRow(new Object[]{
                    kayit.getId(),
                    musteri.getAd() + " " + musteri.getSoyad(),
                    kayit.getKurum(),
                     kayit.getKart_Id(),
                    kayit.getMiktar(),
                    kayit.getKart_tur(),
                    kayit.getTarih()
                }
                );

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(CFaturaOdeme.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<Abs_M_Ana> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where kurum LIKE '%" + aranan + "%' tarih LIKE '%" + aranan + "%' or kart_Id=" + aranan + " or Id=" + aranan;

            connection = new CVeritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Abs_M_Ana> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                MFaturaOdeme kayit = new MFaturaOdeme(
                        resultSet.getInt("Id"),
                        resultSet.getString("kart_tur"),
                        resultSet.getInt("kart_Id"),
                        resultSet.getString("kurum"),
                        resultSet.getInt("miktar"),
                        resultSet.getString("tarih")
                );
                MBankaKart bankaKart = new CBankaKart().Getir(new MBankaKart(kayit.getKart_Id()));
                MMusteri musteri = new CMusteri().Getir(new MMusteri(bankaKart.getMusteri_Id()));
                model.addRow(new Object[]{
                    kayit.getId(),
                    musteri.getAd() + " " + musteri.getSoyad(),
                    kayit.getKurum(),
                     kayit.getKart_Id(),
                    kayit.getMiktar(),
                    kayit.getKart_tur(),
                    kayit.getTarih()
                }
                );

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(CFaturaOdeme.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public boolean Ekle(Abs_M_Ana model) {
        MFaturaOdeme model2 = (MFaturaOdeme) model;

        String kartTabloAd;
        int kalan_bakiye;
        int bakiye;
        if (model2.getKart_tur().equals("Banka Kartı")) {
            kartTabloAd = new MBankaKart().getTabloAd();
            MBankaKart bankaKart = new CBankaKart().Getir(new MBankaKart(model2.getKart_Id()));
            bakiye = bankaKart.getBakiye() - model2.getMiktar();

            if (bakiye < 0) {
                JOptionPane.showMessageDialog(null, "Yeterli miktar yok!\nKalan : " + bankaKart.getBakiye() + " TL");
                return false;
            }
        } else {
            kartTabloAd = new MKrediKart().getTabloAd();
            MKrediKart krediKart = new CKrediKart().Getir(new MKrediKart(model2.getKart_Id()));

            bakiye = krediKart.getBakiye() + model2.getMiktar();

            kalan_bakiye = krediKart.getKart_limit() - krediKart.getBakiye();

            if (bakiye > krediKart.getKart_limit()) {
                JOptionPane.showMessageDialog(null, "Limitinizden fazla miktar çekilemez\nKalan : " + kalan_bakiye + " TL");
                return false;
            }
        }

        String sorgu = "Insert Into " + super.getTabloAd() + " ("
                + "kart_tur,kart_Id,kurum,miktar,tarih) values('"
                + model2.getKart_tur() + "',"
                + model2.getKart_Id() + ",'"
                + model2.getKurum() + "',"
                + model2.getMiktar() + ",'"
                + model2.getTarih() + "'"
                + ")";

        String sorgu2 = "Update " + kartTabloAd + " set bakiye=" + bakiye + " Where Id=" + model2.getKart_Id();

        return new CVeritabani().Sorgu(sorgu) && new CVeritabani().Sorgu(sorgu2);
    }

    @Override
    public boolean Guncelle(Abs_M_Ana model) {
        MFaturaOdeme model2 = (MFaturaOdeme) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "kart_tur='" + model2.getKart_tur() + "'"
                + ",kart_Id=" + model2.getKart_Id()
                + "kurum='" + model2.getKurum() + "'"
                + ",miktar=" + model2.getMiktar()
                + ",tarih='" + model2.getKart_tur() + "'"
                + " Where Id=" + model2.getId();
        return new CVeritabani().Sorgu(sorgu);
    }

    @Override
    public MFaturaOdeme Getir(Abs_M_Ana model) {
        MFaturaOdeme model2 = (MFaturaOdeme) model;
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where Id=" + model.getId();
            connection = new CVeritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            while (resultSet.next()) {
                model2.setId(resultSet.getInt("Id"));
                model2.setKart_tur(resultSet.getString("kart_tur"));
                model2.setKart_Id(resultSet.getInt("kart_Id"));
                model2.setKurum(resultSet.getString("kurum"));
                model2.setMiktar(resultSet.getInt("miktar"));
                model2.setTarih(resultSet.getString("tarih"));
            }
            resultSet.close();
            connection.close();
            return model2;
        } catch (SQLException ex) {
            Logger.getLogger(CFaturaOdeme.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void Ac(String kart_tur, int Id) {
        new VFaturaOdeme(kart_tur, Id).setVisible(true);
    }
}
