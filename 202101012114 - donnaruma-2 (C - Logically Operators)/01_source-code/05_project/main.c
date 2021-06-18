#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct gate_s
{
	char name[15];
	char type[15];
	int output;
	int order;
	struct gate_s *left;
	struct gate_s *right;
} gate;

char **readFileReverse(FILE *file_circuit, int *size_value, int index_no)
{
	char line[100];
	char *ret_val = fgets(line, 100, file_circuit);
	char **circuit = NULL;

	if (ret_val == NULL)
	{
		circuit = (char **)malloc(sizeof(char *) * (*size_value));
		return circuit;
	}
	else
	{
		++*size_value;
		circuit = readFileReverse(file_circuit, size_value, index_no + 1);
		circuit[*size_value - index_no - 1] = (char *)malloc(sizeof(char) * 100);
		line[strlen(line) - 1] = '\0';
		strcpy(circuit[*size_value - index_no - 1], line);
	}
	return circuit;
}

char **separeteOneLine(char *data, int *s)
{
	int partion_size = 4, i, current = 0;
	char **line;
	if (data[0] == 'N' || data[0] == 'F')
	{
		partion_size = 3;
	}
	else if (data[0] == 'I')
	{
		partion_size = 1;
		for (i = 0; i < strlen(data); ++i)
			if (data[i] == ' ')
				partion_size += 1;
	}
	line = (char **)malloc(sizeof(char *) * partion_size);
	for (i = 0; i < partion_size; ++i)
	{
		line[i] = (char *)malloc(sizeof(char) * 15);
		sscanf(&data[current], "%s", line[i]);
		current += strlen(line[i]) + 1;
	}
	*s = partion_size;

	return line;
}

void deleteData(char **data, int size_value)
{
	int i;
	for (i = 0; i < size_value; ++i)
		free(data[i]);
	free(data);
}

gate *createBinaryTree(gate *root, char **circuit, char **input,
					   int size_value, int index_no, int inp_len)
{
	char **line = NULL;
	char **tmp = NULL;
	int i, root_lenght, input_index = -1;
	int temp_lenght;

	if (index_no == size_value - 1)
	{
		return root;
	}
	else
	{
		root = (gate *)malloc(sizeof(gate));
		line = separeteOneLine(circuit[index_no], &root_lenght);
		strcpy(root->type, line[0]);
		strcpy(root->name, line[1]);
		root->order = -1;
		root->output = 0;
		root->left = NULL;
		root->right = NULL;

		for (i = 1; i < inp_len; ++i)
		{
			if (strcmp(input[i], line[2]) == 0)
			{
				input_index = i;
				break;
			}
		}

		if (input_index != -1)
		{
			root->left = (gate *)malloc(sizeof(gate));
			strcpy(root->left->type, input[0]);
			strcpy(root->left->name, input[input_index]);
			root->left->order = input_index - 1;
			root->left->output = 0;
		}
		else
		{
			for (i = index_no; i < size_value - 1; ++i)
			{
				tmp = separeteOneLine(circuit[i], &temp_lenght);
				if (strcmp(tmp[1], line[2]) == 0)
				{
					input_index = i;
					deleteData(tmp, temp_lenght);
					break;
				}
				deleteData(tmp, temp_lenght);
			}
			root->left = createBinaryTree(root->left, circuit, input,
										  size_value, input_index, inp_len);
		}

		input_index = -1;
		if (line[0][0] != 'F' && line[0][0] != 'N')
		{
			for (i = 1; i < inp_len; ++i)
			{
				if (strcmp(input[i], line[3]) == 0)
				{
					input_index = i;
					break;
				}
			}
		}

		if (input_index > -1)
		{
			root->right = (gate *)malloc(sizeof(gate));
			strcpy(root->right->type, input[0]);
			strcpy(root->right->name, input[input_index]);
			root->right->order = input_index - 1;
			root->right->output = 0;
		}
		else
		{
			if (line[0][0] != 'F' && line[0][0] != 'N')
			{
				for (i = index_no; i < size_value - 1; ++i)
				{
					tmp = separeteOneLine(circuit[i], &temp_lenght);
					if (strcmp(tmp[1], line[3]) == 0)
					{
						input_index = i;
						deleteData(tmp, temp_lenght);
						break;
					}
					deleteData(tmp, temp_lenght);
				}
				root->right = createBinaryTree(root->right, circuit, input,
											   size_value, input_index, inp_len);
			}
			else
			{
				root->right = NULL;
			}
		}
		printf("%s\t%10s\t%2d\t%2d\n", root->name, root->type, root->output, root->order);

		deleteData(line, root_lenght);
	}
	return root;
}

void freeTree(gate *root)
{
	if (root == NULL)
		return;
	freeTree(root->left);
	freeTree(root->right);
	free(root);
}

void calc(gate *root, int *input)
{
	if (root == NULL)
	{
		return;
	}
	else if (root->left == NULL && root->right == NULL)
	{
		root->output = input[root->order];
		return;
	}
	else
	{
		calc(root->left, input);
		calc(root->right, input);
		if (strcmp(root->type, "OR") == 0)
		{
			root->output = root->left->output | root->right->output;
		}
		else if (strcmp(root->type, "AND") == 0)
		{
			root->output = root->left->output & root->right->output;
		}
		else if (strcmp(root->type, "NOT") == 0)
		{
			if (root->left->output == 0)
				root->output = 1;
			else
				root->output = 0;
		}
		else if (strcmp(root->type, "FLIPFLOP") == 0)
		{
			root->output = root->output ^ root->left->output;
		}
	}
}

int main()
{
	FILE *file_circuit = fopen("circuit.txt", "r");
	FILE *file_input = fopen("input.txt", "r");
	FILE *file_output = fopen("output.txt", "w");
	int size_value = 0, i, s = 0, count;
	char **circuit = readFileReverse(file_circuit, &size_value, 0);
	char **inp_key = separeteOneLine(circuit[size_value - 1], &s);
	char tmp[100];
	int *input_line = (int *)malloc(sizeof(int) * (s - 1));
	gate *gate_tree = NULL;

	printf("NAME\t%9s%11s%8s\n", "TYPE", "OUTPUT", "ORDER");
	printf("------------------------------------\n");
	gate_tree = createBinaryTree(gate_tree, circuit, inp_key, size_value, 0, s);
	printf("------------------------------------\n");
	printf("NAME\t%9s%11s%8s\n", "TYPE", "OUTPUT", "ORDER");

	while (fgets(tmp, 1024, file_input) != NULL)
	{
		if (tmp[0] != '\n')
		{
			count = 0;
			tmp[strlen(tmp) - 1] = '\0';
			for (i = 0; i < s - 1; ++i)
			{
				sscanf(&tmp[count], "%d", &input_line[i]);
				count += 2;
			}
			calc(gate_tree, input_line);
			fprintf(file_output, "%d\n", gate_tree->output);
		}
	}

	deleteData(inp_key, s);
	deleteData(circuit, size_value);
	freeTree(gate_tree);
	free(input_line);
	fclose(file_circuit);
	fclose(file_input);
	fclose(file_output);

	return 0;
}
