#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

typedef struct {
    char *word;
    char *clue;
    int x;
    int y;
    char direction;
    int f;
} Word_t;
Word_t *loadTextFile(FILE *myFile, int nrWords);
void displayBoard(int row, int cols, char **myBoard);
int isBoardFilled(int row, int cols, char **myBoard);
char **createArray(int row, int cols);
int findIndex(int wArray[], int size, int val);
void playGame(char **myBoard, int word, Word_t *wd, int x, int y, int ctF, int length);
char **updateBoard(char **myBoard, Word_t *wd, int solve);

int main() {
    puts("");
    int col;
    int wd;
    int row;
    
    FILE *filePointer;
    char fName[20];
    
 
    printf("Enter the name of text file: ");
    scanf("%s", fName);
    filePointer = fopen(fName, "r");
    fscanf(filePointer, "%d %d %d\n", &row, &col, &wd);
    printf("Game is %d row x %d cols with %d wd\n", row, col, wd);
    char **bd = (char **) malloc(row * sizeof (char *));
    for (int i = 0; i < col; i++)
        bd[i] = (char *) malloc(col * sizeof (char));
    Word_t *wArray = (Word_t *) malloc(wd * sizeof (Word_t));
    wArray = loadTextFile(filePointer, wd);
    puts("Words and clues are read!");
    printf("Current puzzle:\n");
    bd = createArray(row, col);
    playGame(bd, wd, wArray, row, col, 0, wd);
    return 0;
}


void playGame(char **myBoard, int word, Word_t *wd, int x, int y, int ctF, int length) {
    for (int i = 0; i < word; i++)
        wd[i].f = 0;
    int sec;
    char ans[10];
    for (int i = 0; i < word; i++)
        myBoard = updateBoard(myBoard, wd, i);
    displayBoard(x, y, myBoard);
    puts("# Direction    row col");
    puts("-----------------------");
    while (ctF < word || isBoardFilled(x, y, myBoard) == 0) {
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
            scanf("%d", &sec);
            if (sec == -1) {
                exit(0);
            } else if (sec <= word && sec > 0) {
                if ((*(wd + sec - 1)).f == 1) {
                    puts("That word has been solved before");
                    continue;
                } else
                    break;
            } else {
                puts("invalid number");
                continue;
            }
        }
        printf("Current hint: %s", (*(wd + sec - 1)).clue);
        printf("\nEnter your solution: ");
        scanf("%s", ans);
        for (int i = 0; i < strlen(ans); i++)
            ans[i] = toupper(ans[i]);
        if (strcmp(ans, (*(wd + sec - 1)).word) == 0) {
            printf("\nCorrect!");
            (*(wd + sec - 1)).f = 1;
            ctF++;
            myBoard = updateBoard(myBoard, wd, sec - 1);
            if ((*(wd + sec - 1)).direction == 'H')
                for (int t = 0; t < length; t++) {
                    for (int k = 0; k < strlen((*(wd + sec - 1)).word); k++) {
                        if ((*(wd + sec - 1)).y + k == (*(wd + t)).y && (*(wd + t)).direction == 'V' && ((*(wd + sec - 1)).x >= (*(wd + t)).x) && ((*(wd + sec - 1)).x <= ((*(wd + t)).x + strlen((*(wd + t)).word)))) {
                            int flag = 1;
                            for (int m = 0; m < strlen((*(wd + t)).word); m++)
                                if (myBoard[(*(wd + t)).x + m - 1][(*(wd + t)).y - 1] == '_') {
                                    flag = 0;
                                    break;
                                }
                            if (flag && (*(wd + t)).f == 0) {
                                (*(wd + t)).f = 1;
                                ctF++;
                            }
                        }
                    }
                } else if ((*(wd + sec - 1)).direction == 'V')
                for (int t = 0; t < length; t++) {
                    for (int k = 0; k < strlen((*(wd + sec - 1)).word); k++) {
                        if ((*(wd + sec - 1)).x + k == (*(wd + t)).x && (*(wd + t)).direction == 'H' && ((*(wd + sec - 1)).y >= (*(wd + t)).y) && ((*(wd + sec - 1)).y <= ((*(wd + t)).y + strlen((*(wd + t)).word)))) {
                            int flag = 1;
                            for (int m = 0; m < strlen((*(wd + t)).word); m++)
                                if (myBoard[(*(wd + t)).x - 1][(*(wd + t)).y - 1 + m] == '_') {
                                    flag = 0;
                                    break;
                                }
                            if (flag && (*(wd + t)).f == 0) {
                                (*(wd + t)).f = 1;
                                ctF++;
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

char **createArray(int row, int cols) {
    char **bd = (char **) malloc(row * sizeof (char *));
    for (int i = 0; i < cols; i++)
        bd[i] = (char *) malloc(cols * sizeof (char));
    for (int i = 0; i < row; i++)
        for (int j = 0; j < cols; j++)
            bd[i][j] = '#';
    return bd;
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

int isBoardFilled(int row, int cols, char **myBoard) {
    for (int i = 0; i < row; i++)
        for (int j = 0; j < cols; j++)
            if (myBoard[i][j] == '_')
                return 0;
    return 1;
}

int findIndex(int wArray[], int size, int val) {
    return 0;
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

void displayBoard(int row, int cols, char **myBoard) {
    printf("\n          ");
    for (int i = 0; i < cols; i++)
        printf("%d  ", i + 1);
    printf("\n          ");
    for (int i = 0; i < cols; i++)
        printf("-- ");
    printf("\n");
    for (int i = 0; i < row; i++) {
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
