#include <iostream>
#include <string>

#define MAXHESAP 50
#define MAXISLEM 100

using namespace std;

const int monthDays[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

struct Date {
    int d, m, y;
};

int countLeapYears(Date d) {
    int years = d.y;
    if (d.m <= 2)
        years--;
    return years / 4
            - years / 100
            + years / 400;
}

int getDifference(Date dt1, Date dt2) {
    long int n1 = dt1.y * 365 + dt1.d;
    for (int i = 0; i < dt1.m - 1; i++)
        n1 += monthDays[i];
    n1 += countLeapYears(dt1);
    long int n2 = dt2.y * 365 + dt2.d;
    for (int i = 0; i < dt2.m - 1; i++)
        n2 += monthDays[i];
    n2 += countLeapYears(dt2);
    return (n2 - n1);
}

struct Date mevcutTarih = {01, 01, 2021};

struct Islem {
    string tur;
    int miktar;
};

class Hesap {
    int hesapNo;
    int bakiye;
    int kar;
    struct Date tarih;
    bool vadesizFaizli = false;
public:
    struct Islem *islemler[MAXISLEM];
    int islemAdet = 0;

    Hesap() {
    }

    Hesap(int hesapNo, int bakiye, Date tarih) :
    hesapNo(hesapNo), bakiye(bakiye), tarih(tarih) {
        islemler[islemAdet++] = new Islem{"Olusturma", bakiye};
    }

    void mevduat(int yatirilanPara) {
        this->bakiye += yatirilanPara;
        islemler[islemAdet++] = new Islem{"Mevduat", yatirilanPara};
    }

    bool cekmek(int cekilenPara) {
        if (cekilenPara > this->bakiye) {
            cout << "Bakiye:" << this->bakiye << "\nYeterli bakiye bulunmamakta !" << endl;
            islemler[islemAdet++] = new Islem{"Cekme (Yetersiz Miktar)", cekilenPara};
            return false;
        }
        this->bakiye -= cekilenPara;
        islemler[islemAdet++] = new Islem{"Cekme", cekilenPara};
        return true;
    }

    int getAnlikBakiye() {
        return this->bakiye;
    }

    const int getHesapNo() {
        return this->hesapNo;
    }

    virtual int Kar() {
        int karMiktar = 0;
        return karMiktar;
    }

    string getOlusturulma() {
        string olusturulma = to_string(tarih.d) + "." + to_string(tarih.m) + "." + to_string(tarih.y);
        return olusturulma;
    }

    Date getTarih() const {
        return tarih;
    }

    void setIslemler(string tur, int miktar) {
        this->islemler[islemAdet++] = new Islem{tur, miktar};
    }

    int getIslemAdet() const {
        return islemAdet;
    }

    void setVadesizFaizli(bool vadesizFaizli) {
        this->vadesizFaizli = vadesizFaizli;
    }

    bool isVadesizFaizli() const {
        return vadesizFaizli;
    }


};

class KisaVadeli : public Hesap {
    int minBakiye = 1000;
    int faiz = 17;

public:

    KisaVadeli() :
    Hesap() {
    }

    KisaVadeli(int hesapNo, int bakiye, Date tarih) :
    Hesap(hesapNo, bakiye, tarih) {
    }

    int Kar() {
        if (this->getAnlikBakiye() < minBakiye) {
            cout << "Bakiye:" << this->getAnlikBakiye() << "\nYeterli bakiye bulunmamakta !" << endl;
            return 0;
        }
        float gunlukFaiz = ((this->getAnlikBakiye() / 100) * faiz) / 365.0;
        int gunSayisi = getDifference(this->getTarih(), mevcutTarih);
        return gunlukFaiz*gunSayisi;
    }

    int GetFaiz() const {
        return faiz;
    }

    int GetMinBakiye() const {
        return minBakiye;
    }

};

class UzunVadeli : public Hesap {
    int minBakiye = 1500;
    int faiz = 24;

public:

    UzunVadeli() :
    Hesap() {
    }

    UzunVadeli(int hesapNo, int bakiye, Date tarih) :
    Hesap(hesapNo, bakiye, tarih) {
    }

    int Kar() {
        if (this->getAnlikBakiye() < minBakiye) {
            cout << "Bakiye:" << this->getAnlikBakiye() << "\nYeterli bakiye bulunmamakta !" << endl;
            return 0;
        }
        float gunlukFaiz = ((this->getAnlikBakiye() / 100) * faiz) / 365.0;
        int gunSayisi = getDifference(this->getTarih(), mevcutTarih);
        return gunlukFaiz*gunSayisi;
    }

    int GetFaiz() const {
        return faiz;
    }

    int GetMinBakiye() const {
        return minBakiye;
    }

};

class VadesizFaizli : public Hesap {
    int minBakiye = 0;
    int faiz = 12;

public:

    VadesizFaizli() :
    Hesap() {
        this->minBakiye = 1000;
        this->setVadesizFaizli(true);
    }

    VadesizFaizli(int hesapNo, int bakiye, Date tarih) :
    Hesap(hesapNo, bakiye, tarih) {
        this->minBakiye = bakiye;
        this->setVadesizFaizli(true);
    }

    int Kar() {
        if (this->getAnlikBakiye() < minBakiye) {
            cout << "Bakiye:" << this->getAnlikBakiye() << "\nYeterli bakiye bulunmamakta !" << endl;
            return 0;
        }
        float gunlukFaiz = ((this->getAnlikBakiye() / 100) * faiz) / 365.0;
        int gunSayisi = getDifference(this->getTarih(), mevcutTarih);
        return gunlukFaiz*gunSayisi;
    }

    int GetFaiz() const {
        return faiz;
    }

    int GetMinBakiye() const {
        return minBakiye;
    }



};

class Vadesiz : public Hesap {
public:

    Vadesiz() :
    Hesap() {
    }

    Vadesiz(int hesapNo, int bakiye, Date tarih) :
    Hesap(hesapNo, bakiye, tarih) {

    }

    Vadesiz(int hesapNo, Date tarih) :
    Hesap(hesapNo, 0, tarih) {
    }

    int Kar() {
        return 0;
    }

};

class Banka {
public:
    int hesapAdet = 0;
    Hesap *hesaplar[MAXHESAP];

    Banka() {
    }

    Banka(int hesapAdet) :
    hesapAdet(hesapAdet) {
    }

    struct Date getTarih() {
        cout << mevcutTarih.d << "." << mevcutTarih.m << "." << mevcutTarih.y << endl;
        return mevcutTarih;
    }

    void mevduat(int ID, int nakit) {
        for (int i = 0; i < hesapAdet; i++) {
            if (ID == hesaplar[i]->getHesapNo()) {
                hesaplar[i]->mevduat(nakit);
                cout << "Islem basarili" << endl;
                return;
            }
        }
        cout << "Hesap bulunamadi !" << endl;
        return;
    }

    bool cekmek(int ID, int nakit) {
        for (int i = 0; i < hesapAdet; i++) {
            if (ID == hesaplar[i]->getHesapNo()) {
                if (hesaplar[i]->cekmek(nakit)) {
                    cout << "Islem basarili" << endl;
                    return true;
                }
            }
        }
        cout << "Hesap bulunamadi !" << endl;
        return false;
    }

    int cekilis() {

        return 0;
    }
};


void menu();
void Olustur_S_ID_baslangicParasi();
void Olustur_L_ID_baslangicParasi();
void Olustur_O_ID_baslangicParasi();
void Olustur_C_ID_baslangicParasi();
void Artir_ID_nakit();
void Azalt_ID_nakit();
void Set_dd_mm_yy();
void HesabiGoster();
void GosterIDs();
void Sortition();

Banka *banka = new Banka();

int main() {
    menu();
    return 0;
}

void menu() {

    cout << "1) Kisa vadeli hesap ac" << endl;
    cout << "2) Uzun vadeli hesap ac" << endl;
    cout << "3) Vadesiz faizli hesap ac" << endl;
    cout << "4) Cari hesap hesap ac" << endl;
    cout << "5) Hesapa para ekle" << endl;
    cout << "6) Hesaptan para cek" << endl;
    cout << "7) Sistem saatini ayarla" << endl;
    cout << "8) Hesabi goster" << endl;
    cout << "9) Tum hesaplari goster" << endl;
    cout << "10) Kura cek" << endl;
    cout << "0) Cikis" << endl;
    cout << "Secim: ";
    int secim;
    cin >> secim;
    cout << endl;
    switch (secim) {
        case 0:
            cout << "Programdan cikiliyor..." << endl;
            exit(0);
            break;
        case 1:
            Olustur_S_ID_baslangicParasi();
            break;
        case 2:
            Olustur_L_ID_baslangicParasi();
            break;
        case 3:
            Olustur_O_ID_baslangicParasi();
            break;
        case 4:
            Olustur_C_ID_baslangicParasi();
            break;
        case 5:
            Artir_ID_nakit();
            break;
        case 6:
            Azalt_ID_nakit();
            break;
        case 7:
            Set_dd_mm_yy();
            break;
        case 8:
            HesabiGoster();
            break;
        case 9:
            GosterIDs();
            break;
        case 10:
            Sortition();
            break;
        default:
            cout << "Hatali secim !" << endl;
            break;
    }
    cout << endl;
    menu();
}

void yazdirHesap(Hesap *hesap) {
    cout << endl << "Hesap No: " << hesap->getHesapNo() << endl;
    cout << "Bakiye: " << hesap->getAnlikBakiye() << endl;
    if (hesap->Kar() > 0)
        cout << "Kar: " << hesap->Kar() << endl;
    else
        cout << "Kar: Cari Hesap" << endl;
    cout << "Olusturulma Tarih: " << hesap->getOlusturulma() << endl << endl;
}

int hesapKontrol(int ID) {
    for (int i = 0; i < banka->hesapAdet; i++) {
        if (banka->hesaplar[i]->getHesapNo() == ID)
            return i;
    }

    return -1;
}

void Artir_ID_nakit() {
    cout << "Hesap ID: ";
    int hesapId;
    cin >> hesapId;
    int hesapIndex = hesapKontrol(hesapId);
    if (hesapIndex == -1) {
        cout << "Hesap bulunamadi !" << endl;
        return;
    }
    cout << "Miktar: ";
    int miktar;
    cin >> miktar;
    banka->hesaplar[hesapIndex]->mevduat(miktar);
}

void Azalt_ID_nakit() {
    cout << "Hesap ID: ";
    int hesapId;
    cin >> hesapId;
    int hesapIndex = hesapKontrol(hesapId);
    if (hesapIndex == -1) {
        cout << "Hesap bulunamadi !" << endl;
        return;
    }
    cout << "Miktar: ";
    int miktar;
    cin >> miktar;
    banka->hesaplar[hesapIndex]->cekmek(miktar);
}

void Set_dd_mm_yy() {
    cout << "Sistem Tarihi >> " << endl;
    cout << "Gun: ";
    int gun;
    cin >> gun;

    cout << "Ay: ";
    int ay;
    cin >> ay;

    cout << "Yil: ";
    int yil;
    cin >> yil;

    if (yil < 2000 || (gun < 0 || gun > 31) || (ay < 0 || ay > 12)) {
        cout << "Girilen degerler gecerli bir tarih degeri degil !" << endl;
        return;
    }

    mevcutTarih = {gun, ay, yil};

    cout << "Yeni tarih: " << mevcutTarih.d << "." << mevcutTarih.m << "." << mevcutTarih.y << endl;
}

void HesabiGoster() {
    cout << "Hesap ID: ";
    int hesapId;
    cin >> hesapId;
    int hesapIndex = hesapKontrol(hesapId);
    if (hesapIndex == -1) {
        cout << "Hesap bulunamadi !" << endl;
        return;
    }

    yazdirHesap(banka->hesaplar[hesapIndex]);
    Hesap *hesap = banka->hesaplar[hesapIndex];

    for (int i = hesap->islemAdet - 1; i >= 0 && i > hesap->islemAdet - 6; i--) {
        cout << "Islem: " << hesap->islemler[i]->tur << endl;
        cout << "Miktar: " << hesap->islemler[i]->miktar << endl << endl;
    }
}

void GosterIDs() {
    for (int i = 0; i < banka->hesapAdet; i++) {
        yazdirHesap(banka->hesaplar[i]);
    }
}

void Olustur_S_ID_baslangicParasi() {
    if (banka->hesapAdet >= MAXHESAP) {
        cout << "Daha fazla hesap olusturulamaz !" << endl;
        return;
    }
    int hesapNo;
    int bakiye;
    struct Date tarih;

    cout << "Hesap No: ";
    cin >> hesapNo;
    if (hesapKontrol(hesapNo) != -1) {
        cout << "Hesap noya ait bir kayit var !" << endl;
        return;
    }
    cout << "Bakiye: ";
    cin>> bakiye;
    if (bakiye < (KisaVadeli().GetMinBakiye())) {
        cout << "Minimum bakiye miktarindan az !" << endl;
        return;
    }
    cout << "Olusturma Tarih >> " << endl;
    cout << "Gun : ";
    cin >> tarih.d;
    cout << "Ay : ";
    cin >> tarih.m;
    cout << "Yil : ";
    cin >> tarih.y;

    banka->hesaplar[banka->hesapAdet++] = new KisaVadeli(hesapNo, bakiye, tarih);

}

void Olustur_L_ID_baslangicParasi() {
    if (banka->hesapAdet >= MAXHESAP) {
        cout << "Daha fazla hesap olusturulamaz !" << endl;
        return;
    }
    int hesapNo;
    int bakiye;

    struct Date tarih;


    cout << "Hesap No: ";
    cin >> hesapNo;
    if (hesapKontrol(hesapNo) != -1) {
        cout << "Hesap noya ait bir kayit var !" << endl;
        return;
    }
    cout << "Bakiye: ";
    cin>> bakiye;
    if (bakiye < (UzunVadeli().GetMinBakiye())) {
        cout << "Minimum bakiye miktarindan az !" << endl;
        return;
    }
    cout << "Olusturma Tarih >> " << endl;
    cout << "Gun : ";
    cin >> tarih.d;
    cout << "Ay : ";
    cin >> tarih.m;
    cout << "Yil : ";
    cin >> tarih.y;

    banka->hesaplar[banka->hesapAdet++] = new UzunVadeli(hesapNo, bakiye, tarih);

}

void Olustur_O_ID_baslangicParasi() {
    if (banka->hesapAdet >= MAXHESAP) {
        cout << "Daha fazla hesap olusturulamaz !" << endl;
        return;
    }
    int hesapNo;
    int bakiye;

    struct Date tarih;

    cout << "Hesap No: ";
    cin >> hesapNo;
    if (hesapKontrol(hesapNo) != -1) {
        cout << "Hesap noya ait bir kayit var !" << endl;
        return;
    }
    cout << "Bakiye: ";
    cin>> bakiye;

    cout << "Olusturma Tarih >> " << endl;
    cout << "Gun : ";
    cin >> tarih.d;
    cout << "Ay : ";
    cin >> tarih.m;
    cout << "Yil : ";
    cin >> tarih.y;

    banka->hesaplar[banka->hesapAdet++] = new VadesizFaizli(hesapNo, bakiye, tarih);
}

void Olustur_C_ID_baslangicParasi() {
    if (banka->hesapAdet >= MAXHESAP) {
        cout << "Daha fazla hesap olusturulamaz !" << endl;
        return;
    }
    int hesapNo;
    struct Date tarih;

    cout << "Hesap No: ";
    cin >> hesapNo;
    if (hesapKontrol(hesapNo) != -1) {
        cout << "Hesap noya ait bir kayit var !" << endl;
        return;
    }
    cout << "Olusturma Tarih >> " << endl;
    cout << "Gun : ";
    cin >> tarih.d;
    cout << "Ay : ";
    cin >> tarih.m;
    cout << "Yil : ";
    cin >> tarih.y;

    banka->hesaplar[banka->hesapAdet++] = new Vadesiz(hesapNo, tarih);
}

void Sortition() {
    int adet = 0;
    for (int i = 0; i < banka->hesapAdet; i++) {
        if (banka->hesaplar[i]->isVadesizFaizli()) {
            int kazanma = banka->hesaplar[i]->getAnlikBakiye() / 2000;
            adet += kazanma;
        }
    }
    if (adet == 0) {
        cout << "Cekilisin kosullarini saglayan hesap yok !" << endl;
        return;
    }
    int hesaplar[adet];
    adet = 0;
    for (int i = 0; i < banka->hesapAdet; i++) {
        if (banka->hesaplar[i]->getAnlikBakiye() < 2000)
            continue;
        if (banka->hesaplar[i]->isVadesizFaizli()) {
            int puan = banka->hesaplar[i]->getAnlikBakiye() / 2000;

            for (int j = puan; j >= 0; j--) {
                hesaplar[adet++] = i;
            }
        }
    }

    int rastgele = (int) (rand() % adet - 1);
    cout << "Cekilisin kazanani >> " << endl;

    banka->hesaplar[hesaplar[rastgele]]->mevduat(10000);
    cout << "Odul: 10000";
    yazdirHesap(banka->hesaplar[hesaplar[rastgele]]);

}

