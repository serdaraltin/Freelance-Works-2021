#include <stdio.h>
#include <stdlib.h>

#define TEST_SIZE 3

int* create_series(int*);
float get_avg(int* series, int size);

int main() {
  int* series_ptr;
  for(int i = 0 ; i < TEST_SIZE ; i++) {
    printf("\n");
    int size;
    series_ptr = create_series(&size);
  
    printf("size = %d\n",size);
    float avg = get_avg(series_ptr,size);  
    printf("Average : %.2f\n\n",avg);
  }
}

int* create_series(int *size) {
  int* nums;

  printf("Enter the size and then the integer numbers\n");
  scanf("%d", size);

  nums =(int*)malloc(sizeof(int)*(*size));
  for(int i = 0 ; i < (*size); i++){
      scanf("%d", &nums[i]);
  }
  
  return nums;
}

float get_avg(int* series, int size) {
  float sum = 0;
  for(int i = 0 ; i < size; i++){
     sum += series[i];
  }

  return sum/size;
} 
