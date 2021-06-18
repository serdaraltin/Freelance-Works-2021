#include <iostream>
#include <fstream>
#include <string>

//list len
#define MAX_DOCTOR 30
#define MAX_PATIENT 30

//file names
#define FILE_DOCTOR "doctor.dat"
#define FILE_PATIENT "patient.dat"

//namespace
using namespace std;

//super class

class Person {
private:
    //private field
    string secnum;
    string name, surname;
    int age;
    string phone, gender;

public:
    //class constructor 1 prototip
    Person();
    //class constructor 2
    Person(string secnum, string name, string surname, int age, string phone, string gender);
   //class destructor prototip
    ~Person();
    //class custum print method
    void printPerson();
    //getter
    int getAge() const {
        return age;
    }

    void setAge(int age) {
        this->age = age;
    }
    //getter
    string getGender() const {
        return gender;
    }
    //setter
    void setGender(string gender) {
        this->gender = gender;
    }
    //getter
    string getName() const {
        return name;
    }
    //setter
    void setName(string name) {
        this->name = name;
    }
    //getter
    string getPhone() const {
        return phone;
    }
    //setter
    void setPhone(string phone) {
        this->phone = phone;
    }
    //getter
    string getSecnum() const {
        return secnum;
    }
    //setter
    void setSecnum(string secnum) {
        this->secnum = secnum;
    }
    //getter
    string getSurname() const {
        return surname;
    }
    //setter
    void setSurname(string surname) {
        this->surname = surname;
    }
    //class friend operator method
    friend std::ostream &operator<<(std::ostream &os, const Person &obj) {
        os << "Security Num : " << obj.secnum << endl
                << "Name         : " << obj.name << endl
                << "Surname      : " << obj.surname << endl
                << "Age          : " << obj.age << endl
                << "Phone        : " << obj.phone << endl
                << "Gender       : " << obj.gender << endl;
        return os;
    }
};
//class person constructor 1
Person::Person() {
    this->secnum = "";
    this->name = "";
    this->surname = "";
    this->age = 0;
    this->phone = "";
    this->gender = "";
}
//super class constructor

Person::Person(string secnum, string name, string surname, int age, string phone, string gender) {
    this->secnum = secnum;
    this->name = name;
    this->surname = surname;
    this->age = age;
    this->phone = phone;
    this->gender = gender;
}
//super class destructor

Person::~Person() {
    //cout << "Delete is Person." << endl;
}
//super class cutom print Method

void Person::printPerson() {
    cout << "Security Num : " << secnum << endl;
    cout << "Name         : " << name << endl;
    cout << "Surname      : " << surname << endl;
    cout << "Age          : " << age << endl;
    cout << "Phone        : " << phone << endl;
    cout << "Gender       : " << gender << endl;
}
//Doctor class inherit Person class

class Doctor : public Person {
private:
    //private field
    int experience;

public:
    //class constructor 1
    Doctor() {

    }
    //class constructor 2
    Doctor(string secnum, string name, string surname, int age, string phone, string gender, int experience) : Person(secnum, name, surname, age, phone, gender), experience(experience) {

    }
   //class custom print prototip
    void printDoctor();
    //friend operator(method)

    friend std::ostream &operator<<(std::ostream &os, const Doctor &obj) {
        os << "Security Num : " << obj.getSecnum() << endl
                << "Name         : " << obj.getName() << endl
                << "Surname      : " << obj.getSurname() << endl
                << "Age          : " << obj.getAge() << endl
                << "Phone        : " << obj.getPhone() << endl
                << "Gender       : " << obj.getGender() << endl
                << "Experience   : " << obj.experience << endl
                << endl;
        return os;
    }
    //class destructor prototip
    ~Doctor();
    //getter
    int getExperience() const {
        return experience;
    }
    //setter
    void setExperience(int experience) {
        this->experience = experience;
    }
    //class custom string method

    string toString() {
        string sage = to_string(Person::getAge());
        string sexp = to_string(this->experience);
        return Person::getSecnum() + " "
                + Person::getName() + " "
                + Person::getSurname() + " "
                + sage + " "
                + Person::getPhone() + " "
                + Person::getGender() + " "
                + sexp
                ;
    }
};
//Doctor class destructor

Doctor::~Doctor() {
    // cout << "Delete is Doctor." << endl;
}
//Doctor class cutom print Method

void Doctor::printDoctor() {
    Person::printPerson();
    cout << "Experience   : " << this->experience << endl
            << endl;
}

//Patient class inherit Person class

class Patient : public Person {
private:
    //private field
    int numOfDay;
    int dailyWages;
    int treatmentFee;

public:
    //class constructor 1
    Patient() {

    }
    //class constructor 2
    Patient(string secnum, string name, string surname, int age, string phone, string gender, int numOfDay, float dailyWages, float treatmentFee) : Person(secnum, name, surname, age, phone, gender), numOfDay(numOfDay), dailyWages(dailyWages), treatmentFee(treatmentFee) {
    }
     //class custom print prototip
    void printPatient();
    //friend operator(method)
    friend std::ostream &operator<<(std::ostream &os, const Patient &obj) {
        os << "Security Num : " << obj.getSecnum() << endl
                << "Name         : " << obj.getName() << endl
                << "Surname      : " << obj.getSurname() << endl
                << "Age          : " << obj.getAge() << endl
                << "Phone        : " << obj.getPhone() << endl
                << "Gender       : " << obj.getGender() << endl
                << "Number of Da : " << obj.numOfDay << endl
                << "Daily Wages  : " << obj.dailyWages << endl
                << "Treatment Fee: " << obj.treatmentFee << endl
                << endl;
        return os;
    }
     //class destructor prototip
    ~Patient();
     //getter
    float getDailyWages() const {
        return dailyWages;
    }
    //setter
    void setDailyWages(float dailyWages) {
        this->dailyWages = dailyWages;
    }
     //getter
    int getNumOfDay() const {
        return numOfDay;
    }
     //setter
    void setNumOfDay(int numOfDay) {
        this->numOfDay = numOfDay;
    }
     //getter
    float getTreatmentFee() const {
        return treatmentFee;
    }
     //setter
    void setTreatmentFee(float treatmentFee) {
        this->treatmentFee = treatmentFee;
    }
    //class custom string method
    string toString() {
        string sage = to_string(Person::getAge());
        string snumOfDay = to_string(this->numOfDay);
        string sdailyWages = to_string(this->dailyWages);
        string streatmentFee = to_string(this->treatmentFee);
        return Person::getSecnum() + " "
                + Person::getName() + " "
                + Person::getSurname() + " "
                + sage + " "
                + Person::getPhone() + " "
                + Person::getGender() + " "
                + snumOfDay + " "
                + sdailyWages + " "
                + streatmentFee
                ;
    }
};
//Patient class destructor

Patient::~Patient() {
    //cout << "Delete is Patient." << endl;
}
//Patient class cutom print Method

void Patient::printPatient() {
    Person::printPerson();
    cout << "Number of Day: " << this->numOfDay << endl;
    cout << "Daily Wages  : " << this->dailyWages << endl;
    cout << "Treatment Fee: " << this->treatmentFee << endl
            << endl;
}

//lists
Doctor *doctors[MAX_DOCTOR];
Patient *patients[MAX_PATIENT];
//lists index
int countDoctor = 0, countPatient = 0;

//methos prototips
void menu();
void doctorMenu();
void patientMenu();
int checkDoctor(string secnum);
void listDoctor();
void addDoctor();
void updateDoctor();
void deleteDoctor();
int checkPatient(string secnum);
void listPatient();
void addPatient();
void updatePatient();
void deletePatient();

//temp field
string secnum;
string name, surname;
int age;
string phone, gender;
int experience;
int numOfDay;
float dailyWages;
float treatmentFee;
//file write method
void writeFileDoctor() {
    ofstream file;
    file.open(FILE_DOCTOR);
    int i;
    for (i = 0; i < countDoctor; i++) {
        if ((*doctors[i]).getSecnum() == "deleted")
            continue;
        file << (*doctors[i]).toString();
        if (i + 1 < countDoctor)
            file << "\n";
    }
    file.close();
}
//file read method
void readFileDoctor() {
    ifstream file;
    file.open(FILE_DOCTOR);
    if (!file) {
        return;
    }
    while (!file.eof()) {
        file >> secnum >> name >> surname >> age >> phone >> gender >> experience;
        doctors[countDoctor++] = new Doctor(secnum, name, surname, age, phone, gender, experience);
    }
    file.close();
}
//file write method
void writeFilePatient() {
    ofstream file;
    file.open(FILE_PATIENT);
    int i;
    for (i = 0; i < countPatient; i++) {
        if ((*patients[i]).getSecnum() == "deleted")
            continue;
        file << (*patients[i]).toString();
        if (i + 1 < countPatient)
            file << "\n";
    }
    file.close();
}
//file read method
void readFilePatient() {
    ifstream file;
    file.open(FILE_PATIENT);
    if (!file) {
        return;
    }
    while (!file.eof()) {
        file >> secnum >> name >> surname >> age >> phone >> gender >> numOfDay >> dailyWages >> treatmentFee;
        patients[countPatient++] = new Patient(secnum, name, surname, age, phone, gender, numOfDay, dailyWages, treatmentFee);
    }
    file.close();
}
//main method
int main() {
    readFileDoctor();
    readFilePatient();
    menu();
}
//main menu method
void menu() {
    cout << "1) Doctor Menu" << endl;
    cout << "2) Patient Menu" << endl;
    cout << "0) Exit" << endl;
    cout << "Choice : ";
    int choice;
    cin >> choice;

    switch (choice) {
        case 0:
            cout << "Exiting..." << endl;
            exit(0);
            break;
        case 1:
            doctorMenu();
            break;
        case 2:
            patientMenu();
            break;
        default:
            cout << "Wrong choice !" << endl;
            break;
    }
    cout << endl;
    menu();
}
//sub menu method
void doctorMenu() {
    cout << endl;
    cout << "1) List" << endl;
    cout << "2) Add" << endl;
    cout << "3) Update" << endl;
    cout << "4) Delete" << endl;
    cout << "0) Main Menu" << endl;
    cout << "Choice : ";
    int choice;
    cin >> choice;

    switch (choice) {
        case 0:
            return;
            break;
        case 1:
            listDoctor();
            break;
        case 2:
            addDoctor();
            break;
        case 3:
            updateDoctor();
            break;
        case 4:
            deleteDoctor();
            break;
        default:
            cout << "Wrong choice !" << endl;
            break;
    }
    cout << endl;
    doctorMenu();
}
//check doctor from security num method
int checkDoctor(string secnum) {
    int i;
    for (i = 0; i < countDoctor; i++) {
        if ((*doctors[i]).getSecnum() == secnum) {
            return i;
        }
    }
    return -1;
}
//list doctors method
void listDoctor() {
    cout << endl;
    int i;
    for (i = 0; i < countDoctor; i++) {
        if ((*doctors[i]).getSecnum() == "deleted")
            continue;
        cout << *doctors[i];
    }
}
//add doctor method
void addDoctor() {
    cout << endl;
    if (countDoctor >= MAX_DOCTOR - 1) {
        cout << "Capacity is full !" << endl;
        return;
    }

    cout << "Sec Num : ";
    cin >> secnum;
    if (checkDoctor(secnum) != -1) {
        cout << "Already exits !" << endl;
        return;
    }
    cout << "Name    : ";
    cin >> name;
    cout << "Surname : ";
    cin >> surname;
    cout << "Age     : ";
    cin >> age;
    cout << "Phone   : ";
    cin >> phone;
    cout << "Gender  : ";
    cin >> gender;
    cout << "Experience : ";
    cin >> experience;

    doctors[countDoctor++] = new Doctor(secnum, name, surname, age, phone, gender, experience);
    cout << "New doctor added." << endl;
    writeFileDoctor();
    return;
}
//update doctor method
void updateDoctor() {
    cout << endl;
    cout << "Sec Num : ";
    cin >> secnum;
    int index = checkDoctor(secnum);
    if (index == -1) {
        cout << "Not found !" << endl;
        return;
    }
    cout << "Available information" << endl << endl << *doctors[index] << endl << endl;
    cout << "Name    : ";
    cin >> name;
    cout << "Surname : ";
    cin >> surname;
    cout << "Age     : ";
    cin >> age;
    cout << "Phone   : ";
    cin >> phone;
    cout << "Gender  : ";
    cin >> gender;
    cout << "Experience : ";
    cin >> experience;
    (*doctors[index]).setName(name);
    (*doctors[index]).setSurname(surname);
    (*doctors[index]).setGender(gender);
    (*doctors[index]).setAge(age);
    (*doctors[index]).setPhone(phone);
    (*doctors[index]).setExperience(experience);
    cout << "Doctor updated." << endl;
    writeFileDoctor();
    return;
}
//delete doctor method
void deleteDoctor() {
    cout << endl;
    cout << "Sec Num : ";
    cin >> secnum;
    int index = checkDoctor(secnum);
    if (index == -1) {
        cout << "Not found !" << endl;
        return;
    }
    cout << "Available information" << endl << endl << *doctors[index] << endl;
    (*doctors[index]).setSecnum("deleted");
    cout << "Doctor deleted." << endl;
}
//sub menu method
void patientMenu() {
    cout << endl;
    cout << "1) List" << endl;
    cout << "2) Add" << endl;
    cout << "3) Update" << endl;
    cout << "4) Delete" << endl;
    cout << "0) Main Menu" << endl;
    cout << "Choice : ";
    int choice;
    cin >> choice;

    switch (choice) {
        case 0:
            return;
            break;
        case 1:
            listPatient();
            break;
        case 2:
            addPatient();
            break;
        case 3:
            updatePatient();
            break;
        case 4:
            deletePatient();
            break;
        default:
            cout << "Wrong choice !" << endl;
            break;
    }
    cout << endl;
    patientMenu();
}
//check patient from security num mehod
int checkPatient(string secnum) {
    int i;
    for (i = 0; i < countPatient; i++) {
        if ((*patients[i]).getSecnum() == secnum) {
            return i;
        }
    }
    return -1;

}
//list patients method
void listPatient() {
    cout << endl;
    int i;
    for (i = 0; i < countPatient; i++) {
        if ((*patients[i]).getSecnum() == "deleted")
            continue;
        cout << (*patients[i]);
    }
}
//add patient method method
void addPatient() {
    cout << endl;
    if (countPatient >= MAX_PATIENT - 1) {
        cout << "Capacity is full !" << endl;
        return;
    }
    cout << "Sec Num : ";
    cin >> secnum;
    if (checkPatient(secnum) != -1) {
        cout << "Already exits !" << endl;
        return;
    }

    cout << "Name    : ";
    cin >> name;
    cout << "Surname : ";
    cin >> surname;
    cout << "Age     : ";
    cin >> age;
    cout << "Phone   : ";
    cin >> phone;
    cout << "Gender  : ";
    cin >> gender;
    cout << "Num of Day    : ";
    cin >> numOfDay;
    cout << "Daily Wages   : ";
    cin >> dailyWages;
    cout << "Treatment Fee : ";
    cin >> treatmentFee;

    patients[countPatient++] = new Patient(secnum, name, surname, age, phone, gender, numOfDay, dailyWages, treatmentFee);
    cout << "New patient added." << endl;
    writeFilePatient();
    return;
}
//update patient method
void updatePatient() {
    cout << endl;
    cout << "Sec Num : ";
    cin >> secnum;
    int index = checkPatient(secnum);
    if (index == -1) {
        cout << "Not found !" << endl;
        return;
    }
    cout << "Available information" << endl << endl << *patients[index] << endl << endl;
    cout << "Name    : ";
    cin >> name;
    cout << "Surname : ";
    cin >> surname;
    cout << "Age     : ";
    cin >> age;
    cout << "Phone   : ";
    cin >> phone;
    cout << "Gender  : ";
    cin >> gender;
    cout << "Num of Day    : ";
    cin >> numOfDay;
    cout << "Daily Wages   : ";
    cin >> dailyWages;
    cout << "Treatment Fee : ";
    cin >> treatmentFee;
    (*patients[index]).setName(name);
    (*patients[index]).setSurname(surname);
    (*patients[index]).setGender(gender);
    (*patients[index]).setAge(age);
    (*patients[index]).setPhone(phone);
    (*patients[index]).setNumOfDay(numOfDay);
    (*patients[index]).setDailyWages(dailyWages);
    (*patients[index]).setTreatmentFee(treatmentFee);
    cout << "Patient updated." << endl;
    writeFilePatient();
    return;
}
//delete patient method
void deletePatient() {
    cout << endl;
    cout << "Sec Num : ";
    cin >> secnum;
    int index = checkPatient(secnum);
    if (index == -1) {
        cout << "Not found !" << endl;
        return;
    }
    cout << "Available information" << endl << endl << *patients[index] << endl;
    (*patients[index]).setSecnum("deleted");
    cout << "Patient deleted." << endl;
}