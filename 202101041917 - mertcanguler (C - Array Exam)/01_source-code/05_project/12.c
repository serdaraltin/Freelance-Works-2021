#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i, j, r = 3, c = 3;

    int arr1[3][3] = {
        {1, 2, 3},
        {1, 2, 3},
        {1, 2, 3}};

    int brr1[3][3];

    printf("The matrix is >\n");
    for (i = 0; i < r; i++)
    {
        for (j = 0; j < c; j++)
        {
            printf("%3d", arr1[i][j]);
        }

        printf("\n");
    }

    for (i = 0; i < r; i++)
    {
        for (j = 0; j < c; j++)
        {
            brr1[j][i] = arr1[i][j];
        }
    }

    printf("\nThe transpose of a matrix is > \n");
    for (i = 0; i < c; i++)
    {
        for (j = 0; j < r; j++)
        {
            printf("%3d", brr1[i][j]);
        }
        printf("\n");
    }
    printf("\n");
}