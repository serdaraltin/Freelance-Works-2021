package proje;

import java.util.ArrayList;
import java.util.Scanner;

public class Proje {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Model_Musteri> musteriler = new ArrayList<>();

    //Interface_Controller interface : Controller sınıfı için şablon tanımlamalarını içermektedir 
    //"<T>" daha sonradan çağrıldığı yerde verilen modele göre şekillenmesini sağlar
    static interface Interface_Controller<T> {

        //ilgili methodun prototip tanımı
        public void Listele(ArrayList<T> liste);

        //ilgili methodun prototip tanımı
        public int Kontrol(ArrayList<T> liste, T kayit);

        //ilgili methodun prototip tanımı
        public int Guncelle(ArrayList<T> liste, T kayit);

        //ilgili methodun prototip tanımı
        public boolean Sil(ArrayList<T> liste, T kayit);

        //ilgili methodun prototip tanımı
        public int Ara(ArrayList<T> liste, String aranan);

    }

    //Modal_Main soyut sınıfı : temel olarak bir Model sınıfında olması gerekn özelliklerin tanımlanmasını sağlar
    abstract class Model_Main {

        //genel olarak sınıflarda ortak olan özellik 'Id' değerinin tanımlanması
        private int Id;

        //ilgili özellik için get methodu (kapsülleme)
        public int getId() {
            return Id;
        }

        //ilgili özellik için set methodu (kapsülleme)
        public void setId(int Id) {
            this.Id = Id;
        }

    }

    //Model_Musteri sınıfı : müşteri nesnesinin sahip olacağı özellikleri belirler ve depolar, 
    //Model_Main sınıfından kalıtım almıştır
    static class Model_Musteri extends Model_Main {
        //bu sınıfa ait özelliklerin tanımlanması
        private String ad, soyad, telefon;
        //boş kurucu method
        public Model_Musteri() {
        }
        //bir üst sınıftan miras alınan 'Id' bilgisi ve diğer tüm bilgilerin parametre olarak gönderildiği kurucu method
        public Model_Musteri(int Id, String ad, String soyad, String telefon) {
            super.setId(Id);
            this.ad = ad;
            this.soyad = soyad;
            this.telefon = telefon;
        }
        //sadece bu sınıfa ait yani 'Id' bilgisinin gönderilmediği kurucu method
        public Model_Musteri(String ad, String soyad, String telefon) {
            this.ad = ad;
            this.soyad = soyad;
            this.telefon = telefon;
        }

        //ilgili özellik için get methodu (kapsülleme)
        public String getAd() {
            return ad;
        }

        //ilgili özellik için set methodu (kapsülleme)
        public void setAd(String ad) {
            this.ad = ad;
        }

        //ilgili özellik için get methodu (kapsülleme)
        public String getSoyad() {
            return soyad;
        }

        //ilgili özellik için set methodu (kapsülleme)
        public void setSoyad(String soyad) {
            this.soyad = soyad;
        }

        //ilgili özellik için get methodu (kapsülleme)
        public String getTelefon() {
            return telefon;
        }

        //ilgili özellik için set methodu (kapsülleme)
        public void setTelefon(String telefon) {
            this.telefon = telefon;
        }
        
        //bir üst sınıfın ilgili methodunun ezilmesi ile şuanki sınıftaki methodun geçerli olması
        @Override
        public void setId(int Id) {
            super.setId(Id);
        }
        //bir üst sınıfın ilgili methodunun ezilmesi ile şuanki sınıftaki methodun geçerli olması
        @Override
        public int getId() {
            return super.getId();
        }
        //bir üst sınıfın ilgili methodunun ezilmesi ile şuanki sınıftaki methodun geçerli olması
        //bu method ile bu sınıftan tanımlanan nesne bir string işleminde çağrıldığında buradaki değer döner
        //örnek : System.out.println(musteri); burada musteri nesnesinin toString methodundan dönen değer basılır
        @Override
        public String toString() {
            return "Id=" + super.getId() + ", ad=" + ad + ", soyad=" + soyad + ", telefon=" + telefon;
        }

    }

    //Controller_Musteri sınıfı : Kontrol,Sil,Guncelle,Ara,Listele işlemlerinin yapıldığı sınıf, 
    //Interface_Controller den Model_Musteri ile implemente edilmiştir
    static class Controller_Musteri implements Interface_Controller<Model_Musteri> {
        //gelen parametredeki listedeki değerleri tek tek ekrana yazdırma
        @Override
        public void Listele(ArrayList<Model_Musteri> liste) {
            for (Model_Musteri model_Musteri : liste) {
                System.out.println(model_Musteri);
            }
        }
        
        //gelen liste parametresindeki tüm kayıtları gezip yine parametre olarak gelen kayit nesnesinin ilgili özelliği ile karşılaştırma
        //(işlem başarılı ise geriye ilgili kaydın index değeri döner)
        @Override
        public int Kontrol(ArrayList<Model_Musteri> liste, Model_Musteri kayit) {
            for (int i = 0; i < liste.size(); i++) {
                if (liste.get(i).getId() == kayit.getId()) {
                    return i;
                }
            }
            return -1;
        }

        //gelen liste parametresindeki tüm kayıtları gezip yine parametre olarak gelen kayit nesnesinin ilgili özelliği ile karşılaştırma
        //karşılaştırma işleminden sonra yeni bilgileri ilgili kayda işleme (işlem başarılı ise geriye ilgili kaydın index değeri döner)
        @Override
        public int Guncelle(ArrayList<Model_Musteri> liste, Model_Musteri kayit) {
            for (int i = 0; i < liste.size(); i++) {
                if (liste.get(i).getId() == kayit.getId()) {
                    liste.get(i).setAd(kayit.getAd());
                    liste.get(i).setSoyad(kayit.getSoyad());
                    liste.get(i).setTelefon(kayit.getTelefon());
                    return i;
                }
            }
            return -1;
        }
        
        //gelen liste parametresindeki tüm kayıtları gezip yine parametre olarak gelen kayit nesnesinin ilgili özelliği ile karşılaştırma
        //karşılaştırma işleminden sonra ilgili kaydın silinmesi (işlem başarılı ise geriye true döner)
        @Override
        public boolean Sil(ArrayList<Model_Musteri> liste, Model_Musteri kayit) {
            for (int i = 0; i < liste.size(); i++) {
                if (liste.get(i).getId() == kayit.getId()) {
                    liste.remove(i);
                    return true;
                }
            }
            return false;
        }

        //gelen liste parametresindeki tüm kayıtları gezip yine parametre olark gelen aranan değere göre karşılaştıma yapıp
        //karşılaştırma işleminden sonra kayıtları listeleme ve kayıt adedini geriye döndürme
        @Override
        public int Ara(ArrayList<Model_Musteri> liste, String aranan) {
            int adet = 0;
            for (Model_Musteri model_Musteri : liste) {
                if (model_Musteri.getAd().equals(aranan) || model_Musteri.getSoyad().equals(aranan) || model_Musteri.getTelefon().equals(aranan)) {
                    System.out.println(model_Musteri);
                    adet++;
                }
            }
            return adet;
        }

    }

    //main methodu : program ilk açılışta bu methodu çalıştırır
    public static void main(String[] args) {
        Menu();
    }

    //menu methodu : ilgili işlemlerin yapılması için menu tasarımı ve seçim işlemleri
    static void Menu() {
        //yeni bir müşteri nesnesi tanımlama
        Model_Musteri musteri = new Model_Musteri();
        //yeni bir controller nesnesi tanımlama
        Controller_Musteri controller_Musteri = new Controller_Musteri();
        String aranan;
        //menü tasarımı
        System.out.println("1) Müşteri Ekle");
        System.out.println("2) Müşteri Güncelle");
        System.out.println("3) Müşteri Sil");
        System.out.println("4) Müşteri Ara");
        System.out.println("5) Müşterileri Listele");
        System.out.println("0) Çıkış");
        System.out.print("Seçim : ");
        int secim = scanner.nextInt();

        //seçim kontrol işlemi
        switch (secim) {
            case 0:
                System.out.println("Çıkılıyor...");
                System.exit(0);
                break;
            case 1:
                //gelen girdileri müşteri nesnesine işleme ve ardından listeye ekleme
                System.out.print("Id : ");
                musteri.setId(scanner.nextInt());
                if (controller_Musteri.Kontrol(musteriler, musteri) != -1) {
                    System.out.println("Aynı Id değerine sahip kayıt bulunmakta !");
                    Menu();
                }
                System.out.print("Ad : ");
                musteri.setAd(scanner.next());
                System.out.print("Soyad : ");
                musteri.setSoyad(scanner.next());
                System.out.print("Telefon : ");
                musteri.setTelefon(scanner.next());
                musteriler.add(musteri);
                break;
            case 2:
                //gelen girdileri müşteri nesnesine işleme ve ardından ilgili kaydı güncelleme
                System.out.print("Id : ");
                musteri.setId(scanner.nextInt());
                if (controller_Musteri.Kontrol(musteriler, musteri) == -1) {
                    System.out.println("Müşteri bulunamadı !");
                    Menu();
                }
                System.out.print("Ad : ");
                musteri.setAd(scanner.next());
                System.out.print("Soyad : ");
                musteri.setSoyad(scanner.next());
                System.out.print("Telefon : ");
                musteri.setTelefon(scanner.next());
                controller_Musteri.Guncelle(musteriler, musteri);
                break;
            case 3:
                //müşteri nesnesine Id değerini işleyip ilgili methoda gönderek sonuca göre silme işilemi yapma
                //methoddan dönen değer kaydın listedeki index değeridir
                System.out.print("Id : ");
                musteri.setId(scanner.nextInt());
                if (controller_Musteri.Kontrol(musteriler, musteri) == -1) {
                    System.out.println("Müşteri bulunamadı !");
                    Menu();
                }
                controller_Musteri.Sil(musteriler, musteri);
                break;
            case 4:
                //girilen ad veya soyad veya telefon bilgisinden herhangi biri ile eşleşen kayıtları listeleme
                System.out.print("Ara (Ad,Soyad,Telefon) : ");
                aranan = scanner.next();
                //ilgili method bulunan kayıt adedini geri döndürdüğü için bu değer bir değişkende depolanıyor
                //ve kontrol işlemi için kullanılıyor
                int adet = controller_Musteri.Ara(musteriler, aranan);
                if (adet == 0) {
                    System.out.println("Arama sonucu boş !");
                    Menu();
                }
                System.out.println(adet + " adet kayit bulundu.");
                break;
            case 5:
                //ilgili method çağrılarak listeleme işlemi yapılıyor
                controller_Musteri.Listele(musteriler);
                break;
            default:
                System.out.println("Hatalı seçim!");
                break;
        }
        System.out.println();
        //işlem bitince menü tekrar çağrılıyor
        Menu();
    }
}
