package Controller;

import Model.Urun;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Interface.IController;

public class ControllerUrun implements IController<Urun> {

    ControllerDosya dosya = new ControllerDosya();

    @Override
    public boolean Ekle(ArrayList<Urun> liste, Urun veri) {
        liste.add(veri);
        dosya.YazUrun(liste);
        return true;
    }

    @Override
    public boolean Sil(ArrayList<Urun> liste, Urun veri) {
        if (liste == null) {
            return false;
        }
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getNo() == veri.getNo()) {
                liste.remove(i);
                dosya.YazUrun(liste);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean Guncelle(ArrayList<Urun> liste, Urun veri) {
        if (liste == null) {
            return false;
        }
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getNo() == veri.getNo()) {
                liste.get(i).setAd(veri.getAd());
                liste.get(i).setBirim(veri.getBirim());
                liste.get(i).setFiyat(veri.getFiyat());
                dosya.YazUrun(liste);
                return true;
            }
        }
        return false;
    }

    @Override
    public DefaultTableModel Listele(ArrayList<Urun> liste, JTable tablo) {
        if (liste == null) {
            return null;
        }
        DefaultTableModel model = (DefaultTableModel) tablo.getModel();
        model.setRowCount(0);

        for (Urun urun : liste) {
            model.addRow(new Object[]{
                urun.getNo(),
                urun.getAd(),
                urun.getBirim(),
                urun.getFiyat(),});
        }

        return model;
    }

    @Override
    public boolean Ara(ArrayList<Urun> liste, Urun veri, JTable tablo) {
        ArrayList<Urun> bulunanlar = new ArrayList<Urun>();

        for (Urun urun : liste) {
            if (urun.getAd().toLowerCase().contains(veri.getAd().toLowerCase())) {
                bulunanlar.add(urun);
            }
        }

        Listele(bulunanlar, tablo);

        if (bulunanlar.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Urun Sec(ArrayList<Urun> liste, Urun veri) {
        if (liste == null) {
            return null;
        }
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getNo() == veri.getNo()) {
                return liste.get(i);
            }
        }
        return null;
    }

}
