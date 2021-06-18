package Test;

import Controller.ControllerDosya;
import Model.Ogrenci;
import Model.OgretimGorevlisi;
import Model.Talep;
import Model.Yonetici;
import java.util.ArrayList;

public class Run {

    public static void main(String[] args) {

        ControllerDosya dosya = new ControllerDosya();

        ArrayList<Ogrenci> ogrenciler = dosya.OkuOgrenci();
        ArrayList<OgretimGorevlisi> ogrGorevliler = dosya.OkuOgretimGorevlisi();
        ArrayList<Talep> talepler = dosya.OkuTalep();
        ArrayList<Yonetici> yoneticiler = new ArrayList<>();
        yoneticiler.add(new Yonetici("admin", "admin"));
        yoneticiler.add(new Yonetici("yonetici", "123456"));

        //new View.ViewTalep(talepler, 1).setVisible(true);
        // new View.ViewOgrenci(ogrenciler, 1).setVisible(true);
        // new View.ViewOgretimGorevlisi(ogretimGorevlileri,1).setVisible(true);
        
        //new View.ViewPanelYonetici(talepler, ogrenciler, ogrGorevliler).setVisible(true);
        //new View.ViewIslemKullanici(talepler,1,1).setVisible(true);
        new View.ViewAnaSayfa(ogrenciler, ogrGorevliler,talepler, yoneticiler).setVisible(true);
    }
}
