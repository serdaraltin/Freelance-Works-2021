
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Musteri> musteriler = new ArrayList<>();
    static ArrayList<Kredi> krediler = new ArrayList<>();
    static ArrayList<Odeme> odemeler = new ArrayList<>();

    public static void musteriListele() {
        for (int i = 0; i < musteriler.size(); i++) {
            System.out.println("No : " + (i + 1) + "\n" + musteriler.get(i)+"\n");
        }
    }

    public static void krediListele() {
        for (int i = 0; i < krediler.size(); i++) {
            System.out.println("No : " + (i + 1) + "\n" + krediler.get(i)+"\n");
        }
    }

    public static boolean musteriKontrol(String tcno) {
        for (Musteri musteri : musteriler) {
            if (musteri.getTcno().equals(tcno)) {
                return true;
            }
        }
        return false;
    }

    public static int musteriGetir(String tcno) {
        for (int i = 0; i < musteriler.size(); i++) {
            if (musteriler.get(i).getTcno().equals(tcno)) {
                return i;
            }
        }
        return -1;
    }

    public static int krediGetir(String tcno) {
        for (int i = 0; i < krediler.size(); i++) {
            if (krediler.get(i).getMusteri().getTcno().equals(tcno)) {
                return i;
            }
        }
        return -1;
    }

    public static int odemeGetir(String tcno) {
        for (int i = 0; i < odemeler.size(); i++) {
            if (odemeler.get(i).getKredi().getMusteri().getTcno().equals(tcno)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean musteriSil(String tcno) {
        int musteriIndex = musteriGetir(tcno);
        int krediIndex = krediGetir(tcno);
        int odemeIndex = odemeGetir(tcno);

        if (odemeIndex != -1) {
            odemeler.remove(odemeIndex);
        }
        if (krediIndex != -1) {
            krediler.remove(krediIndex);
        }
        if (musteriIndex != -1) {
            musteriler.remove(musteriIndex);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("1) M????teri ????lemleri");
        System.out.println("2) Kredi ????lemleri");
        System.out.println("3) ??deme ????lemleri");
        System.out.println("4) Hesaplama ????lemleri");
        System.out.println("0) ????k????");
        System.out.print("Se??im : ");
        int secim = scanner.nextInt();

        switch (secim) {
            case 0:
                System.out.println("????k??l??yor...");
                System.exit(0);
                break;
            case 1:
                musteriMenu();
                break;
            case 2:
                krediMenu();
                break;
            case 3:
                odemeMenu();
                break;
            case 4:
                hesaplamaMenu();
                break;
            default:
                System.out.println("Hatal?? se??im !");
                break;
        }
        System.out.println();
        menu();
    }

    public static void musteriMenu() {
        String tcno, ad, soyad, telefon, eposta, sehir;
        System.out.println("1) M????terileri Listele");
        System.out.println("2) M????teri Ekle");
        System.out.println("3) M????teri Silme");
        System.out.println("4) M????teri De??i??tirme");
        System.out.println("0) Ana Men??");
        System.out.print("Se??im : ");
        int secim = scanner.nextInt();

        switch (secim) {
            case 0:
                return;
            case 1:
                System.out.println("M????TER?? L??STES?? >>>\n");
                for (Musteri musteri : musteriler) {
                    System.out.println(musteri + "\n");
                }
                break;
            case 2:
                System.out.print("Tc No : ");
                tcno = scanner.next();
                if (musteriKontrol(tcno)) {
                    System.out.println("Ayn?? TC No'ya sahip bir m????teri bulunmakta !\n");
                    break;
                }
                System.out.print("Ad : ");
                ad = scanner.next();
                System.out.print("Soyad : ");
                soyad = scanner.next();
                System.out.print("Telefon : ");
                telefon = scanner.next();
                System.out.print("Eposta : ");
                eposta = scanner.next();
                System.out.print("Sehir : ");
                sehir = scanner.next();
                musteriler.add(new Musteri(tcno, ad, soyad, telefon, eposta, sehir));
                System.out.println("M????teri eklendi.\n");
                break;
            case 3:
                System.out.print("Tc No : ");
                tcno = scanner.next();
                if (!musteriKontrol(tcno)) {
                    System.out.println("M????teri bulunamad?? !\n");
                    break;
                }
                if (musteriSil(tcno)) {
                    System.out.println("M????teri silindi.\n");
                }
                break;
            case 4:
                System.out.print("Tc No : ");
                tcno = scanner.next();
                if (!musteriKontrol(tcno)) {
                    System.out.println("M????teri bulunamad?? !\n");
                    break;
                }
                int musteriIndex = musteriGetir(tcno);
                System.out.print("Ad : ");
                musteriler.get(musteriIndex).setAd(scanner.next());
                System.out.print("Soyad : ");
                musteriler.get(musteriIndex).setSoyad(scanner.next());
                System.out.print("Telefon : ");
                musteriler.get(musteriIndex).setTelefon(scanner.next());
                System.out.print("Eposta : ");
                musteriler.get(musteriIndex).setEposta(scanner.next());
                System.out.print("Sehir : ");
                musteriler.get(musteriIndex).setSehir(scanner.next());
                System.out.println("M????teri g??ncellendi.\n");
                break;
            default:
                System.out.println("Hatal?? se??im !");
                break;
        }
        System.out.println();
        musteriMenu();
    }

    private static void krediMenu() {
        Musteri musteri;
        String durum = "bor??lu";
        float krediMiktar = 0;
        int no;
        System.out.println("1) Kredileri Listele");
        System.out.println("2) Kredi Ekle");
        System.out.println("3) Kredi Silme");
        System.out.println("4) Kredi De??i??tirme");
        System.out.println("0) Ana Men??");
        System.out.print("Se??im : ");
        int secim = scanner.nextInt();

        switch (secim) {
            case 0:
                return;
            case 1:
                System.out.println("KRED?? L??STES?? >>>\n");
                for (Kredi kredi : krediler) {
                    System.out.println(kredi+"\n");
                }
                break;
            case 2:
                musteriListele();
                System.out.print("M????teri No : ");
                no = scanner.nextInt();
                if (no < 0 || no > musteriler.size()) {
                    System.out.println("Ge??ersiz no !\n");
                    return;
                }
                musteri = musteriler.get(no - 1);
                if (krediGetir(musteri.getTcno()) != -1) {
                    System.out.println("M????teriye zaten kredi verilmi?? !\n");
                    return;
                }
                System.out.print("Kredi Miktar : ");
                krediMiktar = scanner.nextFloat();
                krediler.add(new Kredi(musteri, krediMiktar, durum));
                System.out.println("Kredi bilgisi eklendi.\n");
                break;
            case 3:
                System.out.println("KRED?? L??STES?? >>>\n");
                krediListele();
                no = scanner.nextInt();
                if (no < 0 || no > krediler.size()) {
                    System.out.println("Ge??ersiz no !\n");
                    return;
                }
                if (musteriSil(krediler.get(no - 1).getMusteri().getTcno())) {
                    System.out.println("Kredi bilgisi silindi.\n");
                }
                break;
            case 4:
                System.out.println("KRED?? L??STES?? >>>\n");
                krediListele();
                no = scanner.nextInt();
                if (no < 0 || no > krediler.size()) {
                    System.out.println("Ge??ersiz no !\n");
                    return;
                }
                System.out.print("Kredi Miktar : ");
                krediMiktar = scanner.nextFloat();
                System.out.print("Durum : ");
                durum = scanner.next();
                krediler.get(no - 1).setKrediMiktar(krediMiktar);
                krediler.get(no - 1).setDurum(durum);
                System.out.println("Kredi bilgisi de??i??tirildi.\n");
                break;
            default:
                System.out.println("Hatal?? se??im !");
                break;
        }
        System.out.println();
        krediMenu();
    }

    private static void odemeMenu() {
        Kredi kredi;
        float odemeMiktar = 0;
        String tarih;
        int no;
        System.out.println("1) ??demeleri Listele");
        System.out.println("2) ??deme Ekle");
        System.out.println("0) Ana Men??");
        System.out.print("Se??im : ");
        int secim = scanner.nextInt();

        switch (secim) {
            case 0:
                return;
            case 1:
                System.out.println("??DEME L??STES?? >>>\n");
                for (Odeme odeme : odemeler) {
                    System.out.println(odeme+"\n");
                }
                break;
            case 2:
                System.out.println("KRED?? L??STES?? >>>\n");
                krediListele();
                System.out.print("Kredi No : ");
                no = scanner.nextInt();
                if (no < 0 || no > krediler.size()) {
                    System.out.println("Ge??ersiz no !\n");
                    return;
                }
                System.out.print("??deme Miktar : ");
                odemeMiktar = scanner.nextFloat();
                System.out.print("Tarih : ");
                tarih = scanner.next();
                odemeler.add(new Odeme(krediler.get(no - 1), odemeMiktar, tarih));
                System.out.println("??deme eklendi.\n");
                break;
            default:
                System.out.println("Hatal?? se??im !\n");
                break;
        }
        System.out.println();
        odemeMenu();
    }

    private static void hesaplamaMenu() {
        System.out.println("1) Ortalama Kredi");
        System.out.println("2) Maks Kredi");
        System.out.println("3) Min Kredi");
        System.out.println("0) Ana Men??");
        System.out.print("Se??im : ");
        int secim = scanner.nextInt();
        Hesaplama hesaplama = new Hesaplama(krediler);

        switch (secim) {
            case 0:
                return;
            case 1:
                System.out.println("Ortalama Kredi : " + hesaplama.getOrtalama() + " TL");
                break;
            case 2:
                System.out.println("Maks Kredi : " + new Maks(krediler).getMax() + " TL");
                break;
            case 3:
                System.out.println("Maks Kredi : " + new Min(krediler).getMin() + " TL");
                break;
            default:
                System.out.println("Hatal?? se??im !\n");
                break;
        }
        System.out.println();
        hesaplamaMenu();
    }
}
