package main;
import java.util.Scanner;

public abstract class OdevApplication{

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		//getting the input values
		Scanner scanner = new Scanner(System.in);
		System.out.println("Lütfen 1. metni giriniz:");
		String p1 = scanner.nextLine();
		System.out.println("Lütfen 2. metni giriniz:");
		String p2 = scanner.nextLine();
		System.out.println("Lütfen 3. metni giriniz:");
		String p3 = scanner.nextLine();
		
		MyList<String> p1Tokens= new MyList<String>();//creating my list objects for tokenized versions
		p1Tokens.tokenizeValues(p1);
		
		MyList<String> p2Tokens= new MyList<String>();
		p2Tokens.tokenizeValues(p2);
		
		MyList<String> p3Tokens= new MyList<String>();
		p3Tokens.tokenizeValues(p3);
		
		System.out.println("Toplam girilen sözcük: "+(p1Tokens.size()+p2Tokens.size()+p3Tokens.size()));
		//simply out the size of whole tokens
		MyHashSet<String> hashSet=new MyHashSet<String>();
		hashSet.addPTokens(p1Tokens.a,p2Tokens.a,p3Tokens.a);
		//adding tokens to the hashset
		System.out.println("Farklı sözcük adedi: "+hashSet.size());
		//simply out the size of whole unique tokens
		GetFreq<String,Integer> freq=new GetFreq<String,Integer>();
		freq.freqs(p1Tokens.a,p2Tokens.a, p3Tokens.a, hashSet);
		//gettig frequences of every unique token in the set
		System.out.println(freq.keySet().toString());
		//simpyle out every key in the set
		freq.showValues();
		//showing the final values
		
		
	}

}
