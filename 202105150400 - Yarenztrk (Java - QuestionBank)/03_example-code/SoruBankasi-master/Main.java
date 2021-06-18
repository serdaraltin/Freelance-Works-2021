import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static SoruBankasi soruBankasi = new SoruBankasi();
	
	public static void main(String[] args) {

		Scanner girdi = new Scanner(System.in);
		boolean donguDevam = true;
		while(donguDevam) {
			System.out.print("\nSoru Bankasi v2.0"
					+ "\n1- Sorulara goz at,"
					+ "\n2- Sinav yap,"
					+ "\n3- Soru ekle - cikar,"
					+ "\n4- Programi sonlandir."
					+ "\nYapmak istediginiz islem: ");
			switch (islemAl("1-4 arasi sayi girin..!\t: ")) {
				case 1: sorularaGozAt();	break;
				case 2: soruBankasi.sinavYap();	break;
				case 3: soruBankasi.soruEkleCikarMenu(donguDevam);	break;
				case 4: 
					System.out.println("Program sonlandirildi..!");
					donguDevam = false;
					soruBankasi.dosyayaKaydet();
					break;
				default: 
					System.err.println("\nHatali giris yaptiniz..!");	
					donguDevam = true;
					break;
			}
		}

	}
	
	private static void sorularaGozAt() {
		System.out.print("\nSorular"
				+ "\n1- Arama yap,"
				+ "\n2- Listeleme yap,"
				+ "\n3- Ana menuye don."
				+ "\nYapmak istediginiz islem: ");
		switch (islemAl("1-3 arasi sayi girin..!\t:")) {
			case 1: soruBankasi.arama();	break;
			case 2: soruBankasi.listeleme();	break;
			default: break;
		}
	}
	
	private static int islemAl(String hataMetni) {
		Scanner girdi = new Scanner(System.in);
		while(!girdi.hasNextInt()) {
			System.err.print(hataMetni);
			girdi.next();
		}
		return girdi.nextInt();
	}
}