#include <cstdlib>
#include <ctime>
#include <fstream>
#include <iostream>
#include <set>
#include <string>
#include <vector>
using namespace std;

class Dictionary {
private:
  bool TestLegalSecretWord(string word) {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (i != j && word[i] == word[j]) {
          return false;
        }
      }
    }
    return true;
  }
  set<string> words;
  vector<string> secrets;

public:
  Dictionary(){};

  Dictionary(char *fileName) {
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
      for (set<string>::iterator iter = words.begin(); iter != words.end();
           ++iter) {
        buf = *iter;

        if (TestLegalSecretWord(buf)) {
          secrets.push_back(buf);
        }
      }
    }
  };

  bool IsWordValid(string word) {
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

  string BringValidWord() {
    srand((int)time(0));
    int r = (rand() % secrets.size());
    return secrets[r];
  }

  ~Dictionary(){};
};

class Words {
private:
  int numguesses;
  bool cheated;
  string secret;

  int countofTruePlaceLetters(string gs) {
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

  int countofMatchLetters(string gs) {
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

public:
  Words() {
    numguesses = 0;
    cheated = false;
  };

  void playgame(Words &) {

  }

  ~Words(){};
};
