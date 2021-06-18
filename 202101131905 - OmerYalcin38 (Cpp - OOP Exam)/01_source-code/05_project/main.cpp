
#include <iostream>

using namespace std;

class Sekil
{
private:
    double x, y, z;

public:
    double getX()
    {
        return this->x;
    }
    double getY()
    {
        return this->y;
    }
    double getZ()
    {
        return this->z;
    }

    void setX(double x)
    {
        this->x = x;
    }

    void setY(double y)
    {
        this->y = y;
    }

    void setZ(double z)
    {
        this->z = z;
    }

    virtual double getAlan() = 0;
    virtual double getCevre() = 0;
};

class Ucgen : public Sekil
{
public:
    double getAlan()
    {
        return this->getX() * this->getY() / 2;
    }
    double getCevre()
    {
        return this->getX() + this->getY() + this->getZ();
    }
};

class Dikucgen : public Sekil
{
public:
    double getAlan()
    {
        return this->getX() * this->getY() / 2;
    }
    double getCevre()
    {
        return this->getX() + this->getY() + this->getZ();
    }
};

class Kare : public Sekil
{
public:
    double getAlan()
    {
        return this->getX() * this->getX();
    }
    double getCevre()
    {
        return this->getX() * 4;
    }
};

class Dikdortgen : public Sekil
{
public:
    double getAlan()
    {
        return this->getX() * this->getY();
    }
    double getCevre()
    {
        return (this->getX() + this->getY()) * 2;
    }
};

void menu();

int main()
{
    menu();
}

void menu()
{
    Ucgen ucgen;
    Dikucgen dikucgen;
    Kare kare;
    Dikdortgen dikdortgen;

    cout << "1) Ucgen Alan " << endl;
    cout << "2) Ucgen Cevre " << endl;
    cout << "3) Dikucgen Alan" << endl;
    cout << "4) Dikucgen Cevre" << endl;
    cout << "5) Kare Alan" << endl;
    cout << "6) Kare Cevre" << endl;
    cout << "7) Dikdortgen Alan" << endl;
    cout << "8) Dikdortgen Cevre" << endl;
    cout << "0) Cikis" << endl;
    cout << "Secim : ";
    int secim;
    scanf("%d", &secim);

    double x, y, z;
    switch (secim)
    {
    case 0:
        printf("Cikiliyor...\n");
        exit(1);
        break;
    case 1:
        cout << "b : ";
        cin >> x;
        cout << "h : ";
        cin >> y;
        ucgen.setX(x);
        ucgen.setY(y);
        cout << "Ucgenin Alani = " << ucgen.getAlan() << endl;
        break;
    case 2:
        cout << "a : ";
        cin >> x;
        cout << "b : ";
        cin >> y;
        cout << "c : ";
        cin >> z;
        ucgen.setX(x);
        ucgen.setY(y);
        ucgen.setZ(z);
        cout << "Ucgenin Cevresi = " << ucgen.getCevre() << endl;
        break;
    case 3:
        cout << "b : ";
        cin >> x;
        cout << "h : ";
        cin >> y;
        dikucgen.setX(x);
        dikucgen.setY(y);
        cout << "Dikucgenin Alani = " << dikucgen.getAlan() << endl;
        break;
    case 4:
        cout << "a : ";
        cin >> x;
        cout << "b : ";
        cin >> y;
        cout << "c : ";
        cin >> z;
        dikucgen.setX(x);
        dikucgen.setY(y);
        dikucgen.setZ(z);
        cout << "Dikucgenin Cevresi = " << dikucgen.getCevre() << endl;
        break;
    case 5:
        cout << "a : ";
        cin >> x;
        kare.setX(x);
        cout << "Karenin Alani = " << kare.getAlan() << endl;
        break;
    case 6:
        cout << "a : ";
        cin >> x;
        kare.setX(x);
        cout << "Karenin Alani = " << kare.getCevre() << endl;
        break;
    case 7:
        cout << "g : ";
        cin >> x;
        cout << "y : ";
        cin >> y;
        dikdortgen.setX(x);
        dikdortgen.setY(y);
        cout << "Karenin Alani = " << dikdortgen.getAlan() << endl;
        break;
    case 8:
        cout << "g : ";
        cin >> x;
        cout << "y : ";
        cin >> y;
        dikdortgen.setX(x);
        dikdortgen.setY(y);
        cout << "Karenin Alani = " << dikdortgen.getCevre() << endl;
        break;
    default:
        break;
    }
    cout << endl;
    menu();
}