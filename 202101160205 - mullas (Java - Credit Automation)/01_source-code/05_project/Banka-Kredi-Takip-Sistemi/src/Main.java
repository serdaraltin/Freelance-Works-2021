
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
        System.out.println("1) Müşteri İşlemleri");
        System.out.println("2) Kredi İşlemleri");
        System.out.println("3) Ödeme İşlemleri");
        System.out.println("4) Hesaplama İşlemleri");
        System.out.println("0) Çıkış");
        System.out.print("Seçim : ");
        int secim = scanner.nextInt();

        switch (secim) {
            case 0:
                System.out.println("Çıkılıyor...");
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
                System.out.println("Hatalı seçim !");
                break;
        }
        System.out.println();
        menu();
    }

    public static void musteriMenu() {
        String tcno, ad, soyad, telefon, eposta, sehir;
        System.out.println("1) Müşterileri Listele");
        System.out.println("2) Müşteri Ekle");
        System.out.println("3) Müşteri Silme");
        System.out.println("4) Müşteri Değiştirme");
        System.out.println("0) Ana Menü");
        System.out.print("Seçim : ");
        int secim = scanner.nextInt();

        switch (secim) {
            case 0:
                return;
            case 1:
                System.out.println("MÜŞTERİ LİSTESİ >>>\n");
                for (Musteri musteri : musteriler) {
                    System.out.println(musteri + "\n");
                }
                break;
            case 2:
                System.out.print("Tc No : ");
                tcno = scanner.next();
                if (musteriKontrol(tcno)) {
                    System.out.println("Aynı TC No'ya sahip bir müşteri bulunmakta !\n");
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
                System.out.println("Müşteri eklendi.\n");
                break;
            case 3:
                System.out.print("Tc No : ");
                tcno = scanner.next();
                if (!musteriKontrol(tcno)) {
                    System.out.println("Müşteri bulunamadı !\n");
                    break;
                }
                if (musteriSil(tcno)) {
                    System.out.println("Müşteri silindi.\n");
                }
                break;
            case 4:
                System.out.print("Tc No : ");
                tcno = scanner.next();
                if (!musteriKontrol(tcno)) {
                    System.out.println("Müşteri bulunamadı !\n");
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
                System.out.println("Müşteri güncellendi.\n");
                break;
            default:
                System.out.println("Hatalı seçim !");
                break;
        }
        System.out.println();
        musteriMenu();
    }

    private static void krediMenu() {
        Musteri musteri;
        String durum = "borçlu";
        float krediMiktar = 0;
        int no;
        System.out.println("1) Kredileri Listele");
        System.out.println("2) Kredi Ekle");
        System.out.println("3) Kredi Silme");
        System.out.println("4) Kredi Değiştirme");
        System.out.println("0) Ana Menü");
        System.out.print("Seçim : ");
        int secim = scanner.nextInt();

        switch (secim) {
            case 0:
                return;
            case 1:
                System.out.println("KREDİ LİSTESİ >>>\n");
                for (Kredi kredi : krediler) {
                    System.out.println(kredi+"\n");
                }
                break;
            case 2:
                musteriListele();
                System.out.print("Müşteri No : ");
                no = scanner.nextInt();
                if (no < 0 || no > musteriler.size()) {
                    System.out.println("Geçersiz no !\n");
                    return;
                }
                musteri = musteriler.get(no - 1);
                if (krediGetir(musteri.getTcno()) != -1) {
                    System.out.println("Müşteriye zaten kredi verilmiş !\n");
                    return;
                }
                System.out.print("Kredi Miktar : ");
                krediMiktar = scanner.nextFloat();
                krediler.add(new Kredi(musteri, krediMiktar, durum));
                System.out.println("Kredi bilgisi eklendi.\n");
                break;
            case 3:
                System.out.println("KREDİ LİSTESİ >>>\n");
                krediListele();
                no = scanner.nextInt();
                if (no < 0 || no > krediler.size()) {
                    System.out.println("Geçersiz no !\n");
                    return;
                }
                if (musteriSil(krediler.get(no - 1).getMusteri().getTcno())) {
                    System.out.println("Kredi bilgisi silindi.\n");
                }
                break;
            case 4:
                System.out.println("KREDİ LİSTESİ >>>\n");
                krediListele();
                no = scanner.nextInt();
                if (no < 0 || no > krediler.size()) {
                    System.out.println("Geçersiz no !\n");
                    return;
                }
                System.out.print("Kredi Miktar : ");
                krediMiktar = scanner.nextFloat();
                System.out.print("Durum : ");
                durum = scanner.next();
                krediler.get(no - 1).setKrediMiktar(krediMiktar);
                krediler.get(no - 1).setDurum(durum);
                System.out.println("Kredi bilgisi değiştirildi.\n");
                break;
            default:
                System.out.println("Hatalı seçim !");
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
        System.out.println("1) Ödemeleri Listele");
        System.out.println("2) Ödeme Ekle");
        System.out.println("0) Ana Menü");
        System.out.print("Seçim : ");
        int secim = scanner.nextInt();

        switch (secim) {
            case 0:
                return;
            case 1:
                System.out.println("ÖDEME LİSTESİ >>>\n");
                for (Odeme odeme : odemeler) {
                    System.out.println(odeme+"\n");
                }
                break;
            case 2:
                System.out.println("KREDİ LİSTESİ >>>\n");
                krediListele();
                System.out.print("Kredi No : ");
                no = scanner.nextInt();
                if (no < 0 || no > krediler.size()) {
                    System.out.println("Geçersiz no !\n");
                    return;
                }
                System.out.print("Ödeme Miktar : ");
                odemeMiktar = scanner.nextFloat();
                System.out.print("Tarih : ");
                tarih = scanner.next();
                odemeler.add(new Odeme(krediler.get(no - 1), odemeMiktar, tarih));
                System.out.println("Ödeme eklendi.\n");
                break;
            default:
                System.out.println("Hatalı seçim !\n");
                break;
        }
        System.out.println();
        odemeMenu();
    }

    private static void hesaplamaMenu() {
        System.out.println("1) Ortalama Kredi");
        System.out.println("2) Maks Kredi");
        System.out.println("3) Min Kredi");
        System.out.println("0) Ana Menü");
        System.out.print("Seçim : ");
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
                System.out.println("Hatalı seçim !\n");
                break;
        }
        System.out.println();
        hesaplamaMenu();
    }
}
