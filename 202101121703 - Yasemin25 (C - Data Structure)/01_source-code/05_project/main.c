#include <stdio.h>
#include <stdlib.h>

struct node
{
	int key;
	struct node *left, *right;
};

struct node *root = NULL;

void printGivenLevel(struct node *root, int level);

struct node *newNode(int item)
{
	struct node *temp = (struct node *)malloc(sizeof(struct node));
	temp->key = item;
	temp->left = temp->right = NULL;
	return temp;
}

void list(struct node *root)
{
	if (root != NULL)
	{
		printf("%d ", root->key);
		list(root->left);
		list(root->right);
	}
}

struct node *insert(struct node *node, int key)
{

	if (node == NULL)
		return newNode(key);

	if (key < node->key)
		node->left = insert(node->left, key);
	else if (key > node->key)
		node->right = insert(node->right, key);

	return node;
}

int height(struct node *node)
{
	if (node == NULL)
		return 0;
	else
	{
		int lheight = height(node->left);
		int rheight = height(node->right);
		if (lheight > rheight)
			return (lheight + 1);
		else
			return (rheight + 1);
	}
}

void printLevelOrder(struct node *root)
{
	int h = height(root);
	int i;
	for (i = 1; i <= h; i++)
		printGivenLevel(root, i);
}

void printGivenLevel(struct node *root, int level)
{
	if (root == NULL)
		return;
	if (level == 1)
		printf("%d ", root->key);
	else if (level > 1)
	{
		printGivenLevel(root->left, level - 1);
		printGivenLevel(root->right, level - 1);
	}
}

struct node *search(struct node *root, int key, int *step)
{

	if (root == NULL || root->key == key)
		return root;

	if (root->key < key)
	{
		(*step)++;
		return search(root->right, key, step);
	}
	(*step)++;
	return search(root->left, key, step);
}

void listNumofBig(struct node *root, int num)
{
	if (root != NULL)
	{
		if (root->key > num)
			printf("%d ", root->key);
		listNumofBig(root->left, num);
		listNumofBig(root->right, num);
	}
}

void avgLeaf(struct node *root, int *sum, int *count)
{

	if (root != NULL)
	{
		(*sum) += root->key; 
		(*count)++;
		avgLeaf(root->left,sum,count);
		avgLeaf(root->right,sum,count);
	}
}

void menu();

int main()
{
	menu();

	return 0;
}

void menu()
{
	printf("1) Ekle\n");
	printf("2) Bul\n");
	printf("3) Listele\n");
	printf("4) Seviye Listele\n");
	printf("5) Yaprak Ortalama\n");
	printf("6) Sayidan Buyuk Olanlar\n");
	printf("0) Cikis\n");
	printf("\n\nSecim: ");
	int secim;
	scanf("%d", &secim);
	int sayi;
	int toplam = 0;
	int elemanSayisi = 0;
	switch (secim)
	{
	case 0:
		printf("Cikiliyor...\n");
		exit(0);
		break;
	case 1:
		printf("\nSayi: ");
		scanf("%d", &sayi);
		if (root == NULL)
			root = insert(root, sayi);
		else
			insert(root, sayi);
		break;
	case 2:
		printf("\nSayi: ");
		scanf("%d", &sayi);
		int adim = 0;
		struct node *sonuc = search(root, sayi, &adim);
		if (sonuc == NULL)
		{
			printf("%d elemani bulunamadi !\n", sayi);
		}
		else
		{
			printf("%d elemani %d adimda bulundu.\n", sayi, (adim+1));
		}
		break;
	case 3:
		printf("Liste: ");
		list(root);
		break;
	case 4:
		printf("\nSayi: ");
		int seviye = 0;
		scanf("%d", &seviye);
		printf("%d. seviyedeki elemanlar: ", seviye);
		printGivenLevel(root, seviye + 1);
		break;
	case 5:
		avgLeaf(root,&toplam, &elemanSayisi);
		toplam -= root->key;
		elemanSayisi--;
		printf("Yaprak dugumlerin ortalamasi: %d",(toplam/elemanSayisi));
		break;
	case 6:
		printf("\nSayi: ");
		scanf("%d", &sayi);
		printf("%d degerinden buyuk elemanlar: ", sayi);
		listNumofBig(root, sayi);
		break;
	default:
		printf("Hatali secim!\n");
		break;
	}
	printf("\n\n");
	menu();
}
