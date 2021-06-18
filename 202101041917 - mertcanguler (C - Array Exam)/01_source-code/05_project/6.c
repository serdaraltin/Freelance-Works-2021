#include <stdio.h>
#include <stdlib.h>

int main()
{
    int len = 10;
    int arr1[] = {7,11,3,11,58,36,36,7,3,3};
    int fr1[len];
    int  i, j, ctr;

    for (i = 0; i < len; i++)
    {
        printf("Array[%d] = %d\n",i,arr1[i]);
        fr1[i] = -1;
    }
    
    for (i = 0; i < len; i++)
    {
        ctr = 1;
        for (j = i + 1; j < len; j++)
        {
            if (arr1[i] == arr1[j])
            {
                ctr++;
                fr1[j] = 0;
            }
        }

        if (fr1[i] != 0)
        {
            fr1[i] = ctr;
        }
    }
    printf("\nFrequency of each element of an array > \n");
    for (i = 0; i < len; i++)
    {
        if (fr1[i] != 0)
        {
            printf("%d occurs %d times\n", arr1[i], fr1[i]);
        }
    }
}