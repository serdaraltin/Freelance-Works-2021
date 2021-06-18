package week8;

import java.util.Scanner;

public class PriceCalculator {

	public static void main(String[] args) {

		System.out.print("Enter Engine Type:");
		Scanner sc = new Scanner(System.in);
		int engineType = sc.nextInt();

		System.out.print("Enter Production Cost:");
		double productionCost = sc.nextDouble();
		
		System.out.println();
		System.out.println();
		System.out.println("************************************************************************************");
		System.out.println("*                  ANNUALLY AMOUNT TABLE FOR THE CAR                               *");
		System.out.println("************************************************************************************");
		System.out.println("*==Month==Production Cost=====Profit=====OTV==========KDV=======Price Of the Car===*");
		for (int i = 1; i <= 12; i++) {
			double profitRatio = getProfiftRatio(i);
			double profit = productionCost * profitRatio;
			double batAmount = productionCost + profit;
			double OTVAmount = getOTVAmount(engineType, batAmount);
			double batKDV = batAmount + OTVAmount;
			double KDVAmount = getKDVAmount(engineType, batKDV);
			double carPrice = batKDV + KDVAmount;
			
			System.out.printf("*%4d        %.2f      %.2f     %.2f     %.2f    %.2f   *\n",
					i, productionCost, profit, OTVAmount, KDVAmount, carPrice);
		}
		
		System.out.println("************************************************************************************");

		sc.close();

	}
	

	private static double getKDVAmount(int engineType, double batAmount) {
		
		double KDVAmount = 0;
	
		if(engineType<1600 && batAmount<85000) {
			KDVAmount = batAmount * 0.1;
			
		}
		else if(engineType<1600 && batAmount<130000) {
			KDVAmount = batAmount * 0.12;
		}
		else if(engineType<1600) {
			KDVAmount = batAmount * 0.18;
		}	
		else if(engineType<2000 && batAmount<170000) {
			KDVAmount = batAmount * 0.18;
			
		}
		else if(engineType<2000) {
			KDVAmount = batAmount * 0.20;
		}
		else if(engineType>=2000) {
			KDVAmount = batAmount * 0.24;
		}
		
		return KDVAmount;
	}

	private static double getOTVAmount(int engineType, double batAmount) {
		
		double OTVAmount = 0;
	
		if(engineType<1600 && batAmount<85000) {
			OTVAmount = batAmount * 0.45;
			
		}
		else if(engineType<1600 && batAmount<130000) {
			OTVAmount = batAmount * 0.50;
		}
		else if(engineType<1600) {
			OTVAmount = batAmount * 0.80;
		}	
		else if(engineType<2000 && batAmount<170000) {
			OTVAmount = batAmount * 1.30;
			
		}
		else if(engineType<2000) {
			OTVAmount = batAmount * 1.50;
		}
		else if(engineType>=2000) {
			OTVAmount = batAmount * 2.20;
		}
		
		return OTVAmount;
	}

	private static double getProfiftRatio(int i) {

		switch (i) {
		case 1:
			return 0.60;
		case 2:
			return 0.55;
		case 3:
			return 0.50;
		case 4:
			return 0.45;
		case 5:
			return 0.40;
		case 6:
			return 0.35;
		case 7:
			return 0.30;
		case 8:
			return 0.25;
		case 9:
			return 0.20;
		case 10:
			return 0.15;
		case 11:
			return 0.10;
		case 12:
			return 0.05;
		}

		return 0;
	}

}
