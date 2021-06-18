package Test;

import Controller.ControllerDosya;
import Model.Garson;
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

        ControllerDosya dosya = new ControllerDosya();

        ArrayList<Urun> urunler = dosya.OkuUrun();
        ArrayList<Garson> garsonlar = dosya.OkuGarson();
        ArrayList<Satis> satislar = dosya.OkuSatis();

        new UIMain(urunler, garsonlar, satislar).setVisible(true);
    }
}
