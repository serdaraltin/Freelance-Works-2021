#include <math.h>
#include <stdio.h>
#include <stdlib.h>

void menu();

int asalMi(int sayi) {
  int sinir = sayi / 2, i = 2;
  while (i <= sinir) {
    if (sayi % i == 0)
      return 0;
    i++;
  }
  return 1;
}

void asalKontrol() {
  printf("Bir sayi giriniz : ");
  int sayi;
  scanf("%d", &sayi);
  if (asalMi(sayi)) {
    printf("%d sayisi asaldir.\n", sayi);
  } else {
    printf("%d sayisi asal degildir.\n", sayi);
  }
  return;
}

int ebobHesapla(int sayi1, int sayi2) {

  while (sayi1 != sayi2) {
    if (sayi1 > sayi2)
      sayi1 -= sayi2;
    else
      sayi2 -= sayi1;
  }

  return sayi1;
}

void ebobBulma() {
  printf("1. sayiyi giriniz : ");
  int sayi1, sayi2;
  scanf("%d", &sayi1);
  printf("2. sayiyi giriniz : ");
  scanf("%d", &sayi2);

  int ebob = ebobHesapla(sayi1, sayi2);
  printf("EBOB : %d", ebob);

  return;
}

int ekokHesapla(int sayi1, int sayi2) {
  int s1 = sayi1, s2 = sayi2;
  while (sayi1 != sayi2) {
    if (sayi1 > sayi2)
      sayi1 -= sayi2;
    else
      sayi2 -= sayi1;
  }
  int ekok = (s1 * s2) / sayi1;
  return ekok;
}

void ekokBulma() {
  printf("1. sayiyi giriniz : ");
  int sayi1, sayi2;
  scanf("%d", &sayi1);
  printf("2. sayiyi giriniz : ");
  scanf("%d", &sayi2);

  int ekok = ekokHesapla(sayi1, sayi2);

  printf("EKOK : %d", ekok);

  return;
}

int usHesapla(int sayi, int usAdet) {
  int i = 1, hesapSonuc = 1;

  while (i <= usAdet) {
    hesapSonuc = hesapSonuc * sayi;
    i++;
  }

  return hesapSonuc;
}

void usAlma() {
  printf("Ussu alinacak sayi : ");
  int sayi;
  scanf("%d", &sayi);
  printf("Us degeri : ");
  int us;
  scanf("%d", &us);

  int usSonuc = usHesapla(sayi, us);
  printf("%d ussu %d = %d", sayi, us, usSonuc);
  return;
}

int faktorielHesapla(int sayi) {
  int faktoriel = 1;

  int i;

  for (i = 2; i <= sayi; i++) {
    faktoriel = faktoriel * i;
  }

  return faktoriel;
}

void faktorielBulma() {
  printf("Faktorieli hesaplanacak sayi : ");
  int sayi;
  scanf("%d", &sayi);
  int faktoriel = faktorielHesapla(sayi);
  printf("%d faktoriel = %d", sayi, faktoriel);
}

float karekokHesapla(int sayi, float us) {

  float karekok = pow(sayi, 1 / us);

  return karekok;
}

void karekokBulma() {
  printf("Karakoku bulunacak sayi : ");
  int sayi;
  scanf("%d", &sayi);
  
  printf("Us degeri : ");
  float us;
  scanf("%f",&us);

  float karekok = karekokHesapla(sayi,us);

  printf("%d sayisinin karekoku %.2f dir", sayi, karekok);
}

int main() {
  menu();
  return 0;
}

void menu() {
  printf("\n\n");
  printf("1) Asal Kontrol\n");
  printf("2) EBOB Bulma\n");
  printf("3) EKOK Bulma\n");
  printf("4) Us Alma\n");
  printf("5) Faktoriel Bulma\n");
  printf("6) Karekok Bulma\n");
  printf("0) Cikis\n");
  printf("\nSecim : ");
  int secim;
  scanf("%d", &secim);

  switch (secim) {
  case 0:
    printf("\nProgramdan cikiliyor...\n");
    exit(0);
    break;
  case 1:
    asalKontrol();
    break;

  case 2:
    ebobBulma();
    break;

  case 3:
    ekokBulma();
    break;

  case 4:
    usAlma();
    break;

  case 5:
    faktorielBulma();
    break;

  case 6:
    karekokBulma();
    break;
  default:
    printf("Hatali secim !!!\n");
    break;
  }
  menu();
}
