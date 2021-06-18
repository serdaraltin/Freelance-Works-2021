package Controller;

import Model.MUser;
import Model.MMain;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CUser extends CMain {

    public CUser() {
        super(new MUser());
    }

    public boolean Control(String kullanici_ad, String parola) {
        try {
            con = new Database().Connection();
            stmt = con.createStatement();
            String query = "Select * From " + super.getTblName()
                    + " Where kullanici_ad='" + kullanici_ad + "' and parola='" + parola + "'";
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
            Logger.getLogger(CUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Control(String kullanici_ad) {
        try {
            con = new Database().Connection();
            stmt = con.createStatement();
            String query = "Select * From " + super.getTblName()
                    + " Where kullanici_ad='" + kullanici_ad + "'";
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
            Logger.getLogger(CUser.class.getName()).log(Level.SEVERE, null, ex);
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
                MUser respon = new MUser(
                        rSet.getInt("Id"),
                        rSet.getString("tip"),
                        rSet.getString("kullanici_ad"),
                        rSet.getString("parola")
                );

                oModel.addRow(
                        respon.getObject()
                );

                arr.add(respon);
            }

            con.close();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(CUser.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<MMain> Search(JTable table, String want) {
        try {
            String query = "Select * From " + super.getTblName() + " Where "
                    + " tip LIKE '%" + want + "%' or kullanici_ad LIKE '%" + want + "%' or parola LIKE '%" + want + "%'";
            ;
            con = new Database().Connection();
            rSet = stmt.executeQuery(query);

            DefaultTableModel oModel = (DefaultTableModel) table.getModel();
            oModel.setRowCount(0);
            ArrayList<MMain> arr = new ArrayList<>();

            while (rSet.next()) {
                MUser respon = new MUser(
                        rSet.getInt("Id"),
                        rSet.getString("tip"),
                        rSet.getString("kullanici_ad"),
                        rSet.getString("parola")
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
            Logger.getLogger(CUser.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean Add(MMain oModel) {
        MUser oModel2 = (MUser) oModel;
        String query = "Insert Into " + super.getTblName() + " ("
                + "tip,kullanici_ad,parola) values('"
                + oModel2.getTip() + "','"
                + oModel2.getKullanici_ad() + "','"
                + oModel2.getParola() + "'"
                + ")";

        return new Database().Query(query);
    }

    @Override
    public boolean Update(MMain oModel) {
        MUser oModel2 = (MUser) oModel;
        String query = "Update " + super.getTblName() + " set "
                + "tip='" + oModel2.getTip()
                + "',kullanici_ad='" + oModel2.getKullanici_ad()
                + "',parola='" + oModel2.getParola()
                + "' Where Id=" + oModel2.getId();

        return new Database().Query(query);
    }

    @Override
    public MUser Get(MMain oModel) {
        MUser oModel2 = (MUser) oModel;
        try {
            String query = "Select * From " + super.getTblName()
                    + " Where kullanici_ad='" + oModel2.getKullanici_ad() + "' and parola='" + oModel2.getParola() + "'";
            con = new Database().Connection();
            stmt = con.createStatement();
            rSet = stmt.executeQuery(query);
            while (rSet.next()) {
                oModel2.setId(rSet.getInt("Id"));
                oModel2.setTip(rSet.getString("tip"));
                oModel2.setKullanici_ad(rSet.getString("kullanici_ad"));
                oModel2.setParola(rSet.getString("parola"));
            }
            rSet.close();
            con.close();
            return oModel2;
        } catch (SQLException ex) {
            Logger.getLogger(CUser.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Update(int Id) {
        new View.VUser(Id).setVisible(true);
    }

    @Override
    public void Open() {
        new View.VUser().setVisible(true);
    }
}
