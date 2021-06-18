#include <stdio.h>
#include <stdlib.h>

int r = 3, c = 3;

void sumRC(int matrix[r][c])
{
    int rsum[3], csum[3];
    int i, j, k;
    for (i = 0; i < r; i++)
    {
        rsum[i] = 0;
        for (j = 0; j < c; j++)
            rsum[i] = rsum[i] + matrix[i][j];
    }

    for (i = 0; i < r; i++)
    {
        csum[i] = 0;
        for (j = 0; j < c; j++)
            csum[i] = csum[i] + matrix[j][i];
    }

    printf("The sum or rows and columns >\n");
    for (i = 0; i < r; i++)
    {
        for (j = 0; j < c; j++)
        {
            printf("%3d", matrix[i][j]);
        }
        printf("%6d", rsum[i]);
        printf("\n");
    }
    printf("\n");
    for (j = 0; j < r; j++)
    {
        printf("%3d", csum[j]);
    }
    printf("\n");
}
int main()
{
    int arr1[3][3] = {
        {1, 2, 3},
        {1, 2, 3},
        {1, 2, 3}};

    int i, j, k;

    printf("The matrix is >\n");
    for (i = 0; i < r; i++)
    {
        for (j = 0; j < c; j++)
        {
            printf("%3d", arr1[i][j]);
        }

        printf("\n");
    }
    sumRC(arr1);
}