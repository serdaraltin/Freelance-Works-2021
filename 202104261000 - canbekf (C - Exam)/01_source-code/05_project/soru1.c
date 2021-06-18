#include <stdio.h>
#include <stdlib.h>

#define BOYUT 4

int *solaKaydir(int dizi[], int boyut) {
  int *yeniDizi = (int *)malloc(sizeof(int) * boyut);

  int i;
  for (i = 0; i < boyut + 1; i++) {
    yeniDizi[i] = dizi[i + 1];
  }

  yeniDizi[boyut - 1] = dizi[0];

  return yeniDizi;
}

int main() {
  int i;
  
  int dizi[BOYUT] = {10, 20, 30, 40};

  int *yeniDizi = solaKaydir(dizi, BOYUT);

  printf("Orijinal dizideki ogeler sunlardir: ");
  for (i = 0; i < BOYUT; i++) {
    printf("%d", dizi[i]);
    if(i<BOYUT-1)
      printf(", ");
  }
  printf("\nYeni dizideki ogeler sunlardir: ");
  for (i = 0; i < BOYUT; i++) {
    printf("%d", yeniDizi[i]);
    if(i<BOYUT-1)
      printf(", ");
  }
  printf("\n");

  return 0;
}