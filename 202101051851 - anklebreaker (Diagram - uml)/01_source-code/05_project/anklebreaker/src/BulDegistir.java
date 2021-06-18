
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class BulDegistir {

    int sonIndex = 0;

    public boolean degeriBul(JTextArea metin_kutusu, String aranan_deger, boolean buyuk_kucuk, boolean yukari_yon) {
        int idx = sonrakiDegeriBul(metin_kutusu, aranan_deger, buyuk_kucuk, yukari_yon);

        if (idx != -1) {
            metin_kutusu.setSelectionStart(idx);
            metin_kutusu.setSelectionEnd(idx + aranan_deger.length());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Bulunamadı !!");
            return false;
        }
    }

    public int sonrakiDegeriBul(JTextArea text_area, String aranan_deger, boolean buyuk_kucuk, boolean yukari_yon) {
        String string1 = text_area.getText();
        String string2 = aranan_deger;

        sonIndex = text_area.getCaretPosition();
        int bas = text_area.getSelectionStart();
        int bit = text_area.getSelectionEnd();

        if (yukari_yon) {

            if (bas != bit) {
                sonIndex = bit - string2.length() - 1;
            }

            if (!buyuk_kucuk) {
                sonIndex = string1.toUpperCase().lastIndexOf(string2.toUpperCase(), sonIndex);
            } else {
                sonIndex = string1.lastIndexOf(string2, sonIndex);
            }

        } else {

            if (bas != bit) {
                sonIndex = bas + 1;
            }
            if (!buyuk_kucuk) {
                sonIndex = string1.toUpperCase().indexOf(string2.toUpperCase(), sonIndex);
            } else {
                sonIndex = string1.indexOf(string2, sonIndex);
            }

        }

        return sonIndex;
    }

    public boolean degeriDegistir(JTextArea metin_kutusu, String aranan_deger, String yeni_deger, boolean buyuk_kucuk, boolean yukari_yon) {
        if (metin_kutusu.getSelectionStart() == metin_kutusu.getSelectionEnd()) {
            degeriBul(metin_kutusu, aranan_deger, buyuk_kucuk, yukari_yon);
        }

        String searchText = aranan_deger;
        String temp = metin_kutusu.getSelectedText();

        if ((buyuk_kucuk && temp.equals(searchText))
                || (!buyuk_kucuk && temp.equalsIgnoreCase(searchText))) {
            metin_kutusu.replaceSelection(yeni_deger);
            return true;
        }

        degeriBul(metin_kutusu, aranan_deger, buyuk_kucuk, yukari_yon);
        return false;
    }

    public void tumunuDegistir(JTextArea metin_kutusu, String aranan_deger, String yeni_deger, boolean buyuk_kucuk, boolean yukari_yon) {
        if (yukari_yon) {
            metin_kutusu.setCaretPosition(metin_kutusu.getText().length() - 1);
        } else {
            metin_kutusu.setCaretPosition(0);
        }

        int idx = 0;
        int adet = 0;
        do {
            idx = sonrakiDegeriBul(metin_kutusu, aranan_deger, buyuk_kucuk, yukari_yon);
            if (idx == -1) {
                break;
            }
            adet++;
            metin_kutusu.replaceRange(yeni_deger, idx, idx + aranan_deger.length());
        } while (idx != -1);
        if (adet > 0) {
            JOptionPane.showMessageDialog(null, adet + " adet değişim yapıldı.");
        } else {
            JOptionPane.showMessageDialog(null, "Değiştirilecek değer bulunamadı!");
        }

    }

}
