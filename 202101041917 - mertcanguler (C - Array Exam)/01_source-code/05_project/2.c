#include <stdio.h>
#include <stdlib.h>

int main()
{
    int len = 5, i;
    int array1[] = {1, 2, 3, 4, 5};
    int array2[] = {0, 0, 0, 0, 0};

    printf("Array1 <> Array2\n");
    for (i = 0; i < len; i++)
    {
        printf("%d <> %d\n", array1[i], array2[i]);
        array2[i] = array1[i];
    }
    printf("\nCopy Array1 to Array2\n\n");
    printf("Array1 <> Array2\n");
    for (i = 0; i < len; i++)
    {
        printf("%d <> %d\n", array1[i], array2[i]);
    }
    printf("\n");
}