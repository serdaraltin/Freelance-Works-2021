
import java.util.ArrayList;

public class Ara {
	private ArrayList<Soru> sorularOutput = new ArrayList<Soru>();
	private ArrayList<BoslukDoldurmaSoru> arrBD = new ArrayList<BoslukDoldurmaSoru>();
	private ArrayList<CoktanSecmeliSoru> arrCS = new ArrayList<CoktanSecmeliSoru>();
	private ArrayList<DogruYanlisSoru> arrDY = new ArrayList<DogruYanlisSoru>();
	
	//methods
	private void cleaner() {
		sorularOutput.clear();
		arrBD.clear();
		arrCS.clear();
		arrDY.clear();
	}
	
	public ArrayList<Soru> soruMetniArama(ArrayList<Soru> sorularInput, String aramaMetni) {
		cleaner();
		for (Soru soru : sorularInput) {
			if (soru.getSoruMetni().contains(aramaMetni))	sorularOutput.add(soru);
		}
		return sorularOutput;
	}
	
	public ArrayList<Soru> secenekArama(ArrayList<Soru> sorularInput, String aramaMetni) {
		cleaner();
		for (Soru soru : sorularInput) {
			if (soru.getSoruCesidi() == 'c')	arrCS.add((CoktanSecmeliSoru)soru);
		}
		for (CoktanSecmeliSoru soru : arrCS) {
			if (soru.getSecenekler().contains(aramaMetni))	sorularOutput.add(soru);
		}
		return sorularOutput;
	}
	
	public ArrayList<Soru> cevapArama(ArrayList<Soru> sorularInput, String aramaMetni) {
		cleaner();
		for (Soru soru : sorularInput) {
			switch (soru.getSoruCesidi()) {
				case 'b':	arrBD.add((BoslukDoldurmaSoru)soru);	break;
				case 'c':	arrCS.add((CoktanSecmeliSoru)soru);	break;
				case 'd':	arrDY.add((DogruYanlisSoru)soru);	break;
			}
		}
		for (BoslukDoldurmaSoru soru : arrBD) {
			if(soru.getCevap().contains(aramaMetni))	sorularOutput.add((Soru)soru);
		}
		for (CoktanSecmeliSoru soru : arrCS) {
			if(soru.getCevap().contains(aramaMetni))	sorularOutput.add((Soru)soru);
		}
		for (DogruYanlisSoru soru : arrDY) {
			if(soru.getCevap().contains(aramaMetni))	sorularOutput.add((Soru)soru);
		}
		return sorularOutput;
	}
	
	public ArrayList<Soru> zorlukArama(ArrayList<Soru> sorularInput, String aramaMetni) {
		cleaner();
		for (Soru soru : sorularInput)
			if (soru.getZorluk().equalsIgnoreCase(aramaMetni))
				sorularOutput.add(soru);
		return sorularOutput;
	}
	
	public ArrayList<Soru> puanArama(ArrayList<Soru> sorularInput,  int puan) {
		cleaner();
		for (Soru soru : sorularInput)
			if (soru.getPuan() == puan)
				sorularOutput.add(soru);
		return sorularOutput;
	}
	
}
