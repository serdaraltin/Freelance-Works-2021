package Controller;

import Interface.Interface_Bul;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Controller_Bul implements Interface_Bul {

    int lastIndex = 0;

    @Override
    public void bul(JTextArea txtMetin, String aranan, boolean tamEslesme, boolean yon) {
        int idx = sonrakiBul(txtMetin, aranan, tamEslesme, yon);

        if (idx != -1) {
            txtMetin.setSelectionStart(idx);
            txtMetin.setSelectionEnd(idx + aranan.length());
        } else {
            JOptionPane.showMessageDialog(null, "Bulunamadı");
        }
    }

    @Override
    public int sonrakiBul(JTextArea jta, String aranan, boolean tamEslesme, boolean yon) {
        String s1 = jta.getText();
        String s2 = aranan;

        lastIndex = jta.getCaretPosition();
        int baslangic = jta.getSelectionStart();
        int bitis = jta.getSelectionEnd();

        if (yon) {

            if (baslangic != bitis) {
                lastIndex = bitis - s2.length() - 1;
            }

            if (!tamEslesme) {
                lastIndex = s1.toUpperCase().lastIndexOf(s2.toUpperCase(), lastIndex);
            } else {
                lastIndex = s1.lastIndexOf(s2, lastIndex);
            }

        } else {

            if (baslangic != bitis) {
                lastIndex = baslangic + 1;
            }
            if (!tamEslesme) {
                lastIndex = s1.toUpperCase().indexOf(s2.toUpperCase(), lastIndex);
            } else {
                lastIndex = s1.indexOf(s2, lastIndex);
            }

        }

        return lastIndex;
    }

    @Override
    public void degistir(JTextArea txtMetin, String aranan, String degistirilecek, boolean tamEslesme, boolean yon) {
        if (txtMetin.getSelectionStart() == txtMetin.getSelectionEnd()) {
            bul(txtMetin, aranan, tamEslesme, yon);
            return;
        }

        String searchText = aranan;
        String temp = txtMetin.getSelectedText();

        if ((tamEslesme && temp.equals(searchText))
                || (!tamEslesme && temp.equalsIgnoreCase(searchText))) {
            txtMetin.replaceSelection(degistirilecek);
        }

        bul(txtMetin, aranan, tamEslesme, yon);
    }

    @Override
    public void tumunuDegistir(JTextArea txtMetin, String aranan, String degistirilecek, boolean tamEslesme, boolean yon) {
        if (yon) {
            txtMetin.setCaretPosition(txtMetin.getText().length() - 1);
        } else {
            txtMetin.setCaretPosition(0);
        }

        int idx = 0;
        int counter = 0;
        do {
            idx = sonrakiBul(txtMetin, aranan, tamEslesme, yon);
            if (idx == -1) {
                break;
            }
            counter++;
            txtMetin.replaceRange(degistirilecek, idx, idx + aranan.length());
        } while (idx != -1);
        if (counter > 0) {
            JOptionPane.showMessageDialog(null, counter + " adet değişim yapıldı.");
        }
        else{
            JOptionPane.showMessageDialog(null, "Değiştirilecek değer bulunamadı!");
        }

    }

}
