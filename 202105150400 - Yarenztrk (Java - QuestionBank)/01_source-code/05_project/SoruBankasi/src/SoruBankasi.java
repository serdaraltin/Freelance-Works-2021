import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SoruBankasi {	//sorular, 'sorular.txt' dosyasindan okunuyor/yaziliyor..!

	private DosyaIslemleri io;
	private Sinav sinav;
	private Ara arayici;
	private Liste listeci = new Liste();
	private ArrayList<Sinav> arrSinavlar = new ArrayList<Sinav>();
	private ArrayList<AcikUcluSoru> arrSoruAcikUclu = new ArrayList<AcikUcluSoru>();
	private ArrayList<BoslukDoldurmaSoru> arrSoruBoslukDoldurma = new ArrayList<BoslukDoldurmaSoru>();
	private ArrayList<CoktanSecmeliSoru> arrSoruCoktanSecmeli = new ArrayList<CoktanSecmeliSoru>();
	private ArrayList<DogruYanlisSoru> arrSoruDogruYanlis = new ArrayList<DogruYanlisSoru>();
	
	//constructor calistiginda 'sorular.txt' dosyasini okuyup sorulari arraylistlere atip kullanilabilir hale getiriyor.
	public SoruBankasi() {
		io = new DosyaIslemleri(arrSoruAcikUclu, arrSoruBoslukDoldurma, arrSoruCoktanSecmeli, arrSoruDogruYanlis);
		arayici = new Ara();
	}

	//soru ekleme methodlari
	
	//sorular
	public void soruEkleCikarMenu(boolean donguDevam) {
		Scanner girdi = new Scanner(System.in);
		System.out.print("\n1- Soru ekle,"
				+ "\n2- Soru cikar,"
				+ "\n3- Ana menuye don."
				+ "\nYapmak istediginiz islem: ");
		int islem = islemAlInt("1-3 arasi sayi girin..!\t: ");
		switch (islem) {
			case 1: soruEkle();	break;
			case 2: soruCikar();	break;
			case 3: donguDevam = false;	break;
			default: System.out.println("\nHatali giris yaptiniz..!"); donguDevam = true;	break;
		}
	}
	
	//soru ekleme bolumu
	public void soruEkle() {
		System.out.println("\nSoru Ekleme;");
		switch (eklenecekSoruCinsi()) {
			case 1: acikUcluSoruEkle();	break;
			case 2: boslukDoldurmaliSoruEkle();	break;
			case 3:	coktanSecmeliSoruEkle();	break;
			case 4: dogruYanlisSoruEkle();	break;
			default:	break;
		}
	}
	
	private int eklenecekSoruCinsi() {
		Scanner girdi = new Scanner(System.in);
		System.out.print("\n1- Acik uclu soru ekle"
				+ "\n2- Bosluk doldurmali soru ekle"
				+ "\n3- Coktan secmeli soru ekle"
				+ "\n4- Dogru yanlis sorusu ekle"
				+ "\nEklemek istediginiz soru bicimi: ");
		return islemAlInt("1-4 arasi sayi girin..!\t: ");
	}
	
	private void acikUcluSoruEkle() {
		Scanner girdi = new Scanner(System.in);
		System.out.print("\nSoru metni: ");
		String soruMetni = girdi.nextLine();
		int zorluk;
		while(true) {
			System.out.print("Zorluk(1,2,3): ");
			zorluk = islemAlInt("1-3 arasi sayi girin..!\t: ");
			if (0 <= zorluk && zorluk <= 3)	break;
			else	System.out.println("zorluk 1 2 yada 3 olmali..!");
		}
		this.arrSoruAcikUclu.add(new AcikUcluSoru(soruMetni, zorluk));
	}
	
	private void boslukDoldurmaliSoruEkle() {
		Scanner girdi = new Scanner(System.in);
		System.out.print("\nSoru metni: ");
		String soruMetni = girdi.nextLine();
		System.out.print("Cevap: ");
		String cevap = girdi.nextLine();
		int zorluk;
		while(true) {
			System.out.print("Zorluk(1,2,3): ");
			zorluk = islemAlInt("1-3 arasi sayi girin..!\t: ");
			if (0 <= zorluk && zorluk <= 3)	break;
			else	System.out.println("zorluk 1 2 yada 3 olmali..!");
		}
		this.arrSoruBoslukDoldurma.add(new BoslukDoldurmaSoru(soruMetni, zorluk, cevap));
	}
			
	private void coktanSecmeliSoruEkle() {
		Scanner girdi = new Scanner(System.in);
		System.out.print("\nSoru metni: ");
		String soruMetni = girdi.nextLine();
		
		System.out.print("\nSecenek A) ");
		String secenekA = girdi.nextLine();
		System.out.print("Secenek B) ");
		String secenekB = girdi.nextLine();
		System.out.print("Secenek C) ");
		String secenekC = girdi.nextLine();
		String secenekler = secenekA + "$" + secenekB + "$" + secenekC;	//$ ayracimiz.
		
		System.out.print("\nCevap(a,b,c): ");
		String cevap = girdi.nextLine();
		
		int zorluk;
		while(true) {
			System.out.print("\nZorluk(1,2,3): ");
			zorluk = islemAlInt("1-3 arasi sayi girin..!\t: ");
			if (0 <= zorluk && zorluk <= 3)	break;
			else	System.out.println("zorluk 1 2 yada 3 olmali..!");
		}
		
		this.arrSoruCoktanSecmeli.add(new CoktanSecmeliSoru(soruMetni, zorluk, secenekler, cevap));
	}
		
	private void dogruYanlisSoruEkle() {
		Scanner girdi = new Scanner(System.in);
		System.out.print("\nSoru metni: ");
		String soruMetni = girdi.nextLine();
		System.out.print("Cevap(D/Y): ");
		String cevap = girdi.nextLine();
		int zorluk;
		while(true) {
			System.out.print("Zorluk(1,2,3): ");
			zorluk = islemAlInt("1-3 arasi sayi girin..!\t: ");
			if (0 <= zorluk && zorluk <= 3)	break;
			else	System.err.println("zorluk 1 2 yada 3 olmali..!");
		}
		this.arrSoruDogruYanlis.add(new DogruYanlisSoru(soruMetni, zorluk, cevap));
	}
	
	//soru cikarma bolumu
	
	//soru cikarma
	public void soruCikar() {
		Scanner girdi = new Scanner(System.in);
		int size = tekArraydeBirlestirSorular().size();
		System.out.println("\nbutun sorular listelenmistir;");
		listeci.listele(tekArraydeBirlestirSorular());
		System.out.print("\nSilmek istediginiz sorunun numarasi: ");
		int soruNumarasi = islemAlInt("1-" + size + " arasinda olmali..!\t: ");
		if (1 <= soruNumarasi && soruNumarasi <= size)	{
			Soru tempSoru = tekArraydeBirlestirSorular().get(soruNumarasi-1);
			switch (tempSoru.getSoruCesidi()) {
				case 'a': 
					for (int i=0; i<arrSoruAcikUclu.size(); i++)
						if (arrSoruAcikUclu.get(i).getSoruMetni().equals(tempSoru.getSoruMetni()))
							arrSoruAcikUclu.remove(i);
					break;
				case 'b': 
					for (int i=0; i<arrSoruBoslukDoldurma.size(); i++)
						if (arrSoruBoslukDoldurma.get(i).getSoruMetni().equals(tempSoru.getSoruMetni()))
							arrSoruBoslukDoldurma.remove(i);
					break;
				case 'c': 
					for (int i=0; i<arrSoruCoktanSecmeli.size(); i++)
						if (arrSoruCoktanSecmeli.get(i).getSoruMetni().equals(tempSoru.getSoruMetni()))
							arrSoruCoktanSecmeli.remove(i);
					break;
				case 'd':
					for (int i=0; i<arrSoruDogruYanlis.size(); i++)
						if (arrSoruDogruYanlis.get(i).getSoruMetni().equals(tempSoru.getSoruMetni()))
							arrSoruDogruYanlis.remove(i);
					break;
				default:	break;
			}
			System.err.println("\n" + soruNumarasi + ". soru, soru bankasindan cikarildi..!");
		}
		else
			System.err.println("\n" + soruNumarasi + ". soru yok..!");
	}

	//sinav yap
	public void sinavYap() {
		Scanner girdi = new Scanner(System.in);
		System.out.print("\n1- Acik uclu sinav,"
				+ "\n2- Coktan secmeli sinav,"
				+ "\n3- Karisik sinav,"
				+ "\n4- Ana menuye don."
				+ "\nyapmak istediginiz sinav: ");
		int islem = islemAlInt("1-3 arasi sayi girin..!\n : ");
		switch (islem) {
			case 1: sinav = new SAcikUclu(arrSoruAcikUclu);	break;
			case 2:	sinav = new SCoktanSecmeli(arrSoruCoktanSecmeli);	break;
			case 3: sinav = new SKarisik(tekArraydeBirlestirSorular());	break;
			default: break;
		}
		arrSinavlar.add(sinav);
	}
	
	//listeleme bolumu
	public void listeleme() {
		Scanner girdi = new Scanner(System.in);
		System.out.print("\nListeleme Islemleri;"
				+ "\n1- Butun sorulari listele,"
				+ "\n2- Acik uclu sorulari listele,"
				+ "\n3- Bosluk doldurmali sorulari listele,"
				+ "\n4- Coktan secmeli sorulari listele,"
				+ "\n5- Dogru yanlis sorulari listele,"
				+ "\n6- Zorluga gore listele,"
				+ "\n7- Puana gore listele,"
				+ "\n8- Ana menuye don."
				+ "\nYapmak istediginiz islem: ");
		int islem = islemAlInt("1-7 arasi sayi girin..!\t: ");
		System.out.println();
		switch (islem) {
			case 1: listeci.listele(tekArraydeBirlestirSorular());	break;
			case 2: listeci.listele(soruFromAU(arrSoruAcikUclu));	break;
			case 3: listeci.listele(soruFromBD(arrSoruBoslukDoldurma));	break;
			case 4: listeci.listele(soruFromCS(arrSoruCoktanSecmeli));	break;
			case 5: listeci.listele(soruFromDY(arrSoruDogruYanlis));	break;
			case 6: listeci.listele(arayici.zorlukArama(tekArraydeBirlestirSorular(), listeleZorluk()));	break;
			case 7: listeci.listele(arayici.puanArama(tekArraydeBirlestirSorular(), listelePuan()));	break;
			default:	break;
		}
	}
	
	
	private String listeleZorluk() {
		Scanner girdi = new Scanner(System.in);
		System.out.print("Listelemek istediginiz zorluk(kolay,normal,zor): ");
		return girdi.next();
	}
	
	
	private int listelePuan() {
		Scanner girdi = new Scanner(System.in);
		System.out.print("Listelemek istediginiz paun(10,20,40): ");
		return islemAlInt("10,20,40 sayilarindan birini girin..!\t: ");
	}
	
	//listeleme - belirtilen soru turunu soru ya ceviriyor.
	private ArrayList<Soru> soruFromAU(ArrayList<AcikUcluSoru> arr) {
		ArrayList<Soru> tempArr = new ArrayList<Soru>();
		for (AcikUcluSoru soru : arr)	tempArr.add((Soru)soru);	return tempArr;
	}	
	
	
	private ArrayList<Soru> soruFromBD(ArrayList<BoslukDoldurmaSoru> arr) {
		ArrayList<Soru> tempArr = new ArrayList<Soru>();
		for (BoslukDoldurmaSoru soru : arr)	tempArr.add((Soru)soru);	return tempArr;
	}
	
	
	private ArrayList<Soru> soruFromCS(ArrayList<CoktanSecmeliSoru> arr) {
		ArrayList<Soru> tempArr = new ArrayList<Soru>();
		for (CoktanSecmeliSoru soru : arr)	tempArr.add((Soru)soru);	return tempArr;
	}
	
	
	private ArrayList<Soru> soruFromDY(ArrayList<DogruYanlisSoru> arr) {
		ArrayList<Soru> tempArr = new ArrayList<Soru>();
		for (DogruYanlisSoru soru : arr)	tempArr.add((Soru)soru);	return tempArr;
	}
	
	//tek arrayde butun sorulari birlestirme
	public ArrayList<Soru> tekArraydeBirlestirSorular(){
		ArrayList<Soru> tempArrayList = new ArrayList<Soru>();
		for (AcikUcluSoru soru : arrSoruAcikUclu) {
			tempArrayList.add((Soru)soru);
		}
		for (BoslukDoldurmaSoru soru : arrSoruBoslukDoldurma) {
			tempArrayList.add((Soru)soru);
		}
		for (CoktanSecmeliSoru soru : arrSoruCoktanSecmeli) {
			tempArrayList.add((Soru)soru);
		}
		for (DogruYanlisSoru soru : arrSoruDogruYanlis) {
			tempArrayList.add((Soru)soru);
		}
		Collections.sort(tempArrayList);
		return tempArrayList;
	}
	

	//arama bolumu
	public void arama() {
		Scanner girdi = new Scanner(System.in);
		System.out.print("\nArama Yap;"
				+ "\n1- Soru Metinleri Icerisinde Arama Yap,"
				+ "\n2- Secenekler Icerisinde Arama Yap,"
				+ "\n3- Cevaplar Icerisinde Arama Yap,"
				+ "\n4- Ana menuye don."
				+ "\nYapmak istediginiz islem: ");
		switch (islemAlInt("1-3 arasi sayi girin..!\n : ")) {
			case 1: aramaSoruMetni();	break;
			case 2: aramaSecenek();	break;
			case 3: aramaCevap();	break;
			default:	break;
		}
	}
	
	
	private void aramaSoruMetni() {
		Scanner girdi = new Scanner(System.in);
		System.out.print("\nSoru metni icerisinde arama"
				+ "\nAramak Istediginiz kelime/metin: ");
		String aramaMetni = girdi.nextLine();
		listeci.listele(arayici.soruMetniArama(tekArraydeBirlestirSorular(), aramaMetni));
	}
	
	
	private void aramaSecenek() {
		Scanner girdi = new Scanner(System.in);
		System.out.print("\nSecenek metni icerisinde arama"
				+ "\nAramak Istediginiz kelime/metin: ");
		String aramaMetni = girdi.nextLine();
		listeci.listele(arayici.secenekArama(tekArraydeBirlestirSorular(), aramaMetni));		
	}
	
	
	private void aramaCevap() {
		Scanner girdi = new Scanner(System.in);
		System.out.print("\nCevap arama(a,b,c)"
				+ "\nAramak Istediginiz kelime/metin: ");
		String aramaMetni = girdi.nextLine();
		listeci.listele(arayici.cevapArama(tekArraydeBirlestirSorular(), aramaMetni));
	}

	//islem alma
	private int islemAlInt(String hataMetni) {
		Scanner girdi = new Scanner(System.in);
		while(!girdi.hasNextInt()) {
			System.err.print(hataMetni);
			girdi.next();
		}
		return girdi.nextInt();
	}
	
	//input - output bolumu
	public void dosyayaKaydet() {
		io.sorularDosyaYaz(tekArraydeBirlestirSorular());
		io.sinavlarDosyaYaz(arrSinavlar);
	}

	//gets
	public ArrayList<AcikUcluSoru> getSorularAcikUclu(){
		return this.arrSoruAcikUclu;
	}
	
	
	public ArrayList<BoslukDoldurmaSoru> getSorularBoslukDoldurma(){
		return this.arrSoruBoslukDoldurma;
	}
	
	
	public ArrayList<CoktanSecmeliSoru> getSorularCoktanSecmeli(){
		return this.arrSoruCoktanSecmeli;
	}
	
	
	public ArrayList<DogruYanlisSoru> getSorlarDogruYanlis(){
		return this.arrSoruDogruYanlis;
	}
	
}