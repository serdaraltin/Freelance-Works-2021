package Controller;

import Model.Satis;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Interface.IController;

public class ControllerSatis implements IController<Satis> {

    ControllerGarson controllerGarson = new ControllerGarson();
    ControllerUrun controllerUrun = new ControllerUrun();

    ControllerDosya dosya = new ControllerDosya();

       
    @Override
    public boolean Ekle(ArrayList<Satis> liste, Satis veri) {
        liste.add(veri);
        dosya.YazSatis(liste);
        return true;
    }

    @Override
    public boolean Sil(ArrayList<Satis> liste, Satis veri) {
        if (liste == null) {
            return false;
        }
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getSatisNo() == veri.getSatisNo()) {
                liste.remove(i);
                dosya.YazSatis(liste);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean Guncelle(ArrayList<Satis> liste, Satis veri) {
        if (liste == null) {
            return false;
        }
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getSatisNo() == veri.getSatisNo()) {
                liste.get(i).setGarsonTcNo(veri.getGarsonTcNo());
                liste.get(i).setAdet(veri.getAdet());
                liste.get(i).setTutar(veri.getTutar());
                liste.get(i).setUrunNo(veri.getUrunNo());
                liste.get(i).setTarih(veri.getTarih());
                dosya.YazSatis(liste);
                return true;
            }
        }
        return false;
    }

    @Override
    public DefaultTableModel Listele(ArrayList<Satis> liste, JTable tablo) {
        if (liste == null) {
            return null;
        }
        DefaultTableModel model = (DefaultTableModel) tablo.getModel();
        model.setRowCount(0);

        for (Satis satis : liste) {
            model.addRow(new Object[]{
                satis.getSatisNo(),
                satis.getGarsonTcNo(),
                satis.getUrunNo(),
                satis.getAdet(),
                satis.getTutar(),
                satis.getTarih()
            });
        }

        return model;
    }

    @Override
    public boolean Ara(ArrayList<Satis> liste, Satis veri, JTable tablo) {
        ArrayList<Satis> bulunanlar = new ArrayList<Satis>();

        for (Satis satis : liste) {
            if (satis.getTarih().contains(veri.getTarih())) {
                bulunanlar.add(satis);
            }
        }

        Listele(bulunanlar, tablo);

        if (bulunanlar.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Satis Sec(ArrayList<Satis> liste, Satis veri) {
        if (liste == null) {
            return null;
        }
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getSatisNo() == veri.getSatisNo()) {
                return liste.get(i);
            }
        }
        return null;
    }

}
