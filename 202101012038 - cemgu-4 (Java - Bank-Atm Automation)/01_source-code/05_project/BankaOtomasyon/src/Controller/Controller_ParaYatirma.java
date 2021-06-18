package Controller;

import Model.Model_BankaKart;
import Model.Model_KrediKart;
import Model.Model_ParaYatirma;
import Model.Model_Main;
import Model.Model_Musteri;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_ParaYatirma extends Controller_Main {

    public Controller_ParaYatirma() {
        super(new Model_ParaYatirma());
    }

    @Override
    public ArrayList<Model_Main> Listele(JTable Tablo) {
        try {
            String sorgu = "Select * From " + super.getTabloAd();
            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_ParaYatirma kayit = new Model_ParaYatirma(
                        resultSet.getInt("Id"),
                        resultSet.getString("kart_tur"),
                        resultSet.getInt("kart_Id"),
                        resultSet.getInt("miktar"),
                        resultSet.getString("tarih")
                );
                Model_BankaKart bankaKart = new Controller_BankaKart().Getir(new Model_BankaKart(kayit.getKart_Id()));
                Model_Musteri musteri = new Controller_Musteri().Getir(new Model_Musteri(bankaKart.getMusteri_Id()));
                model.addRow(new Object[]{
                    kayit.getId(),
                    musteri.getAd() + " " + musteri.getSoyad(),
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
            Logger.getLogger(Controller_ParaYatirma.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<Model_Main> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where tarih LIKE '%" + aranan + "%' or kart_Id=" + aranan + " or Id=" + aranan;

            connection = new Controller_Veritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Model_Main> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Model_ParaYatirma kayit = new Model_ParaYatirma(
                        resultSet.getInt("Id"),
                        resultSet.getString("kart_tur"),
                        resultSet.getInt("kart_Id"),
                        resultSet.getInt("miktar"),
                        resultSet.getString("tarih")
                );
                Model_BankaKart bankaKart = new Controller_BankaKart().Getir(new Model_BankaKart(kayit.getKart_Id()));
                Model_Musteri musteri = new Controller_Musteri().Getir(new Model_Musteri(bankaKart.getMusteri_Id()));
                model.addRow(new Object[]{
                    kayit.getId(),
                    musteri.getAd() + " " + musteri.getSoyad(),
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
            Logger.getLogger(Controller_ParaYatirma.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public boolean Ekle(Model_Main model) {
        Model_ParaYatirma model2 = (Model_ParaYatirma) model;

        String kartTabloAd;
        int bakiye;
        if (model2.getKart_tur().equals("Banka Kartı")) {
            kartTabloAd = new Model_BankaKart().getTabloAd();
            bakiye = new Controller_BankaKart().Getir(new Model_BankaKart(model2.getKart_Id())).getBakiye();
        } else {
            kartTabloAd = new Model_KrediKart().getTabloAd();
            Model_KrediKart krediKart = new Controller_KrediKart().Getir(new Model_KrediKart(model2.getKart_Id()));
            bakiye = krediKart.getBakiye();
            if (bakiye + model2.getMiktar() > krediKart.getKart_limit()) {
                JOptionPane.showMessageDialog(null, "Kredi kartı borcunuzdan fazla para yatırıyorsunuz !!!");
                return false;
            }
        }
        bakiye += model2.getMiktar();

        String sorgu = "Insert Into " + super.getTabloAd() + " ("
                + "kart_tur,kart_Id,miktar,tarih) values('"
                + model2.getKart_tur() + "',"
                + model2.getKart_Id() + ","
                + model2.getMiktar() + ",'"
                + model2.getTarih() + "'"
                + ")";

        String sorgu2 = "Update " + kartTabloAd + " set bakiye=" + bakiye + " Where Id=" + model2.getKart_Id();

        return new Controller_Veritabani().Sorgu(sorgu) && new Controller_Veritabani().Sorgu(sorgu2);
    }

    @Override
    public boolean Guncelle(Model_Main model) {
        Model_ParaYatirma model2 = (Model_ParaYatirma) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "kart_tur='" + model2.getKart_tur() + "'"
                + ",kart_Id=" + model2.getKart_Id()
                + ",miktar=" + model2.getMiktar()
                + ",tarih='" + model2.getKart_tur() + "'"
                + " Where Id=" + model2.getId();
        return new Controller_Veritabani().Sorgu(sorgu);
    }

    @Override
    public Model_ParaYatirma Getir(Model_Main model) {
        Model_ParaYatirma model2 = (Model_ParaYatirma) model;
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where Id=" + model.getId();
            connection = new Controller_Veritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            while (resultSet.next()) {
                model2.setId(resultSet.getInt("Id"));
                model2.setKart_tur(resultSet.getString("kart_tur"));
                model2.setKart_Id(resultSet.getInt("kart_Id"));
                model2.setMiktar(resultSet.getInt("miktar"));
                model2.setTarih(resultSet.getString("tarih"));
            }
            resultSet.close();
            connection.close();
            return model2;
        } catch (SQLException ex) {
            Logger.getLogger(Controller_ParaYatirma.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
    public void Ac(String kart_tur, int Id) {
        new View.View_ParaYatirma(kart_tur, Id).setVisible(true);
    }

}
