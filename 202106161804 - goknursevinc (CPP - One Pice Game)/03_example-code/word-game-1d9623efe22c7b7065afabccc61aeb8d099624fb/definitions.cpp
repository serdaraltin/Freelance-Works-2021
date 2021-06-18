#include<iostream>
#include<vector>
#include<set>
#include<string>
#include<fstream>
#include <cstdlib>
#include <ctime>
#include "header.h"
using namespace std;

// Dictionary Class Definitions STARTS
Dictionary::Dictionary() {
	// Does nothing
};

Dictionary::Dictionary(char *filename) {
	/*Open file, assign all words into set<string> words START*/
	fstream dataFile;
	string temp;
	string buffer;
	dataFile.open(filename, std::fstream::in);
	if (!dataFile)
	{
		cout << "File open error!" << endl;
		exit(0);
	}
	else
	{
		dataFile >> temp;
		while (!dataFile.eof()) {
			words.insert(temp);
			dataFile >> temp;
		}
	dataFile.close();
		/*Open file, assign all words into set<string> words DONE*/
		/* Assign secret words from set to vector */
		for (set<string>::iterator it = words.begin(); it != words.end(); ++it)
		{
			buffer = *it;

			if (TestLegalSecretWord(buffer)) {
				secrets.push_back(buffer);
			}
		}
	}
};
Dictionary::~Dictionary() {
	// Does nothing
};
bool Dictionary::TestLegalSecretWord(string word) {
	/*Test if nth word has only unique letters*/
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			if (i != j && word[i] == word[j]) {
				return false;
			}
		}
	}
	return true;
}

string Dictionary::BringValidWord() {
	/*Return a random word without repeated letters*/
	srand((int)time(0));
	int r = (rand() % secrets.size());
	return secrets[r];
}

bool Dictionary::IsWordValid(string word) {
	string buffer;
	/*Check if word is in Dictionary*/
	for (set<string>::iterator it = words.begin(); it != words.end(); ++it) {
		buffer = *it;
		if (word == buffer) {
			return true;
		}
	}
	return false;
}
// Dictionary Class Definitions ENDS

// Words Class Definitions STARTS
	int Words::countofMatchLetters(string guess)
	{
		/* Find common letters in any order */
		int common = 0;
		string scanned = "";
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bool isIn = false;
				for (int x = 0; x < scanned.length(); x++) {
					if (guess[i] == scanned[x]) {
						isIn = true;
					}
				}
				if (guess[i] == secret[j] && !isIn) {
					scanned += guess[i];
					common++;
				}
			}
		}
		return common;
	}


	Words::Words() {
		numguesses = 0;
		cheated = false;
	}; // Default Constructor
	Words::~Words() {}; // destructor

	int Words::countofTruePlaceLetters(string guess)
	{
		/* Find common letters in place */
		int tplace = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == j && guess[i] == secret[j]) {
					tplace++;
				}
			}
		}
		return tplace;
	}

	void Words::playgame(Words &) {
		string guess;
		char filename[10] = "words.txt";
		Dictionary D(filename);
		secret = D.BringValidWord();
		cout << "Bilbakalim Oyununa Hosgeldiniz: "
			<< endl
			<< "5 harften olusan bir kelime tuttum."
			<< endl;
		cout << "Tahmininiz Nedir? ";
		cin >> guess;
		while (true)
		{
			if (guess.length() != 5 || !D.IsWordValid(guess) && guess != "xxxxx") {
				cout << "Bu kelime sozlukte yok!" << endl;
				cout << "Tahmininiz Nedir? ";
				cin >> guess;
				continue;
			}
			numguesses++;
			if (countofTruePlaceLetters(guess) == 5 && !cheated) {
				cout << "Bildiniz! " << numguesses << " tahminde dogru sonuca ulastiniz!";
				break;
			}
			else if (countofTruePlaceLetters(guess) == 5) {
				cout << "Bildiniz! " << numguesses << " tahminde ipucu kullanarak dogru sonuca ulastiniz!";
				break;
			}
			if (guess != "xxxxx" && countofTruePlaceLetters(guess) != 5) {
				cout << "Eslesen harflerin sayisi: " << countofMatchLetters(guess)
					<< endl
					<< "Eslesen harflerin dogru konumu: " << countofTruePlaceLetters(guess) << endl;
			}
			else if (guess == "xxxxx") {
				cout << "Ipucu: Gizli Kelime: " << secret << endl;
				cheated = true;
			}
			cout << "Tahmininiz Nedir? ";
			cin >> guess;
		}

	}
// Words Class Definitions ENDS


