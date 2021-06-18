package Controller;

import Model.MBank;
import Model.MCredit;
import Model.MLodgment;
import Model.MMain;
import Model.MCustomer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CLodgment extends CMain {

    public CLodgment() {
        super(new MLodgment());
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
                MLodgment respon = new MLodgment(
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
            Logger.getLogger(CLodgment.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<MMain> Search(JTable table, String want) {
        try {
            String query = "Select * From " + super.getTblName()
                    + " Where tarih LIKE '%" + want + "%' or kart_Id=" + want + " or Id=" + want;

            con = new Database().Connection();
            rSet = stmt.executeQuery(query);

            DefaultTableModel oModel = (DefaultTableModel) table.getModel();
            oModel.setRowCount(0);
            ArrayList<MMain> arr = new ArrayList<>();

            while (rSet.next()) {
                MLodgment respon = new MLodgment(
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
            Logger.getLogger(CLodgment.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public boolean Add(MMain oModel) {
        MLodgment oModel2 = (MLodgment) oModel;

        String kartTabloAd;
        int bakiye;
        if (oModel2.getKart_tur().equals("Banka Kartı")) {
            kartTabloAd = new MBank().getTblName();
            bakiye = new CBank().Get(new MBank(oModel2.getKart_Id())).getBakiye();
        } else {
            kartTabloAd = new MCredit().getTblName();
            MCredit krediKart = new CCredit().Get(new MCredit(oModel2.getKart_Id()));
            bakiye = krediKart.getBakiye();
            if (bakiye + oModel2.getMiktar() > krediKart.getKart_limit()) {
                JOptionPane.showMessageDialog(null, "Kredi kartı borcunuzdan fazla para yatırıyorsunuz !!!");
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

        String sorgu2 = "Update " + kartTabloAd + " set bakiye=" + bakiye + " Where Id=" + oModel2.getKart_Id();

        return new Database().Query(query) && new Database().Query(sorgu2);
    }

    @Override
    public boolean Update(MMain oModel) {
        MLodgment oModel2 = (MLodgment) oModel;
        String query = "Update " + super.getTblName() + " set "
                + "kart_tur='" + oModel2.getKart_tur() + "'"
                + ",kart_Id=" + oModel2.getKart_Id()
                + ",miktar=" + oModel2.getMiktar()
                + ",tarih='" + oModel2.getKart_tur() + "'"
                + " Where Id=" + oModel2.getId();
        return new Database().Query(query);
    }

    @Override
    public MLodgment Get(MMain oModel) {
        MLodgment oModel2 = (MLodgment) oModel;
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
            Logger.getLogger(CLodgment.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
    public void Open(String kart_tur, int Id) {
        new View.VLodgment(kart_tur, Id).setVisible(true);
    }

}
