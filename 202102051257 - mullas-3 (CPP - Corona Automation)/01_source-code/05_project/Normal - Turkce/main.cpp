#include <iostream>
#include <fstream>

#define MINBAGISIKLIK 25
#define KAPASITE 100

using namespace std;

void DosyaYaz();
void DosyaOku();

class Hasta {
private:
    string tcno;
    string ad;
    string soyad;
    bool ates;
    bool kuruOksuruk;
    bool yorgunluk;
    int bagisiklikSeviye;
    bool corona;
public:

    void KoronaTespit() {
        if (this->bagisiklikSeviye < MINBAGISIKLIK && (ates && kuruOksuruk && yorgunluk)) {
            this->corona = true;
        } else {
            this->corona = false;
        }
    }

    Hasta() {
    }

    Hasta(string tcno, string ad, string soyad) :
    tcno(tcno), ad(ad), soyad(soyad) {
        this->ates = false;
        this->kuruOksuruk = false;
        this->yorgunluk = false;
        this->corona = false;
        this->bagisiklikSeviye = 80;
        KoronaTespit();
    }

    Hasta(string tcno, string ad, string soyad, bool ates, bool kuruOksuruk, bool yorgunluk, int bagisiklikSeviye) :
    tcno(tcno), ad(ad), soyad(soyad), ates(ates), kuruOksuruk(kuruOksuruk), yorgunluk(yorgunluk), bagisiklikSeviye(bagisiklikSeviye) {
        KoronaTespit();
    }

    Hasta(string tcno, string ad, string soyad, bool ates, bool kuruOksuruk, bool yorgunluk, int bagisiklikSeviye, bool corona) :
    tcno(tcno), ad(ad), soyad(soyad), ates(ates), kuruOksuruk(kuruOksuruk), yorgunluk(yorgunluk), bagisiklikSeviye(bagisiklikSeviye), corona(corona) {
        KoronaTespit();
    }

    string GetAd() const {
        return ad;
    }

    void SetAd(string ad) {
        this->ad = ad;
    }

    bool IsAtes() const {
        return ates;
    }

    void SetAtes(bool ates) {
        this->ates = ates;
        KoronaTespit();
    }

    int GetBagisiklikSeviye() const {
        return bagisiklikSeviye;
    }

    void SetBagisiklikSeviye(int bagisiklikSeviye) {
        this->bagisiklikSeviye = bagisiklikSeviye;
        KoronaTespit();
    }

    bool IsCorona() const {
        return corona;
    }

    void SetCorona(bool corona) {
        this->corona = corona;
        KoronaTespit();
    }

    bool IsKuruOksuruk() const {
        return kuruOksuruk;
    }

    void SetKuruOksuruk(bool kuruOksuruk) {
        this->kuruOksuruk = kuruOksuruk;
        KoronaTespit();
    }

    string GetSoyad() const {
        return soyad;
    }

    void SetSoyad(string soyad) {
        this->soyad = soyad;
    }

    string GetTcno() const {
        return tcno;
    }

    void SetTcno(string tcno) {
        this->tcno = tcno;
    }

    bool IsYorgunluk() const {
        return yorgunluk;
    }

    void SetYorgunluk(bool yorgunluk) {
        this->yorgunluk = yorgunluk;
        KoronaTespit();
    }

    friend std::ostream& operator<<(std::ostream& os, const Hasta& obj) {
        os << "TC No        : " << obj.GetTcno() << endl
                << "Ad           : " << obj.GetAd() << endl
                << "Soyad        : " << obj.GetSoyad() << endl
                << "Bagisiklik   : " << obj.GetBagisiklikSeviye() << "%" << endl
                << "Ates         : " << obj.IsAtes() << endl
                << "Kuru Oksuruk : " << obj.IsKuruOksuruk() << endl
                << "Yorgunluk    : " << obj.IsYorgunluk() << endl
                << "Corona       : " << obj.IsCorona() << endl << endl;
        return os;
    }

};

Hasta *hastalar[KAPASITE];
int indexHastalar = 0;

string tcno, ad, soyad;
bool ates, kuruOksuruk, yorgunluk, corona;
int bagisiklikSeviye;

void Sifirla() {
    tcno = "";
    ad = "";
    soyad = "";
    ates = 0;
    kuruOksuruk = 0;
    yorgunluk = 0;
    corona = 0;
    bagisiklikSeviye = 80;
}

void DosyaYaz() {
    int i;
    fstream dosya;
    dosya.open("hastalar.txt", ios::out);
    for (i = 0; i < indexHastalar; i++) {
        if (hastalar[i]->GetTcno() != "silindi") {
            dosya << hastalar[i]->GetTcno() << " "
                    << hastalar[i]->GetAd() << " "
                    << hastalar[i]->GetSoyad() << " "
                    << hastalar[i]->IsAtes() << " "
                    << hastalar[i]->IsKuruOksuruk() << " "
                    << hastalar[i]->IsYorgunluk() << " "
                    << hastalar[i]->GetBagisiklikSeviye() << " "
                    << hastalar[i]->IsCorona();
            if (i < indexHastalar - 1) {
                dosya << endl;
            }
        }
    }
    dosya.close();
}

void DosyaOku() {
    Sifirla();
    fstream dosya;
    dosya.open("hastalar.txt", ios::in);
    if (dosya.eof()) {
        dosya.close();
        return;
    }
    while (!dosya.eof()) {
        dosya >> tcno >> ad >> soyad >> ates >> kuruOksuruk >> yorgunluk >> bagisiklikSeviye >> corona;
        if (tcno == "")
            break;
        hastalar[indexHastalar++] = new Hasta(tcno, ad, soyad, ates, kuruOksuruk, yorgunluk, bagisiklikSeviye, corona);
    }
    dosya.close();
}

void menu();

int main() {
    DosyaOku();


    menu();
    return 0;
}

void HastaEkle();
void HastaSil();
void HastaAra();
void HastaDegistir();
void HastaListele();
int kontrolHasta(string tcno);

void menu() {
    cout << endl;
    cout << "1) Hasta Ekle" << endl;
    cout << "2) Hasta Sil" << endl;
    cout << "3) Hasta Ara" << endl;
    cout << "4) Hasta Guncelle" << endl;
    cout << "5) Hasta Listele" << endl;
    cout << "0) Cikis" << endl;
    cout << "Secim : ";
    int secim;
    cin >> secim;
    switch (secim) {
        case 0:
            cout << "Cikiliyor..." << endl;
            exit(0);
            break;
        case 1:
            HastaEkle();
            break;
        case 2:
            HastaSil();
            break;
        case 3:
            HastaAra();
            break;
        case 4:
            HastaDegistir();
            break;
        case 5:
            HastaListele();
            break;
        default:
            cout << "Hatali secim !!!" << endl;
            break;
    }
    menu();
}

int kontrolHasta(string tcno) {
    int i;
    for (i = 0; i < indexHastalar; i++) {
        if ((*hastalar[i]).GetTcno() == tcno)
            return i;
    }
    return -1;
}

void HastaEkle() {
    if (indexHastalar == 99) {
        cout << "Kapasite dolmustur !!!" << endl;
        return;
    }

    Sifirla();
    cout << "Tc No : ";
    cin >> tcno;
    if (kontrolHasta(tcno) != -1) {
        cout << "Hasta zaten kayitli !!!" << endl;
        return;
    }
    cout << "Ad    : ";
    cin >> ad;
    cout << "Soyad : ";
    cin >> soyad;
    cout << "Ates         [1/0] : ";
    cin >> ates;
    cout << "Kuru Oksuruk [1/0] : ";
    cin >> kuruOksuruk;
    cout << "Yorgunluk    [1/0] : ";
    cin >> yorgunluk;
    cout << "Bagisiklik [0-100] : ";
    cin >> bagisiklikSeviye;

    hastalar[indexHastalar++] = new Hasta(tcno, ad, soyad, ates, kuruOksuruk, yorgunluk, bagisiklikSeviye);
    DosyaYaz();
    cout << "Hasta eklendi." << endl;
}

void HastaSil() {
    Sifirla();
    cout << "Tc No : ";
    cin >> tcno;
    if (kontrolHasta(tcno) == -1) {
        cout << "Hasta bulunamadi !!!" << endl;
        return;
    }
    cout << endl << "HASTA BILGILERI >>" << endl << endl << *hastalar[kontrolHasta(tcno)] << endl;
    hastalar[kontrolHasta(tcno)]->SetTcno("silindi");
    DosyaYaz();
    indexHastalar = 0;
    DosyaOku();
    cout << "Hasta silindi." << endl;
}

void HastaAra() {
    Sifirla();
    cout << "Tc No : ";
    cin >> tcno;
    if (kontrolHasta(tcno) == -1) {
        cout << "Hasta bulunamadi !!!" << endl;
        return;
    }
    cout << endl << "HASTA BILGILERI >>" << endl << endl << *hastalar[kontrolHasta(tcno)] << endl;
    return;
}

void HastaDegistir() {
    Sifirla();
    cout << "Tc No : ";
    cin >> tcno;
    if (kontrolHasta(tcno) == -1) {
        cout << "Hasta bulunamadi !!!" << endl;
        return;
    }
    cout << endl << "HASTA BILGILERI >>" << endl << endl << *hastalar[kontrolHasta(tcno)] << endl << endl;
    cout << "Ad    : ";
    cin >> ad;
    cout << "Soyad : ";
    cin >> soyad;
    cout << "Ates         [1/0] : ";
    cin >> ates;
    cout << "Kuru Oksuruk [1/0] : ";
    cin >> kuruOksuruk;
    cout << "Yorgunluk    [1/0] : ";
    cin >> yorgunluk;
    cout << "Bagisiklik [0-100] : ";
    cin >> bagisiklikSeviye;

    hastalar[kontrolHasta(tcno)] = new Hasta(tcno, ad, soyad, ates, kuruOksuruk, yorgunluk, bagisiklikSeviye);
    DosyaYaz();
    cout << "Hasta degistirildi." << endl;
}

void HastaListele() {
    if (indexHastalar == 0) {
        cout << "Hic kayit bulunamadi !!!" << endl;
        return;
    }
    cout << "HASTALAR >>" << endl << endl;
    int i;
    for (i = 0; i < indexHastalar; i++) {
        cout << *hastalar[i] << endl;
    }
    cout << endl;
}