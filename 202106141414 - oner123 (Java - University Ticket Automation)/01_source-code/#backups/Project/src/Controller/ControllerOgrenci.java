package Controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Interface.IController;
import Model.Ogrenci;

public class ControllerOgrenci implements IController<Ogrenci> {

    ControllerDosya dosya = new ControllerDosya();

    @Override
    public boolean Ekle(ArrayList<Ogrenci> liste, Ogrenci veri) {
        liste.add(veri);
        Yaz(liste);
        return true;
    }

    @Override
    public boolean Sil(ArrayList<Ogrenci> liste, int no) {
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
    public boolean Guncelle(ArrayList<Ogrenci> liste, Ogrenci veri) {
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
    public DefaultTableModel Listele(ArrayList<Ogrenci> liste, JTable tablo) {
        if (liste == null) {
            return null;
        }
        DefaultTableModel model = (DefaultTableModel) tablo.getModel();
        model.setRowCount(0);

        for (Ogrenci hesap : liste) {
            model.addRow(hesap.getObject());
        }

        return model;
    }

    @Override
    public boolean Ara(ArrayList<Ogrenci> liste, Ogrenci veri, JTable tablo) {
        ArrayList<Ogrenci> bulunanlar = new ArrayList<>();

        for (Ogrenci hesap : liste) {

        }

        Listele(bulunanlar, tablo);

        return bulunanlar.size() > 0;
    }

    @Override
    public Ogrenci Sec(ArrayList<Ogrenci> liste, int no) {
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

    public void Yaz(ArrayList<Ogrenci> liste) {
        dosya.YazOgrenci(liste);
    }
}
