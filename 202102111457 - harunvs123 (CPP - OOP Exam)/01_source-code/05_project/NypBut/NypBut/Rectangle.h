#pragma once
//Rectangle(dikd�rtgen) s�n�f�, Shape s�n�f�ndan kal�t�m alm��t�r
class Rectangle : public Shape
{
public:
	//sanal olarak tan�mlanan methodlar�n i�eleri doldurulmu� hali
	double getArea() //alan de�erini geri d�nd�r�r
	{
		return this->getX() * this->getY();
	}
	//sanal olarak tan�mlanan methodlar�n i�eleri doldurulmu� hali
	double getPerim() //�evre de�erini geri d�nd�r�r
	{
		return (this->getX() + this->getY()) * 2;
	}
};