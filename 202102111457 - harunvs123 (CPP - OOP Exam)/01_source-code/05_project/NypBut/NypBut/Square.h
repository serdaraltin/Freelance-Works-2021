#pragma once
//Square(square) sınıfı, Shape sınıfından kalıtım almıştır
class Square : public Shape
{
public:
	//sanal olarak tanımlanan methodların içeleri doldurulmuş hali
	double getArea() //alan değerini geri döndürür
	{
		return this->getX() * this->getX();
	}
	//sanal olarak tanımlanan methodların içeleri doldurulmuş hali
	double getPerim() //çevre değerini geri döndürür
	{
		return this->getX() * 4;
	}
};