#include <stdio.h>
#include <stdlib.h>

#define BOYUT 256

int main() {

  int dizi[BOYUT];
  char ch;
  int i = 0;
  int input[100000];

  while (scanf("%c", &ch) && (ch != '\n')) {
    if (ch == ' ')
      continue;
    input[i] = ch - '0';

    dizi[i] = input[i];

    if (i == BOYUT) {
      printf("\n Cok fazla sayi girdiniz !!!");
      break;
    }
    i++;
  }

  int j, k, adet = 1, makTekrar = 0, tekrar = 0, maxSayi = 0;

  int tekrarListesi[BOYUT];

  for (j = 0; j < i; j++) {

    int kontrol = 1;
    for (k = 0; k < tekrar; k++) {
      if (dizi[j] == tekrarListesi[k]) {
        kontrol = 0;
        break;
      }
    }
    if (kontrol == 0)
      continue;

    for (k = j + 1; k < i; k++) {
      if (dizi[j] == dizi[k]) {
        adet++;
        tekrarListesi[tekrar++] = dizi[k];
      }
    }

    if (adet > 1) {
      if (adet > makTekrar){
          makTekrar = adet;
          maxSayi = dizi[j];
      }
        

      printf("%d sayisi %d kez\n", dizi[j], adet);

      adet = 1;
    }
  }

  if (makTekrar > 0) {
    printf("tekrarlanmistir. Maksimum tekrar sayisi: %d\n", maxSayi);
  } else {
    printf("Dizide tekrarlama olmamistir.\n");
  }
}