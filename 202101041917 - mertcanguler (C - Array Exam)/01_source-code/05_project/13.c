#include <stdio.h>
#include <stdlib.h>

int r = 3, c = 3;

int sumRightDiagonal(int matrix[r][c])
{
    int i, j, sum = 0;
    for (i = 0; i < r; i++)
    {
        for (j = 0; j < c; j++)
        {
            if (i == j)
                sum = sum + matrix[i][j];
        }
    }
    return sum;
}
int main()
{
    int i, j;
    int arr1[3][3] = {
        {1, 2, 3},
        {1, 2, 3},
        {1, 2, 3}};

    printf("The matrix is >\n");
    for (i = 0; i < r; i++)
    {
        for (j = 0; j < c; j++)
        {
            printf("%3d", arr1[i][j]);
        }
        printf("\n");
    }

    printf("Addition of the right Diagonal elements is :%d\n", sumRightDiagonal(arr1));
}