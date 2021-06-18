
public class SoruBoslukDoldurma extends Soru{
	
	public String cevap;
	
	public SoruBoslukDoldurma(String soruMetni, int zorluk, String cevap) {
		super(soruMetni, zorluk, 'b');	//b = bosluk doldurma
		this.cevap = cevap;
	}
	
	public String getCevap() {
		return this.cevap;
	}

}
