package Controller;

import Model.MBank;
import Model.MCredit;
import Model.MWithDraw;
import Model.MMain;
import Model.MCustomer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CWithDraw extends CMain {

    public CWithDraw() {
        super(new MWithDraw());
    }

    @Override
    public ArrayList<MMain> List(JTable table) {
        try {
            String query = "Select * From " + super.getTblName();
            con = new Database().Connection();
            rSet = stmt.executeQuery(query);

            DefaultTableModel oModel = (DefaultTableModel) table.getModel();
            oModel.setRowCount(0);
            ArrayList<MMain> arr = new ArrayList<>();

            while (rSet.next()) {
                MWithDraw respon = new MWithDraw(
                        rSet.getInt("Id"),
                        rSet.getString("kart_tur"),
                        rSet.getInt("kart_Id"),
                        rSet.getInt("miktar"),
                        rSet.getString("tarih")
                );
                MBank bank = new CBank().Get(new MBank(respon.getKart_Id()));
                MCustomer customer = new CCustomer().Get(new MCustomer(bank.getMusteri_Id()));
                oModel.addRow(new Object[]{
                    respon.getId(),
                    customer.getAd() + " " + customer.getSoyad(),
                    respon.getMiktar(),
                    respon.getKart_tur(),
                    respon.getTarih()
                }
                );

                arr.add(respon);
            }

            con.close();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(CWithDraw.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<MMain> Search(JTable table, String want) {
        try {
            String query = "Select * From " + super.getTblName();

            con = new Database().Connection();
            rSet = stmt.executeQuery(query);

            DefaultTableModel oModel = (DefaultTableModel) table.getModel();
            oModel.setRowCount(0);
            ArrayList<MMain> arr = new ArrayList<>();

            while (rSet.next()) {
                MWithDraw respon = new MWithDraw(
                        rSet.getInt("Id"),
                        rSet.getString("kart_tur"),
                        rSet.getInt("kart_Id"),
                        rSet.getInt("miktar"),
                        rSet.getString("tarih")
                );
                MBank bank = new CBank().Get(new MBank(respon.getKart_Id()));
                MCustomer customer = new CCustomer().Get(new MCustomer(bank.getMusteri_Id()));
                oModel.addRow(new Object[]{
                    respon.getId(),
                    customer.getAd() + " " + customer.getSoyad(),
                    respon.getMiktar(),
                    respon.getKart_tur(),
                    respon.getTarih()
                }
                );

                arr.add(respon);
            }

            con.close();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(CWithDraw.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public boolean Add(MMain oModel) {
        MWithDraw oModel2 = (MWithDraw) oModel;

        String kartTabloAd;
        int kalan_bakiye;
        int bakiye;
        if (oModel2.getKart_tur().equals("Banka Kartı")) {
            kartTabloAd = new MBank().getTblName();
            MBank bank = new CBank().Get(new MBank(oModel2.getKart_Id()));
            bakiye = bank.getBakiye();
            int kalan = bank.getBakiye();
            kalan_bakiye = kalan - oModel2.getMiktar();
            if (kalan_bakiye < 0) {
                JOptionPane.showMessageDialog(null, "Yeterli miktar yok!\nKalan : " + kalan + " TL");
                return false;
            }
        } else {
            kartTabloAd = new MCredit().getTblName();
            MCredit krediKart = new CCredit().Get(new MCredit(oModel2.getKart_Id()));
            bakiye = krediKart.getBakiye();
            int kalan_limit = krediKart.getKart_limit() - bakiye;
            kalan_bakiye = kalan_limit - oModel2.getMiktar();
            if (kalan_bakiye < 0) {
                JOptionPane.showMessageDialog(null, "Limitinizden fazla miktar çekilemez\nKalan : " + kalan_limit + " TL");
                return false;
            }
        }
        bakiye += oModel2.getMiktar();

        String query = "Insert Into " + super.getTblName() + " ("
                + "kart_tur,kart_Id,miktar,tarih) values('"
                + oModel2.getKart_tur() + "',"
                + oModel2.getKart_Id() + ","
                + oModel2.getMiktar() + ",'"
                + oModel2.getTarih() + "'"
                + ")";

        String sorgu2 = "Update " + kartTabloAd + " set bakiye=" + kalan_bakiye + " Where Id=" + oModel2.getKart_Id();

        return new Database().Query(query) && new Database().Query(sorgu2);
    }

    @Override
    public boolean Update(MMain oModel) {
        MWithDraw oModel2 = (MWithDraw) oModel;
        String query = "Update " + super.getTblName() + " set "
                + "kart_tur='" + oModel2.getKart_tur() + "'"
                + ",kart_Id=" + oModel2.getKart_Id()
                + ",miktar=" + oModel2.getMiktar()
                + ",tarih='" + oModel2.getKart_tur() + "'"
                + " Where Id=" + oModel2.getId();
        return new Database().Query(query);
    }

    @Override
    public MWithDraw Get(MMain oModel) {
        MWithDraw oModel2 = (MWithDraw) oModel;
        try {
            String query = "Select * From " + super.getTblName()
                    + " Where Id=" + oModel.getId();
            con = new Database().Connection();
            stmt = con.createStatement();
            rSet = stmt.executeQuery(query);
            while (rSet.next()) {
                oModel2.setId(rSet.getInt("Id"));
                oModel2.setKart_tur(rSet.getString("kart_tur"));
                oModel2.setKart_Id(rSet.getInt("kart_Id"));
                oModel2.setMiktar(rSet.getInt("miktar"));
                oModel2.setTarih(rSet.getString("tarih"));
            }
            rSet.close();
            con.close();
            return oModel2;
        } catch (SQLException ex) {
            Logger.getLogger(CWithDraw.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void Open(String kart_tur, int Id) {
        new View.VWithDraw(kart_tur, Id).setVisible(true);
    }
}
