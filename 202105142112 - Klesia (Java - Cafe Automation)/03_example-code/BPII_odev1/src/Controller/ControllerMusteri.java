package Controller;

import Model.Musteri;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Interface.IController;

public class ControllerMusteri implements IController<Musteri> {

    @Override
    public boolean Ekle(ArrayList<Musteri> liste, Musteri veri) {
        liste.add(veri);
        return true;
    }

    @Override
    public boolean Sil(ArrayList<Musteri> liste, Musteri veri) {
        if (liste == null) {
            return false;
        }
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getTcNo().equals(veri.getTcNo())) {
                liste.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean Guncelle(ArrayList<Musteri> liste, Musteri veri) {
        if (liste == null) {
            return false;
        }
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getTcNo().equals(veri.getTcNo())) {
                liste.get(i).setAd(veri.getAd());
                liste.get(i).setSoyad(veri.getSoyad());
                liste.get(i).setTelefon(veri.getTelefon());
                liste.get(i).setAdres(veri.getAdres());
                return true;
            }
        }
        return false;
    }

    @Override
    public DefaultTableModel Listele(ArrayList<Musteri> liste, JTable tablo) {
        if (liste == null) {
            return null;
        }
        DefaultTableModel model = (DefaultTableModel) tablo.getModel();
        model.setRowCount(0);

        for (Musteri musteri : liste) {
            model.addRow(new Object[]{
                musteri.getTcNo(),
                musteri.getAd(),
                musteri.getSoyad(),
                musteri.getTelefon(),
                musteri.getEposta(),
                musteri.getAdres()
            });
        }

        return model;
    }

    @Override
    public boolean Ara(ArrayList<Musteri> liste, Musteri veri, JTable tablo) {
        ArrayList<Musteri> bulunanlar = new ArrayList<Musteri>();

        for (Musteri musteri : liste) {
            if (musteri.getAd().toLowerCase().contains(veri.getAd().toLowerCase()) || musteri.getSoyad().toLowerCase().contains(veri.getAd().toLowerCase())) {
                bulunanlar.add(musteri);
            }
        }

        Listele(bulunanlar, tablo);

        if (bulunanlar.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Musteri Sec(ArrayList<Musteri> liste, Musteri veri) {
        if (liste == null) {
            return null;
        }
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getTcNo().equals(veri.getTcNo())) {
                return liste.get(i);
            }
        }
        return null;
    }

}
