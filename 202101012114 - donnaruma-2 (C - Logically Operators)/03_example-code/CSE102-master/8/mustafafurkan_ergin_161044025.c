/* Mustafa Furkan Ergin - 161044025 - HW8 */

#include <stdio.h>
#include <sys/resource.h>

#define NUM 512 /* matrix size */

int island_determine(int M[][NUM], FILE * doc2);
int count_islands(int M[][NUM], FILE * doc2, int i, int j, int count);
void determine_island(int M[][NUM], int SIZE, int row, int column);

int main(){

	FILE * doc = fopen("input.txt","r");
	FILE * doc2 = fopen("output.txt","w");
	int M[NUM][NUM];
	int i, j, water_level, count=0;
/***********************************************************************************/
	const rlim_t kStackSize = 16 * 1024 * 1024; // min stack size = 16 MB
	struct rlimit rl;
	int result;

	result = getrlimit(RLIMIT_STACK, &rl);
	if (result == 0){
		if (rl.rlim_cur < kStackSize){
			rl.rlim_cur = kStackSize;
			result = setrlimit(RLIMIT_STACK, &rl);
			
			if (result != 0){
				fprintf(stderr, "setrlimit returned result = %d\n", result);
			}
		}
	}
/************************************************************************************/
	fscanf(doc, "%d", &water_level);

	for (i = 0; i < NUM; ++i) {
		for (j = 0; j < NUM; ++j){
			fscanf(doc, "%d", &M[i][j]);

			if(M[i][j] <= water_level)
				M[i][j] = 0;
			else
				M[i][j] = 1;

		}
	}

	count_islands(M, doc2, 0, 0, 0);

	fclose(doc); 
	fclose(doc2);

	return 0;
}

/* this function count the islands and prints counts of islands and their coordinates */
int count_islands(int M[][NUM], FILE * doc2, int i, int j, int count) {
	if (i == NUM - 1 && j == NUM - 1) {
		if (count == 0)
			fprintf(doc2, "%d", count);
		else
			fprintf(doc2, "%d\n", count);
	} else if (j == NUM - 1) {
		count += count_islands(M, doc2, i + 1, 0, count);
	} else if (M[i][j] == 1) {
		determine_island(M, NUM, i, j);
		count += count_islands(M, doc2, i, j + 1, count + 1);
		if (count == 0)
			fprintf(doc2,"%d %d", j, i);
		else
			fprintf(doc2,"%d %d\n", j, i);
	} else {
		count = count_islands(M, doc2, i, j + 1, count);
	}
	return 0;
}

/* this function determine the islands' coordinates recursively */
void determine_island(int M[][NUM], int SIZE, int row, int column){

	M[row][column] = 0;

	if(row - 1 >= 0 && M[row - 1][column] == 1)
		determine_island(M, SIZE, row - 1, column);
	
	if(row + 1 < SIZE && M[row + 1][column] == 1)
		determine_island(M, SIZE, row + 1, column);
	
	if(column - 1 >= 0 && M[row][column -1 ] == 1)
		determine_island(M, SIZE, row, column - 1);
	
	if(column + 1 < SIZE && M[row][column + 1] == 1)
		determine_island(M, SIZE, row, column + 1);

}
