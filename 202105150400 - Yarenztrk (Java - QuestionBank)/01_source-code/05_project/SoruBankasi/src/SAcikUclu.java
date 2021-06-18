import java.util.ArrayList;
public class SAcikUclu extends Sinav{

	private ArrayList<AcikUcluSoru> sorular = new ArrayList<AcikUcluSoru>();
	
	//phase: hazirlanma
	public SAcikUclu(ArrayList<AcikUcluSoru> arr) {	//acik uclu sorulari(arr) soru bankasindan aliyoruz.
		setSoruNumaralari(arr.size());
		for(int i=0; i<soruSayisi; i++)	
			sorular.add(arr.get(soruNumaralari[i]));
		sinavYap();
		System.out.println("\nSinav bitti..! Sonuclariniz gosterilmeyecektir..!");
	}
		
	private void setSoruNumaralari(int soruListesiSize) {
		ArrayList<Integer> tempRandom = tekrarsizRandom.olustur(soruSayisi, soruListesiSize);
		super.setSoruNumaralari(tempRandom);
	}
	
	//phase: execution
	private void sinavYap() {
		System.out.println("\nAcik uclu sinav"
				+ "\nBu sinavda soru bankasindan rastgele secilen"
				+ "\n5 adet acik uclu soru bulunmaktadir."
				+ "\nSinav sonunda sinav sonucu gosterilmeyecektir..!");
		for (AcikUcluSoru soru : sorular) {
			System.out.println("\n" + mevcutSoruNumarasi + ") " + soru.getSoruMetni());
			System.out.print("cevabiniz: ");
			cevapAlma();
			mevcutSoruNumarasi++;
		}
	}
	
}
