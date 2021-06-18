#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define LINE_LEN 100
#define LEN 15

#define DEBUG_FOR(l, s) \
	for (int i = 0; i < s; ++i) \
		printf("%d, ", l[i]); \
	printf("\n");

#define DEBUG_NODE(n) \
	printf("name: %s, type: %s, output: %d, order: %d\n", \
		   n->name, n->type, n->output, n->order);

typedef struct gate_s {
	char name[LEN];
	char type[LEN];
	int output;
	int order;
	struct gate_s * left;
	struct gate_s * right;
} gate_t;

char ** read_file_reverse(FILE * doc, int * size, int index);
char ** separate_one_line(char * data, int * s);
void delete_data(char ** data, int size);
gate_t * create_binary_tree(gate_t * root, char ** circuit, char ** input, 
							int size, int index, int inp_len);
void calculate(gate_t * root, int * input);
void free_tree(gate_t * root);

int main()
{
	FILE * doc = fopen("circuit.txt", "r");
	FILE * doc2 = fopen("input.txt", "r");
	FILE * doc3 = fopen("output.txt", "w");
	int size = 0, i, s = 0, count;
	char ** circuit = read_file_reverse(doc, &size, 0);
	char ** inp_key = separate_one_line(circuit[size-1], &s);
	char tmp[LINE_LEN]; /* You can alter this with dynamic array using s */
	int * input_line = (int *) malloc(sizeof(int) * (s - 1));
	gate_t * gate_tree = NULL;

	gate_tree = create_binary_tree(gate_tree, circuit, inp_key, size, 0, s); 

	while (fgets(tmp, 1024, doc2) != NULL) {
		if (tmp[0] != '\n') {
			count = 0;
			tmp[strlen(tmp)-1] = '\0';
			for (i = 0; i < s-1; ++i) {
				sscanf(&tmp[count], "%d", &input_line[i]);
				count += 2;
			} 
			calculate(gate_tree, input_line);	
			fprintf(doc3, "%d\n", gate_tree->output);
		}
	}

	delete_data(inp_key, s);
	delete_data(circuit, size);
	free_tree(gate_tree);
	free(input_line);
	fclose(doc);
	fclose(doc2);
	fclose(doc3);

	return 0;
}

char ** read_file_reverse(FILE * doc, int * size, int index)
{
	char line[LINE_LEN];
	char * ret_val = fgets(line, LINE_LEN, doc);
	char ** circuit = NULL;

	if (ret_val == NULL) {
		circuit = (char **) malloc(sizeof(char *) * (*size));
		return circuit;
	} else {
		++*size;
		circuit = read_file_reverse(doc, size, index + 1);
		circuit[*size-index-1] = (char *) malloc(sizeof(char) * LINE_LEN);
		line[strlen(line)-1] = '\0';
		strcpy(circuit[*size-index-1], line);
	}
	return circuit;
}

char ** separate_one_line(char * data, int * s)
{
	int part_size = 4, i, current = 0;
	char ** line;
	if (data[0] == 'N' || data[0] == 'F') {
		part_size = 3;
	} else if (data[0] == 'I') {
		part_size = 1;
		for (i = 0; i < strlen(data); ++i)	
			if (data[i] == ' ')
				part_size += 1;
	}
	line = (char **) malloc(sizeof(char *) * part_size);
	for (i = 0; i < part_size; ++i) {
		line[i] = (char *) malloc(sizeof(char) * LEN);
		sscanf(&data[current], "%s", line[i]);
		current += strlen(line[i]) + 1;
	}
	*s = part_size;

	return line;
}

void delete_data(char ** data, int size)
{
	int i;
	for (i = 0; i < size; ++i)
		free(data[i]);
	free(data);
}

gate_t * create_binary_tree(gate_t * root, char ** circuit, char ** input, 
							int size, int index, int inp_len)
{
	char ** line = NULL;
	char ** tmp = NULL;
	int i, root_len, inp_index = -1;
	int tmp_len;

	if (index == size - 1) {
		return root;
	} else {
		root = (gate_t *) malloc(sizeof(gate_t));
		line = separate_one_line(circuit[index], &root_len);
		strcpy(root->type, line[0]);
		strcpy(root->name, line[1]);
		root->order = -1;
		root->output = 0;
		root->left = NULL;
		root->right = NULL;

		for (i = 1; i < inp_len; ++i) {
			if (strcmp(input[i], line[2]) == 0) {
				inp_index = i;
				break;
			}
		}

		if (inp_index != -1) {
			root->left = (gate_t *) malloc(sizeof(gate_t));
			strcpy(root->left->type, input[0]);
			strcpy(root->left->name, input[inp_index]);
			root->left->order = inp_index-1;
			root->left->output = 0;
		} else {
			for (i = index; i < size-1; ++i) {
				tmp = separate_one_line(circuit[i], &tmp_len);
				if (strcmp(tmp[1], line[2]) == 0) {
					inp_index = i;
					delete_data(tmp, tmp_len);
					break;
				}
				delete_data(tmp, tmp_len);	
			}
			root->left = create_binary_tree(root->left, circuit, input, 
											size, inp_index, inp_len);
		}

		inp_index = -1;
		if (line[0][0] != 'F' && line[0][0] != 'N') {
			for (i = 1; i < inp_len; ++i) {
				if (strcmp(input[i], line[3]) == 0) {
					inp_index = i;
					break;
				}
			}
		}

		if (inp_index > -1) {
			root->right = (gate_t *) malloc(sizeof(gate_t));
			strcpy(root->right->type, input[0]);
			strcpy(root->right->name, input[inp_index]);
			root->right->order = inp_index-1;
			root->right->output = 0;
		} else {
			if (line[0][0] != 'F' && line[0][0] != 'N') {
				for (i = index; i < size - 1; ++i) {
					tmp = separate_one_line(circuit[i], &tmp_len);
					if (strcmp(tmp[1], line[3]) == 0) {
						inp_index = i;
						delete_data(tmp, tmp_len);
						break;
					}
					delete_data(tmp, tmp_len);
				}
				root->right = create_binary_tree(root->right, circuit, input, 
										 	 	 size, inp_index, inp_len);
			} else {
				root->right = NULL;
			}
		}
			printf("name: %s, type: %s, output: %d, order: %d\n", root->name, root->type, root->output, root->order);

		delete_data(line, root_len);
	}
	return root;
}

void free_tree(gate_t * root)
{
	if (root == NULL)
		return;
	free_tree(root->left);
	free_tree(root->right);
	free(root);
}

void calculate(gate_t * root, int * input)
{
	if (root == NULL) {
		return;
	} else if (root->left == NULL && root->right == NULL) {
		root->output = input[root->order]; 
		return;
	} else {
		calculate(root->left, input);
		calculate(root->right, input);
		if (strcmp(root->type, "OR") == 0) {
			root->output = root->left->output | root->right->output;
		} else if (strcmp(root->type, "AND") == 0) {
			root->output = root->left->output & root->right->output;
		} else if (strcmp(root->type, "NOT") == 0) {
			if (root->left->output == 0)
				root->output = 1;
			else
				root->output = 0;
		} else if (strcmp(root->type, "FLIPFLOP") == 0) {
			root->output = root->output ^ root->left->output;
		}
	}
}
