import java.io.Serializable;

public class Soru implements Serializable, Comparable<Soru>{

	private char soruCesidi;
	private String soruMetni;
	//puanlar zorluga gore belirleniyor, kolay -> 10p, normal -> 20p, zor -> 40p
	private int puan;
	private int zorluk;	
	
	
	public Soru(String soruMetni, int zorluk, char soruCesidi) {
		this.soruMetni = soruMetni;
		this.zorluk = zorluk;
		this.puan = setPuan();
		this.soruCesidi = soruCesidi;
	}
	
	private int setPuan() {	//puanlar zorluga gore belirleniyor, kolay -> 10p, normal -> 20p, zor -> 40p
		switch (this.zorluk) {
			case 1:	return 10;
			case 2:	return 20;
			case 3:	return 40;
			default:	return -1;
		}
	}
	
	public int getPuan() {
		return this.puan;
	}
	
	public String getSoruMetni() {
		return this.soruMetni;
	}
	
	public String getZorluk() {
		switch (this.zorluk) {
		case 1:	return "kolay";
		case 2: return "normal";
		case 3: return "zor";
		default:	return "hata";
		}
	}
		
	public char getSoruCesidi() {
		return this.soruCesidi;
	}

	@Override
	public int compareTo(Soru o) {
		if (this.puan < o.puan)	return -1;
		if (this.puan > o.puan)	return 1;
		return 0;
	}


	
}
