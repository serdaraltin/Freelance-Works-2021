#include <cstdio>
#include <cstdlib>
#include <fstream>
#include <iostream>
#include <string.h>
#include <string>

using namespace std;

int arama = 0;

struct ogrenci {
  int ogrno;
  char ad[30];
  char soyad[30];

  struct ogrenci *left, *right;
};
typedef struct ogrenci Ogrenci;

//+
void YazdirOgrenci(Ogrenci *ogrenci) {
  cout << ogrenci->ogrno << " " << ogrenci->ad << " " << ogrenci->soyad
       << endl;
}

//+
Ogrenci *yeniDugum(int ogrno, char ad[], char soyad[]) {
  Ogrenci *temp = (Ogrenci *)malloc(sizeof(Ogrenci));
  temp->ogrno = ogrno;

  strcpy(temp->ad, ad);
  strcpy(temp->soyad, soyad);
  temp->left = temp->right = NULL;
  return temp;
}

//+
Ogrenci *dugumEkle(Ogrenci *root, int ogrno, char ad[], char soyad[]) {
  if (root == NULL)
    return yeniDugum(ogrno, ad, soyad);

  if (ogrno < root->ogrno)
    root->left = dugumEkle(root->left, ogrno, ad, soyad);
  else
    root->right = dugumEkle(root->right, ogrno, ad, soyad);

  return root;
}

//+
Ogrenci *minValueNode(Ogrenci *root) {
  Ogrenci *current = root;

  while (current && current->left != NULL)
    current = current->left;

  return current;
}

//+
Ogrenci *dugumSil(Ogrenci *root, int ogrno) {
  if (root == NULL)
    return root;

  if (ogrno < root->ogrno) {
    root->left = dugumSil(root->left, ogrno);
  } else if (ogrno > root->ogrno) {
    root->right = dugumSil(root->right, ogrno);
  } else {
    if (root->left == NULL) {
      Ogrenci *temp = root->right;
      free(root);
      return temp;
    } else if (root->right == NULL) {
      Ogrenci *temp = root->left;
      free(root);
      return temp;
    }

    Ogrenci *temp = minValueNode(root->right);
    root->ogrno = temp->ogrno;
    root->right = dugumSil(root->right, temp->ogrno);
  }
  return root;
}

//+
void inorderTara(Ogrenci *root) {
  if (root != NULL) {
    inorderTara(root->left);
    YazdirOgrenci(root);
    inorderTara(root->right);
  }
}

//+
void preorderTara(Ogrenci *root) {
  if (root != NULL) {
    YazdirOgrenci(root);
    inorderTara(root->left);
    inorderTara(root->right);
  }
}

//+
void postorderTara(Ogrenci *root) {
  if (root != NULL) {
    inorderTara(root->left);
    inorderTara(root->right);
    YazdirOgrenci(root);
  }
}

//+
void agacKur(Ogrenci **root, string dosya) {
  char ogrno[15], ad[30], soyad[30], satirAl[75];
  char *ptr;
  
  ifstream dosya1(dosya, ios::in);
  dosya1.getline(satirAl, 75);
  
  for (int i = 0; i < 75; i++) {
    if (satirAl[i] == '\r')
      satirAl[i] = '\0';
  }
  while (dosya1) {
    ptr = strtok(satirAl, "\t");
    int j = 0;
    while (ptr != NULL) {
      if (j == 0)
        strcpy(ogrno, ptr);
      if (j == 1)
        strcpy(ad, ptr);
      if (j == 2)
        strcpy(soyad, ptr);
      if (j == 3) {
        strcat(ad, " ");
        strcat(ad, soyad);
        strcpy(soyad, ptr);
      }
      ptr = strtok(NULL, " ");
      j++;
    }

	
    *root = dugumEkle(*root, atoi(ogrno), ad, soyad);

    dosya1.getline(satirAl, 75);
    for (int i = 0; i < 75; i++) {
      if (satirAl[i] == '\r')
        satirAl[i] = '\0';
    }
  }
  dosya1.close();
}

//+
void dosyayaYaz(Ogrenci *root, char dosyaAdi[]) {
  if (root != NULL) {
    dosyayaYaz(root->left, dosyaAdi);
    FILE *dosya;
    dosya = fopen(dosyaAdi, "a");
    fprintf(dosya, "%d %s %s\n", root->ogrno, root->ad, root->soyad);
    fclose(dosya);
    dosyayaYaz(root->right, dosyaAdi);
  }
}

//+
void ilkDerinlikAra(Ogrenci *root, int ogrno) {
  if (root != NULL) {
    ilkDerinlikAra(root->left, ogrno);
    if (root->ogrno == ogrno) {
      YazdirOgrenci(root);
      arama = 1;
    }
    ilkDerinlikAra(root->right, ogrno);
  }

}

//+
void ilkGenislikAra(Ogrenci *root, int ogrno) {
  if (root != NULL) {
    ilkDerinlikAra(root->right, ogrno);
    if (root->ogrno == ogrno) {
      YazdirOgrenci(root);
      arama = 1;
    }
    ilkDerinlikAra(root->left, ogrno);
  }

}

void Menu();
void AramaYap();
void Listele();
void DosyaYaz();
void ogrenciSil();

Ogrenci *liste1 = NULL;
Ogrenci *liste2 = NULL;
Ogrenci *liste3 = NULL;

int main() {
	setlocale(LC_ALL, "Turkish");
  agacKur(&liste1, "data1.txt");
  agacKur(&liste2, "data2.txt");
  agacKur(&liste3, "data3.txt");

  Menu();
  return 0;
}

//+
void Menu() {
  cout << "Asagidaki islemlerden birini seciniz..." << endl;
  cout << "Arama yapmak icin: A" << endl;
  cout << "Listeyi ekrana yazdirmak icin: L" << endl;
  cout << "Ogrenci silmek icin: S" << endl;
  cout << "Dosyaya yazmak icin: Y" << endl;
  cout << "Cikis icin: C" << endl;
  char secim;
  cin >> secim;
  cout << endl;

  switch (secim) {
  case 'C':
    exit(0);
    break;
  case 'A':
    AramaYap();
    break;
  case 'L':
    Listele();
    break;
  case 'S':
    ogrenciSil();
    break;
  case 'Y':
    DosyaYaz();
    break;
  default:
    cout << "Hatali secim !" << endl << endl;
    break;
  }
  cout << endl << endl;
  Menu();
}

void AramaYap() {

  cout << "Hangi dosya icin arama yapmak istiyorsunuz?..." << endl;
  cout << "data1.txt icin: 1" << endl;
  cout << "data2.txt icin: 2" << endl;
  cout << "data3.txt icin: 3" << endl;
  cout << "Seciminizi giriniz:";
  int dosyaSecim;
  cin >> dosyaSecim;
  Ogrenci *gecici;
  switch (dosyaSecim) {
  case 1:
    gecici = liste1;
    break;
  case 2:
    gecici = liste2;
    break;
  case 3:
    gecici = liste3;
    break;
  default:
    cout << "Hatali secim !" << endl << endl;
    return;
  }
  char ogrno[15];
  cout << endl << "Ogrenci numarasini giriniz:";
  cin >> ogrno;
  cout << endl << "Ilk derinlik aramak icin: I" << endl;
  cout << "Ilk genislik aramak icin: G" << endl;
  char aramaTur;
  cin >> aramaTur;
  arama = 0;
  switch (aramaTur) {
  case 'I':
    ilkDerinlikAra(gecici, atoi(ogrno));
    break;
  case 'G':
    ilkDerinlikAra(gecici, atoi(ogrno));
    break;
  }
  if (arama == 0) {
    cout << "Ogrenci bulunamadi !!!" << endl;
  }
}

//+
void Listele() {
  cout << "Preorder listeleme yapmak icin: R" << endl;
  cout << "Inorder listeleme yapmak icin: I" << endl;
  cout << "Postorder listeleme yapmak icin: O" << endl;
  cout << "Seciminizi giriniz:";
  char secim;
  cin >> secim;
  cout << endl;

  int dosyaSecim;

  if (!(secim == 'R' || secim == 'I' || secim == 'O')) {
    cout << "Hatali secim !" << endl << endl;
    return;
  }
  cout << "Hangi dosya icin inorderTara listeleme yapmak istiyorsunuz?..."
       << endl;
  cout << "data1.txt icin: 1" << endl;
  cout << "data2.txt icin: 2" << endl;
  cout << "data3.txt icin: 3" << endl;
  cout << "Seciminizi giriniz:";
  cin >> dosyaSecim;
  Ogrenci *gecici;
  switch (dosyaSecim) {
  case 1:
    gecici = liste1;
    break;
  case 2:
    gecici = liste2;
    break;
  case 3:
    gecici = liste3;
    break;
  default:
    cout << "Hatali secim !" << endl << endl;
    return;
  }
  switch (secim) {
  case 'R':
    preorderTara(gecici);
    break;
  case 'I':
    inorderTara(gecici);
    break;
  case 'O':
    postorderTara(gecici);
    break;
  }
}

//+
void ogrenciSil() {

  cout << "Hangi dosya icin silme yapmak istiyorsunuz?..." << endl;
  cout << "data1.txt icin: 1" << endl;
  cout << "data2.txt icin: 2" << endl;
  cout << "data3.txt icin: 3" << endl;
  cout << "Seciminizi giriniz:";
  int dosyaSecim;
  cin >> dosyaSecim;
  Ogrenci *gecici;
  switch (dosyaSecim) {
  case 1:
    gecici = liste1;
    break;
  case 2:
    gecici = liste2;
    break;
  case 3:
    gecici = liste3;
    break;
  default:
    cout << "Hatali secim !" << endl << endl;
    return;
  }
  char ogrno[15];
  cout << "Ogrenci numarasini giriniz:";
  cin >> ogrno;
  gecici = dugumSil(gecici, atoi(ogrno));
}

//+
void DosyaYaz() {
  cout << "Hangi dosyayi yazmak istiyorsunuz?..." << endl;
  cout << "data1.txt icin: 1" << endl;
  cout << "data2.txt icin: 2" << endl;
  cout << "data3.txt icin: 3" << endl;
  cout << "Seciminizi giriniz:";
  int dosyaSecim;
  cin >> dosyaSecim;
  Ogrenci *gecici;
  char dosyaAdi[20];
  switch (dosyaSecim) {
  case 1:
    gecici = liste1;
    strcpy(dosyaAdi, "data1.txt");
    break;
  case 2:
    gecici = liste2;
    strcpy(dosyaAdi, "data1.txt");
    break;
  case 3:
    gecici = liste3;
    strcpy(dosyaAdi, "data1.txt");
    break;
  default:
    cout << "Hatali secim !" << endl << endl;
    return;
  }
  FILE *dosya;
  dosya = fopen(dosyaAdi, "w");

  fclose(dosya);
  dosyayaYaz(gecici, dosyaAdi);
}
