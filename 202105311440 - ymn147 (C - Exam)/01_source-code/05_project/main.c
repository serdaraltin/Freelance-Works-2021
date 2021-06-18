#include <stdio.h>
#include <stdlib.h>

#define PI 3.14

float hesapla(float r, int adet) {
  adet--;
  if (adet == -1)
    return 0;

  float alan = PI * (r * r);
  return alan + hesapla(r / 2, adet);
}

int main() {
  printf("---Hosgeldiniz---\n\n");
  while (1) {
    printf("Adet (N) giriniz: ");
    int adet;
    scanf("%d", &adet);

    printf("Yaricap (r) giriniz: ");
    float r;
    scanf("%f", &r);

    float sonuc = hesapla(r, adet);

    printf("Sonuc : %.2f\n", sonuc);

    printf("Devam etmek istiyor musunuz? (E/H) : ");
    char cevap[2];
    scanf("%s",cevap);

    if(!(cevap[0] == 'E' || cevap[0] == 'e')){
        printf("Programdan cikiliyor...\n");
        exit(0);
    }
  }

  return 0;
}
