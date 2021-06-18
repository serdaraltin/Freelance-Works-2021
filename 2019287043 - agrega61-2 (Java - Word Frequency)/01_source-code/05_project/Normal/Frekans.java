
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class Frekans<String, Values> extends Hashtable<String, Integer> {

    public void Goster() {
        System.out.println("\nSözcük frekansları:");
        int EnSikSozcukFrekans = 0;
        String EnSikKullanilanSozcuk;
        EnSikKullanilanSozcuk = (String) "";

        for (String parca : keySet()) {

            System.out.printf(" %8s : %s\n", parca, get(parca));

            if (get(parca) > EnSikSozcukFrekans) {
                EnSikSozcukFrekans = get(parca);
                EnSikKullanilanSozcuk = parca;
            }
        }

        System.out.println("\nEn sık kullanılan sözcük: \"" + EnSikKullanilanSozcuk + "\".");
        System.out.println("En sık kullanılan sözcüğün frekansı: " + EnSikSozcukFrekans);
        System.out.println("-------------------------------");
    }

    public void frekans(ArrayList<String> metinListesi1, ArrayList<String> metinListesi2, ArrayList<String> metinListesi3, Tablo<String> hashTablosu) {
        Integer adet;
        for (String parca : hashTablosu) {
            adet = (Collections.frequency(metinListesi1, parca)
                    + Collections.frequency(metinListesi2, parca)
                    + Collections.frequency(metinListesi3, parca));
            put(parca, adet);
        }
    }

}
