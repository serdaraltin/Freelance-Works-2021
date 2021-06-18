public class SoruDogruYanlis extends Soru{
	
	private String cevap;

	public SoruDogruYanlis(String soruMetni, int zorluk, String cevap) {
		super(soruMetni, zorluk, 'd');	//d = dogru yanlis
		this.cevap = cevap;
	}
	
	public String getCevap() {
		return this.cevap;
	}
}
