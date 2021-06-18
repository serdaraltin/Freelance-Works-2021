package week10;

import java.util.Scanner;

public class CardOpenStatus {
	
	public static void main(String[] args) {
		
		openCards();
		
	}
	
	

	private static void openCards() {
	
		int[] cardStatus = {0, 0, 0, 0, 0, 0};
		

		
		boolean flag = true;
		
		Scanner  in = new Scanner(System.in);
		
		while(flag) {
			
			System.out.println("Enter card number : ");
			int cardNo = in.nextInt();
			
			if(cardNo <1 || cardNo >6) {
				System.out.println("Please enter valid card.");
				continue;
			}
			
			cardStatus[cardNo-1] = 1;
			
			for(int crdNum:cardStatus) {
				
				if(crdNum == 0) {
					System.out.printf("%d card no is closed.", crdNum);
				}
				else if(crdNum == 1) {
					System.out.printf("%d card no is opened.", crdNum);
				}
				
				System.out.println();
				
			}
			
			boolean allCardsOpen = true;
			
			for(int crdNum:cardStatus) {
				if(crdNum == 0) {
					allCardsOpen = false;
				}
			}
			
			if(allCardsOpen) {
				System.out.println("All Card is opened");
				flag = false;
			}
			
			
			
		}
		
	}

}
