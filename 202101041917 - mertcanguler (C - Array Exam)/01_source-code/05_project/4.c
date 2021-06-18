#include <stdio.h>
#include <stdlib.h>

int main()
{
    int array[] = {25, 13, 78, 13, 5, 7, 9, 25, 18, 3};
    int i, j, k, ctr = 0, len = 10;

    for (i = 0; i < len; i++)
    {
        printf("Array[%d] = %d\n", i, array[i]);
    }

    printf("\nAll unique elements : ");
    for (i = 0; i < len; i++)
    {
        ctr = 0;
        for (j = 0, k = len; j < k + 1; j++)
        {
            if (i != j)
            {
                if (array[i] == array[j])
                {
                    ctr++;
                }
            }
        }
        if (ctr == 0)
        {
            printf("%d ", array[i]);
        }
    }
    printf("\n");
}