#pragma once
#define PI 3.14

//Circle(daire) sýnýfý, Shape sýnýfýndan kalýtým almýþtýr
class Circle : public Shape
{
public:
	//sanal olarak tanýmlanan methodlarýn içeleri doldurulmuþ hali
	double getArea() //alan deðerini geri döndürür
	{
		return PI * (this->getX() * this->getX());
	}
	//sanal olarak tanýmlanan methodlarýn içeleri doldurulmuþ hali
	double getPerim() //çevre deðerini geri döndürür
	{
		return (this->getX()* PI) * 2;
	}
};