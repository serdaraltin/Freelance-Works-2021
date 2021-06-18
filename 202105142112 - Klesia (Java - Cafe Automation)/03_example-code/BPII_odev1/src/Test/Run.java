package Test;

import Model.Musteri;
import Model.Satis;
import Model.Urun;
import View.UIMain;
import java.util.ArrayList;

public class Run {
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        ArrayList<Urun> urunler = new ArrayList<Urun>();
        ArrayList<Musteri> musteriler = new ArrayList<Musteri>();
        ArrayList<Satis> satislar = new ArrayList<Satis>();
        
        
        //TEST VERİLERİ
        /*
        
        urunler.add(new Urun(1, "patates", "kg", 3));
        urunler.add(new Urun(2, "domates", "kg", 4));
        urunler.add(new Urun(3, "patlıcan", "kg", 7));
        
        musteriler.add(new Musteri("12345678910", "Ahmet", "Bal", "0542658971", "ahmet@mail.com", "İstanbul"));
        musteriler.add(new Musteri("58796423152", "Seda", "Güben", "05231545697", "seda@mail.com", "Ankara"));
        
        satislar.add(new Satis(1, "12345678910", 2, 3, 12, "2020.08.18"));
        
        */
        
        new UIMain(urunler,musteriler,satislar).setVisible(true);
    }
}
