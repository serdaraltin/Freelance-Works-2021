#include<iostream>
#include<vector>
#include<set>
#include<string>
#include<fstream>
#include <cstdlib>
#include <ctime>
using namespace std;

class Dictionary {
private:
	bool TestLegalSecretWord(string word) {
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
	set<string> words; // set contains unique words
	vector<string> secrets; // vector contains secret words
public:
	Dictionary() {
		// Does nothing
	};

	Dictionary(char *filename) {
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
	~Dictionary() {
	// Does nothing
	};
	

	string BringValidWord() {
		/*Return a random word without repeated letters*/
		srand((int)time(0));
		int r = (rand() % secrets.size());
		return secrets[r];
	}

	bool IsWordValid(string word) {
		string buffer;
		/*Check if word is in Dictionary*/
		for (set<string>::iterator it = words.begin(); it != words.end(); ++it){
			buffer = *it;
			if (word == buffer) {
				return true;
			}
		}
		return false;
	}

};



class Words {
private:
	int numguesses; // track number of guesses used
	bool cheated; // flag set to true if cheat code is used
	string secret; // word to guess

	int countofMatchLetters(string guess)
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

	int countofTruePlaceLetters(string guess)
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
public:
	Words() {
		numguesses = 0;
		cheated = false;
	}; // Default Constructor
	~Words() {}; // destructor

	void playgame(Words &) {
		string guess;
		char filename[10] = "words.txt";
		Dictionary D(filename);
		//secret = D.BringValidWord();
		secret = "vogue";
		cout << secret << endl;
		cout << "Bilbakalim Oyununa Hosgeldiniz: "
			 << endl
			 << "5 harften olusan bir kelime tuttum."
			 << endl;
		cout << "Tahmininiz Nedir? ";
		cin >> guess;
		while (true)
		{	
			if (guess.length() != 5 || !D.IsWordValid(guess)) {
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
			else if(guess == "xxxxx"){
				cout << "Ipucu: Gizli Kelime: " << secret << endl;
				cheated = true;
			}
			cout << "Tahmininiz Nedir? ";
			cin >> guess;
		}

	}
	
};






int main() 
{	
	Words W;
	W.playgame(W);
	return 0;
}
