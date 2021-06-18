
#include <iostream>
#include "NypBut\NypBut\Shape.h"
#include "NypBut\NypBut\Triangle.h"
#include "NypBut\NypBut\RightTriangle.h"
#include "NypBut\NypBut\Square.h"
#include "NypBut\NypBut\Rectangle.h"
#include "NypBut\NypBut\Circle.h"

using namespace std;

//ilgili şekiller için nesne tanımlamaları
Triangle triangle;
RightTriangle righttriangle;
Square square;
Rectangle rectangle;
Circle circle;

//prototip tanımları
void menu();
void triangleMenu();
void righttangleMenu();
void squareMenu();
void rectangleMenu();
void circleMenu();

int main()
{
	cout << ">>> Hosgeldiniz <<<" << endl << endl;
	menu();
}

//ana menu
void menu()
{
	cout << "1) Ucgen Islemler" << endl;
	cout << "2) Dikucgen Islemleri" << endl;
	cout << "3) Kare Islemleri" << endl;
	cout << "4) Dikdortgen Islemleri" << endl;
	cout << "5) Daire Islemleri" << endl;
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
		triangleMenu();
		break;
	case 2:
		righttangleMenu();
		break;
	case 3:
		squareMenu();
		break;
	case 4:
		rectangleMenu();
		break;
	case 5:
		circleMenu();
		break;
	default:
		printf("Hatali secim !\n");
		break;
	}
	cout << endl;
	menu();
}


//üçgen menüsü
void triangleMenu()
{
	cout << "1) Ucgenin Alani" << endl;
	cout << "2) Ucgenin Cevresi" << endl;
	cout << "0) Ana Menu" << endl;
	cout << "Secim : ";
	int secim;
	scanf("%d", &secim);

	double x, y, z;
	switch (secim)
	{
	case 0:
		return;
		break;
	case 1:
		cout << "b : ";
		cin >> x;
		cout << "hipotenuz : ";
		cin >> y;
		//gelen değerlerin ilgili sınıfın ilgili methodu ile, ilgili değişkenine işlenmesi
		triangle.setX(x);
		triangle.setY(y);
		//ilgili sınıfın alan methodundan gelen değerin yazıdırılması
		cout << "Ucgenin Alani = " << triangle.getArea() << endl;
		break;
	case 2:
		cout << "x : ";
		cin >> x;
		cout << "y : ";
		cin >> y;
		cout << "z : ";
		cin >> z;
		//gelen değerlerin ilgili sınıfın ilgili methodu ile, ilgili değişkenine işlenmesi
		triangle.setX(x);
		triangle.setY(y);
		triangle.setZ(z);
		//ilgili sınıfın çevre methodundan gelen değerin yazıdırılması
		cout << "Ucgenin Cevresi = " << triangle.getPerim() << endl;
		break;
	default:
		printf("Hatali secim !\n");
		break;
	}
	cout << endl;
	triangleMenu();
}
//diküçgen menüsü
void righttangleMenu()
{
	cout << "1) Dikucgeninin Alani" << endl;
	cout << "2) Dikucgeninin Cevresi" << endl;
	cout << "0) Ana Menu" << endl;
	cout << "Secim : ";
	int secim;
	scanf("%d", &secim);

	double x, y, z;
	switch (secim)
	{
	case 0:
		return;
		break;
	case 1:
		cout << "b : ";
		cin >> x;
		cout << "h : ";
		cin >> y;
		//gelen değerlerin ilgili sınıfın ilgili methodu ile, ilgili değişkenine işlenmesi
		righttriangle.setX(x);
		righttriangle.setY(y);
		//ilgili sınıfın alan methodundan gelen değerin yazıdırılması
		cout << "Dikucgenin Alani = " << righttriangle.getArea() << endl;
		break;
	case 2:
		cout << "x : ";
		cin >> x;
		cout << "y : ";
		cin >> y;
		cout << "z : ";
		cin >> z;
		//gelen değerlerin ilgili sınıfın ilgili methodu ile, ilgili değişkenine işlenmesi
		righttriangle.setX(x);
		righttriangle.setY(y);
		righttriangle.setZ(z);
		//ilgili sınıfın çevre methodundan gelen değerin yazıdırılması
		cout << "Dikucgenin Cevresi = " << righttriangle.getPerim() << endl;
		break;
	default:
		printf("Hatali secim !\n");
		break;
	}
	cout << endl;
	righttangleMenu();
}
//kare menüsü
void squareMenu()
{
	cout << "1) Karenin Alani" << endl;
	cout << "2) Karenin Cevresi" << endl;
	cout << "0) Ana Menu" << endl;
	cout << "Secim : ";
	int secim;
	scanf("%d", &secim);

	double x, y, z;
	switch (secim)
	{
	case 0:
		return;
		break;
	case 1:
		cout << "x : ";
		cin >> x;
		//gelen değerin ilgili sınıfın ilgili methodu ile, ilgili değişkenine işlenmesi
		square.setX(x);
		//ilgili sınıfın alan methodundan gelen değerin yazıdırılması
		cout << "Karenin Alani = " << square.getArea() << endl;
		break;
	case 2:
		cout << "x : ";
		cin >> x;
		//gelen değerin ilgili sınıfın ilgili methodu ile, ilgili değişkenine işlenmesi
		square.setX(x);
		//ilgili sınıfın alan methodundan gelen değerin yazıdırılması
		cout << "Karenin Cevresi = " << square.getPerim() << endl;
		break;
	default:
		printf("Hatali secim !\n");
		break;
	}
	cout << endl;
	squareMenu();
}
//dikdörtgen menüsü
void rectangleMenu()
{
	cout << "1) Dikdortgenin Alani" << endl;
	cout << "2) Dikdortgenin Cevresi" << endl;
	cout << "0) Ana Menu" << endl;
	cout << "Secim : ";
	int secim;
	scanf("%d", &secim);

	double x, y, z;
	switch (secim)
	{
	case 0:
		return;
		break;
	case 1:
		cout << "x : ";
		cin >> x;
		cout << "y : ";
		cin >> y;
		//gelen değerin ilgili sınıfın ilgili methodu ile, ilgili değişkenine işlenmesi
		rectangle.setX(x);
		rectangle.setY(y);
		//ilgili sınıfın alan methodundan gelen değerin yazıdırılması
		cout << "Dikdortgenin Alani = " << rectangle.getArea() << endl;
		break;
	case 2:
		cout << "x : ";
		cin >> x;
		cout << "y : ";
		cin >> y;
		//gelen değerin ilgili sınıfın ilgili methodu ile, ilgili değişkenine işlenmesi
		rectangle.setX(x);
		rectangle.setY(y);
		//ilgili sınıfın alan methodundan gelen değerin yazıdırılması
		cout << "Dikdortgenin Cevresi = " << rectangle.getPerim() << endl;
		break;
	default:
		printf("Hatali secim !\n");
		break;
	}
	cout << endl;
	rectangleMenu();
}

//daire menüsü
void circleMenu()
{
	cout << "1) Dairenin Alani" << endl;
	cout << "2) Dairenin Cevresi" << endl;
	cout << "0) Ana Menu" << endl;
	cout << "Secim : ";
	int secim;
	scanf("%d", &secim);

	double x, y, z;
	switch (secim)
	{
	case 0:
		return;
		break;
	case 1:
		cout << "yaricap : ";
		cin >> x;
		//gelen değerlerin ilgili sınıfın ilgili methodu ile, ilgili değişkenine işlenmesi
		circle.setX(x);
		//ilgili sınıfın alan methodundan gelen değerin yazıdırılması
		cout << "Dairenin Alani = " << circle.getArea() << endl;
		break;
	case 2:
		cout << "yaricap : ";
		cin >> x;
		//gelen değerlerin ilgili sınıfın ilgili methodu ile, ilgili değişkenine işlenmesi
		circle.setX(x);
		//ilgili sınıfın çevre methodundan gelen değerin yazıdırılması
		cout << "Dairenin Cevresi = " << circle.getPerim() << endl;
		break;
	default:
		printf("Hatali secim !\n");
		break;
	}
	cout << endl;
	circleMenu();
}