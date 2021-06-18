#include "header.h"
#include <cstdlib>
#include <ctime>
#include <fstream>
#include <iostream>
#include <set>
#include <string>
#include <vector>
#include <conio.h>
using namespace std;

Dictionary::Dictionary(){

};

Dictionary::Dictionary(char *fileName) {
  fstream dFile;
  string tmp;
  string buf;
  dFile.open(fileName, std::fstream::in);
  if (!dFile) {
    cout << "File open error!" << endl;
    exit(0);
  } else {
    dFile >> tmp;
    while (!dFile.eof()) {
      words.insert(tmp);
      dFile >> tmp;
    }
    dFile.close();

    for (set<string>::iterator iter = words.begin(); iter != words.end();
         ++iter) {
      buf = *iter;

      if (TestLegalSecretWord(buf)) {
        secrets.push_back(buf);
      }
    }
  }
};

Dictionary::~Dictionary(){};

string Dictionary::BringValidWord() {
  srand((int)time(0));
  int r = (rand() % secrets.size());
  return secrets[r];
}
bool Dictionary::TestLegalSecretWord(string word) {

  for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
      if (i != j && word[i] == word[j]) {
        return false;
      }
    }
  }
  return true;
}

bool Dictionary::IsWordValid(string word) {
  string buf;
  for (set<string>::iterator iter = words.begin(); iter != words.end();
       ++iter) {
    buf = *iter;
    if (word == buf) {
      return true;
    }
  }
  return false;
}

int Words::countofMatchLetters(string gs) {
  int cm = 0;
  string input = "";
  for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
      bool isIn = false;
      for (int x = 0; x < input.length(); x++) {
        if (gs[i] == input[x]) {
          isIn = true;
        }
      }
      if (gs[i] == secret[j] && !isIn) {
        input += gs[i];
        cm++;
      }
    }
  }
  return cm;
}

Words::Words() {
  numguesses = 0;
  cheated = false;
};
Words::~Words(){};

int Words::countofTruePlaceLetters(string gs) {
  int place = 0;
  for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
      if (i == j && gs[i] == secret[j]) {
        place++;
      }
    }
  }
  return place;
}

void Words::playgame(Words &) {
  string gs;
  char fileName[10] = "words.txt";
  Dictionary D(fileName);
  secret = D.BringValidWord();
  cout << "Bilbakalim Oyununa Hosgeldiniz: " << endl
       << "5 harften olusan bir kelime tuttum." << endl;
  cout << "Tahmininiz Nedir? ";
  cin >> gs;
  while (true) {
    if (gs.length() != 5 || !D.IsWordValid(gs) && gs != "xxxxx") {
      cout << "Bu kelime sozlukte yok!" << endl;
      cout << "Tahmininiz Nedir? ";
      cin >> gs;
      continue;
    }
    numguesses++;
    if (countofTruePlaceLetters(gs) == 5 && !cheated) {
      cout << "Bildiniz! " << numguesses
           << " tahminde dogru sonuca ulastiniz!\n";
	  getch();
      break;
    } else if (countofTruePlaceLetters(gs) == 5) {
      cout << "Bildiniz! " << numguesses
           << " tahminde ipucu kullanarak dogru sonuca ulastiniz!\n";
	  getch();
      break;
    }
    if (gs != "xxxxx" && countofTruePlaceLetters(gs) != 5) {
      cout << "Eslesen harflerin sayisi: " << countofMatchLetters(gs) << endl
           << "Eslesen harflerin dogru konumu: " << countofTruePlaceLetters(gs)
           << endl;
    } else if (gs == "xxxxx") {
      cout << "Ipucu: Gizli Kelime: " << secret << endl;
      cheated = true;
    }
    cout << "Tahmininiz Nedir? ";
    cin >> gs;
  }
}