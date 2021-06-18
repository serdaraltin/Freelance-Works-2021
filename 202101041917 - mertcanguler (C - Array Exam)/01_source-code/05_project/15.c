#include <stdio.h>
#include <stdlib.h>

int determinant(int matrix[3][3])
{
    int i, j;
    int det = 0;
    for (i = 0; i < 3; i++)
        det = det + (matrix[0][i] * (matrix[1][(i + 1) % 3] * matrix[2][(i + 2) % 3] - matrix[1][(i + 2) % 3] * matrix[2][(i + 1) % 3]));
    return det;
}
int main()
{
    int arr1[3][3] = {
        {1, 0, -1},
        {0, 0, 1},
        {-1, -1, 0}};

    int i, j, n = 3;

    printf("The matrix is >\n");
    for (i = 0; i < 3; i++)
    {
        for (j = 0; j < 3; j++)
        {
            printf("%3d", arr1[i][j]);
        }

        printf("\n");
    }

    printf("\nThe Determinant of the matrix is: %d\n\n", determinant(arr1));
}