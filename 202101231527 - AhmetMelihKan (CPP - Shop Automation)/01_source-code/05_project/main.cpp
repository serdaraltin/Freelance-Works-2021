#include <iostream>
#include <iomanip>
#include <string.h>
#include <locale.h>
#include <conio.h>

#define SEPET_BOYUT 30

using namespace std;

double marketF[] = {1.5, 0.5, 1.0, 2.0, 5.0,
                    1.0, 4.0, 8.0, 2.0, 1.5,
                    0.8, 1.6, 3.5, 2.80, 3.0, 2.5};
string marketTxt[] = {"Domates","Kabak","Havuç","Patlýcan","Iceberg",
"Salatalýk","Marul","Lahana","Elma","Portakal",
"Mandalina","Armut","Cips","Kola","IceTea","Kek"};

int sepet[SEPET_BOYUT][2];
int indexSepet = 0;

void listele();
void ekle(int no);
void menu();
void sepettekiUrunler();

int main()
{
	setlocale(LC_ALL,"Turkish");
    menu();
}

void menu()
{
    listele();
    int uzunluk = sizeof(marketTxt) / sizeof(string);
    cout << "Malzeme Secin:";
    int secim;
    cin >> secim;
    if (cin.fail() || secim < 1 || secim > uzunluk)
    {
        cin.clear();
        cin.ignore();
        cout << endl
             << "Hatali bir islem yaptiniz! Tekrar deneyin.";
        getch();
        menu();
        return;
    }
    ekle(secim);
    menu();
}

void ekle(int no)
{
    no--;
    cout << endl
         << marketTxt[no] << "(Adet " << marketF[no] << " TL) Adedi Girin:";
    int adet;
    cin >> adet;
    if (cin.fail())
    {
        cin.clear();
        cin.ignore();
        cout << endl
             << "Hatali bir islem yaptiniz! Tekrar deneyin." << endl;
        ekle(no + 1);
        return;
    }

    sepet[indexSepet][0] = no;
    sepet[indexSepet++][1] = adet;

    listele();
    cout << "Urun Sepete Eklendi" << endl
         << endl;
    while (true)
    {

        cout << "Baska Urun Eklemek Ister misiniz (y/n)?";
        string cevap;
        cin >> cevap;
        if (cevap == "y" || cevap == "Y")
        {
            return;
        }
        else if (cevap == "n" || cevap == "N")
        {
            sepettekiUrunler();
            break;
        }
        else
        {
            cin.clear();
            cin.ignore();
            cout << endl
                 << "Hatali bir islem yaptiniz! Tekrar deneyin." << endl<<endl;
        }
    }
}

void listele()
{
    system("CLS");
    cout << " __________________________________________Sepetteki Urun [ " << indexSepet << " ]____" << endl;
    printf("|%66s|\n", "");
    printf("|%66s|\n", "");
    int uzunluk = sizeof(marketTxt) / sizeof(string);
    int i, j;
    for (i = 0; i < uzunluk / 4; i++)
    {
        cout << "|  ";
        for (j = i; j < 16; j += 4)
        {
            printf("%d.%s\t%3s", (j + 1), marketTxt[j].c_str(), "");
        }
        cout << "|" << endl;
    }
    printf("|%66s|\n", "");
    printf("|%66s|\n", "");
    cout << " __________________________________________________________________" << endl
         << endl;
}

void sepettekiUrunler()
{
	system("CLS");
    cout << " __________________________________________________________________" << endl;
    printf("|%66s|\n|", "");
    cout.width(40);
    cout << "Sepetteki Urunler";
    cout.width(27);
    cout << " |" << endl;
    printf("|%66s|\n", "");
    cout << " __________________________________________________________________" << endl
         << endl;

    int i, a, b;
    float toplam = 0;
    float fiyat = 0;
    for (i = 0; sepet[i][1] != 0; i++)
    {
        a = sepet[i][0];
        b = sepet[i][1];
        fiyat = marketF[a] * b;
        toplam += fiyat;
        cout << "   " << marketTxt[a];
        if (strlen(marketTxt[a].c_str()) < 5)
            cout << "\t";
        cout << "\tx " << b;

        cout << "\t" << marketF[a] << " TL x " << b << " = " << fiyat << " TL" << endl;
    }
    cout << " __________________________________________________________________" << endl
         << endl;
    cout << "   TOPLAM\t\t\t\t\t\t" << toplam << " TL" << endl
         << endl;

    cout << "Cikmak icin herhangi bir tusa basin";
    getch();
    exit(0);
}
