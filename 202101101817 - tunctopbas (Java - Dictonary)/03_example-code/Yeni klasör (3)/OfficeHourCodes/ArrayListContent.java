package week10;

import java.util.ArrayList;

public class ArrayListContent {

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Bob"); 
		names.add(0, "Ann"); 
		names.remove(1); 
		names.add("Cal"); 

		for(int i=0; i<names.size(); i++) {
			System.out.println(names.get(i));
		}

	}

}
