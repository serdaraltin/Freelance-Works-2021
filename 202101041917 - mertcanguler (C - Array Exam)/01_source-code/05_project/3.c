#include <stdio.h>
#include <stdlib.h>

#define LEN 10

int duplicateElementsCount(int array[], int len)
{
    int i, j, totalNum = 0;

    for (i = 0; i < len; i++)
    {
        for (j = i + 1; j < len; j++)
        {
            if (array[i] == array[j])
            {
                totalNum++;
                break;
            }
        }
    }

    return totalNum;
}

int main()
{

    int array[] = {1, 2, 3, 3, 5, 6, 6, 8, 9, 1};
    int i;

    for (i = 0; i < LEN; i++)
    {
        printf("Array[%d] = %d\n", i, array[i]);
    }
    printf("\nTotal number of duplicate element : %d\n", duplicateElementsCount(array, LEN));
}