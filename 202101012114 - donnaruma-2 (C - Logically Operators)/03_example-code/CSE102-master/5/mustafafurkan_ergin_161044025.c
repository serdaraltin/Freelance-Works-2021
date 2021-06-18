/* Mustafa Furkan Ergin - 161044025 - HW5 */

#include<stdio.h>
#include<string.h>

#define MAXLENGTH 250 
#define NODELENGTH 10

int func(char *text,int count,FILE *doc2);

int main(){
	
	FILE *doc=fopen("input.txt","r");
	FILE *doc2=fopen("output.txt","w");
	char text[MAXLENGTH],*junk;
	int i, length;

	fgets(text,MAXLENGTH,doc);

	length = strlen(text); 

	text[length-1]='\0'; 

	for (i = 0; text[i] == ' ' || text[i] == '\t'; ++i)
		;
	junk = &text[i]; /* delete space and '\t' characters from begining of the string */

	func(junk,0,doc2);
	
	fclose(doc);
	fclose(doc2);
}

int func(char *text,int count,FILE *doc2){	

	int i=0;

	if (text[0]=='\0')
		return 0;
	
	if(text[0]=='(') count++; /* open brackets counts and increasing */
	if(text[0]==')') count--; /* open brackets counts and decreasing */


	if(text[-2] != ',' && text[-1]=='(' && text[0]!='(' && text[0]!=',')
		for(i=0;i<count;++i)
			fprintf(doc2,"-");	/* print '-' for the first character */
	
	if(text[-1]==',')
		for(i=0;i<count;++i) 	/* print '-' for the other characters */
			fprintf(doc2,"-");
	
	if(text[0]==',')
		fprintf(doc2,"\n"); /* bottom line for new node */
		
	if(text[0]!=',' && text[0]!= '(' && text[0] != ')')
		fprintf(doc2,"%c",text[0]); /* printed nodes */
	

	return func(&text[1],count,doc2);
}		

