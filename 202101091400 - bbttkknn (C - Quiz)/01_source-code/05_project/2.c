#include <stdio.h>
#include <stdlib.h>

double f(int number){
    return (double)number;
}

int main()
{
    int number;
    printf("Enter Integer Number : ");
    scanf("%d",&number);
    printf("Number double version = %lf\n",f(number));
    return 0;
}