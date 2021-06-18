#include<iostream>
#include<fstream>
#include<string.h>

using namespace std;

int main(){
	char ogrno[15],ad[30],soyad[30],satirAl[75];
	char *ptr;
	ifstream dosya1("data1.txt");			//ifstream ile "data1.txt" dosyasını okumak için dosyayı açma
	dosya1.getline(satirAl,75);			
	for(int i=0;i<75;i++){				//satır sonundaki '\r' karakterini, '\0' karakteri ile değiştirme
		if(satirAl[i]=='\r')	
			satirAl[i]='\0';
		}
	while(dosya1){					//while döngüsü içinde dosyayı sonuna kadar satır satır okuma ve okunan satırları boşluklara göre parçalayıp, 
		ptr=strtok(satirAl,"\t");		//	j sayacının değerine göre değişkenlere atama
		int j=0;
		while(ptr!=NULL){
			if(j==0)
				strcpy(ogrno,ptr);
			if(j==1)
				strcpy(ad,ptr);
			if(j==2)
				strcpy(soyad,ptr);
			if(j==3){			//bir ad ve bir soyad okunmasına rağmen satır sonu gelmedi ise öğrencinin iki adı var demektir,
				strcat(ad," ");		//	bu iki ad arada bir boşluk bırakılarak öğrenci değişkenine atanır ve soyadı tekrar okunur
				strcat(ad,soyad);
				strcpy(soyad,ptr);
				}
			ptr=strtok(NULL," ");						
			j++;
			}
		//ekle(&kok1,ogrno,ad,soyad);
		cout << ogrno << "--" << ad << "--" << soyad << endl;
		dosya1.getline(satirAl,75);
		for(int i=0;i<75;i++){
			if(satirAl[i]=='\r')	
				satirAl[i]='\0';
			}
		}
	dosya1.close();
	return 0;
}
	