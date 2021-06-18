#pragma once
#define PI 3.14

//Circle(daire) s�n�f�, Shape s�n�f�ndan kal�t�m alm��t�r
class Circle : public Shape
{
public:
	//sanal olarak tan�mlanan methodlar�n i�eleri doldurulmu� hali
	double getArea() //alan de�erini geri d�nd�r�r
	{
		return PI * (this->getX() * this->getX());
	}
	//sanal olarak tan�mlanan methodlar�n i�eleri doldurulmu� hali
	double getPerim() //�evre de�erini geri d�nd�r�r
	{
		return (this->getX()* PI) * 2;
	}
};