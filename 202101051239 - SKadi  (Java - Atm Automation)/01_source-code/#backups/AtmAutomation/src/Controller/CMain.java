package Controller;

import Model.MMain;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public abstract class CMain implements Controller.IMain {

    private String tblName;
    private MMain oModel;
    Connection con;
    Statement stmt;
    ResultSet rSet;
    

    public CMain(MMain oModel) {
        try {
            this.tblName = oModel.getTblName();
            this.oModel = oModel;
            con = new Database().Connection();
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean Control(int Id) {
        String query = "Select * From " + tblName + " Where Id=" + Id;

        try {
            con = new Database().Connection();
            rSet = stmt.executeQuery(query);
            if (rSet.next()) {
                rSet.close();
                con.close();
                return true;
            }
            rSet.close();
            con.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean Delete(int Id) {
        String query = "Delete From " + tblName + " Where Id=" + Id;
        return new Database().Query(query);
    }

    public String getTblName() {
        return tblName;
    }

    public void setTabloAd(String tblName) {
        this.tblName = tblName;
    }

    @Override
    public String toString() {
        return "CMain{" + "tblName=" + tblName + '}';
    }

    @Override
    public void Update(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void Open() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public MMain getModel() {
        return oModel;
    }

    public void setModel(MMain oModel) {
        this.oModel = oModel;
    }

    @Override
    public ArrayList<MMain> List(JTable table) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<MMain> Search(JTable table, String want) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean Add(MMain oModel) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean Update(MMain oModel) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public MMain Get(MMain oModel) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
}
