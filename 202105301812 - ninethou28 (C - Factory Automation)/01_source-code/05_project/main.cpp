#include <stdlib.h>
#include <stdio.h>

typedef struct opr {
  int proccod;
  int quan;
  struct opr *next;
}Opr;

typedef struct setdur {
  int proccod1;
  int proccod2;
  int setupduration;
  struct setdur *next;
}SetDur;

typedef struct ord {
  int ordcode;
  int jobtime;
  int proccod;
  int lastdeliverydate;
  struct ord *next;
}Ord;

typedef struct schl {
  int timing;
  int proccod;
  int ordcode;
  int ordquan;
  int setupload;
  struct schl *next;
}Schl;

Schl *schedules = NULL;
SetDur *setups = NULL;
Opr *operations = NULL;
Ord *orders = NULL;

void ordread();
void schlwrite(Schl *sch);
void opwrite(Opr *op);
void setupread();
void ordlist();
void ordprocess();
void setuplist();
void opread();
void schllist();
void oplist();


int main() {
  opread();
  setupread();
  ordread();

  oplist();
  printf("---------------------------------------\n");
  setuplist();
  printf("---------------------------------------\n");
  ordlist();
  printf("---------------------------------------\n");

  ordprocess();
  schllist();
  printf("---------------------------------------\n");
  return 0;
}

int roll(float num) { return (int)(num + 0.5f); }

void opadd(int proccod, int quan) {
  if (operations == NULL) {
    operations = (Opr *)malloc(sizeof(Opr));
    operations->proccod = proccod;
    operations->quan = quan;
    operations->next = NULL;
    return;
  }
  Opr *itr = operations;
  while (itr->next != NULL) {
    itr = itr->next;
  }
  itr->next = (Opr *)malloc(sizeof(Opr));
  itr->next->proccod = proccod;
  itr->next->quan = quan;
  itr->next->next = NULL;
}

void ordadd(int ordcode, int jobtime, int proccod,
              int lastdeliverydate) {
  if (orders == NULL) {
    orders = (Ord *)malloc(sizeof(Ord));
    orders->ordcode = ordcode;
    orders->jobtime = jobtime;
    orders->proccod = proccod;
    orders->lastdeliverydate = lastdeliverydate;
    orders->next = NULL;
    return;
  }
  Ord *itr = orders;
  while (itr->next != NULL) {
    itr = itr->next;
  }
  itr->next = (Ord *)malloc(sizeof(Ord));
  itr->next->ordcode = ordcode;
  itr->next->jobtime = jobtime;
  itr->next->proccod = proccod;
  itr->next->lastdeliverydate = lastdeliverydate;
  itr->next->next = NULL;
}

void setupadd(int proccod1, int proccod2, int setupduration) {
  if (setups == NULL) {
    setups = (SetDur *)malloc(sizeof(SetDur));
    setups->proccod1 = proccod1;
    setups->proccod2 = proccod2;
    setups->setupduration = setupduration;
    setups->next = NULL;
    return;
  }

  SetDur *itr = setups;
  while (itr->next != NULL) {
    itr = itr->next;
  }
  itr->next = (SetDur *)malloc(sizeof(SetDur));
  itr->next->proccod1 = proccod1;
  itr->next->proccod2 = proccod2;
  itr->next->setupduration = setupduration;
  itr->next->next = NULL;
}

void schladd(int timing, int proccod, int ordcode,
                 int ordquan, int setupload) {
  if (schedules == NULL) {
    schedules = (Schl *)malloc(sizeof(Schl));
    schedules->timing = timing;
    schedules->proccod = proccod;
    schedules->ordcode = ordcode;
    schedules->setupload = setupload;
       schedules->ordquan = ordquan;
    schedules->next = NULL;
  }
  Schl *itr = schedules;
  while (itr->next != NULL)
    itr = itr->next;
  itr->next = (Schl *)malloc(sizeof(Schl));
  itr->next->timing = timing;
  itr->next->proccod = proccod;
  itr->next->ordcode = ordcode;
  itr->next->setupload = setupload;
   itr->next->ordquan = ordquan;
  itr->next->next = NULL;
}

void opread() {
  FILE *filePointer;
  filePointer = fopen("Operations.txt", "r");
  if (filePointer == NULL) {
 
    printf("File connot open!\n");
    exit(0);
  }
  while (!feof(filePointer)) {
    int proccod;
    int quan;
    fscanf(filePointer, "%d;%d\n", &proccod, &quan);
    opadd(proccod, quan);
  }
}

void ordread() {
  FILE *filePointer;
  filePointer = fopen("Orders.txt", "r");
 
  if (filePointer == NULL) {
       
    printf("File connot open!\n");
    exit(0);
  }
  while (!feof(filePointer)) {
    int ordcode;
    int jobtime;
    int proccod;
    int lastdeliverydate;
    fscanf(filePointer, "%d;%d;%d;%d\n", &ordcode, &jobtime, &proccod,
           &lastdeliverydate);
    ordadd(ordcode, jobtime, proccod, lastdeliverydate);
  }
}

void setupread() {
  FILE *filePointer;
  filePointer = fopen("SetupDuration.txt", "r");
  if (filePointer == NULL) {
 
    printf("File connot open!\n");
    exit(0);
  }
  while (!feof(filePointer)) {
    int proccod1;
    int proccod2;
    int setupduration;
    fscanf(filePointer, "%d;%d;%d\n", &proccod1, &proccod2, &setupduration);
    setupadd(proccod1, proccod2, setupduration);
  }
}

void opwrite(Opr *op) {
  printf("%d\t%d\n", op->proccod, op->quan);
}

void oplist() {
  Opr *itr = operations;
  while (itr != NULL) {
    opwrite(itr);
    itr = itr->next;
  }
}

void writeord(Ord *ord) {
  printf(
      "%d\t%d\t%d\t%d\n",
      ord->ordcode, ord->jobtime, ord->proccod,
      ord->lastdeliverydate);
}

void ordlist() {
  Ord *itr = orders;
  while (itr != NULL) {
    writeord(itr);
    itr = itr->next;
  }
}

void writesetdur(SetDur *set) {
  printf("%d\t%d\t%d\t\n",
         set->proccod1, set->proccod2, set->setupduration);
}

void setuplist() {
  SetDur *itr = setups;
  while (itr != NULL) {
    writesetdur(itr);
    itr = itr->next;
  }
}

int getquan(int proccod) {
  Opr *itr = operations;
  while (itr != NULL) {
    if (itr->proccod == proccod)
      return itr->quan;
    itr = itr->next;
  }
  return -1;
}

int getsetdur(int proccod1, int proccod2) {
  SetDur *itr = setups;
  while (itr != NULL) {
    if (itr->proccod1 == proccod1 && itr->proccod2 == proccod2)
      return itr->setupduration;
    itr = itr->next;
  }
  return -1;
}

void calcord(Ord *ord, int *time) {
  int quan = roll((ord->jobtime) / getquan(ord->proccod));
  int kurulum;
  if (ord->next == NULL) {
    kurulum = 0;
  } else {
    kurulum = roll(getsetdur(ord->proccod, ord->next->proccod));
  }
  schladd(*time, ord->proccod, ord->ordcode, ord->jobtime,
              kurulum);
  (*time) += kurulum;
}

void ordprocess() {
  int time = 0;
  Ord *itr = orders;
  while (itr != NULL) {
    calcord(itr, &time);
    itr = itr->next;
    time++;
  }
}

void schlwrite(Schl *sch) {
  printf("%d\t%d\t%d\t%d\t%d\n",
         sch->timing, sch->proccod, sch->ordcode, sch->ordquan,
         sch->setupload);
}

void schllist() {
  FILE *filePointer;
  filePointer = fopen("Schedule.txt", "w");
  if (filePointer == NULL) {
    printf("File connot create\n");
    return;
  }

  Schl *itr = schedules;
  while (itr != NULL) {
    schlwrite(itr);
    fprintf(filePointer, "%d;%d;%d;%d;%d\n", itr->timing, itr->proccod,
            itr->ordcode, itr->ordquan, itr->setupload);
    itr = itr->next;
  }

  fclose(filePointer);
}
