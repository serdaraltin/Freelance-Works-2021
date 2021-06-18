/*
 * @Yazar
 * Öğrenci adı: !! buraya girin !!
 * Öğrenci Kimliği : !! buraya girin !!
 * Tarih:
 */

#include <iostream>
#include <vector>
#include <fstream>

using namespace std;

class Sehir {
private:
public:
    int ID;
    string isim;
    int miktar;

    Sehir() {
    }

    Sehir(int ID, string isim, int miktar) :
    ID(ID), isim(isim), miktar(miktar) {
    }

    bool operator==(const Sehir& right) const {
        bool result = false;
        return result;
    }
};

class SehirListesi : public Sehir {
private:
public:
    vector<Sehir> kayitlar;

    SehirListesi() {
    }

    SehirListesi(string dosyaAdi) {
        this->kayitlar = new vector();
        fstream dosya;
        dosya.open(dosyaAdi, ios::in);
        if (dosya.eof()) {
            dosya.close();
            return;
        }
        while (!dosya.eof()) {
            
        }
    }

    void print() {

    }

    SehirListesi operator+(const SehirListesi& right) const {

        return;
    }

    SehirListesi operator-(const SehirListesi& right) const {

        return;
    }

    SehirListesi operator&(const SehirListesi& right) const {

        return;
    }

    bool operator==(const SehirListesi& right) const {

        return false;
    }

    friend std::ostream& operator<<(std::ostream& os, const SehirListesi& obj) {
    
        return os;
    }

};

int main() {
    SehirListesi S1("sehirler1.txt");
    SehirListesi S2("sehirler2.txt");

    if (S1 == S2) {
        cout << "S1, S2' ye esittir." << endl;
    } else {
        cout << "S1, S2' ye esit degildir." << endl;
    }

    SehirListesi L1 = S1 + S2;
    SehirListesi L2 = S1 & S2;
    SehirListesi L3 = S1 - S2;
    SehirListesi L4 = S2 - S1;

    cout << "L1 >>" << endl;
    cout << L1 << endl;

    cout << "L2 >>" << endl;
    cout << L2 << endl;

    cout << "L3 >>" << endl;
    cout << L3 << endl;

    cout << "L4 >>" << endl;
    cout << L4 << endl;

    string cikis;
    cout << endl << "Cikmak icin herhangi bir tusa basiniz.";
    cin >> cikis;

    return 0;
}

