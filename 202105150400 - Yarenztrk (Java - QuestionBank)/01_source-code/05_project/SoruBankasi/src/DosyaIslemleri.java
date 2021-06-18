import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class DosyaIslemleri {

	private final String fileNameSinavlar = "sinavlar.txt";
	private final String fileNameSorular = "sorular.txt";
	private ArrayList<Soru> sorular = new ArrayList<Soru>();

	/*
		eger "sorular.txt" yok ise olusturuyoruz ve icine default olarak kayitli
		her soru cinsinden 5 er tane olmak uzere 20 soru yaziyor.
		dosya var ve soru sayisi eksik yada fazla ise bir islem yapmiyoruz.
	*/
	
	public DosyaIslemleri(ArrayList<AcikUcluSoru> au,
			ArrayList<BoslukDoldurmaSoru> bd,
			ArrayList<CoktanSecmeliSoru> cs,
			ArrayList<DogruYanlisSoru> dy)
	{
		sorularDosyaOku(au,bd,cs,dy);
	}

	@SuppressWarnings("unchecked")
	public void sorularDosyaOku(ArrayList<AcikUcluSoru> au,
			ArrayList<BoslukDoldurmaSoru> bd,
			ArrayList<CoktanSecmeliSoru> cs,
			ArrayList<DogruYanlisSoru> dy) 
	{
		try {
			FileInputStream fis = new FileInputStream(fileNameSorular);
			ObjectInputStream ois = new ObjectInputStream(fis);
			sorular = (ArrayList<Soru>)ois.readObject();
			sorulariListeyeAl(au, bd, cs, dy);
			ois.close();
			
		} catch (FileNotFoundException e) {
			//dosya bulunamadiginda, dosya olusturup varsayilan sorulari kaydediyor.
			sorularDosyaYazVarsayilan(au, bd, cs, dy);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			//dosya var ama ici bos ise bu varsayilan sorulari ekliyor.
			sorularDosyaYazVarsayilan(au, bd, cs, dy);
			sorularDosyaOku(au, bd, cs, dy);
		}
	}

	public void sorularDosyaYaz(ArrayList<Soru> sorular) {
		this.sorular = sorular;
		try {
			FileOutputStream fos = new FileOutputStream(fileNameSorular);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(this.sorular);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	//eger sorular.txt bos ise assadaki sorulari varsayilan olarak ekliyor.
	private void sorularDosyaYazVarsayilan(
			ArrayList<AcikUcluSoru> au,
			ArrayList<BoslukDoldurmaSoru> bd,
			ArrayList<CoktanSecmeliSoru> cs,
			ArrayList<DogruYanlisSoru> dy)
	{
		au.add(new AcikUcluSoru("Buyuk Iskender kimdir? Kisaca anlatin.", 1));
		au.add(new AcikUcluSoru("Sokrates kimdir? Kisaca anlatin.", 1));
		au.add(new AcikUcluSoru("Gaius Julius Caesar kimdir? Kisaca anlatin.", 2));
		au.add(new AcikUcluSoru("Satraplik sistemi nedir kisaca aciklayin.", 2));
		au.add(new AcikUcluSoru("Platon'un Magara Deneyini aciklayin.", 3));
		
		bd.add(new BoslukDoldurmaSoru("Buyuk Iskender babasi II. Filip'ten ......... tahtini devralmistir.", 1, "Makedonya"));
		bd.add(new BoslukDoldurmaSoru(".....'in acilimi international network tur.", 1, " internet"));
		bd.add(new BoslukDoldurmaSoru("..... Roma Ordularinin en genis birimidir.", 2, "lejyon"));
		bd.add(new BoslukDoldurmaSoru("Sokrates .....'da dogmustur.", 2, "Atina"));
		bd.add(new BoslukDoldurmaSoru(".......... Budizm'in dini liderine verilen isimdir.", 3, "Dalai Lama"));
		
		cs.add(new CoktanSecmeliSoru("Ataturk'un dogum tarihi?", 1, "1880$1881$1882", "b"));
		cs.add(new CoktanSecmeliSoru("Roma Devletinin resmi dili hangisidir?", 1, "Latince$Italyanca$Flemenkce", "a"));
		cs.add(new CoktanSecmeliSoru("Pers Imparatorlugunu kim yikmistir?", 2, "Scipio Africanus$Hannibal$Buyuk Iskender", "c"));
		cs.add(new CoktanSecmeliSoru("Ceaser'la iliski yasan, sonrasinda Mark Anthony ile evlenen Misir Kralicesi hangisidir?", 2, 
				"VII. Kleopatra$VIII Kleopatra$IX. Kleopatra", "a"));
		cs.add(new CoktanSecmeliSoru("Son Pers Imparatoru kimdir?", 3, "Darius I$Darius II$Darius III", "c"));
		
		dy.add(new DogruYanlisSoru("Buyuk Iskender 32 yasinda olmustur.", 1, "d"));
		dy.add(new DogruYanlisSoru("Julius Ceaser savasta olmustur.", 1, "y"));
		dy.add(new DogruYanlisSoru("Kubilay Cin'i fethedip Yuan Hanedanligini kurmustur.", 2, "d"));
		dy.add(new DogruYanlisSoru("Cengiz Han'in gercek adi Cengiz'dir.", 2, "y"));
		dy.add(new DogruYanlisSoru("Hinduism'de ki yaratici tanrinin adi Brahma'dir", 3, "d"));	
		
		sorularTekListe(au, bd, cs, dy);
	}
	
	private void sorularTekListe(
			ArrayList<AcikUcluSoru> au,
			ArrayList<BoslukDoldurmaSoru> bd,
			ArrayList<CoktanSecmeliSoru> cs,
			ArrayList<DogruYanlisSoru> dy)
	{
		for (AcikUcluSoru soru : au)
			sorular.add((Soru)soru);
		for (BoslukDoldurmaSoru soru : bd)
			sorular.add((Soru)soru);
		for (CoktanSecmeliSoru soru : cs)
			sorular.add((Soru)soru);
		for (DogruYanlisSoru soru : dy)
			sorular.add((Soru)soru);
	}

	private void sorulariListeyeAl(ArrayList<AcikUcluSoru> au,
			ArrayList<BoslukDoldurmaSoru> bd,
			ArrayList<CoktanSecmeliSoru> cs,
			ArrayList<DogruYanlisSoru> dy)
	{
		for (Soru soru : sorular) {
			switch (soru.getSoruCesidi()) {
				case 'a':	au.add((AcikUcluSoru)soru);	break;
				case 'b':	bd.add((BoslukDoldurmaSoru)soru);	break;
				case 'c':	cs.add((CoktanSecmeliSoru)soru);	break;
				case 'd':	dy.add((DogruYanlisSoru)soru);	break;
				default:	break;
			}
		}
	}
	
	//sinavlar
	public void sinavlarDosyaYaz(ArrayList<Sinav> sinavlar) {
		try {
			FileOutputStream fos = new FileOutputStream(fileNameSinavlar);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(sinavlar);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (StackOverflowError e) {
			e.printStackTrace();
		} catch (NotSerializableException e) {
			e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
	}
	
}