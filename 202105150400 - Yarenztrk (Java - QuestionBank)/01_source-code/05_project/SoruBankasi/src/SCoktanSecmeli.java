
import java.util.ArrayList;

public class SCoktanSecmeli extends Sinav {

    private int alinanPuan = 0, toplamPuan = 0, dogruSayaci = 1;
    private ArrayList<CoktanSecmeliSoru> sorular = new ArrayList<>();
    //methodlar

    public SCoktanSecmeli(ArrayList<CoktanSecmeliSoru> arr) {
        setSoruNumaralari(arr.size());
        for (int i = 0; i < soruSayisi; i++) {
            sorular.add(arr.get(soruNumaralari[i]));
        }
        sinavYap();
        sonucYazdir();
    }

    //phase: hazirlanma
    private void setSoruNumaralari(int soruListesiSize) {
        ArrayList<Integer> tempRandom = tekrarsizRandom.olustur(soruSayisi, soruListesiSize);
        super.setSoruNumaralari(tempRandom);
    }

    //phase: uygulama
    private void sinavYap() {
        System.out.println("\nCoktan Secmeli sinav"
                + "\nBu sinavda soru bankasindan rastgele secilen"
                + "\n5 adet coktan secmeli soru bulunmaktadir.");
        for (CoktanSecmeliSoru soru : sorular) {
            System.out.println("\n" + mevcutSoruNumarasi + ") " + soru.getSoruMetni());
            secenekleriYazdir(soru);
            System.out.print("cevabiniz(a,b,c): ");
            super.cevapAlma();
            cevapDogrumu(soru); //cevap dogruysa alinan puani artiriyor.
            mevcutSoruNumarasi++;
        }
    }

    private void secenekleriYazdir(CoktanSecmeliSoru soru) {
        String[] secenekler = {"", "", ""};   //new secenekeler[3] diye tanimlarsam += isleminde basinda null oluyor
        int sayac = 0;
        for (int i = 0; i < soru.getSecenekler().length(); i++) {
            if (soru.getSecenekler().charAt(i) == '$') {
                sayac++;
            } else {
                secenekler[sayac] += soru.getSecenekler().charAt(i);
            }
        }
        System.out.println("A) " + secenekler[0] + "\nB) " + secenekler[1] + "\nC) " + secenekler[2]);
    }

    private void cevapDogrumu(CoktanSecmeliSoru soru) {
        if (cevaplar[mevcutSoruNumarasi - 1].equalsIgnoreCase(soru.getCevap())) {
            alinanPuan += soru.getPuan();
            dogruSayaci++;
        }
        toplamPuan += soru.getPuan();
    }

    //phase: sonlandirma
    //sonuc yazdirma
    private void sonucYazdir() {
        alinanPuan = (int) (((float) alinanPuan / (float) toplamPuan) * 100);
        System.out.println("\nSinav Bitti..!\n" + soruSayisi + " sorudan " + dogruSayaci + " tanesine"
                + " dogru cevap verdiniz.\nPuan: " + alinanPuan + "/" + toplamPuan);
    }

}
