package Interface;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public interface Interface_Dosya {

    public File dosyaOlustur(File dosya, String metin, JFrame pencere);

    public File dosyaAc(File dosya, JTextArea txt, JFrame pencere);

    public File dosyaKapa(File dosya, JTextArea txt, JFrame pencere);

    public File dosyaKaydet(File dosya, String metin, JFrame pencere);

    public File dosyaYaz(File dosya, String metin);

    public String dosyaOku(File dosya);

    public ArrayList<String> dosyaOkuListe(File dosya);
}
