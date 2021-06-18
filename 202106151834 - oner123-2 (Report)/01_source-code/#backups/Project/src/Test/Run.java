package Test;

import Controller.ControllerDosya;
import Model.Ogrenci;
import Model.OgretimGorevlisi;
import Model.Talep;
import View.ViewGirisOgrenci;
import java.util.ArrayList;

public class Run {

    public static void main(String[] args) {

        ControllerDosya dosya = new ControllerDosya();
        ArrayList<Ogrenci> ogrenciler = dosya.OkuOgrenci();
        ArrayList<OgretimGorevlisi> ogrGorevliler = dosya.OkuOgretimGorevlisi();
        ArrayList<Talep> talepler = dosya.OkuTalep();

        new ViewGirisOgrenci(ogrenciler, talepler).setVisible(true);

        //new ViewAnaSayfa(urunler, garsonlar, satislar).setVisible(true);
    }
}
