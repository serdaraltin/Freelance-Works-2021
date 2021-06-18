#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define DOSYA_ARAC "arac.csv"
#define DOSYA_MUSTERI "musteri.csv"
#define DOSYA_KIRALAMA "kiralama.csv"

typedef struct arac
{
    int no;
    char marka[20], model[20];
    int yil;
    float fiyat;
    int hava_yastigi, isitmali_koltuk;
} Arac;

typedef struct musteri
{
    int no;
    char ad[20], soyad[20];
    int dogum;
    char adres[150];
    char ehliyet[10];
} Musteri;

typedef struct kiralama
{
    int no;
    int aracNo, musteriNo;
    char tarih[30];
    int gun;
    float tutar;

} Kiralama;

Arac araclar[100];
Musteri musteriler[100];
Kiralama kiralamalar[100];

int aSayi = 0, mSayi = 0, kSayi = 0;

void AnaMenu();
void DosyaOku();

void AracMenu();
void AracKaydet();
void AracListele();
void AracSil();
void DosyaOkuArac();
void DosyaYazArac();
void YazdirArac(Arac arac);
int EkleArac(Arac *arac);
int SilArac(int no);
void ListeleArac();
int GetirArac(int no);

void MusteriMenu();
void YeniMusteriOlustur();
void MusteriListele();
void DosyaOkuMusteri();
void DosyaYazMusteri();
void YazdirMusteri(Musteri musteri);
int EkleMusteri(Musteri *musteri);
void ListeleMusteri();
int GetirMusteri(int no);

void ArabaMenu();
void KiralananAraclar();
void MevcutAraclarinListesi();
void AracKirala();
void DosyaOkuKiralama();
void DosyaYazKiralama();
void YazdirKiralama(Kiralama kiralama);
int EkleKiralama(Kiralama *kiralama);
void ListeleKiralama();
int KiralanmamisArac(int aracNo);

int main()
{
    DosyaOku();
    printf("-------------------------------\n");
    printf("|     ...HOS GELDINIZ...      |\n");
    printf("-------Arac Yonetimi v1.0------\n\n");
    AnaMenu();
}

void AnaMenu()
{
	printf("----------ANA MENU-------------\n");
    printf("1) Arac yonetimi\n");
    printf("2) Musteri yonetimi\n");
    printf("3) Araba yonetimi\n");
    printf("0) Cikis\n");
    printf("-------------------------------\n");
    printf("\nSecim : ");
    int secim;
    scanf("%d", &secim);

    switch (secim)
    {
    case 0:
        printf("Cikiliyor...\n");
        exit(0);
        break;
    case 1:
        AracMenu();
        break;
    case 2:
        MusteriMenu();
        break;
    case 3:
        ArabaMenu();
        break;
    default:
        printf("\nHatali secim !\n");
        break;
    }
    
    AnaMenu();
}

void DosyaOku()
{
    DosyaOkuArac();
    DosyaOkuMusteri();
    DosyaOkuKiralama();
}
void AracMenu()
{
	printf("----------ARAC MENU------------\n");
    printf("1) Arac kaydedin\n");
    printf("2) Arac listesini listeleyin\n");
    printf("3) Arac silin\n");
    printf("0) Ust menu\n");
    printf("-------------------------------\n");
    printf("\nSecim : ");
    int secim;
    scanf("%d", &secim);

    switch (secim)
    {
    case 0:
        return;
        break;
    case 1:
        AracKaydet();
        break;
    case 2:
        AracListele();
        break;
    case 3:
        AracSil();
        break;
    default:
        printf("\nHatali secim !\n");
        break;
    }
    printf("\n");
    AracMenu();
}
void AracKaydet()
{
    printf("\n--- ARAC KAYDET\n");
    Arac *arac = (Arac *)malloc(sizeof(Arac));
    printf("\nNo    : ");
    scanf("%d", &arac->no);
    printf("Marka : ");
    scanf("%s", arac->marka);
    printf("Model : ");
    scanf("%s", arac->model);
    printf("Yil   : ");
    scanf("%d", &arac->yil);
    printf("Fiyat : ");
    scanf("%f", &arac->fiyat);
    printf("Hava Yastigi (1=var,0=yok)    : ");
    scanf("%d", &arac->hava_yastigi);
    printf("Isitmali Koltuk (1=var,0=yok) : ");
    scanf("%d", &arac->isitmali_koltuk);
    if (EkleArac(arac))
    {
        printf("\nArac eklendi.\n");
        DosyaYazArac();
        return;
    }
    printf("\nArac eklenemedi.\n");
}
void AracListele()
{
    printf("\n--- ARAC LISTELE\n");
    ListeleArac();
}
void AracSil()
{
    printf("\n--- ARAC SIL\n\n");
    printf("Arac No : ");
    int no;
    scanf("%d", &no);
    if (SilArac(no))
    {
        printf("\nArac silindi.\n");
        return;
    }
    printf("\nBoyle bir arac yok.\n");
}

void MusteriMenu()
{
	printf("-------MUSTERI MENU------------\n");
    printf("1) Yeni bir musteri olusturun\n");
    printf("2) Musterileri listeleyin\n");
    printf("0) Ust menu\n");
    printf("-------------------------------\n");
    printf("\nSecim : ");
    int secim;
    scanf("%d", &secim);

    switch (secim)
    {
    case 0:
        return;
        break;
    case 1:
        YeniMusteriOlustur();
        break;
    case 2:
        MusteriListele();
        break;
    default:
        printf("\nHatali secim !\n");
        break;
    }
    printf("\n");
    MusteriMenu();
}
void YeniMusteriOlustur()
{
    printf("\n--- YENI MUSTERI OLUSTUR\n");
    Musteri *musteri = (Musteri *)malloc(sizeof(Musteri));
    printf("\nNo      : ");
    scanf("%d", &musteri->no);
    printf("Ad      : ");
    scanf("%s", musteri->ad);
    printf("Soyad   : ");
    scanf("%s", musteri->soyad);
    printf("Dogum   : ");
    scanf("%d", &musteri->dogum);
    printf("Adres   : ");
    scanf("%s", musteri->adres);
    printf("Ehliyet : ");
    scanf("%s", musteri->ehliyet);
    if (EkleMusteri(musteri))
    {
        printf("\nYeni musteri olusturuldu.\n");
        DosyaYazMusteri();
        return;
    }
    printf("\nMusteri olusturulamadi.\n");
}
void MusteriListele()
{
    printf("\n--- MUSTERI LISTELE\n");
    ListeleMusteri();
}

void ArabaMenu()
{
	printf("---------ARABA MENU------------\n");
    printf("1) Kiralanan araclarin listesi\n");
    printf("2) Mevcut araclari listeleyin\n");
    printf("3) Arac kiralayin\n");
    printf("0) Ust menu\n");
    printf("-------------------------------\n");
    printf("\nSecim : ");
    int secim;
    scanf("%d", &secim);

    switch (secim)
    {
    case 0:
        return;
        break;
    case 1:
        KiralananAraclar();
        break;
    case 2:
        MevcutAraclarinListesi();
        break;
    case 3:
        AracKirala();
        break;
    default:
        printf("\nHatali secim !\n");
        break;
    }
    printf("\n");
    ArabaMenu();
}
void KiralananAraclar()
{
    printf("\n--- KIRALANAN ARACLAR\n");
    ListeleKiralama();
}
void MevcutAraclarinListesi()
{
    printf("\n--- MEVCUT ARACLARIN LISTELEYIN\n");
    int i;
    for (i = 0; i < aSayi; i++)
    {
        Arac arac = araclar[GetirArac(araclar[i].no)];     
        if (KiralanmamisArac(arac.no) == 1)
        {
            YazdirArac(arac);
        }
    }
}
void AracKirala()
{
    Kiralama *kiralama = (Kiralama *)malloc(sizeof(Kiralama));
    printf("\n--- ARAC KIRALAYIN\n");

    printf("\nNo      : ");
    scanf("%d", &kiralama->no);
    printf("Musteri : ");
    scanf("%d", &kiralama->musteriNo);
    if (GetirMusteri(kiralama->musteriNo) == -1)
    {
        printf("Musteri bulunamadi!");
        AracKirala();
    }
    printf("Arac    : ");
    scanf("%d", &kiralama->aracNo);
    if (GetirArac(kiralama->aracNo) == -1)
    {
        printf("Arac bulunamadi!");
        AracKirala();
    }
    printf("Tarih   : ");
    scanf("%s", kiralama->tarih);
    printf("Gun     : ");
    scanf("%d", &kiralama->gun);
    printf("Tutar   : ");
    float tutar = araclar[GetirArac(kiralama->aracNo)].fiyat;
    kiralama->tutar = tutar * kiralama->gun;

    if (EkleKiralama(kiralama))
    {
        printf("\nKiralama kaydi olusturuldu.\n");
        DosyaYazKiralama();
        return;
    }
    printf("\nKayit basarisiz.\n");
}

void YazdirArac(Arac arac)
{
    printf("\nNo    : %d\n", arac.no);
    printf("Marka : %s\n", arac.marka);
    printf("Model : %s\n", arac.model);
    printf("Yil   : %d\n", arac.yil);
    printf("Fiyat : %.2f TL\n", arac.fiyat);
    printf("Hava Yastigi (1=var,0=yok)    : %d\n", arac.hava_yastigi);
    printf("Isitmali Koltuk (1=var,0=yok) : %d\n\n", arac.isitmali_koltuk);
}
void DosyaOkuArac()
{
    FILE *dosya = fopen(DOSYA_ARAC, "r");

    while (!feof(dosya))
    {
        Arac *arac = (Arac *)malloc(sizeof(Arac));
        fscanf(
            dosya, "%d , %s , %s , %d , %f , %d , %d",
            &arac->no, arac->marka, arac->model, &arac->yil, &arac->fiyat, &arac->hava_yastigi, &arac->isitmali_koltuk);
        if (strcmp(arac->model, "") != 0)
            EkleArac(arac);
    }
    fclose(dosya);
}
int EkleArac(Arac *arac)
{
    if (aSayi >= 100)
        return 0;
    araclar[aSayi].no = arac->no;
    araclar[aSayi].fiyat = arac->fiyat;
    araclar[aSayi].yil = arac->yil;
    araclar[aSayi].hava_yastigi = arac->hava_yastigi;
    araclar[aSayi].isitmali_koltuk = arac->isitmali_koltuk;
    strcpy(araclar[aSayi].marka, arac->marka);
    strcpy(araclar[aSayi].model, arac->model);
    aSayi++;
    return 1;
}
void DosyaYazArac()
{
    int i;
    FILE *dosya = fopen(DOSYA_ARAC, "w");
    for (i = 0; i < aSayi; i++)
    {
        if (araclar[i].no != 0)
            fprintf(dosya,
                    "%d , %s , %s , %d , %f , %d , %d\n",
                    araclar[i].no, araclar[i].marka, araclar[i].model, araclar[i].yil, araclar[i].fiyat, araclar[i].hava_yastigi, araclar[i].isitmali_koltuk);
    }
    fclose(dosya);
}
int SilArac(int no)
{
    int i;
    for (i = 0; i < aSayi; i++)
    {
        if (araclar[i].no == no)
        {
            printf("\nSilinen arac bilgileri >>\n");
            YazdirArac(araclar[i]);
            araclar[i].no = 0;
            araclar[i].fiyat = 0;
            araclar[i].yil = 0;
            araclar[i].hava_yastigi = 0;
            araclar[i].isitmali_koltuk = 0;
            strcpy(araclar[i].marka, "");
            strcpy(araclar[i].model, "");
            DosyaYazArac();
            return 1;
        }
    }

    return 0;
}
void ListeleArac()
{
    int i;
    for (i = 0; i < aSayi; i++)
    {
        if (araclar[i].no != 0)
            YazdirArac(araclar[i]);
    }
}
int GetirArac(int no)
{
    int i;
    for (i = 0; i < aSayi; i++)
    {
        if (araclar[i].no == no)
            return i;
    }
    return -1;
}

void YazdirMusteri(Musteri musteri)
{
    printf("\nNo      : %d\n", musteri.no);
    printf("Ad      : %s\n", musteri.ad);
    printf("Soyad   : %s\n", musteri.soyad);
    printf("Dogum   : %d\n", musteri.dogum);
    printf("Adres   : %s\n", musteri.adres);
    printf("Ehliyet : %s\n\n", musteri.ehliyet);
}
void DosyaOkuMusteri()
{
    FILE *dosya = fopen(DOSYA_MUSTERI, "r");

    while (!feof(dosya))
    {
        Musteri *musteri = (Musteri *)malloc(sizeof(Musteri));
        fscanf(
            dosya, "%d , %s , %s , %d , %s , %s",
            &musteri->no, musteri->ad, musteri->soyad, &musteri->dogum, musteri->adres, musteri->ehliyet);
        if (strcmp(musteri->ehliyet, "") != 0)
            EkleMusteri(musteri);
    }
    fclose(dosya);
}
int EkleMusteri(Musteri *musteri)
{
    if (mSayi >= 100)
        return 0;
    musteriler[mSayi].no = musteri->no;
    strcpy(musteriler[mSayi].ad, musteri->ad);
    strcpy(musteriler[mSayi].soyad, musteri->soyad);
    musteriler[mSayi].dogum = musteri->dogum;
    strcpy(musteriler[mSayi].adres, musteri->adres);
    strcpy(musteriler[mSayi].ehliyet, musteri->ehliyet);
    mSayi++;
    return 1;
}
void DosyaYazMusteri()
{
    int i;
    FILE *dosya = fopen(DOSYA_MUSTERI, "w");
    for (i = 0; i < mSayi; i++)
    {
        if (musteriler[i].no != 0)
            fprintf(dosya,
                    "%d , %s , %s , %d , %s , %s\n",
                    musteriler[i].no, musteriler[i].ad, musteriler[i].soyad, musteriler[i].dogum, musteriler[i].adres, musteriler[i].ehliyet);
    }
    fclose(dosya);
}
void ListeleMusteri()
{
    int i;
    for (i = 0; i < mSayi; i++)
    {
        if (musteriler[i].no != 0)
            YazdirMusteri(musteriler[i]);
    }
}
int GetirMusteri(int no)
{
    int i;
    for (i = 0; i < mSayi; i++)
    {
        if (musteriler[i].no == no)
            return i;
    }
    return -1;
}

void YazdirKiralama(Kiralama kiralama)
{
    Musteri musteri = musteriler[GetirMusteri(kiralama.musteriNo)];
    Arac arac = araclar[GetirArac(kiralama.aracNo)];
    printf("\nNo      : %d\n", kiralama.no);
    printf("Musteri : %s %s\n", musteri.ad, musteri.soyad);
    printf("Arac    : %s %s\n", arac.marka, arac.model);
    printf("Tarih   : %s\n", kiralama.tarih);
    printf("Gun     : %d\n", kiralama.gun);
    printf("Tutar   : %.2f TL\n", kiralama.tutar);
}
void DosyaOkuKiralama()
{
    FILE *dosya = fopen(DOSYA_KIRALAMA, "r");

    while (!feof(dosya))
    {
        Kiralama *kiralama = (Kiralama *)malloc(sizeof(Kiralama));
        fscanf(
            dosya, "%d , %d , %d , %s , %d , %f",
            &kiralama->no, &kiralama->musteriNo, &kiralama->aracNo, kiralama->tarih, &kiralama->gun, &kiralama->tutar);
       if (kiralama->gun != 0)
            EkleKiralama(kiralama);
    }
    fclose(dosya);
}
int EkleKiralama(Kiralama *kiralama)
{
    if (kSayi >= 100)
        return 0;

    kiralamalar[kSayi].no = kiralama->no;
    kiralamalar[kSayi].musteriNo = kiralama->musteriNo;
    kiralamalar[kSayi].aracNo = kiralama->aracNo;
    strcpy(kiralamalar[kSayi].tarih, kiralama->tarih);
    kiralamalar[kSayi].gun = kiralama->gun;
    kiralamalar[kSayi].tutar = kiralama->tutar;

    kSayi++;
    return 1;
}
void DosyaYazKiralama()
{
    int i;
    FILE *dosya = fopen(DOSYA_KIRALAMA, "w");
    for (i = 0; i < kSayi; i++)
    {
        if (kiralamalar[i].no != 0)
            fprintf(dosya, "%d , %d , %d , %s , %d , %f\n",
                    kiralamalar[i].no, kiralamalar[i].musteriNo, kiralamalar[i].aracNo, kiralamalar[i].tarih, kiralamalar[i].gun, kiralamalar[i].tutar);
    }
    fclose(dosya);
}
void ListeleKiralama()
{
    int i;
    for (i = 0; i < kSayi; i++)
    {
        YazdirKiralama(kiralamalar[i]);
    }
}
int KiralanmamisArac(int aracNo)
{
    int i;
    for (i = 0; i < kSayi; i++)
    {
        if (kiralamalar[i].aracNo == aracNo)
            return 0;
    }
    return 1;
}