package Controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Interface.IController;
import Model.OgretimGorevlisi;

public class ControllerOgretimGorevlisi implements IController<OgretimGorevlisi> {

    ControllerDosya dosya = new ControllerDosya();

    @Override
    public boolean Ekle(ArrayList<OgretimGorevlisi> liste, OgretimGorevlisi veri) {
        liste.add(veri);
        Yaz(liste);
        return true;
    }

    @Override
    public boolean Sil(ArrayList<OgretimGorevlisi> liste, int no) {
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
    public boolean Guncelle(ArrayList<OgretimGorevlisi> liste, OgretimGorevlisi veri) {
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
    public DefaultTableModel Listele(ArrayList<OgretimGorevlisi> liste, JTable tablo) {
        if (liste == null) {
            return null;
        }
        DefaultTableModel model = (DefaultTableModel) tablo.getModel();
        model.setRowCount(0);

        for (OgretimGorevlisi hesap : liste) {
            model.addRow(hesap.getObject());
        }

        return model;
    }

    @Override
    public boolean Ara(ArrayList<OgretimGorevlisi> liste, OgretimGorevlisi veri, JTable tablo) {
        ArrayList<OgretimGorevlisi> bulunanlar = new ArrayList<>();

        for (OgretimGorevlisi hesap : liste) {

        }

        Listele(bulunanlar, tablo);

        return bulunanlar.size() > 0;
    }

    @Override
    public OgretimGorevlisi Sec(ArrayList<OgretimGorevlisi> liste, int no) {
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

    public void Yaz(ArrayList<OgretimGorevlisi> liste) {
        dosya.YazOgretimGorevlisi(liste);
    }
}
