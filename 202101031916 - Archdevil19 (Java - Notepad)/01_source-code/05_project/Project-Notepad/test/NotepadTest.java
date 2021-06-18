import Controller.Controller_Bul;
import Controller.Controller_Degistir;
import Controller.Controller_Dosya;
import Controller.Controller_Yazim;
import Model.Model_Bul;
import Model.Model_Degistir;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JTextArea;
import org.junit.Test;
import static org.junit.Assert.*;

public class NotepadTest {

    Controller_Bul controller_Bul = new Controller_Bul();
    Controller_Degistir controller_Degistir = new Controller_Degistir();
    Controller_Yazim controller_Yazim = new Controller_Yazim();
    Controller_Dosya controller_Dosya = new Controller_Dosya();

    @Test
    public void BulKontrol() {
        JTextArea metin = new JTextArea();
        metin.setText("ahmet mehmet veli");

        assertEquals(controller_Bul.Bul(new Model_Bul(metin, "mehmet")), true);
    }

    @Test
    public void YazimHataKontrol() {
        ArrayList<String> kelimeler = controller_Dosya.dosyaOkuListe(new File("words.txt"));
        JTextArea metin = new JTextArea();
        metin.setText("foxier\n"
                + "foxiset\n"
                + "foxiyl");
        metin.setCaretPosition(0);
        int hataAdet = controller_Yazim.hataKontrol(metin, kelimeler);
        System.out.println("Yazim hatasi >> " + hataAdet);
        assertEquals(hataAdet, 2);
    }

    @Test
    public void DegistirKontrol() {
        JTextArea metin = new JTextArea();
        metin.setText("ahmet mehmet veli");
        System.out.println("once  >> " + metin.getText());
        controller_Degistir.TumunuDegistir(new Model_Degistir(metin, "mehmet", "kerim"));
        System.out.println("sonra >> " + metin.getText());
        assertEquals(controller_Bul.Bul(new Model_Bul(metin, "kerim")), true);
    }

}
