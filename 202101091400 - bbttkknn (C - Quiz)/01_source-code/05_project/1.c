#include <stdio.h>
#include <stdlib.h>


int main()
{
    float input_num;
    printf("Enter decimal number: ");
    scanf("%f",&input_num);
    int integer_num =(int)input_num;
    printf("Output integer number = %d\n",integer_num);
}