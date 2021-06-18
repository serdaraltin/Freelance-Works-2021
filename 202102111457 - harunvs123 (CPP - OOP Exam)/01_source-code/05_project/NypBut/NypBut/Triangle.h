#pragma once
//Triangle(üçgen) sýnýfý, Shape sýnýfýndan kalýtým almýþtýr
class Triangle : public Shape
{
public:
	//sanal olarak tanýmlanan methodlarýn içeleri doldurulmuþ hali
	double getArea() //alan deðerini geri döndürür
	{
		return this->getX() * this->getY() / 2;
	}
	//sanal olarak tanýmlanan methodlarýn içeleri doldurulmuþ hali
	double getPerim() //çevre deðerini geri döndürür
	{
		return this->getX() + this->getY() + this->getZ();
	}
};