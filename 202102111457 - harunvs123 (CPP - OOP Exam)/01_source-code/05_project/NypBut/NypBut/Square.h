#pragma once
//Square(square) s�n�f�, Shape s�n�f�ndan kal�t�m alm��t�r
class Square : public Shape
{
public:
	//sanal olarak tan�mlanan methodlar�n i�eleri doldurulmu� hali
	double getArea() //alan de�erini geri d�nd�r�r
	{
		return this->getX() * this->getX();
	}
	//sanal olarak tan�mlanan methodlar�n i�eleri doldurulmu� hali
	double getPerim() //�evre de�erini geri d�nd�r�r
	{
		return this->getX() * 4;
	}
};