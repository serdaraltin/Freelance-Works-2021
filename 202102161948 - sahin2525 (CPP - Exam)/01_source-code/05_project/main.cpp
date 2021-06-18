#include <iostream>
#include <locale.h>
#include <fstream>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>

#define KAPASITE 150

using namespace std;

class Ogrenci
{
public:
    int no;
    string ad, soyad, mail, telefon, dogumTarih;
    int vize, odev, final;
    float gno;
    string harfNotu;
    string durum;

    float gnoHesapla()
    {
        return (0.3 * this->vize) + (0.2 * this->odev) + (0.5 * final);
    }

    string harfNotuHesapla()
    {
        if (gno >= 84 && gno <= 100)
        {
            this->harfNotu == "AA";
        }
        else if (gno >= 77 && gno <= 83)
        {
            this->harfNotu == "AB";
        }
        else if (gno >= 71 && gno <= 76)
        {
            this->harfNotu == "BA";
        }
        else if (gno >= 66 && gno <= 70)
        {
            this->harfNotu == "BB";
        }
        else if (gno >= 61 && gno <= 65)
        {
            this->harfNotu == "BC";
        }
        else if (gno >= 56 && gno <= 60)
        {
            this->harfNotu == "CB";
        }
        else if (gno >= 50 && gno <= 55)
        {
            this->harfNotu == "CC";
        }
        else if (gno >= 46 && gno <= 49)
        {
            this->harfNotu == "CD";
        }
        else if (gno <= 46)
        {
            this->harfNotu == "FF";
        }
        return this->harfNotu;
    }

    string durumHesapla()
    {
        gno = gnoHesapla();
        harfNotuHesapla();
        if (gno >= 55)
        {
            this->durum = "GECTI";
        }
        else
        {
            this->durum = "KALDI";
        }

        return durum;
    }

    Ogrenci(int no, string ad, string soyad, string mail, string telefon, string dogumTarih, int vize, int odev, int final)
    {
        this->no = no;
        this->ad = ad;
        this->soyad = soyad;
        this->mail = mail;
        this->telefon = telefon;
        this->dogumTarih = dogumTarih;
        this->vize = vize;
        this->odev = odev;
        this->final = final;
        durumHesapla();
    }

    void yazdir()
    {
        cout << no << " " << ad << " " << soyad << " " << mail << " " << telefon
             << " " << dogumTarih << " " << vize << " " << odev << " " << final << endl;
    }
    void yazdirNot()
    {
        cout << no << " " << ad << " " << soyad << " " << mail << " " << telefon
             << " " << dogumTarih << " " << vize << " " << odev << " " << final
             << " GNO: " << gno << " " << harfNotu << " " << durum << endl;
    }
};

Ogrenci *kayitlar[KAPASITE];
int kayitIndex = 0;

void dosyaOku()
{
    int no;
    string ad, soyad, mail, telefon, dogumTarih;
    int vize, odev, final;

    ifstream dosya;
    dosya.open("Ogrenciler.dat");

	int satir = 0;
    while (!dosya.eof())
    {
    	if(satir > 2){
    		    dosya >> no >> ad >> soyad >> mail >> telefon >> dogumTarih >> vize >> odev >> final;

        kayitlar[kayitIndex++] = new Ogrenci(no, ad, soyad, mail, telefon, dogumTarih, vize, odev, final);
		}
		string bos;
		getline(dosya,bos);
    satir++;
    }

    dosya.close();
}


void menu();
void program1Menu();
void program2Menu();

int main()
{
    srand(time(0));

    setlocale(LC_ALL, "Turkish");
    dosyaOku();
    menu();
}

void menu()
{
    cout << endl;
    cout << "1) Program 1 (Not Otomasyon)" << endl;
    cout << "2) Program 2 (Rastgele Sayi)" << endl;
    cout << "0) Cikis" << endl;
    cout << "Secim : ";
    int secim;
    cin >> secim;

    switch (secim)
    {
    case 0:
        cout << "Programdan cikiliyor...";
        exit(0);
        break;
    case 1:
        program1Menu();
        break;

    case 2:
        program2Menu();
        break;

    default:
        cout << "Hatali secim !!!" << endl;
        break;
    }

    menu();
}

void ekle();
void tumBilgileriListele();
void kalanOgrencileriListele();
void notlariSonuclandir();

void program1Menu()
{
    cout << endl;
    cout << "1) Kayit Ekle" << endl;
    cout << "2) Tum Bilgileri Listele" << endl;
    cout << "3) Kalan Ogrencileri Listele" << endl;
    cout << "4) Notlari Sonuclandir" << endl;
    cout << "0) Ana Menu" << endl;
    cout << "Secim : ";
    int secim;
    cin >> secim;

    switch (secim)
    {
    case 0:
        return;
        break;
    case 1:
        ekle();
        break;
    case 2:
        tumBilgileriListele();
        break;
    case 3:
        kalanOgrencileriListele();
        break;
    case 4:
        notlariSonuclandir();
        break;
    default:
        cout << "Hatali secim !!!";
        break;
    }

    program1Menu();
}

bool noKontrol(int no)
{
    int i;
    for (i = 0; i < KAPASITE; i++)
    {
        if (kayitlar[i] != NULL && (*kayitlar[i]).no == no)
            return true;
    }
    return false;
}

void ekle()
{
    if (kayitIndex >= KAPASITE)
    {
        cout << "Maksimum kapasiteye ulasilmistir !!!" << endl;
        return;
    }
    cout << ">>> YENI EKLE <<<" << endl
         << endl;
    int no;
    string ad, soyad, mail, telefon, dogumTarih;
    int vize, odev, final;

    cout << "No : ";
    cin >> no;
    if (noKontrol(no))
    {
        cout << "Ayni no' ya sahip ogrenci var !!!";
        return;
    }
    cout << "Ad : ";
    cin >> ad;
    cout << "Soyad : ";
    cin >> soyad;
    cout << "Mail : ";
    cin >> mail;
    cout << "Telefon : ";
    cin >> telefon;
    cout << "Dogum Tarihi (gg/aa/yyyy) : ";
    cin >> dogumTarih;
    cout << "Vize Notu : ";
    cin >> vize;
    cout << "Odev Notu : ";
    cin >> odev;
    cout << "Final Notu : ";
    cin >> final;

    kayitlar[kayitIndex++] = new Ogrenci(no, ad, soyad, mail, telefon, dogumTarih, vize, odev, final);
	
	fstream dosya;
        dosya.open("Ogrenciler.dat", ios::in | ios::out | ios::app);

      dosya <<endl << no << " "<<ad<< " "<<soyad << " "<<mail<< " "<<telefon<< " "<<dogumTarih<< " "<<vize<< " "<<odev<< " "<<final;
        
        dosya.close();
	
    cout << "Yeni kayit eklendi..."<<endl;
    return;
}

void tumBilgileriListele()
{
    cout << ">>> TUM BILGILER LISTE <<<" << endl
         << endl;
    int i;
    for (i = 0; i < KAPASITE; i++)
    {
        if (kayitlar[i] != NULL)
        {
            (*kayitlar[i]).yazdir();
        }
    }
}
void kalanOgrencileriListele()
{
    cout << ">>> KALAN OGRENCILER LISTE <<<" << endl
         << endl;
    int i;
    for (i = 0; i < KAPASITE; i++)
    {
        if (kayitlar[i] != NULL)
        {
            if ((*kayitlar[i]).durum == "KALDI")
                (*kayitlar[i]).yazdir();
        }
    }
}
void notlariSonuclandir()
{
    cout << ">>> NOTLARI SONUCLANDIR <<<" << endl
         << endl;

    fstream gecenler, kalanlar;
    gecenler.open("GECENLER.txt", ios::out);
    kalanlar.open("KALANLAR.txt", ios::out);

    int i;
    for (i = 0; i < KAPASITE; i++)
    {
        if (kayitlar[i] != NULL)
        {
            (*kayitlar[i]).yazdirNot();
            if ((*kayitlar[i]).durum == "KALDI")
            {
                kalanlar << (*kayitlar[i]).no << " " << (*kayitlar[i]).ad << " " << (*kayitlar[i]).soyad << " " << (*kayitlar[i]).mail << " " << (*kayitlar[i]).telefon << " " << (*kayitlar[i]).dogumTarih << " " << (*kayitlar[i]).vize << " " << (*kayitlar[i]).odev << " " << (*kayitlar[i]).final << " " << (*kayitlar[i]).gno << " " << (*kayitlar[i]).durum << " " << endl;
            }
            else
            {
                 gecenler << (*kayitlar[i]).no << " " << (*kayitlar[i]).ad << " " << (*kayitlar[i]).soyad << " " << (*kayitlar[i]).mail << " " << (*kayitlar[i]).telefon << " " << (*kayitlar[i]).dogumTarih << " " << (*kayitlar[i]).vize << " " << (*kayitlar[i]).odev << " " << (*kayitlar[i]).final << " " << (*kayitlar[i]).gno << " " << (*kayitlar[i]).durum << " " << endl;
            }
        }
    }
    gecenler.close();
    kalanlar.close();
}

int Rastgele(int minimum, int maksimum)
{
    return minimum + (rand() % (maksimum - minimum + 1));
}

void program2Menu()
{
    cout << endl;
    cout << "Ana menuye donmek ister misiniz? (e/h) ";
     char anamenu;
    cin >> anamenu;
    if (anamenu == 'e' || anamenu == 'E')
    {
    	return;
    }
    cout << "Minimum deger giriniz: ";
    int minimum;
    cin >> minimum;
    cout << "Maksimum deger giriniz: ";
    int maksimum;
    cin >> maksimum;
    cout << "Uretilecek sayi adedi: ";
    int adet;
    cin >> adet;

    int sayilar[adet] = {0};

    cout << endl
         << "Uretilen Sayilar" << endl;
    int i, toplam = 0;
    float ortalama;
    for (i = 0; i < adet; i++)
    {
        sayilar[i] = Rastgele(minimum, maksimum);
        cout << sayilar[i] << endl;
        toplam += sayilar[i];
    }
    ortalama = (float)toplam / (float)adet;
    cout << endl;
    cout << "Uretilen " << adet << " adet sayinin ortalamasi: " << ortalama << endl;
    cout << "Sayilar dosyaya yazilsin mi? (e/h) ";
    char yazmaCevap;
    cin >> yazmaCevap;
    if (yazmaCevap == 'e' || yazmaCevap == 'E')
    {
        fstream dosya;
        dosya.open("Rastgele.txt", ios::in | ios::out | ios::app);

        for (i = 0; i < adet; i++)
        {
            dosya << sayilar[i] << " ";
        }
        dosya << ortalama << endl;
        dosya.close();
        cout << "Sayilar dosyaya yazildi..." << endl;
    }

    program2Menu();
}
