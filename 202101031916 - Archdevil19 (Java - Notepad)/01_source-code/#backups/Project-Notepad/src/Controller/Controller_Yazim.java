package Controller;

import Interface.Interface_Yazim;
import Model.Model_Degistir;

import java.util.ArrayList;
import javax.swing.JTextArea;
import jdk.nashorn.internal.runtime.JSType;

public class Controller_Yazim implements Interface_Yazim {

    Controller_Degistir controller_Degistir = new Controller_Degistir();

    @Override
    public int hataKontrol(JTextArea txtMetin, ArrayList<String> kelimeler) {
        int hataAdet = 0;
        String metin = txtMetin.getText();
        String[] ayrilmis = metin.split("[\\,;. \n]");
        for (String kelime : ayrilmis) {
            String dogruSozcuk = sozlukAra(kelimeler, kelime);
            if (!kelime.equals(dogruSozcuk) && dogruSozcuk != null) {
                hataAdet++;
            }
        }
        return hataAdet;
    }

    @Override
    public String sozlukAra(ArrayList<String> kelimeler, String aranan) {
        if (JSType.isNumber(aranan)) {
            return aranan;
        }
        if (kelimeler.contains(aranan)) {
            return aranan;
        }
        int satir = 0;
        for (String kelime : kelimeler) {
            satir++;
            if (kelime.length() != aranan.length()) {
                continue;
            }

            if (iceriyorMu(aranan, kelime)) {
                System.out.printf("%4d > %s <--> %s\n", satir, aranan, kelime);
                return kelime;
            }

        }
        return null;
    }

    @Override
    public boolean iceriyorMu(String kelimeA, String kelimeB) {
        int fark = 0;

        char[] diziA = kelimeA.toCharArray();
        char[] diziB = kelimeB.toCharArray();

        for (int i = 0; i < diziA.length; i++) {
            if (!harfAdet(kelimeA, kelimeB, diziA[i])) {
                return false;
            }
            if (!kelimeA.contains(String.valueOf(diziB[i]))) {
                fark++;
                if (fark > 2) {
                    return false;
                }
            }
        }
        fark = 0;
        for (int i = 0; i < diziB.length; i++) {
            if (!harfAdet(kelimeA, kelimeB, diziB[i])) {
                return false;
            }
            if (!kelimeB.contains(String.valueOf(diziA[i]))) {
                fark++;
                if (fark > 2) {
                    return false;
                }
            }
        }
        fark = 0;
        for (int i = 0; i < diziB.length; i++) {
            if (diziA[i] != diziB[i]) {
                fark++;
                if (fark > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean harfAdet(String kelimeA, String kelimeB, char harf) {
        int adetA = 0, adetB = 0;
        char[] diziA = kelimeA.toCharArray();
        char[] diziB = kelimeB.toCharArray();
        for (int i = 0; i < diziA.length; i++) {
            if (diziA[i] == harf) {
                adetA++;
            }
        }
        for (int i = 0; i < diziB.length; i++) {
            if (diziB[i] == harf) {
                adetB++;
            }
        }
        if (adetA != adetB) {
            return false;
        }
        return true;
    }

    @Override
    public boolean hataDuzelt(JTextArea txtMetin, ArrayList<String> kelimeler) {
        String metin = txtMetin.getText();
        String[] ayrilmis = metin.split("[\\,;. \n]");
        for (String kelime : ayrilmis) {
            String dogruSozcuk = sozlukAra(kelimeler, kelime);
            if (!kelime.equals(dogruSozcuk) && dogruSozcuk != null) {
                txtMetin.setCaretPosition(0);
                controller_Degistir.TumunuDegistir(new Model_Degistir(txtMetin, kelime, dogruSozcuk, false, false));
            }
        }
        return true;
    }

}
