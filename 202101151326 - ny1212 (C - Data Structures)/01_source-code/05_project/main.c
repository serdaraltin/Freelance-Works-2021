#include <stdio.h>
#include <stdlib.h>

#define CAPACITY 10

typedef struct contanier
{
    int *labels;
    float *values;
    int capacity;
} Container;

void init(int capacity, Container *map)
{
    map->capacity = capacity;
    map->labels = (int *)malloc(sizeof(int) * capacity);
    map->values = (float *)malloc(sizeof(float) * capacity);

    int i;
    for (i = 0; i < map->capacity; i++)
    {
        map->labels[i] = 0;
        map->values[i] = 0;
    }
    return;
}

int label_exists(Container *map, int label)
{
    int i;
    for (i = 0; i < map->capacity; i++)
    {
        if (map->labels[i] == label)
        {
            printf("label %d exists\n",label);
            return 1;
        }
    }
    return 0;
}

int insert(Container *map, int label, float value)
{
    if (label_exists(map, label))
    {
        return 1;
    }
    int i;
    for (i = 0; i < map->capacity; i++)
    {
        if (map->labels[i] == 0)
        {
            map->labels[i] = label;
            map->values[i] = value;
            return 0;
        }
    }
    return 1;
}

float get_val(Container *map, int label)
{
    int i;
    for (i = 0; i < map->capacity; i++)
    {
        if (map->labels[i] == label)
        {
            return map->values[i];
        }
    }
    return -1.00;
}

void print(Container *map)
{
    int i;
    for (i = 0; i < map->capacity; i++)
    {
        if (map->labels[i] != 0)
            printf("label: %d, value: %.2f\n", map->labels[i], map->values[i]);
    }
}

int main()
{
    Container map;

    init(CAPACITY, &map);

    print(&map);

    int succ = 0;

    succ += insert(&map, 3, 5.0);
    succ += insert(&map, 4, 2.5);
    succ += insert(&map, 6, 3.0);
    succ += insert(&map, 7, 4.3);
    succ += insert(&map, 3, 7.0);

    if (succ != 0)
        printf("%d insertion(s) failed\n\n", succ);

    print(&map);

    printf("\nvalue with label 3:%.2f\n", get_val(&map, 3));
    printf("value with label 8:%.2f\n", get_val(&map, 8));
}