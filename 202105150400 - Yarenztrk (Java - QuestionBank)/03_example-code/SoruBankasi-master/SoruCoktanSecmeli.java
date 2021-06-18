public class SoruCoktanSecmeli extends Soru{
	
	private String secenekler;
	private String cevap;

	
	public SoruCoktanSecmeli(String soruMetni, int zorluk, String secenekler, String cevap) {
		super(soruMetni, zorluk, 'c');	//c = coktan secmeli
		this.secenekler = secenekler;
		this.cevap = cevap;
	}
	
	public String getSecenekler() {
		return this.secenekler;
	}
	
	public String getCevap() {
		return this.cevap;
	}
	
}
