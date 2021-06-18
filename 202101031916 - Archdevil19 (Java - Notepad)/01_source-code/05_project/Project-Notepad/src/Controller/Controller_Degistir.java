package Controller;

import Interface.Interface_Degistir;
import Model.Model_Bul;
import Model.Model_Degistir;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Controller_Degistir implements Interface_Degistir<Model_Degistir> {

    Controller_Bul controller_Bul = new Controller_Bul();

    @Override
    public void Degistir(Model_Degistir veri) {

        if (veri.getMetin().getSelectionStart() == veri.getMetin().getSelectionEnd()) {
            controller_Bul.Bul(new Model_Bul(veri.getMetin(), veri.getEskiDeger(), veri.isTamEslesme(), veri.isYukari()));
            return;
        }

        String searchText = veri.getEskiDeger();
        String temp = veri.getMetin().getSelectedText();

        if ((veri.isTamEslesme() && temp.equals(searchText))
                || (!veri.isTamEslesme() && temp.equalsIgnoreCase(searchText))) {
            veri.getMetin().replaceSelection(veri.getYeniDeger());
        }

        controller_Bul.Bul(new Model_Bul(veri.getMetin(), veri.getEskiDeger(), veri.isTamEslesme(), veri.isYukari()));
    }

    @Override
    public void TumunuDegistir(Model_Degistir veri) {
        if (veri.isYukari()) {
            veri.getMetin().setCaretPosition(veri.getMetin().getText().length() - 1);
        } else {
            veri.getMetin().setCaretPosition(0);
        }

        int idx = 0;
        int adet = 0;
        do {
            idx = controller_Bul.SonrakiniBul(new Model_Bul(veri.getMetin(), veri.getEskiDeger(), veri.isTamEslesme(), veri.isYukari()));
            if (idx == -1) {
                break;
            }
            adet++;
            veri.getMetin().replaceRange(veri.getYeniDeger(), idx, idx + veri.getEskiDeger().length());
        } while (idx != -1);
        if (adet > 0) {
            JOptionPane.showMessageDialog(null, veri.getEskiDeger()+" > "+veri.getYeniDeger()+" "+adet + " adet değişim yapıldı.");
        } else {
            JOptionPane.showMessageDialog(null, "Değiştirilecek değer bulunamadı!");
        }

    }
}
