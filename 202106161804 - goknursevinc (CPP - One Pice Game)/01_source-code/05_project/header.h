#ifndef HEADER_H
#define HEADER_H
#include<iostream>
#include<vector>
#include<set>
#include<string>
#include<fstream>
#include <cstdlib>
#include <ctime>

using namespace std;
class Dictionary {
public:
	Dictionary();
	Dictionary(char *fileName);
	~Dictionary();
	string BringValidWord();
	bool IsWordValid(string word);
private:
	bool TestLegalSecretWord(string word);
	set<string> words;
	vector<string> secrets;
};


class Words {
public:
	Words();
	~Words();
	void playgame(Words &);
private:
	int countofMatchLetters(string);
	int countofTruePlaceLetters(string);
	int numguesses;
	bool cheated;
	string secret;
};
#endif
