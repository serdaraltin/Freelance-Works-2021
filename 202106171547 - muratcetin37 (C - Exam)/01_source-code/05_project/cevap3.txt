#include "stdio.h"

#define BOYUT 5

int EB(int *dizi);
int EK(int *dizi);

int main() {
  int i, sayi;
  int dizi[BOYUT];

  for (i = 0; i < BOYUT; i++) {
    printf("Sayiyi giriniz\n");
    scanf("%d", &sayi);
    dizi[i] = sayi;
  }
  int enBuyuk = EB(dizi);
  int enKucuk = EK(dizi);

  printf("En buyuk sayi: %d\n",enBuyuk);
  printf("En kucuk sayi: %d\n",enKucuk);
}

int EB(int *dizi) {
  int i, enBuyuk;
  enBuyuk = dizi[0];
  for (i = 1; i < BOYUT; i++) {
    if (dizi[i] > enBuyuk)
      enBuyuk = dizi[i];
  }
  return enBuyuk;
}
int EK(int *dizi) {
  int i, enKucuk;
  enKucuk = dizi[0];
  for (i = 1; i < BOYUT; i++) {
    if (dizi[i] < enKucuk)
      enKucuk = dizi[i];
  }
  return enKucuk;
}