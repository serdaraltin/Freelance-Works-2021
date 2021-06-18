

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class cMusteri extends acMain {

    public cMusteri() {
        super(new mlMusteri());
    }

    public boolean KayitKontrol(String tcno) {
        try {
            String sorgu = "Select * From " + super.gettblad()
                    + " Where tcno='" + tcno + "'";
            conn = new cVeritabani().Baglanti();
            stmt = conn.createStatement();
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
            Logger.getLogger(cKrediKart.class.getName()).log(Level.SEVERE, null, ex);
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
                mlMusteri kayit = new mlMusteri(
                        result.getInt("id"),
                        result.getString("unvan"),
                        result.getString("tcno"),
                        result.getString("ad"),
                        result.getString("soyad"),
                        result.getString("dogum"),
                        result.getString("telefon"),
                        result.getString("eposta"),
                        result.getString("adres")
                );

                model.addRow(
                        kayit.getveri()
                );

                arrayList.add(kayit);
            }

            conn.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(cMusteri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<amlMain> KayitAra(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.gettblad() + " Where "
                    + " ad LIKE '%" + aranan
                    + "%' or unvan LIKE '%" + aranan
                    + "%' or tcno LIKE '%" + aranan
                    + "%' or ad LIKE '%" + aranan
                    + "%' or soyad LIKE '%" + aranan
                    + "%' or dogum LIKE '%" + aranan
                    + "%' or telefon LIKE '%" + aranan
                    + "%' or eposta LIKE '%" + aranan
                    + "%' or adres LIKE '%" + aranan + "%'";
            ;
            conn = new cVeritabani().Baglanti();
            result = stmt.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<amlMain> arrayList = new ArrayList<>();

            while (result.next()) {
                mlMusteri kayit = new mlMusteri(
                        result.getInt("id"),
                        result.getString("unvan"),
                        result.getString("tcno"),
                        result.getString("ad"),
                        result.getString("soyad"),
                        result.getString("dogum"),
                        result.getString("telefon"),
                        result.getString("eposta"),
                        result.getString("adres")
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
            Logger.getLogger(cMusteri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean KayitEkle(amlMain model) {
        mlMusteri model2 = (mlMusteri) model;
        String sorgu = "Insert Into " + super.gettblad() + " ("
                + "unvan,tcno,ad,soyad,dogum,telefon,eposta,adres) values('"
                + model2.getUnvan() + "','"
                + model2.getTcno() + "','"
                + model2.getAd() + "','"
                + model2.getSoyad() + "','"
                + model2.getDogum() + "','"
                + model2.getTelefon() + "','"
                + model2.getEposta() + "','"
                + model2.getAdres() + "'"
                + ")";

        return new cVeritabani().Sorgu(sorgu);
    }

    @Override
    public boolean KayitGuncelle(amlMain model) {
        mlMusteri model2 = (mlMusteri) model;
        String sorgu = "Update " + super.gettblad() + " set "
                + "unvan='" + model2.getUnvan()
                + "',tcno=" + model2.getTcno()
                + "',ad=" + model2.getAd()
                + "',soyad=" + model2.getSoyad()
                + "',dogum=" + model2.getDogum()
                + "',telefon=" + model2.getTelefon()
                + "',eposta=" + model2.getEposta()
                + "',adres=" + model2.getAdres()
                + "' Where id=" + model2.getId();

        return new cVeritabani().Sorgu(sorgu);
    }

    @Override
    public mlMusteri KayitBilgisi(amlMain model) {
        mlMusteri model2 = (mlMusteri) model;
        try {
            String sorgu = "Select * From " + super.gettblad()
                    + " Where tcno='" + model2.getTcno() + "' or id=" + model.getId();
            conn = new cVeritabani().Baglanti();
            stmt = conn.createStatement();
            result = stmt.executeQuery(sorgu);
            while (result.next()) {
                model2.setId(result.getInt("id"));
                model2.setUnvan(result.getString("unvan"));
                model2.setTcno(result.getString("tcno"));
                model2.setAd(result.getString("ad"));
                model2.setSoyad(result.getString("soyad"));
                model2.setDogum(result.getString("dogum"));
                model2.setTelefon(result.getString("telefon"));
                model2.setEposta(result.getString("eposta"));
                model2.setAdres(result.getString("adres"));

            }
            result.close();
            conn.close();
            return model2;
        } catch (SQLException ex) {
            Logger.getLogger(cMusteri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    /*ilgili kaydın id bilgisine göre güncellenmesi*/ public void KayitGuncelle(int id) {
        new pMusteri(id).setVisible(true);
    }

    @Override
    /*ilgili pencerenin gösterilmesi*/ public void PencereAc() {
        new pMusteri().setVisible(true);
    }

}
