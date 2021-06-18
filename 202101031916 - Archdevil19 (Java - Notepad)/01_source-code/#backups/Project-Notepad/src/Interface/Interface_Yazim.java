package Interface;

import java.util.ArrayList;
import javax.swing.JTextArea;

public interface Interface_Yazim {

    public int hataKontrol(JTextArea txtMetin, ArrayList<String> kelimeler);

    public String sozlukAra(ArrayList<String> kelimeler, String aranan);

    public boolean iceriyorMu(String kelimeA, String kelimeB);

    public boolean harfAdet(String kelimeA, String kelimeB, char harf);

    public boolean hataDuzelt(JTextArea txtMetin, ArrayList<String> kelimeler);
}
