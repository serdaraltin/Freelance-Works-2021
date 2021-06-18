
import Controller.Controller_Dosya;
import Controller.Controller_Yazim;
import java.io.File;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;


public class SozcukTest {
    

    Controller_Yazim controller_Yazim = new Controller_Yazim();
    Controller_Dosya controller_Dosya = new Controller_Dosya();

    @Test
    public void AyniMi() {

        String doguSozcuk = "default";
        String testSozcuk = "deafult";
        ArrayList<String> kelimeler = controller_Dosya.dosyaOkuListe(new File("words.txt"));
        kelimeler.add(doguSozcuk);
        assertEquals(doguSozcuk, controller_Yazim.sozlukAra(kelimeler, testSozcuk));
    }
}
