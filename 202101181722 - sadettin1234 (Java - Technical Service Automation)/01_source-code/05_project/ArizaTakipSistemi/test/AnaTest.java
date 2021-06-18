
import Model.Ariza;
import Model.Musteri;
import Model.Tekniker;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AnaTest {

    public AnaTest() {
    }

    @Test
    public void Musteri() {
        Model.Musteri[] musteriler = new Musteri[10];
        new Controller.ControllerMusteri().Ekle(musteriler, 0, new Musteri("12345678910", "Ahmet", "Bal", "05428973214", "denemeAdres"));
        System.out.println(musteriler[0]);
        assertEquals(musteriler[0].getTcno(), "12345678910");
    }

    @Test
    public void Tekniker() {
        Model.Tekniker[] teknikerler = new Tekniker[10];
        new Controller.ControllerTekniker().Ekle(teknikerler, 0, new Tekniker("12345678921", "Ahmet", "Bal"));
        System.out.println(teknikerler[0]);
        assertEquals(teknikerler[0].getTcno(), "12345678921");
    }

    @Test
    public void Ariza() {
        Model.Ariza[] arizalar = new Ariza[10];
        new Controller.ControllerAriza().Ekle(arizalar, 0, new Ariza(new Musteri("12345678910", "Ahmet", "Bal", "05428973214", "denemeAdres"), "sigorta arizasi",120,  "18.01.2021"));
        System.out.println(arizalar[0]);
        assertEquals(arizalar[0].getTur(), "sigorta arizasi");
    }
}
