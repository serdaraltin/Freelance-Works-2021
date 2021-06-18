/* Mustafa Furkan Ergin - 161044025 - HW3 */

#include<stdio.h>

#define MAXWORDLENGTH 10
#define MAXROWLENGTH 250
#define MAXNUMOFROWS 100

#define TRUE 1
#define FALSE 0

char arr[MAXWORDLENGTH]; /* input1.txt words */
char arr2[MAXNUMOFROWS][MAXROWLENGTH]; /* input2.txt words */

void read();
void fun();

int main(){

	read();

}

void read(){
	
	FILE *doc, *doc2;
	int i=0;	
	
	doc=fopen("input1.txt","r");
	doc2=fopen("input2.txt","r");
	
	/* input2.txt read */
	while(fscanf(doc2,"%s",arr2[i])!=EOF){
		i++;
	}
		
	/* input1.txt read */
	while(fscanf(doc,"%s",arr)!=EOF){
		fun();/* function called for each word */
	}

	fclose(doc);
	fclose(doc2);	
	
}

void fun(){
	FILE *doc3;
	int i=0,j=0,k=0;
	int begin_index;
	
	doc3=fopen("output.txt","a");
	
	for (i=0;i<MAXNUMOFROWS;++i){		
		for (j=0;j<MAXROWLENGTH;++j){
			printf("%c %c\n %d %d %d ",arr[k],arr2[i][j],i,j,k);
			if (arr2[i][j]==arr[0]) 
				/* check horizontal words */		
				begin_index=TRUE;
				
				for (k=1;arr[k]!='\0' && begin_index;++k)
					
					if(arr2[i][j+k]!=arr[k])
						begin_index=FALSE;

				if(begin_index==FALSE){
					/* check vertical words */
					begin_index = TRUE;
					
					for (k=1;arr[k]!='\0' && begin_index;++k)
						if (arr2[i+k][j] != arr[k])
							begin_index=FALSE;
					/* vertical words found, printed to file */
					if(begin_index == TRUE)
						fprintf(doc3,"%s (%d,%d) Vertical\n",arr,i+1,j+1);
				}		
				/* horizontal words found, printed to file */
				else{
					fprintf(doc3,"%s (%d,%d) Horizontal\n",arr,i+1,j+1);
				}
			
		}
	}
	
	fclose(doc3);
}

