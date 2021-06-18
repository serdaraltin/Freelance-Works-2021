import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Sinav implements Serializable{

	protected final int soruSayisi = 5;	//sabit sinavdaki soru sayisini belirler.
	protected int mevcutSoruNumarasi = 1;	//donguler icerisinde kullanmak icin.
	protected String[] cevaplar = new String[5];	//aldigimiz cevaplar burada.
	protected int[] soruNumaralari = new int[5];	//butun sorular icerisinden secilen 5 sorunun indexleri burada.
	protected Rastgele tekrarsizRandom = new Rastgele();
	private Scanner girdi = new Scanner(System.in);
	
	//----------------------------------------
	protected void setSoruNumaralari(ArrayList<Integer> tempRandom) {
		for(int i=0; i<tempRandom.size(); i++)
			soruNumaralari[i] = tempRandom.get(i);
	}
	
	protected void cevapAlma() {
		String cevap = girdi.nextLine();
		cevaplar[mevcutSoruNumarasi-1] = cevap;
	}
		
}
