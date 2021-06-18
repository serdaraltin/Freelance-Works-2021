
import java.util.ArrayList;
import java.util.HashSet;

public class Tablo<String> extends HashSet<String> {

    public void addPTokens(ArrayList<java.lang.String> metinListesi1, ArrayList<java.lang.String> metinListesi2, ArrayList<java.lang.String> a3) {
        metinListesi1.forEach((token) -> {
            this.add((String) token);
        });
        metinListesi2.forEach((token) -> {
            this.add((String) token);
        });
        a3.forEach((token) -> {
            this.add((String) token);
        });
    }
}
