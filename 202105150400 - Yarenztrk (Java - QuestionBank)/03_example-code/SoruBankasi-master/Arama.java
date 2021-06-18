
import java.util.ArrayList;

public class Arama {
	private ArrayList<Soru> sorularOutput = new ArrayList<Soru>();
	private ArrayList<SoruBoslukDoldurma> arrBD = new ArrayList<SoruBoslukDoldurma>();
	private ArrayList<SoruCoktanSecmeli> arrCS = new ArrayList<SoruCoktanSecmeli>();
	private ArrayList<SoruDogruYanlis> arrDY = new ArrayList<SoruDogruYanlis>();
	
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
			if (soru.getSoruCesidi() == 'c')	arrCS.add((SoruCoktanSecmeli)soru);
		}
		for (SoruCoktanSecmeli soru : arrCS) {
			if (soru.getSecenekler().contains(aramaMetni))	sorularOutput.add(soru);
		}
		return sorularOutput;
	}
	
	public ArrayList<Soru> cevapArama(ArrayList<Soru> sorularInput, String aramaMetni) {
		cleaner();
		for (Soru soru : sorularInput) {
			switch (soru.getSoruCesidi()) {
				case 'b':	arrBD.add((SoruBoslukDoldurma)soru);	break;
				case 'c':	arrCS.add((SoruCoktanSecmeli)soru);	break;
				case 'd':	arrDY.add((SoruDogruYanlis)soru);	break;
			}
		}
		for (SoruBoslukDoldurma soru : arrBD) {
			if(soru.getCevap().contains(aramaMetni))	sorularOutput.add((Soru)soru);
		}
		for (SoruCoktanSecmeli soru : arrCS) {
			if(soru.getCevap().contains(aramaMetni))	sorularOutput.add((Soru)soru);
		}
		for (SoruDogruYanlis soru : arrDY) {
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
