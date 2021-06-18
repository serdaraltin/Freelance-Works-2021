//shape(�ekil) s�n�f�
class Shape
{
private:
	//s�n�f i�erisinde kullan�lan private de�i�kenler, �zellikler
	double x, y, z;

	//s�n�f i�erisindeki method tan�mlamalar� (getter, setter ve virtual(sanal) method tan�mlar�)
public:
	//x de�i�keninin de�erinin d�nd�r�r
	double getX()
	{
		return this->x;
	}
	//y de�i�keninin de�erinin d�nd�r�r
	double getY()
	{
		return this->y;
	}
	//z de�i�keninin de�erinin d�nd�r�r
	double getZ()
	{
		return this->z;
	}
	//parametre olarak gelen de�eri x de�i�kenine atar
	void setX(double x)
	{
		this->x = x;
	}
	//parametre olarak gelen de�eri y de�i�kenine atar
	void setY(double y)
	{
		this->y = y;
	}
	//parametre olarak gelen de�eri z de�i�kenine atar
	void setZ(double z)
	{
		this->z = z;
	}

	//sanal method tan�mlar� alt s�n�flarda kullan�ld�klar�ndaki varsay�lan de�erleri
	virtual double getArea() = 0;
	virtual double getPerim() = 0;
};