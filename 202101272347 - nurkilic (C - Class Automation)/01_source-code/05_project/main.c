//kullanılan kütüphanelerin dahil edilmesi
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//ön işlemci komutları, ilgili değişkenlerin değer uzunlukları için
#define CLASSSIZE 35           // SINIF KAPASITE
#define STUDENTNUMBERLENGTH 10 // OGRENCI NUMARA UZUNLUGU
#define NAMELENGTH 25          // ADI UZUNLUGU
#define COURSENAMELENGTH 50    // DERS ADI UZUNLUGU
#define COURSECODELENGTH 10    // DERS KODU UZUNLUGU
#define COURSESREGISTERED 5    // KAYITLI DERSLER
#define MIDTERMWEIGHT 30       // VIZE AGIRLIK
#define FINALWEIGHT 30         // FINAL AGIRLIK
#define QUIZWEIGHT 20          // QUIZ AGIRLIK
#define HOMEWORKWEIGHT 20      // ODEV AGIRLIK

//öğrenciye ait ad,soyad bilgisinin tutulduğu yapı
typedef struct fullName // tam adi
{
    char *name;    // adi
    char *surname; // soyadi
} name_t;

//öğrencinin dersine ait aldığı notların tutulduğu yapı
typedef struct examGrades // sinav not
{
    double midterm;  // vize
    double final;    // final
    double quiz;     // quiz
    double homework; // odev
} grades_t;

//öğrencinin kayıtlı olduğu derse ait bilgilerin tutulduğu yapı
typedef struct courseRegistered // kayitli dersler
{
    char courseName[COURSENAMELENGTH]; // ders adi
    char courseCode[COURSECODELENGTH]; // ders kodu
    grades_t grades;                   // notlar
    char letterGrade[2];               // harf notu
    double numericGrade;               // numarik not
} courseReg_t;

//öğrenciye ait bilgilerin tutulduğu yapı
typedef struct studentInfo // ogrenci bilgi
{
    name_t studentName;                      // ogrenci adi
    char *stNo;                              // ogrenci numara
    courseReg_t *courses[COURSESREGISTERED]; // ogrenci dersler
    double gpa;                              // ogrenci ortalama
} student_t;

//sınıf bilgilerinin tutulduğu yapı
typedef struct courseInfo // sinif bilgi
{
    char courseName[COURSENAMELENGTH]; // sinif adi
    char courseCode[COURSECODELENGTH]; // sinif kodu
    student_t students[CLASSSIZE];     // sinif ogrenciler
    double courseAverage;              // sinif ortalama
} courses_t;

//ilgili fonksiyonların prototip tanımlamaları
//+
void ogrenciEkle(student_t students[], int *indexStudents);
//+
void dersEkle(student_t students[], int indexStudents);
//+
void OgrencininDersNotHesapla(student_t students[], int indexStudents);
//+
void OgrenciOrtalamaHesapla(student_t students[], int indexStudents);
//+
void OgrenciBilgiGoster(student_t students[], int indexStudents);
//+
void DersBilgiGoster(student_t students[], int indexStudents);
//+
void SinifGoster(courses_t courseClass, int indexStudents);
//+
void DersOrtalamaHesapla(student_t students[], int indexStudents);

//ana method
int main()
{
	//sınıf değerlerinin tutulduğu değişken
    courses_t courseClass;

    //sınıf bilgilerinin girilmesi
    printf("Sinif Adi : ");
    scanf("%s", courseClass.courseName);
    printf("Sinif Kodu : ");
    scanf("%s", courseClass.courseCode);
    printf("\nSinif bilgileri eklendi.\n");

    //öğrenci sayısının tutulduğu değişken
    int indexStudents = 0;

    //menu, döngü ile program sonlandırılana dek işlem bitince menüye dönülmesi
    while (1)
    {
        printf("\n");
        printf("1) Ogrenci Ekle\n");
        printf("2) Ders Ekle\n");
        printf("3) Ogrencinin Ders Notlari\n");
        printf("4) Ogrencinin Ortalamasi\n");
        printf("5) Ogrenci Bilgi Goster\n");
        printf("6) Ders Bilgi Goster\n");
        printf("7) Sinif Goster\n");
        printf("8) Ders Ortalama\n");
        printf("0) Cikis\n");
        printf("Secim : ");
        int secim;
        scanf("%d", &secim);
        //seçilen seçeneğe göre ilgili fonksiyonların ilgili değerlerle çağrılması
        switch (secim)
        {
        case 0:
            printf("Cikiliyor...\n");
            exit(0);
            break;
        case 1:
            ogrenciEkle(courseClass.students, &indexStudents);
            break;
        case 2:
            dersEkle(courseClass.students, indexStudents);
            break;
        case 3:
            OgrencininDersNotHesapla(courseClass.students, indexStudents);
            break;
        case 4:
            OgrenciOrtalamaHesapla(courseClass.students, indexStudents);
            break;
        case 5:
            OgrenciBilgiGoster(courseClass.students, indexStudents);
            break;
        case 6:
            DersBilgiGoster(courseClass.students, indexStudents);
            break;
        case 7:
            SinifGoster(courseClass, indexStudents);
            break;
        case 8:
            DersOrtalamaHesapla(courseClass.students, indexStudents);
            break;
        default:
            printf("Hatali secim !!!\n");
            break;
        }
        printf("\n");
    }
}

//öğrenci bilgilerinin yatay olarak yazıdırılması
void yazdirOgrenci(student_t student, int index)
{
    printf("\n------------------------------------------------------------------\n");
    printf("%2d ", index);
    printf("%16s ", student.stNo);
    printf("%20s ", student.studentName.name);
    printf("%17s", student.studentName.surname);
}

//öğrenci bilgilerinin dikey olarak yazıdırılması
void yazdirOgrenciSade(student_t student)
{
    printf("Ogrenci No    : %s\n", student.stNo);
    printf("Ogrenci Ad    : %s\n", student.studentName.name);
    printf("Ogrenci Soyad : %s\n", student.studentName.surname);
}

//öğrenci listesinin yazdırılması
void ogrenciListele(student_t students[], int indexStudents)
{
    printf("\n%s %13s %18s %20s", "Index", "Numara", "Ad", "Soyad");

    int i;
    for (i = 0; i < indexStudents; i++)
    {
        yazdirOgrenci(students[i], (i + 1));
    }
    printf("\n------------------------------------------------------------------\n");
}

//listeden bir öğrenci seçilmesi
int ogrenciSec(student_t students[], int indexStudents)
{
    if (indexStudents == 0)
    {
        printf("Hic ogrenci kaydi yok !!!\n");
        return -1;
    }
    ogrenciListele(students, indexStudents);
    printf("Ogrenci Index No : ");
    int indexNo;
    scanf("%d", &indexNo);
    indexNo--;
    if (indexNo < 0 || indexNo >= indexStudents)
    {
        printf("Hatali index no !!!\n");
        return -1;
    }
    return indexNo;
}

//öğrenci listesine yeni bir öğrenci eklenmesi
void ogrenciEkle(student_t students[], int *indexStudents)
{
    student_t *newStudent = &students[(*indexStudents)++];

    newStudent->studentName.name = (char *)malloc(sizeof(char) * NAMELENGTH);
    newStudent->studentName.surname = (char *)malloc(sizeof(char) * NAMELENGTH);
    newStudent->stNo = (char *)malloc(sizeof(char) * STUDENTNUMBERLENGTH);

    printf("No    : ");
    scanf("%s", newStudent->stNo);

    printf("Ad    : ");
    scanf("%s", newStudent->studentName.name);

    printf("Soyad : ");
    scanf("%s", newStudent->studentName.surname);

    printf("\nOgrenci eklendi.\n");

    return;
}

//öğrencinin notlarına göre harf notunun belirlenmesi
void harfNotuBelirle(char *letterGrade, int numericGrade)
{
    if (numericGrade >= 90)
    {
        strcpy(letterGrade, "AA");
    }
    else if (numericGrade >= 85 && numericGrade <= 89)
    {
        strcpy(letterGrade, "BA");
    }
    else if (numericGrade >= 80 && numericGrade <= 84)
    {
        strcpy(letterGrade, "BA");
    }
    else if (numericGrade >= 85 && numericGrade <= 89)
    {
        strcpy(letterGrade, "BB");
    }
    else if (numericGrade >= 75 && numericGrade <= 79)
    {
        strcpy(letterGrade, "CB");
    }
    else if (numericGrade >= 70 && numericGrade <= 74)
    {
        strcpy(letterGrade, "CC");
    }
    else if (numericGrade >= 60 && numericGrade <= 79)
    {
        strcpy(letterGrade, "DC");
    }
    else if (numericGrade >= 50 && numericGrade <= 59)
    {
        strcpy(letterGrade, "DD");
    }
    else if (numericGrade >= 0 && numericGrade <= 49)
    {
        strcpy(letterGrade, "FF");
    }
}

//öğrenciye ait kayıta ders kaydının eklenmesi, not girilmesi
void dersEkle(student_t students[], int indexStudents)
{
    int indexNo = ogrenciSec(students, indexStudents);
    if (indexNo == -1)
        return;

    student_t *student = &students[indexNo];

    printf("Ogrenci Numara : %s\n", student->stNo);
    printf("Ogrenci Adi    : %s\n", student->studentName.name);
    printf("Ogrenci Soyadi : %s\n\n", student->studentName.surname);
    printf("----------------------------------\n");

    int i;
    for (i = 0; i < COURSESREGISTERED; i++)
    {
        student->courses[i] = (courseReg_t *)malloc(sizeof(courseReg_t));
        printf("%d. Ders Adi  : ", (i + 1));
        scanf("%s", student->courses[i]->courseName);
        printf("%d. Ders Kodu : ", (i + 1));
        scanf("%s", student->courses[i]->courseCode);
        printf("Notlar >>\n");
        double midterm, final, quiz, homework;
    vizenotgir:
        printf("Vize     : ");
        scanf("%lf", &midterm);
        if (midterm < 0 || midterm > 100)
        {
            printf("Hatali notlandirma !!!\n");
            goto vizenotgir;
        }
    finalnotgir:
        printf("Final    : ");
        scanf("%lf", &final);
        if (final < 0 || final > 100)
        {
            printf("Hatali notlandirma !!!\n");
            goto finalnotgir;
        }
    quiznotgir:
        printf("Quiz     : ");
        scanf("%lf", &quiz);
        if (quiz < 0 || quiz > 100)
        {
            printf("Hatali notlandirma !!!\n");
            goto quiznotgir;
        }
    homeworknotgir:
        printf("Homework : ");
        scanf("%lf", &homework);
        if (homework < 0 || homework > 100)
        {
            printf("Hatali notlandirma !!!\n");
            goto homeworknotgir;
        }
        student->courses[i]->grades.midterm = midterm;
        student->courses[i]->grades.final = midterm;
        student->courses[i]->grades.quiz = quiz;
        student->courses[i]->grades.homework = homework;
    }
}
//öğrencinin tüm derslerinin notlarının hesaplanması 
void OgrencininDersNotHesapla(student_t students[], int indexStudents)
{
    int indexNo = ogrenciSec(students, indexStudents);
    if (indexNo == -1)
        return;

    student_t *student = &students[indexNo];

    printf("Ogrenci Numara : %s\n", student->stNo);
    printf("Ogrenci Adi    : %s\n", student->studentName.name);
    printf("Ogrenci Soyadi : %s\n\n", student->studentName.surname);
    printf("----------------------------------\n");

    int i;
    for (i = 0; i < COURSESREGISTERED; i++)
    {
        double numericGrade = 0;
        numericGrade += (student->courses[i]->grades.midterm / 100) * MIDTERMWEIGHT;
        numericGrade += (student->courses[i]->grades.final / 100) * FINALWEIGHT;
        numericGrade += (student->courses[i]->grades.quiz / 100) * QUIZWEIGHT;
        numericGrade += (student->courses[i]->grades.homework / 100) * HOMEWORKWEIGHT;

        student->courses[i]->numericGrade = numericGrade;
        harfNotuBelirle(student->courses[i]->letterGrade, numericGrade);

        printf("Ders Adi    : %s\n", student->courses[i]->courseName);
        printf("Ders Kodu   : %s\n", student->courses[i]->courseCode);
        printf("Numerik Not : %.2lf\n", numericGrade);
        printf("Harf Notu   : %s\n\n", student->courses[i]->letterGrade);
    }
}
//öğrencnin derslerine ait not ortalamalarının hesaplanması
void OgrenciOrtalamaHesapla(student_t students[], int indexStudents)
{
    int indexNo = ogrenciSec(students, indexStudents);
    if (indexNo == -1)
        return;

    student_t *student = &students[indexNo];

    printf("Ogrenci Numara : %s\n", student->stNo);
    printf("Ogrenci Adi    : %s\n", student->studentName.name);
    printf("Ogrenci Soyadi : %s\n\n", student->studentName.surname);
    printf("----------------------------------\n");

    double gpa = 0;
    int i;
    for (i = 0; i < COURSESREGISTERED; i++)
    {
        gpa += student->courses[i]->numericGrade;
    }
    gpa /= COURSESREGISTERED;
    student->gpa = gpa;

    printf("Ogrenci Ortalama : %.2lf", gpa);
}
//öğrenciye ait bilgileri ve derslerden aldığı notların listelenmesi
void OgrenciBilgiGoster(student_t students[], int indexStudents)
{
    int indexNo = ogrenciSec(students, indexStudents);
    if (indexNo == -1)
        return;

    student_t *student = &students[indexNo];

    printf("Ogrenci Numara : %s\n", student->stNo);
    printf("Ogrenci Adi    : %s\n", student->studentName.name);
    printf("Ogrenci Soyadi : %s\n\n", student->studentName.surname);
    printf("----------------------------------\n");
    int i;
    for (i = 0; i < COURSESREGISTERED; i++)
    {
        printf("Ders Ad/Kod   : %s (%s)\n", student->courses[i]->courseName, student->courses[i]->courseCode);
        printf("Vize Notu     : %.2lf\n", student->courses[i]->grades.midterm);
        printf("Final Notu    : %.2lf\n", student->courses[i]->grades.final);
        printf("Quiz Notu     : %.2lf\n", student->courses[i]->grades.quiz);
        printf("Odev Notu     : %.2lf\n\n", student->courses[i]->grades.homework);
        printf("Ders Not      : %.2lf\n", student->courses[i]->numericGrade);
        printf("Ders Harf Not : %s\n", student->courses[i]->letterGrade);
        printf("----------------------------------\n");
    }

    printf("Ogrenci Ortalama : %.2lf", student->gpa);
}
//sınıfın öğrencilerinin ders notu ortalamasının hesaplanması
double sinifOrtalamaHesapla(courses_t courseClass, int indexStudents)
{
    double ortalama = 0;
    int i;
    for (i = 0; i < indexStudents; i++)
    {
        ortalama += courseClass.students[i].gpa;
    }
    return ortalama / indexStudents;
}
//sınıfa ait bilgilerin ve kayıtlı öğrencilerin listelenmesi
void SinifGoster(courses_t courseClass, int indexStudents)
{
    courseClass.courseAverage = sinifOrtalamaHesapla(courseClass, indexStudents);

    printf("\nSinif Adi      : %s\n", courseClass.courseName);
    printf("Sinif Kodu     : %s\n", courseClass.courseCode);
    printf("Sinif Ortalama : %.2lf\n", courseClass.courseAverage);
    printf("\nOgrenciler >>\n");
    ogrenciListele(courseClass.students, indexStudents);
}
//tüm ders kayıtlarından seçilen bir dersin bilgilerinin listelenmesi
void DersBilgiGoster(student_t students[], int indexStudents)
{
    printf("\nDersler >>\n");
    int i, j;
    for (i = 0; i < indexStudents; i++)
    {
        for (j = 0; j < COURSESREGISTERED; j++)
        {
            printf("Ders Ad : %s\n", students[i].courses[j]->courseName);
            printf("-----------------------------\n");
        }
    }
    char dersAd[COURSENAMELENGTH];
    printf("Ders Adi : ");
    scanf("%s", dersAd);

    printf("\nDersi alan ogrenciler >>\n\n");
    for (i = 0; i < indexStudents; i++)
    {
        for (j = 0; j < COURSESREGISTERED; j++)
        {
            if (students[i].courses[j]->courseName != NULL)
            {
                if (strcmp(students[i].courses[j]->courseName, dersAd) == 0)
                {
                    yazdirOgrenciSade(students[i]);
                    printf("---------------------------\n");
                }
            }
        }
    }
}
//tüm ders kayıtlarından seçilen bir derse kayıtlı öğrencilerden dersin ortalmasının listelenmesi
void DersOrtalamaHesapla(student_t students[], int indexStudents)
{
    printf("\nDersler >>\n");
    int i, j;
    for (i = 0; i < indexStudents; i++)
    {
        for (j = 0; j < COURSESREGISTERED; j++)
        {
            printf("Ders Ad : %s\n", students[i].courses[j]->courseName);
            printf("-----------------------------\n");
        }
    }
    char dersAd[COURSENAMELENGTH];
    printf("Ders Adi : ");
    scanf("%s", dersAd);

    int adet = 0;
    double ortalama = 0;
    for (i = 0; i < indexStudents; i++)
    {
        for (j = 0; j < COURSESREGISTERED; j++)
        {
            if (students[i].courses[j]->courseName != NULL)
            {
                if (strcmp(students[i].courses[j]->courseName, dersAd) == 0)
                {
                   ortalama += students[i].courses[j]->numericGrade;
                   adet++;
                }
            }
        }
    }
    printf("Ders Ortlama = %.2lf\n",(ortalama/adet));
}
