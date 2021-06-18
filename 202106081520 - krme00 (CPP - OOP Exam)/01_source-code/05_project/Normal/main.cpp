
#include <iostream>

#define TUR_BOYUT 3
#define DIZI_BOYUT 30

using namespace std;

class otopark {
private:
    string tasit_turu;
    double saatlik_ucreti;
    double kacsaat_kaldi;
public:

    otopark() {
    }

    otopark(string tasit_turu, double saatlik_ucreti, double kacsaat_kaldi) :
    tasit_turu(tasit_turu), saatlik_ucreti(saatlik_ucreti), kacsaat_kaldi(kacsaat_kaldi) {
    }

    otopark(string tasit_turu, double saatlik_ucreti) :
    tasit_turu(tasit_turu), saatlik_ucreti(saatlik_ucreti) {
    }

    void ucret_listesi_goster() {
        cout << this->tasit_turu << "\t\t" << this->saatlik_ucreti << endl;
    }

    void park_eden_tasit_bilgisi_doldur(otopark gelen_tasit, double kac_saat) {
        this->tasit_turu = gelen_tasit.tasit_turu;
        this->saatlik_ucreti = gelen_tasit.saatlik_ucreti;
        this->kacsaat_kaldi = kac_saat;
    }

    double ciro_hesapla() {
        return this->saatlik_ucreti * this->kacsaat_kaldi;
    }

    void park_listesi() {
        cout << this->tasit_turu << " " << this->kacsaat_kaldi << " saat park etti" << endl;
    }

    double getKacsaat_kaldi() const {
        return kacsaat_kaldi;
    }

    void setKacsaat_kaldi(double kacsaat_kaldi) {
        this->kacsaat_kaldi = kacsaat_kaldi;
    }

    double getSaatlik_ucreti() const {
        return saatlik_ucreti;
    }

    void setSaatlik_ucreti(double saatlik_ucreti) {
        this->saatlik_ucreti = saatlik_ucreti;
    }

    string getTasit_turu() const {
        return tasit_turu;
    }

    void setTasit_turu(string tasit_turu) {
        this->tasit_turu = tasit_turu;
    }

};

int main(int argc, char** argv) {
    otopark tasit_turleri[TUR_BOYUT] = {otopark("araba", 1.5),
        otopark("minibus", 3),
        otopark("kamyon", 4.5)};



    otopark park_eden_dizisi[DIZI_BOYUT];

    int sayac;
    for (sayac = 0; sayac < DIZI_BOYUT; sayac++) {

        cout << "Tasit turu No,\tTasit Turu,\tSaatlik Icret\n";
        cout << "----------------------------------------------" << endl;

        int i;
        for (i = 0; i < TUR_BOYUT; i++) {
            cout << i << "\t\t";
            tasit_turleri[i].ucret_listesi_goster();
        }
        cout << endl;

        cout << "Park eden tasit turu No giriniz: ";
        int secim;
        cin >> secim;
        cout << "Kac saat park etti: ";
        double kac_saat_kaldi;
        cin >> kac_saat_kaldi;
        park_eden_dizisi[sayac].park_eden_tasit_bilgisi_doldur(tasit_turleri[secim], kac_saat_kaldi);
        cout << (sayac+1) << ". park eden tasit cirosu: " << park_eden_dizisi[sayac].ciro_hesapla() << " TL" << endl << endl;
        cout << "Yeni park bilgisi girecek misiniz? (E,H): ";
        string cevap;
        cin >> cevap;
        if (cevap == "H") {
            break;
        }
        cout << "----------------------------------------------" << endl;
    }
    cout << "\nPark Listesi" << endl << "-----------------------------" << endl;
    int i;
    double toplam_ciro = 0;
    for (i = 0; i <= sayac; i++) {
        cout << (i + 1) << "-> ";
        park_eden_dizisi[i].park_listesi();
        toplam_ciro += park_eden_dizisi[i].ciro_hesapla();
    }

    cout << "\nToplam" << sayac << " adet tasit park etti" << endl;
    cout << "Toplam cironuz: " << toplam_ciro << " TL" << endl;

    return 0;
}

