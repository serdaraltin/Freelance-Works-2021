#include <stdio.h>
#include <stdlib.h>

int main()
{

    int n = 0;
    printf("N value: ");
    scanf("%d", &n);

    int array[n];

    int i;

    for (i = 0; i < n; i++)
    {
        printf("%d. array element value : ", i + 1);
        scanf("%d", &array[i]);
    }
    printf("\nReverse Order\n");

    for (i = n - 1; i >= 0; i--)
    {
        printf("%d\n", array[i]);
    }
}