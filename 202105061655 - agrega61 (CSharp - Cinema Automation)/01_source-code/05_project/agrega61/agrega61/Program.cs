using System;
using System.Collections.Generic;
using System.IO;

namespace agrega61
{
    class DosyaIslemleri
    {
        public void DosyaOku(List<Gosterim> gosterimler, List<Bilet> biletler)
        {
            if (!File.Exists("gosterimler.txt") || !File.Exists("sinema.txt"))
            {
                Console.WriteLine("Dosya bulunamadı !!!");
                Console.Read();
                Environment.Exit(0);
            }

            foreach (string satir in File.ReadAllLines("gosterimler.txt"))
            {
                string[] degerler = satir.Split(',');
                gosterimler.Add(new Gosterim(Convert.ToInt32(degerler[0]), degerler[1], degerler[2], degerler[3], Convert.ToInt32(degerler[4])));
            }
            foreach (string satir in File.ReadAllLines("sinema.txt"))
            {
                string[] degerler = satir.Split(',');
                float Fiyat;
                float.TryParse(degerler[5], out Fiyat);
                biletler.Add(new Bilet(gosterimler[Convert.ToInt32(degerler[0])], gosterimler[Convert.ToInt32(degerler[0])].Koltuklar[Convert.ToInt32(degerler[1])],
                    degerler[2], degerler[3], degerler[4], Fiyat));
                gosterimler[Convert.ToInt32(degerler[0])].Koltuklar[Convert.ToInt32(degerler[1])].Durum = true;
            }


        }

        public void DosyaYaz(List<Gosterim> gosterimler, List<Bilet> biletler)
        {
            StreamWriter yazGosterim = new StreamWriter("gosterimler.txt");
            foreach (Gosterim gosterim in gosterimler)
                yazGosterim.WriteLine(gosterim.Koltuklar.Count + "," + gosterim.FilmAdi + "," + gosterim.Seans + "," + gosterim.Tarih + "," + gosterim.SalonNo);
            yazGosterim.Close();

            StreamWriter yazBilet = new StreamWriter("sinema.txt");
            foreach (Bilet bilet in biletler)
            {
                int i = 0;
                foreach (Gosterim gosterim in gosterimler)
                {
                    if (gosterim == bilet.gosterim)
                        yazBilet.WriteLine(i + "," + bilet.koltuk.KoltukNo + "," + bilet.Ad + "," + bilet.Soyad + "," + bilet.TcNo + "," + bilet.Fiyat);
                    i++;
                }

            }
            yazBilet.Close();
        }



    }

    class Koltuk
    {
        public int SiraNo;
        public int KoltukNo;
        public bool Durum;
        public Koltuk()
        {
            SiraNo = 0;
            KoltukNo = 0;
            Durum = false;
        }
        public Koltuk(int _SiraNo, int _KoltukNo)
        {
            SiraNo = _SiraNo;
            KoltukNo = _KoltukNo;
            Durum = false;
        }
        public void YerAyir()
        {
            Durum = true;
        }
        public void Goruntule()
        {
            string sDurum;
            if (Durum)
                sDurum = "Dolu";
            else
                sDurum = "Boş";

            Console.WriteLine("Koltuk No: " + KoltukNo + "\tSıra No : " + SiraNo + "\tDurum : " + sDurum);
        }
    }

    class Gosterim
    {
        public List<Koltuk> Koltuklar = new List<Koltuk>();
        public string FilmAdi;
        public string Seans;
        public string Tarih;
        public int SalonNo;
        public Gosterim()
        {
            FilmAdi = null;
            Seans = null;
            Tarih = null;
            SalonNo = 0;
        }
        public Gosterim(int _KoltukSayisi, string _FilmAdi, string _Seans, string _Tarih, int _SalonNo)
        {
            int j = 1;
            for (int i = 1; i <= _KoltukSayisi; i++)
            {
                Koltuklar.Add(new Koltuk(j, i));
                if (i % 10 == 0)
                    j++;
            }

            FilmAdi = _FilmAdi;
            Seans = _Seans;
            Tarih = _Tarih;
            SalonNo = _SalonNo;
        }
        public void Goruntule()
        {
            Console.WriteLine("Film Adı : " + FilmAdi + "\tSeans\t : " + Seans + "\tTarih : " + Tarih + "\tSalon No : " + SalonNo);
        }

    }

    class Bilet
    {
        public Gosterim gosterim = new Gosterim();
        public Koltuk koltuk = new Koltuk();
        public string Ad;
        public string Soyad;
        public string TcNo;
        public float Fiyat;

        public Bilet()
        {
            gosterim = null;
            koltuk = null;
            Ad = null;
            Soyad = null;
            TcNo = null;
            Fiyat = 0;
        }
        public Bilet(Gosterim _gosterim, Koltuk _koltuk, string _Ad, string _Soyad, string _TcNo, float _Fiyat)
        {
            gosterim = _gosterim;
            koltuk = _koltuk;
            Ad = _Ad;
            Soyad = _Soyad;
            TcNo = _TcNo;
            Fiyat = _Fiyat;
        }
        public void BilgiYazdir()
        {
            Console.WriteLine("\nAd:" + Ad + "\nSoyad:" + Soyad + "\nTc No:" + TcNo + "\nFiyat:" + Fiyat +
                "\n\nFilm Adı : " + gosterim.FilmAdi + "\nSeans\t : " + gosterim.Seans +
                "\nTarih\t : " + gosterim.Tarih + "\nSalon No : " + gosterim.SalonNo +
                "\n\nKoltuk No:" + koltuk.KoltukNo + "\nSıra No:" + koltuk.SiraNo);
        }
        public void Goruntule()
        {
            Console.WriteLine("\nAd :" + Ad + "\nSoyad :" + Soyad + "\nTc No :" + TcNo + "\nFiyat :" + Fiyat +
                "\n\nFilm Adı : " + gosterim.FilmAdi + "\nSeans\t : " + gosterim.Seans +
                "\nTarih\t : " + gosterim.Tarih + "\nSalon No : " + gosterim.SalonNo +
                "\n\nKoltuk No :" + koltuk.KoltukNo + "\nSıra No :" + koltuk.SiraNo);
        }
    }

    class IndirimliBilet : Bilet
    {
        string IndirimKodu;
        float IndirimMiktari;

        public IndirimliBilet()
        {
            IndirimKodu = null;
            IndirimMiktari = 0;
        }
        public IndirimliBilet(string _IndirimKodu, float _IndirimMiktari)
        {
            IndirimKodu = _IndirimKodu;
            IndirimMiktari = _IndirimMiktari;

        }

        public string IndirimKodu1
        {
            get { return IndirimKodu; }
            set { IndirimKodu = value; }
        }

        public float IndirimMiktari1
        {
            get { return IndirimMiktari; }
            set { IndirimMiktari = value; }
        }

    }

    class Program
    {
        public static List<Gosterim> gosterimler = new List<Gosterim>();
        public static List<Bilet> biletler = new List<Bilet>();
        public static List<IndirimliBilet> IndirimliBiletler = new List<IndirimliBilet>();
        static void Main(string[] args)
        {

            DosyaIslemleri dosyaIslem = new DosyaIslemleri();
            dosyaIslem.DosyaOku(gosterimler, biletler);

            Menu();

            Console.Read();
        }

        public static void Menu()
        {
            Console.WriteLine("1) Gösterim Ekle");
            Console.WriteLine("2) Gösterim Görüntüle");
            Console.WriteLine("3) Koltuk Görüntüle");
            Console.WriteLine("4) Bilet Sat");
            Console.WriteLine("5) Bilet Görüntüle");
            Console.WriteLine("6) Gösterimleri Listele");
            Console.WriteLine("7) Biletleri Listele");
            Console.WriteLine("8) Dosyayı Güncelle");
            Console.WriteLine("0) Çıkış");
            Console.Write("\n\nSeçim : ");
            int secim = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("\n\n");
            switch (secim)
            {
                case 0:
                    Environment.Exit(0);
                    break;
                case 1:
                    Console.Clear();
                    Console.Write("Film Adı: ");
                    string FilmAdi = Console.ReadLine();
                    Console.Write("Salon No [1,2,3...]: ");
                    int SalonNo = Convert.ToInt32(Console.ReadLine());
                    Console.Write("Seans [hh:mm] : ");
                    string Seans = Console.ReadLine();
                    Console.Write("Tarih [yyyy.MM.dd] : ");
                    string Tarih = Console.ReadLine();
                    Console.Write("Koltuk Sayısı [10,20,30...]: ");
                    int KoltukSayisi = Convert.ToInt32(Console.ReadLine()) - 1;
                    gosterimler.Add(new Gosterim(KoltukSayisi, FilmAdi, Seans, Tarih, SalonNo));
                    MenuyeDon();
                    break;
                case 2:

                    Console.Clear();
                    Console.Write("Gösterim Numarası : ");
                    int GosterimNo = Convert.ToInt32(Console.ReadLine()) - 1;

                    foreach (Koltuk koltuk in gosterimler[GosterimNo].Koltuklar)
                        koltuk.Goruntule();
                    Console.WriteLine("\n\n\n");
                    gosterimler[GosterimNo].Goruntule();

                    MenuyeDon();
                    break;
                case 3:

                    Console.Clear();
                    Console.Write("Gösterim Numarası : ");
                    GosterimNo = Convert.ToInt32(Console.ReadLine()) - 1;
                    Console.Write("Koltuk Numarası : ");
                    int KoltukNo = Convert.ToInt32(Console.ReadLine()) - 1;

                    gosterimler[GosterimNo].Koltuklar[KoltukNo].Goruntule();

                    MenuyeDon();
                    break;
                case 4:
                    Console.Clear();
                    Console.Write("Gösterim Numarası : ");
                    GosterimNo = Convert.ToInt32(Console.ReadLine()) - 1;
                    Console.Write("Koltuk Numarası : ");
                    KoltukNo = Convert.ToInt32(Console.ReadLine()) - 1;
                    if (gosterimler[GosterimNo].Koltuklar[KoltukNo].Durum)
                    {
                        Console.WriteLine("Seçilen koltuk dolu!!!");
                        MenuyeDon();
                    }
                    gosterimler[GosterimNo].Koltuklar[KoltukNo].Goruntule();
                    Console.Write("Ad : ");
                    string Ad = Console.ReadLine();
                    Console.Write("Soyad : ");
                    string SoyAd = Console.ReadLine();
                    Console.Write("Tc No : ");
                    string TcNo = Console.ReadLine();
                    Console.Write("Fiyat : ");
                    float Fiyat;
                    float.TryParse(Console.ReadLine(), out Fiyat);
                    Console.Write("İndirim Kodu Var mı? [E/H] : ");
                    float IndirimMiktari = 0;
                    if (Console.ReadLine() == "E")
                    {
                        Console.Write("İndirim Kodu [AAA000] : ");
                        string IndirimKodu = Console.ReadLine();
                        Console.Write("İndirim Miktari : ");
                        float.TryParse(Console.ReadLine(), out IndirimMiktari);
                        IndirimliBiletler.Add(new IndirimliBilet(IndirimKodu, IndirimMiktari));
                    }

                    biletler.Add(new Bilet(gosterimler[GosterimNo], gosterimler[GosterimNo].Koltuklar[KoltukNo], Ad, SoyAd, TcNo, Fiyat - IndirimMiktari));
                    gosterimler[GosterimNo].Koltuklar[KoltukNo].Durum = true;
                    MenuyeDon();
                    break;
                case 5:
                    Console.Clear();
                    Console.Write("Bilet Numarası : ");
                    int BiletNo = Convert.ToInt32(Console.ReadLine()) - 1;
                    biletler[BiletNo].Goruntule();
                    MenuyeDon();
                    break;
                case 6:
                    Console.Clear();
                    foreach (Gosterim gosterim in gosterimler)
                    {
                        gosterim.Goruntule();
                    }
                    MenuyeDon();

                    break;
                case 7:
                    Console.Clear();
                    foreach (Bilet bilet in biletler)
                    {
                        bilet.Goruntule();
                    }
                    MenuyeDon();

                    break;
                case 8:
                    Console.Clear();
                    DosyaIslemleri dosyaIslem = new DosyaIslemleri();
                    dosyaIslem.DosyaYaz(gosterimler, biletler);
                    Console.WriteLine("Dosya Güncellendi...");
                    MenuyeDon();
                    break;


            }

        }
        public static void MenuyeDon()
        {
            Console.Write("\n\n\nAna Menüye Dönmek 'ENTER' basın...");
            Console.ReadLine();
            Console.Clear();
            Menu();
        }

    }


}
