#include "stdio.h"

int main() {
  printf("Toplam sayi adedi giriniz\n");
  int adet;
  scanf("%d", &adet);

  int i, sayi, tekAdet = 0, ciftAdet = 0;
  for (i = 0; i < adet; i++) {
    printf("Sayi giriniz\n");
    scanf("%d", &sayi);
    if ((sayi % 2) == 0)
      ciftAdet++;
    else
      tekAdet++;
  }
  printf("Cif sayi adedi: %d\n",ciftAdet);
  printf("Tek sayi adedi: %d\n",tekAdet);
}