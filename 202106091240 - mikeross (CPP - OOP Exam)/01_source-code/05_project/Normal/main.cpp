
#include <iostream>
#include <math.h>

using namespace std;

class Rasyonel {
private:
    int pay;
    int payda;
public:

    Rasyonel() :
    pay(2), payda(4) {
        Sadelestir();
    }

    Rasyonel(int pay, int payda) :
    pay(pay), payda(payda) {
    }

    void Sadelestir() {
        int i = 2, kucuk;
        if (pay > payda)
            kucuk = abs(payda);
        else kucuk = abs(pay);
        while (i <= kucuk) {
            if (pay % i == 0 && payda % i == 0) {
                pay /= i;
                payda /= i;
                kucuk /= i;
                i = 2;
            } else i++;
        }
    }

    Rasyonel operator+(const Rasyonel& right) const {
        int yeniPay, yeniPayda;
        if (this->payda == right.payda) {
            yeniPay = this->pay + right.pay;
            yeniPayda = this->payda;
        } else {
            yeniPay = (this->pay * right.payda) + (right.pay * this->payda);
            yeniPayda = this->payda * right.payda;
        }

        Rasyonel result(yeniPay, yeniPayda);
        result.Sadelestir();
        return result;
    }

    Rasyonel operator-(const Rasyonel& right) const {
        int yeniPay, yeniPayda;
        if (this->payda == right.payda) {
            yeniPay = this->pay - right.pay;
            yeniPayda = this->payda;
        } else {
            yeniPay = (this->pay * right.payda) - (right.pay * this->payda);
            yeniPayda = this->payda * right.payda;
        }

        Rasyonel result(yeniPay, yeniPayda);
        result.Sadelestir();
        return result;
    }

    Rasyonel operator*(const Rasyonel& right) const {
        int yeniPay, yeniPayda;

        yeniPay = this->pay * right.pay;
        yeniPayda = this->payda * right.payda;

        Rasyonel result(yeniPay, yeniPayda);
        result.Sadelestir();
        return result;
    }

    Rasyonel operator/(const Rasyonel& right) const {
        int yeniPay, yeniPayda;

        yeniPay = this->pay * right.payda;
        yeniPayda = this->payda * right.pay;

        Rasyonel result(yeniPay, yeniPayda);
        result.Sadelestir();
        return result;
    }

    int GetPay() const {
        return pay;
    }

    void SetPay(int pay) {
        this->pay = pay;
    }

    int GetPayda() const {
        return payda;
    }

    void SetPayda(int payda) {
        this->payda = payda;
    }

    void YazdirBicimA() {
        cout << this->pay << "/" << this->payda << endl;
    }

    void YazdirBicimB() {
        float sonuc = (float) pay / (float) payda;
        cout << sonuc << endl;
    }

    friend std::ostream& operator<<(std::ostream& os, const Rasyonel& obj) {
        os << obj.pay << "/" << obj.payda << endl;
        return os;
    }

    Rasyonel(const Rasyonel& other) :
    pay(other.pay), payda(other.payda) {
    }


};

int main(int argc, char** argv) {

    Rasyonel r1;
    Rasyonel r2;
    Rasyonel r3;

    int secim;
    while (1) {
        cout << "Menu" << endl;
        cout << "1) Iki kesirli sayinin toplami" << endl;
        cout << "2) Iki kesirli sayinin cikartilmasi" << endl;
        cout << "3) Iki kesirli sayinin carpilmasi" << endl;
        cout << "4) Iki kesirli sayinin bolumu" << endl;
        cout << "-1) Cikis" << endl;
        cout << "Secim : ";
        cin >> secim;
        int pay, payda;

        if (secim == -1) {
            cout << "Programdan cikiliyor..." << endl;
            return 0;
        }

        cout << "1. kesirli sayi pay : ";
        cin >> pay;
        cout << "1. kesirli sayi payda : ";
        cin >> payda;
        r1.SetPay(pay);
        r1.SetPayda(payda);

        cout << "2. kesirli sayi pay : ";
        cin >> pay;
        cout << "2. kesirli sayi payda : ";
        cin >> payda;
        r2.SetPay(pay);
        r2.SetPayda(payda);

        cout << "Degerler : " << endl;
        switch (secim) {
            case 1:
                r3 = r1 + r2;
                break;
            case 2:
                r3 = r1 - r2;
                break;
            case 3:
                r3 = r1 * r2;
                break;
            case 4:
                r3 = r1 / r2;
                break;

        }
        r1.YazdirBicimA();
        r2.YazdirBicimA();
        cout << endl << "Sonuc;";
        cout << "Kesirli : ";
        r3.YazdirBicimA();
        cout << "Ondalikli : ";
        r3.YazdirBicimB();
        cout << endl << endl;
    }
    return 0;
}

