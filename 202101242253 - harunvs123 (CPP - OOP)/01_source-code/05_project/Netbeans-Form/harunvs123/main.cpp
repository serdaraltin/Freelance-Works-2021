#include <iostream>

#define BOYUT 100

using namespace std;

class Personel {
private:
    string tcNo;
    string ad;
    string soyad;
    int maas;
    string bolum;
public:

    Personel() {
    }

    Personel(string tcNo, string ad, string soyad, int maas, string bolum) :
    tcNo(tcNo), ad(ad), soyad(soyad), maas(maas), bolum(bolum) {
    }

    string GetAd() const {
        return ad;
    }

    void SetAd(string ad) {
        this->ad = ad;
    }

    string GetBolum() const {
        return bolum;
    }

    void SetBolum(string bolum) {
        this->bolum = bolum;
    }

    int GetMaas() const {
        return maas;
    }

    void SetMaas(int maas) {
        this->maas = maas;
    }

    string GetSoyad() const {
        return soyad;
    }

    void SetSoyad(string soyad) {
        this->soyad = soyad;
    }

    string GetTcNo() const {
        return tcNo;
    }

    void SetTcNo(string tcNo) {
        this->tcNo = tcNo;
    }

    friend std::ostream& operator<<(std::ostream& os, const Personel& obj) {
        os << "Tc No : " << obj.GetTcNo() << endl
                << "Ad : " << obj.GetAd() << endl
                << "Soyad : " << obj.GetSoyad() << endl
                << "Maas : " << obj.GetMaas() << endl
                << "Bolum : " << obj.GetBolum() << endl;
        return os;
    }


};

class Akademik : public Personel {
private:
    string dal;
public:

    Akademik() :
    Personel() {
    }

    Akademik(string tcNo, string ad, string soyad, int maas, string bolum, string dal) :
    Personel(tcNo, ad, soyad, maas, bolum), dal(dal) {
    }

    string GetDal() const {
        return dal;
    }

    void SetDal(string dal) {
        this->dal = dal;
    }

    friend std::ostream& operator<<(std::ostream& os, const Akademik& obj) {
        os << "Tc No : " << obj.GetTcNo() << endl
                << "Ad : " << obj.GetAd() << endl
                << "Soyad : " << obj.GetSoyad() << endl
                << "Maas : " << obj.GetMaas() << endl
                << "Bolum : " << obj.GetBolum() << endl
                << "Dal : " << obj.GetDal() << endl;
        return os;
    }

};

class Idari : public Personel {
private:
    string gorev;

public:

    Idari(string tcNo, string ad, string soyad, int maas, string bolum, string gorev) :
    Personel(tcNo, ad, soyad, maas, bolum), gorev(gorev) {
    }

    string GetGorev() const {
        return gorev;
    }

    void SetGorev(string gorev) {
        this->gorev = gorev;
    }

    friend std::ostream& operator<<(std::ostream& os, const Idari& obj) {
        os << "Tc No : " << obj.GetTcNo() << endl
                << "Ad : " << obj.GetAd() << endl
                << "Soyad : " << obj.GetSoyad() << endl
                << "Maas : " << obj.GetMaas() << endl
                << "Bolum : " << obj.GetBolum() << endl
                << "Gorev : " << obj.GetGorev() << endl;
        return os;
    }

};

class Akademisyen : public Akademik {
private:
    string unvan;
    int tecrubeSure;
public:

    Akademisyen() :
    Akademik() {
    }

    Akademisyen(string tcNo, string ad, string soyad, int maas, string bolum, string dal, string unvan, int tecrubeSure) :
    Akademik(tcNo, ad, soyad, maas, bolum, dal), unvan(unvan), tecrubeSure(tecrubeSure) {
    }

    int GetTecrubeSure() const {
        return tecrubeSure;
    }

    void SetTecrubeSure(int tecrubeSure) {
        this->tecrubeSure = tecrubeSure;
    }

    string GetUnvan() const {
        return unvan;
    }

    void SetUnvan(string unvan) {
        this->unvan = unvan;
    }

    friend std::ostream& operator<<(std::ostream& os, const Akademisyen& obj) {
        os << "Tc No : " << obj.GetTcNo() << endl
                << "Ad : " << obj.GetAd() << endl
                << "Soyad : " << obj.GetSoyad() << endl
                << "Maas : " << obj.GetMaas() << endl
                << "Bolum : " << obj.GetBolum() << endl
                << "Unvan : " << obj.GetUnvan() << endl
                << "Tecrube : " << obj.GetTecrubeSure() << " yil" << endl;
        return os;
    }

};

class Ogrenci : public Akademik {
private:
    int no;
    int sinif;
public:

    Ogrenci(string tcNo, string ad, string soyad, string bolum, int no, int sinif) :
    Akademik(tcNo, ad, soyad, 0, bolum, ""), no(no), sinif(sinif) {
    }

    Ogrenci() :
    Akademik() {
    }

    int GetNo() const {
        return no;
    }

    void SetNo(int no) {
        this->no = no;
    }

    int GetSinif() const {
        return sinif;
    }

    void SetSinif(int sinif) {
        this->sinif = sinif;
    }

    friend std::ostream& operator<<(std::ostream& os, const Ogrenci& obj) {
        os
                << "No : " << obj.GetNo() << endl
                << "Sinif : " << obj.GetSinif() << endl
                << "Tc No : " << obj.GetTcNo() << endl
                << "Ad : " << obj.GetAd() << endl
                << "Soyad : " << obj.GetSoyad() << endl
                << "Maas : " << obj.GetMaas() << endl
                << "Bolum : " << obj.GetBolum() << endl
                ;
        return os;
    }

};

class ArastirmaGorevlisi : public Akademisyen {
private:
    int kalanSure;
public:

    ArastirmaGorevlisi() {
    }

    ArastirmaGorevlisi(string tcNo, string ad, string soyad, int maas, string bolum, string dal, string unvan, int tecrubeSure, int kalanSure) :
    Akademisyen(tcNo, ad, soyad, maas, bolum, dal, unvan, tecrubeSure), kalanSure(kalanSure) {
    }

    int GetKalanSure() const {
        return kalanSure;
    }

    void SetKalanSure(int kalanSure) {
        this->kalanSure = kalanSure;
    }

    friend std::ostream& operator<<(std::ostream& os, const ArastirmaGorevlisi& obj) {
        os << "Tc No : " << obj.GetTcNo() << endl
                << "Ad : " << obj.GetAd() << endl
                << "Soyad : " << obj.GetSoyad() << endl
                << "Maas : " << obj.GetMaas() << endl
                << "Bolum : " << obj.GetBolum() << endl
                << "Dal : " << obj.GetDal() << endl
                << "unvan : " << obj.GetUnvan() << endl
                << "Tecrube : " << obj.GetUnvan() << " yil" << endl
                << "Kalan : " << obj.GetUnvan() << " yil" << endl
                ;
        return os;
    }

};

Akademik *akademikler[BOYUT];
Idari *idariler[BOYUT];
Akademisyen *akademisyenler[BOYUT];
Ogrenci *ogrenciler[BOYUT];
ArastirmaGorevlisi *arastirmacilar[BOYUT];

int indexAkademik = 0, indexIdari = 0, indexAkademisyen = 0, indexOgrenci = 0, indexArastirmaci = 0;

void menu();
void kayitOlusturMenu();
void kayitSilMenu();
void bilgiGoruntuleMenu();

int main() {

    menu();
    return 0;
}

void menu() {
    cout << "1) Kayit olustur" << endl;
    cout << "2) Kayit sil" << endl;
    cout << "3) Bilgi goruntule" << endl;
    cout << "0) Cik" << endl;
    cout << "Secim : ";
    int secim;
    cin >> secim;

    switch (secim) {
        case 0:
            cout << "Cikiliyor..." << endl;
            exit(0);
            break;
        case 1:
            kayitOlusturMenu();
            break;
        case 2:
            kayitSilMenu();
            break;
        case 3:
            bilgiGoruntuleMenu();
            break;
        default:
            cout << "Hatali secim. Tekrar deneyiniz !" << endl;
            break;

    }
    cout << endl;
    menu();
}

void listeleAkademik() {
    int i;
    for (i = 0; i < BOYUT; i++) {
        if (akademikler[i] != NULL) {
            cout << "No : " << i << " Ad: " << akademikler[i]->GetAd() << " Soyad: " << akademikler[i]->GetSoyad() << endl;
        }
    }
}

void listeleIdari() {
    int i;
    for (i = 0; i < BOYUT; i++) {
        if (idariler[i] != NULL) {
            cout << "No : " << i << " Ad: " << idariler[i]->GetAd() << " Soyad: " << idariler[i]->GetSoyad() << endl;
        }
    }
}

void listeleAkademisyen() {
    int i;
    for (i = 0; i < BOYUT; i++) {
        if (akademisyenler[i] != NULL) {
            cout << "No : " << i << " Ad: " << akademisyenler[i]->GetAd() << " Soyad: " << akademisyenler[i]->GetSoyad() << endl;
        }
    }
}

void listeleOgrenci() {
    int i;
    for (i = 0; i < BOYUT; i++) {
        if (ogrenciler[i] != NULL) {
            cout << "No : " << i << " Ad: " << ogrenciler[i]->GetAd() << " Soyad: " << ogrenciler[i]->GetSoyad() << endl;
        }
    }
}

void listeleArastirmaci() {
    int i;
    for (i = 0; i < BOYUT; i++) {
        if (arastirmacilar[i] != NULL) {
            cout << "No : " << i << " Ad: " << arastirmacilar[i]->GetAd() << " Soyad: " << arastirmacilar[i]->GetSoyad() << endl;
        }
    }
}

void kayitAkademik();
void kayitIdari();
void kayitAkademisyen();
void kayitOgrenci();
void kayitArastirmaci();

void kayitOlusturMenu() {
    cout << endl << "KAYIT OLUSTUR" << endl;
    cout << "1) Akademik Personel" << endl;
    cout << "2) Idari Personel" << endl;
    cout << "3) Akademisyen" << endl;
    cout << "4) Ogrenci" << endl;
    cout << "5) Arastirma Gorevlisi" << endl;
    cout << "0) Ana menu" << endl;
    cout << "Secim : ";
    int secim;
    cin >> secim;

    switch (secim) {
        case 0:
            return;
            break;
        case 1:
            kayitAkademik();
            break;
        case 2:
            kayitIdari();
            break;
        case 3:
            kayitAkademisyen();
            break;
        case 4:
            kayitOgrenci();
            break;
        case 5:
            kayitArastirmaci();
            break;
    }
    cout << endl;
    kayitOlusturMenu();
}

void kayitAkademik() {
    string tcno, ad, soyad, bolum, dal;
    int maas;

    cout << "Tc No : ";
    cin >> tcno;

    cout << "Ad : ";
    cin >> ad;

    cout << "Soyad : ";
    cin >> soyad;

    cout << "Maaş : ";
    cin >> maas;

    cout << "Bölüm : ";
    cin >> bolum;

    cout << "Dal : ";
    cin >> dal;

    akademikler[indexAkademik++] = new Akademik(tcno, ad, soyad, maas, bolum, dal);

}

void kayitIdari() {
    string tcno, ad, soyad, bolum, gorev;
    int maas;

    cout << "Tc No : ";
    cin >> tcno;

    cout << "Ad : ";
    cin >> ad;

    cout << "Soyad : ";
    cin >> soyad;

    cout << "Maaş : ";
    cin >> maas;

    cout << "Bölüm : ";
    cin >> bolum;

    cout << "Gorev : ";
    cin >> gorev;

    idariler[indexIdari++] = new Idari(tcno, ad, soyad, maas, bolum, gorev);
}

void kayitAkademisyen() {
    string tcno, ad, soyad, unvan, bolum, dal;
    int maas, tecrube;

    cout << "Tc No : ";
    cin >> tcno;

    cout << "Ad : ";
    cin >> ad;

    cout << "Soyad : ";
    cin >> soyad;

    cout << "Maaş : ";
    cin >> maas;

    cout << "Bölüm : ";
    cin >> bolum;

    cout << "Dal : ";
    cin >> dal;


    cout << "Ünvan : ";
    cin >> unvan;

    cout << "Tecrube (yil) : ";
    cin >> tecrube;

    akademisyenler[indexAkademisyen++] = new Akademisyen(tcno, ad, soyad, maas, bolum, dal, unvan, tecrube);
}

void kayitOgrenci() {
    string tcno, ad, soyad, bolum;
    int maas, no, sinif;


    cout << "No : ";
    cin >> no;

    cout << "Tc No : ";
    cin >> tcno;

    cout << "Ad : ";
    cin >> ad;

    cout << "Soyad : ";
    cin >> soyad;

    cout << "Bolum : ";
    cin >> bolum;

    cout << "Sinif (1..4) : ";
    cin >> sinif;

    ogrenciler[indexOgrenci++] = new Ogrenci(tcno, ad, soyad, bolum, no, sinif);
}

void kayitArastirmaci() {
    string tcno, ad, soyad, unvan, bolum, dal;
    int maas, tecrube, kalanSure;

    cout << "Tc No : ";
    cin >> tcno;

    cout << "Ad : ";
    cin >> ad;

    cout << "Soyad : ";
    cin >> soyad;

    cout << "Maaş : ";
    cin >> maas;

    cout << "Bölüm : ";
    cin >> bolum;

    cout << "Dal : ";
    cin >> dal;


    cout << "Ünvan : ";
    cin >> unvan;

    cout << "Tecrube (yil) : ";
    cin >> tecrube;

    cout << "Kalan sure (yil) : ";
    cin >> kalanSure;

    arastirmacilar[indexArastirmaci++] = new ArastirmaGorevlisi(tcno, ad, soyad, maas, bolum, dal, unvan, tecrube, kalanSure);

}

void silAkademik();
void silIdari();
void silAkademisyen();
void silOgrenci();
void silArastirmaci();

void kayitSilMenu() {
    cout << endl << "KAYIT SIL" << endl;
    cout << "1) Akademik Personel" << endl;
    cout << "2) Idari Personel" << endl;
    cout << "3) Akademisyen" << endl;
    cout << "4) Ogrenci" << endl;
    cout << "5) Arastirma Gorevlisi" << endl;
    cout << "0) Ana menu" << endl;
    cout << "Secim : ";
    int secim;
    cin >> secim;

    switch (secim) {
        case 0:
            return;
            break;
        case 1:
            silAkademik();
            break;
        case 2:
            silIdari();
            break;
        case 3:
            silAkademisyen();
            break;
        case 4:
            silOgrenci();
            break;
        case 5:
            silArastirmaci();
            break;
    }
    cout << endl;
    kayitSilMenu();
}

void silAkademik() {
    if (indexAkademik == 0) {
        cout << "Hic kayit yok !" << endl;
        return;
    }
    int no;
    listeleAkademik();
    cout << "No : ";
    cin >> no;
    if (akademikler[no] == NULL) {
        cout << "Kayit bulunamadi !" << endl;
        return;
    }
    akademikler[no] = NULL;
}

void silIdari() {
    if (indexIdari == 0) {
        cout << "Hic kayit yok !" << endl;
        return;
    }
    int no;
    listeleIdari();
    cout << "No : ";
    cin >> no;
    if (idariler[no] == NULL) {
        cout << "Kayit bulunamadi !" << endl;
        return;
    }
    idariler[no] = NULL;
}

void silAkademisyen() {
    if (indexAkademisyen == 0) {
        cout << "Hic kayit yok !" << endl;
        return;
    }
    int no;
    listeleAkademisyen();
    cout << "No : ";
    cin >> no;
    if (akademisyenler[no] == NULL) {
        cout << "Kayit bulunamadi !" << endl;
        return;
    }
    akademisyenler[no] = NULL;
}

void silOgrenci() {
    if (indexOgrenci == 0) {
        cout << "Hic kayit yok !" << endl;
        return;
    }
    int no;
    listeleOgrenci();
    cout << "No : ";
    cin >> no;
    if (ogrenciler[no] == NULL) {
        cout << "Kayit bulunamadi !" << endl;
        return;
    }
    ogrenciler[no] = NULL;
}

void silArastirmaci() {
    if (indexArastirmaci == 0) {
        cout << "Hic kayit yok !" << endl;
        return;
    }
    int no;
    listeleArastirmaci();
    cout << "No : ";
    cin >> no;
    if (arastirmacilar[no] == NULL) {
        cout << "Kayit bulunamadi !" << endl;
        return;
    }
    arastirmacilar[no] = NULL;
}


void goruntuleAkademik(int no);
void goruntuleIdari(int no);
void goruntuleAkademisyen(int no);
void goruntuleOgrenci(int no);
void goruntuleArastirmaci(int no);

void bilgiGoruntuleMenu() {
    cout << endl << "KAYIT GORUNTULE" << endl;
    cout << "1) Akademik Personel" << endl;
    cout << "2) Idari Personel" << endl;
    cout << "3) Akademisyen" << endl;
    cout << "4) Ogrenci" << endl;
    cout << "5) Arastirma Gorevlisi" << endl;
    cout << "0) Ana menu" << endl;
    cout << "Secim : ";
    int secim;
    cin >> secim;
    int no;
    switch (secim) {
        case 0:
            return;
            break;
        case 1:
            listeleAkademik();
            cout << "No : ";
            cin >> no;
            goruntuleAkademik(no);
            break;
        case 2:
            listeleIdari();
            cout << "No : ";
            cin >> no;
            goruntuleIdari(no);
            break;
        case 3:
            listeleAkademisyen();
            cout << "No : ";
            cin >> no;
            goruntuleAkademisyen(no);
            break;
        case 4:
            listeleOgrenci();
            cout << "No : ";
            cin >> no;
            goruntuleOgrenci(no);
            break;
        case 5:
            listeleArastirmaci();
            cout << "No : ";
            cin >> no;
            goruntuleArastirmaci(no);
            break;
    }
    cout << endl;
    bilgiGoruntuleMenu();
}

void goruntuleAkademik(int no) {
    if (indexAkademik == 0) {
        cout << "Hic kayit yok !" << endl;
        return;
    }
    if (akademikler[no] == NULL) {
        cout << "Kayit bulunamadi !" << endl;
        return;
    }
    cout << *akademikler[no] << endl;
}

void goruntuleIdari(int no) {
    if (indexIdari == 0) {
        cout << "Hic kayit yok !" << endl;
        return;
    }
    if (idariler[no] == NULL) {
        cout << "Kayit bulunamadi !" << endl;
        return;
    }
    cout << *idariler[no] << endl;
}

void goruntuleAkademisyen(int no) {
    if (indexAkademisyen == 0) {
        cout << "Hic kayit yok !" << endl;
        return;
    }
    if (akademisyenler[no] == NULL) {
        cout << "Kayit bulunamadi !" << endl;
        return;
    }
    cout << *akademisyenler[no] << endl;
}

void goruntuleOgrenci(int no) {
    if (indexOgrenci == 0) {
        cout << "Hic kayit yok !" << endl;
        return;
    }
    if (ogrenciler[no] == NULL) {
        cout << "Kayit bulunamadi !" << endl;
        return;
    }
    cout << *ogrenciler[no] << endl;
}

void goruntuleArastirmaci(int no) {
    if (indexArastirmaci == 0) {
        cout << "Hic kayit yok !" << endl;
        return;
    }
    if (arastirmacilar[no] == NULL) {
        cout << "Kayit bulunamadi !" << endl;
        return;
    }
    cout << *arastirmacilar[no] << endl;
}
