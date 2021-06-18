#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define MAX 100

int hash[MAX + 1][2];

int ara(int x)
{
    if (x >= 0)
    {
        if (hash[x][0] == 1)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}

void ekle(int a[], int n)
{
    int i;
    for (i = 0; i < n; i++)
    {
        if (a[i] >= 0)
        {
            hash[a[i]][0] = 1;
        }
        else
        {
            hash[abs(a[i])][1] = 1;
        }
    }
}

void kesisim(int a[], int aN, int b[], int bN)
{
    int i;
    for (i = 0; i < MAX; i++)
    {
        hash[i][0] = 0;
        hash[i][1] = 0;
    }

    ekle(a, aN);

    for (i = 0; i < MAX; i++)
    {
        printf("Hash[%d][%d]\n",hash[i][0],hash[i][1]);
    }
    
    int yok = 1;
    printf("\n");
    for (i = 0; i < bN; i++)
    {
        if (ara(b[i]))
        {
            yok = 0;
            printf("ortak > %d\n", b[i]);
        }
    }
    if (yok)
    {
        printf("Kesisim bulunmamaktadir !\n");
    }
}

int main()
{
    int i, aBoyut = 0, bBoyut = 0;
    printf("1. dizi eleman sayisi : ");
    scanf("%d", &aBoyut);
    int a[aBoyut];

    for (i = 0; i < aBoyut; i++)
    {
        printf("%d. elemani giriniz : ", (i + 1));
        scanf("%d", &a[i]);
    }

    printf("\n2. dizi eleman sayisi : ");
    scanf("%d", &bBoyut);
    int b[bBoyut];

    for (i = 0; i < bBoyut; i++)
    {
        printf("%d. elemani giriniz : ", (i + 1));
        scanf("%d", &b[i]);
    }

    kesisim(a, aBoyut, b, bBoyut);
}
