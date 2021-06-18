#include <stdio.h>
#include <stdlib.h>

void menu();

int kaynamaKontrol(int sicaklik, int madde) {
  int yuzdeBes = (madde / 100) * 5;

  if (sicaklik >= madde - yuzdeBes && sicaklik <= madde + yuzdeBes) {
    return 1;
  }
 return 0;
}

void kaynamaHesaplama() {
  int su = 100, civa = 357, bakir = 1187, gumus = 2193, altin = 2660;

  printf("Celcius degerini giriniz : ");
 
  int sicaklik;
  scanf("%d", &sicaklik);

  if (kaynamaKontrol(sicaklik, su)) {
    printf("Kaynama Noktasi : Su");
  }

  else if (kaynamaKontrol(sicaklik, civa)) {
    printf("Kaynama Noktasi : Civa");
  }
  else if (kaynamaKontrol(sicaklik, bakir)) {
    printf("Kaynama Noktasi : Bakir");
  }
  else if (kaynamaKontrol(sicaklik, gumus)) {
    printf("Kaynama Noktasi : Gumus");
  }
  else if (kaynamaKontrol(sicaklik, altin)) {
    printf("Kaynama Noktasi : Altin");
  }
  else {
    printf("5 maddeden biri degildir. (su,civa,bakir,gumus,altin)");
  }
}

int usAl(int sayi, int us) {
  int i, sonuc = 1;
  for (i = 1; i <= us; i++) {
    sonuc *= sayi;
  }
  return sonuc;
}

int armstrongKontrol(int sayi) {
  
  int number = sayi, originalNumber, remainder, result = 0, n = 0;
  originalNumber = number;

  for (; originalNumber != 0; originalNumber /= 10, ++n)
    ;

  originalNumber = number;

  for (; originalNumber != 0; originalNumber /= 10) {

    remainder = originalNumber % 10;
    result += usAl(remainder, n);
  }
  if (result == number) {
    return 1;
  }
  return 0;
}

void armstrongBulma() {
  int baslangic, bitis;
  printf("Baslangic degerini giriniz : ");
  scanf("%d", &baslangic);

  printf("Bitis degerini giriniz : ");
  scanf("%d", &bitis);

  int i, adet = 0;

  for (i = baslangic; i <= bitis; i++) {
    if (armstrongKontrol(i)) {
      adet++;
      printf("%d > %d\n", adet, i);
    }
  }
  if (adet > 0) {
    printf("Belirlenen aralikta %d adet armstrong sayisi vardir.\n", adet);
  } else {
    printf("Belirlenen aralikta hic armstrong sayisi bulunamadi.\n");
  }
  return;
}

int ikiTerimliKatsayi(int n, int k) {
  int res = 1;

  if (k > n - k) {
    k = n - k;
  }
  int i;
  for (i = 0; i < k; ++i) {
    res *= (n - i);
    res /= (i + 1);
  }
  return res;
}

void yazdirPaskal(int n) {

  int line;
  for (line = 0; line < n; line++) {
    int i;
    for (i = 0; i <= line; i++) {

      printf("%d ", ikiTerimliKatsayi(line, i));
    }

    printf("\n");
  }
}

void paskalUcgeni() {

  printf("Satir No : ");
  int satir;
  scanf("%d", &satir);
  yazdirPaskal(satir);
}

float fahrenheitHesapla(float celcius) { 
    return ((celcius * 9) / 5) + 32;
}

float kelvinHesapla(float celcius) {
  float fahrenheit = fahrenheitHesapla(celcius);
  return ((fahrenheit + 459.67) / 1.8);
}

float reaumurHesapla(float celcius) {
  float fahrenheit = fahrenheitHesapla(celcius);
  return ((fahrenheit - 32) / 2.25);
}

void sicaklikDonusum() {
  printf("Celsius(Santigrat) degerini giriniz : ");
  float celcisus;
  scanf("%f", &celcisus);

  printf("Fahrenheit degeri : %.2f\n", fahrenheitHesapla(celcisus));
  printf("Kelvin degeri : %.2f\n", kelvinHesapla(celcisus));
  printf("Reaumur degeri : %.2f\n", reaumurHesapla(celcisus));
}

int main() {

  menu();

  return 0;
}

void menu() {
  printf("\n\n");
  printf("1) Kaynama Noktasi Bulma\n");
  printf("2) Armstrong Sayilarini Bulma\n");
  printf("3) Paskal Ucgeni Yazdirma\n");
  printf("4) Sicaklik Donusumleri\n");
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
    kaynamaHesaplama();
    break;

  case 2:
    armstrongBulma();
    break;

  case 3:
    paskalUcgeni();
    break;

  case 4:
    sicaklikDonusum();
    break;

  default:
    printf("Hatali secim !!!\n");
    break;
  }
  menu();
}
