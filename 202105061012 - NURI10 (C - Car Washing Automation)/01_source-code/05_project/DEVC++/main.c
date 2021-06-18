//ilgii kutuphanelerin dahil edilmesi
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//program icerisinde degismeyecek, sabit degerlerin tanimlanmasi (on islemci komutlari)
#define INPUT_FILE "input.txt"
#define TIME_NORMAL 10
#define TIME_LUX 20
#define STRING_LUX "luksus"
#define STRING_NORMAL "alm"

//araba bilgisi icin struct tanimi (araba bilgileri tutulur)
struct car {
	char numberPlate[8];
	char brand[20];
	char type[10];
};
typedef struct car Car;

//her bir yikama bilgisinin tutulmasi icin dugum tanimlamasi
struct node {
	struct car *data;
	struct node *next;
};
typedef struct node Node;

//baslangic kaydinin tutulacagi dugum
Node *root = NULL;
//son kayding tutulacagi durum
Node *last = NULL;

//kuyruga yeni bir eleman ekleme islemi
void enqueue(Car *data) {
	//eger kuyruk tamamen bos ise
	if (root == NULL) {
		root = (Node *)malloc(sizeof(Node));
		root->data = data;
		root->next = NULL;
		last = root;
		return;
	}
	//kuyruk bos degis ise
	last->next = (Node *)malloc(sizeof(Node));
	last->next->data = data;
	last = last->next;
	last->next = NULL;
	return;
}

//kuyruktaki ilk elemanin cikarilmesi
Car *dequeue() {
	//kuyrugun tamamen bos olmasi durumu
	if (root == NULL) {
		printf("Queue is empty\n");
		return NULL;
	}

	Car *rvalue = root->data;
	Node *temp = root;
	root = root->next;
	free(temp);

	return rvalue;
}

//belirtilen bilgilere sahip yeni bir araba yapisinin olusturulmasi ve geri dondurulmesi 
Car *newCar(char numberPlate[], char brand[], char type[]) {
	Car *new_car = (Car *)malloc(sizeof(Car));
	strcpy(new_car->numberPlate, numberPlate);
	strcpy(new_car->brand, brand);
	strcpy(new_car->type, type);
	return new_car;
}

//parametre olarak gelen araba yapisinin ekrana bastirilmasi
void PrintCar(Car *data) {
	//yapi bos ise geriye donulmesi
	if (data == NULL)
		return;
	printf("Number Plate : %s\n", data->numberPlate);
	printf("Brand        : %s\n", data->brand);
	printf("Type         : %s\n", data->type);
	return;
}

//spesifik bir dugumun silinmesi
void delete(Node *node) {
	//kuyruk bos ise
	if (root == NULL) {
		printf("Queue is empty\n");
		return;
	}
	//ilk dugumden baslanip dugume kadar ilerlenilmesi
	Node *iter = root;
	while (iter->next != node)
		iter = iter->next;

	//dugumun aradan kaldirilmesi
	Node *temp = iter->next;
	iter->next = iter->next->next;
	//bellegin temizlenmesi
	free(temp);
	return;
}

//109-132 daha sonradan yazilacak fonksiyonlarin prototip tanimlamalari
void menu();
void ReadFile(char filePath[]);
void ListAll();

Node *RecordControl(char numberPlate[]);
int CalculateWaitTime(Node *node);
Car *GetNumberOfCar(int number);
void PrintOrder(char type[]);

int CalculateQueueSize();
void AddRecord();
void FirstCar();
void LongestWaiting();
void NowWashedCar();
void NumberOfCar();
void TotalWashingTime();
void CalculateWaitingTime();
void NormalWashingOrder();
void LuxWashingOrder();
void ByNumberPate();
void DeleteFromQueue();
void ChangeWashType();
void ListAllWithDetail();

//programin baslangic fonksiyonu
int main() {
	//ilgili dosyadan kayitlarin okunmasi
	ReadFile(INPUT_FILE);
	//menunun cagrilmasi
	menu();
	return 0;
}

void menu() {

	printf("1) Add record\n");
	printf("2) First car\n");
	printf("3) Longest waiting\n");
	printf("4) Now washed car\n");
	printf("5) Number of the car\n");
	printf("6) Total washing time\n");
	printf("7) Calculate waiting time\n");
	printf("8) Normal washing order\n");
	printf("9) Luxury washing order\n");
	printf("10) By number pate\n");
	printf("11) Delete from queue\n");
	printf("12) Change washing type\n");
	printf("13) List all \n");
	printf("14) List all details\n");
	printf("0) Exit\n");
	printf("Choice: ");
	int choice;
	//secimin okunmasi
	scanf("%d", &choice);
	printf("\n");


	//yapilan secime gore ilgili fonksiyonun cagrilmasi veya islemin yapilmasi
	switch (choice) {
	case 0:
		printf("Exiting the program...\n");
		//programdan hatasiz cikilmasi
		exit(0);
		break;
	case 1:
		AddRecord();
		break;
	case 2:
		FirstCar();
		break;
	case 3:
		LongestWaiting();
		break;
	case 4:
		NowWashedCar();
		break;
	case 5:
		NumberOfCar();
		break;
	case 6:
		TotalWashingTime();
		break;
	case 7:
		CalculateWaitingTime();
		break;
	case 8:
		NormalWashingOrder();
		break;
	case 9:
		LuxWashingOrder();
		break;
	case 10:
		ByNumberPate();
		break;
	case 11:
		DeleteFromQueue();
		break;
	case 12:
		ChangeWashType();
		break;
	case 13:
		ListAll();
		break;
	case 14:
		ListAllWithDetail();
		break;
	default:
		printf("Wrong choice !\n");
		break;
	}
	printf("\n");
	//islem bitiminde tekrar menuye donulmesi
	menu();
}

//parametre olarak gelen dosya yolu bilgisindeki dosyadan degerlerin okunup kuyruga eklenmesi
void ReadFile(char filePath[]) {
	FILE *file;
	file = fopen(filePath, "r");

	//dosyanin bulunamamasi
	if (file == NULL) {
		printf("File no found !\n");
		return;
	}
	while (!feof(file)) {
		char numberPlate[8];
		char brand[20];
		char type[10];

		//o anki satirin okunup degerlerin ilgili degiskenlere atanmasi
		fscanf(file, "%s %s %s\n", numberPlate, brand, type);
		//ilgili verilerle yeni bir kuyruk olusturulmasi
		enqueue(newCar(numberPlate, brand, type));
	}
	fclose(file);
	return;
}

//kuyruktaki tum elemanlarin listelenmesi
void ListAll() {
	//gecici bir dugum tanimlamasi (baslangic dugumunun etkilenmemesi icin)
	Node *temp = root;
	//son elemana gidene dek bir dongu olusturulmasi
	while (temp != NULL) {
		//o anki dugumdeki data (araba bilgisi) ekrana bastirilmasi
		PrintCar(temp->data);
		printf("\n");
		//sonraki dugume gecme
		temp = temp->next;
	}
}
//not: 249-257 satirlari arasinda yapilan aciklamalar programin diger yerlerinde de ayni mantiktadir

//parametre olarak gelen plaka numarasindaki aracin kuyrukta olma durumunun kontrolu
Node *RecordControl(char numberPlate[]) {
	Node *temp = root;
	while (temp != NULL) {
		//eger arac kuyrukta ise aracin dugum bilgisi geriye dondurulur
		if (strcmp(numberPlate, temp->data->numberPlate) == 0)
			return temp;
		temp = temp->next;
	}
	//eger arac kuyrukta degilse geriye bos donulur
	return NULL;
}

//kuyruga yeni bir eleman ekleme
void AddRecord() {
	char numberPlate[8];
	char brand[20];
	char type[10];

	printf("Number Plate: ");
	scanf("%s", numberPlate);
	//plaka bilgisinin kuyruktan kontrol edilmesi
	if (RecordControl(numberPlate) != NULL) {
		printf("Already exists!\n");
		return;
	}

	//marka bilgisinin okunmasi
	printf("Brand: ");
	scanf("%s", brand);
	//yikama tipinin okunmasi
	printf("Type (%s/%s): ", STRING_NORMAL, STRING_LUX);
	scanf("%s", type);

	//kuyuruga yeni elemanin eklenmesi
	enqueue(newCar(numberPlate, brand, type));
	printf("Record added.\n");
}

//kuyruktaki ilk aracin bilgilerinin yazdirilmasi (root dugumu her zaman ilk aracin bilgisini tutar)
void FirstCar() { PrintCar(root->data); }

//parametre olarak gelen durumun kuyruktaki bekleme suresinin hesaplanmasi
int CalculateWaitTime(Node *node) {
	int result = 0;

	Node *temp = root;
	//parametre olarak gelen dugume kadar ilerleyen dongu
	while (temp != node) {
		//eger o anki node LUX bir araci iceriyorsa 20 (bu deger #define ile sabit tanimlidir)
		if (strcmp(temp->data->type, STRING_LUX) == 0)
			result += TIME_LUX;
		//eger o anki node NORMAL bir araci iceriyorsa 10 (bu deger #define ile sabit tanimlidir)
		else
			result += TIME_NORMAL;
		temp = temp->next;
	}
	//gerekli eklemeler yapilan degisken degerinin geriye dondurulmesi
	return result;
}

//kuyrukta en cok bekleyecek olan yani son aracin bekleme suresinin yazdirilmasi
void LongestWaiting() {
	//last dugumu her zaman kuyruktaki son elemani tutar
	PrintCar(last->data);
	//ilgii fonksiyon yardimi ile bekleme suresinin hesaplanmasi
	printf("Wait Time    : %d\n", CalculateWaitTime(last));
}

//yikama islemi yapilmasi
void NowWashedCar() {
	//kuyruktaki ilk arac yikanir ve kuyruktan cikarilir
	Car *washed = dequeue();
	if (washed != NULL) {
		PrintCar(washed);
		printf("Washed...\n");
		return;
	}
}

//tum kuyrugun kac elemandan olustugu bilgisi geriye donulur
int CalculateQueueSize() {
	//0 dan baslanir
	int rvalue = 0;
	Node *temp = root;
	while (temp != NULL) {
		rvalue++;
		temp = temp->next;
	}
	return rvalue;
}

//parametre olarak gelen sira numarasindaki aracin bilgilerinin geriye dondurulmasi
Car *GetNumberOfCar(int number) {
	//0 dan baslanir
	int counter = 0;
	Node *temp = root;
	while (temp != NULL) {
		//sira numarasi esit ise o anki dugumundeki arac bilgisinin geri dondurulmesi
		if (number == counter)
			return temp->data;
		counter++;
		temp = temp->next;
	}
	return NULL;
}

//sira numarasi girilen aracin bilgilerinin yazdirilmasi
void NumberOfCar() {
	//kuyrugun uzunlugunun hesaplanmasi
	int max = CalculateQueueSize();
	//kuyruk bos ise
	if (max == 0) {
		return;
	}
	//ilgili sira degerinin okunmasi
	printf("Number (0-%d) : ", max - 1);
	int number;
	scanf("%d", &number);

	//belirtilen siradaki aracin bulunmasi ve bir gecici arac yapisina aktarilmasi
	Car *found = GetNumberOfCar(number);
	//egere arac yapisi bos ise yani sira numarasi hatali ise
	if (found == NULL) {
		printf("Not found !\n");
		return;
	}
	//aracin bilgilerinin yazdirilmasi
	PrintCar(found);
}

//kuyrugun toplam bekleme suresinin hesaplanmasi
void TotalWashingTime() {
	//kuyruktaki son elemanin
	printf("Total washing time: %d\n", CalculateWaitTime(last->next));
}

//arac plaka bilgisinden aracin kuyruktaki bekleme suresinin hesaplanmasi
void CalculateWaitingTime() {
	char numberPlate[8];

	printf("Number Plate: ");
	scanf("%s", numberPlate);
	if (RecordControl(numberPlate) == NULL) {
		printf("Not found!\n");
		return;
	}

	int result = 0;

	Node *temp = root;
	//plana degeri esit olana deg kuyrugun gezilmesi
	while (strcmp(temp->data->numberPlate, numberPlate) != 0) {
		//o anki dugumun (yikama) tipi lux ise
		if (strcmp(temp->data->type, STRING_LUX))
			result += TIME_LUX;
		//o anki dugumun (yikama) tipi normal ise
		else
			result += TIME_NORMAL;
		temp = temp->next;
	}

	printf("Waiting time: %d\n", result);
}

//belirtilen yikama tipindeki araclarin yazidirlmasi
void PrintOrder(char type[]) {
	int counter = 0;
	Node *temp = root;
	while (temp != NULL) {
		//arac yikama tipinin kontrolu (ayni ise)
		if (strcmp(temp->data->type, type) == 0) {
			PrintCar(temp->data);
			printf("\n");
			counter++;
		}
		temp = temp->next;
	}
	//toplamda belirtilen tipteki yikamalarin adeti
	printf("Total: %d\n", counter);
}

//normal yikama tipindeki araclarin yazdirilmasi (STRING_NORMAL on islemci komutu olarak tanimlidir orn:"alm")
void NormalWashingOrder() { PrintOrder(STRING_NORMAL); }

//lux yikama tipindeki araclarin yazdirilmasi (STRING_LUX on islemci komutu olarak tanimlidir orn:"luksus")
void LuxWashingOrder() { PrintOrder(STRING_LUX); }

//plaka bilgisinden arac bilgilerinin yazdirilmasi
void ByNumberPate() {
	char numberPlate[8];

	printf("Number Plate: ");
	scanf("%s", numberPlate);
	//ilgili fonksiyondan plaka bilgisine ait aracin alinmasi
	Node *found = RecordControl(numberPlate);
	//kayit bulunamassa
	if (found == NULL) {
		printf("Not found!\n");
		return;
	}
	printf("\n\n");
	//bulanan aracin bilgilerinin yazdirilmasi
	PrintCar(found->data);
}

//kuyruktaki tum araclarin sira ve bekleme suresi bilgileriyle yazdirilmasi
void ListAllWithDetail() {
	int counter = 0;
	Node *temp = root;
	while (temp != NULL) {
		//sira numarasinin yazdirilmasi
		printf("Number       : %d\n", counter);
		//o anki aracin yazdirilmasi
		PrintCar(temp->data);
		//bekleme suresinin yazdirilmasi
		printf("Wait Time    : %d\n\n", CalculateWaitTime(temp));
		counter++;
		temp = temp->next;
	}
}

//plaka bilgisine gore bir aracin yikama turunun degisitirilmei
void ChangeWashType() {
	char numberPlate[8];

	printf("Number Plate: ");
	scanf("%s", numberPlate);
	//aracin kuyrukta bulunmamasi
	if (RecordControl(numberPlate) == NULL) {
		printf("Not found!\n");
		return;
	}

	Node *temp = root;
	//arac bulunana dek kuyrugun gezilmesi ve plaka esit olmayana dek
	while (strcmp(temp->data->numberPlate, numberPlate) != 0)
		temp = temp->next;

	//yikama tipinin okunmasi
	printf("New type (%s/%s): ", STRING_NORMAL, STRING_LUX);
	char type[10];
	scanf("%s", type);
	//yeni yikama tipinin yapiya islenmesi (kopyalama)
	strcpy(temp->data->type, type);

	printf("Changed...\n");
}

//plaka numarasina gore bir dugumun (yikama) kuyruktan silinmesi
void DeleteFromQueue() {
	char numberPlate[8];

	printf("Number Plate: ");
	scanf("%s", numberPlate);
	//plaka bilgisine gore dugumun ilgili fonksiyon ile bulunmasi
	Node *found = RecordControl(numberPlate);
	//yapinin bos olmasi, yani plaka bilgisinde kayit bulunmamasi
	if (found == NULL) {
		printf("Not found!\n");
		return;
	}
	printf("\n");
	//silinecek aracin bilgilerinin yazdirilmasi
	PrintCar(found->data);
	//aracin ilgili fonksiyon yardimiyla (dugum) kuyruktan silinmesi
	delete(found);
	printf("Deleted...\n");
}