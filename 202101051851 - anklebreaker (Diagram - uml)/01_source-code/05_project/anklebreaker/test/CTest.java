
import java.util.ArrayList;
import javax.swing.JTextArea;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CTest {

    public CTest() {
    }

    @Test
    public void DegerBulma() {
        System.out.println("\n\nTest > Değer Bulma\n");
        BulDegistir bulDegistir = new BulDegistir();
        JTextArea metin = new JTextArea();
        String aranan = "okula";
        metin.setText("ben bugün okula başladım");
        System.out.println("Metin  : " + metin.getText() + "\nAranan : " + aranan);
        assertEquals(bulDegistir.degeriBul(metin, aranan, false, false), true);
    }

    @Test
    public void DegerDegistirme() {
        System.out.println("\n\nTest > Değer Değiştirme\n");
        BulDegistir bulDegistir = new BulDegistir();
        JTextArea metin = new JTextArea();
        String aranan = "okula";
        String degistirim = "koleje";
        metin.setText("ben bugün okula başladım");
        System.out.println("Metin  : " + metin.getText() + "\nAranan : " + aranan);

        assertEquals(bulDegistir.degeriDegistir(metin, aranan, degistirim, false, false), true);
        System.out.println("Degistirim : " + degistirim + "\nMetin  : " + metin.getText());

    }

    @Test
    public void YazimHataKontrol() {
        System.out.println("\n\nTest > Yazım Hataları\n");
        ArrayList<String> kelimeler = new ArrayList<>();
        kelimeler.add("denemek");
        kelimeler.add("sevmek");
        kelimeler.add("kimseyi");
        System.out.println("Kelime Listesi >>");
        for (String string : kelimeler) {
            System.out.println(string);
        }
        System.out.println("--------------------");
        JTextArea metin = new JTextArea();
        metin.setText("deenmek\n"
                + "sevemk\n"
                + "kimseyi");
        System.out.println("Metin >> \n" + metin.getText()+"\n-------------------");
        metin.setCaretPosition(0);
        int hataAdet = new YazimDenetimi().hatalariDenetle(metin, kelimeler);
        System.out.println("Yazim hatasi : " + hataAdet + " adet");
        assertEquals(hataAdet, 2);
    }

}
