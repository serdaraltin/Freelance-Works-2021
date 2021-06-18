
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct dugum
{
    int key;
    struct dugum *parent, *sol_link, *sag_link;
};

struct heap
{
    struct dugum *kok;
    struct dugum *en_son_eklenen;
};

struct dugum *yeni(int key)
{
    struct dugum *temp = (struct dugum *)malloc(sizeof(struct dugum));
    temp->key = key;
    temp->parent = NULL;
    temp->sol_link = NULL;
    temp->sag_link = NULL;
    return temp;
}

void heap_insert(struct heap *heap, int key)
{
    struct dugum *kok = heap->kok;
 
    while (kok->sag_link != NULL)
    {
        kok = kok->sag_link;
    }
    struct dugum *temp = yeni(key);
    temp->sag_link = kok;
    kok->sag_link = temp;
    temp->sol_link = kok;
    heap->en_son_eklenen = temp;
    temp->parent = kok;
    return;
}

void printHeap(struct heap *heap)
{
    struct dugum *temp = heap->kok;

    while (temp != NULL)
    {
        printf("%d ", temp->key);
        temp = temp->sag_link;
    }
    printf("\n");
}

int main(int argc, char **argv)
{
    struct heap *heap = (struct heap *)malloc(sizeof(heap));
    heap->kok = yeni(4);
    heap->en_son_eklenen = heap->kok;
    heap_insert(heap, 5);
    heap_insert(heap, 7);
    heap_insert(heap, 3);
    heap_insert(heap, 1);
    heap_insert(heap, 9);

    printHeap(heap);

    return (EXIT_SUCCESS);
}
