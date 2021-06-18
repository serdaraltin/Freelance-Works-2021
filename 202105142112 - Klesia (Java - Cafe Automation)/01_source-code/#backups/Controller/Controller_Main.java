package Controller;

import Interface.Interface_Controller;
import Model.Model_Main;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller_Main implements Interface_Controller<Model_Main> {

    private ArrayList<Model_Main> liste = new ArrayList<>();
    private Model_Main model;

    public Model_Main getModel() {
        return model;
    }

    public void setModel(Model_Main model) {
        this.model = model;
    }
    
    public ArrayList<Model_Main> getListe() {
        return liste;
    }

    public void setListe(ArrayList<Model_Main> liste) {
        this.liste = liste;
    }

    @Override
    public ArrayList<Model_Main> Listele(JTable tablo) {
        DefaultTableModel model = (DefaultTableModel) tablo.getModel();
        model.setRowCount(0);
        for (int i = 0; i < liste.size(); i++) {
            model.addRow(liste.get(i).getNesne());
        }
        return liste;
    }

    @Override
    public ArrayList<Model_Main> Ara(JTable tablo, String aranan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Ekle(Model_Main veri) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model_Main Guncelle(Model_Main veri) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Sil(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model_Main Getir(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int GetirIndex(Model_Main veri) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Ac() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Guncelle(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
