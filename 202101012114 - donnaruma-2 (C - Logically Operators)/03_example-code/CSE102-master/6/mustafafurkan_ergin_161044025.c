/* Mustafa Furkan Ergin - 161044025 - HW6 */

#include<stdio.h>
#include<string.h>

#define MAX 101

double rec(char *base, char *current);
int seperate(char *parts, char node[][MAX], int *num, double *price);
void read_from_user(char *str);
int count_digits(int number);

int main(){
	
	char object[MAX],new[MAX],new2[MAX];
	size_t length_object=0,ret_value=0;
	double result;

	printf("Name the object:\n");
	
	fgets(object,MAX,stdin);
	length_object = strlen(object);
	object[length_object-1]='\0';

	ret_value=sscanf(object,"%s %s",new,new2); /*this function delete the object's spaces */
	
	if(ret_value >1){
		strcpy(object, new);
		strcat(object, " ");	
		strcat(object,new2);
	}
	
	result = rec(NULL, object);
	/* The calculated total price in the recursive 
	function is printed in the main function. */
	printf("Total cost of %s is %.1lf\n", object, result);

	return 0;
}

double rec(char *base, char *current){	
	char parts[MAX],node[MAX][MAX];
	double price,result = 0;
	int num[MAX],i;
	size_t count;
	
	if (base == NULL) {
		printf("Define %s?\n", current);
	} 
	else {
		printf("Define %s in %s\n", current, base);
		
	}
	read_from_user(parts);/* parts requested from user */

	count = seperate(parts, node, num, &price);
	/* calculate how many times the recursive function works */
	if (count == -1)
		return price;
	/* but if user enters only number recursive function return -1 */
	for (i = 0; i < count; i++) {
		result += num[i] * rec(current, node[i]);/* this is total price calculating */
	}

	return result;
}

int seperate(char *parts, char node[][MAX], int *num, double *price){	
	
	int i,j=0;
	int ret_val,digit=0,number;

	for(i=0 ; parts[i] != '\0' ; i++){

		ret_val = sscanf(&parts[i],"%d %s" , &num[j], node[j]);
		/* if the user enters a number and a part name return value is 2 */
		number=num[j];
		digit=count_digits(number);/* this row for sscanf's to work correctly */

		if(ret_val == 2){
			if (node[j][0] == '.'){
				sscanf(&parts[i], "%lf", price);/* if the user enters a double value 
				sscanf workin 2 times but i need to return -1 for the program to work correctly*/
				return -1;
			}
			i+=strlen(node[j])+digit;
			j++;
		} 
		else if (ret_val == 1) {
			*price = num[j];/* if the user enters only integer number */
			return -1;
		} 
	}

	return j;
}

void read_from_user(char *str) {/* this function read function for easy reading of the code  */
	size_t length_parts=0;
	fgets(str,MAX,stdin);
	length_parts = strlen(str);
	str[length_parts-1]='\0';
}

int count_digits(int number){/* this function calculated digit numbers recursively */
    if (number < 10) return 1;
    return (1 + count_digits(number/10));
}

