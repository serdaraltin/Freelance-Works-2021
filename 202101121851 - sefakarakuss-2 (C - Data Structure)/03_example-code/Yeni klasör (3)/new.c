void heap_insert(struct heap *heap, int key)
{
    struct dugum *kok = heap->kok;
 
    while (kok->sag_link != NULL)
    {
        kok = kok->sag_link;
    }
    struct dugum *temp = (struct dugum*)malloc(sizeof dugum);
    temp->key = key;
    temp->sag_link = kok;
    kok->sag_link = temp;
    temp->sol_link = kok;
    heap->en_son_eklenen = temp;
    temp->parent = kok;
    return;
}