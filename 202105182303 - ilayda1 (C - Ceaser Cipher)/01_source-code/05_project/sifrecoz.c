#include <stdio.h>
#include <string.h>

#define UST_SINIR 256

int sayiKontrol(char sayi[]){
	int i = 0;
	
	if(sayi[0] == '-')
		i=1;
	
	for(; sayi[i] != 0; i++){
		if(!isdigit(sayi[i])){
			return 0;
		}
	}
	return 1;
}

int main(int argc, char *argv[]){
	char metin[UST_SINIR] = "";
	int anahtar,i=0;
	
	if(argc == 1 || argc > 2){
		printf("Kullanim sekli : sifrecoz sayi\n");
		return 0;
	}
	else if(argc == 2 && !sayiKontrol(argv[1])){
		printf("Kullanim sekli : sifrecoz sayi\n");
		return 0;
	}

	anahtar = atoi(argv[1]);
	printf("\nSifreli cumle giriniz  : ");
	
	fgets(metin, UST_SINIR, stdin);

	for(i=1; i<argc-1; i++){
		strcat(metin,argv[i]);
		if(i+1<argc-1)
			strcat(metin," ");
	}

	for(i=0; metin[i] != '\0'; i++){
		//65-90 97-122
		
		
			
		if(metin[i] >= 65 && metin[i] <=90){
			metin[i] = (metin[i]-65) -anahtar % 26 + 65;
			if(metin[i] < 65){
				metin[i]+=26;
			}
		}
		else if(metin[i] >= 97 && metin[i] <=122){
			//printf("%d\n",26-(metin[i]-97) -anahtar % 26);
			metin[i] = (metin[i]-97) -anahtar % 26 + 97;
			if(metin[i] < 97){
				metin[i]+=26;
			}
		}
		
	}
	
	printf("\nSifresi cozulmus cumle : %s\n",metin,anahtar);
}
