
public class BoslukDoldurmaSoru extends Soru{
	
	public String cevap;
	
	public BoslukDoldurmaSoru(String soruMetni, int zorluk, String cevap) {
		super(soruMetni, zorluk, 'b');	//b = bosluk doldurma
		this.cevap = cevap;
	}
	
	public String getCevap() {
		return this.cevap;
	}

}
