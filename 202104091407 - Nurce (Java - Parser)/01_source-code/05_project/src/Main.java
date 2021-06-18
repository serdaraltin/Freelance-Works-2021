import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Method {
	String methodIsmi;
	String donusTuru = "Nesne Adresi";
	ArrayList<String> parametreler = new ArrayList<String>();

	@Override
	public String toString() {

		String cikti = "\t" + methodIsmi + "\n";
		cikti += "\t\tParametre: ";
		if (parametreler.get(0) != "") {
			cikti += parametreler.size() + " ";
			cikti += "(";
			for (int i = 0; i < parametreler.size(); i++) {
				cikti += parametreler.get(i).toString();

				if (i + 1 < parametreler.size())
					cikti += ", ";

			}
			cikti += ")";
		} else {
			cikti += "0 ";
		}
		cikti += "\n\t\tDönüş Türü: " + donusTuru;

		return cikti;
	}
}

class Sinif {
	String sinifIsmi;
	ArrayList<Method> methodlar = new ArrayList<Method>();

	@Override
	public String toString() {
		String cikti = "Sınıf: " + sinifIsmi + "\n";

		if (methodlar.size() > 0) {
			for (Method method : methodlar) {
				cikti += method + "\n";
			}
		}

		return cikti;
	}
}

class CppDosyaOkuyucu {
	int imlecPoz;
	ArrayList<String> superSiniflar = new ArrayList<String>();

	public CppDosyaOkuyucu(String dosyaYolu) {
		ayristir((dosyaOku(dosyaYolu).toCharArray()));
	}

	public String dosyaOku(String dosyaYolu) {
		String veri = "";

		Scanner scanner;
		try {
			scanner = new Scanner(new File(dosyaYolu));
			while (scanner.hasNextLine()) {
				veri += scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return veri;
	}

	public String metneDonustur(char[] veri, int baslangic, int bitis) {
		String metin = "";
		for (int i = baslangic; i < bitis; i++) {
			metin += veri[i];
		}
		return metin;
	}

	public int bul(char[] veri, int poz, char karakter) {
		for (int i = poz; i < veri.length; i++) {
			if (veri[i] == karakter) {
				return i;
			}
		}
		return -1;
	}

	public int bul(char[] veri, int poz, String kelime) {
		char[] kelimeDizi = kelime.toCharArray();

		for (int i = poz; i < veri.length; i++) {
			if (veri[i] == kelimeDizi[0]) {

				boolean kontrol = true;

				for (int j = 0; j < kelimeDizi.length; j++) {
					if (kelimeDizi[j] != veri[i + j]) {
						kontrol = false;
						break;
					}
				}
				if (kontrol) {
					return i;
				}
			}
		}
		return -1;
	}

	public int bul(char[] veri, int poz, String kelime, boolean bitis) {
		char[] kelimeDizi = kelime.toCharArray();

		for (int i = poz; i < veri.length; i++) {
			if (veri[i] == kelimeDizi[0]) {

				boolean kontrol = true;

				for (int j = 0; j < kelimeDizi.length; j++) {
					if (kelimeDizi[j] != veri[i + j]) {
						kontrol = false;
						break;
					}
				}
				if (kontrol) {
					return i + kelime.length();
				}
			}
		}
		return -1;
	}

	public int[] aralikBul(char[] veri, int poz, char karakter1, char karakter2) {
		int[] aralik = new int[2];

		aralik[0] = bul(veri, poz, karakter1);
		aralik[1] = bul(veri, aralik[0], karakter2);

		return aralik;
	}

	public int[] aralikBul(char[] veri, int poz, String metin1, String metin2) {
		int[] aralik = new int[2];

		aralik[0] = bul(veri, poz, metin1);
		aralik[1] = bul(veri, aralik[0], metin2);

		return aralik;
	}

	public char[] temizle(char[] veri, int poz1, int poz2) {
		for (int i = poz1; i < poz2; i++) {
			veri[i] = ' ';
		}
		return veri;
	}

	public void temizle(char[] veri, int poz) {
		for (int i = 0; i < poz; i++) {
			veri[i] = ' ';
		}
	}

	public String temizle(String metin) {
		String temiz = "";

		char[] dizi = metin.toCharArray();
		for (int i = 0; i < dizi.length; i++) {
			if (dizi[i] == ' ' || dizi[i] == '\n' || dizi[i] == '\t')
				continue;
			temiz += dizi[i];
		}
		return temiz;
	}

	public int karakterAdet(char[] veri, int baslangic, int bitis, char karakter) {
		int adet = 0;

		for (int i = baslangic; i < bitis; i++) {
			if (veri[i] == karakter)
				adet++;
		}

		return adet;
	}

	public ArrayList<String> parametreBul(char[] veri, int baslangic, int bitis) {

		String parametreMetin = "";

		int i = baslangic;

		while (i > 0) {
			if (veri[i - 1] == '(')
				break;
			i--;
		}

		bitis = baslangic;
		while (bitis > veri.length) {
			if (veri[bitis] == ')')
				break;
			bitis++;
		}

		for (int j = i; j < bitis; j++) {
			if (veri[j] == ')')
				break;
			parametreMetin += veri[j];
		}

		ArrayList<String> parametreler = new ArrayList<String>();

		String[] parametreListe = parametreMetin.split(",");
		for (String parametre : parametreListe) {
			int indisNo = 0;
			if (!parametre.equals("") && parametre.charAt(0) == ' ')
				indisNo = 1;

			String[] parametreDizisi = parametre.split(" ");

			parametreler.add(parametreDizisi[indisNo]);

		}

		return parametreler;
	}

	public int[] geriyeAralikBul(char[] veri, int bitis, char karakter1, char karakter2) {
		int[] aralik = new int[2];

		for (int i = bitis; i > 0; i--) {
			if (veri[i] == karakter1)
				aralik[0] = i;
			if (veri[i] == karakter2)
				aralik[1] = i;
		}

		return aralik;
	}

	public String methodIsmiBul(char[] veri, int baslangic, int bitis) {
		String isim = "";

		int i = baslangic;

		while (i > 0) {
			if (veri[i] == '(')
				break;
			i--;
		}

		baslangic = i;
		while (baslangic > 0) {
			if (veri[baslangic] == ' ')
				break;
			baslangic--;
		}

		isim = metneDonustur(veri, baslangic, i);

		return isim;

	}

	public String donusTuruBul(char[] veri, int baslangic, int bitis) {
		String donusTuru = "";

		int i = baslangic;

		while (i > 0) {
			if (veri[i] == '(')
				break;
			i--;
		}

		while (i > 0) {
			if (veri[i] == ' ')
				break;
			i--;
		}

		baslangic = i;
		while (baslangic > 0) {
			if (veri[baslangic] == '}' || veri[baslangic] == ':') {
				break;
			}

			baslangic--;
		}

		donusTuru = metneDonustur(veri, baslangic + 1, i);
		try {
			donusTuru = donusTuru.split(" ")[donusTuru.split(" ").length - 1];
		} catch (Exception e) {
			// TODO: handle exception
		}
		donusTuru = temizle(donusTuru);

		if (donusTuru == "")
			donusTuru = "Nesne Adresi";
		return donusTuru;

	}

	public int[] sinifKapsami(char[] veri, int poz) {
		int[] aralik = new int[2];
		imlecPoz = poz;
		aralik[0] = imlecPoz;
		for (int i = imlecPoz; i < veri.length; i++) {
			if (veri[i] == '{') {
				for (int j = i; j < veri.length; j++) {
					if (veri[j] == '}') {
						i = j + 1;
						break;
					}
				}

			}
			if (veri[i] == '}') {

				aralik[1] = bul(veri, i, ';') + 1;
				break;

			}
		}

		return aralik;
	}

	public int[] methodBul(char[] veri, int poz) {
		int[] aralik = new int[2];
		imlecPoz = poz;

		for (int i = 0; i < veri.length; i++) {
			if (veri[i] == '{') {
				aralik[0] = i;
				for (int j = i; j < veri.length; j++) {
					if (veri[j] == '}') {
						i = j + 1;
						break;
					}
				}
				aralik[1] = i;
				break;
			}
		}
		return aralik;
	}

	public String superSinifBul(String sinifIsmi, char[] veri, int poz) {
		String superSinifIsmi = "";
		imlecPoz = poz;

		int sinifBaslangic = bul(veri, imlecPoz, sinifIsmi, true);
		// int publicKonum = bul(veri, sinifBaslangic, ":");

		if (sinifBaslangic == -1) {
			int[] aralik = aralikBul(veri, imlecPoz, ':', '{');
			imlecPoz = aralik[1];
			superSinifIsmi = metneDonustur(veri, aralik[0] + 1, aralik[1]);
			superSinifIsmi = superSinifIsmi.split(" ")[superSinifIsmi.split(" ").length - 1];

		}

		return superSinifIsmi;
	}

	public ArrayList<Method> methodlariBul(String sinifIsmi, char[] veri, int poz, boolean superSinif) {
		imlecPoz = poz;
		ArrayList<Method> methodlar = new ArrayList<Method>();

		imlecPoz = bul(veri, imlecPoz, '{') + 1;

		int[] aralik = sinifKapsami(veri, imlecPoz);

		imlecPoz = bul(veri, aralik[0], "public", true);
		imlecPoz = bul(veri, aralik[0], ':') + 1;

		for (int i = imlecPoz; i < aralik[1]; i++) {
			if (veri[i] == '{') {

				String methodIsmi = "";
				String donusTuru = "";
				ArrayList<String> parametreler = new ArrayList<String>();

				for (int j = i; j < veri.length; j++) {

					if (veri[j] == '}') {
						methodIsmi = methodIsmiBul(veri, i, j);
						parametreler = parametreBul(veri, i, j);
						donusTuru = donusTuruBul(veri, i, j);

						if (superSinif && donusTuru.contains(",")) {
							int j2;
							for (j2 = i; veri[j2] != ':'; j2--) {

							}

							methodIsmi = methodIsmiBul(veri, j2, j);
							parametreler = parametreBul(veri, j2, j);
							donusTuru = donusTuruBul(veri, j2, j);

						}

						imlecPoz = j;
						Method yeniMethod = new Method();
						yeniMethod.methodIsmi = methodIsmi;
						yeniMethod.parametreler = parametreler;
						yeniMethod.donusTuru = donusTuru;

						methodlar.add(yeniMethod);

						i = j + 1;
						break;
					}

				}

			}
			imlecPoz = i;
		}

		imlecPoz = aralik[1];
		return methodlar;

	}

	public Sinif sinifBul(char[] veri, int poz) {
		Sinif yeniSinif = new Sinif();
		imlecPoz = poz;

		if (bul(veri, imlecPoz, "class", true) == -1)
			return null;
		imlecPoz = bul(veri, imlecPoz, "class", true);

		int isimUzunluk = bul(veri, imlecPoz, '{');

		yeniSinif.sinifIsmi = temizle(metneDonustur(veri, imlecPoz, isimUzunluk));

		String superSinifIsmi = superSinifBul(yeniSinif.sinifIsmi, veri, imlecPoz);

		if (superSinifIsmi.length() > 0) {
			superSiniflar.add(superSinifIsmi);
			yeniSinif.sinifIsmi = yeniSinif.sinifIsmi.split(":")[0];
		}

		yeniSinif.methodlar = methodlariBul(yeniSinif.sinifIsmi, veri, imlecPoz, (superSinifIsmi.length() > 0));

		return yeniSinif;
	}

	public void ayristir(char[] veri) {
		ArrayList<Sinif> siniflar = new ArrayList<Sinif>();

		Sinif yeni = null;
		while ((yeni = sinifBul(veri, imlecPoz)) != null) {
			System.out.println(yeni);
		}

		if (superSiniflar.size() > 0) {
			
			System.out.println("Super Siniflar:");
		
			for (int i = 0; i < superSiniflar.size(); i++) {
				if(superSiniflar.get(i).equals(""))
					continue;
				int adet = 1;
				
				for (int j = i; j < superSiniflar.size(); j++) {
					if(superSiniflar.get(j).equals(superSiniflar.get(i))) {
						adet++;
						superSiniflar.set(j, "");
					}
				}
			
				System.out.println("\t"+superSiniflar.get(i)+": "+adet);
			
			}
		}

		// sinifBul(veri, imlecPoz);

	}

}

public class Main {
	public static void main(String[] args) {
		new CppDosyaOkuyucu("main.cpp");
	}
}
