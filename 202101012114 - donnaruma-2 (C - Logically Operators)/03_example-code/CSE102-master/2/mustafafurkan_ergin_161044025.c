/*Sorry Mr.Kaya, I am a stupid so i can't create the algorithm. */

#include<stdio.h>

#define P1 0.5
#define P2 20

void read();
void chunk(double *arr,int count);

int main(){
	
	read();

}

void read(){

	FILE *doc;
	int i=0,count=0;
	double arr[1000]; 
	
	doc=fopen("input.txt","r");	

	while(fscanf(doc,"%lf",&arr[i]) != EOF){
		i++;
		count++;
	}
	
	fclose(doc);
	
	chunk(&arr[0],count);
	
	
}


void chunk(double *arr,int count){
	
	int i=0,j=1,count2=0;
	double a,b,n,sum1,sum2,chunk[100][1000];
	
	
	a=arr[0];
	b=(arr[0]+arr[1])/2;
	n=a;
	while(count>0){

		printf("%lf	%lf	%lf\n",a,n,b);
		
		if(!(b > a*(1+P1) || b < a*(1-P1) || a > n*P2 || a < n/P2)==1){
			j++;
			n=arr[j];
			sum1=chunk[i][j]+n;
			a=sum1/(j+1);
			b=(sum1+chunk[i][j+1])/(j+2);		
		}
		else{	
			i++;

			printf("\n");
		//a=chunk[i][j];			
		}
				
		count--;
	}
	
	for(i=0;i<4;i++){
		for(j=0;j<10;j++){
			printf("\n%lf---chunk[%d][%d]",chunk[i][j],i,j);
		}
		
	}
		
	
}
