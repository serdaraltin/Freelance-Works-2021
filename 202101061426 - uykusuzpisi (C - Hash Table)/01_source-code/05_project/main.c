#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define MAX 11

int hash[MAX];

int ara(int x)
{
    int i, mod = x % MAX;

    if (hash[mod] == x)
    {
        return 1;
    }
    for (i = 0; i < MAX; i++)
    {
        if (hash[i] == x)
        {
            return 1;
        }
    }
    return 0;
}

void ekle(int a[], int n)
{
    int i, j;
    for (i = 0; i < n; i++)
    {
        int mod = a[i] % MAX;
        if (hash[mod] == 0)
        {
            hash[mod] = a[i];
        }
        else
        {
            int bas = mod + 1;
            if (mod == MAX - 1)
            {
                bas = 0;
            }
            for (j = bas; j < MAX; j++)
            {
                if (hash[j] == 0)
                {
                    hash[j] = a[i];
                    break;
                }
            }
        }
    }
}

void kesisim(int a[], int aN, int b[], int bN)
{
    int i;
    for (i = 0; i < MAX; i++)
    {
        hash[i] = 0;
    }

    ekle(a, aN);

    printf("Hash tablosu >>\n");
    for (i = 0; i < MAX; i++)
    {
        printf("%d ", hash[i]);
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
