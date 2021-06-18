#include <stdio.h>
#include <stdlib.h>

#define FILE_OPERATION "Operations.txt"
#define FILE_SETUP "SetupDuration.txt"
#define FILE_ORDER "Orders.txt"
#define FILE_SCHEDULE "Schedule.txt"

struct operation {
  int islemKodu;
  int miktar;
  struct operation *next;
};
typedef struct operation Operation;

struct setup_duration {
  int islemKodu1;
  int islemKodu2;
  int kurulumSuresi;
  struct setup_duration *next;
};
typedef struct setup_duration SetupDuration;

struct order {
  int siparisKodu;
  int isinUzunlugu;
  int islemKodu;
  int sonTeslimTarihi;
  struct order *next;
};
typedef struct order Order;

struct schedule {
  int zamanlama;
  int islemKodu;
  int siparisKodu;
  int siparisMiktari;
  int kurulumYuku;
  struct schedule *next;
};
typedef struct schedule Schedule;

Operation *operations = NULL;
SetupDuration *setups = NULL;
Order *orders = NULL;
Schedule *schedules = NULL;

void AddOperation(int islemKodu, int miktar) {
  if (operations == NULL) {
    operations = (Operation *)malloc(sizeof(Operation));
    operations->islemKodu = islemKodu;
    operations->miktar = miktar;
    operations->next = NULL;
    return;
  }
  Operation *iter = operations;
  while (iter->next != NULL) {
    iter = iter->next;
  }
  iter->next = (Operation *)malloc(sizeof(Operation));
  iter->next->islemKodu = islemKodu;
  iter->next->miktar = miktar;
  iter->next->next = NULL;
}

void AddOrder(int siparisKodu, int isinUzunlugu, int islemKodu,
              int sonTeslimTarihi) {
  if (orders == NULL) {
    orders = (Order *)malloc(sizeof(Order));
    orders->siparisKodu = siparisKodu;
    orders->isinUzunlugu = isinUzunlugu;
    orders->islemKodu = islemKodu;
    orders->sonTeslimTarihi = sonTeslimTarihi;
    orders->next = NULL;
    return;
  }
  Order *iter = orders;
  while (iter->next != NULL) {
    iter = iter->next;
  }
  iter->next = (Order *)malloc(sizeof(Order));
  iter->next->siparisKodu = siparisKodu;
  iter->next->isinUzunlugu = isinUzunlugu;
  iter->next->islemKodu = islemKodu;
  iter->next->sonTeslimTarihi = sonTeslimTarihi;
  iter->next->next = NULL;
}

void AddSetupDuration(int islemKodu1, int islemKodu2, int kurulumSuresi) {
  if (setups == NULL) {
    setups = (SetupDuration *)malloc(sizeof(SetupDuration));
    setups->islemKodu1 = islemKodu1;
    setups->islemKodu2 = islemKodu2;
    setups->kurulumSuresi = kurulumSuresi;
    setups->next = NULL;
    return;
  }

  SetupDuration *iter = setups;
  while (iter->next != NULL) {
    iter = iter->next;
  }
  iter->next = (SetupDuration *)malloc(sizeof(SetupDuration));
  iter->next->islemKodu1 = islemKodu1;
  iter->next->islemKodu2 = islemKodu2;
  iter->next->kurulumSuresi = kurulumSuresi;
  iter->next->next = NULL;
}

void AddSchedule(int zamanlama, int islemKodu, int siparisKodu,
                 int siparisMiktari, int kurulumYuku) {
  if (schedules == NULL) {
    schedules = (Schedule *)malloc(sizeof(Schedule));
    schedules->zamanlama = zamanlama;
    schedules->islemKodu = islemKodu;
    schedules->siparisKodu = siparisKodu;
    schedules->kurulumYuku = kurulumYuku;
       schedules->siparisMiktari = siparisMiktari;
    schedules->next = NULL;
  }
  Schedule *iter = schedules;
  while (iter->next != NULL)
    iter = iter->next;
  iter->next = (Schedule *)malloc(sizeof(Schedule));
  iter->next->zamanlama = zamanlama;
  iter->next->islemKodu = islemKodu;
  iter->next->siparisKodu = siparisKodu;
  iter->next->kurulumYuku = kurulumYuku;
   iter->next->siparisMiktari = siparisMiktari;
  iter->next->next = NULL;
}

void OkuOperation();
void OkuOrder();
void OkuSetupDuration();
void YazdirOperation(Operation *op);
void ListeleOperation();
void ListeleOrder();
void ListeleSetupDuration();
void YazdirSchedule(Schedule *sch);
void ListeleSchedule();
void HesaplaOrder(Order *ord, int *sure);
void IsleOrder();

int main() {
  OkuOperation();
  OkuSetupDuration();
  OkuOrder();

  ListeleOperation();
  ListeleSetupDuration();
  ListeleOrder();

  IsleOrder();
  ListeleSchedule();
  return 0;
}

int Yuvarla(float sayi) { return (int)(sayi + 0.5f); }

void OkuOperation() {
  FILE *file;
  file = fopen(FILE_OPERATION, "r");
  if (file == NULL) {
    printf("Dosya acilamadi !\n");
    exit(0);
  }
  while (!feof(file)) {
    int islemKodu;
    int miktar;
    fscanf(file, "%d;%d\n", &islemKodu, &miktar);
    AddOperation(islemKodu, miktar);
  }
}

void OkuOrder() {
  FILE *file;
  file = fopen(FILE_ORDER, "r");
  if (file == NULL) {
    printf("Dosya acilamadi !\n");
    exit(0);
  }
  while (!feof(file)) {
    int siparisKodu;
    int isinUzunlugu;
    int islemKodu;
    int sonTeslimTarihi;
    fscanf(file, "%d;%d;%d;%d\n", &siparisKodu, &isinUzunlugu, &islemKodu,
           &sonTeslimTarihi);
    AddOrder(siparisKodu, isinUzunlugu, islemKodu, sonTeslimTarihi);
  }
}

void OkuSetupDuration() {
  FILE *file;
  file = fopen(FILE_SETUP, "r");
  if (file == NULL) {
    printf("Dosya acilamadi !\n");
    exit(0);
  }
  while (!feof(file)) {
    int islemKodu1;
    int islemKodu2;
    int kurulumSuresi;
    fscanf(file, "%d;%d;%d\n", &islemKodu1, &islemKodu2, &kurulumSuresi);
    AddSetupDuration(islemKodu1, islemKodu2, kurulumSuresi);
  }
}

void YazdirOperation(Operation *op) {
  printf("Islem Kodu: %d\tMiktar: %d\n", op->islemKodu, op->miktar);
}

void ListeleOperation() {
  Operation *iter = operations;
  while (iter != NULL) {
    YazdirOperation(iter);
    iter = iter->next;
  }
}

void YazdirOrder(Order *ord) {
  printf(
      "Siparis Kodu: %d\tIsin Uzunlugu: %d\tIslem Kodu: %d\tSon Teslim: %d\n",
      ord->siparisKodu, ord->isinUzunlugu, ord->islemKodu,
      ord->sonTeslimTarihi);
}

void ListeleOrder() {
  Order *iter = orders;
  while (iter != NULL) {
    YazdirOrder(iter);
    iter = iter->next;
  }
}

void YazdirSetupDuration(SetupDuration *set) {
  printf("Islem Kodu 1: %d\tIslem Kodu 2: %d\tKurulum Suresi: %d\t\n",
         set->islemKodu1, set->islemKodu2, set->kurulumSuresi);
}

void ListeleSetupDuration() {
  SetupDuration *iter = setups;
  while (iter != NULL) {
    YazdirSetupDuration(iter);
    iter = iter->next;
  }
}

int GetirMiktar(int islemKodu) {
  Operation *iter = operations;
  while (iter != NULL) {
    if (iter->islemKodu == islemKodu)
      return iter->miktar;
    iter = iter->next;
  }
  return -1;
}

int GetirKurulumSure(int islemKodu1, int islemKodu2) {
  SetupDuration *iter = setups;
  while (iter != NULL) {
    if (iter->islemKodu1 == islemKodu1 && iter->islemKodu2 == islemKodu2)
      return iter->kurulumSuresi;
    iter = iter->next;
  }
  return -1;
}

void HesaplaOrder(Order *ord, int *sure) {
  int miktar = Yuvarla((ord->isinUzunlugu) / GetirMiktar(ord->islemKodu));
  int kurulum;
  if (ord->next == NULL) {
    kurulum = 0;
  } else {
    kurulum = Yuvarla(GetirKurulumSure(ord->islemKodu, ord->next->islemKodu));
  }
  AddSchedule(*sure, ord->islemKodu, ord->siparisKodu, ord->isinUzunlugu,
              kurulum);

  /*printf("%d;%d;%d;%d;%d\n", *sure, ord->islemKodu, ord->siparisKodu,
         ord->isinUzunlugu, kurulum);*/
  (*sure) += kurulum;
}

void IsleOrder() {
  int sure = 0;
  Order *iter = orders;
  while (iter != NULL) {
    HesaplaOrder(iter, &sure);
    iter = iter->next;
    sure++;
  }
}

void YazdirSchedule(Schedule *sch) {
  printf("Zamanlama Zamani: %d\tIslem Kodu: %d\tSiparis Kodu: %d\tSiparis "
         "Miktari: %d\tKurulum Ek Yuku: %d\n",
         sch->zamanlama, sch->islemKodu, sch->siparisKodu, sch->siparisMiktari,
         sch->kurulumYuku);
}

void ListeleSchedule() {
  FILE *file;
  file = fopen(FILE_SCHEDULE, "w");
  if (file == NULL) {
    printf("File connot create\n");
    return;
  }

  Schedule *iter = schedules;
  while (iter != NULL) {
    YazdirSchedule(iter);
    fprintf(file, "%d;%d;%d;%d;%d\n", iter->zamanlama, iter->islemKodu,
            iter->siparisKodu, iter->siparisMiktari, iter->kurulumYuku);
    iter = iter->next;
  }

  fclose(file);
}
