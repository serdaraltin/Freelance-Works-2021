#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

typedef struct schl {
  int timing;
  int proccod;
  int ordcod;
  int ordquan;
  int setupload;
  struct schl *right;
} Schl;

typedef struct opr {
  int proccod;
  int quan;
  struct opr *right;
} Operation;

typedef struct Order {
  int ordcod;
  int jobtm;
  int proccod;
  int lsdvdt;
  struct Order *right;
} Ord;

typedef struct setdur {
  int pcod1;
  int pcod2;
  int stdr;
  struct setdur *right;
} SetDur;

SetDur *stps = NULL;
Schl *schdls = NULL;
Ord *ordrs = NULL;
Operation *oprts = NULL;

void WriteSchedule(Schl *sch);
void ProcessOrder();
void ListSetup();
void setupread();
void ReadOperation();
void ReadOrder();
void ListOrder();
void WriteOperation(Operation *Operation);
void ListSchedule();
void ListOperation();
void opadd(int proccod, int quan);
void setupadd(int pcod1, int pcod2, int stdr) ;

void space() { cout << "++++++++++++++++++++++++++++++++++++++++" << endl; }

int main() {
  ReadOperation();
  setupread();
  ReadOrder();
  ListOperation();
  space();
  ListSetup();
  space();
  ListOrder();
  space();
  ProcessOrder();
  ListSchedule();
  space();
  return 0;
}

int down(float num) { return (int)(num + 0.5f); }

void ReadOperation() {
  FILE *fp;
  fp = fopen("Operations.txt", "r");
  if (fp == NULL) {

    printf("File connot open!\n");
    exit(0);
  }
  while (!feof(fp)) {
    int proccod;
    int quan;
    fscanf(fp, "%d;%d\n", &proccod, &quan);
    opadd(proccod, quan);
  }
}

void ordadd(int ordcod, int jobtm, int proccod, int lsdvdt) {
  if (ordrs == NULL) {
    ordrs = (Ord *)malloc(sizeof(Ord));
    ordrs->ordcod = ordcod;
    ordrs->jobtm = jobtm;
    ordrs->proccod = proccod;
    ordrs->lsdvdt = lsdvdt;
    ordrs->right = NULL;
    return;
  }
  Ord *iterator = ordrs;
  while (iterator->right != NULL) {
    iterator = iterator->right;
  }
  iterator->right = (Ord *)malloc(sizeof(Ord));
  iterator->right->ordcod = ordcod;
  iterator->right->jobtm = jobtm;
  iterator->right->proccod = proccod;
  iterator->right->lsdvdt = lsdvdt;
  iterator->right->right = NULL;
}

void setupread() {
  FILE *fp;
  fp = fopen("SetupDuration.txt", "r");
  if (fp == NULL) {

    printf("File connot open!\n");
    exit(0);
  }
  while (!feof(fp)) {
    int pcod1;
    int pcod2;
    int stdr;
    fscanf(fp, "%d;%d;%d\n", &pcod1, &pcod2, &stdr);
    setupadd(pcod1, pcod2, stdr);
  }
}

void opadd(int proccod, int quan) {
  if (oprts == NULL) {
    oprts = (Operation *)malloc(sizeof(Operation));
    oprts->proccod = proccod;
    oprts->quan = quan;
    oprts->right = NULL;
    return;
  }
  Operation *iterator = oprts;
  while (iterator->right != NULL) {
    iterator = iterator->right;
  }
  iterator->right = (Operation *)malloc(sizeof(Operation));
  iterator->right->proccod = proccod;
  iterator->right->quan = quan;
  iterator->right->right = NULL;
}

void setupadd(int pcod1, int pcod2, int stdr) {
  if (stps == NULL) {
    stps = (SetDur *)malloc(sizeof(SetDur));
    stps->pcod1 = pcod1;
    stps->pcod2 = pcod2;
    stps->stdr = stdr;
    stps->right = NULL;
    return;
  }

  SetDur *iterator = stps;
  while (iterator->right != NULL) {
    iterator = iterator->right;
  }
  iterator->right = (SetDur *)malloc(sizeof(SetDur));
  iterator->right->pcod1 = pcod1;
  iterator->right->pcod2 = pcod2;
  iterator->right->stdr = stdr;
  iterator->right->right = NULL;
}
void WriteOperation(Operation *Operation) { printf("%d\t%d\n", Operation->proccod, Operation->quan); }
void WriteOrder(Ord *Order) {
  printf("%d\t%d\t%d\t%d\n", Order->ordcod, Order->jobtm, Order->proccod,
         Order->lsdvdt);
}
void ListOperation() {
  Operation *iterator = oprts;
  while (iterator != NULL) {
    WriteOperation(iterator);
    iterator = iterator->right;
  }
}

void ReadOrder() {
  FILE *fp;
  fp = fopen("Orders.txt", "r");

  if (fp == NULL) {

    printf("File connot open!\n");
    exit(0);
  }
  while (!feof(fp)) {
    int ordcod;
    int jobtm;
    int proccod;
    int lsdvdt;
    fscanf(fp, "%d;%d;%d;%d\n", &ordcod, &jobtm, &proccod,
           &lsdvdt);
    ordadd(ordcod, jobtm, proccod, lsdvdt);
  }
}

void schladd(int timing, int proccod, int ordcod, int ordquan, int setupload) {
  if (schdls == NULL) {
    schdls = (Schl *)malloc(sizeof(Schl));
    schdls->timing = timing;
    schdls->proccod = proccod;
    schdls->ordcod = ordcod;
    schdls->setupload = setupload;
    schdls->ordquan = ordquan;
    schdls->right = NULL;
  }
  Schl *iterator = schdls;
  while (iterator->right != NULL)
    iterator = iterator->right;
  iterator->right = (Schl *)malloc(sizeof(Schl));
  iterator->right->timing = timing;
  iterator->right->proccod = proccod;
  iterator->right->ordcod = ordcod;
  iterator->right->setupload = setupload;
  iterator->right->ordquan = ordquan;
  iterator->right->right = NULL;
}

void writesetdur(SetDur *set) {
  printf("%d\t%d\t%d\t\n", set->pcod1, set->pcod2, set->stdr);
}

void ListSetup() {
  SetDur *iterator = stps;
  while (iterator != NULL) {
    writesetdur(iterator);
    iterator = iterator->right;
  }
}

int Proc2SetupDuration(int pcod1, int pcod2) {
  SetDur *iterator = stps;
  while (iterator != NULL) {
    if (iterator->pcod1 == pcod1 && iterator->pcod2 == pcod2)
      return iterator->stdr;
    iterator = iterator->right;
  }
  return -1;
}

int Proc2Quan(int proccod) {
  Operation *iterator = oprts;
  while (iterator != NULL) {
    if (iterator->proccod == proccod)
      return iterator->quan;
    iterator = iterator->right;
  }
  return -1;
}


void ListSchedule() {
  FILE *fp;
  fp = fopen("Schedule.txt", "w");
  if (fp == NULL) {
    printf("File connot create\n");
    return;
  }

  Schl *iterator = schdls;
  while (iterator != NULL) {
    WriteSchedule(iterator);
    fprintf(fp, "%d;%d;%d;%d;%d\n", iterator->timing, iterator->proccod,
            iterator->ordcod, iterator->ordquan, iterator->setupload);
    iterator = iterator->right;
  }

  fclose(fp);
}

void CalculateOrder(Ord *Order, int *Time) {
  int quan = down((Order->jobtm) / Proc2Quan(Order->proccod));
  int setup;
  if (Order->right == NULL) {
    setup = 0;
  } else {
    setup = down(Proc2SetupDuration(Order->proccod, Order->right->proccod));
  }
  schladd(*Time, Order->proccod, Order->ordcod, Order->jobtm, setup);
  (*Time) += setup;
}

void ListOrder() {
  Ord *iterator = ordrs;
  while (iterator != NULL) {
    WriteOrder(iterator);
    iterator = iterator->right;
  }
}

void ProcessOrder() {
  int Time = 0;
  Ord *iterator = ordrs;
  while (iterator != NULL) {
    CalculateOrder(iterator, &Time);
    iterator = iterator->right;
    Time++;
  }
}

void WriteSchedule(Schl *sch) {
  printf("%d\t%d\t%d\t%d\t%d\n", sch->timing, sch->proccod, sch->ordcod,
         sch->ordquan, sch->setupload);
}
