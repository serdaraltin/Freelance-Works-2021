#include "stdio.h"
#include "stdlib.h"

int main() {
    char string[] = "BADGERS";
    char *ptr = string;
    *ptr = *ptr+2;
    ptr = ptr+2;
    printf("%c",*ptr);
    ptr--;
    printf("%c",*ptr);
    ptr= ptr+1;
    printf("%c",*ptr);
}