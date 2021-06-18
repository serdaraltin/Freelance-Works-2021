#include <stdio.h>

#define BOYUT 7

char romaRakami[] = {'I','V','X','L','C','D','M'};
int sayilar[] = {1,5,10,50,100,500,1000};

int main(){
    int sayi;

    printf("Bir sayi giriniz: ");
    scanf("%d",&sayi);
    printf("Girdiginiz sayinin Roma sayi karsiligi : ");
    while(sayi != 0)
    {
        if (sayi >= 1000)       
        {
           printf("M");
           sayi -= 1000;
        }
        else if (sayi >= 900)   
        {
           printf("CM");
           sayi -= 900;
        }        
        else if (sayi >= 500)  
        {           
           printf("D");
           sayi -= 500;
        }
        else if (sayi >= 400)   
        {
           printf("CD");
           sayi -= 400;
        }
        else if (sayi >= 100)  
        {
           printf("C");
           sayi -= 100;                       
        }
        else if (sayi >= 90)    
        {
           printf("XC");
           sayi -= 90;                                              
        }
        else if (sayi >= 50)    
        {
           printf("L");
           sayi -= 50;                                                                     
        }
        else if (sayi >= 40)   
        {
           printf("XL");           
           sayi -= 40;
        }
        else if (sayi >= 10)    
        {
           printf("X");
           sayi -= 10;           
        }
        else if (sayi >= 9)    
        {
           printf("IX");
           sayi -= 9;                         
        }
        else if (sayi >= 5)     
        {
           printf("V");
           sayi -= 5;                                     
        }
        else if (sayi >= 4)    
        {
           printf("IV");
           sayi -= 4;                                                            
        }
        else if (sayi >= 1)   
        {
           printf("I");
           sayi -= 1;                                                                                   
        }

    }
    printf("\n");

    return 0;

}