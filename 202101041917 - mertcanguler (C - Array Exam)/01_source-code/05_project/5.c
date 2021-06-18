#include <stdio.h>
#include <stdlib.h>

int main()
{
  
    int s1=4, s2=4, s3;
    int i, j, k;

    int arr1[] = {7,2,7,3};
    int arr2[] = {6,4,1,7};
    int arr3[s1+s2];

    s3 = s1 + s2;
  
    
    for (i = 0; i < s1; i++)
    {
        printf("Array1[%d] = %d\n",i,arr1[i]);
    }
    printf("\n");
    for (i = 0; i < s2; i++)
    {
        printf("Array2[%d] = %d\n",i,arr2[i]);
    }
    printf("\n");
    for (i = 0; i < s1; i++)
    {
        arr3[i] = arr1[i];
    }
    for (j = 0; j < s2; j++)
    {
        arr3[i] = arr2[j];
        i++;
    }
    
    for (i = 0; i < s3; i++)
    {
        for (k = 0; k < s3 - 1; k++)
        {

            if (arr3[k] <= arr3[k + 1])
            {
                j = arr3[k + 1];
                arr3[k + 1] = arr3[k];
                arr3[k] = j;
            }
        }
    }

   
    printf("The merged array in decending order is >\n");
    for (i = 0; i < s3; i++)
    {
        printf("Array3[%d] = %d\n",i,arr3[i]);
    }
    printf("\n");
}