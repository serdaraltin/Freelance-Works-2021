#include <stdio.h>
#include <stdlib.h>

int main()
{
    int arr1[3][3] = {
        {1, 2, 3},
        {1, 2, 3},
        {1, 2, 3}};
    int brr1[3][3] = {
        {4, 5, 6},
        {4, 5, 6},
        {4, 5, 6}};

    int crr1[3][3], i, j, n = 3;

    printf("The First matrix is >\n");
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            printf("%3d", arr1[i][j]);
        }
        printf("\n");
    }

    printf("The Second matrix is >\n");
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            printf("%3d", brr1[i][j]);
        }
        printf("\n");
    }

    for (i = 0; i < n; i++)
        for (j = 0; j < n; j++)
            crr1[i][j] = arr1[i][j] + brr1[i][j];
    printf("\nThe Addition of two matrix is >\n");
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            printf("%3d", crr1[i][j]);
        }
        printf("\n");
    }
    printf("\n");
}