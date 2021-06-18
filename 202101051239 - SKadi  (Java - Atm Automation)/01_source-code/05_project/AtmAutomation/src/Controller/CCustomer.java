package Controller;

import Model.MMain;
import Model.MCustomer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CCustomer extends CMain {

    public CCustomer() {
        super(new MCustomer());
    }

    public boolean Control(String tcno) {
        try {
            String query = "Select * From " + super.getTblName()
                    + " Where tcno='" + tcno + "'";
            con = new Database().Connection();
            stmt = con.createStatement();
            rSet = stmt.executeQuery(query);
            while (rSet.next()) {
                rSet.close();
                con.close();
                return true;
            }
            rSet.close();
            con.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(CCredit.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
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
                MCustomer respon = new MCustomer(
                        rSet.getInt("Id"),
                        rSet.getString("unvan"),
                        rSet.getString("tcno"),
                        rSet.getString("ad"),
                        rSet.getString("soyad"),
                        rSet.getString("dogum"),
                        rSet.getString("telefon"),
                        rSet.getString("eposta"),
                        rSet.getString("adres")
                );

                oModel.addRow(
                        respon.getObject()
                );

                arr.add(respon);
            }

            con.close();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(CCustomer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<MMain> Search(JTable table, String want) {
        try {
            String query = "Select * From " + super.getTblName() + " Where "
                    + " ad LIKE '%" + want
                    + "%' or unvan LIKE '%" + want
                    + "%' or tcno LIKE '%" + want
                    + "%' or ad LIKE '%" + want
                    + "%' or soyad LIKE '%" + want
                    + "%' or dogum LIKE '%" + want
                    + "%' or telefon LIKE '%" + want
                    + "%' or eposta LIKE '%" + want
                    + "%' or adres LIKE '%" + want + "%'";
            ;
            con = new Database().Connection();
            rSet = stmt.executeQuery(query);

            DefaultTableModel oModel = (DefaultTableModel) table.getModel();
            oModel.setRowCount(0);
            ArrayList<MMain> arr = new ArrayList<>();

            while (rSet.next()) {
                MCustomer respon = new MCustomer(
                        rSet.getInt("Id"),
                        rSet.getString("unvan"),
                        rSet.getString("tcno"),
                        rSet.getString("ad"),
                        rSet.getString("soyad"),
                        rSet.getString("dogum"),
                        rSet.getString("telefon"),
                        rSet.getString("eposta"),
                        rSet.getString("adres")
                );

                oModel.addRow(
                        respon.getObject()
                );

                arr.add(respon);
            }
            rSet.close();
            con.close();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(CCustomer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean Add(MMain oModel) {
        MCustomer oModel2 = (MCustomer) oModel;
        String query = "Insert Into " + super.getTblName() + " ("
                + "unvan,tcno,ad,soyad,dogum,telefon,eposta,adres) values('"
                + oModel2.getUnvan() + "','"
                + oModel2.getTcno() + "','"
                + oModel2.getAd() + "','"
                + oModel2.getSoyad() + "','"
                + oModel2.getDogum() + "','"
                + oModel2.getTelefon() + "','"
                + oModel2.getEposta() + "','"
                + oModel2.getAdres() + "'"
                + ")";

        return new Database().Query(query);
    }

    @Override
    public boolean Update(MMain oModel) {
        MCustomer oModel2 = (MCustomer) oModel;
        String query = "Update " + super.getTblName() + " set "
                + "'unvan='" + oModel2.getUnvan()
                + "','tcno=" + oModel2.getTcno()
                + "','ad=" + oModel2.getAd()
                + "','soyad=" + oModel2.getSoyad()
                + "','dogum=" + oModel2.getDogum()
                + "','telefon=" + oModel2.getTelefon()
                + "','eposta=" + oModel2.getEposta()
                + "','adres=" + oModel2.getAdres()
                + "' Where Id=" + oModel2.getId();

        return new Database().Query(query);
    }

    @Override
    public MCustomer Get(MMain oModel) {
        MCustomer oModel2 = (MCustomer) oModel;
        try {
            String query = "Select * From " + super.getTblName()
                    + " Where tcno='" + oModel2.getTcno() + "' or Id=" + oModel.getId();
            con = new Database().Connection();
            stmt = con.createStatement();
            rSet = stmt.executeQuery(query);
            while (rSet.next()) {
                oModel2.setId(rSet.getInt("Id"));
                oModel2.setUnvan(rSet.getString("unvan"));
                oModel2.setTcno(rSet.getString("tcno"));
                oModel2.setAd(rSet.getString("ad"));
                oModel2.setSoyad(rSet.getString("soyad"));
                oModel2.setDogum(rSet.getString("dogum"));
                oModel2.setTelefon(rSet.getString("telefon"));
                oModel2.setEposta(rSet.getString("eposta"));
                oModel2.setAdres(rSet.getString("adres"));

            }
            rSet.close();
            con.close();
            return oModel2;
        } catch (SQLException ex) {
            Logger.getLogger(CCustomer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Update(int Id) {
        new View.VCustomer(Id).setVisible(true);
    }

    @Override
    public void Open() {
        new View.VCustomer().setVisible(true);
    }

}
