using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace KanBagis
{

    class Program
    {
        static string kAd = "kullanici", kParola = "12345";
        static string yAd = "yonetici", yParola = "12345";

        //no, bağışçı(tcno,ad,soyad,yas), kan grubu(a/b/rh), bağış tarihi(01.01.2021)

        static object[] bagis = new object[6];
        static object[] liste = new object[100];
        static int indexListe = 0;

        static void Main(string[] args)
        {
            DosyaOku();
            Console.Write("Giris Adi : ");
            string ad = Console.ReadLine();
            Console.Write("Parola : ");
            string parola = Console.ReadLine();

            if (yAd == ad && yParola == parola)
            {
                Console.WriteLine("Yönetici olarak giriş yapıldı.\n");
                YoneticiMenu();
            }
            if (kAd == ad && kParola == parola)
            {
                Console.WriteLine("Kullanıcı olarak giriş yapıldı.\n");
                KullaniciMenu();
            }
            Console.WriteLine("Girilen bilgiler hatalıdır !");
            Console.ReadKey();
        }
        static void KullaniciMenu()
        {
            Console.Clear();
            Console.WriteLine("1) Veri Ekleme");
            Console.WriteLine("2) Veri Arama");
            Console.WriteLine("3) Veri Listeleme");
            Console.WriteLine("0) Çıkış");
            Console.Write("Seçim : ");
            int secim = Convert.ToInt32(Console.ReadLine());

            switch (secim)
            {
                case 0:
                    Console.WriteLine("Programdan çıkılıyor...");
                    Environment.Exit(0);
                    break;
                case 1:
                    VeriEkleme();
                    break;
                case 2:
                    VeriArama();
                    break;
                case 3:
                    VeriListeleme();
                    break;
                default:
                    Console.WriteLine("Hatalı seçim !");
                    break;
            }
            Console.WriteLine("Devam etmek için bir tuşa basın.");
            Console.ReadKey();
            KullaniciMenu();
        }
        static void YoneticiMenu()
        {
            Console.Clear();
            Console.WriteLine("1) Veri Ekleme");
            Console.WriteLine("2) Veri Güncelleme");
            Console.WriteLine("3) Veri Arama");
            Console.WriteLine("4) Veri Silme");
            Console.WriteLine("5) Veri Listeleme");
            Console.WriteLine("0) Çıkış");
            Console.Write("Seçim : ");
            int secim = Convert.ToInt32(Console.ReadLine());

            switch (secim)
            {
                case 0:
                    Console.WriteLine("Programdan çıkılıyor...");
                    Environment.Exit(0);
                    break;
                case 1:
                    VeriEkleme();
                    break;
                case 2:
                    VeriGuncelleme();
                    break;
                case 3:
                    VeriArama();
                    break;
                case 4:
                    VeriSilme();
                    break;
                case 5:
                    VeriListeleme();
                    break;
                default:
                    Console.WriteLine("Hatalı seçim !");
                    break;
            }
            Console.WriteLine("Devam etmek için bir tuşa basın.");
            Console.ReadKey();
            YoneticiMenu();
        }
        private static void VeriListeleme()
        {
            if (indexListe == 0)
            {
                Console.WriteLine("Hiç kayıt yok !");
                return;
            }
            for (int i = 0; i < indexListe; i++)
            {
                Console.WriteLine("No   >> " + (i+1));
                VeriYazdir((object[])liste[i]);
            }
        }
        private static void VeriYazdir(object[] veri)
        {
            Console.WriteLine("Tc No     >> " + veri[0]);
            Console.WriteLine("Ad        >> " + veri[1]);
            Console.WriteLine("Soyad     >> " + veri[2]);
            Console.WriteLine("Yas       >> " + veri[3]);
            Console.WriteLine("Kan Grubu >> " + veri[4]);
            Console.WriteLine("Tarih     >> " + veri[5]+"\n");
        }
        private static void VeriEkleme()
        {
            object[] yeni = new object[6];
            Console.Write("Tc No : ");
            yeni[0] = Console.ReadLine();
            Console.Write("Ad : ");
            yeni[1] = Console.ReadLine();
            Console.Write("Soyad : ");
            yeni[2] = Console.ReadLine();
            Console.Write("Yas : ");
            yeni[3] = Convert.ToInt32(Console.ReadLine());
            Console.Write("Kan Grubu : ");
            yeni[4] = Console.ReadLine();
            Console.Write("Tarih : ");
            yeni[5] = Console.ReadLine();

            liste[indexListe++] = yeni;
            DosyaYaz();
            Console.WriteLine("Eklendi.");
        }
        private static void VeriGuncelleme()
        {
            if (indexListe == 0)
            {
                Console.WriteLine("Hiç kayıt yok !");
                return;
            }
            VeriListeleme();
            Console.Write("No : ");
            int no = Convert.ToInt32(Console.ReadLine())-1;
            if(no < 0 || no > indexListe)
            {
                Console.WriteLine("Geçersiz no !");
                VeriGuncelleme();
            }
            object[] yeni = new object[6];
            Console.Write("Tc No : ");
            yeni[0] = Console.ReadLine();
            Console.Write("Ad : ");
            yeni[1] = Console.ReadLine();
            Console.Write("Soyad : ");
            yeni[2] = Console.ReadLine();
            Console.Write("Yas : ");
            yeni[3] = Convert.ToInt32(Console.ReadLine());
            Console.Write("Kan Grubu : ");
            yeni[4] = Console.ReadLine();
            Console.Write("Tarih : ");
            yeni[5] = Console.ReadLine();

            liste[no] = yeni;
            DosyaYaz();
            Console.WriteLine("Güncellendi.");
        }
        private static void VeriArama()
        {
            if (indexListe == 0)
            {
                Console.WriteLine("Hiç kayıt yok !");
                return;
            }
          
            Console.Write("Arama (tcno,ad,soyad,kan grubu) : ");
            string aranan = Console.ReadLine();

            int bulunanAdet = 0;
            for (int i = 0; i < indexListe; i++)
            {
                object[] kayit = (object[])liste[i];
                aranan = aranan.ToLower();
                if(((string)kayit[0]).ToLower().Contains(aranan) ||
                    ((string)kayit[1]).ToLower().Contains(aranan) ||
                    ((string)kayit[2]).ToLower().Contains(aranan) ||
                    ((string)kayit[4]).ToLower().Contains(aranan))
                {
                    VeriYazdir(kayit);
                    bulunanAdet++;
                }
            }
            if(bulunanAdet == 0)
            {
                Console.WriteLine("Kayıt bulunamadı !");
                return;
            }
            Console.WriteLine("Arama Sonucu : " + bulunanAdet+ " kayıt");
        }
        private static void VeriSilme()
        {
            if (indexListe == 0)
            {
                Console.WriteLine("Hiç kayıt yok !");
                return;
            }
            VeriListeleme();
            Console.Write("No : ");
            int no = Convert.ToInt32(Console.ReadLine()) - 1;
            if (no < 0 || no > indexListe)
            {
                Console.WriteLine("Geçersiz no !");
                VeriGuncelleme();
            }
            Console.WriteLine("SİLİNECEK KAYIT >> \n");
            VeriYazdir((object[])liste[no]);
            Console.Write("Silmek istiyor musunuz ? (E/H)");
            if(Console.ReadLine() == "E")
            {
                object[] yeniListe = new object[100];
                int j = 0;
                for (int i = 0; i < indexListe; i++)
                {
                    if (no == j)
                        j++;
                    yeniListe[i] = liste[j];
                }
                indexListe--;
                liste = yeniListe;
                DosyaYaz();
                Console.WriteLine("Silindi.");
                return;
            }
            Console.WriteLine("İptal edildi.");
        }
        private static void DosyaOku()
        {
            string[] satirlar = File.ReadAllLines("veriler.txt");
            foreach(string satir in satirlar)
            {
                if (satir == "")
                    continue;
                object[] kayit = new object[6];
                kayit[0] = satir.Split(',')[0];
                kayit[1] = satir.Split(',')[1];
                kayit[2] = satir.Split(',')[2];
                kayit[3] = satir.Split(',')[3];
                kayit[4] = satir.Split(',')[4];
                kayit[5] = satir.Split(',')[5];

                liste[indexListe++] = kayit;
            }
            return;
        }
        private static void DosyaYaz()
        {
            StreamWriter yaz = new StreamWriter("veriler.txt");
            for (int i = 0; i < indexListe; i++)
            {
                object[] kayit = (object[])liste[i];
                yaz.WriteLine(kayit[0] + "," + kayit[1] + "," + kayit[2] + "," + kayit[3] + "," + kayit[4] + "," + kayit[5]);
            }
            yaz.Close();
            return;
        }
    }
}
