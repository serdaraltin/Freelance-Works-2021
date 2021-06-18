#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define BOYUT 100
#define DOSYA_OGRENCI "ogrenci.txt"
#define DOSYA_FIRMA "firma.txt"
#define DOSYA_STAJ "staj.txt"

struct tarih {
  int gun;
  int ay;
  int yil;
};
typedef struct tarih Tarih;

struct ogrenci {
  char no[12];
  char isim[50];
  char soyisim[50];
  char eposta[75];
};
typedef struct ogrenci Ogrenci;

struct firma {
  char vergiNo[20];
  char isim[50];
  char faliyetAlani[100];
  char eposta[75];
};
typedef struct firma Firma;

struct staj {
  char ogrno[12];
  char frmvergiNo[20];
  char baslangicTarih[30];
  char bitisTarih[30];
  int tur;
};
typedef struct staj Staj;

Ogrenci *ogrenciler[BOYUT];
Firma *firmalar[BOYUT];
Staj *stajlar[BOYUT];

int sogrenci = 0, sfirma = 0, sstaj = 0;

void DosyaOkuOgrenci();
void DosyaOkuFirma();
void DosyaOkuStaj();

void DosyaYazOgrenci();
void DosyaYazFirma();
void DosyaYazStaj();

void OgrenciEkle();
void OgrenciDuzenle();
void OgrenciSil();
void OgrenciListele();

void FirmaEkle();
void FirmaDuzenle();
void FirmaSil();
void FirmaListele();

void StajEkle();
void TamamlanmamisStajlar();
void TamamlanmisStajlar();

void Menu();
void OgrenciIslemleri();
void FirmaIslemleri();
void StajIslemleri();

int AralikHesapla(Tarih *baslangic, Tarih *bitis);

int main() {

  DosyaOkuOgrenci();
  DosyaOkuFirma();
  DosyaOkuStaj();

  Menu();
  return 0;
}

void DosyaOkuOgrenci() {
  FILE *dosya;
  dosya = fopen(DOSYA_OGRENCI, "r");
  if (dosya == NULL) {
    return;
  }

  while (!feof(dosya)) {
    ogrenciler[sogrenci] = (Ogrenci *)malloc(sizeof(Ogrenci));
    fscanf(dosya, "%s , %s , %s , %s\n", (*ogrenciler + sogrenci)->no,
           (*ogrenciler + sogrenci)->isim, (*ogrenciler + sogrenci)->soyisim,
           (*ogrenciler + sogrenci)->eposta);
    sogrenci++;
  }
  fclose(dosya);
}
void DosyaOkuFirma() {
  FILE *dosya;
  dosya = fopen(DOSYA_FIRMA, "r");
  if (dosya == NULL) {
    return;
  }
  while (!feof(dosya)) {
    firmalar[sfirma] = (Firma *)malloc(sizeof(Firma));
    fscanf(dosya, "%s , %s , %s , %s\n", (*firmalar + sfirma)->vergiNo,
           (*firmalar + sfirma)->isim, (*firmalar + sfirma)->faliyetAlani,
           (*firmalar + sfirma)->eposta);
    sfirma++;
  }
  fclose(dosya);
}

void DosyaYazOgrenci() {
  FILE *dosya;
  dosya = fopen(DOSYA_OGRENCI, "w");
  int i;
  for (i = 0; i < sogrenci; i++) {
    if (strcmp((*ogrenciler + i)->no, "silindi") == 0)
      continue;
    fprintf(dosya, "%s , %s , %s , %s\n", (*ogrenciler + i)->no,
            (*ogrenciler + i)->isim, (*ogrenciler + i)->soyisim,
            (*ogrenciler + i)->eposta);
  }
  fclose(dosya);
}
void DosyaYazFirma() {
  FILE *dosya;
  dosya = fopen(DOSYA_FIRMA, "w");
  int i;
  for (i = 0; i < sfirma; i++) {
    if (strcmp((*firmalar + i)->vergiNo, "silindi") == 0)
      continue;
    fprintf(dosya, "%s , %s , %s , %s\n", (*firmalar + i)->vergiNo,
            (*firmalar + i)->isim, (*firmalar + i)->faliyetAlani,
            (*firmalar + i)->eposta);
  }
  fclose(dosya);
}

void Menu() {
  printf("1) Ogrenci Islemleri\n");
  printf("2) Firma Islemleri\n");
  printf("3) Staj Islemleri\n");
  printf("0) Programdan cikis\n");
  printf("Secim : ");
  int secim;
  scanf("%d", &secim);
  printf("\n");

  switch (secim) {
  case 0:
    printf("Programdan cikiliyor...\n");
    exit(0);
    break;
  case 1:
    OgrenciIslemleri();
    break;
  case 2:
    FirmaIslemleri();
    break;
  case 3:
    StajIslemleri();
    break;
  default:
    printf("Hatali secim !\n");
    break;
  }
  printf("\n");
  Menu();
}

void OgrenciIslemleri() {
  printf("1) Ogrenci Ekle\n");
  printf("2) Ogrenci Duzenle\n");
  printf("3) Ogrenci Sil\n");
  printf("4) Ogrenci Listele\n");
  printf("0) Ust menu\n");
  printf("Secim : ");
  int secim;
  scanf("%d", &secim);
  printf("\n");

  switch (secim) {
  case 0:
    return;
  case 1:
    OgrenciEkle();
    break;
  case 2:
    OgrenciDuzenle();
    break;
  case 3:
    OgrenciSil();
    break;
  case 4:
    OgrenciListele();
    break;
  default:
    printf("Hatali secim !\n");
    break;
  }
  printf("\n");
  OgrenciIslemleri();
}

void FirmaIslemleri() {
  printf("1) Firma Ekle\n");
  printf("2) Firma Duzenle\n");
  printf("3) Firma Sil\n");
  printf("4) Firma Listele\n");
  printf("0) Ust menu\n");
  printf("Secim : ");
  int secim;
  scanf("%d", &secim);
  printf("\n");

  switch (secim) {
  case 0:
    return;
  case 1:
    FirmaEkle();
    break;
  case 2:
    FirmaDuzenle();
    break;
  case 3:
    FirmaSil();
    break;
  case 4:
    FirmaListele();
    break;
  default:
    printf("Hatali secim !\n");
    break;
  }
  printf("\n");
  FirmaIslemleri();
}

void StajIslemleri() {
  printf("1) Staj Ekle\n");
  printf("2) Tamamlanmamis Stajlar\n");
  printf("3) Tamamlanmis Stajlar\n");
  printf("0) Ust menu\n");
  printf("Secim : ");
  int secim;
  scanf("%d", &secim);
  printf("\n");

  switch (secim) {
  case 0:
    return;
  case 1:
    StajEkle();
    break;
  case 2:
    TamamlanmamisStajlar();
    break;
  case 3:
    TamamlanmisStajlar();
    break;
  default:
    printf("Hatali secim !\n");
    break;
  }
  printf("\n");
  StajIslemleri();
}

int OgrenciKontrol(char no[]) {
  int i;
  for (i = 0; i < sogrenci; i++) {
    if (strcmp(no, (*ogrenciler + i)->no) == 0)
      return i;
  }
  return -1;
}

void YazdirOgrenci(Ogrenci *ogrenci) {
  printf("\nNo      : %s\n", ogrenci->no);
  printf("Isim    : %s\n", ogrenci->isim);
  printf("Soyisim : %s\n", ogrenci->soyisim);
  printf("Eposta  : %s\n\n", ogrenci->eposta);
}

void OgrenciEkle() {
  char no[12];

  printf("Ogrenci Ekle >>\n\n");
  printf("No : ");
  scanf("%s", no);
  if (OgrenciKontrol(no) != -1) {
    printf("Ayni no'ya sahip ogrenci var !\n");
    return;
  }
  ogrenciler[sogrenci] = (Ogrenci *)malloc(sizeof(Ogrenci));
  strcpy((*ogrenciler + sogrenci)->no, no);

  printf("Isim : ");
  scanf("%s", (*ogrenciler + sogrenci)->isim);
  printf("Soyisim : ");
  scanf("%s", (*ogrenciler + sogrenci)->soyisim);
  printf("Eposta : ");
  scanf("%s", (*ogrenciler + sogrenci)->eposta);

  // YazdirOgrenci((*ogrenciler+sogrenci));
  sogrenci++;
  DosyaYazOgrenci();
  printf("Ogrenci eklendi.\n");
}

void OgrenciDuzenle() {
  char no[12];

  printf("Ogrenci Duzenle >>\n\n");
  printf("No : ");
  scanf("%s", no);
  int index = OgrenciKontrol(no);
  if (index == -1) {
    printf("No'ya sahip ogrenci bulunamadi !\n");
    return;
  }

  printf("Isim : ");
  scanf("%s", (*ogrenciler + index)->isim);
  printf("Soyisim : ");
  scanf("%s", (*ogrenciler + index)->soyisim);
  printf("Eposta : ");
  scanf("%s", (*ogrenciler + index)->eposta);

  printf("\nYeni bilgiler >>");
  YazdirOgrenci((*ogrenciler + index));
  DosyaYazOgrenci();
  printf("Ogrenci duzenlendi.\n");
}

int OgrenciSilKontrol(char no[]) {
  int i;
  for (i = 0; i < sstaj; i++) {
    if (strcmp((*stajlar + sstaj)->ogrno, no) == 0)
      return i;
  }
  return -1;
}

void OgrenciSil() {
  char no[12];

  printf("Ogrenci Duzenle >>\n\n");
  printf("No : ");
  scanf("%s", no);
  int index = OgrenciKontrol(no);
  if (index == -1) {
    printf("No'ya sahip ogrenci bulunamadi !\n");
    return;
  }
  if (OgrenciSilKontrol(no) != -1) {
    printf("Ogrenci staj kayitlarinda bulundugu icin silinemez !\n");
    return;
  }
  printf("\nOgrenci bilgileri >>");
  YazdirOgrenci((*ogrenciler + index));
  strcpy((*ogrenciler + index)->no, "silindi");
  DosyaYazOgrenci();
  printf("Ogrenci silindi.\n");
}

void OgrenciListele() {
  printf("Ogrenci Listele >>\n");
  int i;
  for (i = 0; i < sogrenci; i++) {
    if (strcmp((*ogrenciler + i)->no, "silindi") == 0)
      continue;
    YazdirOgrenci((*ogrenciler + i));
  }
}

int FirmaKontrol(char vergiNo[]) {
  int i;
  for (i = 0; i < sfirma; i++) {
    if (strcmp(vergiNo, (*firmalar + i)->vergiNo) == 0)
      return i;
  }
  return -1;
}

void YazdirFirma(Firma *firma) {
  printf("\nVergi No      : %s\n", firma->vergiNo);
  printf("Isim          : %s\n", firma->isim);
  printf("Faliyet Alani : %s\n", firma->faliyetAlani);
  printf("Eposta        : %s\n\n", firma->eposta);
}

void FirmaEkle() {
  char vergiNo[20];
  printf("Firma Ekle >>\n\n");
  printf("Vergi No : ");
  scanf("%s", vergiNo);
  if (FirmaKontrol(vergiNo) != -1) {
    printf("Ayni vergi no'ya sahip firma var !\n");
    return;
  }
  firmalar[sfirma] = (Firma *)malloc(sizeof(Firma));
  strcpy((*firmalar + sfirma)->vergiNo, vergiNo);

  printf("Isim : ");
  scanf("%s", (*firmalar + sfirma)->isim);
  printf("Faliyet Alani : ");
  scanf("%s", (*firmalar + sfirma)->faliyetAlani);
  printf("Eposta : ");
  scanf("%s", (*firmalar + sfirma)->eposta);

  // YazdirFirma((*firmalar+sfirma));
  sfirma++;
  DosyaYazFirma();
  printf("Firma eklendi.\n");
}

void FirmaDuzenle() {
  char vergiNo[20];
  printf("Firma Duzenle >>\n\n");
  printf("Vergi No : ");
  scanf("%s", vergiNo);
  int index = FirmaKontrol(vergiNo);
  if (index == -1) {
    printf("Vergi No'ya sahip kayit bulunamadi !\n");
    return;
  }
  printf("Isim : ");
  scanf("%s", (*firmalar + sfirma)->isim);
  printf("Faliyet Alani : ");
  scanf("%s", (*firmalar + sfirma)->faliyetAlani);
  printf("Eposta : ");
  scanf("%s", (*firmalar + sfirma)->eposta);

  printf("\nYeni bilgiler >>\n");
  YazdirFirma((*firmalar + sfirma));
  sfirma++;
  DosyaYazFirma();
  printf("Firma duzenlendi.\n");
}

int FirmaSilKontrol(char vergiNo[]) {
  int i;
  for (i = 0; i < sstaj; i++) {
    if (strcmp((*stajlar + sstaj)->frmvergiNo, vergiNo) == 0)
      return i;
  }
  return -1;
}

void FirmaSil() {
  char vergiNo[20];
  printf("Firma Duzenle >>\n\n");
  printf("Vergi No : ");
  scanf("%s", vergiNo);
  int index = FirmaKontrol(vergiNo);
  if (index == -1) {
    printf("Vergi No'ya sahip kayit bulunamadi !\n");
    return;
  }
  if (FirmaSilKontrol(vergiNo) != -1) {
    printf("Firma staj kayitlarinda bulundugu icin silinemez !\n");
    return;
  }
  printf("\nFirma bilgileri >>\n");
  YazdirFirma((*firmalar + index));
  strcpy((*firmalar + index)->vergiNo, "silindi");
  DosyaYazFirma();
  printf("Firma silindi.\n");
}

void FirmaListele() {
  printf("Firma Listele >>\n");
  int i;
  for (i = 0; i < sfirma; i++) {
    if (strcmp((*firmalar + i)->vergiNo, "silindi") == 0)
      continue;
    YazdirFirma((*firmalar + i));
  }
}

int AraYil(Tarih *tarih) {
  int yillar = tarih->yil;

  if (tarih->ay <= 2)
    yillar--;

  return yillar / 4 - yillar / 100 + yillar / 400;
}

int AralikHesapla(Tarih *baslangic, Tarih *bitis) {
  int month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  int n1 = baslangic->yil * 365 + baslangic->gun;

  int i;
  for (i = 0; i < baslangic->ay - 1; i++) {
    n1 += month[i];
  }

  n1 += AraYil(baslangic);

  int n2 = bitis->yil * 365 + bitis->gun;

  for (i = 0; i < bitis->ay - 1; i++) {
    n2 += month[i];
  }
  n2 += AraYil(bitis);

  return (n2 - n1);
}

Tarih *TarihBelirle(Tarih *tarih, char ctarih[]) {
  char starih[30];
  strcpy(starih, ctarih);
  char *token;

  int ay = -1, gun = -1, yil = -1;

  token = strtok(starih, ".");

  int i;
  for (i = 0; i < 3; i++) {
    int sayi = atoi(token);
    if (i == 0)
      gun = sayi;
    else if (i == 1)
      ay = sayi;
    else if (i == 2)
      yil = sayi;

    token = strtok(NULL, ".");
  }

  tarih->gun = gun;

  tarih->ay = ay;
  tarih->yil = yil;

  return tarih;
}

int StajMiktar(char no[], int tur) {
  int adet = 0, i;

  for (i = 0; (*stajlar + i) != NULL && i < sstaj; i++) {
    if (strcmp((*stajlar + i)->ogrno, no) == 0) {
      if ((*stajlar + i)->tur == tur) {
        Tarih *baslangic = (Tarih *)malloc(sizeof(Tarih));
        Tarih *bitis = (Tarih *)malloc(sizeof(Tarih));

        TarihBelirle(baslangic, (*stajlar + i)->baslangicTarih);
        TarihBelirle(bitis, (*stajlar + i)->bitisTarih);

        int aralik = AralikHesapla(baslangic, bitis);
        int hafta = aralik / 7;

        adet += hafta;
      }
    }
  }
  return adet;
}

void DosyaYazStaj() {
  FILE *dosya;
  dosya = fopen(DOSYA_STAJ, "w");
  int i;
  for (i = 0; i < sstaj; i++) {
    fprintf(dosya, "%s , %s , %s , %s , %d\n", (*stajlar + i)->ogrno,
            (*stajlar + i)->frmvergiNo, (*stajlar + i)->baslangicTarih,
            (*stajlar + i)->bitisTarih, (*stajlar + i)->tur);
  }
  fclose(dosya);
}

void DosyaOkuStaj() {
  FILE *dosya;
  dosya = fopen(DOSYA_STAJ, "r");
  if (dosya == NULL) {
    return;
  }
  while (!feof(dosya)) {
    char ogrno[12];
    char frmvergiNo[20];
    char baslangicTarih[30];
    char bitisTarih[30];
    int tur;

    fscanf(dosya, "%s , %s , %s , %s , %d\n", ogrno, frmvergiNo, baslangicTarih,
           bitisTarih, &tur);

    stajlar[sstaj] = (Staj *)malloc(sizeof(Staj));
    strcpy((*stajlar + sstaj)->ogrno, ogrno);
    strcpy((*stajlar + sstaj)->frmvergiNo, frmvergiNo);
    strcpy((*stajlar + sstaj)->baslangicTarih, baslangicTarih);
    strcpy((*stajlar + sstaj)->bitisTarih, bitisTarih);
    (*stajlar + sstaj)->tur = tur;

    sstaj++;
  }
  fclose(dosya);
}

void StajEkle() {
  char no[12];

  printf("Staj Ekle >>\n\n");
  printf("Ogrenci No : ");
  scanf("%s", no);
  int ogrIndex = OgrenciKontrol(no);
  if (ogrIndex == -1) {
    printf("No'ya sahip ogrenci bulunamadi !\n");
    return;
  }
  printf("\nOgrenci Bilgileri>>");
  YazdirOgrenci((*ogrenciler + ogrIndex));

  int donanimStajAdet = StajMiktar(no, 0);
  int yazilimStajAdet = StajMiktar(no, 1);

  printf("Donanim Staj Hatfa : %d\n", donanimStajAdet);
  printf("Yazilim Staj Hafta : %d\n", yazilimStajAdet);

  if (donanimStajAdet + yazilimStajAdet >= 12) {
    printf("Ogrenci staji tamamlanmistir !\n");
    return;
  }

  char vergiNo[20];
  printf("Firma Vergi No : ");
  scanf("%s", vergiNo);
  int frmIndex = FirmaKontrol(vergiNo);
  if (frmIndex == -1) {
    printf("Vergi No'ya sahip firma bulunamadi !\n");
    return;
  }
  printf("\nFirma Bilgileri>>");
  YazdirFirma((*firmalar + frmIndex));

  printf("Tur [Donanim(0)/Yazilim(1) : ");
  int tur;
  scanf("%d", &tur);

  if (!(tur == 0 || tur == 1)) {
    printf("Hatali secim !\n");
    return;
  }
  if (tur == 0) {
    if (donanimStajAdet >= 4 && yazilimStajAdet < 2) {
      printf("Uygun tur secilmedi !\n");
      return;
    }
  }
  if (tur == 1) {
    if (donanimStajAdet < 4 && yazilimStajAdet >= 2) {
      printf("Uygun tur secilmedi !\n");
      return;
    }
  }

  printf("Baslangic Tarihi (gg.aa.yyyy) : ");
  char baslangic[30];
  scanf("%s", baslangic);
  Tarih *baslangicTarih = (Tarih *)malloc(sizeof(Tarih));
  TarihBelirle(baslangicTarih, baslangic);

  printf("Bitis Tarihi (gg.aa.yyyy) : ");
  char bitis[30];
  scanf("%s", bitis);
  Tarih *bitisTarih = (Tarih *)malloc(sizeof(Tarih));
  TarihBelirle(bitisTarih, bitis);

  int haftaAdet = AralikHesapla(baslangicTarih, bitisTarih) / 7;
  if (haftaAdet < 1) {
    printf("Staj 1 haftadan kisa oldugu icin gecersizdir.\n");
    return;
  }

  printf("Hafta Sayisi : %d\n", haftaAdet);

  stajlar[sstaj] = (Staj *)malloc(sizeof(Staj));
  strcpy((*stajlar + sstaj)->ogrno, no);
  strcpy((*stajlar + sstaj)->frmvergiNo, vergiNo);
  strcpy((*stajlar + sstaj)->baslangicTarih, baslangic);
  strcpy((*stajlar + sstaj)->bitisTarih, bitis);
  (*stajlar + sstaj)->tur = tur;

  sstaj++;
  DosyaYazStaj();
  printf("Staj eklendi.\n");
}

void TamamlanmamisStajlar() {
  printf("Stajini Tamamlamamis Ogrenciler >>\n");
  int i;
  for (i = 0; i < sogrenci; i++) {
    int donanimStaj = StajMiktar((*ogrenciler + i)->no, 0);
    int yazilimStaj = StajMiktar((*ogrenciler + i)->no, 1);

    
    if (donanimStaj <= 4 || yazilimStaj <= 2 ||
        donanimStaj + yazilimStaj < 12) {
      YazdirOgrenci((*ogrenciler + i));
      printf("Donanim staj : %d hafta\n", donanimStaj);
      printf("Yazilim staj : %d hafta\n", yazilimStaj);
    }
  }
}
void TamamlanmisStajlar() {
  printf("Stajini Tamamlamis Ogrenciler >>\n");
  int i;
  for (i = 0; i < sogrenci; i++) {
    int donanimStaj = StajMiktar((*ogrenciler + i)->no, 0);
    int yazilimStaj = StajMiktar((*ogrenciler + i)->no, 1);

    if (donanimStaj >= 4 && yazilimStaj >= 2 &&
        donanimStaj + yazilimStaj == 12) {
      YazdirOgrenci((*ogrenciler + i));
    }
  }
}