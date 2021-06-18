import java.util.ArrayList;

public class Rastgele {

    public ArrayList<Integer> olustur(int olusturulacakSayiAdedi, int boyut){
        ArrayList<Integer> arrListControl = new ArrayList<>();
    	if(olusturulacakSayiAdedi <= boyut) {
	        for (int i=0; i < olusturulacakSayiAdedi; i++){
	            int tempRandom = (int)(Math.random() * boyut);
	            if (arrListControl.indexOf(tempRandom) == -1)   arrListControl.add(tempRandom); //yoksa ekliyor..!
	            else    i -= 1; //olusturulan sayi listede varsa sayaci bir azalt..! 
	        }
    	}
        return arrListControl;
    }
    
}