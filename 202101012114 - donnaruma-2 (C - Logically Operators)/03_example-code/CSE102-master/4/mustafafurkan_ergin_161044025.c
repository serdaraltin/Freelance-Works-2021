/* Mustafa Furkan Ergin - HW4 - 161044025 */

#include<stdio.h>
#include<string.h>
#include<math.h>
	
#define MAXDOUBLENUMBERS 100 
#define MAXLENGTHOFPOLYNOMIAL 1000	/* defines */

void read();
void poly(double value[],char polynomial[],int i,int j);

int main(){	
	read();
}

void read(){
	
	double value[MAXDOUBLENUMBERS];
	char polynomial[MAXLENGTHOFPOLYNOMIAL];
	int i=0,j;	
	
	FILE *doc1,*doc2;
	
	doc1=fopen("values.txt","r");
	
	while( fscanf(doc1,"%lf",&value[i]) != EOF ){/* first document(values.txt) has been read */ 
		i++;
	}

	fclose(doc1);
	
	doc2=fopen("polynomial.txt","r");
	
	while(fgets(polynomial,MAXLENGTHOFPOLYNOMIAL,doc2) != NULL);/* second document(polynomial.txt) has been read */
	j=strlen(polynomial);

	fclose(doc2);

	poly(value,polynomial,i,j-1);/* evaluation function has been called */

}

void poly(double value[],char polynomial[],int number_value,int poly_length){
	
	FILE *doc=fopen("evaluations.txt","w");
	char new_polynomial[MAXLENGTHOFPOLYNOMIAL][MAXLENGTHOFPOLYNOMIAL];
	char junk_chars,operator, junk;
	int row=0,column=0,i,j,first_operator,power=1, ret_val, k;
	double coefficient=1,result=0,temp=0;
	
	for(i = 0; i < poly_length; i++){ 
		
		/* polynomial seperated something like that*/
		/* 5x										*/
		/*+23.5x^3									*/
		/*-x^2										*/
		/*+5										*/
		if(polynomial[i] == '+' || polynomial[i] == '-'){ 
			row++;
			column=0;
		}
		
		if(polynomial[i]!=' '&& polynomial[i] != '\t'){	
			new_polynomial[row][column]=polynomial[i];
			column++;
		}			
	}
	++row;

	if(new_polynomial[0][0]=='\0') {
		first_operator=1; /* There is an operator sign at the beginning. */
	} else {
		first_operator=0;
	}
	for(i = 0; i < number_value; i++) {
		for(j = first_operator; j < row; j++){
			if (new_polynomial[j][0] == '-' || new_polynomial[j][0] == '+'){
				k=1;
				sscanf(&new_polynomial[j][0], "%c", &operator);
			} 
			else{
				operator='+';
				k=0;
			}
			if (new_polynomial[j][k] != 'x'){
				ret_val=sscanf(&new_polynomial[j][k], "%lf%c%c%d", &coefficient, &junk_chars, &junk, &power);
				if(ret_val == 1)			/* e.g. 5.0 */
					temp=coefficient;
			    else if(ret_val == 2)	    /* e.g. 5.0x */
					temp=coefficient * value[i];
				else 				/* e.g. 5.0x^2 */	
					temp=coefficient * pow(value[i], power);
			} 
			else{
				ret_val=sscanf(&new_polynomial[j][k], "%c%c%d", &junk_chars, &junk, &power);
				if(ret_val==1)			/* e.g. x */
					temp=value[i];
			
				else						/* e.g. x^2 */
					temp=pow(value[i], power);
			}
			if(operator=='-')
				result += -temp; 
			else
				result += temp;
		}
		fprintf(doc,"%.2f\n",result);/* results has been printed in the file */
		result=0;
	}

	fclose(doc);
}
