#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i, pos, n = 10;
    int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    for (i = 0; i < n; i++)
    {
        printf("Array[%d] = %d\n", i, arr1[i]);
    }

    printf("\nDelete value : ");
    scanf("%d", &pos);

    i = 0;
    while (i != pos - 1)
        i++;

    while (i < n)
    {
        arr1[i] = arr1[i + 1];
        i++;
    }
    n--;
    printf("\nThe new list is >\n");
    for (i = 0; i < n; i++)
    {
        printf("Array[%d] = %d\n", i, arr1[i]);
    }
    printf("\n");
}