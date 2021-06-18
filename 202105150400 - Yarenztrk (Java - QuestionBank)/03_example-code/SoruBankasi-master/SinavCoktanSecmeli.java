import java.util.ArrayList;

public class SinavKarisik extends Sinav{

	private ArrayList<Soru> sorular = new ArrayList<Soru>();
	
	public SinavKarisik(ArrayList<Soru> tumSorular) {
		setSoruNumaralari(tumSorular.size());
		for(int i=0; i<soruSayisi; i++)
			sorular.add(tumSorular.get(soruNumaralari[i]));
		sinavYap();
		System.out.println("\nSinav bitti..! Sonuclariniz gosterilmeyecektir..!");
	}
	
	private void setSoruNumaralari(int tumSorularSize) {
		ArrayList<Integer> tempRandom = tekrarsizRandom.olustur(soruSayisi, tumSorularSize);
		super.setSoruNumaralari(tempRandom);
	}
	
	//yazdirirken soru cesidine gore farkli fonksiyonlar kullan
	private void sinavYap() {
		System.out.println("\nKarisik sinav"
				+ "\nBu sinavda soru bankasindan rastgele secilen"
				+ "\n5 adet soru bulunmaktadir."
				+ "\nSinav sonunda sinav sonucu gosterilmeyecektir..!");
		for (Soru soru : sorular) {
			switch (soru.getSoruCesidi()) {
				case 'a': soruMetniYazdir(soru);	cevapAl();	break;
				case 'b': soruMetniYazdir(soru);	cevapAl();	break;
				case 'c': soruMetniYazdir(soru);	secenekleriYazdir((SoruCoktanSecmeli)soru);	cevapAl();	break;
				case 'd': soruMetniYazdir(soru);	System.out.println("D - Y");	cevapAl();	break;
				default:	break;
			}
		}
	}

	private void soruMetniYazdir(Soru soru) {
		System.out.println("\n" + mevcutSoruNumarasi + ") " + soru.getSoruMetni());
	}

	private void secenekleriYazdir(SoruCoktanSecmeli soru) {
		String[] secenekler = {"","",""};
		int sayac = 0;
		for (int i=0; i<soru.getSecenekler().length(); i++) {
			if (soru.getSecenekler().charAt(i) == '$')	sayac++;
			else	secenekler[sayac] += soru.getSecenekler().charAt(i);
		}
		System.out.println("A) " + secenekler[0] + "\nB) " + secenekler[1] + "\nC) " + secenekler[2]);
	}
	
	private void cevapAl() {
		System.out.print("cevabiniz: ");
		cevapAlma();
		mevcutSoruNumarasi++;
	}

}

import java.util.ArrayList;
​
import javax.xml.transform.Source;
​
//@mehmet uysal, last update: 03/05/2020
​
public class SinavCoktanSecmeli extends Sinav{
    
    private int alinanPuan = 0, toplamPuan = 0, dogruSayaci = 1;
    private ArrayList<SoruCoktanSecmeli> sorular = new ArrayList<SoruCoktanSecmeli>();
​
    //methodlar
    
    public SinavCoktanSecmeli(ArrayList<SoruCoktanSecmeli> arr) {
        setSoruNumaralari(arr.size());
        for(int i=0; i<soruSayisi; i++)
            sorular.add(arr.get(soruNumaralari[i]));
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
        for (SoruCoktanSecmeli soru : sorular) {
            System.out.println("\n" + mevcutSoruNumarasi + ") " + soru.getSoruMetni());
            secenekleriYazdir(soru);
            System.out.print("cevabiniz(a,b,c): ");
            super.cevapAlma();
            cevapDogrumu(soru); //cevap dogruysa alinan puani artiriyor.
            mevcutSoruNumarasi++;
        }
    }
    
    private void secenekleriYazdir(SoruCoktanSecmeli soru) {
        String[] secenekler = {"","",""};   //new secenekeler[3] diye tanimlarsam += isleminde basinda null oluyor
        int sayac = 0;
        for (int i=0; i<soru.getSSoruCoktanSeçmelih(); i++) {
            if (soru.getSecenekler().charAt(i) == '$')  sayac++;
            else    secenekler[sayac] += soru.getSecenekler().charAt(i);
        }
        System.out.println("A) " + secenekler[0] + "\nB) " + secenekler[1] + "\nC) " + secenekler[2]);
    }
    
    private void cevapDogrumu(SoruCoktanSecmeli soru) {
        if (cevaplar[mevcutSoruNumarasi-1].equalsIgnoreCase(soru.getCevap())) {
            alinanPuan += soru.getPuan();   dogruSayaci++;
        }
        toplamPuan += soru.getPuan();
    }
    
    //phase: sonlandirma
    //sonuc yazdirma
    private void sonucYazdir() {
        alinanPuan = (int)(((float)alinanPuan / (float)toplamPuan) * 100);
        System.out.println("\nSinav Bitti..!\n" + soruSayisi + " sorudan " + dogruSayaci + " tanesine"
                        + " dogru cevap verdiniz.\nPuan: " + alinanPuan + "/" + toplamPuan);
    }
    
}
​
deasciifier.com 2020 - Eski site