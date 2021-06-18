#include <stdio.h>
#include <stdlib.h>

struct myname
{
    char first_name[20];
    char last_name[20];
};

void initial(struct myname myn)
{
    printf("output is %c. %s\n", myn.first_name[0], myn.last_name);
    return;
}

int main()
{
    struct myname myn;
    printf("Enter First Name: ");
    scanf("%s", myn.first_name);

    printf("Enter Last Name: ");
    scanf("%s", myn.last_name);

    initial(myn);

    return 0;
}