#include <stdio.h>
#include <stdlib.h>

#define SIZE 16
// prototype
void insertion_sort(int *sorted_array, int size);

int main() {
  int array_to_be_sorted[SIZE] = {3,  5,  8, 2, 1, 6,  4,  7, 12, 10, 9, 1, 5, 11, 14, 13};
  insertion_sort(array_to_be_sorted, SIZE);

  int i;
  for (i = 0; i < SIZE; i++) {
    printf("%d-", array_to_be_sorted[i]);
  }

  return 0;
}

void insertion_sort(int *sorted_array, int size) {
  int counter = 1;
  int temp, i;

  int pivot = sorted_array[1];
  while (counter < size) {

    for (i = counter - 1; i >= 0; i--) {
      if (pivot < sorted_array[i]) {
        temp = sorted_array[i];
        sorted_array[i] = sorted_array[i + 1];
        sorted_array[i + 1] = temp;
      }
    }
    counter++;
    pivot = sorted_array[counter];
  }
}