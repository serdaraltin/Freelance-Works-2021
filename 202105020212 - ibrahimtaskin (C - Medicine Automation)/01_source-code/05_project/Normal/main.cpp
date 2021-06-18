#include <stdlib.h>
#include <fstream>
#include <iostream>
#include <string>

using namespace std;

#define PAROLA "12345"
#define ECZANE_SAYI 4
#define ILAC_SAYI 10
#define DOSYA_ECZANE "eczane_listesi.dat"

class eczn {
    int eczn_id;
    string eczn_isim = "";
    string eczn_adres = "";

public:

    eczn() {
    }

    eczn(int eczn_id, string eczn_isim, string eczn_adres) :
    eczn_id(eczn_id), eczn_isim(eczn_isim), eczn_adres(eczn_adres) {
    }

    eczn(const eczn& other) :
    eczn_id(other.eczn_id), eczn_isim(other.eczn_isim), eczn_adres(other.eczn_adres) {
    }

    void eczn_olustur();
    void eczn_goster();
    void eczn_ilac_sayfasi();

    string getEczn_adres() const {
        return eczn_adres;
    }

    void setEczn_adres(string eczn_adres) {
        this->eczn_adres = eczn_adres;
    }

    int getEczn_id() const {
        return eczn_id;
    }

    void setEczn_id(int eczn_id) {
        this->eczn_id = eczn_id;
    }

    string getEczn_isim() const {
        return eczn_isim;
    }

    void setEczn_isim(string eczn_isim) {
        this->eczn_isim = eczn_isim;
    }

    eczn& operator=(const eczn& right) {
        this->eczn_id = right.eczn_id;
        this->eczn_isim = right.eczn_isim;
        this->eczn_adres = right.eczn_adres;
        return *this;
    }

};

class ilac {
    int ilac_id;
    int ilac_sayisi;
    double ilac_fiyati;
    string ilac_isim = "";

public:

    ilac() {
    }

    ilac(int ilac_id, string ilac_isim, double ilac_fiyati, int ilac_sayisi) :
    ilac_id(ilac_id), ilac_sayisi(ilac_sayisi), ilac_fiyati(ilac_fiyati), ilac_isim(ilac_isim) {
    }

    ilac(const ilac& other) :
    ilac_id(other.ilac_id), ilac_sayisi(other.ilac_sayisi), ilac_fiyati(other.ilac_fiyati), ilac_isim(other.ilac_isim) {
    }


    void ilac_olustur();
    void ilac_goster();
    void ilac_duzenle();

    double getIlac_fiyati() const {
        return ilac_fiyati;
    }

    void setIlac_fiyati(double ilac_fiyati) {
        this->ilac_fiyati = ilac_fiyati;
    }

    int getIlac_id() const {
        return ilac_id;
    }

    void setIlac_id(int ilac_id) {
        this->ilac_id = ilac_id;
    }

    string getIlac_isim() const {
        return ilac_isim;
    }

    void setIlac_isim(string ilac_isim) {
        this->ilac_isim = ilac_isim;
    }

    int getIlac_sayisi() const {
        return ilac_sayisi;
    }

    void setIlac_sayisi(int ilac_sayisi) {
        this->ilac_sayisi = ilac_sayisi;
    }

    ilac& operator=(const ilac& right) {
        this->ilac_id = right.ilac_id;
        this->ilac_sayisi = right.ilac_sayisi;
        this->ilac_fiyati = right.ilac_fiyati;
        this->ilac_isim = right.ilac_isim;
        return *this;
    }

};

int eczaneAdet = 0;
eczn eczaneler[ECZANE_SAYI];

int ilacAdet[ECZANE_SAYI];
ilac ilaclar[ECZANE_SAYI][ILAC_SAYI];

void menu();
void eczane_menu();
void musteri_menu();

void eczaneleri_goster();
void eczane_listesi_olustur();
void eczn_ekle();
void ilac_ekle();
void ilac_duzenle();

void ilac_listele();
void ilac_ara();

void herhangi_bir_eczane();
void herhangi_bir_eczane_ilac_liste();

void eczane_oku();
void ilac_oku();

void ilac_yaz();
void eczane_yaz();

bool eczane_kontrol(int id);
bool ilac_kontrol(int id);
bool ilac_kontrol(string isim);

void eczn::eczn_olustur() {
    cout << "Id: ";
    int gecici_id;
    cin>> gecici_id;
    if (eczane_kontrol(gecici_id)) {
        cout << "Ayni kayit zaten var !" << endl;
        return;
    }
    this->eczn_id = gecici_id;
    cout << "Isim: ";
    cin>>this->eczn_isim;
    cout << "Adres: ";
    cin>>this->eczn_adres;
}

void eczn::eczn_goster() {

    cout << endl << "Id: " << this->eczn_id << endl;
    cout << "Isim: " << this->eczn_isim << endl;
    cout << "Adres: " << this->eczn_adres << endl;

}

void eczn::eczn_ilac_sayfasi() {
    ilac_yaz();
}

void ilac::ilac_olustur() {

    cout << endl << "Id: ";
    int gecici_id;
    cin>> gecici_id;
    if (ilac_kontrol(gecici_id)) {
        cout << "Ayni kayit zaten var !" << endl;

        return;
    }
    this->ilac_id = gecici_id;
    cout << "Isim: ";
    cin>>this->ilac_isim;
    cout << "Fiyat: ";
    cin>>this->ilac_fiyati;
    cout << "Sayi: ";
    cin>>this->ilac_sayisi;

    cout << "Ilac olusturuldu." << endl;
}

void ilac::ilac_duzenle() {
    cout << "Isim: ";
    string gecici_isim;
    cin>>gecici_isim;
    if (ilac_kontrol(gecici_isim)) {
        cout << "Ayni isimde zaten kayit var !" << endl;
        return;
    }
    this->ilac_isim = gecici_isim;
    cout << "Fiyat: ";
    cin>>this->ilac_fiyati;
    cout << "Sayi: ";
    cin>>this->ilac_sayisi;
}

void ilac::ilac_goster() {
    cout << endl << "Id: " << this->ilac_id << endl;
    cout << "Isim: " << this->ilac_isim << endl;
    cout << "Fiyat: " << this->ilac_fiyati << endl;
    cout << "Sayi: " << this->ilac_sayisi << endl << endl;
}

int main(int argc, char** argv) {
    cout << "Hicbir girdide bosluk birakmayiniz !" << endl;
    eczane_oku();
    ilac_oku();
    menu();
    return 0;
}

void menu() {
    cout << endl;
    cout << "1) Eczane Girisi" << endl;
    cout << "2) Musteri Girisi" << endl;
    cout << "0) Cikis" << endl;
    cout << "Secim: ";
    int secim;
    cin >> secim;
    string parola = "";
    switch (secim) {
        case 0:
            cout << "Programdan cikiliyor..." << endl;
            exit(0);
            break;
        case 1:
            cout << "Parola: ";

            cin >> parola;
            if (PAROLA != parola) {
                cout << "Hatali parola !" << endl;
                break;
            }
            eczane_menu();
            break;
        case 2:
            musteri_menu();
            break;
        default:
            cout << "Hatali secim !!!" << endl;
            break;
    }

    menu();
}

void eczane_menu() {
    cout << endl;
    cout << "1) Eczane Listesi Olustur" << endl;
    cout << "2) Eczane Ekle" << endl;
    cout << "3) Ilac Ekle" << endl;
    cout << "4) Ilac Duzenle" << endl;
    cout << "0) Ana Menu" << endl;
    cout << "Secim: ";
    int secim;
    cin >> secim;

    switch (secim) {
        case 0:
            return;
        case 1:
            eczane_listesi_olustur();
            break;
        case 2:
            eczn_ekle();
            break;
        case 3:
            ilac_ekle();
            break;
        case 4:
            ilac_duzenle();
            break;
        default:
            cout << "Hatali secim !!!" << endl;
            break;
    }
    eczane_menu();
}

void musteri_menu() {
    cout << endl;
    cout << "1) Ilac Ara" << endl;
    cout << "2) Eczane Listele" << endl;
    cout << "3) Herhangi bir Eczaneyi Goster" << endl;
    cout << "4) Herhangi bir Eczaneye ait Ilac Listesi" << endl;
    cout << "0) Ana Menu" << endl;
    cout << "Secim: ";
    int secim;
    cin >> secim;

    switch (secim) {
        case 0:
            return;
        case 1:
            ilac_ara();
            break;
        case 2:
            eczaneleri_goster();
            break;
        case 3:
            herhangi_bir_eczane();
            break;
        case 4:
            herhangi_bir_eczane_ilac_liste();
            break;
        default:
            cout << "Hatali secim !!!" << endl;
            break;
    }
    musteri_menu();
}

void eczane_listesi_olustur() {

    for (eczaneAdet = 0; eczaneAdet < ECZANE_SAYI; eczaneAdet++) {
        cout << (eczaneAdet + 1) << ". Eczaneye ait bilgileri giriniz !" << endl;
        eczaneler[eczaneAdet].eczn_olustur();
        cout << "Devam etmek istiyor musunuz? (E/H): ";
        string cevap;
        cin >> cevap;
        if (!(cevap == "E" || cevap == "e"))
            break;
    }
    eczane_yaz();
    return;
}

void ilac_ara() {
    cout << "Ilac Ismi: ";
    string ilac_isim;
    cin >> ilac_isim;

    int i, bulunma = 0;
    for (i = 0; i < ECZANE_SAYI; i++) {
        if (eczaneler[i].getEczn_isim() == "") {
            continue;
        }
        cout << "Eczane: " << eczaneler[i].getEczn_isim() << " >> " << endl;
        int j;
        for (j = 0; j < ilacAdet[i]; j++) {
            if (ilaclar[i][j].getIlac_isim() == ilac_isim) {
                cout << "Sayi: " << ilaclar[i][j].getIlac_sayisi() << endl;
                cout << "Fiyat: " << ilaclar[i][j].getIlac_fiyati() << endl << endl;
                bulunma = 1;
            }
        }
    }
    if (bulunma == 0) {
        cout << "Ilac bulunamadi!" << endl;
        return;
    }

}

void herhangi_bir_eczane() {
    cout << "Eczane Ismi: ";
    string eczane_isim;
    cin >> eczane_isim;

    int i;
    for (i = 0; i < ECZANE_SAYI; i++) {
        if (eczaneler[i].getEczn_isim() == eczane_isim) {
            eczaneler[i].eczn_goster();
            break;
        }
    }

    if (i == 4) {
        cout << "Eczane bulunamadi !" << endl;
    }

}

void herhangi_bir_eczane_ilac_liste() {
    cout << "Eczane Ismi: ";
    string eczane_isim;
    cin >> eczane_isim;

    int i;
    for (i = 0; i < ECZANE_SAYI; i++) {
        if (eczaneler[i].getEczn_isim() == eczane_isim) {
            cout << "Eczana Bilgileri >> " << endl;
            eczaneler[i].eczn_goster();
            break;
        }
    }

    if (i == 4) {
        cout << "Eczane bulunamadi !" << endl;
        return;
    }
    cout << "--------------------------------------------------";
    int j;
    for (j = 0; j < ilacAdet[i]; j++) {
        if (ilaclar[i][j].getIlac_isim() != "")
            ilaclar[i][j].ilac_goster();
    }
}

void eczane_oku() {
    ifstream dosya;
    dosya.open(DOSYA_ECZANE);
    if (dosya.is_open()) {
        int eczn_id;
        string eczn_isim = "";
        string eczn_adres = "";


        for (eczaneAdet = 0; !dosya.eof() && eczaneAdet < ECZANE_SAYI; eczaneAdet++) {
            dosya >> eczn_id >> eczn_isim >> eczn_adres;
            eczaneler[eczaneAdet] = eczn(eczn_id, eczn_isim, eczn_adres);
        }
    }
    dosya.close();
}

void eczane_yaz() {
    ofstream dosya;
    dosya.open(DOSYA_ECZANE, ios::out);

    int i;
    for (i = 0; i < eczaneAdet; i++) {
        dosya << eczaneler[i].getEczn_id() << " "
                << eczaneler[i].getEczn_isim() << " "
                << eczaneler[i].getEczn_adres();
        if (i + 1 < eczaneAdet)
            dosya << "\n";
    }

    dosya.close();
}

void eczaneleri_goster() {
    //dosya oku (eczane_listesi.dat)
    eczane_oku();

    cout << "Eczane Listesi >> " << endl;
    int i;
    for (i = 0; i < eczaneAdet; i++) {
        eczaneler[i].eczn_goster();
    }
}

void eczn_ekle() {
    if (eczaneAdet >= 4) {
        cout << "Daha fazla eczane eklenemez !" << endl;
        return;
    }
    cout << "Eczane Ekle >> " << endl << endl;
    eczaneler[eczaneAdet++].eczn_olustur();


    //dosya yaz (eczane_listesi.dat)
    eczane_yaz();

}

void ilac_ekle() {
    cout << "Eczane Ismi: ";
    string eczane_isim;
    cin >> eczane_isim;

    int i;
    for (i = 0; i < ECZANE_SAYI; i++) {
        if (eczaneler[i].getEczn_isim() == eczane_isim) {
            cout << "Eczana Bilgileri >> " << endl;
            eczaneler[i].eczn_goster();
            break;
        }
    }

    if (i == 4) {
        cout << "Eczane bulunamadi !" << endl;
        return;
    }

    if (ilacAdet[i] >= 10) {
        cout << "Daha fazla ilac eklenemez !" << endl;
        return;
    }
    ilaclar[i][(ilacAdet[i])++].ilac_olustur();

    //dosya yaz (eczaneismi_ilac.dat)
    ilac_yaz();
}

void ilac_oku() {
    int i;
    for (i = 0; i < eczaneAdet; i++) {

        int ilac_id;
        int ilac_sayisi;
        double ilac_fiyati;
        string ilac_isim = "";

        ifstream dosya;
        const string dosyaIsmi = eczaneler[i].getEczn_isim() + "_ilac.dat";
        dosya.open(dosyaIsmi.c_str());
        if (dosya.is_open()) {
            for (ilacAdet[i] = 0; !dosya.eof() && ilacAdet[i] < ILAC_SAYI; ilacAdet[i]++) {
                int j = ilacAdet[i];
                dosya >> ilac_id >> ilac_isim >> ilac_fiyati >> ilac_sayisi;
                ilaclar[i][j] = ilac(ilac_id, ilac_isim, ilac_fiyati, ilac_sayisi);
            }
        }
        dosya.close();
    }
}

void ilac_yaz() {
    int i;
    for (i = 0; i < eczaneAdet; i++) {
        int j;
        ofstream dosya;
        string dosyaIsmi = eczaneler[i].getEczn_isim() + "_ilac.dat";
        dosya.open(dosyaIsmi.c_str(), ios::out);

        for (j = 0; j < ilacAdet[i]; j++) {
            dosya << ilaclar[i][j].getIlac_id() << " "
                    << ilaclar[i][j].getIlac_isim() << " "
                    << ilaclar[i][j].getIlac_fiyati() << " "
                    << ilaclar[i][j].getIlac_sayisi();
            if (j + 1 < ilacAdet[i])
                dosya << "\n";
        }

        dosya.close();
    }
}

void ilac_duzenle() {
    cout << "Eczane Ismi: ";
    string eczane_isim;
    cin >> eczane_isim;

    int i;
    for (i = 0; i < ECZANE_SAYI; i++) {
        if (eczaneler[i].getEczn_isim() == eczane_isim) {
            cout << "Eczana Bilgileri >> " << endl;
            eczaneler[i].eczn_goster();
            break;
        }
    }

    if (i == 4) {
        cout << "Eczane bulunamadi !" << endl;
        return;
    }
    cout << "Ilac Ismi: ";
    string ilac_isim;
    cin >> ilac_isim;
    int j;
    for (j = 0; j < ilacAdet[i]; j++) {
        if (ilaclar[i][j].getIlac_isim() == ilac_isim) {
            ilaclar[i][j].ilac_goster();
            break;
        }
    }
    if (j >= 10) {
        cout << "Ilac bulunamadi !" << endl;
        return;
    }

    ilaclar[i][j].ilac_duzenle();

    //dosya yaz (eczaneismi_ilac.dat)
    ilac_yaz();
}

bool eczane_kontrol(int id) {
    int i;
    for (i = 0; i < eczaneAdet; i++) {
        if (eczaneler[i].getEczn_id() == id) {
            return true;
        }
    }
    return false;
}

bool ilac_kontrol(int id) {
    int i;
    for (i = 0; i < eczaneAdet; i++) {
        int j;
        for (j = 0; j < ilacAdet[i]; j++) {
            if (ilaclar[i][j].getIlac_id() == id) {
                return true;
            }
        }
    }
    return false;
}

bool ilac_kontrol(string isim) {
    int i;
    for (i = 0; i < eczaneAdet; i++) {
        int j;
        for (j = 0; j < ilacAdet[i]; j++) {
            if (ilaclar[i][j].getIlac_isim() == isim) {
                return true;
            }
        }
    }
    return false;
}
