//shape(þekil) sýnýfý
class Shape
{
private:
	//sýnýf içerisinde kullanýlan private deðiþkenler, özellikler
	double x, y, z;

	//sýnýf içerisindeki method tanýmlamalarý (getter, setter ve virtual(sanal) method tanýmlarý)
public:
	//x deðiþkeninin deðerinin döndürür
	double getX()
	{
		return this->x;
	}
	//y deðiþkeninin deðerinin döndürür
	double getY()
	{
		return this->y;
	}
	//z deðiþkeninin deðerinin döndürür
	double getZ()
	{
		return this->z;
	}
	//parametre olarak gelen deðeri x deðiþkenine atar
	void setX(double x)
	{
		this->x = x;
	}
	//parametre olarak gelen deðeri y deðiþkenine atar
	void setY(double y)
	{
		this->y = y;
	}
	//parametre olarak gelen deðeri z deðiþkenine atar
	void setZ(double z)
	{
		this->z = z;
	}

	//sanal method tanýmlarý alt sýnýflarda kullanýldýklarýndaki varsayýlan deðerleri
	virtual double getArea() = 0;
	virtual double getPerim() = 0;
};