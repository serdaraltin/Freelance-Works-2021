
import Controller.Controller_Film;
import Controller.Controller_Kullanici;
import Model.Model_Film;
import Model.Model_Kullanici;
import java.util.ArrayList;
import javax.swing.JTable;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test_Veritabani {

    @Test
    public void KullaniciKontrol() {
        Model_Kullanici kullanici = new Model_Kullanici(0, "admin", "1234");
        Controller_Kullanici controller_Kullanici = new Controller_Kullanici();
        assertEquals(controller_Kullanici.Kontrol(kullanici), true);
    }

    @Test
    public void KullaniciGetir() {
        Model_Kullanici kullanici = new Model_Kullanici(0, "admin", "1234");
        Controller_Kullanici controller_Kullanici = new Controller_Kullanici();
        assertNotEquals(controller_Kullanici.Getir(kullanici).getId(), 0);
        System.out.println("Kullanici Getir >>\n\t" + controller_Kullanici.Getir(kullanici).toString());
    }

    @Test
    public void FilmKontrol() {
        Model_Film film = new Model_Film(0, "Akira", "", "", 0);
        Controller_Film controller_Film = new Controller_Film();
        assertEquals(controller_Film.Kontrol(film), true);
    }

    @Test
    public void FilmGetir() {
        Model_Film film = new Model_Film(0, "Akira", "", "", 0);
        Controller_Film controller_Film = new Controller_Film();
        assertEquals(controller_Film.Getir(film).getYil(), 1985);
        System.out.println("Film Getir >>\n\t" + controller_Film.Getir(film).toString());
    }

    @Test
    public void FilmEkle() {
        Model_Film film = new Model_Film(0, "Ekle", "Ekle", "Ekle", 2020);
        Controller_Film controller_Film = new Controller_Film();
        assertEquals(controller_Film.Ekle(film), true);
        System.out.println("Film Ekle>>\n\t" + controller_Film.Getir(film).toString());
    }

    @Test
    public void FilmGuncelle() {
        Model_Film film = new Model_Film(0, "Guncelle", "Guncelle", "Guncelle", 2020);
        Controller_Film controller_Film = new Controller_Film();
        film.setId(controller_Film.Getir(new Model_Film(0, "Ekle", "", "", 0)).getId());
        assertEquals(controller_Film.Guncelle(film), true);
        System.out.println("Film Guncelle>>\n\t" + controller_Film.Getir(film).toString());
    }

    @Test
    public void FilmSil() {
        Model_Film film = new Model_Film();
        Controller_Film controller_Film = new Controller_Film();
        film.setId(controller_Film.Getir(new Model_Film(0, "Guncelle", "", "", 0)).getId());
        System.out.println("Film Sil>>\n\t" + controller_Film.Getir(film).toString());
        assertEquals(controller_Film.Sil(film), true);

    }

    @Test
    public void FilmListele() {
        ArrayList<Model_Film> kayitlar = new Controller_Film().Listele(new JTable());
        System.out.println("Film Listele >>");
        for (Model_Film kayit : kayitlar) {
            System.out.println("\t" + kayit.toString());
        }
        assertNotEquals(kayitlar.size(), 0);
    }

}
