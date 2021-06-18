#include <iostream>
#include <stdlib.h>

#define UZUNLUK 10

using namespace std;

typedef struct node
{
    int sayi;
    struct node *sonraki;
} Node;

Node *root = NULL;

Node *tersduz(int sira)
{
    Node *list = root;

    int i = 1;
    while (list != NULL)
    {
        if (i == sira)
            break;
        list = list->sonraki;
        i++;
    }

    Node *list2 = list;
    while (list2->sonraki != NULL)
    {
        list2 = list2->sonraki;
    }

    Node *list3 = root;
    i = 1;
    while (root != NULL)
    {
        if (i + 1 == sira)
        {
            root->sonraki = NULL;
            break;
        }
        root = root->sonraki;
    }

    list2->sonraki = list3;

    Node *son = list;
    i = 1;
    while (list != NULL)
    {
        if (i == UZUNLUK)
        {
            list->sonraki = NULL;
            break;
        }
        list = list->sonraki;
        i++;
    }
    return son;
}

Node *yeniNode(int sayi)
{
    Node *yeni = (Node *)malloc(sizeof(Node));
    yeni->sayi = sayi;
    yeni->sonraki = NULL;
    return yeni;
}

void ekle(Node *node, int sayi)
{
    if (node == NULL)
    {
        root = yeniNode(sayi);
        return;
    }
    Node *temp = node;

    while (temp->sonraki != NULL)
    {
        temp = temp->sonraki;
    }
    temp->sonraki = yeniNode(sayi);
    return;
}

int main()
{
    ekle(root, 1);
    ekle(root, 2);
    ekle(root, 3);
    ekle(root, 4);
    ekle(root, 5);
    ekle(root, 6);
    ekle(root, 7);
    ekle(root, 8);
    ekle(root, 9);
    ekle(root, 10);

    int sira;
    cout << "1'den 9'a kadar bir sira numarasi giriniz : ";
    cin >> sira;
    root = tersduz(sira);

    Node *temp = root;

    while (temp)
    {
        cout << temp->sayi << " ";
        temp = temp->sonraki;
    }
    cout << endl;
}
