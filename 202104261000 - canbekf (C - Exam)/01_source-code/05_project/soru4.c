#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

struct tarih {
  int gun;
  int ay;
  int yil;
};

struct kisiler {
  char adi[30];
  struct tarih dogum;
};

void yas(int gun, int ay, int yil, struct tarih dogum) {
  int month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  if (dogum.gun > gun) {
    gun = gun + month[dogum.ay - 1];
    ay = ay - 1;
  }
  if (dogum.ay > ay) {
    yil = yil - 1;
    ay = ay + 12;
  }
  int sGun = gun - dogum.gun;
  int sAy = ay - dogum.ay;
  int sYil = yil - dogum.yil;

  printf("%d yil %d ay %d gun\n", sYil, sAy, sGun);
}

struct tarih tarihBelirle(struct tarih dogum, char tarih[]) {
  char *token;

  int ay = -1, gun = -1, yil = -1;

  token = strtok(tarih, ".");

  int i;
  for(i=0 ; i<3; i++){
    int sayi = atoi(token);
    if (i==0)
      gun = sayi;
    else if (i == 1)
      ay = sayi;
    else if (i == 2)
      yil = sayi;

    token = strtok(NULL, ".");
  }
 
  dogum.gun = gun;
  dogum.ay = ay;
  dogum.yil = yil;

return dogum;
}

int main() {

  time_t t = time(NULL);
  struct tm tm = *localtime(&t);

  int yil = tm.tm_year + 1900;
  int ay = tm.tm_mon + 1;
  int gun = tm.tm_mday;

  printf("Kac kisinin bilgisini gireceksiniz: ");
  int adet;
  scanf("%d", &adet);

  struct kisiler kisilerListe[adet];

  int i;
  for (i = 0; i < adet; i++) {
    printf("Kisinin ismi: ");
    scanf("%s", kisilerListe[i].adi);
    printf("%s' in dogum tarihi: ", kisilerListe[i].adi);
    char dogum[12];
    scanf("%s", dogum);
    kisilerListe[i].dogum = tarihBelirle(kisilerListe[i].dogum, dogum);

  }

  for (i = 0; i < adet; i++) {
    printf("%s' in yasi : ", kisilerListe[i].adi);
    yas(gun, ay, yil, kisilerListe[i].dogum);
  }
  return 0;
}