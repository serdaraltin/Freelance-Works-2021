#include <stdio.h>
#include <stdlib.h>

int main()
{
    int arr1[] = {78, 15, 33, 42, 17, 10, 55, 1, 4, 3};
    int i, j = 0, k = 0, n = 10;
    int arr2[n], arr3[n];

    for (i = 0; i < n; i++)
    {
        printf("Array[%d] = %d\n", i, arr1[i]);
    }

    for (i = 0; i < n; i++)
    {
        if (arr1[i] % 2 == 0)
        {
            arr2[j] = arr1[i];
            j++;
        }
        else
        {
            arr3[k] = arr1[i];
            k++;
        }
    }

    printf("\nThe Even elements are >\n");
    for (i = 0; i < j; i++)
    {
        printf("Array2[%d] = %d\n", i, arr2[i]);
    }

    printf("\nThe Odd elements are >\n");
    for (i = 0; i < k; i++)
    {
        printf("%d ", arr3[i]);
        printf("Array3[%d] = %d\n", i, arr3[i]);
    }
    printf("\n");
}