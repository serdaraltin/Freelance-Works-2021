//kullanılan kütüphanelerin dahil edilmesi
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#define CLASSSIZE 35          
#define STUDENTNUMBERLENGTH 10 
#define NAMELENGTH 25          
#define COURSENAMELENGTH 50   
#define COURSECODELENGTH 10   
#define COURSESREGISTERED 5   
#define MIDTERMWEIGHT 30     
#define FINALWEIGHT 30         
#define QUIZWEIGHT 20        
#define HOMEWORKWEIGHT 20    


typedef struct fullName 
{
    char *name;   
    char *surname; 
} name_t;

typedef struct examGrades 
{
    double midterm;  
    double final;    
    double quiz;    
    double homework; 
} grades_t;

typedef struct courseRegistered
{
    char courseName[COURSENAMELENGTH]; 
    char courseCode[COURSECODELENGTH]; 
    grades_t grades;                   
    char letterGrade[2];             
    double numericGrade;              
} courseReg_t;


typedef struct studentInfo 
{
    name_t studentName;                     
    char *stNo;                              
    courseReg_t *courses[COURSESREGISTERED]; 
    double gpa;                             
} student_t;


typedef struct courseInfo 
{
    char courseName[COURSENAMELENGTH]; 
    char courseCode[COURSECODELENGTH]; 
    student_t students[CLASSSIZE];    
    double courseAverage;            
} courses_t;

void printStudent(student_t student, int index)
{
    printf("\n%2d ", index);
    printf("%16s ", student.stNo);
    printf("%20s ", student.studentName.name);
    printf("%17s", student.studentName.surname);
}

void printStudent2(student_t student)
{
    printf("No    : %s\n", student.stNo);
    printf("Name    : %s\n", student.studentName.name);
    printf("Surname : %s\n", student.studentName.surname);
}

void studentList(student_t students[], int in_student)
{
    printf("\n%s %13s %18s %20s", "Index", "No", "Name", "Surname");

    int i;
    for (i = 0; i < in_student; i++)
    {
        printStudent(students[i], (i + 1));
    }
    printf("\n");
}

int studentChoice(student_t students[], int in_student)
{
    if (in_student == 0)
    {
        printf("List null !!!\n");
        return -1;
    }
    studentList(students, in_student);
    printf("Student Index : ");
    int indexNo;
    scanf("%d", &indexNo);
    indexNo--;
    if (indexNo < 0 || indexNo >= in_student)
    {
        printf("Warning choice !!!\n");
        return -1;
    }
    return indexNo;
}

void addStudent(student_t students[], int *in_student)
{
    student_t *newStudent = &students[(*in_student)++];

    newStudent->studentName.name = (char *)malloc(sizeof(char) * NAMELENGTH);
    newStudent->studentName.surname = (char *)malloc(sizeof(char) * NAMELENGTH);
    newStudent->stNo = (char *)malloc(sizeof(char) * STUDENTNUMBERLENGTH);

    printf("No    : ");
    scanf("%s", newStudent->stNo);

    printf("Name    : ");
    scanf("%s", newStudent->studentName.name);

    printf("Surname : ");
    scanf("%s", newStudent->studentName.surname);

    printf("\n");

    return;
}

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

void addCourse(student_t students[], int in_student)
{
    int indexNo = studentChoice(students, in_student);
    if (indexNo == -1)
        return;

    student_t *student = &students[indexNo];

    printf("No : %s\n", student->stNo);
    printf("Name   : %s\n", student->studentName.name);
    printf("Surname : %s\n\n", student->studentName.surname);
    printf("----------------------------------\n");

    int i;
    for (i = 0; i < COURSESREGISTERED; i++)
    {
        student->courses[i] = (courseReg_t *)malloc(sizeof(courseReg_t));
        printf("%d. Course Name : ", (i + 1));
        scanf("%s", student->courses[i]->courseName);
        printf("%d. Course Code : ", (i + 1));
        scanf("%s", student->courses[i]->courseCode);
        printf("Grades >>\n");
        double midterm, final, quiz, homework;
    vizenotgir:
        printf("Midterm     : ");
        scanf("%lf", &midterm);
        if (midterm < 0 || midterm > 100)
        {
            printf("Warning input !!!\n");
            goto vizenotgir;
        }
    finalnotgir:
        printf("Final    : ");
        scanf("%lf", &final);
        if (final < 0 || final > 100)
        {
            printf("Warning input !!!\n");
            goto finalnotgir;
        }
    quiznotgir:
        printf("Quiz     : ");
        scanf("%lf", &quiz);
        if (quiz < 0 || quiz > 100)
        {
            printf("Warning input !!!\n");
            goto quiznotgir;
        }
    homeworknotgir:
        printf("Homework : ");
        scanf("%lf", &homework);
        if (homework < 0 || homework > 100)
        {
            printf("Warning input !!!\n");
            goto homeworknotgir;
        }
        student->courses[i]->grades.midterm = midterm;
        student->courses[i]->grades.final = midterm;
        student->courses[i]->grades.quiz = quiz;
        student->courses[i]->grades.homework = homework;
    }
}


void calculateStudentCourseGrade(student_t students[], int in_student)
{
    int indexNo = studentChoice(students, in_student);
    if (indexNo == -1)
        return;

    student_t *student = &students[indexNo];

    printf("No : %s\n", student->stNo);
    printf("Name   : %s\n", student->studentName.name);
    printf("Surname : %s\n\n", student->studentName.surname);
    printf("\n");

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

        printf("Course Name   : %s\n", student->courses[i]->courseName);
        printf("Course Code   : %s\n", student->courses[i]->courseCode);
        printf("Numeric Grade : %.2lf\n", numericGrade);
        printf("Letter Grade  : %s\n\n", student->courses[i]->letterGrade);
    }
}


void calculateStudentGPA(student_t students[], int in_student)
{
    int indexNo = studentChoice(students, in_student);
    if (indexNo == -1)
        return;

    student_t *student = &students[indexNo];

    printf("No : %s\n", student->stNo);
    printf("Name   : %s\n", student->studentName.name);
    printf("Surname : %s\n\n", student->studentName.surname);
    printf("\n");

    double gpa = 0;
    int i;
    for (i = 0; i < COURSESREGISTERED; i++)
    {
        gpa += student->courses[i]->numericGrade;
    }
    gpa /= COURSESREGISTERED;
    student->gpa = gpa;

    printf("Student AVG : %.2lf", gpa);
}


void displayStudentInfo(student_t students[], int in_student)
{
    int indexNo = studentChoice(students, in_student);
    if (indexNo == -1)
        return;

    student_t *student = &students[indexNo];

    printf("No : %s\n", student->stNo);
    printf("Name   : %s\n", student->studentName.name);
    printf("Surname : %s\n\n", student->studentName.surname);
    printf("----------------------------------\n");
    int i;
    for (i = 0; i < COURSESREGISTERED; i++)
    {
        printf("Course Name/Course Code   : %s (%s)\n", student->courses[i]->courseName, student->courses[i]->courseCode);
        printf("Midtern     : %.2lf\n", student->courses[i]->grades.midterm);
        printf("Final   : %.2lf\n", student->courses[i]->grades.final);
        printf("Quiz     : %.2lf\n", student->courses[i]->grades.quiz);
        printf("Homework     : %.2lf\n\n", student->courses[i]->grades.homework);
        printf("Numeric Grade      : %.2lf\n", student->courses[i]->numericGrade);
        printf("Letter Grade : %s\n", student->courses[i]->letterGrade);
        printf("----------------------------------\n");
    }

    printf("Student AVG : %.2lf", student->gpa);
}


double sinifOrtalamaHesapla(courses_t courseClass, int in_student)
{
    double avg = 0;
    int i;
    for (i = 0; i < in_student; i++)
    {
        avg += courseClass.students[i].gpa;
    }
    return avg / in_student;
}


void printClass(courses_t courseClass, int in_student)
{
    courseClass.courseAverage = sinifOrtalamaHesapla(courseClass, in_student);

    printf("\nClass Name   : %s\n", courseClass.courseName);
    printf("Class Code    : %s\n", courseClass.courseCode);
    printf("Class AVG : %.2lf\n", courseClass.courseAverage);
    printf("\nStudents >>\n");
    studentList(courseClass.students, in_student);
}


void displayCourseInfo(student_t students[], int in_student)
{
    printf("\nCourses >>\n");
    int i, j;
    for (i = 0; i < in_student; i++)
    {
        for (j = 0; j < COURSESREGISTERED; j++)
        {
            printf("Course Name : %s\n", students[i].courses[j]->courseName);
            printf("-----------------------------\n");
        }
    }
    char courseName[COURSENAMELENGTH];
    printf("Course Name: ");
    scanf("%s", courseName);

    printf("\nStudents >>\n\n");
    for (i = 0; i < in_student; i++)
    {
        for (j = 0; j < COURSESREGISTERED; j++)
        {
            if (students[i].courses[j]->courseName != NULL)
            {
                if (strcmp(students[i].courses[j]->courseName, courseName) == 0)
                {
                    printStudent2(students[i]);
                    printf("---------------------------\n");
                }
            }
        }
    }
}


void calculateCourseAverage(student_t students[], int in_student)
{
    printf("\nCourses >>\n");
    int i, j;
    for (i = 0; i < in_student; i++)
    {
        for (j = 0; j < COURSESREGISTERED; j++)
        {
            printf("Course Name : %s\n\n", students[i].courses[j]->courseName);

        }
    }
    char courseName[COURSENAMELENGTH];
    printf("Course Name: ");
    scanf("%s", courseName);

    int num = 0;
    double avg = 0;
    for (i = 0; i < in_student; i++)
    {
        for (j = 0; j < COURSESREGISTERED; j++)
        {
            if (students[i].courses[j]->courseName != NULL)
            {
                if (strcmp(students[i].courses[j]->courseName, courseName) == 0)
                {
                   avg += students[i].courses[j]->numericGrade;
                   num++;
                }
            }
        }
    }
    printf("Course AVG = %.2lf\n",(avg/num));
}


int main()
{

    courses_t courseClass;

    printf("Class Name : ");
    scanf("%s", courseClass.courseName);
    printf("Class Code : ");
    scanf("%s", courseClass.courseCode);

    int in_student = 0;

    while (1)
    {
        printf("\n");
        printf("1) Student Add\n");
        printf("2) Course Add\n");
        printf("3) Lecture notes of the student\n");
        printf("4) Student's Average\n");
        printf("5) Show Student Information\n");
        printf("6) Show Course Information\n");
        printf("7) Class Show\n");
        printf("8) Course Average\n");
        printf("0) Exit\n");
        printf("Choice : ");
        int choice;
        scanf("%d", &choice);
        switch (choice)
        {
        case 0:
            exit(0);
            break;
        case 1:
            addStudent(courseClass.students, &in_student);
            break;
        case 2:
            addCourse(courseClass.students, in_student);
            break;
        case 3:
            calculateStudentCourseGrade(courseClass.students, in_student);
            break;
        case 4:
            calculateStudentGPA(courseClass.students, in_student);
            break;
        case 5:
            displayStudentInfo(courseClass.students, in_student);
            break;
        case 6:
            displayCourseInfo(courseClass.students, in_student);
            break;
        case 7:
            printClass(courseClass, in_student);
            break;
        case 8:
            calculateCourseAverage(courseClass.students, in_student);
            break;
        default:
            printf("Wrong choice !!!\n");
            break;
        }
        printf("\n");
    }
}