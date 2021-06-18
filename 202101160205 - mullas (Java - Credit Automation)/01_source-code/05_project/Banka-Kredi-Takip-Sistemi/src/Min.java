
import java.util.ArrayList;

public class Min extends Hesaplama {

    public Min(ArrayList<Kredi> krediler) {
        super(krediler);
    }

    public Kredi getMin() {
        Kredi maxKredi = super.getKrediler().get(0);
        for (Kredi kredi : super.getKrediler()) {
            if (maxKredi.getKrediMiktar() > kredi.getKrediMiktar()) {
                maxKredi = kredi;
            }
        }
        return maxKredi;
    }

}
