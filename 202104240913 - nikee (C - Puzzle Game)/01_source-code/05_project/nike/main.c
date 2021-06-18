#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

typedef struct {
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
int findIndex(int wArray[], int size, int val);
void playGame(char **myBoard, int word, Word_t *wd, int x, int y, int ctf, int length);
char **updateBoard(char **myBoard, Word_t *wd, int solve);

int main() {
    puts("");
    int column;
    int wd;
    int rows;

    FILE *fPointer;
    char fName[20];


    printf("Enter the name of text file: ");
    scanf("%s", fName);
    fPointer = fopen(fName, "r");
    fscanf(fPointer, "%d %d %d\n", &rows, &column, &wd);
    printf("Game is %d rows x %d cols with %d wd\n", rows, column, wd);
    char **bPointer = (char **) malloc(rows * sizeof (char *));
    for (int i = 0; i < column; i++)
        bPointer[i] = (char *) malloc(column * sizeof (char));
    Word_t *wArray = (Word_t *) malloc(wd * sizeof (Word_t));
    wArray = loadTextFile(fPointer, wd);
    puts("Words and clues are read!");
    printf("Current puzzle:\n");
    bPointer = createArray(rows, column);
    playGame(bPointer, wd, wArray, rows, column, 0, wd);
    return 0;
}


int isBoardFilled(int rows, int cols, char **myBoard) {
    for (int i = 0; i < rows; i++)
        for (int j = 0; j < cols; j++)
            if (myBoard[i][j] == '_')
                return 0;
    return 1;
}

char **createArray(int rows, int cols) {
    char **bPointer = (char **) malloc(rows * sizeof (char *));
    for (int i = 0; i < cols; i++)
        bPointer[i] = (char *) malloc(cols * sizeof (char));
    for (int i = 0; i < rows; i++)
        for (int j = 0; j < cols; j++)
            bPointer[i][j] = '#';
    return bPointer;
}


int findIndex(int wArray[], int size, int val) {
    return 0;
}


void displayBoard(int rows, int cols, char **myBoard) {
    printf("\n          ");
    for (int i = 0; i < cols; i++)
        printf("%d  ", i + 1);
    printf("\n          ");
    for (int i = 0; i < cols; i++)
        printf("-- ");
    printf("\n");
    for (int i = 0; i < rows; i++) {
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



Word_t *loadTextFile(FILE *myFile, int nrWords) {

    Word_t *wArrayay = (Word_t *) malloc(nrWords * sizeof (Word_t));
    for (int i = 0; i < nrWords; i++) {
        (*(wArrayay + i)).word = (char *) malloc(256 * sizeof (char));
        (*(wArrayay + i)).clue = (char *) malloc(256 * sizeof (char));
        fscanf(myFile, "%c %d %d %s %[^\n]\n", &(*(wArrayay + i)).direction, &(*(wArrayay + i)).x, &(*(wArrayay + i)).y, (*(wArrayay + i)).word, (*(wArrayay + i)).clue);
    }
    return wArrayay;
}


char **updateBoard(char **myBoard, Word_t *wd, int solve) {
    int length;
    int x;
    int y;
    int direction;
    direction = (*(wd + solve)).direction;
    x = (*(wd + solve)).x;
    y = (*(wd + solve)).y;
    length = strlen((*(wd + solve)).word);
    if (wd[solve].f == 0) {
        if ((*(wd + solve)).direction == 'H')
            for (int i = 0; i < strlen((*(wd + solve)).word); i++)
                myBoard[(*(wd + solve)).x - 1][((*(wd + solve)).y) + i - 1] = '_';
        else if ((*(wd + solve)).direction == 'V')
            for (int i = 0; i < strlen((*(wd + solve)).word); i++)
                myBoard[((*(wd + solve)).x) + i - 1][(*(wd + solve)).y - 1] = '_';
    } else {
        if (direction == 'H')
            for (int i = 0; i < length; i++)
                myBoard[x - 1][y + i - 1] = (*(wd + solve)).word[i];
        else if (direction == 'V')
            for (int i = 0; i < length; i++)
                myBoard[x + i - 1][y - 1] = (*(wd + solve)).word[i];
    }
    return myBoard;
}



void playGame(char **myBoard, int word, Word_t *wd, int x, int y, int ctf, int length) {
    for (int i = 0; i < word; i++)
        wd[i].f = 0;
    int slect;
    char ans[10];
    for (int i = 0; i < word; i++)
        myBoard = updateBoard(myBoard, wd, i);
    displayBoard(x, y, myBoard);
    puts("# Direction    rows column");
    puts("-----------------------");
    while (ctf < word || isBoardFilled(x, y, myBoard) == 0) {
        for (int n = 0; n < word; n++) {
            if ((*(wd + n)).direction == 'H') {
                if ((*(wd + n)).f == 0)
                    printf("%d: Horizontal   %d    %d\n", n + 1, (*(wd + n)).x, (*(wd + n)).y);
            } else if ((*(wd + n)).direction == 'V') {
                if ((*(wd + n)).f == 0)
                    printf("%d: Vertical     %d    %d\n", n + 1, (*(wd + n)).x, (*(wd + n)).y);
            }
        }
        for (;;) {
            puts("Enter -1 to exit");
            printf("Which word to solve next?: ");
            scanf("%d", &slect);
            if (slect == -1) {
                exit(0);
            } else if (slect <= word && slect > 0) {
                if ((*(wd + slect - 1)).f == 1) {
                    puts("That word has been solved before");
                    continue;
                } else
                    break;
            } else {
                puts("invalid number");
                continue;
            }
        }
        printf("Current hint: %s", (*(wd + slect - 1)).clue);
        printf("\nEnter your solution: ");
        scanf("%s", ans);
        for (int i = 0; i < strlen(ans); i++)
            ans[i] = toupper(ans[i]);
        if (strcmp(ans, (*(wd + slect - 1)).word) == 0) {
            printf("\nCorrect!");
            (*(wd + slect - 1)).f = 1;
            ctf++;
            myBoard = updateBoard(myBoard, wd, slect - 1);
            if ((*(wd + slect - 1)).direction == 'H')
                for (int t = 0; t < length; t++) {
                    for (int k = 0; k < strlen((*(wd + slect - 1)).word); k++) {
                        if ((*(wd + slect - 1)).y + k == (*(wd + t)).y && (*(wd + t)).direction == 'V' && ((*(wd + slect - 1)).x >= (*(wd + t)).x) && ((*(wd + slect - 1)).x <= ((*(wd + t)).x + strlen((*(wd + t)).word)))) {
                            int check = 1;
                            for (int m = 0; m < strlen((*(wd + t)).word); m++)
                                if (myBoard[(*(wd + t)).x + m - 1][(*(wd + t)).y - 1] == '_') {
                                    check = 0;
                                    break;
                                }
                            if (check && (*(wd + t)).f == 0) {
                                (*(wd + t)).f = 1;
                                ctf++;
                            }
                        }
                    }
                } else if ((*(wd + slect - 1)).direction == 'V')
                for (int t = 0; t < length; t++) {
                    for (int k = 0; k < strlen((*(wd + slect - 1)).word); k++) {
                        if ((*(wd + slect - 1)).x + k == (*(wd + t)).x && (*(wd + t)).direction == 'H' && ((*(wd + slect - 1)).y >= (*(wd + t)).y) && ((*(wd + slect - 1)).y <= ((*(wd + t)).y + strlen((*(wd + t)).word)))) {
                            int check = 1;
                            for (int m = 0; m < strlen((*(wd + t)).word); m++)
                                if (myBoard[(*(wd + t)).x - 1][(*(wd + t)).y - 1 + m] == '_') {
                                    check = 0;
                                    break;
                                }
                            if (check && (*(wd + t)).f == 0) {
                                (*(wd + t)).f = 1;
                                ctf++;
                            }
                        }
                    }
                }
            displayBoard(x, y, myBoard);
        } else {
            printf("\nWRONG ANSWER");
            displayBoard(x, y, myBoard);
        }
    }
    printf("Congratulations! You beat the puzzle!");
}