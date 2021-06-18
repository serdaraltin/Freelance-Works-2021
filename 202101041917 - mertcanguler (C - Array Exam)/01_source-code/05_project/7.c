#include <stdio.h>
#include <stdlib.h>

void printMaxanMin(int array[], int len)
{
    int i, max, min, n = len;
    max = array[0];
    min = array[0];

    for (i = 1; i < n; i++)
    {
        if (array[i] > max)
        {
            max = array[i];
        }

        if (array[i] < min)
        {
            min = array[i];
        }
    }
    printf("Maximum element is : %d\n", max);
    printf("Minimum element is : %d\n", min);
}

int main()
{
    int arr1[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, len = 10;

    int i;
    for (i = 0; i < len; i++)
    {
        printf("Array[%d] = %d\n", i, arr1[i]);
    }
    printf("\n");
    printMaxanMin(arr1, len);
}