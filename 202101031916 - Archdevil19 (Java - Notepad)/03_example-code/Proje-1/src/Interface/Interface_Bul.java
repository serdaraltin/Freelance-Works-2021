package Interface;

import javax.swing.JTextArea;

public interface Interface_Bul {

    public void bul(JTextArea txtMetin, String aranan, boolean tamEslesme, boolean yon);

    public int sonrakiBul(JTextArea txtMetin, String aranan, boolean tamEslesme, boolean yon);

    public void degistir(JTextArea txtMetin, String aranan, String degistirilecek, boolean tamEslesme, boolean yon);

    public void tumunuDegistir(JTextArea txtMetin, String aranan, String degistirilecek, boolean tamEslesme, boolean yon);
}
