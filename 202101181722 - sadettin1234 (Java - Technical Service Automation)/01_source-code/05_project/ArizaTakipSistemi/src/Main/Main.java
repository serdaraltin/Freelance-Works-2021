package Main;

import Controller.ControllerAriza;
import Controller.ControllerMusteri;
import Controller.ControllerTekniker;
import Model.Ariza;
import Model.Musteri;
import Model.Tekniker;
import java.util.Scanner;

public class Main {

    static Musteri[] musteriler = new Musteri[100];
    static Tekniker[] teknikerler = new Tekniker[100];
    static Ariza[] arizalar = new Ariza[100];

    static ControllerMusteri contMusteri = new ControllerMusteri();
    static ControllerTekniker contTekniker = new ControllerTekniker();
    static ControllerAriza contAriza = new ControllerAriza();

    static Scanner scanner = new Scanner(System.in);

    static int indexMusteri = 0, indexTekniker = 0, indexAriza = 0;

    public static void main(String[] args) {
        //test kayıtları
        teknikerler[indexTekniker++] = new Tekniker("1234567921", "Sedat", "Ucar");
        musteriler[indexMusteri++] = new Musteri("12345678910", "ahmet", "bal", "05429634578", "Adana Merkez");
        arizalar[indexAriza++] = new Ariza(musteriler[indexMusteri - 1], "sigorta patlamasi", 90, "18.01.2021");

        menu();
    }

    public static void menu() {
        System.out.println("1) Musteri Menu");
        System.out.println("2) Tekniker Menu");
        System.out.println("3) Ariza Menu");
        System.out.println("4) Ortalama Kazanc");
        System.out.println("0) Cikis");
        System.out.print("Secim : ");
        int secim = scanner.nextInt();
        System.out.println();
        switch (secim) {
            case 0:
                System.out.println("Cikiliyor...\n");
                System.exit(0);
                break;
            case 1:
                musteriMenu();
                break;
            case 2:
                teknikerMenu();
                break;
            case 3:
                arizaMenu();
                break;
            case 4:
                ortalamaKazanc();
                break;
            default:
                System.out.println("Hatali secim!\n");
                break;
        }
        System.out.println();
        menu();
    }

    //+
    private static void ortalamaKazanc() {
        float ortalama = 0;
        int toplam = 0, adet = 0;
        for (Ariza ariza : arizalar) {
            if (ariza != null) {
                toplam += ariza.getUcret();
                adet++;
            }
        }
        ortalama = toplam / adet;
        System.out.println("Ortalam Kazanc : " + ortalama + " TL");
    }

    //+
    private static void musteriMenu() {
        System.out.println("1) Listele");
        System.out.println("2) Ekle");
        System.out.println("3) Sil");
        System.out.println("4) Degistir");
        System.out.println("5) En Cok Arizasi Olan Musteri");
        System.out.println("6) Musteri Aktif Arizalar");
        System.out.println("7) En Cok Odeme Yapan Musteri");
        System.out.println("0) Ana Menu");
        System.out.print("Secim : ");
        int secim = scanner.nextInt();
        System.out.println();
        switch (secim) {
            case 0:
                return;
            case 1:
                musteriListele();
                break;
            case 2:
                musteriEkle();
                break;
            case 3:
                musteriSil();
                break;
            case 4:
                musteriDegistir();
                break;
            case 5:
                musteriEnCokAriza();
                break;
            case 6:
                musteriAktifAriza();
                break;
            case 7:
                musteriEnCokOdeme();
                break;
            default:
                System.out.println("Hatali secim!\n");
                break;
        }
        musteriMenu();
    }

    //+
    private static void musteriListele() {
        contMusteri.Listele(musteriler);
    }

    //+
    private static void musteriEkle() {
        Musteri musteri = new Musteri();
        System.out.print("Tc No : ");
        musteri.setTcno(scanner.next());
        if (contMusteri.Kontrol(musteriler, musteri)) {
            System.out.println("Bu TC numarasına kayıtlı müşteri bulumakta !\n");
            return;
        }
        System.out.print("Ad: ");
        musteri.setAd(scanner.next());
        System.out.print("Soyad : ");
        musteri.setSoyad(scanner.next());
        System.out.print("Telefon : ");
        musteri.setTelefon(scanner.next());
        System.out.println("Adres >>");
        String gec = scanner.nextLine();
        musteri.setAdres(scanner.nextLine());

        if (contMusteri.Ekle(musteriler, indexMusteri, musteri) != -1) {
            System.out.println("Musteri eklendi.\n");
            return;
        }
    }

    //+
    private static void musteriSil() {
        Musteri musteri = new Musteri();
        System.out.print("Tc No : ");
        musteri.setTcno(scanner.next());
        if (!contMusteri.Kontrol(musteriler, musteri)) {
            System.out.println("Bu TC numarasına kayıtlı müşteri bulunmamaktadir !\n");
            return;
        }
        System.out.println("\n" + musteriler[contMusteri.Getir(musteriler, musteri)] + "\n");
        if (contAriza.musteriKontrol(arizalar, musteri)) {
            System.out.println("Musteri adına kayitli arizalar bulundugu icin kayit silinemez !\n");
            return;
        }
        if (contMusteri.Sil(musteriler, musteri) != -1) {
            System.out.println("Musteri silindi.\n");
            return;
        }
    }

    //+
    private static void musteriDegistir() {
        Musteri musteri = new Musteri();
        System.out.print("Tc No : ");
        musteri.setTcno(scanner.next());
        if (!contMusteri.Kontrol(musteriler, musteri)) {
            System.out.println("Bu TC numarasına kayıtlı müşteri bulunmamaktadir !\n");
            return;
        }
        System.out.println("\n" + musteriler[contMusteri.Getir(musteriler, musteri)] + "\n");
        System.out.print("Ad: ");
        musteri.setAd(scanner.next());
        System.out.print("Soyad : ");
        musteri.setSoyad(scanner.next());
        System.out.print("Telefon : ");
        musteri.setTelefon(scanner.next());
        System.out.println("Adres >>");
        String gec = scanner.nextLine();
        musteri.setAdres(scanner.nextLine());

        if (contMusteri.Degistir(musteriler, musteri) != -1) {
            System.out.println("Musteri degistirildi.\n");
            return;
        }
    }

    //+
    private static int musteriArizaAdet(String tcno) {
        int adet = 0;
        for (Ariza ariza : arizalar) {
            if (ariza != null && ariza.getMusteri().getTcno().equals(tcno)) {
                adet++;
            }
        }
        return adet;
    }

    //+
    private static void musteriEnCokAriza() {
        Musteri encokArizaMusteri = new Musteri();
        int adet = 0;
        for (Musteri musteri : musteriler) {
            if (musteri != null) {
                if (musteriArizaAdet(musteri.getTcno()) > adet) {
                    encokArizaMusteri = musteri;
                    adet = musteriArizaAdet(musteri.getTcno());
                }
            }
        }
        System.out.println("En Cok Ariza Kayitli Musteri >> \n\n" + encokArizaMusteri + "\nAriza Adet : " + adet + "\n");
        System.out.println("ARIZALAR >>\n");
        for (Ariza ariza : arizalar) {
            if (ariza != null && ariza.getMusteri().getTcno().equals(encokArizaMusteri.getTcno())) {
                System.out.println(ariza + "\n");
            }
        }
        System.out.println();
    }

    //+
    private static void musteriAktifAriza() {
        contMusteri.Listele(musteriler);
        Musteri musteri = new Musteri();
        System.out.print("Tc No : ");
        musteri.setTcno(scanner.next());
        if (!contMusteri.Kontrol(musteriler, musteri)) {
            System.out.println("Bu TC numarasına kayıtlı müşteri bulunmamaktadir !\n");
            return;
        }
        System.out.println("\nAKTIF ARIZALAR >>\n");
        for (Ariza ariza : arizalar) {
            if (ariza != null && ariza.getMusteri().getTcno().equals(musteri.getTcno())) {
                if (ariza.getTeslimTarih().equals("teslim edilmedi")) {
                    System.out.println(ariza + "\n");
                }
            }
        }
        System.out.println();
    }

    //+
    private static int musteriOdemeMiktar(String tcno) {
        int miktar = 0;
        for (Ariza ariza : arizalar) {
            if (ariza != null && ariza.getMusteri().getTcno().equals(tcno)) {
                miktar += ariza.getUcret();
            }
        }
        return miktar;
    }

    //+
    private static void musteriEnCokOdeme() {
        Musteri encokOdemeMusteri = new Musteri();
        int miktar = 0;
        for (Musteri musteri : musteriler) {
            if (musteri != null) {
                if (musteriOdemeMiktar(musteri.getTcno()) > miktar) {
                    encokOdemeMusteri = musteri;
                    miktar = musteriOdemeMiktar(musteri.getTcno());
                }
            }
        }
        System.out.println("En Cok Ariza Kayitli Musteri >> \n\n" + encokOdemeMusteri + "\nOdeme   : " + miktar + " TL\n");
        /*System.out.println("ARIZALAR >>\n");
        for (Ariza ariza : arizalar) {
            if (ariza != null && ariza.getMusteri().getTcno().equals(encokOdemeMusteri.getTcno())) {
                System.out.println(ariza + "\n");
            }
        }*/
        System.out.println();
    }

    //+
    private static void teknikerMenu() {
        System.out.println("1) Listele");
        System.out.println("2) Ekle");
        System.out.println("3) Sil");
        System.out.println("4) Degistir");
        System.out.println("5) Tekniker Arizalar");
        System.out.println("6) En Cok Hasilat Yapan Tekniker");
        System.out.println("7) Tekniker Ariza Ekle");
        System.out.println("0) Ana Menu");
        System.out.print("Secim : ");
        int secim = scanner.nextInt();
        System.out.println();
        switch (secim) {
            case 0:
                return;
            case 1:
                teknikerListele();
                break;
            case 2:
                teknikerEkle();
                break;
            case 3:
                teknikerSil();
                break;
            case 4:
                teknikerDegistir();
                break;
            case 5:
                teknikerArizalar();
                break;
            case 6:
                teknikerEnCokHasilar();
                break;
            case 7:
                teknikerArizaEkle();
                break;
            default:
                System.out.println("Hatali secim!\n");
                break;
        }
        teknikerMenu();
    }

    //+
    private static void teknikerListele() {
        contTekniker.Listele(teknikerler);
    }

    //+
    private static void teknikerEkle() {
        Tekniker tekniker = new Tekniker();
        System.out.print("Tc No : ");
        tekniker.setTcno(scanner.next());
        if (contTekniker.Kontrol(teknikerler, tekniker)) {
            System.out.println("Bu TC numarasına kayıtlı tekniker bulumakta !\n");
            return;
        }
        System.out.print("Ad: ");
        tekniker.setAd(scanner.next());
        System.out.print("Soyad : ");
        tekniker.setSoyad(scanner.next());

        if (contTekniker.Ekle(teknikerler, indexTekniker, tekniker) != -1) {
            System.out.println("Tekniker eklendi.\n");
            return;
        }
    }

    //+
    private static void teknikerSil() {
        Tekniker tekniker = new Tekniker();
        System.out.print("Tc No : ");
        tekniker.setTcno(scanner.next());
        if (!contTekniker.Kontrol(teknikerler, tekniker)) {
            System.out.println("Bu TC numarasına kayıtlı tekniker bulunmamaktadir !\n");
            return;
        }
        System.out.println("\n" + teknikerler[contTekniker.Getir(teknikerler, tekniker)] + "\n");
        if (contTekniker.arizaKontrol(teknikerler, tekniker)) {
            System.out.println("Tekniker adına kayitli arizalar bulundugu icin kayit silinemez !\n");
            return;
        }
        if (contTekniker.Sil(teknikerler, tekniker) != -1) {
            System.out.println("Tekniker silindi.\n");
            return;
        }
    }

    //+
    private static void teknikerDegistir() {
        Tekniker tekniker = new Tekniker();
        System.out.print("Tc No : ");
        tekniker.setTcno(scanner.next());
        if (!contTekniker.Kontrol(teknikerler, tekniker)) {
            System.out.println("Bu TC numarasına kayıtlı tekniker bulunmamaktadir !\n");
            return;
        }
        System.out.print("Ad: ");
        tekniker.setAd(scanner.next());
        System.out.print("Soyad : ");
        tekniker.setSoyad(scanner.next());

        if (contTekniker.Degistir(teknikerler, tekniker) != -1) {
            System.out.println("Tekniker degistirildi.\n");
            return;
        }
    }

    //+
    private static void teknikerArizalar() {
        contTekniker.Listele(teknikerler);
        Tekniker tekniker = new Tekniker();
        System.out.print("Tc No : ");
        tekniker.setTcno(scanner.next());
        int indexNo = contTekniker.Getir(teknikerler, tekniker);
        System.out.println("\nTEKNIKER ARIZALAR >>");
        for (Ariza ariza : teknikerler[indexNo].getArizalar()) {
            if (ariza != null) {
                System.out.println(ariza + "\n");
            }
        }
    }

    //+
    private static void teknikerArizaEkle() {
        contTekniker.Listele(teknikerler);
        Tekniker tekniker = new Tekniker();
        System.out.print("Tc No : ");
        tekniker.setTcno(scanner.next());
        if (!contTekniker.Kontrol(teknikerler, tekniker)) {
            System.out.println("Bu TC numarasına kayıtlı tekniker bulunmamaktadir !\n");
            return;
        }
        tekniker = teknikerler[contTekniker.Getir(teknikerler, tekniker)];
        System.out.println(tekniker + "\n");
        contAriza.Listele(arizalar);
        System.out.print("Ariza No : ");
        int arizaNo = scanner.nextInt() - 1;
        if (arizalar[arizaNo] == null) {
            System.out.println("Bu No ya sahip ariza kaydi bulunmamaktadir !\n");;
            return;
        }
        tekniker.arizaEkle(arizalar[arizaNo]);
        System.out.println("Ariza kaydi teknikere eklendi.\n");
        return;
    }

    //+
    private static int teknikerHasilat(Tekniker tekniker) {
        int hasilat = 0;
        for (Ariza ariza : tekniker.getArizalar()) {
            if (ariza != null) {
                hasilat += ariza.getUcret();
            }
        }
        return hasilat;
    }

    //+
    private static void teknikerEnCokHasilar() {
        Tekniker encokHasilatTekniker = new Tekniker();
        int hasilat = 0;
        for (Tekniker tekniker : teknikerler) {
            if (tekniker != null) {
                if (teknikerHasilat(tekniker) > hasilat) {
                    encokHasilatTekniker = tekniker;
                    hasilat = teknikerHasilat(tekniker);
                }
            }
        }
        if (encokHasilatTekniker.getAd() == null) {
            System.out.println("Tekniker veya teknikerlere ait ariza kaydı yok!\n");
            return;
        }
        System.out.println("En Cok Hasilat Yapan Tekniker >>\n" + encokHasilatTekniker + "\nHasilat : " + hasilat + " TL\n");

    }

    //+
    private static void arizaMenu() {
        System.out.println("1) Listele");
        System.out.println("2) Ekle");
        System.out.println("3) Degistir");
        System.out.println("4) Farkli Ariza Turleri");
        System.out.println("0) Ana Menu");
        System.out.print("Secim : ");
        int secim = scanner.nextInt();
        System.out.println();
        switch (secim) {
            case 0:
                return;
            case 1:
                arizaListe();
                break;
            case 2:
                arizaEkle();
                break;
            case 3:
                arizaDegistir();
                break;
            case 4:
                arizaFakliTurler();
                break;
            default:
                System.out.println("Hatali secim!\n");
                break;
        }
        arizaMenu();
    }

    //+
    private static void arizaListe() {
        contAriza.Listele(arizalar);
    }

    //+
    private static void arizaEkle() {
        Ariza ariza = new Ariza();
        contMusteri.Listele(musteriler);
        Musteri musteri = new Musteri();
        System.out.print("Musteri Tc No : ");
        musteri.setTcno(scanner.next());
        if (!contMusteri.Kontrol(musteriler, musteri)) {
            System.out.println("Bu TC numarasına kayıtlı müşteri bulunmamaktadir !\n");
            return;
        }

        ariza.setMusteri(musteriler[contMusteri.Getir(musteriler, musteri)]);
        System.out.println("\n" + ariza.getMusteri() + "\n");
        System.out.print("Kayit Tarih : ");
        ariza.setKayitTarih(scanner.next());
        System.out.println("Tur >>");
        String gec = scanner.nextLine();
        ariza.setTur(scanner.nextLine());
        System.out.print("Ucret : ");
        ariza.setUcret(scanner.nextInt());
        if (contAriza.Ekle(arizalar, indexAriza, ariza) != -1) {
            System.out.println("Ariza kaydi eklendi.");
            return;
        }
    }

    //+
    private static void arizaDegistir() {
        contAriza.Listele(arizalar);
        System.out.print("Ariza No : ");
        int arizaNo = scanner.nextInt() - 1;
        if (arizalar[arizaNo] == null) {
            System.out.println("Bu No ya sahip ariza kaydi bulunmamaktadir !\n");;
            return;
        }
        System.out.println("Durum >>");
        String gec = scanner.nextLine();
        arizalar[arizaNo].setDurum(scanner.nextLine());
        System.out.print("Teslim Tarih : ");
        arizalar[arizaNo].setTeslimTarih(scanner.next());

        System.out.println("Ariza kaydi degistirildi.\n");
    }

    //+
    private static boolean arizaTurKontrol(String tur, int index) {
        for (int i = index; i > 0; i--) {
            if (arizalar[i] != null && arizalar[i].getTur().equals(tur)) {
                return true;
            }
        }
        return false;
    }

    //+
    private static void arizaFakliTurler() {
        String[] turler = new String[100];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (arizalar[i] != null) {

                turler[index++] = arizalar[i].getTur();

            }
        }
        System.out.println("\nFARKLI TURLER >>");
        for (String tur : turler) {
            if (tur != null) {
                System.out.println(tur);
            }
        }
        System.out.println();
    }

}
