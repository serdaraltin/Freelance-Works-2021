/*Mustafa Furkan Ergin - 161044025 - CSE102-HW1*/

#include<stdio.h>
#define CLASS 10

int main(){

	int i;
	double coord_x,coord_y,temp1=0,temp2=0,temp3=0,temp4=0;
	double average_x1,average_y1,average_x2,average_y2,conline_slope,sepline_slope,midpoint_x,midpoint_y;
	double testpoint_x,testpoint_y;
	
	/*conline = connecting line   sepline=seperating line*/
	
	for(i=0;i<CLASS;i++){
	
		scanf("%lf %lf",&coord_x,&coord_y);	/*read number of points for class 1*/ 
		
		temp1+=coord_x;
		temp2+=coord_y;
		
	}
	
	average_x1=temp1/CLASS; /*average points calculated for class 1*/ 
	average_y1=temp2/CLASS;
	
	/*printf("For class 1 --> xAverage: %.1lf yAverage: %.1lf \n",average_x1,average_y1);*/
	
	for(i=0;i<CLASS;i++){
	
		scanf("%lf %lf",&coord_x,&coord_y); /*read number of points for class 2*/ 
		
		temp3+=coord_x;
		temp4+=coord_y;
		
	}
	
	average_x2=temp3/CLASS; /*average points calculated for class 2*/ 
	average_y2=temp4/CLASS;

	/*printf("For class 2 --> xAverage: %.1lf yAverage: %.1lf ",average_x2,average_y2);*/
	
	if(average_x2-average_x1==0){
		average_x2+=0.00001;
		conline_slope=(average_y2-average_y1)/(average_x2-average_x1);	
	}
	/*when calculating the slope of the connection line, the probability of divide by zero is canceled*/
	else
		conline_slope=(average_y2-average_y1)/(average_x2-average_x1);
	
	midpoint_x=(average_x1+average_x2)/2;/*midpoint's coordinates calculated*/
	midpoint_y=(average_y1+average_y2)/2;
		
	if(conline_slope==0)
		conline_slope+=0.00001;
	
	/*printf("\nconline_slope: %lf---X:%.1lf--Y:%.1lf",conline_slope,midpoint_x,midpoint_y);*/
	
	sepline_slope=-1/conline_slope;/*seperating line's slope calculated.*/
	
	/*printf("\n\nSeperating line: y-%.1lf=%.1lf(x-%.1lf)",midpoint_y,sepline_slope,midpoint_x);	*/
	
	while(scanf("%lf %lf",&testpoint_x,&testpoint_y)){	/*get test points and exit status set when character is entered*/
	
		if(average_y1>average_y2 || average_x1>average_x2){
			if((testpoint_y-midpoint_y)>(sepline_slope*(testpoint_x-midpoint_x))){
				printf("class 1\n");
			}
			else if((testpoint_y-midpoint_y)<(sepline_slope*(testpoint_x-midpoint_x))){
				printf("class 2\n");
			}
		}
	/*according to the equation of the separating line, which test point belongs to which class.*/
		if(average_y2>average_y1 || average_x2>average_x1){
			if((testpoint_y-midpoint_y)<(sepline_slope*(testpoint_x-midpoint_x))){
				printf("class 1\n");
			}
			else if((testpoint_y-midpoint_y)>(sepline_slope*(testpoint_x-midpoint_x))){
				printf("class 2\n");
			}
		}
		
	}

	return 0;	
}
