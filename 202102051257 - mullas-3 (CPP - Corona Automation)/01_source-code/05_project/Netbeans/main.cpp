#include <iostream>
#include <fstream>

#define MINBAGISIKLIK 25
#define KAPASITE 100

using namespace std;

void DosyaYaz();
void DosyaOku();

class Patient {
private:
    string secnum;
    string name;
    string surname;
    bool fever;
    bool dryCough;
    bool tiredness;
    int immuneLevel;
    bool corona;
public:

    void CoronaControl() {
        if (this->immuneLevel < MINBAGISIKLIK && (fever && dryCough && tiredness)) {
            this->corona = true;
        } else {
            this->corona = false;
        }
    }

    Patient() {
    }

    Patient(string secnum, string name, string surname) :
    secnum(secnum), name(name), surname(surname) {
        this->fever = false;
        this->dryCough = false;
        this->tiredness = false;
        this->corona = false;
        this->immuneLevel = 80;
        CoronaControl();
    }

    Patient(string secnum, string name, string surname, bool fever, bool dryCough, bool tiredness, int immuneLevel) :
    secnum(secnum), name(name), surname(surname), fever(fever), dryCough(dryCough), tiredness(tiredness), immuneLevel(immuneLevel) {
        CoronaControl();
    }

    Patient(string secnum, string name, string surname, bool fever, bool dryCough, bool tiredness, int immuneLevel, bool corona) :
    secnum(secnum), name(name), surname(surname), fever(fever), dryCough(dryCough), tiredness(tiredness), immuneLevel(immuneLevel), corona(corona) {
        CoronaControl();
    }

    string GetAd() const {
        return name;
    }

    void SetAd(string name) {
        this->name = name;
    }

    bool IsAtes() const {
        return fever;
    }

    void SetAtes(bool fever) {
        this->fever = fever;
        CoronaControl();
    }

    int GetBagisiklikSeviye() const {
        return immuneLevel;
    }

    void SetBagisiklikSeviye(int immuneLevel) {
        this->immuneLevel = immuneLevel;
        CoronaControl();
    }

    bool IsCorona() const {
        return corona;
    }

    void SetCorona(bool corona) {
        this->corona = corona;
        CoronaControl();
    }

    bool IsKuruOksuruk() const {
        return dryCough;
    }

    void SetKuruOksuruk(bool dryCough) {
        this->dryCough = dryCough;
        CoronaControl();
    }

    string GetSoyad() const {
        return surname;
    }

    void SetSoyad(string surname) {
        this->surname = surname;
    }

    string GetTcno() const {
        return secnum;
    }

    void SetTcno(string secnum) {
        this->secnum = secnum;
    }

    bool IsYorgunluk() const {
        return tiredness;
    }

    void SetYorgunluk(bool tiredness) {
        this->tiredness = tiredness;
        CoronaControl();
    }

    friend std::ostream& operator<<(std::ostream& os, const Patient& obj) {
        os << "Sec Num        : " << obj.GetTcno() << endl
                << "Name         : " << obj.GetAd() << endl
                << "Surname      : " << obj.GetSoyad() << endl
                << "Immune Level : " << obj.GetBagisiklikSeviye() << "%" << endl
                << "Fever        : " << obj.IsAtes() << endl
                << "Dry Cough    : " << obj.IsKuruOksuruk() << endl
                << "Tiredness    : " << obj.IsYorgunluk() << endl
                << "Corona       : " << obj.IsCorona() << endl << endl;
        return os;
    }

};

Patient *patients[KAPASITE];
int indexHastalar = 0;

string secnum, name, surname;
bool fever, dryCough, tiredness, corona;
int immuneLevel;

void Sifirla() {
    secnum = "";
    name = "";
    surname = "";
    fever = 0;
    dryCough = 0;
    tiredness = 0;
    corona = 0;
    immuneLevel = 80;
}

void DosyaYaz() {
    int i;
    fstream dosya;
    dosya.open("patients.txt", ios::out);
    for (i = 0; i < indexHastalar; i++) {
        if (patients[i]->GetTcno() != "deleted") {
            dosya << patients[i]->GetTcno() << " "
                    << patients[i]->GetAd() << " "
                    << patients[i]->GetSoyad() << " "
                    << patients[i]->IsAtes() << " "
                    << patients[i]->IsKuruOksuruk() << " "
                    << patients[i]->IsYorgunluk() << " "
                    << patients[i]->GetBagisiklikSeviye() << " "
                    << patients[i]->IsCorona();
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
    dosya.open("patients.txt", ios::in);
    if (dosya.eof()) {
        dosya.close();
        return;
    }
    while (!dosya.eof()) {
        dosya >> secnum >> name >> surname >> fever >> dryCough >> tiredness >> immuneLevel >> corona;
        if (secnum == "")
            break;
        patients[indexHastalar++] = new Patient(secnum, name, surname, fever, dryCough, tiredness, immuneLevel, corona);
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
int kontrolHasta(string secnum);

void menu() {
    cout << endl;
    cout << "1) Patient Add" << endl;
    cout << "2) Patient Delete" << endl;
    cout << "3) Patient Search" << endl;
    cout << "4) Patient Modify" << endl;
    cout << "5) Patient List" << endl;
    cout << "0) Exit" << endl;
    cout << "Choice : ";
    int secim;
    cin >> secim;
    switch (secim) {
        case 0:
            cout << "Exiting..." << endl;
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
            cout << "Wrong choice!!!" << endl;
            break;
    }
    menu();
}

int kontrolHasta(string secnum) {
    int i;
    for (i = 0; i < indexHastalar; i++) {
        if ((*patients[i]).GetTcno() == secnum)
            return i;
    }
    return -1;
}

void HastaEkle() {
    if (indexHastalar == 99) {
        cout << "Capacity full !!!" << endl;
        return;
    }

    Sifirla();
    cout << "Sec Num : ";
    cin >> secnum;
    if (kontrolHasta(secnum) != -1) {
        cout << "Patient already exist !!!" << endl;
        return;
    }
    cout << "Name    : ";
    cin >> name;
    cout << "Surname : ";
    cin >> surname;
    cout << "Fever         [1/0] : ";
    cin >> fever;
    cout << "Dry Cough [1/0] : ";
    cin >> dryCough;
    cout << "Tiredness    [1/0] : ";
    cin >> tiredness;
    cout << "Immune Level [0-100] : ";
    cin >> immuneLevel;

    patients[indexHastalar++] = new Patient(secnum, name, surname, fever, dryCough, tiredness, immuneLevel);
    DosyaYaz();
    cout << "Patient added." << endl;
}

void HastaSil() {
    Sifirla();
    cout << "Sec Num : ";
    cin >> secnum;
    if (kontrolHasta(secnum) == -1) {
        cout << "Patient not found !!!" << endl;
        return;
    }
    cout << endl << "PATIENT INFO >>" << endl << endl << *patients[kontrolHasta(secnum)] << endl;
    patients[kontrolHasta(secnum)]->SetTcno("deleted");
    DosyaYaz();
    indexHastalar = 0;
    DosyaOku();
    cout << "Patient deleted." << endl;
}

void HastaAra() {
    Sifirla();
    cout << "Sec Num : ";
    cin >> secnum;
    if (kontrolHasta(secnum) == -1) {
        cout << "Patient not found !!!" << endl;
        return;
    }
    cout << endl << "PATIENT INFO >>" << endl << endl << *patients[kontrolHasta(secnum)] << endl;
    return;
}

void HastaDegistir() {
    Sifirla();
    cout << "Sec Num : ";
    cin >> secnum;
    if (kontrolHasta(secnum) == -1) {
        cout << "Patient not found !!!" << endl;
        return;
    }
    cout << endl << "PATIENT INFO >>" << endl << endl << *patients[kontrolHasta(secnum)] << endl << endl;
    cout << "Name    : ";
    cin >> name;
    cout << "Surname : ";
    cin >> surname;
    cout << "Fever         [1/0] : ";
    cin >> fever;
    cout << "Dry Cough [1/0] : ";
    cin >> dryCough;
    cout << "Tiredness    [1/0] : ";
    cin >> tiredness;
    cout << "Immune Level [0-100] : ";
    cin >> immuneLevel;

    patients[kontrolHasta(secnum)] = new Patient(secnum, name, surname, fever, dryCough, tiredness, immuneLevel);
    DosyaYaz();
    cout << "Patient changed." << endl;
}

void HastaListele() {
    if (indexHastalar == 0) {
        cout << "No records found !!!" << endl;
        return;
    }
    cout << "PATIENTS >>" << endl << endl;
    int i;
    for (i = 0; i < indexHastalar; i++) {
        cout << *patients[i] << endl;
    }
    cout << endl;
}