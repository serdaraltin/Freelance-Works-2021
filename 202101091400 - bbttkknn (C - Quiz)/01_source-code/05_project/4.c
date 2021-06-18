#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    int i=0,j=0,array[100];
    char *str = (char*)malloc(sizeof(char)*100);
    printf("Please input the elements of the array:\n");
    scanf("%[^\n]",str);

    char* token = strtok(str, " "); 

    while (token != NULL) { 
        array[i++] = atoi(token);
        token = strtok(NULL, " "); 
    } 
    printf("the number of elements input is: %d\n",i);
    for (j = 0; j < i; j++)
    {
         printf("%d\n",array[j]);
    }
}