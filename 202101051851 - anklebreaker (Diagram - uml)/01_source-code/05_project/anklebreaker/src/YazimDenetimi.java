import java.util.ArrayList;
import javax.swing.JTextArea;

public class YazimDenetimi {

    BulDegistir cBul = new BulDegistir();

    public int hatalariDenetle(JTextArea metin_kutusu, ArrayList<String> sozcuk_listesi) {
        int hataAdet = 0;
        String metin = metin_kutusu.getText();
        String[] ayrilmis = metin.split("[\\,;. \n]");
        for (String kelime : ayrilmis) {
            String dogurSozcuk = suzlukteAra(sozcuk_listesi, kelime);
            if (!kelime.equals(dogurSozcuk) && dogurSozcuk != null) {
                hataAdet++;
            }
        }
        return hataAdet;
    }

    public String suzlukteAra(ArrayList<String> sozcuk_listesi, String aranan_deger) {

        if (sozcuk_listesi.contains(aranan_deger)) {
            return aranan_deger;
        }
        for (String kelime : sozcuk_listesi) {
            if (kelime.length() != aranan_deger.length()) {
                continue;
            }
            if (varmi(aranan_deger, kelime)) {
                return kelime;
            }
        }
        return null;
    }

    public boolean varmi(String kelimeA, String kelimeB) {
        int fark = 0;

        char[] diziA = kelimeA.toCharArray();
        char[] diziB = kelimeB.toCharArray();

        for (int i = 0; i < diziA.length; i++) {
            if (!harfMiktari(kelimeA, kelimeB, diziA[i])) {
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
            if (!harfMiktari(kelimeA, kelimeB, diziB[i])) {
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

    public boolean harfMiktari(String kelimeA, String kelimeB, char harf) {
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

    public int hatalariDuzelt(JTextArea metin_kutusu, ArrayList<String> sozcuk_listesi) {
        int hataAdet = 0;
        String metin = metin_kutusu.getText();
        String[] ayrilmis = metin.split("[\\,;. \n]");
        for (String kelime : ayrilmis) {
            String dogurSozcuk = suzlukteAra(sozcuk_listesi, kelime);
            if (!kelime.equals(dogurSozcuk) && dogurSozcuk != null) {
                hataAdet++;
                metin_kutusu.setCaretPosition(0);
                cBul.tumunuDegistir(metin_kutusu, kelime, dogurSozcuk, false, false);
            }
        }
        return hataAdet;
    }

}
