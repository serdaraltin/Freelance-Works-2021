
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner oku = new Scanner(System.in);
        System.out.println("> Lütfen 1. metni giriniz:");
        String metin1 = oku.nextLine();
        System.out.println("\n> Lütfen 2. metni giriniz:");
        String metin2 = oku.nextLine();
        System.out.println("\n> Lütfen 3. metni giriniz:");
        String metin3 = oku.nextLine();

        SozcukListe<String> metin1TK = new SozcukListe<>();
        metin1TK.tokenizeValues(metin1);

        SozcukListe<String> metin2TK = new SozcukListe<>();
        metin2TK.tokenizeValues(metin2);

        SozcukListe<String> metin3TK = new SozcukListe<>();
        metin3TK.tokenizeValues(metin3);
        
        System.out.println("-------------------------------");
        System.out.println("\nToplam girilen sözcük: " + (metin1TK.size() + metin2TK.size() + metin3TK.size()));
        Tablo<String> hashSet = new Tablo<>();
        
        hashSet.addPTokens(metin1TK.liste, metin2TK.liste, metin3TK.liste);
        System.out.println("\nFarklı sözcük adedi: " + hashSet.size());
        
        Frekans<String, Integer> frekans = new Frekans<>();
        frekans.frekans(metin1TK.liste, metin2TK.liste, metin3TK.liste, hashSet);

        frekans.Goster();
    }
}
