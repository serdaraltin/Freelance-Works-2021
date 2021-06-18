
import java.util.ArrayList;

public class Maks extends Hesaplama {

    public Maks(ArrayList<Kredi> krediler) {
        super(krediler);
    }

    public Kredi getMax() {
        Kredi maxKredi = super.getKrediler().get(0);
        for (Kredi kredi : super.getKrediler()) {
            if (maxKredi.getKrediMiktar() < kredi.getKrediMiktar()) {
                maxKredi = kredi;
            }
        }
        return maxKredi;
    }
}
