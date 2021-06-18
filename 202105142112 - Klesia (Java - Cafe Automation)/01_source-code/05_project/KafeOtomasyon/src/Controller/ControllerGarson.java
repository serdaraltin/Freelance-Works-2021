package Controller;

import Model.Garson;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Interface.IController;
import Model.Satis;

public class ControllerGarson implements IController<Garson> {

    ControllerDosya dosya = new ControllerDosya();

    public float KazancHesapla(ArrayList<Satis> satislar, Garson garson) {
        float kazancToplam = 0;
        int kazancAdet = 0;

        for (Satis satis : satislar) {
            if (satis.getGarsonTcNo().equals(garson.getTcNo())) {
                kazancAdet += satis.getAdet();
                kazancToplam += (float)(satis.getTutar() / 100.0) * 10.0;
               
            }
        }
        return kazancToplam;
    }

    @Override
    public boolean Ekle(ArrayList<Garson> liste, Garson veri) {
        liste.add(veri);
        dosya.YazGarson(liste);
        return true;
    }

    @Override
    public boolean Sil(ArrayList<Garson> liste, Garson veri) {
        if (liste == null) {
            return false;
        }
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getTcNo().equals(veri.getTcNo())) {
                liste.remove(i);
                dosya.YazGarson(liste);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean Guncelle(ArrayList<Garson> liste, Garson veri) {
        if (liste == null) {
            return false;
        }
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getTcNo().equals(veri.getTcNo())) {
                liste.get(i).setAd(veri.getAd());
                liste.get(i).setSoyad(veri.getSoyad());
                liste.get(i).setTelefon(veri.getTelefon());
                liste.get(i).setAdres(veri.getAdres());
                dosya.YazGarson(liste);
                return true;
            }
        }
        return false;
    }

    @Override
    public DefaultTableModel Listele(ArrayList<Garson> liste, JTable tablo) {
        if (liste == null) {
            return null;
        }
        DefaultTableModel model = (DefaultTableModel) tablo.getModel();
        model.setRowCount(0);

        for (Garson garson : liste) {
            model.addRow(new Object[]{
                garson.getTcNo(),
                garson.getAd(),
                garson.getSoyad(),
                garson.getTelefon(),
                garson.getEposta(),
                garson.getAdres()
            });
        }

        return model;
    }

    @Override
    public boolean Ara(ArrayList<Garson> liste, Garson veri, JTable tablo) {
        ArrayList<Garson> bulunanlar = new ArrayList<>();

        for (Garson garson : liste) {
            if (garson.getAd().toLowerCase().contains(veri.getAd().toLowerCase()) || garson.getSoyad().toLowerCase().contains(veri.getAd().toLowerCase())) {
                bulunanlar.add(garson);
            }
        }

        Listele(bulunanlar, tablo);

        return bulunanlar.size() > 0;
    }

    @Override
    public Garson Sec(ArrayList<Garson> liste, Garson veri) {
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
