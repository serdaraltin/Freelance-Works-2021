
import java.util.ArrayList;

public class Hesaplama {

    private ArrayList<Kredi> krediler;
    private float ortalama;

    public Hesaplama(ArrayList<Kredi> krediler) {
        this.krediler = krediler;
    }

    public ArrayList<Kredi> getKrediler() {
        return krediler;
    }

    public void setKrediler(ArrayList<Kredi> krediler) {
        this.krediler = krediler;
    }

   
    public float getOrtalama() {
        float toplamKredi = 0;
        int krediAdet = 0;
        for (Kredi kredi : krediler) {
            toplamKredi += kredi.getKrediMiktar();
            krediAdet++;
        }
        this.ortalama = toplamKredi / (float)krediAdet;
        return ortalama;
    }

    public void setOrtalama(float ortalama) {
        this.ortalama = ortalama;
    }

}
