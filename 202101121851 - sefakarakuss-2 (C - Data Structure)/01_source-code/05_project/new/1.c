#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct cell
{
    char *anahtar;
    struct cell *next;
};

struct table_node
{
    int count;
    struct cell *header;
};

struct hash_tablosu
{
    struct table_node *tablo_basi;
    int tablo_uzunlugu;
    int multiplier;
};

void initialize_hash_table(struct hash_tablosu **hash_table,
                           int multiplier, int table_size)
{
    int i;
    *hash_table = (struct hash_tablosu *)malloc(sizeof(struct hash_tablosu));
    if (*hash_table == NULL)
    {
        printf(" Hash tablosu icin yer ayrilamnadi... Hata!!!");
        exit(1);
    }
    (*hash_table)->tablo_basi =
        (struct table_node *)malloc(table_size * sizeof(struct table_node));
    if ((*hash_table)->tablo_basi == NULL)
    {
        printf(" Hash tablosu icin yer ayrilamnadi... Hata!!!");
        exit(1);
    }
    (*hash_table)->tablo_uzunlugu = table_size;
    (*hash_table)->multiplier = multiplier;

    for (i = 0; i < table_size; i++)
    {
        ((*hash_table)->tablo_basi + i)->count = 0;
        ((*hash_table)->tablo_basi + i)->header = NULL;
    }
}

unsigned int hash(char *s, int multiplier, int table_size)
{
    int i = 0;
    unsigned int value = 0;
    while (s[i] != '\0')
    {
        value = (s[i] + multiplier * value) % table_size;
        i++;
    }
    return value;
}

struct cell *hucre_olustur(char *icerik)
{
    struct cell *a;
    a = (struct cell *)(malloc(sizeof(struct cell)));
    if (a == NULL)
    {
        printf("Heapten yer ayr�lamad�...\n");
        exit(1);
    }
    a->anahtar = (char *)malloc((strlen(icerik) + 1) * sizeof(char));
    strcpy(a->anahtar, icerik);
    a->next = NULL;
    return a;
}

void liste_sonu(char *icerik, struct cell **liste_basi)
{

    struct cell *a = hucre_olustur(icerik);
    if (*liste_basi == NULL)
    {

        a->next = *liste_basi;
        *liste_basi = a;
    }
    else
    {
        struct cell *x = *liste_basi;
        while (x->next != NULL)
        {
            x = x->next;
        }
        x->next = a;
    }
}

void liste_yaz(struct cell *liste_basi)
{
    while (liste_basi != NULL)
    {
        printf("%s\n", liste_basi->anahtar);
        liste_basi = liste_basi->next;
    }
    printf("\n");
}

void listeyi_hash_tablosuna_donusturme(struct hash_tablosu *htable, struct cell **liste_basi)
{
    struct cell *liste = *liste_basi;

    while (liste)
    {
        int hash_index = hash(liste->anahtar, htable->multiplier, htable->tablo_uzunlugu);

        if ((htable->tablo_basi + hash_index)->header == NULL)
        {
            (htable->tablo_basi + hash_index)->header = liste;
            (htable->tablo_basi + hash_index)->count++;
        }else{
            (htable->tablo_basi + hash_index)->header->next = liste;
            (htable->tablo_basi + hash_index)->count++;
        }
        (htable->tablo_basi + hash_index)->header->next == NULL;

        struct cell *mevcut = liste;
        liste = liste->next;
        mevcut->next = NULL;
    }
}

void print_list(struct cell *l)
{
    if (l != NULL)
    {
        printf("%s ", l->anahtar);
        print_list(l->next);
    }
}

void print_hash_table(struct hash_tablosu *hash_table)
{
    if (hash_table)
    {
        int index;
        printf("----- HASH TABLOSU -----\n");
        for (index = 0; index < hash_table->tablo_uzunlugu; index++)
        {
            printf("%5d : (%2d) ", index, (hash_table->tablo_basi + index)->count);

            print_list((hash_table->tablo_basi + index)->header);
            printf("\n");
        }
    }
    else
        printf("Hash Tablosu Bos ...\n");
}

int main(int argc, char *argv[])
{

    struct cell *A;
    A = NULL;
    liste_sonu("mehmet", &A);
    liste_sonu("ahmet", &A);
    liste_sonu("vehmet", &A);
    liste_sonu("hehmet", &A);
    liste_sonu("tayfun", &A);
    liste_sonu("tayfun", &A);

    liste_yaz(A);
    struct hash_tablosu *htable = NULL;

    initialize_hash_table(&htable, 7, 10);
    print_hash_table(htable);
    listeyi_hash_tablosuna_donusturme(htable, &A);
    print_hash_table(htable);
    printf("\nbitti\n");
    return 0;
}
