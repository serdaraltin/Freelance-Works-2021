using System;
using System.Collections;


namespace AracOtomasyon
{
    class Program
    {
        //Kayıtların tutulduğu listeler
        static ArrayList arabalar = new ArrayList();
        static ArrayList sirketler = new ArrayList();
        static ArrayList musteriler = new ArrayList();
        static ArrayList siparisler = new ArrayList();
        static ArrayList servisler = new ArrayList();

        //başlangıç methodu
        static void Main(string[] args)
        {
            //Test kayıtları, örnek olması için eklenmiştir, 19-22 satırları silinebilir
            arabalar.Add(new object[] { "hundai", "elentra", "yeşil", 22000, "düz", "full", 1.8, 75, 178 });
            sirketler.Add(new object[] { "otosan", "ankara", 45, 172, 13, 287 });
            musteriler.Add(new object[] { "ahmet", "yağız", 78000, "12345678927", "05451237865", "ahmet@gmail.com", "istanbul" });
            siparisler.Add(new object[] { 0, 0, "2021.01.08", 22000 });
            Menu();
        }
        //Menü
        static void Menu()
        {
            Console.WriteLine("1) Araba Ekle");
            Console.WriteLine("2) Arabalari Listele");
            Console.WriteLine("3) Şirketi Ekle");
            Console.WriteLine("4) Şirketleri Listele");
            Console.WriteLine("5) Müşteri Ekle");
            Console.WriteLine("6) Müşterileri Listele");
            Console.WriteLine("7) Sipariş Ekle");
            Console.WriteLine("8) Siparişleri Listele");
            Console.WriteLine("9) Servis Kaydı Ekle");
            Console.WriteLine("10) Servis Kayıtlarını Listele");
            Console.WriteLine("0) Çıkış");

            Console.Write("Seçim : ");
            int secim = Convert.ToInt32(Console.ReadLine());

            switch (secim)
            {
                case 0:
                    return;
                case 1:
                    EkleAraba();
                    break;
                case 2:
                    ListeleAraba();
                    break;
                case 3:
                    EkleSirket();
                    break;
                case 4:
                    ListeleSirket();
                    break;
                case 5:
                    EkleMusteri();
                    break;
                case 6:
                    ListeleMusteri();
                    break;
                case 7:
                    EkleSiparis();
                    break;
                case 8:
                    ListeleSiparis();
                    break;
                case 9:
                    EkleServis();
                    break;
                case 10:
                    ListeleServis();
                    break;
                default:
                    Console.WriteLine("Hatalı seçim !!!");
                    break;
            }
            Menu();
        }
        //Araba işlemleri
        static void EkleAraba()
        {
            object[] araba = new object[9];
            Console.Write("\nMarka         : ");
            araba[0] = Console.ReadLine();
            Console.Write("Model         : ");
            araba[1] = Console.ReadLine();
            Console.Write("Renk          : ");
            araba[2] = Console.ReadLine();
            Console.Write("Fiyat         : ");
            araba[3] = float.Parse(Console.ReadLine());
            Console.Write("Şanzıman Türü : ");
            araba[4] = Console.ReadLine();
            Console.Write("Paket         : ");
            araba[5] = Console.ReadLine();
            Console.Write("Motor Hacmi   : ");
            araba[6] = float.Parse(Console.ReadLine());
            Console.Write("Beygir Gücü   : ");
            araba[7] = Convert.ToInt32(Console.ReadLine());
            Console.Write("Tork          : ");
            araba[8] = Convert.ToInt32(Console.ReadLine());
            arabalar.Add(araba);
        }
        //ilgili kayda ait bilgileri yazdırma
        static void YazdirAraba(object[] araba, int no)
        {
            Console.WriteLine("\nNo            : " + no);
            Console.WriteLine("Marka         : " + araba[0]);
            Console.WriteLine("Model         : " + araba[1]);
            Console.WriteLine("Renk          : " + araba[2]);
            Console.WriteLine("Fiyat         : " + araba[3]);
            Console.WriteLine("Şanzıman Türü : " + araba[4]);
            Console.WriteLine("Paket         : " + araba[5]);
            Console.WriteLine("Motor Hacmi   : " + araba[6]);
            Console.WriteLine("Beygir Gücü   : " + araba[7]);
            Console.WriteLine("Tork          : " + araba[8] + "\n");
        }
        //ilgili listedeki tüm kayıtları listeleme
        static void ListeleAraba()
        {
            for (int i = 0; i < arabalar.Count; i++)
            {
                YazdirAraba((object[])arabalar[i], i);
            }
        }
        //Şirket işlemleri
        static void EkleSirket()
        {
            object[] sirket = new object[6];
            Console.Write("\nŞirket Adı      : ");
            sirket[0] = Console.ReadLine();
            Console.Write("Bayi Adres      : ");
            sirket[1] = Console.ReadLine();
            Console.Write("Stok Miktar     : ");
            sirket[2] = Console.ReadLine();
            Console.Write("Çalışan Sayı    : ");
            sirket[3] = float.Parse(Console.ReadLine());
            Console.Write("Model Çeşitleri : ");
            sirket[4] = Console.ReadLine();
            Console.Write("Depo Araç Sayi  : ");
            sirket[5] = Console.ReadLine();
            sirketler.Add(sirket);
        }
        //ilgili listedeki tüm kayıtları listeleme
        static void ListeleSirket()
        {
            for (int i = 0; i < sirketler.Count; i++)
            {
                YazdirSirket((object[])sirketler[i], i);
            }
        }
        //ilgili kayda ait bilgileri yazdırma
        static void YazdirSirket(object[] sirket, int no)
        {
            Console.WriteLine("\nNo              : " + no);
            Console.WriteLine("Şirket Adı      : " + sirket[0]);
            Console.WriteLine("Bayi Adres      : " + sirket[1]);
            Console.WriteLine("Stok Miktar     : " + sirket[2]);
            Console.WriteLine("Çalışan Sayı    : " + sirket[3]);
            Console.WriteLine("Model Çeşitleri : " + sirket[4]);
            Console.WriteLine("Depo Araç Sayı  : " + sirket[5] + "\n");
        }
        //Müşteri işlemleri
        static void EkleMusteri()
        {
            object[] musteri = new object[7];
            Console.Write("\nAd       : ");
            musteri[0] = Console.ReadLine();
            Console.Write("Soyad      : ");
            musteri[1] = Console.ReadLine();
            Console.Write("Para       : ");
            musteri[2] = float.Parse(Console.ReadLine());
            Console.Write("TC Kimlik  : ");
            musteri[3] = Console.ReadLine();
            Console.Write("Telefon No : ");
            musteri[4] = Console.ReadLine();
            Console.Write("E-posta    : ");
            musteri[5] = Console.ReadLine();
            Console.Write("Adres      : ");
            musteri[6] = Console.ReadLine();
            musteriler.Add(musteri);
        }
        //ilgili listedeki tüm kayıtları listeleme
        static void ListeleMusteri()
        {
            for (int i = 0; i < musteriler.Count; i++)
            {
                YazdirMusteri((object[])musteriler[i], i);
            }
        }
        static void YazdirMusteri(object[] musteri, int no)
        {
            Console.WriteLine("\nNo         : " + no);
            Console.WriteLine("Ad         : " + musteri[0]);
            Console.WriteLine("Soyad      : " + musteri[1]);
            Console.WriteLine("Para       : " + musteri[2]);
            Console.WriteLine("TC Kimlik  : " + musteri[3]);
            Console.WriteLine("Telefon No : " + musteri[4]);
            Console.WriteLine("E-posta    : " + musteri[5]);
            Console.WriteLine("Adres      : " + musteri[6] + "\n");
        }
        //Sipariş işlemleri
        static void EkleSiparis()
        {
            object[] siparis = new object[4];
            for (int i = 0; i < musteriler.Count; i++)
            {
                Console.WriteLine("\nNo    :" + i);
                Console.WriteLine("Ad    : " + ((object[])musteriler[i])[0]);
                Console.WriteLine("Soyad : " + ((object[])musteriler[i])[1] + "\n");
            }
            Console.Write("Müşteri No    : ");
            int musteriNo = Convert.ToInt32(Console.ReadLine());
            siparis[0] = musteriNo;
            if (musteriNo > musteriler.Count - 1)
            {
                Console.WriteLine("Hatalı musteri no !!!");
                return;
            }
            for (int i = 0; i < arabalar.Count; i++)
            {
                Console.WriteLine("\nNo    :" + i);
                Console.WriteLine("Marka : " + ((object[])arabalar[i])[0]);
                Console.WriteLine("Model : " + ((object[])arabalar[i])[1] + "\n");
            }
            Console.Write("Araba No      : ");
            int arabaNo = Convert.ToInt32(Console.ReadLine());
            siparis[1] = arabaNo;
            if (arabaNo > arabalar.Count - 1)
            {
                Console.WriteLine("Hatalı araba no !!!");
                return;
            }
            int para = Convert.ToInt32(((object[])musteriler[musteriNo])[2]);
            int fiyat = Convert.ToInt32(((object[])arabalar[arabaNo])[3]);
            if (fiyat > para)
            {
                Console.WriteLine("Para yetersiz !");
                return;
            }
            ((object[])musteriler[musteriNo])[2] = para - fiyat;
            Console.Write("Teslim Tarih : ");
            siparis[2] = Console.ReadLine();
            siparis[3] = fiyat;

            siparisler.Add(siparis);
        }
        //ilgili listedeki tüm kayıtları listeleme
        static void ListeleSiparis()
        {
            for (int i = 0; i < siparisler.Count; i++)
            {
                YazdirSiparis((object[])siparisler[i], i);
            }
        }
        //ilgili kayda ait bilgileri yazdırma
        static void YazdirSiparis(object[] siparis, int no)
        {
            Console.WriteLine("\nNo           : " + no);
            int musteriNo = Convert.ToInt32(siparis[0]);
            string musteriAd = ((object[])musteriler[musteriNo])[0].ToString();
            string musteriSoyad = ((object[])musteriler[musteriNo])[1].ToString();

            int arabaNo = Convert.ToInt32(siparis[1]);
            string arabaMarka = ((object[])arabalar[arabaNo])[0].ToString();
            string arabaModel = ((object[])arabalar[arabaNo])[1].ToString();
            Console.WriteLine("Müşter No    : " + musteriAd + " " + musteriSoyad);
            Console.WriteLine("Araç         : " + arabaMarka + " " + arabaModel);
            Console.WriteLine("Teslim Tarih : " + siparis[2]);
            Console.WriteLine("Toplam Ücret : " + siparis[3] + "\n");

        }
        //Servis işlemleri
        static void EkleServis()
        {
            object[] servis = new object[7];

            for (int i = 0; i < siparisler.Count; i++)
            {
                Console.WriteLine("\nNo           : " + i);
                object[] siparis = (object[])siparisler[0];
                int musteriNo = Convert.ToInt32(siparis[0]);
                string musteriAd = ((object[])musteriler[musteriNo])[0].ToString();
                string musteriSoyad = ((object[])musteriler[musteriNo])[1].ToString();

                int arabaNo = Convert.ToInt32(siparis[1]);
                string arabaMarka = ((object[])arabalar[arabaNo])[0].ToString();
                string arabaModel = ((object[])arabalar[arabaNo])[1].ToString();

                Console.WriteLine("...Müşter No    : " + musteriAd + " " + musteriSoyad);
                Console.WriteLine("...Araç         : " + arabaMarka + " " + arabaModel);
            }

            Console.Write("\nSiparis No   : ");
            servis[0] = Convert.ToInt32(Console.ReadLine());
            if (Convert.ToInt32(servis[0]) > siparisler.Count - 1)
            {
                Console.WriteLine("Hatalı seçim !!!");
                return;
            }
            Console.Write("Bakım Fiyat  : ");
            servis[1] = Convert.ToInt32(Console.ReadLine());
            Console.Write("Onarım Fiyat : ");
            servis[2] = Convert.ToInt32(Console.ReadLine());
            Console.Write("Parça Fiyat  : ");
            servis[3] = Convert.ToInt32(Console.ReadLine());
            Console.Write("Parça Stok   : ");
            servis[4] = Convert.ToInt32(Console.ReadLine());
            Console.Write("Parça Çesit  : ");
            servis[5] = Convert.ToInt32(Console.ReadLine());

            servis[6] = Convert.ToInt32(servis[1]) + Convert.ToInt32(servis[2]) + Convert.ToInt32(servis[3]);

            servisler.Add(servis);

        }
        //ilgili listedeki tüm kayıtları listeleme
        static void ListeleServis()
        {
            for (int i = 0; i < servisler.Count; i++)
            {
                YazdirServis((object[])servisler[i], i);
            }
        }
        //ilgili kayda ait bilgileri yazdırma
        static void YazdirServis(object[] servis, int no)
        {
            Console.WriteLine("\nNo           : " + no);
            object[] siparis = (object[])siparisler[Convert.ToInt32(servis[0])];
            int musteriNo = Convert.ToInt32(siparis[0]);
            string musteriAd = ((object[])musteriler[musteriNo])[0].ToString();
            string musteriSoyad = ((object[])musteriler[musteriNo])[1].ToString();

            
            int arabaNo = Convert.ToInt32(siparis[1]);
            string arabaMarka = ((object[])arabalar[arabaNo])[0].ToString();
            string arabaModel = ((object[])arabalar[arabaNo])[1].ToString();

            Console.WriteLine("Müşter No    : " + musteriAd + " " + musteriSoyad);
            Console.WriteLine("Araç         : " + arabaMarka + " " + arabaModel);
            Console.WriteLine("Bakım Fiyat  : " + servis[1]);
            Console.WriteLine("Onarım Fiyat : " + servis[2]);
            Console.WriteLine("Parça Fiyat  : " + servis[3]);
            Console.WriteLine("Parça Stok   : " + servis[4]);
            Console.WriteLine("Parça Çesit  : " + servis[5]);
            Console.WriteLine("Toplam Fiyat : " + servis[6] + "\n");
        }
    }
}
