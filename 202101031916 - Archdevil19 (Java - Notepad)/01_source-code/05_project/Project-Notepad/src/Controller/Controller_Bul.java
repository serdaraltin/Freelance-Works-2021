package Controller;

import Interface.Interface_Bul;
import Model.Model_Bul;
import javax.swing.JOptionPane;

public class Controller_Bul implements Interface_Bul<Model_Bul> {

    int lastIndex = 0;

    @Override
    public boolean Bul(Model_Bul veri) {
        int idx = SonrakiniBul(veri);

        if (idx != -1) {
            veri.getMetin().setSelectionStart(idx);
            veri.getMetin().setSelectionEnd(idx + veri.getAranan().length());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Bulunamadı");
            return false;
        }
    }

    @Override
    public int SonrakiniBul(Model_Bul veri) {
        String s1 = veri.getMetin().getText();
        String s2 = veri.getAranan();

        lastIndex = veri.getMetin().getCaretPosition();
        int baslangic = veri.getMetin().getSelectionStart();
        int bitis = veri.getMetin().getSelectionEnd();

        if (veri.isYukari()) {

            if (baslangic != bitis) {
                lastIndex = bitis - s2.length() - 1;
            }

            if (!veri.isTamEslesme()) {
                lastIndex = s1.toUpperCase().lastIndexOf(s2.toUpperCase(), lastIndex);
            } else {
                lastIndex = s1.lastIndexOf(s2, lastIndex);
            }

        } else {

            if (baslangic != bitis) {
                lastIndex = baslangic + 1;
            }
            if (!veri.isTamEslesme()) {
                lastIndex = s1.toUpperCase().indexOf(s2.toUpperCase(), lastIndex);
            } else {
                lastIndex = s1.indexOf(s2, lastIndex);
            }

        }

        return lastIndex;
    }

}
