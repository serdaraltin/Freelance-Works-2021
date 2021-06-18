#pragma once
//Rectangle(dikdörtgen) sýnýfý, Shape sýnýfýndan kalýtým almýþtýr
class Rectangle : public Shape
{
public:
	//sanal olarak tanýmlanan methodlarýn içeleri doldurulmuþ hali
	double getArea() //alan deðerini geri döndürür
	{
		return this->getX() * this->getY();
	}
	//sanal olarak tanýmlanan methodlarýn içeleri doldurulmuþ hali
	double getPerim() //çevre deðerini geri döndürür
	{
		return (this->getX() + this->getY()) * 2;
	}
};