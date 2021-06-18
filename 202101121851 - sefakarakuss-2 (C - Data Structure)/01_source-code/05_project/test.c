#include <stdio.h>
#include <stdlib.h>

#include <string.h>

struct CELL
{
    char *anahtar;
    struct CELL *next;
};

int lookup(char *anahtar,struct CELL *l) //Arama
{
    if(l==NULL)
        return 0;
    else if( !strcmp(anahtar,l->anahtar) ) //Eşitse (string ifadeler eşitse) 0 döndürür. Değili 1.
        return 1;
    else
        return lookup(anahtar,l->next);
}

int insert(char *anahtar,struct CELL **l)
{
    if(*l==NULL) //Liste boş ise.
    {
        *l=(struct CELL *)malloc( sizeof(struct CELL) );
        (*l)->anahtar=(char *)malloc( (strlen(anahtar)+1)*sizeof(char) ); //strlen(anahtar)=>string uzunluğu.
        strcpy( (*l)->anahtar,anahtar );
        (*l)->next=NULL;
        return 1;
    }
    else if( strcmp(anahtar,(*l)->anahtar) ) 
            return insert( anahtar,&( (*l)->next ) );
    else 
        return 0;
}

void print_list(struct CELL *l)
{
    if(l!=NULL) 
    {
        printf("%s ",l->anahtar);
        print_list(l->next);
    }
    /*
    while(l!=NULL)
    {
        printf("%s",l->anahtar);
        l=l->next;
    }
    */   
}

struct table_node
{
    int counter;
    struct CELL *header; //Listenin başlangıç adresini tutar.
};

struct hash_tablosu
{
    struct table_node *tablo_basi; //[tablo_basi][tablo_uzunlugu][multiplier]
    int tablo_uzunlugu;            
    int multiplier;
};

unsigned hash(char *anahtar,int multiplier,int table_size)
{
    int i=0;
    unsigned int value=0;
    while(anahtar[i]) //while(anahtar[i]!=NULL)
    {
        value=( anahtar[i]+multiplier*value )%table_size;
        i++;
    }  
    return value;
}

void initialize_hash_table(struct hash_tablosu **hash_table,int multiplier,int table_size)
{
    int i;
    
    *hash_table=(struct hash_tablosu *)malloc( sizeof(struct hash_tablosu) );
    if(*hash_table==NULL)
    {
        printf("Hash tablosu icin yer ayrilamadi...");
        exit(1);
    }
    
    (*hash_table)->tablo_basi=(struct table_node *)malloc( table_size*sizeof(struct table_node) );
    if( (*hash_table)->tablo_basi==NULL )
    {
        printf("Hash tablosu icin yer ayrilamadi...");
        exit(1);
    }
    
    (*hash_table)->tablo_uzunlugu=table_size;
    (*hash_table)->multiplier=multiplier;
    
    for(i=0;i<table_size;i++)
    {
       ( ( (*hash_table)->tablo_basi )+i )->counter=0;
       ( ( (*hash_table)->tablo_basi )+i )->header=NULL;
    }
}

void insert_hash_table(struct hash_tablosu *hash_table,char *anahtar)
{
    int hash_index=hash(anahtar,hash_table->multiplier,hash_table->tablo_uzunlugu);
    if(insert( anahtar,&( (hash_table->tablo_basi + hash_index)->header) ) );
    (hash_table->tablo_basi+hash_index)->counter++;
}

void print_hash_table(struct hash_tablosu *hash_table)
{
    if(hash_table) //Null degilse.
    {
        int index;
        printf("----------HASH TABLOSU-------\n");
        for(index=0;index<hash_table->tablo_uzunlugu;index++)
        {
            printf("%5d : (%d) ",index,(hash_table->tablo_basi+index)->counter);
            print_list((hash_table->tablo_basi+index)->header);
            printf("\n");
        }
    }
    else 
     printf("Hash tablosu bos...\n");
}

int delete_dugum_liste(struct CELL **header,char *anahtar)
{
    struct CELL *simdiki,*onceki;
    simdiki=*header;
    while( simdiki && strcmp(simdiki->anahtar,anahtar) )
    {
 onceki=simdiki;
        simdiki=simdiki->next;
    }
    if(!simdiki)
  return 0;
    if(simdiki==*header)
    {
        *header=(*header)->next;
    }
    else
    {
        onceki->next=simdiki->next;
    }
    free(simdiki->anahtar);
    free(simdiki);
    return 1;
}

void delete_hash_table(struct hash_tablosu *table,char *anahtar)
{
    int hash_index=hash(anahtar,table->multiplier,table->tablo_uzunlugu);
    if(delete_dugum_liste( &( (table->tablo_basi +hash_index)->header ),anahtar) )
    (table->tablo_basi + hash_index)->counter--;
}

void liste_yok_et(struct CELL **liste_basi)
{
    struct CELL *onceki;
    while(*liste_basi)
    {
        onceki=*liste_basi;
        *liste_basi=(*liste_basi)->next;
        free(onceki->anahtar);
        free(onceki);
    }
}

void hash_table_yok_et(struct hash_tablosu **hash_table)
{
    int index;
    if(*hash_table)
    {
        for(index=0;index<(*hash_table)->tablo_uzunlugu;index++)
            liste_yok_et( &( (*hash_table)->tablo_basi+index )->header );
        free( (*hash_table)->tablo_basi );
        free(*hash_table);
    }
    *hash_table=NULL;
}

struct hash_tablosu *hash_table_buyut(struct hash_tablosu **htable,int multiplier,int tablo_uzunlugu)
{
    int i;
    struct CELL *liste_basi;
    struct hash_tablosu *yeni_tablo;
    if(!*htable)
        return NULL;
    initialize_hash_table(&yeni_tablo,multiplier,tablo_uzunlugu);
    for(i=0;i<(*htable)->tablo_uzunlugu;i++)
    {
        liste_basi=( (*htable)->tablo_basi + i )->header;
        while(liste_basi!=NULL)
        {
            insert_hash_table(yeni_tablo,liste_basi->anahtar);
            liste_basi=liste_basi->next;
        }
    }
    hash_table_yok_et(htable);
    return yeni_tablo;
}

int main(int argc, char** argv) 
{
    struct hash_tablosu *htable;
    
    initialize_hash_table(&htable,7,11);
    print_hash_table(htable);
    /*
    0 [0][NULL]
    1 [0][NULL]
    ...
    10[0][NULL]
    */

    insert_hash_table(htable,"kadayif");
    insert_hash_table(htable,"trabzonspor");
    insert_hash_table(htable,"kadayif");
    insert_hash_table(htable,"gundogdu");
    insert_hash_table(htable,"besiktas");
    insert_hash_table(htable,"baklava");
    insert_hash_table(htable,"dembaba");
    insert_hash_table(htable,"cardozo");
    print_hash_table(htable);
    /*
    0:(1) dembaba
    1:(2) kadayif
    2:(0)
    3:(1) gundogdu
    4:(1) trabzonspor
    5:(0)
    6:(0)
    7:(2) baklava cardozo
    8:(1) besiktas
    9:()
    10:()
    */

    htable=hash_table_buyut(&htable,17,19);
    print_hash_table(htable);
    /*
    0:(0) 
    1:(0) 
    2:(0)
    3:(0) 
    4:(1) kadayif
    5:(0)
    6:(0)
    7:(1) cardozo
    8:(0) 
    9:(2) dembaba baklava
    10:(0)
    11:(0)
    12:(1) trabzonspor
    13:(0)
    14:(1) gundogdu
    15:(0)
    16:(0)
    17:(0)
    18:(1) besiktas
    */
    getch();
    return 0;
}