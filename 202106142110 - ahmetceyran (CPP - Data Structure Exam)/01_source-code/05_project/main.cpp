#include <cstdio>
#include <cstdlib>
#include <fstream>
#include <iostream>
#include <string.h>
#include <string>

using namespace std;

int arama = 0;

struct node {
  int studenNo;
  char name[30];
  char lastname[30];

  struct node *left;
  struct node *right;
};

struct node *root1 = NULL;
struct node *root2 = NULL;
struct node *root3 = NULL;

void Menu();
void Search();
void List();
void fileWrite();
void removeNode();
void printNode(struct node *node);
struct node *nodeNew(int studenNo, char name[], char lastname[]);
struct node *nodeAdd(struct node *root, int studenNo, char name[],
                     char lastname[]);
struct node *nodeMin(struct node *root);
struct node *nodeDelete(struct node *root, int studenNo);
void printInorder(struct node *root);
void printPreorder(struct node *root);
void printPostorder(struct node *root);
void agacKur(struct node **root, string file);
void dosyayaYaz(struct node *root, char fileName[]);
void ilkDerinlikAra(struct node *root, int studenNo);
void ilkGenislikAra(struct node *root, int studenNo);

void Menu() {
  cout << "Asagidaki islemlerden birini seciniz..." << endl;
  cout << "Arama yapmak icin: A" << endl;
  cout << "Listeyi ekrana yazdirmak icin: L" << endl;
  cout << "Ogrenci silmek icin: S" << endl;
  cout << "Dosyaya yazmak icin: Y" << endl;
  cout << "Cikis icin: C" << endl;
  char secim;
  cin >> secim;
  cout << endl;

  switch (secim) {
  case 'C':
    exit(0);
    break;
  case 'A':
    Search();
    break;
  case 'L':
    List();
    break;
  case 'S':
    removeNode();
    break;
  case 'Y':
    fileWrite();
    break;
  default:
    cout << "Hatali secim !" << endl << endl;
    break;
  }
  cout << endl << endl;
  Menu();
}

int main() {
  agacKur(&root3, "data3.txt");
  agacKur(&root2, "data2.txt");
  agacKur(&root1, "data1.txt");
  Menu();
}

void Search() {

  cout << "Hangi dosya icin arama yapmak istiyorsunuz?..." << endl;
  cout << "data1.txt icin: 1" << endl;
  cout << "data2.txt icin: 2" << endl;
  cout << "data3.txt icin: 3" << endl;
  cout << "Seciminizi :";
  int fileChoice;
  cin >> fileChoice;
  struct node *temp;
  switch (fileChoice) {
  case 1:
    temp = root1;
    break;
  case 2:
    temp = root2;
    break;
  case 3:
    temp = root3;
    break;
  default:
    cout << "Hatali secim !" << endl << endl;
    return;
  }
  char studenNo[15];
  cout << endl << "Ogrenci no :";
  cin >> studenNo;
  cout << endl << "Ilk derinlik aramak icin: I" << endl;
  cout << "Ilk genislik aramak icin: G" << endl;
  char aramaTur;
  cin >> aramaTur;
  arama = 0;
  switch (aramaTur) {
  case 'I':
    ilkDerinlikAra(temp, atoi(studenNo));
    break;
  case 'G':
    ilkDerinlikAra(temp, atoi(studenNo));
    break;
  }
  if (arama == 0) {
    cout << "Ogrenci bulunamadi !!!" << endl;
  }
}

void removeNode() {

  cout << "Hangi dosya icin silme yapmak istiyorsunuz?..." << endl;
  cout << "data1.txt icin: 1" << endl;
  cout << "data2.txt icin: 2" << endl;
  cout << "data3.txt icin: 3" << endl;
  cout << "Seciminizi :";
  int fileChoice;
  cin >> fileChoice;
  struct node *temp;
  switch (fileChoice) {
  case 1:
    temp = root1;
    break;
  case 2:
    temp = root2;
    break;
  case 3:
    temp = root3;
    break;
  default:
    return;
  }
  char studenNo[15];
  cout << "Ogrenci no :";
  cin >> studenNo;
  temp = nodeDelete(temp, atoi(studenNo));
}

void fileWrite() {
  cout << "Hangi dosyayi yazmak istiyorsunuz?..." << endl;
  cout << "data1.txt icin: 1" << endl;
  cout << "data2.txt icin: 2" << endl;
  cout << "data3.txt icin: 3" << endl;
  cout << "Seciminizi :";
  int fileChoice;
  cin >> fileChoice;
  struct node *temp;
  char fileName[20];
  switch (fileChoice) {
  case 1:
    temp = root1;
    strcpy(fileName, "data1.txt");
    break;
  case 2:
    temp = root2;
    strcpy(fileName, "data1.txt");
    break;
  case 3:
    temp = root3;
    strcpy(fileName, "data1.txt");
    break;
  default:
    cout << "Hatali secim !" << endl << endl;
    return;
  }
  FILE *file;
  file = fopen(fileName, "w");

  fclose(file);
  dosyayaYaz(temp, fileName);
}

void List() {
  cout << "Preorder listeleme yapmak icin: R" << endl;
  cout << "Inorder listeleme yapmak icin: I" << endl;
  cout << "Postorder listeleme yapmak icin: O" << endl;
  cout << "Seciminizi :";
  char secim;
  cin >> secim;
  cout << endl;

  int fileChoice;

  if (!(secim == 'R' || secim == 'I' || secim == 'O')) {
    cout << "Yanlis tercih" << endl << endl;
    return;
  }
  cout << "Hangi dosya icin printInorder listeleme yapmak istiyorsunuz?..."
       << endl;
  cout << "data1.txt icin: 1" << endl;
  cout << "data2.txt icin: 2" << endl;
  cout << "data3.txt icin: 3" << endl;
  cout << "Seciminizi :";
  cin >> fileChoice;
  struct node *temp;
  switch (fileChoice) {
  case 1:
    temp = root1;
    break;
  case 2:
    temp = root2;
    break;
  case 3:
    temp = root3;
    break;
  default:
    return;
  }
  switch (secim) {
  case 'R':
    printPreorder(temp);
    break;
  case 'I':
    printInorder(temp);
    break;
  case 'O':
    printPostorder(temp);
    break;
  }
}

void printNode(struct node *node) {
  cout << node->studenNo << "--" << node->name << "--" << node->lastname
       << endl;
}

void printInorder(struct node *root) {
  if (root != NULL) {
    printInorder(root->left);
    printNode(root);
    printInorder(root->right);
  }
}

struct node *nodeNew(int studenNo, char name[], char lastname[]) {
  struct node *temp = (struct node *)malloc(sizeof(struct node));
  temp->studenNo = studenNo;

  strcpy(temp->name, name);
  strcpy(temp->lastname, lastname);
  temp->left = temp->right = NULL;
  return temp;
}

struct node *nodeAdd(struct node *root, int studenNo, char name[],
                     char lastname[]) {
  if (root == NULL)
    return nodeNew(studenNo, name, lastname);

  if (studenNo < root->studenNo)
    root->left = nodeAdd(root->left, studenNo, name, lastname);
  else
    root->right = nodeAdd(root->right, studenNo, name, lastname);

  return root;
}

void ilkDerinlikAra(struct node *root, int studenNo) {
  if (root != NULL) {
    ilkDerinlikAra(root->left, studenNo);
    if (root->studenNo == studenNo) {
      printNode(root);
      arama = 1;
    }
    ilkDerinlikAra(root->right, studenNo);
  }
}

struct node *nodeMin(struct node *root) {
  struct node *current = root;

  while (current && current->left != NULL)
    current = current->left;

  return current;
}

void printPreorder(struct node *root) {
  if (root != NULL) {
    printNode(root);
    printPreorder(root->left);
    printPreorder(root->right);
  }
}

void agacKur(struct node **root, string file) {
  char studenNo[15], name[30], lastname[30], satirAl[75];
  char *ptr;

  ifstream dosya1(file, ios::in);
  dosya1.getline(satirAl, 75);

  for (int i = 0; i < 75; i++) {
    if (satirAl[i] == '\r')
      satirAl[i] = '\0';
  }
  while (dosya1) {
    ptr = strtok(satirAl, "\t");
    int j = 0;
    while (ptr != NULL) {
      if (j == 0)
        strcpy(studenNo, ptr);
      if (j == 1)
        strcpy(name, ptr);
      if (j == 2)
        strcpy(lastname, ptr);
      if (j == 3) {
        strcat(name, " ");
        strcat(name, lastname);
        strcpy(lastname, ptr);
      }
      ptr = strtok(NULL, " ");
      j++;
    }

    *root = nodeAdd(*root, atoi(studenNo), name, lastname);

    dosya1.getline(satirAl, 75);
    for (int i = 0; i < 75; i++) {
      if (satirAl[i] == '\r')
        satirAl[i] = '\0';
    }
  }
  dosya1.close();
}

void printPostorder(struct node *root) {
  if (root != NULL) {
    printPostorder(root->left);
    printPostorder(root->right);
    printNode(root);
  }
}

void ilkGenislikAra(struct node *root, int studenNo) {
  if (root != NULL) {
    ilkDerinlikAra(root->right, studenNo);
    if (root->studenNo == studenNo) {
      printNode(root);
      arama = 1;
    }
    ilkDerinlikAra(root->left, studenNo);
  }
}

void dosyayaYaz(struct node *root, char fileName[]) {
  if (root != NULL) {
    dosyayaYaz(root->left, fileName);
    FILE *file;
    file = fopen(fileName, "a");
    fprintf(file, "%d %s %s\n", root->studenNo, root->name, root->lastname);
    fclose(file);
    dosyayaYaz(root->right, fileName);
  }
}

struct node *nodeDelete(struct node *root, int studenNo) {
  if (root == NULL)
    return root;

  if (studenNo < root->studenNo) {
    root->left = nodeDelete(root->left, studenNo);
  } else if (studenNo > root->studenNo) {
    root->right = nodeDelete(root->right, studenNo);
  } else {
    if (root->left == NULL) {
      struct node *temp = root->right;
      free(root);
      return temp;
    } else if (root->right == NULL) {
      struct node *temp = root->left;
      free(root);
      return temp;
    }

    struct node *temp = nodeMin(root->right);
    root->studenNo = temp->studenNo;
    root->right = nodeDelete(root->right, temp->studenNo);
  }
  return root;
}
