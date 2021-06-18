import java.util.ArrayList;
import java.util.Collections;

public class Liste {
	
	public void listele(ArrayList<Soru> tempArrList) {
		Collections.sort(tempArrList);
		yazdir(tempArrList);
	}
	
	private void yazdir(ArrayList<Soru> tempArrList) {
		int sayac = 1;
		for (Soru soru : tempArrList) {
			System.out.println(sayac + ") " + soru.getSoruMetni());
			sayac++;
		}
	}
}