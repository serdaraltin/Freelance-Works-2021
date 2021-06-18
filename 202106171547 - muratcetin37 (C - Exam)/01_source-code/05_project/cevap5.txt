#include "string.h"
#include <stdio.h>
#include <stdlib.h>

struct ogr {
  char adi[50];
  float odev1 = 0.05, odev2 = 0.05;
  float quiz1 = 0.08, quiz2 = 0.08, quiz3 = 0.08;
  float vize1 = 0.13, vize2 = 0.13;
  float final = 0.40;
  float gecme_notu;
};

void yaz(struct ogr *dizi, int boyut) {
  FILE *dosya;
  dosya = fopen("notlar.txt", "w");

  int i;
  for (i = 0; i < boyut; i++) {
    fprintf(dosya, "%s,%f\n", dizi[i].adi, dizi[i].gecme_notu);
  }
  fclose(dosya);
}

int main() {
  int boyut;

  printf("Dizi boyutunu giriniz: ");
  scanf("%d", &boyut);

  struct ogr *dizi = (struct ogr *)malloc(sizeof(struct ogr)*boyut);

  char adi[50];
  float odev1 = 0.05, odev2 = 0.05;
  float quiz1 = 0.08, quiz2 = 0.08, quiz3 = 0.08;
  float vize1 = 0.13, vize2 = 0.13;
  float finaln = 0.40;

  int i;
  for (i = 0; i < boyut; i++) {
    printf("%d. ogrenci bilgilerini giriniz\n", i + 1);
    printf("adi : ");
    scanf("%s", dizi[i].adi);

    printf("odev1 : ");
    scanf("%f", &dizi[i].odev1);
    dizi[i].odev1 *= odev1;

    printf("odev2 : ");
    scanf("%f", &dizi[i].odev2);
    dizi[i].odev2 *= odev1;

    printf("quiz1 : ");
    scanf("%f", &dizi[i].quiz1);
    dizi[i].quiz1 *= quiz1;

    printf("quiz2 : ");
    scanf("%f", &dizi[i].quiz2);
    dizi[i].quiz2 *= quiz2;

    printf("quiz3 : ");
    scanf("%f", &dizi[i].quiz3);
    dizi[i].quiz3 *= quiz3;

    printf("vize1 : ");
    scanf("%f", &dizi[i].vize1);
    dizi[i].vize1 *= vize1;

    printf("vize2 : ");
    scanf("%f", &dizi[i].vize2);
    dizi[i].vize2 *= vize2;

    printf("final : ");
    scanf("%f", &dizi[i].final);
    dizi[i].final *= finaln;

    dizi[i].gecme_notu = dizi[i].odev1 + dizi[i].odev2 + dizi[i].quiz1 +
                         dizi[i].quiz2 + dizi[i].quiz3 + dizi[i].vize1 +
                         dizi[i].vize2;

    printf("gecme notu : %.2f\n\n", dizi[i].gecme_notu);
  }
  yaz(dizi, boyut);
  printf("Dosyaya yazildi.\n");
}