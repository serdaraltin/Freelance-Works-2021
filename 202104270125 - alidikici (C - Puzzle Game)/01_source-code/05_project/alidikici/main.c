#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

typedef struct
{
    char *word;
    char *clue;
    int x;
    int y;
    char direction;
    int f;
} Word_t;
Word_t *loadTextFile(FILE *myFile, int nrWords);
void displayBoard(int rows, int cols, char **myBoard);
int isBoardFilled(int rows, int cols, char **myBoard);
char **createArray(int rows, int cols);
int findIndex(int array[], int size, int val);
void playGame(char **myBoard, int word, Word_t *words, int x, int y, int countToFinish, int length);
char **updateBoard(char **myBoard, Word_t *words, int solve);

int main()
{
    puts("");

    FILE *fp;
    int rows;
    int columns;
    int words;

    char fileName[20];
    printf("Enter the name of text file: ");
    scanf("%s", fileName);
    fp = fopen(fileName, "r");

    fscanf(fp, "%d %d %d\n", &rows, &columns, &words);

    printf("Game is %d rows x %d cols with %d words\n", rows, columns, words);

    char **mboard = (char **)malloc(rows * sizeof(char *));

    for (int i = 0; i < columns; i++)
        mboard[i] = (char *)malloc(columns * sizeof(char));

    Word_t *array = (Word_t *)malloc(words * sizeof(Word_t));

    array = loadTextFile(fp, words);
    puts("Words and clues are read!");
    printf("Current puzzle:\n");

    mboard = createArray(rows, columns);

    playGame(mboard, words, array, rows, columns, 0, words);

    return 0;
}

Word_t *loadTextFile(FILE *myFile, int nrWords)
{

    char line[150];

    Word_t *arrayay = (Word_t *)malloc(nrWords * sizeof(Word_t));

    for (int i = 0; i < nrWords; i++)
    {
        (*(arrayay + i)).word = (char *)malloc(256 * sizeof(char));
        (*(arrayay + i)).clue = (char *)malloc(256 * sizeof(char));
        fscanf(myFile, "%c %d %d %s %[^\n]\n", &(*(arrayay + i)).direction, &(*(arrayay + i)).x, &(*(arrayay + i)).y, (*(arrayay + i)).word, (*(arrayay + i)).clue);
    }
    return arrayay;
}

char **createArray(int rows, int cols)
{
    char **mboard = (char **)malloc(rows * sizeof(char *));
    for (int i = 0; i < cols; i++)
        mboard[i] = (char *)malloc(cols * sizeof(char));
    for (int i = 0; i < rows; i++)
        for (int j = 0; j < cols; j++)
            mboard[i][j] = '#';
    return mboard;
}

void displayBoard(int rows, int cols, char **myBoard)
{
    printf("\n          ");
    for (int i = 0; i < cols; i++)
        printf("%d  ", i + 1);
    printf("\n          ");
    for (int i = 0; i < cols; i++)
        printf("-- ");
    printf("\n");
    for (int i = 0; i < rows; i++)
    {
        printf("%d       | ", i + 1);
        for (int j = 0; j < cols; j++)
            printf("%c  ", myBoard[i][j]);
        printf("\n");
    }
    printf("        ");
    for (int i = 0; i < cols; i++)
        printf("***");
    printf("\n");
}

int isBoardFilled(int rows, int cols, char **myBoard)
{
    for (int i = 0; i < rows; i++)
        for (int j = 0; j < cols; j++)
            if (myBoard[i][j] == '_')
                return 0;
    return 1;
}

int findIndex(int array[], int size, int val)
{
    return 0;
}

char **updateBoard(char **myBoard, Word_t *words, int solve)
{
    int length;
    int x;
    int y;
    int direction;
    direction = (*(words + solve)).direction;
    x = (*(words + solve)).x;
    y = (*(words + solve)).y;
    length = strlen((*(words + solve)).word);
    if (words[solve].f == 0)
    {
        if ((*(words + solve)).direction == 'H')
            for (int i = 0; i < strlen((*(words + solve)).word); i++)
                myBoard[(*(words + solve)).x - 1][((*(words + solve)).y) + i - 1] = '_';
        else if ((*(words + solve)).direction == 'V')
            for (int i = 0; i < strlen((*(words + solve)).word); i++)
                myBoard[((*(words + solve)).x) + i - 1][(*(words + solve)).y - 1] = '_';
    }
    else
    {
        if (direction == 'H')
            for (int i = 0; i < length; i++)
                myBoard[x - 1][y + i - 1] = (*(words + solve)).word[i];

        else if (direction == 'V')
            for (int i = 0; i < length; i++)
                myBoard[x + i - 1][y - 1] = (*(words + solve)).word[i];
    }

    return myBoard;
}
void playGame(char **myBoard, int word, Word_t *words, int x, int y, int countToFinish, int length)
{
    for (int i = 0; i < word; i++)
        words[i].f = 0;
    int select;
    char answer[10];
    for (int i = 0; i < word; i++)
        myBoard = updateBoard(myBoard, words, i);
    displayBoard(x, y, myBoard);
    puts("# Direction    row col");
    puts("-----------------------");
    while (countToFinish < word || isBoardFilled(x, y, myBoard) == 0)
    {
        for (int n = 0; n < word; n++)
        {
            if ((*(words + n)).direction == 'H')
            {
                if ((*(words + n)).f == 0)
                    printf("%d: Horizontal   %d    %d\n", n + 1, (*(words + n)).x, (*(words + n)).y);
            }
            else if ((*(words + n)).direction == 'V')
            {

                if ((*(words + n)).f == 0)
                    printf("%d: Vertical     %d    %d\n", n + 1, (*(words + n)).x, (*(words + n)).y);
            }
        }
        for (;;)
        {
            puts("Enter -1 to exit");
            printf("Which word to solve next?: ");
            scanf("%d", &select);
            if (select == -1)
            {
                exit(0);
            }
            else if (select <= word && select > 0)
            {

                if ((*(words + select - 1)).f == 1)
                {
                    puts("That word has been solved before");
                    continue;
                }
                else
                    break;
            }
            else
            {
                puts("invalid number");
                continue;
            }
        }
        printf("Current hint: %s", (*(words + select - 1)).clue);
        printf("\nEnter your solution: ");
        scanf("%s", answer);
        for (int i = 0; i < strlen(answer); i++)
            answer[i] = toupper(answer[i]);
        if (strcmp(answer, (*(words + select - 1)).word) == 0)
        {
            printf("\nCorrect!");
            (*(words + select - 1)).f = 1;
            countToFinish++;
            myBoard = updateBoard(myBoard, words, select - 1);
            if ((*(words + select - 1)).direction == 'H')
                for (int t = 0; t < length; t++)
                {
                    for (int k = 0; k < strlen((*(words + select - 1)).word); k++)
                    {
                        if ((*(words + select - 1)).y + k == (*(words + t)).y && (*(words + t)).direction == 'V' && ((*(words + select - 1)).x >= (*(words + t)).x) && ((*(words + select - 1)).x <= ((*(words + t)).x + strlen((*(words + t)).word))))
                        {
                            int flag = 1;
                            for (int m = 0; m < strlen((*(words + t)).word); m++)
                                if (myBoard[(*(words + t)).x + m - 1][(*(words + t)).y - 1] == '_')
                                {
                                    flag = 0;
                                    break;
                                }

                            if (flag && (*(words + t)).f == 0)
                            {
                                (*(words + t)).f = 1;
                                countToFinish++;
                            }
                        }
                    }
                }
            else if ((*(words + select - 1)).direction == 'V')
                for (int t = 0; t < length; t++)
                {
                    for (int k = 0; k < strlen((*(words + select - 1)).word); k++)
                    {
                        if ((*(words + select - 1)).x + k == (*(words + t)).x && (*(words + t)).direction == 'H' && ((*(words + select - 1)).y >= (*(words + t)).y) && ((*(words + select - 1)).y <= ((*(words + t)).y + strlen((*(words + t)).word))))
                        {

                            int flag = 1;
                            for (int m = 0; m < strlen((*(words + t)).word); m++)
                                if (myBoard[(*(words + t)).x - 1][(*(words + t)).y - 1 + m] == '_')
                                {
                                    flag = 0;
                                    break;
                                }

                            if (flag && (*(words + t)).f == 0)
                            {
                                (*(words + t)).f = 1;
                                countToFinish++;
                            }
                        }
                    }
                }
            displayBoard(x, y, myBoard);
        }
        else
        {
            printf("\nWRONG ANSWER");

            displayBoard(x, y, myBoard);
        }
    }
    printf("Congratulations! You beat the puzzle!");
}
