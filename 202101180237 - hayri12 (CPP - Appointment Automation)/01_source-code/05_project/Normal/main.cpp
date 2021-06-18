#include <iostream>
#include <fstream>
#include <string>

using namespace std;

//poliklinik sınıfı

class Poliklinik {
private:
    //özel tanımlı değişkenler
    string ad;
    int randevuUcret;
public:
    //kurucu method 1

    Poliklinik() {
    }
    //kurucu method 2

    Poliklinik(string ad, int randevuUcret) :
    ad(ad), randevuUcret(randevuUcret) {
    }
    //arkadaş method

    friend std::ostream& operator<<(std::ostream& os, const Poliklinik& obj) {
        os << "Poliklinik : " << obj.ad << "\t" << "Ucret : " << obj.randevuUcret << " TL" << endl;
        return os;
    }
    //getter

    string GetAd() const {
        return ad;
    }
    //setter

    void SetAd(string ad) {
        this->ad = ad;
    }
    //getter

    int GetRandevuUcret() const {
        return randevuUcret;
    }
    //setter

    void SetRandevuUcret(int randevuUcret) {
        this->randevuUcret = randevuUcret;
    }
    //yıkıcı method

    ~Poliklinik() {
        ad = "";
        randevuUcret = 0;
        //cout << "Poliklinik bellekten kaldirildi\n";
    }
};

//kisi sınıfı

class Kisi {
private:
    //özel tanımlı değişkenler
    string tcno;
    string ad;
    string soyad;
public:
    //kurucu method 1

    Kisi() {
    }
    //kurucu method 1

    Kisi(string tcno, string ad, string soyad) :
    tcno(tcno), ad(ad), soyad(soyad) {
    }
    //arkadaş method

    friend std::ostream& operator<<(std::ostream& os, const Kisi& obj) {
        os << "Tc No : " << obj.GetTcno() << endl <<
                "Ad    : " << obj.GetAd() << endl <<
                "Soyad : " << obj.GetSoyad() << endl;
        return os;
    }
    //yıkıcı method

    ~Kisi() {
        tcno = "";
        ad = "";
        soyad = "";
        // cout << "Kisi bellekten kaldirildi.\n";
    }
    //getter

    string GetAd() const {
        return ad;
    }
    //setter

    void SetAd(string ad) {
        this->ad = ad;
    }
    //getter

    string GetSoyad() const {
        return soyad;
    }
    //setter

    void SetSoyad(string soyad) {
        this->soyad = soyad;
    }
    //getter

    string GetTcno() const {
        return tcno;
    }
    //setter

    void SetTcno(string tcno) {
        this->tcno = tcno;
    }

};

//doktor sınıfı > kisi sinifindan turemistir 

class Doktor : public Kisi {
private:
    //özel tanımlı nesne
    Poliklinik poliklinik;
public:
    //kurucu method 1

    Doktor() :
    Kisi() {
    }
    //kurucu method 2

    Doktor(string tcno, string ad, string soyad) :
    Kisi(tcno, ad, soyad) {
    }
    //kurucu method 3

    Doktor(string tcno, string ad, string soyad, Poliklinik poliklinik) :
    Kisi(tcno, ad, soyad), poliklinik(poliklinik) {
    }
    //arkadaş method

    friend std::ostream& operator<<(std::ostream& os, const Doktor& obj) {
        os <<  "Ad         : " << obj.GetAd() << endl <<
                "Soyad      : " << obj.GetSoyad() << endl <<
                "Poliklinik : " << obj.GetPoliklinik().GetAd() << endl;
        return os;
    }
    //yıkıcı method

    ~Doktor() {
        //cout << "Doktor nesnesi bellekten kaldirildi."<<endl;
    }
    //getter

    Poliklinik GetPoliklinik() const {
        return poliklinik;
    }
    //setter

    void SetPoliklinik(Poliklinik poliklinik) {
        this->poliklinik = poliklinik;
    }

};

//hasta sınıfı > kisi sınıfından türemiştir

class Hasta : public Kisi {
private:
public:
    //kurucu method 1

    Hasta() :
    Kisi() {
    }
    //kurucu method 2

    Hasta(string tcno, string ad, string soyad) :
    Kisi(tcno, ad, soyad) {
    }
    //arkadaş method

    friend std::ostream& operator<<(std::ostream& os, const Hasta& obj) {
        os << "Tc No      : " << obj.GetTcno() << endl <<
                "Ad         : " << obj.GetAd() << endl <<
                "Soyad      : " << obj.GetSoyad() << endl;
        return os;
    }
    //yıkıcı method

    ~Hasta() {
        //cout << "Hasta bellekten kaldirildi." << endl;
    }
};

//randevu sınıfı

class Randevu {
private:
    //özel tanımlı nesne ve değişkenler
    Doktor doktor;
    Hasta hasta;
    string tarih;
    string saat;
public:
    //kurucu method 1

    Randevu() {
    }
    //kurucu method 1

    Randevu(Doktor doktor, Hasta hasta, string tarih, string saat) :
    doktor(doktor), hasta(hasta), tarih(tarih), saat(saat) {
    }
    //arkadaş method

    friend std::ostream& operator<<(std::ostream& os, const Randevu& obj) {
        os << "Hasta      >> " << obj.hasta.GetTcno() << " " << obj.hasta.GetAd()
                << " " << obj.hasta.GetSoyad() << endl
                << "Doktor     >> " << obj.doktor.GetAd() << " " << obj.doktor.GetSoyad() << endl
                << "Poliklinik >> " << obj.doktor.GetPoliklinik().GetAd() << endl
                << "Tarih/Saat >> " << obj.GetTarih() << " " << obj.GetSaat() << endl
                << "Ucret      >> " << obj.doktor.GetPoliklinik().GetRandevuUcret() << " TL" << endl;
        return os;
    }
    //yıkıcı method

    ~Randevu() {
        this->tarih = "";
        this->saat = "";
        //cout << "Randevu bellekten kaldirildi."<<endl;
    }
    //getter

    Doktor GetDoktor() const {
        return doktor;
    }
    //setter

    void SetDoktor(Doktor doktor) {
        this->doktor = doktor;
    }
    //getter

    Hasta GetHasta() const {
        return hasta;
    }
    //setter

    void SetHasta(Hasta hasta) {
        this->hasta = hasta;
    }
    //getter

    string GetSaat() const {
        return saat;
    }
    //setter

    void SetSaat(string saat) {
        this->saat = saat;
    }
    //getter

    string GetTarih() const {
        return tarih;
    }
    //setter

    void SetTarih(string tarih) {
        this->tarih = tarih;
    }


};

//kisi structı

typedef struct kisi {
    string tcno;
    string ad;
    string soyad;
} sKisi;

//ilgili kayıtların tutulduğu diziler
Doktor *doktorlar[5];
Poliklinik *poliklinikler[2];
Hasta *hastalar[50];
Randevu *randevular[100];

//ilgili kayıtların tutulduğu dizilerdeki eleman sayısını tutan index değişkenleri
int indexDoktor = 0, indexPoliklinik = 0, indexHasta = 0, indexRandevu = 0;

//genel aktarımlarda kullanılan değişkenler
string ad, soyad, tcno, poliklinikAd;
int ucret;

//prototip tanımlamaları
void menu();
void listelePoliklinik();
void listeleDoktor(string poliklinikAd);
int kontrolPoliklinik(string ad);
int kontrolHasta(string tcno);
int kontrolDoktor(string ad);
int kontrolDoktor(string tcno);
int ekleHasta();
void ekleRandevu(int hastaNo);

//dosyadan ilgili dosyayı okuma ve kayıta geçirme işlemi

void dosyaOkuPoliklinik() {
    fstream dosya;
    dosya.open("poliklinik.txt", ios::in);

    while (!dosya.eof()) {
        dosya >> ad >> ucret;
        poliklinikler[indexPoliklinik++] = new Poliklinik(ad, ucret);
    }
    dosya.close();
}
//dosyadan ilgili dosyayı okuma ve kayıta geçirme işlemi

void dosyaOkuDoktor() {
    tcno = "";
    ad = "";
    soyad = "";
    fstream dosya;
    dosya.open("doktor.txt", ios::in);

    while (!dosya.eof()) {
        dosya >> tcno >> ad >> soyad>> poliklinikAd;
        if (tcno == "")
            break;
        doktorlar[indexDoktor++] = new Doktor(tcno, ad, soyad);
        int indexNo = kontrolPoliklinik(poliklinikAd);
        (*doktorlar[indexDoktor - 1]).SetPoliklinik(*poliklinikler[indexNo]);
    }
    dosya.close();
}
//dosyadan ilgili dosyayı okuma ve kayıta geçirme işlemi

void dosyaOkuHasta() {
    tcno = "";
    ad = "";
    soyad = "";
    fstream dosya;
    dosya.open("hasta.txt", ios::in);

    while (!dosya.eof()) {
        dosya >> tcno >> ad >> soyad;
        if (tcno == "")
            break;
        hastalar[indexHasta++] = new Hasta(tcno, ad, soyad);
    }
    dosya.close();
}
//dosyadan ilgili dosyayı okuma ve kayıta geçirme işlemi

void dosyaOkuRandevu() {
    fstream dosya;
    dosya.open("randevu.txt", ios::in);
    string hastaTc, doktorTc, tarih, saat;
    while (!dosya.eof()) {
        dosya >> hastaTc >> doktorTc >> tarih>> saat;
        if (hastaTc == "")
            break;
        randevular[indexRandevu++] = new Randevu();
        (*randevular[indexRandevu - 1]).SetTarih(tarih);
        (*randevular[indexRandevu - 1]).SetSaat(saat);
        int hastaNo = kontrolHasta(hastaTc);
        int doktorNo = kontrolDoktor(doktorTc);
        (*randevular[indexRandevu - 1]).SetHasta(*hastalar[hastaNo]);
        (*randevular[indexRandevu - 1]).SetDoktor(*doktorlar[doktorNo]);
    }
    dosya.close();
}
//dosyadan ilgili dosyayı yazma işlemi

void dosyaYazHasta() {
    int i;
    fstream dosya;
    dosya.open("hasta.txt", ios::out);
    for (i = 0; i < indexHasta; i++) {
        dosya << hastalar[i]->GetTcno() << " " << hastalar[i]->GetAd()
                << " " << hastalar[i]->GetSoyad();
        if (i < indexHasta - 1) {
            dosya << endl;
        }
    }
    dosya.close();
}
//dosyadan ilgili dosyayı yazma işlemi

void dosyaYazRandevu() {
    int i;
    fstream dosya;
    dosya.open("randevu.txt", ios::out);
    for (i = 0; i < indexRandevu; i++) {
        dosya << randevular[i]->GetHasta().GetTcno() << " "
                << randevular[i]->GetDoktor().GetTcno() << " "
                << randevular[i]->GetTarih() << " "
                << randevular[i]->GetSaat();
        if (i < indexRandevu - 1) {
            dosya << endl;
        }
    }
    dosya.close();
}

//ana method

int main() {
    //ilgili dosyaların okunması
    dosyaOkuPoliklinik();
    dosyaOkuDoktor();
    dosyaOkuHasta();
    dosyaOkuRandevu();
    //menu çağrımı
    menu();
    return 0;
}

//ilgili listedeki kayıtların listelenmesi

void listelePoliklinik() {
    cout << "POLIKLINIKLER >>" << endl << endl;
    int i;
    for (i = 0; i < indexPoliklinik; i++) {
        cout << *poliklinikler[i] << endl;
    }
    cout << endl;
}
//ilgili listedeki kayıtların listelenmesi (parametreye göre)

void listeleDoktor(string poliklinikAd) {
    cout << "DOKTORLAR (" << poliklinikAd << ")>>" << endl << endl;
    int i;
    for (i = 0; i < indexDoktor; i++) {
        if ((*doktorlar[i]).GetPoliklinik().GetAd() == poliklinikAd)
            cout << *doktorlar[i] << endl;
    }
    cout << endl;
}

//ilgili listedeki kaydın kontrolü parametreye göre

int kontrolDoktor(string ad, string poliklinikAd) {
    int i;
    for (i = 0; i < indexDoktor; i++) {
        if ((*doktorlar[i]).GetAd() == ad && (*doktorlar[i]).GetPoliklinik().GetAd() == poliklinikAd)
            return i;
    }
    return -1;
}
//ilgili listedeki kaydın kontrolü parametreye göre

int kontrolDoktor(string tcno) {
    int i;
    for (i = 0; i < indexDoktor; i++) {
        if ((*doktorlar[i]).GetTcno() == tcno)
            return i;
    }
    return -1;
}
//ilgili listedeki kaydın kontrolü parametreye göre

int kontrolPoliklinik(string ad) {
    int i;
    for (i = 0; i < indexPoliklinik; i++) {
        if ((*poliklinikler[i]).GetAd() == ad)
            return i;
    }
    return -1;
}
//ilgili listedeki kaydın kontrolü parametreye göre

int kontrolHasta(string tcno) {
    int i;
    for (i = 0; i < indexHasta; i++) {
        if ((*hastalar[i]).GetTcno() == tcno)
            return i;
    }
    return -1;
}

//yeni bir hasta oluşturma işlemi

int ekleHasta() {
    //  sKisi *kisi = (sKisi*) malloc(sizeof (sKisi));
    string htcno, had, hsoyad;
    cout << "Tc No : ";
    cin >> htcno;
    if (kontrolHasta(htcno) != -1) {
        return kontrolHasta(htcno);
    }
    cout << "Adiniz : ";
    cin >> had;
    cout << "Soyadiniz : ";
    cin >> hsoyad;
    //listeye ekleme
    hastalar[indexHasta++] = new Hasta(htcno, had, hsoyad);
    cout << "Hasta eklendi." << endl;
    //yeni randevu listesinin dosyaya yazılması
    dosyaYazHasta();
    return -1;
}

//yeni bir randevu oluşturma işlemi

void ekleRandevu(int hastaNo) {
    int polikinikNo = -1, doktorNo = -1;
    if (hastaNo == -1)
        hastaNo = indexHasta - 1;
    listelePoliklinik();
    string poliklinikAd;
    cout << "Hangi poliklinikten randevu almak istiyorsunuz ? ";
    cin >> poliklinikAd;
    polikinikNo = kontrolPoliklinik(poliklinikAd);
    if (polikinikNo == -1) {
        cout << "Hatali secim !" << endl;
        ekleRandevu(hastaNo);
        return;
    }

    string doktorAd;
    listeleDoktor(poliklinikAd);
    cout << "Hangi doktordan randevu almak istiyorsunuz ? ";
    cin >> doktorAd;
    doktorNo = kontrolDoktor(doktorAd, poliklinikAd);
    if (doktorNo == -1) {
        cout << "Hatali secim !" << endl;
        ekleRandevu(hastaNo);
        return;
    }
    string tarih, saat;
    cout << "Tarih : ";
    cin >> tarih;
    cout << "Saat  (13.00-14.00-15.00): ";
    cin >> saat;
    if (!(saat == "13.00" || saat == "14.00" || saat == "15.00")) {
        cout << "Saat gecersiz !" << endl;
        ekleRandevu(hastaNo);
        return;
    }

    //ilgili bilgilerin yeni oluşturulan randevu alanına yazılması
    randevular[indexRandevu++] = new Randevu();
    randevular[indexRandevu - 1]->SetTarih(tarih);
    randevular[indexRandevu - 1]->SetSaat(saat);
    (*randevular[indexRandevu - 1]).SetHasta(*hastalar[hastaNo]);
    (*randevular[indexRandevu - 1]).SetDoktor(*doktorlar[doktorNo]);
    cout << "Sayin " << (*hastalar[hastaNo]).GetAd() << " " << (*hastalar[hastaNo]).GetAd() <<
            " randevunuz olusturulmustur." << endl;
    //yeni randevu listesinin dosyaya yazılması
    dosyaYazRandevu();
    cout << "Yeni randevu eklensin mi (E/H)?";
    string yeni = "H";
    cin >> yeni;
    if (yeni == "E")
        ekleRandevu(hastaNo);

    return;
}

//menu

void menu() {
    cout << "1) Randevu Ayarla" << endl;
    cout << "0) Cikis" << endl;
    cout << "Secim : ";
    int secim;
    cin >> secim;
    int hNo = -1;
    switch (secim) {
        case 0:
            cout << "Cikiliyor..." << endl;
            exit(0);
            break;
        case 1:
            hNo = ekleHasta();
            ekleRandevu(hNo);
            break;
        case 2:
            break;
        default:
            cout << "Hatali secim !" << endl;
            break;
    }
    cout << endl << endl;
    menu();
}