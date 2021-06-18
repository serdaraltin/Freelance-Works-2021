package Controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Interface.IController;
import Model.Talep;

public class ControllerTalep implements IController<Talep> {

    ControllerDosya dosya = new ControllerDosya();

    @Override
    public boolean Ekle(ArrayList<Talep> liste, Talep veri) {
        liste.add(veri);
        Yaz(liste);
        return true;
    }

    @Override
    public boolean Sil(ArrayList<Talep> liste, int no) {
        if (liste == null) {
            return false;
        }
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getNo() == no) {
                liste.remove(i);
                Yaz(liste);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean Guncelle(ArrayList<Talep> liste, Talep veri) {
        if (liste == null) {
            return false;
        }
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getNo() == veri.getNo()) {
                Yaz(liste);
                return true;
            }
        }
        return false;
    }

    @Override
    public DefaultTableModel Listele(ArrayList<Talep> liste, JTable tablo) {
        if (liste == null) {
            return null;
        }
        DefaultTableModel model = (DefaultTableModel) tablo.getModel();
        model.setRowCount(0);

        for (Talep hesap : liste) {
            model.addRow(hesap.getObject());
        }

        return model;
    }

    @Override
    public boolean Ara(ArrayList<Talep> liste, Talep veri, JTable tablo) {
        ArrayList<Talep> bulunanlar = new ArrayList<>();

        for (Talep hesap : liste) {

        }

        Listele(bulunanlar, tablo);

        return bulunanlar.size() > 0;
    }

    @Override
    public Talep Sec(ArrayList<Talep> liste, int no) {
        if (liste == null) {
            return null;
        }
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getNo() == no) {
                return liste.get(i);
            }
        }
        return null;
    }

    public void Yaz(ArrayList<Talep> liste) {
        dosya.YazTalep(liste);
    }
}
