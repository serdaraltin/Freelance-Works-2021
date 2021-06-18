#include <stdio.h>
#include <stdlib.h>

int secondMin(int array[], int len)
{
    int n = len, i, j = 0, sml, sml2nd;
    sml = array[0];
    for (i = 0; i < n; i++)
    {
        if (sml > array[i])
        {
            sml = array[i];
            j = i;
        }
    }

    sml2nd = 99999;
    for (i = 0; i < n; i++)
    {
        if (i == j)
        {
            i++;
            i--;
        }
        else
        {
            if (sml2nd > array[i])
            {
                sml2nd = array[i];
            }
        }
    }
    return sml2nd;
}
int main()
{
    int n = 10, i;
    int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

    for (i = 0; i < n; i++)
    {
        printf("Array[%d] = %d\n", i, arr1[i]);
    }

    printf("\nThe Second smallest element :  %d \n", secondMin(arr1, n));
}