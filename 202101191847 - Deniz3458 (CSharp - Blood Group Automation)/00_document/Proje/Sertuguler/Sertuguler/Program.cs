using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Sertuguler
{
    class Program
    {

        static void Main(string[] args)
        {
            Kayıt ktp = new Kayıt();
            string giris;
            while (1 == 1)
            {
                Console.Clear();
                Console.WriteLine("Giriş Yapınız");
                giris = Console.ReadLine();
                if (giris == "123")
                {
                    string ksecim;
                    Console.Clear();
                    Console.WriteLine("Kullanıcı Girişine Hoş Geldiniz Bir İşlem Seçiniz.");
                    Console.WriteLine("1--->Veri Girişi");
                    Console.WriteLine("2--->Veri Güncelle");
                    Console.WriteLine("3--->Veri Listeleme");
                    Console.WriteLine("4--->Çıkış");
                    ksecim=Console.ReadLine();
                    if (ksecim == "1")
                    {
                        Console.Clear();

                        Console.WriteLine("ID no nuz:");
                        string ıd = Console.ReadLine();
                        ktp.KayıtEkle(ıd);

                        Console.WriteLine("Kan Grubunuz:");
                        string kan = Console.ReadLine();
                        ktp.KayıtEkle(kan);

                        Console.WriteLine("Rh değeriniz:");
                        string rh = Console.ReadLine();
                        ktp.KayıtEkle(rh);

                        Console.WriteLine("Telefon Numaranız:");
                        string tel = Console.ReadLine();
                        ktp.KayıtEkle(tel);


                        Console.WriteLine("Kayıt Editilmiştir.");
                    }
                    else if (ksecim == "2")
                    {
                        Console.Clear();

                        Console.WriteLine("Id ile güncelle:");
                        string ıd = Console.ReadLine();
                        ktp.KayıtGüncelle(ıd);
                        Console.WriteLine("Kayıt Güncellenmiştir.");
                    }
                    else if (ksecim == "3")
                    {
                        ktp.dosyadanOku();
                    }
                    else if (ksecim=="4")
                    {
                        Environment.Exit(0);
                    }
                }
                else
                    Console.WriteLine("Yanlıs deger girildi tekrar giris yapınız");
                if (giris=="1234")
                {
                    string ksecim;
                    int sayi1 = 0;
                    Console.Clear();
                    Console.WriteLine("Yönetici Girişine Hoş Geldiniz Bir İşlem Seçiniz.");
                    Console.WriteLine("1--->Veri Girişi");
                    Console.WriteLine("2--->Veri Güncelle");
                    Console.WriteLine("3--->Veri Sil");
                    Console.WriteLine("4--->Veri Listeleme");
                    Console.WriteLine("5--->Çıkış");
                    ksecim = Console.ReadLine();
                    if (ksecim == "1")
                    {
                        Console.Clear();

                        Console.WriteLine("ID no nuz: {0}", ++sayi1);
                        string ıd = Console.ReadLine();
                        ktp.KayıtEkle(ıd);

                        Console.WriteLine("Kan Grubunuz:");
                        string kan = Console.ReadLine();
                        ktp.KayıtEkle(kan);

                        Console.WriteLine("Rh değeriniz:");
                        string rh = Console.ReadLine();
                        ktp.KayıtEkle(rh);

                        Console.WriteLine("Telefon Numaranız:");
                        string tel = Console.ReadLine();
                        ktp.KayıtEkle(tel);


                        Console.WriteLine("Kayıt Editilmiştir.");
                    }
                    else if (ksecim == "2")
                    {
                        Console.Clear();

                        Console.WriteLine("Id ile güncelle:");
                        string ıd = Console.ReadLine();
                        ktp.KayıtGüncelle(ıd);
                        Console.WriteLine("Kayıt Güncellenmiştir.");
                    }
                    else if (ksecim == "3")
                    {
                        
                        Console.Clear();
                        Console.WriteLine("Silmek İstediğiniz Id:");
                        string ıd = Console.ReadLine();
                        Console.Write("Kayıt silinsin mi?(e/h) ");
                        int cevap = char.Parse(Console.ReadLine());
                        if (cevap == 'e')
                        {
                            File.WriteAllLines("VeriEkleme.txt", File.ReadAllLines("VeriEkleme.txt").Where(s => !s.StartsWith(ıd + ";")));
                            Console.WriteLine("Kayıt Silinmiştir");
                        }
                        else
                            Environment.Exit(0);
                        
                    }
                    else if (ksecim == "4")
                    {
                        Console.Clear();
                        ktp.dosyadanOku();
                    }
                    else if (ksecim == "5")
                    {
                        Environment.Exit(0);
                    }
                    Console.ReadKey();
                }
                else
                    Console.WriteLine("Yanlıs deger girildi tekrar giris yapınız");
                
            }
            

        }

    }
}
