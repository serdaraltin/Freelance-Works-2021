package Controller;

import Model.MCredit;
import Model.MMain;
import Model.MCustomer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CCredit extends CMain {

    public CCredit() {
        super(new MCredit());
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
                MCredit respon = new MCredit(
                        rSet.getInt("Id"),
                        rSet.getInt("musteri_Id"),
                        rSet.getInt("bakiye"),
                        rSet.getInt("kart_limit")
                );
                MCustomer customer = new CCustomer().Get(new MCustomer(respon.getMusteri_Id()));
                oModel.addRow(new Object[]{
                    respon.getId(),
                    customer.getAd() + " " + customer.getSoyad(),
                    respon.getBakiye(),
                    respon.getKart_limit()
                }
                );

                arr.add(respon);
            }

            con.close();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(CCredit.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<MMain> Search(JTable table, String want) {
        try {
            String query = "Select * From " + super.getTblName() + " Where musteri_Id=" + want;
            con = new Database().Connection();
            stmt = con.createStatement();
            rSet = stmt.executeQuery(query);
   
            DefaultTableModel oModel = (DefaultTableModel) table.getModel();
            oModel.setRowCount(0);
            ArrayList<MMain> arr = new ArrayList<>();

            while (rSet.next()) {
                MCredit respon = new MCredit(
                        rSet.getInt("Id"),
                        rSet.getInt("musteri_Id"),
                        rSet.getInt("bakiye"),
                        rSet.getInt("kart_limit")
                );
           
                MCustomer customer = new CCustomer().Get(new MCustomer(respon.getMusteri_Id()));
                oModel.addRow(new Object[]{
                    respon.getId(),
                    customer.getAd() + " " + customer.getSoyad(),
                    respon.getBakiye(),
                    respon.getKart_limit()
                }
                );
                arr.add(respon);
            }
            rSet.close();
            con.close();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(CCredit.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean Add(MMain oModel) {
        MCredit oModel2 = (MCredit) oModel;
        String query = "Insert Into " + super.getTblName() + " ("
                + "musteri_Id,bakiye,kart_limit) values("
                + oModel2.getMusteri_Id() + ","
                + oModel2.getBakiye() + ","
                + oModel2.getKart_limit() + ""
                + ")";

        return new Database().Query(query);
    }

    @Override
    public boolean Update(MMain oModel) {
        MCredit oModel2 = (MCredit) oModel;
        String query = "Update " + super.getTblName() + " set "
                + "musteri_Id=" + oModel2.getMusteri_Id()
                + ",bakiye=" + oModel2.getBakiye()
                + ",kart_limit=" + oModel2.getKart_limit()
                + " Where Id=" + oModel2.getId();
        return new Database().Query(query);
    }

    @Override
    public MCredit Get(MMain oModel) {
        MCredit oModel2 = (MCredit) oModel;
        try {
            String query = "Select * From " + super.getTblName()
                    + " Where Id=" + oModel.getId();
            con = new Database().Connection();
            stmt = con.createStatement();
            rSet = stmt.executeQuery(query);
            while (rSet.next()) {
                oModel2.setId(rSet.getInt("Id"));
                oModel2.setMusteri_Id(rSet.getInt("musteri_Id"));
                oModel2.setBakiye(rSet.getInt("bakiye"));
                oModel2.setKart_limit(rSet.getInt("kart_limit"));
            }
            rSet.close();
            con.close();
            return oModel2;
        } catch (SQLException ex) {
            Logger.getLogger(CCredit.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Update(int Id) {
        new View.VCredit(Id).setVisible(true);
    }

    @Override
    public void Open() {
        new View.VCredit().setVisible(true);
    }
}
