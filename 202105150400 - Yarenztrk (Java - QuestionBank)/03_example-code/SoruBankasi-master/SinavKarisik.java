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
