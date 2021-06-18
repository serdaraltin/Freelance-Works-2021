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

    Personel(string tcNo, string ad, string soyad, int maas, string bolum){
        printf("test\n");
    }

    string GetAd() {
        return ad;
    }

    void SetAd(string ad) {
        this->ad = ad;
    }

    string GetBolum() {
        return bolum;
    }

    void SetBolum(string bolum) {
        this->bolum = bolum;
    }

    int GetMaas() {
        return maas;
    }

    void SetMaas(int maas) {
        this->maas = maas;
    }

    string GetSoyad() {
        return soyad;
    }

    void SetSoyad(string soyad) {
        this->soyad = soyad;
    }

    string GetTcNo() {
        return tcNo;
    }

    void SetTcNo(string tcNo) {
        this->tcNo = tcNo;
    }



};

class Akademik {
private:
    string dal;
public:

    Akademik() {
    }

    string GetDal() {
        return dal;
    }

    void SetDal(string dal) {
        this->dal = dal;
    }

};
